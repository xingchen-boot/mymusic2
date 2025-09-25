package org.example.service;

import org.example.entity.UserPlaySettings;
import org.example.mapper.UserPlaySettingsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户播放设置服务类
 */
@Service
public class UserPlaySettingsService {

    @Autowired
    private UserPlaySettingsMapper userPlaySettingsMapper;

    /**
     * 获取用户播放设置
     */
    public UserPlaySettings getUserPlaySettings(Long userId) {
        UserPlaySettings settings = userPlaySettingsMapper.findByUserId(userId);
        
        // 如果用户没有设置，返回默认设置
        if (settings == null) {
            settings = new UserPlaySettings(userId, 70, false, "list");
            settings.setCurrentMusicId(null);
            settings.setCurrentMusicName(null);
            settings.setCurrentMusicArtist(null);
            settings.setCurrentMusicCover(null);
            settings.setCurrentMusicUrl(null);
            settings.setPlayProgress(0.0);
            settings.setPlayTime(0.0);
            settings.setIsPlaying(false);
        }
        
        return settings;
    }

    /**
     * 保存用户播放设置
     */
    public boolean saveUserPlaySettings(UserPlaySettings settings) {
        try {
            int result = userPlaySettingsMapper.insertOrUpdate(settings);
            return result > 0;
        } catch (Exception e) {
            System.err.println("保存用户播放设置失败: " + e.getMessage());
            return false;
        }
    }

    /**
     * 更新用户音量设置
     */
    public boolean updateUserVolume(Long userId, Integer volume) {
        try {
            UserPlaySettings settings = getUserPlaySettings(userId);
            settings.setVolume(volume);
            return saveUserPlaySettings(settings);
        } catch (Exception e) {
            System.err.println("更新用户音量设置失败: " + e.getMessage());
            return false;
        }
    }

    /**
     * 更新用户静音设置
     */
    public boolean updateUserMuteStatus(Long userId, Boolean isMuted) {
        try {
            UserPlaySettings settings = getUserPlaySettings(userId);
            settings.setIsMuted(isMuted);
            return saveUserPlaySettings(settings);
        } catch (Exception e) {
            System.err.println("更新用户静音设置失败: " + e.getMessage());
            return false;
        }
    }

    /**
     * 更新用户播放模式设置
     */
    public boolean updateUserPlayMode(Long userId, String playMode) {
        try {
            UserPlaySettings settings = getUserPlaySettings(userId);
            settings.setPlayMode(playMode);
            return saveUserPlaySettings(settings);
        } catch (Exception e) {
            System.err.println("更新用户播放模式设置失败: " + e.getMessage());
            return false;
        }
    }

    /**
     * 更新用户播放进度
     */
    public boolean updateUserPlayProgress(Long userId, Double playProgress, Double playTime) {
        try {
            UserPlaySettings settings = getUserPlaySettings(userId);
            settings.setPlayProgress(playProgress);
            settings.setPlayTime(playTime);
            return saveUserPlaySettings(settings);
        } catch (Exception e) {
            System.err.println("更新用户播放进度失败: " + e.getMessage());
            return false;
        }
    }

    /**
     * 更新用户当前播放音乐
     */
    public boolean updateUserCurrentMusic(Long userId, String musicId, String musicName, 
                                        String musicArtist, String musicCover, String musicUrl) {
        try {
            UserPlaySettings settings = getUserPlaySettings(userId);
            settings.setCurrentMusicId(musicId);
            settings.setCurrentMusicName(musicName);
            settings.setCurrentMusicArtist(musicArtist);
            settings.setCurrentMusicCover(musicCover);
            settings.setCurrentMusicUrl(musicUrl);
            settings.setPlayProgress(0.0);
            settings.setPlayTime(0.0);
            return saveUserPlaySettings(settings);
        } catch (Exception e) {
            System.err.println("更新用户当前播放音乐失败: " + e.getMessage());
            return false;
        }
    }

    /**
     * 更新用户播放状态
     */
    public boolean updateUserPlayStatus(Long userId, Boolean isPlaying) {
        try {
            UserPlaySettings settings = getUserPlaySettings(userId);
            settings.setIsPlaying(isPlaying);
            return saveUserPlaySettings(settings);
        } catch (Exception e) {
            System.err.println("更新用户播放状态失败: " + e.getMessage());
            return false;
        }
    }
}
