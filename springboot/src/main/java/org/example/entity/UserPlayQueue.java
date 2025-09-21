package***REMOVED***org.example.entity;

import***REMOVED***java.time.LocalDateTime;

/**
***REMOVED*******REMOVED***用户播放队列实体类
***REMOVED****/
public***REMOVED***class***REMOVED***UserPlayQueue***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***Long***REMOVED***id;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***Long***REMOVED***userId;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***musicId;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***musicMid;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***musicSong;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***musicSinger;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***musicAlbum;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***musicCover;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***musicUrl;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***Integer***REMOVED***sortOrder;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***LocalDateTime***REMOVED***addTime;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***Integer***REMOVED***status;***REMOVED***//***REMOVED***0-删除***REMOVED***1-正常

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***UserPlayQueue()***REMOVED***{}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***UserPlayQueue(Long***REMOVED***userId,***REMOVED***Music***REMOVED***music,***REMOVED***Integer***REMOVED***sortOrder)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.userId***REMOVED***=***REMOVED***userId;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicId***REMOVED***=***REMOVED***music.getId().toString();
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicMid***REMOVED***=***REMOVED***music.getMid();
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicSong***REMOVED***=***REMOVED***music.getSong();
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicSinger***REMOVED***=***REMOVED***music.getSinger();
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicAlbum***REMOVED***=***REMOVED***music.getAlbum();
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicCover***REMOVED***=***REMOVED***music.getCover();
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicUrl***REMOVED***=***REMOVED***music.getPlayUrl();
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.sortOrder***REMOVED***=***REMOVED***sortOrder;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.addTime***REMOVED***=***REMOVED***LocalDateTime.now();
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.status***REMOVED***=***REMOVED***1;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***Getters***REMOVED***and***REMOVED***Setters
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

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***getMusicUrl()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***musicUrl;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setMusicUrl(String***REMOVED***musicUrl)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicUrl***REMOVED***=***REMOVED***musicUrl;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***Integer***REMOVED***getSortOrder()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***sortOrder;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setSortOrder(Integer***REMOVED***sortOrder)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.sortOrder***REMOVED***=***REMOVED***sortOrder;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***LocalDateTime***REMOVED***getAddTime()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***addTime;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setAddTime(LocalDateTime***REMOVED***addTime)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.addTime***REMOVED***=***REMOVED***addTime;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***Integer***REMOVED***getStatus()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***status;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setStatus(Integer***REMOVED***status)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.status***REMOVED***=***REMOVED***status;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***@Override
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***toString()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***"UserPlayQueue{"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"id="***REMOVED***+***REMOVED***id***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***userId="***REMOVED***+***REMOVED***userId***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***musicId='"***REMOVED***+***REMOVED***musicId***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***musicSong='"***REMOVED***+***REMOVED***musicSong***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***musicSinger='"***REMOVED***+***REMOVED***musicSinger***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***sortOrder="***REMOVED***+***REMOVED***sortOrder***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***'}';
***REMOVED******REMOVED******REMOVED******REMOVED***}
}
