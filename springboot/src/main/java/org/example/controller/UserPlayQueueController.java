package org.example.controller;

import org.example.entity.ApiResponse;
import org.example.entity.Music;
import org.example.service.UserPlayQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用户播放队列控制器
 */
@RestController
@RequestMapping("/api/user-play-queue")
@CrossOrigin(origins = "*")
public class UserPlayQueueController {

    @Autowired
    private UserPlayQueueService userPlayQueueService;

    /**
     * 获取用户播放队列
     */
    @GetMapping("/user/{userId}")
    public ApiResponse<List<Music>> getUserPlayQueue(@PathVariable Long userId) {
        try {
            List<Music> musicList = userPlayQueueService.getQueueMusicList(userId);
            return ApiResponse.success("获取成功", musicList);
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 添加音乐到播放队列
     */
    @PostMapping("/add")
    public ApiResponse<String> addMusicToQueue(@RequestBody Map<String, Object> request) {
        try {
            Long userId = Long.valueOf(request.get("userId").toString());
            Integer insertIndex = request.get("insertIndex") != null ? 
                Integer.valueOf(request.get("insertIndex").toString()) : null;

            // 构建Music对象
            Music music = new Music();
            music.setId(Long.valueOf(request.get("id").toString()));
            music.setMid(request.get("mid").toString());
            music.setSong(request.get("song").toString());
            music.setSinger(request.get("singer").toString());
            music.setAlbum(request.get("album").toString());
            music.setCover(request.get("cover").toString());
            music.setPlayUrl(request.get("playUrl") != null ? request.get("playUrl").toString() : "");

            boolean success = userPlayQueueService.addMusicToQueue(userId, music, insertIndex);
            if (success) {
                return ApiResponse.success("添加成功", null);
            } else {
                return ApiResponse.error("音乐已存在于播放队列中");
            }
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 从播放队列移除音乐
     */
    @DeleteMapping("/remove")
    public ApiResponse<String> removeMusicFromQueue(@RequestParam Long userId, @RequestParam String musicId) {
        try {
            boolean success = userPlayQueueService.removeMusicFromQueue(userId, musicId);
            if (success) {
                return ApiResponse.success("移除成功", null);
            } else {
                return ApiResponse.error("移除失败");
            }
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 清空播放队列
     */
    @DeleteMapping("/clear/{userId}")
    public ApiResponse<String> clearPlayQueue(@PathVariable Long userId) {
        try {
            boolean success = userPlayQueueService.clearPlayQueue(userId);
            if (success) {
                return ApiResponse.success("清空成功", null);
            } else {
                return ApiResponse.error("清空失败");
            }
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 更新播放队列排序
     */
    @PutMapping("/reorder/{userId}")
    public ApiResponse<String> updateQueueOrder(@PathVariable Long userId, @RequestBody List<Music> musicList) {
        try {
            boolean success = userPlayQueueService.updateQueueOrder(userId, musicList);
            if (success) {
                return ApiResponse.success("排序更新成功", null);
            } else {
                return ApiResponse.error("排序更新失败");
            }
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 检查音乐是否在播放队列中
     */
    @GetMapping("/check")
    public ApiResponse<Map<String, Boolean>> checkMusicInQueue(@RequestParam Long userId, @RequestParam String musicId) {
        try {
            boolean exists = userPlayQueueService.isMusicInQueue(userId, musicId);
            Map<String, Boolean> result = Map.of("exists", exists);
            return ApiResponse.success("检查完成", result);
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }
}
