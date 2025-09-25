package org.example.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.example.entity.Music;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MusicApiService {

    private static final String API_BASE_URL = "https://api.vkeys.cn";
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 搜索音乐
     */
    public Map<String, Object> searchMusic(String keyword, Integer page, Integer size) throws Exception {
        String encodedKeyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8.toString());
        String urlString = API_BASE_URL + "/v2/music/tencent?word=" + encodedKeyword + "&page=" + page + "&num=" + size;
        
        System.out.println("调用外部API: " + urlString);
        
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // 设置请求头
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
        connection.setRequestProperty("Accept", "application/json");
        connection.setConnectTimeout(10000);
        connection.setReadTimeout(30000);
        
        // 读取响应
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        
        String responseString = response.toString();
        System.out.println("API响应: " + responseString);
        
        if (responseString == null || responseString.trim().isEmpty()) {
            throw new Exception("外部API返回空响应");
        }
        
        JsonNode jsonNode = objectMapper.readTree(responseString);
        
        if (jsonNode.get("code").asInt() != 200) {
            throw new Exception("API调用失败: " + jsonNode.get("message").asText());
        }
        
        // 将JSON数据转换为Music实体列表
        List<Music> musicList = objectMapper.readValue(
            jsonNode.get("data").toString(), 
            new TypeReference<List<Music>>() {}
        );
        
        Map<String, Object> result = new HashMap<>();
        result.put("data", musicList);
        result.put("total", musicList.size());
        
        return result;
    }

    /**
     * 获取音乐播放URL
     */
    public Map<String, Object> getMusicUrl(String mid, String id) throws Exception {
        String urlString = API_BASE_URL + "/v2/music/tencent/geturl";
        if (mid != null && !mid.isEmpty()) {
            urlString += "?mid=" + mid;
        } else if (id != null && !id.isEmpty()) {
            urlString += "?id=" + id;
        } else {
            throw new Exception("mid或id参数不能为空");
        }
        
        System.out.println("获取播放URL: " + urlString);
        
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        
        String responseString = response.toString();
        System.out.println("播放URL响应: " + responseString);
        
        JsonNode jsonNode = objectMapper.readTree(responseString);
        
        if (jsonNode.get("code").asInt() != 200) {
            throw new Exception("获取播放URL失败: " + jsonNode.get("message").asText());
        }
        
        Map<String, Object> result = new HashMap<>();
        
        // 检查data字段是否存在
        JsonNode dataNode = jsonNode.get("data");
        if (dataNode != null) {
            // 检查url字段是否存在
            JsonNode urlNode = dataNode.get("url");
            if (urlNode != null) {
                result.put("url", urlNode.asText());
            } else {
                // 如果没有url字段，可能直接返回的是URL字符串
                result.put("url", dataNode.asText());
            }
            
            // 检查format字段是否存在
            JsonNode formatNode = dataNode.get("format");
            if (formatNode != null) {
                result.put("format", formatNode.asText());
            } else {
                result.put("format", "mp3"); // 默认格式
            }
        } else {
            throw new Exception("API响应中缺少data字段");
        }
        
        return result;
    }

    /**
     * 获取搜索建议
     */
    public Map<String, Object> getSearchSuggestions(String word) throws Exception {
        String urlString = API_BASE_URL + "/v2/music/tencent/search/smartbox";
        if (word != null && !word.isEmpty()) {
            urlString += "?word=" + URLEncoder.encode(word, StandardCharsets.UTF_8);
        } else {
            throw new Exception("搜索词不能为空");
        }
        
        System.out.println("获取搜索建议: " + urlString);
        
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        
        String responseString = response.toString();
        System.out.println("搜索建议响应: " + responseString);
        
        JsonNode jsonNode = objectMapper.readTree(responseString);
        
        if (jsonNode.get("code").asInt() != 200) {
            String errorMessage = jsonNode.get("message") != null ? jsonNode.get("message").asText() : "未知错误";
            System.out.println("搜索建议API错误: " + errorMessage);
            throw new Exception("获取搜索建议失败: " + errorMessage);
        }
        
        // 检查data字段是否存在
        JsonNode dataNode = jsonNode.get("data");
        if (dataNode != null) {
            // 直接返回完整的搜索建议数据
            Map<String, Object> result = new HashMap<>();
            result.put("song", dataNode.get("song") != null ? dataNode.get("song") : null);
            result.put("singer", dataNode.get("singer") != null ? dataNode.get("singer") : null);
            result.put("album", dataNode.get("album") != null ? dataNode.get("album") : null);
            result.put("mv", dataNode.get("mv") != null ? dataNode.get("mv") : null);
            return result;
        } else {
            throw new Exception("API响应中缺少data字段");
        }
    }

    /**
     * 获取歌词
     */
    public Map<String, Object> getLyrics(String mid, String id) throws Exception {
        String urlString = API_BASE_URL + "/v2/music/tencent/lyric";
        // 优先使用id参数，因为id是数字类型，mid是字符串类型
        if (id != null && !id.isEmpty()) {
            urlString += "?id=" + id;
        } else if (mid != null && !mid.isEmpty()) {
            urlString += "?mid=" + mid;
        } else {
            throw new Exception("mid或id参数不能为空");
        }
        
        System.out.println("获取歌词: " + urlString);
        
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        
        String responseString = response.toString();
        System.out.println("歌词响应: " + responseString);
        
        JsonNode jsonNode = objectMapper.readTree(responseString);
        
        if (jsonNode.get("code").asInt() != 200) {
            String errorMessage = jsonNode.get("message") != null ? jsonNode.get("message").asText() : "未知错误";
            System.out.println("歌词API错误: " + errorMessage);
            throw new Exception("获取歌词失败: " + errorMessage);
        }
        
        // 检查data字段是否存在
        JsonNode dataNode = jsonNode.get("data");
        if (dataNode != null) {
            // 直接返回完整的歌词数据，包含lrc、trans、yrc、roma等字段
            Map<String, Object> result = new HashMap<>();
            result.put("lrc", dataNode.get("lrc") != null ? dataNode.get("lrc").asText() : "");
            result.put("trans", dataNode.get("trans") != null ? dataNode.get("trans").asText() : "");
            result.put("yrc", dataNode.get("yrc") != null ? dataNode.get("yrc").asText() : "");
            result.put("roma", dataNode.get("roma") != null ? dataNode.get("roma").asText() : "");
            return result;
        } else {
            throw new Exception("API响应中缺少data字段");
        }
    }
}
