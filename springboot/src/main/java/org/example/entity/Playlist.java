package org.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 播放列表实体类
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Playlist {
    
    private Long id;
    private String name;
    private String description;
    private String cover;
    private Long userId;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
    
    // 播放列表中的音乐列表（不存储到数据库，用于API返回）
    private List<PlaylistMusic> musicList;
    
    // 音乐数量（计算字段）
    private Integer musicCount;
    
    // 构造函数
    public Playlist() {}
    
    public Playlist(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public Playlist(Long id, String name, String description, String cover) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cover = cover;
    }
    
    // Getter和Setter方法
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getCover() {
        return cover;
    }
    
    public void setCover(String cover) {
        this.cover = cover;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public List<PlaylistMusic> getMusicList() {
        return musicList;
    }
    
    public void setMusicList(List<PlaylistMusic> musicList) {
        this.musicList = musicList;
    }
    
    public Integer getMusicCount() {
        return musicCount;
    }
    
    public void setMusicCount(Integer musicCount) {
        this.musicCount = musicCount;
    }
    
    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", musicCount=" + musicCount +
                '}';
    }
}
