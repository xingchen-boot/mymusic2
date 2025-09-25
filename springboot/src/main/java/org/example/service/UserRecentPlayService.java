package org.example.service;

import org.example.entity.UserRecentPlay;
import org.example.mapper.UserRecentPlayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户最近播放服务类
 */
@Service
public class UserRecentPlayService {

    @Autowired
    private UserRecentPlayMapper userRecentPlayMapper;

    private static final int MAX_RECENT_PLAYS = 100; // 最多保留100条最近播放记录

    /**
     * 记录用户播放音乐
     */
    public void recordPlay(Long userId, String musicId, String musicMid, String musicSong, 
                          String musicSinger, String musicAlbum, String musicCover, 
                          String musicTime, String musicPay, Integer playDuration, BigDecimal playProgress) {
        try {
            UserRecentPlay recentPlay = new UserRecentPlay(
                userId, musicId, musicMid, musicSong, musicSinger, musicAlbum, 
                musicCover, musicTime, musicPay, playDuration, playProgress
            );
            
            // 插入或更新记录
            userRecentPlayMapper.insertOrUpdate(recentPlay);
            
            // 检查是否需要删除旧记录
            int totalCount = userRecentPlayMapper.countByUserId(userId);
            if (totalCount > MAX_RECENT_PLAYS) {
                userRecentPlayMapper.deleteOldRecords(userId, MAX_RECENT_PLAYS);
            }
        } catch (Exception e) {
            System.err.println("记录最近播放失败: " + e.getMessage());
            // 不抛出异常，避免影响播放功能
        }
    }

    /**
     * 更新播放进度
     */
    public void updatePlayProgress(Long userId, String musicId, Integer playDuration, BigDecimal playProgress) {
        try {
            userRecentPlayMapper.updatePlayProgress(userId, musicId, playDuration, playProgress);
        } catch (Exception e) {
            System.err.println("更新播放进度失败: " + e.getMessage());
        }
    }

    /**
     * 获取用户最近播放列表
     */
    public List<UserRecentPlay> getRecentPlays(Long userId, Integer limit) {
        if (limit == null || limit <= 0) {
            limit = 50; // 默认返回50条
        }
        return userRecentPlayMapper.findByUserIdOrderByPlayTimeDesc(userId, limit);
    }

    /**
     * 获取用户最近播放列表（默认50条）
     */
    public List<UserRecentPlay> getRecentPlays(Long userId) {
        return getRecentPlays(userId, 50);
    }

    /**
     * 检查音乐是否在最近播放中
     */
    public boolean isInRecentPlays(Long userId, String musicId) {
        UserRecentPlay recentPlay = userRecentPlayMapper.findByUserIdAndMusicId(userId, musicId);
        return recentPlay != null;
    }

    /**
     * 从最近播放中移除音乐
     */
    public boolean removeFromRecentPlays(Long userId, String musicId) {
        try {
            int result = userRecentPlayMapper.deleteByUserIdAndMusicId(userId, musicId);
            return result > 0;
        } catch (Exception e) {
            System.err.println("从最近播放移除失败: " + e.getMessage());
            return false;
        }
    }

    /**
     * 清空用户最近播放记录
     */
    public boolean clearRecentPlays(Long userId) {
        try {
            int result = userRecentPlayMapper.deleteByUserId(userId);
            return result >= 0; // 即使没有记录也返回true
        } catch (Exception e) {
            System.err.println("清空最近播放失败: " + e.getMessage());
            return false;
        }
    }

    /**
     * 获取用户最近播放数量
     */
    public int getRecentPlaysCount(Long userId) {
        return userRecentPlayMapper.countByUserId(userId);
    }
}
