package org.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

/**
 * 播放列表音乐关联实体类
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaylistMusic {
    
    private Long id;
    private Long playlistId;
    private String musicId;
    private String musicName;
    private String artistName;
    private String albumName;
    private Integer duration;
    private String musicUrl;
    private String coverUrl;
    private Integer sortOrder;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime addTime;
    
    // 构造函数
    public PlaylistMusic() {}
    
    public PlaylistMusic(Long playlistId, Music music) {
        this.playlistId = playlistId;
        this.musicId = music.getId().toString();
        this.musicName = music.getSong();
        this.artistName = music.getSinger();
        this.albumName = music.getAlbum();
        this.coverUrl = music.getCover();
        this.musicUrl = music.getPlayUrl();
    }
    
    // Getter和Setter方法
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getPlaylistId() {
        return playlistId;
    }
    
    public void setPlaylistId(Long playlistId) {
        this.playlistId = playlistId;
    }
    
    public String getMusicId() {
        return musicId;
    }
    
    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }
    
    public String getMusicName() {
        return musicName;
    }
    
    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }
    
    public String getArtistName() {
        return artistName;
    }
    
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
    
    public String getAlbumName() {
        return albumName;
    }
    
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
    
    public Integer getDuration() {
        return duration;
    }
    
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    
    public String getCoverUrl() {
        return coverUrl;
    }
    
    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
    
    public String getMusicUrl() {
        return musicUrl;
    }
    
    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }
    
    public Integer getSortOrder() {
        return sortOrder;
    }
    
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
    
    public LocalDateTime getAddTime() {
        return addTime;
    }
    
    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }
    
    @Override
    public String toString() {
        return "PlaylistMusic{" +
                "id=" + id +
                ", playlistId=" + playlistId +
                ", musicName='" + musicName + '\'' +
                ", artistName='" + artistName + '\'' +
                '}';
    }
}
