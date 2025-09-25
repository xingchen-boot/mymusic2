package org.example.service;

import org.example.entity.Music;
import org.example.entity.Playlist;
import org.example.entity.PlaylistMusic;
import org.example.mapper.PlaylistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 播放列表服务类
 */
@Service
public class PlaylistService {
    
    @Autowired
    private PlaylistMapper playlistMapper;
    
    /**
     * 创建播放列表
     */
    @Transactional
    public Playlist createPlaylist(String name, String description) {
        Playlist playlist = new Playlist(name, description);
        playlist.setCreatedAt(LocalDateTime.now());
        playlist.setUpdatedAt(LocalDateTime.now());
        
        playlistMapper.insertPlaylist(playlist);
        return playlist;
    }
    
    /**
     * 获取所有播放列表
     */
    public List<Playlist> getAllPlaylists() {
        List<Playlist> playlists = playlistMapper.selectAllPlaylists();
        
        // 为每个播放列表设置音乐数量
        for (Playlist playlist : playlists) {
            int musicCount = playlistMapper.countMusicByPlaylistId(playlist.getId());
            playlist.setMusicCount(musicCount);
        }
        
        return playlists;
    }
    
    /**
     * 根据ID获取播放列表
     */
    public Playlist getPlaylistById(Long id) {
        Playlist playlist = playlistMapper.selectPlaylistById(id);
        if (playlist != null) {
            // 获取播放列表中的音乐
            List<PlaylistMusic> musicList = playlistMapper.selectMusicByPlaylistId(id);
            playlist.setMusicList(musicList);
            
            // 设置音乐数量
            playlist.setMusicCount(musicList.size());
        }
        return playlist;
    }
    
    /**
     * 更新播放列表
     */
    @Transactional
    public boolean updatePlaylist(Playlist playlist) {
        playlist.setUpdatedAt(LocalDateTime.now());
        return playlistMapper.updatePlaylist(playlist) > 0;
    }
    
    /**
     * 删除播放列表
     */
    @Transactional
    public boolean deletePlaylist(Long id) {
        // 先删除播放列表中的所有音乐
        playlistMapper.deleteAllMusicFromPlaylist(id);
        // 再删除播放列表
        return playlistMapper.deletePlaylist(id) > 0;
    }
    
    /**
     * 添加音乐到播放列表
     */
    @Transactional
    public boolean addMusicToPlaylist(Long playlistId, Music music) {
        // 检查音乐是否已存在
        if (playlistMapper.existsMusicInPlaylist(playlistId, music.getId())) {
            return false; // 音乐已存在
        }
        
        PlaylistMusic playlistMusic = new PlaylistMusic(playlistId, music);
        playlistMusic.setAddTime(LocalDateTime.now());
        
        // 设置排序顺序（添加到末尾）
        int maxOrder = playlistMapper.countMusicByPlaylistId(playlistId);
        playlistMusic.setSortOrder(maxOrder + 1);
        
        return playlistMapper.insertPlaylistMusic(playlistMusic) > 0;
    }
    
    /**
     * 从播放列表移除音乐
     */
    @Transactional
    public boolean removeMusicFromPlaylist(Long playlistId, Long musicId) {
        return playlistMapper.deleteMusicFromPlaylist(playlistId, musicId) > 0;
    }
    
    /**
     * 获取播放列表中的音乐
     */
    public List<PlaylistMusic> getPlaylistMusic(Long playlistId) {
        return playlistMapper.selectMusicByPlaylistId(playlistId);
    }
    
    /**
     * 检查音乐是否在播放列表中
     */
    public boolean isMusicInPlaylist(Long playlistId, Long musicId) {
        return playlistMapper.existsMusicInPlaylist(playlistId, musicId);
    }
}
