package org.example.entity;

import java.time.LocalDateTime;

/**
 * 用户收藏音乐实体类
 */
public class UserFavorite {
    private Long id;
    private Long userId;
    private String musicId;
    private String musicMid;
    private String musicSong;
    private String musicSinger;
    private String musicAlbum;
    private String musicCover;
    private String musicTime;
    private String musicPay;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    // 构造函数
    public UserFavorite() {}

    public UserFavorite(Long userId, String musicId, String musicMid, String musicSong, 
                       String musicSinger, String musicAlbum, String musicCover, 
                       String musicTime, String musicPay) {
        this.userId = userId;
        this.musicId = musicId;
        this.musicMid = musicMid;
        this.musicSong = musicSong;
        this.musicSinger = musicSinger;
        this.musicAlbum = musicAlbum;
        this.musicCover = musicCover;
        this.musicTime = musicTime;
        this.musicPay = musicPay;
    }

    // Getter和Setter方法
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

    public String getMusicTime() {
        return musicTime;
    }

    public void setMusicTime(String musicTime) {
        this.musicTime = musicTime;
    }

    public String getMusicPay() {
        return musicPay;
    }

    public void setMusicPay(String musicPay) {
        this.musicPay = musicPay;
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
        return "UserFavorite{" +
                "id=" + id +
                ", userId=" + userId +
                ", musicId='" + musicId + '\'' +
                ", musicMid='" + musicMid + '\'' +
                ", musicSong='" + musicSong + '\'' +
                ", musicSinger='" + musicSinger + '\'' +
                ", musicAlbum='" + musicAlbum + '\'' +
                ", musicCover='" + musicCover + '\'' +
                ", musicTime='" + musicTime + '\'' +
                ", musicPay='" + musicPay + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
