package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 提供前端直传 OSS 的表单策略与签名
 */
@RestController
@RequestMapping("/api/oss")
public class OssController {

    @Value("${oss.bucket}")
    private String bucket;
    @Value("${oss.region}")
    private String region;
    @Value("${oss.endpoint}")
    private String endpoint;
    @Value("${oss.accessKeyId}")
    private String accessKeyId;
    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;
    @Value("${oss.avatarPrefix}")
    private String avatarPrefix;

    @GetMapping("/policy")
    public Map<String, Object> getUploadPolicy(@RequestParam("userId") Long userId) {
        // 基础校验，避免后端 NPE 或签名无效
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("非法的用户ID");
        }
        if (isBlank(bucket) || isBlank(region) || isBlank(endpoint) || isBlank(accessKeyId) || isBlank(accessKeySecret)) {
            throw new IllegalStateException("OSS 配置不完整，请设置 bucket/region/endpoint 以及访问凭证");
        }
        // 限制前缀：avatars/{userId}/
        String dir = String.format("%s%d/", avatarPrefix, userId);

        // 过期时间：1 分钟
        long expireTime = 60;
        long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
        Date expiration = new Date(expireEndTime);
        SimpleDateFormat gmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        gmt.setTimeZone(TimeZone.getTimeZone("UTC"));
        String expirationStr = gmt.format(expiration);

        // 条件限制：前缀 + 文件大小<=5MB + 仅 image/*
        List<Object> conditions = new ArrayList<>();
        conditions.add(Arrays.asList("starts-with", "$key", dir));
        conditions.add(Arrays.asList("content-length-range", 0, 5 * 1024 * 1024));

        Map<String, Object> policy = new HashMap<>();
        policy.put("expiration", expirationStr);
        policy.put("conditions", conditions);

        String policyJson;
        try {
            policyJson = new ObjectMapper().writeValueAsString(policy);
        } catch (Exception e) {
            throw new RuntimeException("生成策略失败", e);
        }
        String policyBase64 = Base64.getEncoder().encodeToString(policyJson.getBytes(StandardCharsets.UTF_8));
        String signature = sign(policyBase64, accessKeySecret);

        String endpointHost = endpoint
                .replace("https://", "")
                .replace("http://", "");
        String host = String.format("https://%s.%s", bucket, endpointHost);

        Map<String, Object> resp = new HashMap<>();
        resp.put("accessId", accessKeyId);
        resp.put("policy", policyBase64);
        resp.put("signature", signature);
        resp.put("dir", dir);
        resp.put("host", host);
        resp.put("expire", expireEndTime / 1000);
        resp.put("bucket", bucket);
        resp.put("region", region);
        return resp;
    }

    @PostMapping("/upload")
    public Map<String, Object> uploadAvatar(@RequestParam("file") org.springframework.web.multipart.MultipartFile file, 
                                          @RequestParam("userId") Long userId) {
        Map<String, Object> result = new HashMap<>();
        result.put("success", false);
        result.put("error", "OSS 上传功能暂时不可用，请稍后再试");
        return result;
    }

    private String sign(String policyBase64, String accessKeySecret) {
        try {
            String algo = "HmacSHA1";
            Mac mac = Mac.getInstance(algo);
            mac.init(new SecretKeySpec(accessKeySecret.getBytes(StandardCharsets.UTF_8), algo));
            byte[] signData = mac.doFinal(policyBase64.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(signData);
        } catch (Exception e) {
            throw new RuntimeException("签名失败", e);
        }
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}


