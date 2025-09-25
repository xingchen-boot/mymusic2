package org.example.controller;

import org.example.entity.ApiResponse;
import org.example.entity.Music;
import org.example.entity.Playlist;
import org.example.entity.PlaylistMusic;
import org.example.service.PlaylistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 播放列表控制器
 */
@RestController
@RequestMapping("/api/playlist")
@CrossOrigin(origins = "*")
public class PlaylistController {

    private final PlaylistService playlistService;
    
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }
    
    /**
     * 创建播放列表
     */
    @PostMapping
    public ResponseEntity<ApiResponse<Playlist>> createPlaylist(@RequestBody Map<String, String> request) {
        try {
            String name = request.get("name");
            String description = request.get("description");
            
            if (name == null || name.trim().isEmpty()) {
                return ResponseEntity.ok(ApiResponse.error("播放列表名称不能为空"));
            }
            
            Playlist playlist = playlistService.createPlaylist(name, description);
            return ResponseEntity.ok(ApiResponse.success("创建成功", playlist));
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("创建失败: " + e.getMessage()));
        }
    }
    
    /**
     * 获取所有播放列表
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<Playlist>>> getAllPlaylists() {
        try {
            List<Playlist> playlists = playlistService.getAllPlaylists();
            return ResponseEntity.ok(ApiResponse.success("获取成功", playlists));
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("获取失败: " + e.getMessage()));
        }
    }
    
    /**
     * 根据ID获取播放列表详情
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Playlist>> getPlaylistById(@PathVariable Long id) {
        try {
            Playlist playlist = playlistService.getPlaylistById(id);
            if (playlist == null) {
                return ResponseEntity.ok(ApiResponse.error("播放列表不存在"));
            }
            return ResponseEntity.ok(ApiResponse.success("获取成功", playlist));
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("获取失败: " + e.getMessage()));
        }
    }
    
    /**
     * 更新播放列表
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> updatePlaylist(@PathVariable Long id, @RequestBody Playlist playlist) {
        try {
            playlist.setId(id);
            boolean success = playlistService.updatePlaylist(playlist);
            if (success) {
                return ResponseEntity.ok(ApiResponse.success("更新成功", null));
            } else {
                return ResponseEntity.ok(ApiResponse.error("更新失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("更新失败: " + e.getMessage()));
        }
    }
    
    /**
     * 删除播放列表
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deletePlaylist(@PathVariable Long id) {
        try {
            boolean success = playlistService.deletePlaylist(id);
            if (success) {
                return ResponseEntity.ok(ApiResponse.success("删除成功", null));
            } else {
                return ResponseEntity.ok(ApiResponse.error("删除失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("删除失败: " + e.getMessage()));
        }
    }
    
    /**
     * 添加音乐到播放列表
     */
    @PostMapping("/{playlistId}/music")
    public ResponseEntity<ApiResponse<Object>> addMusicToPlaylist(@PathVariable Long playlistId, @RequestBody Music music) {
        try {
            boolean success = playlistService.addMusicToPlaylist(playlistId, music);
            if (success) {
                return ResponseEntity.ok(ApiResponse.success("添加成功", null));
            } else {
                return ResponseEntity.ok(ApiResponse.error("音乐已存在或添加失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("添加失败: " + e.getMessage()));
        }
    }
    
    /**
     * 从播放列表移除音乐
     */
    @DeleteMapping("/{playlistId}/music/{musicId}")
    public ResponseEntity<ApiResponse<Object>> removeMusicFromPlaylist(@PathVariable Long playlistId, @PathVariable Long musicId) {
        try {
            boolean success = playlistService.removeMusicFromPlaylist(playlistId, musicId);
            if (success) {
                return ResponseEntity.ok(ApiResponse.success("移除成功", null));
            } else {
                return ResponseEntity.ok(ApiResponse.error("移除失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("移除失败: " + e.getMessage()));
        }
    }
    
    /**
     * 获取播放列表中的音乐
     */
    @GetMapping("/{playlistId}/music")
    public ResponseEntity<ApiResponse<List<PlaylistMusic>>> getPlaylistMusic(@PathVariable Long playlistId) {
        try {
            List<PlaylistMusic> musicList = playlistService.getPlaylistMusic(playlistId);
            return ResponseEntity.ok(ApiResponse.success("获取成功", musicList));
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("获取失败: " + e.getMessage()));
        }
    }
    
    /**
     * 检查音乐是否在播放列表中
     */
    @GetMapping("/{playlistId}/music/{musicId}/exists")
    public ResponseEntity<ApiResponse<Boolean>> checkMusicInPlaylist(@PathVariable Long playlistId, @PathVariable Long musicId) {
        try {
            boolean exists = playlistService.isMusicInPlaylist(playlistId, musicId);
            return ResponseEntity.ok(ApiResponse.success("检查完成", exists));
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error("检查失败: " + e.getMessage()));
        }
    }
}
