package org.example.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 用户最近播放实体类
 */
public class UserRecentPlay {
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
    private LocalDateTime playTime;
    private Integer playDuration;
    private BigDecimal playProgress;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    // 构造函数
    public UserRecentPlay() {}

    public UserRecentPlay(Long userId, String musicId, String musicMid, String musicSong, 
                         String musicSinger, String musicAlbum, String musicCover, 
                         String musicTime, String musicPay, Integer playDuration, BigDecimal playProgress) {
        this.userId = userId;
        this.musicId = musicId;
        this.musicMid = musicMid;
        this.musicSong = musicSong;
        this.musicSinger = musicSinger;
        this.musicAlbum = musicAlbum;
        this.musicCover = musicCover;
        this.musicTime = musicTime;
        this.musicPay = musicPay;
        this.playDuration = playDuration;
        this.playProgress = playProgress;
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

    public LocalDateTime getPlayTime() {
        return playTime;
    }

    public void setPlayTime(LocalDateTime playTime) {
        this.playTime = playTime;
    }

    public Integer getPlayDuration() {
        return playDuration;
    }

    public void setPlayDuration(Integer playDuration) {
        this.playDuration = playDuration;
    }

    public BigDecimal getPlayProgress() {
        return playProgress;
    }

    public void setPlayProgress(BigDecimal playProgress) {
        this.playProgress = playProgress;
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
        return "UserRecentPlay{" +
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
                ", playTime=" + playTime +
                ", playDuration=" + playDuration +
                ", playProgress=" + playProgress +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
