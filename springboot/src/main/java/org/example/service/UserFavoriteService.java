package org.example.service;

import org.example.entity.UserFavorite;
import org.example.mapper.MusicFavoriteStatsMapper;
import org.example.mapper.UserFavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户收藏音乐服务类
 */
@Service
public class UserFavoriteService {

    @Autowired
    private UserFavoriteMapper userFavoriteMapper;

    @Autowired
    private MusicFavoriteStatsMapper musicFavoriteStatsMapper;

    // rollback: remove stats mapper

    /**
     * 获取用户收藏列表
     */
    public List<UserFavorite> getUserFavorites(Long userId) {
        return userFavoriteMapper.findByUserId(userId);
    }

    /**
     * 添加收藏
     */
    public boolean addFavorite(Long userId, String musicId, String musicMid, String musicSong,
                              String musicSinger, String musicAlbum, String musicCover,
                              String musicTime, String musicPay) {
        try {
            // 检查是否已经收藏
            if (userFavoriteMapper.checkFavorite(userId, musicId) > 0) {
                System.out.println("音乐已收藏，无需重复添加");
                return true;
            }

            UserFavorite userFavorite = new UserFavorite(userId, musicId, musicMid, musicSong,
                    musicSinger, musicAlbum, musicCover, musicTime, musicPay);
            
            int result = userFavoriteMapper.insert(userFavorite);
            if (result > 0) {
                // 统计表：若不存在则插入并计数为1，存在则+1
                musicFavoriteStatsMapper.incrementFavorite(
                        musicId,
                        musicSong,
                        musicSinger,
                        musicAlbum,
                        musicCover
                );
                return true;
            }
            return false;
        } catch (Exception e) {
            System.err.println("添加收藏失败: " + e.getMessage());
            return false;
        }
    }

    /**
     * 删除收藏
     */
    public boolean removeFavorite(Long userId, String musicId) {
        try {
            int result = userFavoriteMapper.deleteByUserIdAndMusicId(userId, musicId);
            if (result > 0) {
                // 统计表：计数-1（不小于0）
                musicFavoriteStatsMapper.decrementFavorite(musicId);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.err.println("删除收藏失败: " + e.getMessage());
            return false;
        }
    }

    // no-op

    /**
     * 检查是否已收藏
     */
    public boolean isFavorite(Long userId, String musicId) {
        try {
            return userFavoriteMapper.checkFavorite(userId, musicId) > 0;
        } catch (Exception e) {
            System.err.println("检查收藏状态失败: " + e.getMessage());
            return false;
        }
    }

    /**
     * 获取用户收藏数量
     */
    public int getFavoriteCount(Long userId) {
        try {
            return userFavoriteMapper.getFavoriteCount(userId);
        } catch (Exception e) {
            System.err.println("获取收藏数量失败: " + e.getMessage());
            return 0;
        }
    }
}
