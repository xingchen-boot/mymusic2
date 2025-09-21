package***REMOVED***org.example.entity;

import***REMOVED***java.time.LocalDateTime;

/**
***REMOVED*******REMOVED***用户收藏音乐实体类
***REMOVED****/
public***REMOVED***class***REMOVED***UserFavorite***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***Long***REMOVED***id;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***Long***REMOVED***userId;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***musicId;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***musicMid;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***musicSong;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***musicSinger;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***musicAlbum;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***musicCover;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***musicTime;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***musicPay;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***LocalDateTime***REMOVED***createTime;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***LocalDateTime***REMOVED***updateTime;

***REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***构造函数
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***UserFavorite()***REMOVED***{}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***UserFavorite(Long***REMOVED***userId,***REMOVED***String***REMOVED***musicId,***REMOVED***String***REMOVED***musicMid,***REMOVED***String***REMOVED***musicSong,***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***String***REMOVED***musicSinger,***REMOVED***String***REMOVED***musicAlbum,***REMOVED***String***REMOVED***musicCover,***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***String***REMOVED***musicTime,***REMOVED***String***REMOVED***musicPay)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.userId***REMOVED***=***REMOVED***userId;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicId***REMOVED***=***REMOVED***musicId;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicMid***REMOVED***=***REMOVED***musicMid;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicSong***REMOVED***=***REMOVED***musicSong;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicSinger***REMOVED***=***REMOVED***musicSinger;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicAlbum***REMOVED***=***REMOVED***musicAlbum;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicCover***REMOVED***=***REMOVED***musicCover;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicTime***REMOVED***=***REMOVED***musicTime;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicPay***REMOVED***=***REMOVED***musicPay;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***Getter和Setter方法
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***Long***REMOVED***getId()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***id;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setId(Long***REMOVED***id)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.id***REMOVED***=***REMOVED***id;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***Long***REMOVED***getUserId()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***userId;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setUserId(Long***REMOVED***userId)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.userId***REMOVED***=***REMOVED***userId;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***getMusicId()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***musicId;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setMusicId(String***REMOVED***musicId)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicId***REMOVED***=***REMOVED***musicId;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***getMusicMid()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***musicMid;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setMusicMid(String***REMOVED***musicMid)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicMid***REMOVED***=***REMOVED***musicMid;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***getMusicSong()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***musicSong;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setMusicSong(String***REMOVED***musicSong)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicSong***REMOVED***=***REMOVED***musicSong;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***getMusicSinger()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***musicSinger;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setMusicSinger(String***REMOVED***musicSinger)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicSinger***REMOVED***=***REMOVED***musicSinger;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***getMusicAlbum()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***musicAlbum;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setMusicAlbum(String***REMOVED***musicAlbum)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicAlbum***REMOVED***=***REMOVED***musicAlbum;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***getMusicCover()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***musicCover;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setMusicCover(String***REMOVED***musicCover)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicCover***REMOVED***=***REMOVED***musicCover;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***getMusicTime()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***musicTime;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setMusicTime(String***REMOVED***musicTime)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicTime***REMOVED***=***REMOVED***musicTime;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***getMusicPay()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***musicPay;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setMusicPay(String***REMOVED***musicPay)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicPay***REMOVED***=***REMOVED***musicPay;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***LocalDateTime***REMOVED***getCreateTime()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***createTime;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setCreateTime(LocalDateTime***REMOVED***createTime)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.createTime***REMOVED***=***REMOVED***createTime;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***LocalDateTime***REMOVED***getUpdateTime()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***updateTime;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setUpdateTime(LocalDateTime***REMOVED***updateTime)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.updateTime***REMOVED***=***REMOVED***updateTime;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***@Override
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***toString()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***"UserFavorite{"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"id="***REMOVED***+***REMOVED***id***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***userId="***REMOVED***+***REMOVED***userId***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***musicId='"***REMOVED***+***REMOVED***musicId***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***musicMid='"***REMOVED***+***REMOVED***musicMid***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***musicSong='"***REMOVED***+***REMOVED***musicSong***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***musicSinger='"***REMOVED***+***REMOVED***musicSinger***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***musicAlbum='"***REMOVED***+***REMOVED***musicAlbum***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***musicCover='"***REMOVED***+***REMOVED***musicCover***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***musicTime='"***REMOVED***+***REMOVED***musicTime***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***musicPay='"***REMOVED***+***REMOVED***musicPay***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***createTime="***REMOVED***+***REMOVED***createTime***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***updateTime="***REMOVED***+***REMOVED***updateTime***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***'}';
***REMOVED******REMOVED******REMOVED******REMOVED***}
}
