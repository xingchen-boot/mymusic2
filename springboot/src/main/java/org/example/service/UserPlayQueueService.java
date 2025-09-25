package org.example.service;

import org.example.entity.Music;
import org.example.entity.UserPlayQueue;
import org.example.mapper.UserPlayQueueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户播放队列服务类
 */
@Service
public class UserPlayQueueService {

    @Autowired
    private UserPlayQueueMapper userPlayQueueMapper;

    /**
     * 获取用户的播放队列
     */
    public List<UserPlayQueue> getUserPlayQueue(Long userId) {
        return userPlayQueueMapper.findByUserId(userId);
    }

    /**
     * 添加音乐到播放队列
     */
    public boolean addMusicToQueue(Long userId, Music music, Integer insertIndex) {
        // 检查音乐是否已存在
        if (userPlayQueueMapper.checkMusicInQueue(userId, music.getId().toString()) > 0) {
            return false; // 音乐已存在
        }

        // 获取当前最大排序值
        int maxSortOrder = userPlayQueueMapper.getMaxSortOrder(userId);
        int sortOrder = insertIndex != null ? insertIndex : maxSortOrder + 1;

        UserPlayQueue queueItem = new UserPlayQueue(userId, music, sortOrder);
        return userPlayQueueMapper.insert(queueItem) > 0;
    }

    /**
     * 从播放队列移除音乐
     */
    public boolean removeMusicFromQueue(Long userId, String musicId) {
        return userPlayQueueMapper.deleteByUserIdAndMusicId(userId, musicId) > 0;
    }

    /**
     * 清空播放队列
     */
    public boolean clearPlayQueue(Long userId) {
        return userPlayQueueMapper.clearByUserId(userId) > 0;
    }

    /**
     * 更新播放队列排序
     */
    public boolean updateQueueOrder(Long userId, List<Music> musicList) {
        // 先清空现有队列
        userPlayQueueMapper.clearByUserId(userId);

        // 批量插入新的队列
        List<UserPlayQueue> queueItems = new ArrayList<>();
        for (int i = 0; i < musicList.size(); i++) {
            UserPlayQueue queueItem = new UserPlayQueue(userId, musicList.get(i), i);
            queueItems.add(queueItem);
        }

        if (!queueItems.isEmpty()) {
            return userPlayQueueMapper.batchInsert(queueItems) > 0;
        }
        return true;
    }

    /**
     * 检查音乐是否在播放队列中
     */
    public boolean isMusicInQueue(Long userId, String musicId) {
        return userPlayQueueMapper.checkMusicInQueue(userId, musicId) > 0;
    }

    /**
     * 获取播放队列中的音乐列表（转换为Music对象）
     */
    public List<Music> getQueueMusicList(Long userId) {
        List<UserPlayQueue> queueItems = userPlayQueueMapper.findByUserId(userId);
        List<Music> musicList = new ArrayList<>();

        for (UserPlayQueue item : queueItems) {
            Music music = new Music();
            music.setId(Long.parseLong(item.getMusicId()));
            music.setMid(item.getMusicMid());
            music.setSong(item.getMusicSong());
            music.setSinger(item.getMusicSinger());
            music.setAlbum(item.getMusicAlbum());
            music.setCover(item.getMusicCover());
            music.setPlayUrl(item.getMusicUrl());
            musicList.add(music);
        }

        return musicList;
    }
}
