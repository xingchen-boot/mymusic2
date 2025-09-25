package org.example.entity;

import java.time.LocalDateTime;

/**
 * 用户播放队列实体类
 */
public class UserPlayQueue {
    private Long id;
    private Long userId;
    private String musicId;
    private String musicMid;
    private String musicSong;
    private String musicSinger;
    private String musicAlbum;
    private String musicCover;
    private String musicUrl;
    private Integer sortOrder;
    private LocalDateTime addTime;
    private Integer status; // 0-删除 1-正常

    public UserPlayQueue() {}

    public UserPlayQueue(Long userId, Music music, Integer sortOrder) {
        this.userId = userId;
        this.musicId = music.getId().toString();
        this.musicMid = music.getMid();
        this.musicSong = music.getSong();
        this.musicSinger = music.getSinger();
        this.musicAlbum = music.getAlbum();
        this.musicCover = music.getCover();
        this.musicUrl = music.getPlayUrl();
        this.sortOrder = sortOrder;
        this.addTime = LocalDateTime.now();
        this.status = 1;
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

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getMusicMid() {
        return musicMid;
    }

    public void setMusicMid(String musicMid) {
        this.musicMid = musicMid;
    }

    public String getMusicSong() {
        return musicSong;
    }

    public void setMusicSong(String musicSong) {
        this.musicSong = musicSong;
    }

    public String getMusicSinger() {
        return musicSinger;
    }

    public void setMusicSinger(String musicSinger) {
        this.musicSinger = musicSinger;
    }

    public String getMusicAlbum() {
        return musicAlbum;
    }

    public void setMusicAlbum(String musicAlbum) {
        this.musicAlbum = musicAlbum;
    }

    public String getMusicCover() {
        return musicCover;
    }

    public void setMusicCover(String musicCover) {
        this.musicCover = musicCover;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserPlayQueue{" +
                "id=" + id +
                ", userId=" + userId +
                ", musicId='" + musicId + '\'' +
                ", musicSong='" + musicSong + '\'' +
                ", musicSinger='" + musicSinger + '\'' +
                ", sortOrder=" + sortOrder +
                '}';
    }
}
