package org.example.controller;

import org.example.entity.ApiResponse;
import org.example.entity.UserPlaySettings;
import org.example.service.UserPlaySettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户播放设置控制器
 */
@RestController
@RequestMapping("/api/user-play-settings")
@CrossOrigin(origins = "*")
public class UserPlaySettingsController {

    @Autowired
    private UserPlaySettingsService userPlaySettingsService;

    /**
     * 获取用户播放设置
     */
    @GetMapping("/user/{userId}")
    public ApiResponse<UserPlaySettings> getUserPlaySettings(@PathVariable Long userId) {
        try {
            UserPlaySettings settings = userPlaySettingsService.getUserPlaySettings(userId);
            return ApiResponse.success(settings);
        } catch (Exception e) {
            return ApiResponse.error("获取用户播放设置失败: " + e.getMessage());
        }
    }

    /**
     * 保存用户播放设置
     */
    @PostMapping("/save")
    public ApiResponse<Boolean> saveUserPlaySettings(@RequestBody UserPlaySettings settings) {
        try {
            boolean success = userPlaySettingsService.saveUserPlaySettings(settings);
            if (success) {
                return ApiResponse.success(true);
            } else {
                return ApiResponse.error("保存用户播放设置失败");
            }
        } catch (Exception e) {
            return ApiResponse.error("保存用户播放设置失败: " + e.getMessage());
        }
    }

    /**
     * 更新用户音量设置
     */
    @PutMapping("/volume/{userId}")
    public ApiResponse<Boolean> updateUserVolume(@PathVariable Long userId, @RequestParam Integer volume) {
        try {
            boolean success = userPlaySettingsService.updateUserVolume(userId, volume);
            if (success) {
                return ApiResponse.success(true);
            } else {
                return ApiResponse.error("更新用户音量设置失败");
            }
        } catch (Exception e) {
            return ApiResponse.error("更新用户音量设置失败: " + e.getMessage());
        }
    }

    /**
     * 更新用户静音设置
     */
    @PutMapping("/mute/{userId}")
    public ApiResponse<Boolean> updateUserMuteStatus(@PathVariable Long userId, @RequestParam Boolean isMuted) {
        try {
            boolean success = userPlaySettingsService.updateUserMuteStatus(userId, isMuted);
            if (success) {
                return ApiResponse.success(true);
            } else {
                return ApiResponse.error("更新用户静音设置失败");
            }
        } catch (Exception e) {
            return ApiResponse.error("更新用户静音设置失败: " + e.getMessage());
        }
    }

    /**
     * 更新用户播放模式设置
     */
    @PutMapping("/play-mode/{userId}")
    public ApiResponse<Boolean> updateUserPlayMode(@PathVariable Long userId, @RequestParam String playMode) {
        try {
            boolean success = userPlaySettingsService.updateUserPlayMode(userId, playMode);
            if (success) {
                return ApiResponse.success(true);
            } else {
                return ApiResponse.error("更新用户播放模式设置失败");
            }
        } catch (Exception e) {
            return ApiResponse.error("更新用户播放模式设置失败: " + e.getMessage());
        }
    }

    /**
     * 更新用户播放进度
     */
    @PutMapping("/play-progress/{userId}")
    public ApiResponse<Boolean> updateUserPlayProgress(@PathVariable Long userId, 
                                                      @RequestParam Double playProgress,
                                                      @RequestParam Double playTime) {
        try {
            boolean success = userPlaySettingsService.updateUserPlayProgress(userId, playProgress, playTime);
            if (success) {
                return ApiResponse.success(true);
            } else {
                return ApiResponse.error("更新用户播放进度失败");
            }
        } catch (Exception e) {
            return ApiResponse.error("更新用户播放进度失败: " + e.getMessage());
        }
    }

    /**
     * 更新用户当前播放音乐
     */
    @PutMapping("/current-music/{userId}")
    public ApiResponse<Boolean> updateUserCurrentMusic(@PathVariable Long userId,
                                                      @RequestParam String musicId,
                                                      @RequestParam String musicName,
                                                      @RequestParam String musicArtist,
                                                      @RequestParam String musicCover,
                                                      @RequestParam String musicUrl) {
        try {
            boolean success = userPlaySettingsService.updateUserCurrentMusic(userId, musicId, 
                                                                             musicName, musicArtist, 
                                                                             musicCover, musicUrl);
            if (success) {
                return ApiResponse.success(true);
            } else {
                return ApiResponse.error("更新用户当前播放音乐失败");
            }
        } catch (Exception e) {
            return ApiResponse.error("更新用户当前播放音乐失败: " + e.getMessage());
        }
    }

    /**
     * 更新用户播放状态
     */
    @PutMapping("/play-status/{userId}")
    public ApiResponse<Boolean> updateUserPlayStatus(@PathVariable Long userId, @RequestParam Boolean isPlaying) {
        try {
            boolean success = userPlaySettingsService.updateUserPlayStatus(userId, isPlaying);
            if (success) {
                return ApiResponse.success(true);
            } else {
                return ApiResponse.error("更新用户播放状态失败");
            }
        } catch (Exception e) {
            return ApiResponse.error("更新用户播放状态失败: " + e.getMessage());
        }
    }
}
