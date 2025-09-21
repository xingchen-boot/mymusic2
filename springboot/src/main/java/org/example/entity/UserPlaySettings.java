package***REMOVED***org.example.entity;

import***REMOVED***java.time.LocalDateTime;

/**
***REMOVED*******REMOVED***用户播放设置实体类
***REMOVED****/
public***REMOVED***class***REMOVED***UserPlaySettings***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***Long***REMOVED***id;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***Long***REMOVED***userId;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***Integer***REMOVED***volume;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***Boolean***REMOVED***isMuted;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***playMode;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***currentMusicId;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***currentMusicName;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***currentMusicArtist;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***currentMusicCover;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***String***REMOVED***currentMusicUrl;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***Double***REMOVED***playProgress;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***Double***REMOVED***playTime;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***Boolean***REMOVED***isPlaying;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***LocalDateTime***REMOVED***createTime;
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***LocalDateTime***REMOVED***updateTime;

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***UserPlaySettings()***REMOVED***{}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***UserPlaySettings(Long***REMOVED***userId,***REMOVED***Integer***REMOVED***volume,***REMOVED***Boolean***REMOVED***isMuted,***REMOVED***String***REMOVED***playMode)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.userId***REMOVED***=***REMOVED***userId;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.volume***REMOVED***=***REMOVED***volume;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.isMuted***REMOVED***=***REMOVED***isMuted;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.playMode***REMOVED***=***REMOVED***playMode;
***REMOVED******REMOVED******REMOVED******REMOVED***}

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

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***Integer***REMOVED***getVolume()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***volume;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setVolume(Integer***REMOVED***volume)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.volume***REMOVED***=***REMOVED***volume;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***Boolean***REMOVED***getIsMuted()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***isMuted;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setIsMuted(Boolean***REMOVED***isMuted)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.isMuted***REMOVED***=***REMOVED***isMuted;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***getPlayMode()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***playMode;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setPlayMode(String***REMOVED***playMode)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.playMode***REMOVED***=***REMOVED***playMode;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***getCurrentMusicId()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***currentMusicId;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setCurrentMusicId(String***REMOVED***currentMusicId)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.currentMusicId***REMOVED***=***REMOVED***currentMusicId;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***getCurrentMusicName()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***currentMusicName;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setCurrentMusicName(String***REMOVED***currentMusicName)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.currentMusicName***REMOVED***=***REMOVED***currentMusicName;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***getCurrentMusicArtist()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***currentMusicArtist;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setCurrentMusicArtist(String***REMOVED***currentMusicArtist)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.currentMusicArtist***REMOVED***=***REMOVED***currentMusicArtist;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***getCurrentMusicCover()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***currentMusicCover;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setCurrentMusicCover(String***REMOVED***currentMusicCover)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.currentMusicCover***REMOVED***=***REMOVED***currentMusicCover;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***String***REMOVED***getCurrentMusicUrl()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***currentMusicUrl;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setCurrentMusicUrl(String***REMOVED***currentMusicUrl)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.currentMusicUrl***REMOVED***=***REMOVED***currentMusicUrl;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***Double***REMOVED***getPlayProgress()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***playProgress;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setPlayProgress(Double***REMOVED***playProgress)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.playProgress***REMOVED***=***REMOVED***playProgress;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***Double***REMOVED***getPlayTime()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***playTime;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setPlayTime(Double***REMOVED***playTime)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.playTime***REMOVED***=***REMOVED***playTime;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***Boolean***REMOVED***getIsPlaying()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***isPlaying;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***setIsPlaying(Boolean***REMOVED***isPlaying)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.isPlaying***REMOVED***=***REMOVED***isPlaying;
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
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***"UserPlaySettings{"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"id="***REMOVED***+***REMOVED***id***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***userId="***REMOVED***+***REMOVED***userId***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***volume="***REMOVED***+***REMOVED***volume***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***isMuted="***REMOVED***+***REMOVED***isMuted***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***playMode='"***REMOVED***+***REMOVED***playMode***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***currentMusicId='"***REMOVED***+***REMOVED***currentMusicId***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***currentMusicName='"***REMOVED***+***REMOVED***currentMusicName***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***currentMusicArtist='"***REMOVED***+***REMOVED***currentMusicArtist***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***currentMusicCover='"***REMOVED***+***REMOVED***currentMusicCover***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***currentMusicUrl='"***REMOVED***+***REMOVED***currentMusicUrl***REMOVED***+***REMOVED***'\''***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***playProgress="***REMOVED***+***REMOVED***playProgress***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***playTime="***REMOVED***+***REMOVED***playTime***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***isPlaying="***REMOVED***+***REMOVED***isPlaying***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***createTime="***REMOVED***+***REMOVED***createTime***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***",***REMOVED***updateTime="***REMOVED***+***REMOVED***updateTime***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***'}';
***REMOVED******REMOVED******REMOVED******REMOVED***}
}
