package org.example.controller;

import org.example.entity.ApiResponse;
import org.example.entity.Music;
import org.example.service.MusicApiService;
import org.example.service.MusicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/music")
@CrossOrigin(origins = "*")
public class MusicController {

    private final MusicApiService musicApiService;
    private final MusicService musicService;
    
    public MusicController(MusicApiService musicApiService, MusicService musicService) {
        this.musicApiService = musicApiService;
        this.musicService = musicService;
    }

    /**
     * 搜索音乐
     */
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<Music>>> searchMusic(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "20") Integer size) {
        
        try {
            Map<String, Object> result = musicApiService.searchMusic(keyword, page, size);
            List<Music> musicList = (List<Music>) result.get("data");
            
            ApiResponse<List<Music>> response = ApiResponse.success("搜索成功", musicList);
            response.setTotal(result.get("total"));
            response.setPage(page);
            response.setSize(size);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("搜索失败: " + e.getMessage()));
        }
    }

    /**
     * 获取音乐播放URL
     */
    @GetMapping("/url")
    public ResponseEntity<ApiResponse<Object>> getMusicUrl(
            @RequestParam(required = false) String mid,
            @RequestParam(required = false) String id) {
        
        try {
            Map<String, Object> result = musicApiService.getMusicUrl(mid, id);
            return ResponseEntity.ok(ApiResponse.success("获取成功", result));
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("获取失败: " + e.getMessage()));
        }
    }

    /**
     * 获取搜索建议
     */
    @GetMapping("/suggestions")
    public ResponseEntity<ApiResponse<Object>> getSearchSuggestions(
            @RequestParam String word) {
        
        try {
            Map<String, Object> result = musicApiService.getSearchSuggestions(word);
            return ResponseEntity.ok(ApiResponse.success("获取成功", result));
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("获取失败: " + e.getMessage()));
        }
    }

    /**
     * 获取歌词
     */
    @GetMapping("/lyrics")
    public ResponseEntity<ApiResponse<Object>> getLyrics(
            @RequestParam(required = false) String mid,
            @RequestParam(required = false) String id) {
        
        try {
            Map<String, Object> result = musicApiService.getLyrics(mid, id);
            return ResponseEntity.ok(ApiResponse.success("获取成功", result));
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("获取失败: " + e.getMessage()));
        }
    }

    /**
     * 热门推荐（基于全局统计表）
     */
    @GetMapping("/hot")
    public ResponseEntity<ApiResponse<List<Music>>> getHot(@RequestParam(defaultValue = "20") Integer limit) {
        try {
            List<Music> list = musicService.getHotFromStats(limit);
            return ResponseEntity.ok(ApiResponse.success("获取成功", list));
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("获取失败: " + e.getMessage()));
        }
    }
}
