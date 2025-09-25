package org.example.service;

import org.example.entity.UserPlaylist;
import org.example.entity.PlaylistMusic;
import org.example.mapper.UserPlaylistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户播放列表服务类
 */
@Service
public class UserPlaylistService {

    @Autowired
    private UserPlaylistMapper userPlaylistMapper;

    /**
     * 获取用户的播放列表
     */
    public List<UserPlaylist> getUserPlaylists(Long userId) {
        return userPlaylistMapper.findByUserId(userId);
    }

    /**
     * 根据ID获取播放列表
     */
    public UserPlaylist getPlaylistById(Long id) {
        UserPlaylist playlist = userPlaylistMapper.findById(id);
        if (playlist != null) {
            // 加载播放列表中的音乐
            List<PlaylistMusic> musicList = userPlaylistMapper.findMusicByPlaylistId(id);
            playlist.setMusicList(musicList);
        }
        return playlist;
    }

    /**
     * 创建播放列表
     */
    public UserPlaylist createPlaylist(Long userId, String name, String description) {
        // 检查名称是否已存在
        if (userPlaylistMapper.checkNameExists(userId, name) > 0) {
            throw new RuntimeException("播放列表名称已存在");
        }

        UserPlaylist playlist = new UserPlaylist(userId, name, description);
        userPlaylistMapper.insert(playlist);
        return playlist;
    }

    /**
     * 更新播放列表
     */
    public boolean updatePlaylist(Long id, String name, String description, String coverUrl) {
        UserPlaylist playlist = new UserPlaylist();
        playlist.setId(id);
        playlist.setName(name);
        playlist.setDescription(description);
        playlist.setCoverUrl(coverUrl);
        playlist.setUpdateTime(LocalDateTime.now());
        
        return userPlaylistMapper.update(playlist) > 0;
    }

    /**
     * 删除播放列表
     */
    public boolean deletePlaylist(Long id) {
        return userPlaylistMapper.deleteById(id, LocalDateTime.now()) > 0;
    }

    /**
     * 添加音乐到播放列表
     */
    public boolean addMusicToPlaylist(Long playlistId, PlaylistMusic music) {
        // 检查音乐是否已存在
        if (userPlaylistMapper.checkMusicInPlaylist(playlistId, music.getMusicId()) > 0) {
            throw new RuntimeException("音乐已存在于播放列表中");
        }

        music.setPlaylistId(playlistId);
        music.setAddTime(LocalDateTime.now());
        
        // 设置排序顺序（添加到末尾）
        List<PlaylistMusic> existingMusic = userPlaylistMapper.findMusicByPlaylistId(playlistId);
        music.setSortOrder(existingMusic.size());
        
        return userPlaylistMapper.addMusicToPlaylist(music) > 0;
    }

    /**
     * 从播放列表移除音乐
     */
    public boolean removeMusicFromPlaylist(Long playlistId, String musicId) {
        return userPlaylistMapper.removeMusicFromPlaylist(playlistId, musicId) > 0;
    }

    /**
     * 获取播放列表中的音乐
     */
    public List<PlaylistMusic> getPlaylistMusic(Long playlistId) {
        return userPlaylistMapper.findMusicByPlaylistId(playlistId);
    }

    /**
     * 更新音乐排序
     */
    public boolean updateMusicSort(Long musicId, Integer sortOrder) {
        return userPlaylistMapper.updateMusicSort(musicId, sortOrder) > 0;
    }

    /**
     * 清空播放列表
     */
    public boolean clearPlaylist(Long playlistId) {
        return userPlaylistMapper.clearPlaylist(playlistId) > 0;
    }

    /**
     * 检查音乐是否在播放列表中
     */
    public boolean isMusicInPlaylist(Long playlistId, String musicId) {
        return userPlaylistMapper.checkMusicInPlaylist(playlistId, musicId) > 0;
    }
}

