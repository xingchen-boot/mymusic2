package org.example.entity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户播放列表实体类
 */
public class UserPlaylist {
    private Long id;
    private Long userId;
    private String name;
    private String description;
    private String coverUrl;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer status; // 0-删除 1-正常
    private List<PlaylistMusic> musicList; // 播放列表中的音乐

    public UserPlaylist() {}

    public UserPlaylist(Long userId, String name, String description) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.status = 1;
        this.createTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<PlaylistMusic> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<PlaylistMusic> musicList) {
        this.musicList = musicList;
    }

    @Override
    public String toString() {
        return "UserPlaylist{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                '}';
    }
}

