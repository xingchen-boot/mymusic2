package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 音乐实体类
 */
public class Music {
    
    @JsonProperty("id")
    private Long id;
    
    @JsonProperty("mid")
    private String mid;
    
    @JsonProperty("vid")
    private String vid;
    
    @JsonProperty("song")
    private String song;
    
    @JsonProperty("subtitle")
    private String subtitle;
    
    @JsonProperty("album")
    private String album;
    
    @JsonProperty("singer")
    private String singer;
    
    @JsonProperty("singer_list")
    private Object singerList;
    
    @JsonProperty("cover")
    private String cover;
    
    @JsonProperty("pay")
    private String pay;
    
    @JsonProperty("time")
    private String time;
    
    @JsonProperty("type")
    private Integer type;
    
    @JsonProperty("bpm")
    private Integer bpm;
    
    @JsonProperty("interval")
    private String interval;
    
    @JsonProperty("content")
    private String content;
    
    @JsonProperty("quality")
    private String quality;
    
    @JsonProperty("grp")
    private Object grp;
    
    // 播放相关字段（不在API响应中，用于前端播放）
    private String playUrl;
    private String format;
    private String lyrics;
    
    // 构造函数
    public Music() {}
    
    public Music(Long id, String song, String singer, String album, String cover) {
        this.id = id;
        this.song = song;
        this.singer = singer;
        this.album = album;
        this.cover = cover;
    }
    
    // Getter和Setter方法
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getMid() {
        return mid;
    }
    
    public void setMid(String mid) {
        this.mid = mid;
    }
    
    public String getVid() {
        return vid;
    }
    
    public void setVid(String vid) {
        this.vid = vid;
    }
    
    public String getSong() {
        return song;
    }
    
    public void setSong(String song) {
        this.song = song;
    }
    
    public String getSubtitle() {
        return subtitle;
    }
    
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
    
    public String getAlbum() {
        return album;
    }
    
    public void setAlbum(String album) {
        this.album = album;
    }
    
    public String getSinger() {
        return singer;
    }
    
    public void setSinger(String singer) {
        this.singer = singer;
    }
    
    public Object getSingerList() {
        return singerList;
    }
    
    public void setSingerList(Object singerList) {
        this.singerList = singerList;
    }
    
    public String getCover() {
        return cover;
    }
    
    public void setCover(String cover) {
        this.cover = cover;
    }
    
    public String getPay() {
        return pay;
    }
    
    public void setPay(String pay) {
        this.pay = pay;
    }
    
    public String getTime() {
        return time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    public Integer getType() {
        return type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
    
    public Integer getBpm() {
        return bpm;
    }
    
    public void setBpm(Integer bpm) {
        this.bpm = bpm;
    }
    
    public String getInterval() {
        return interval;
    }
    
    public void setInterval(String interval) {
        this.interval = interval;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getQuality() {
        return quality;
    }
    
    public void setQuality(String quality) {
        this.quality = quality;
    }
    
    public Object getGrp() {
        return grp;
    }
    
    public void setGrp(Object grp) {
        this.grp = grp;
    }
    
    public String getPlayUrl() {
        return playUrl;
    }
    
    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }
    
    public String getFormat() {
        return format;
    }
    
    public void setFormat(String format) {
        this.format = format;
    }
    
    public String getLyrics() {
        return lyrics;
    }
    
    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
    
    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", song='" + song + '\'' +
                ", singer='" + singer + '\'' +
                ", album='" + album + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }
}
