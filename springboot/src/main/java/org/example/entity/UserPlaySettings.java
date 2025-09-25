package org.example.entity;

import java.time.LocalDateTime;

/**
 * 用户播放设置实体类
 */
public class UserPlaySettings {
    private Long id;
    private Long userId;
    private Integer volume;
    private Boolean isMuted;
    private String playMode;
    private String currentMusicId;
    private String currentMusicName;
    private String currentMusicArtist;
    private String currentMusicCover;
    private String currentMusicUrl;
    private Double playProgress;
    private Double playTime;
    private Boolean isPlaying;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public UserPlaySettings() {}

    public UserPlaySettings(Long userId, Integer volume, Boolean isMuted, String playMode) {
        this.userId = userId;
        this.volume = volume;
        this.isMuted = isMuted;
        this.playMode = playMode;
    }

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

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Boolean getIsMuted() {
        return isMuted;
    }

    public void setIsMuted(Boolean isMuted) {
        this.isMuted = isMuted;
    }

    public String getPlayMode() {
        return playMode;
    }

    public void setPlayMode(String playMode) {
        this.playMode = playMode;
    }

    public String getCurrentMusicId() {
        return currentMusicId;
    }

    public void setCurrentMusicId(String currentMusicId) {
        this.currentMusicId = currentMusicId;
    }

    public String getCurrentMusicName() {
        return currentMusicName;
    }

    public void setCurrentMusicName(String currentMusicName) {
        this.currentMusicName = currentMusicName;
    }

    public String getCurrentMusicArtist() {
        return currentMusicArtist;
    }

    public void setCurrentMusicArtist(String currentMusicArtist) {
        this.currentMusicArtist = currentMusicArtist;
    }

    public String getCurrentMusicCover() {
        return currentMusicCover;
    }

    public void setCurrentMusicCover(String currentMusicCover) {
        this.currentMusicCover = currentMusicCover;
    }

    public String getCurrentMusicUrl() {
        return currentMusicUrl;
    }

    public void setCurrentMusicUrl(String currentMusicUrl) {
        this.currentMusicUrl = currentMusicUrl;
    }

    public Double getPlayProgress() {
        return playProgress;
    }

    public void setPlayProgress(Double playProgress) {
        this.playProgress = playProgress;
    }

    public Double getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Double playTime) {
        this.playTime = playTime;
    }

    public Boolean getIsPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(Boolean isPlaying) {
        this.isPlaying = isPlaying;
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

    @Override
    public String toString() {
        return "UserPlaySettings{" +
                "id=" + id +
                ", userId=" + userId +
                ", volume=" + volume +
                ", isMuted=" + isMuted +
                ", playMode='" + playMode + '\'' +
                ", currentMusicId='" + currentMusicId + '\'' +
                ", currentMusicName='" + currentMusicName + '\'' +
                ", currentMusicArtist='" + currentMusicArtist + '\'' +
                ", currentMusicCover='" + currentMusicCover + '\'' +
                ", currentMusicUrl='" + currentMusicUrl + '\'' +
                ", playProgress=" + playProgress +
                ", playTime=" + playTime +
                ", isPlaying=" + isPlaying +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
