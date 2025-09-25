package org.example.controller;

import org.example.entity.ApiResponse;
import org.example.entity.UserRecentPlay;
import org.example.service.UserRecentPlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户最近播放控制器
 */
@RestController
@RequestMapping("/api/recent-play")
@CrossOrigin(origins = "*")
public class UserRecentPlayController {

    @Autowired
    private UserRecentPlayService userRecentPlayService;

    /**
     * 记录用户播放音乐
     */
    @PostMapping("/record")
    public ResponseEntity<ApiResponse<Object>> recordPlay(@RequestBody RecordPlayRequest request) {
        try {
            userRecentPlayService.recordPlay(
                request.getUserId(),
                request.getMusicId(),
                request.getMusicMid(),
                request.getMusicSong(),
                request.getMusicSinger(),
                request.getMusicAlbum(),
                request.getMusicCover(),
                request.getMusicTime(),
                request.getMusicPay(),
                request.getPlayDuration(),
                request.getPlayProgress()
            );
            return ResponseEntity.ok(ApiResponse.success("记录播放成功"));
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("记录播放失败: " + e.getMessage()));
        }
    }

    /**
     * 更新播放进度
     */
    @PutMapping("/progress")
    public ResponseEntity<ApiResponse<Object>> updatePlayProgress(@RequestBody UpdateProgressRequest request) {
        try {
            userRecentPlayService.updatePlayProgress(
                request.getUserId(),
                request.getMusicId(),
                request.getPlayDuration(),
                request.getPlayProgress()
            );
            return ResponseEntity.ok(ApiResponse.success("更新进度成功"));
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("更新进度失败: " + e.getMessage()));
        }
    }

    /**
     * 获取用户最近播放列表
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<UserRecentPlay>>> getRecentPlays(
            @PathVariable Long userId,
            @RequestParam(required = false) Integer limit) {
        try {
            List<UserRecentPlay> recentPlays = userRecentPlayService.getRecentPlays(userId, limit);
            return ResponseEntity.ok(ApiResponse.success("获取成功", recentPlays));
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("获取失败: " + e.getMessage()));
        }
    }

    /**
     * 检查音乐是否在最近播放中
     */
    @GetMapping("/user/{userId}/check/{musicId}")
    public ResponseEntity<ApiResponse<Boolean>> checkInRecentPlays(
            @PathVariable Long userId,
            @PathVariable String musicId) {
        try {
            boolean isInRecentPlays = userRecentPlayService.isInRecentPlays(userId, musicId);
            return ResponseEntity.ok(ApiResponse.success("检查成功", isInRecentPlays));
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("检查失败: " + e.getMessage()));
        }
    }

    /**
     * 从最近播放中移除音乐
     */
    @DeleteMapping("/user/{userId}/music/{musicId}")
    public ResponseEntity<ApiResponse<Object>> removeFromRecentPlays(
            @PathVariable Long userId,
            @PathVariable String musicId) {
        try {
            boolean success = userRecentPlayService.removeFromRecentPlays(userId, musicId);
            if (success) {
                return ResponseEntity.ok(ApiResponse.success("移除成功"));
            } else {
                return ResponseEntity.ok(ApiResponse.error("移除失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("移除失败: " + e.getMessage()));
        }
    }

    /**
     * 清空用户最近播放记录
     */
    @DeleteMapping("/user/{userId}/clear")
    public ResponseEntity<ApiResponse<Object>> clearRecentPlays(@PathVariable Long userId) {
        try {
            boolean success = userRecentPlayService.clearRecentPlays(userId);
            if (success) {
                return ResponseEntity.ok(ApiResponse.success("清空成功"));
            } else {
                return ResponseEntity.ok(ApiResponse.error("清空失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("清空失败: " + e.getMessage()));
        }
    }

    /**
     * 获取用户最近播放数量
     */
    @GetMapping("/user/{userId}/count")
    public ResponseEntity<ApiResponse<Integer>> getRecentPlaysCount(@PathVariable Long userId) {
        try {
            int count = userRecentPlayService.getRecentPlaysCount(userId);
            return ResponseEntity.ok(ApiResponse.success("获取成功", count));
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("获取失败: " + e.getMessage()));
        }
    }

    // 内部请求类
    public static class RecordPlayRequest {
        private Long userId;
        private String musicId;
        private String musicMid;
        private String musicSong;
        private String musicSinger;
        private String musicAlbum;
        private String musicCover;
        private String musicTime;
        private String musicPay;
        private Integer playDuration;
        private BigDecimal playProgress;

        // Getters and Setters
        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }
        public String getMusicId() { return musicId; }
        public void setMusicId(String musicId) { this.musicId = musicId; }
        public String getMusicMid() { return musicMid; }
        public void setMusicMid(String musicMid) { this.musicMid = musicMid; }
        public String getMusicSong() { return musicSong; }
        public void setMusicSong(String musicSong) { this.musicSong = musicSong; }
        public String getMusicSinger() { return musicSinger; }
        public void setMusicSinger(String musicSinger) { this.musicSinger = musicSinger; }
        public String getMusicAlbum() { return musicAlbum; }
        public void setMusicAlbum(String musicAlbum) { this.musicAlbum = musicAlbum; }
        public String getMusicCover() { return musicCover; }
        public void setMusicCover(String musicCover) { this.musicCover = musicCover; }
        public String getMusicTime() { return musicTime; }
        public void setMusicTime(String musicTime) { this.musicTime = musicTime; }
        public String getMusicPay() { return musicPay; }
        public void setMusicPay(String musicPay) { this.musicPay = musicPay; }
        public Integer getPlayDuration() { return playDuration; }
        public void setPlayDuration(Integer playDuration) { this.playDuration = playDuration; }
        public BigDecimal getPlayProgress() { return playProgress; }
        public void setPlayProgress(BigDecimal playProgress) { this.playProgress = playProgress; }
    }

    public static class UpdateProgressRequest {
        private Long userId;
        private String musicId;
        private Integer playDuration;
        private BigDecimal playProgress;

        // Getters and Setters
        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }
        public String getMusicId() { return musicId; }
        public void setMusicId(String musicId) { this.musicId = musicId; }
        public Integer getPlayDuration() { return playDuration; }
        public void setPlayDuration(Integer playDuration) { this.playDuration = playDuration; }
        public BigDecimal getPlayProgress() { return playProgress; }
        public void setPlayProgress(BigDecimal playProgress) { this.playProgress = playProgress; }
    }
}
