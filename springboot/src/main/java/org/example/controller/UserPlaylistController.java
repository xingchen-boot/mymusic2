package org.example.controller;

import org.example.entity.ApiResponse;
import org.example.entity.UserPlaylist;
import org.example.entity.PlaylistMusic;
import org.example.service.UserPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户播放列表控制器
 */
@RestController
@RequestMapping("/api/user-playlist")
@CrossOrigin(origins = "*")
public class UserPlaylistController {

    @Autowired
    private UserPlaylistService userPlaylistService;

    /**
     * 获取用户的播放列表
     */
    @GetMapping("/user/{userId}")
    public ApiResponse<List<UserPlaylist>> getUserPlaylists(@PathVariable Long userId) {
        try {
            List<UserPlaylist> playlists = userPlaylistService.getUserPlaylists(userId);
            return ApiResponse.success("获取成功", playlists);
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 根据ID获取播放列表详情
     */
    @GetMapping("/{id}")
    public ApiResponse<UserPlaylist> getPlaylistById(@PathVariable Long id) {
        try {
            UserPlaylist playlist = userPlaylistService.getPlaylistById(id);
            if (playlist == null) {
                return ApiResponse.error("播放列表不存在");
            }
            return ApiResponse.success("获取成功", playlist);
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 创建播放列表
     */
    @PostMapping("/create")
    public ApiResponse<UserPlaylist> createPlaylist(@RequestBody Map<String, Object> request) {
        try {
            Long userId = Long.valueOf(request.get("userId").toString());
            String name = request.get("name").toString();
            String description = request.get("description") != null ? request.get("description").toString() : "";

            UserPlaylist playlist = userPlaylistService.createPlaylist(userId, name, description);
            return ApiResponse.success("创建成功", playlist);
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 更新播放列表
     */
    @PutMapping("/{id}")
    public ApiResponse<String> updatePlaylist(@PathVariable Long id, @RequestBody Map<String, String> request) {
        try {
            String name = request.get("name");
            String description = request.get("description");
            String coverUrl = request.get("coverUrl");

            boolean success = userPlaylistService.updatePlaylist(id, name, description, coverUrl);
            if (success) {
                return ApiResponse.success("更新成功", null);
            } else {
                return ApiResponse.error("更新失败");
            }
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 删除播放列表
     */
    @DeleteMapping("/{id}")
    public ApiResponse<String> deletePlaylist(@PathVariable Long id) {
        try {
            boolean success = userPlaylistService.deletePlaylist(id);
            if (success) {
                return ApiResponse.success("删除成功", null);
            } else {
                return ApiResponse.error("删除失败");
            }
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 添加音乐到播放列表
     */
    @PostMapping("/{playlistId}/music")
    public ApiResponse<String> addMusicToPlaylist(@PathVariable Long playlistId, @RequestBody PlaylistMusic music) {
        try {
            boolean success = userPlaylistService.addMusicToPlaylist(playlistId, music);
            if (success) {
                return ApiResponse.success("添加成功", null);
            } else {
                return ApiResponse.error("添加失败");
            }
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 从播放列表移除音乐
     */
    @DeleteMapping("/{playlistId}/music/{musicId}")
    public ApiResponse<String> removeMusicFromPlaylist(@PathVariable Long playlistId, @PathVariable String musicId) {
        try {
            boolean success = userPlaylistService.removeMusicFromPlaylist(playlistId, musicId);
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
     * 获取播放列表中的音乐
     */
    @GetMapping("/{playlistId}/music")
    public ApiResponse<List<PlaylistMusic>> getPlaylistMusic(@PathVariable Long playlistId) {
        try {
            List<PlaylistMusic> musicList = userPlaylistService.getPlaylistMusic(playlistId);
            return ApiResponse.success("获取成功", musicList);
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 更新音乐排序
     */
    @PutMapping("/music/{musicId}/sort")
    public ApiResponse<String> updateMusicSort(@PathVariable Long musicId, @RequestBody Map<String, Integer> request) {
        try {
            Integer sortOrder = request.get("sortOrder");
            boolean success = userPlaylistService.updateMusicSort(musicId, sortOrder);
            if (success) {
                return ApiResponse.success("更新成功", null);
            } else {
                return ApiResponse.error("更新失败");
            }
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 清空播放列表
     */
    @DeleteMapping("/{playlistId}/clear")
    public ApiResponse<String> clearPlaylist(@PathVariable Long playlistId) {
        try {
            boolean success = userPlaylistService.clearPlaylist(playlistId);
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
     * 检查音乐是否在播放列表中
     */
    @GetMapping("/{playlistId}/check/{musicId}")
    public ApiResponse<Map<String, Boolean>> checkMusicInPlaylist(@PathVariable Long playlistId, @PathVariable String musicId) {
        try {
            boolean exists = userPlaylistService.isMusicInPlaylist(playlistId, musicId);
            Map<String, Boolean> result = new HashMap<>();
            result.put("exists", exists);
            return ApiResponse.success("检查完成", result);
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }
}

