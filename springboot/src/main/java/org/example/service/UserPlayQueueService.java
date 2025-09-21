package***REMOVED***org.example.service;

import***REMOVED***org.example.entity.Music;
import***REMOVED***org.example.entity.UserPlayQueue;
import***REMOVED***org.example.mapper.UserPlayQueueMapper;
import***REMOVED***org.springframework.beans.factory.annotation.Autowired;
import***REMOVED***org.springframework.stereotype.Service;

import***REMOVED***java.time.LocalDateTime;
import***REMOVED***java.util.ArrayList;
import***REMOVED***java.util.List;

/**
***REMOVED*******REMOVED***用户播放队列服务类
***REMOVED****/
@Service
public***REMOVED***class***REMOVED***UserPlayQueueService***REMOVED***{

***REMOVED******REMOVED******REMOVED******REMOVED***@Autowired
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***UserPlayQueueMapper***REMOVED***userPlayQueueMapper;

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***获取用户的播放队列
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***List<UserPlayQueue>***REMOVED***getUserPlayQueue(Long***REMOVED***userId)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***userPlayQueueMapper.findByUserId(userId);
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***添加音乐到播放队列
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***boolean***REMOVED***addMusicToQueue(Long***REMOVED***userId,***REMOVED***Music***REMOVED***music,***REMOVED***Integer***REMOVED***insertIndex)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***检查音乐是否已存在
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(userPlayQueueMapper.checkMusicInQueue(userId,***REMOVED***music.getId().toString())***REMOVED***>***REMOVED***0)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***false;***REMOVED***//***REMOVED***音乐已存在
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***获取当前最大排序值
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***maxSortOrder***REMOVED***=***REMOVED***userPlayQueueMapper.getMaxSortOrder(userId);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***sortOrder***REMOVED***=***REMOVED***insertIndex***REMOVED***!=***REMOVED***null***REMOVED***?***REMOVED***insertIndex***REMOVED***:***REMOVED***maxSortOrder***REMOVED***+***REMOVED***1;

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***UserPlayQueue***REMOVED***queueItem***REMOVED***=***REMOVED***new***REMOVED***UserPlayQueue(userId,***REMOVED***music,***REMOVED***sortOrder);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***userPlayQueueMapper.insert(queueItem)***REMOVED***>***REMOVED***0;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***从播放队列移除音乐
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***boolean***REMOVED***removeMusicFromQueue(Long***REMOVED***userId,***REMOVED***String***REMOVED***musicId)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***userPlayQueueMapper.deleteByUserIdAndMusicId(userId,***REMOVED***musicId)***REMOVED***>***REMOVED***0;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***清空播放队列
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***boolean***REMOVED***clearPlayQueue(Long***REMOVED***userId)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***userPlayQueueMapper.clearByUserId(userId)***REMOVED***>***REMOVED***0;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***更新播放队列排序
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***boolean***REMOVED***updateQueueOrder(Long***REMOVED***userId,***REMOVED***List<Music>***REMOVED***musicList)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***先清空现有队列
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userPlayQueueMapper.clearByUserId(userId);

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***批量插入新的队列
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***List<UserPlayQueue>***REMOVED***queueItems***REMOVED***=***REMOVED***new***REMOVED***ArrayList<>();
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***for***REMOVED***(int***REMOVED***i***REMOVED***=***REMOVED***0;***REMOVED***i***REMOVED***<***REMOVED***musicList.size();***REMOVED***i++)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***UserPlayQueue***REMOVED***queueItem***REMOVED***=***REMOVED***new***REMOVED***UserPlayQueue(userId,***REMOVED***musicList.get(i),***REMOVED***i);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***queueItems.add(queueItem);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(!queueItems.isEmpty())***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***userPlayQueueMapper.batchInsert(queueItems)***REMOVED***>***REMOVED***0;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***true;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***检查音乐是否在播放队列中
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***boolean***REMOVED***isMusicInQueue(Long***REMOVED***userId,***REMOVED***String***REMOVED***musicId)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***userPlayQueueMapper.checkMusicInQueue(userId,***REMOVED***musicId)***REMOVED***>***REMOVED***0;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***获取播放队列中的音乐列表（转换为Music对象）
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***List<Music>***REMOVED***getQueueMusicList(Long***REMOVED***userId)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***List<UserPlayQueue>***REMOVED***queueItems***REMOVED***=***REMOVED***userPlayQueueMapper.findByUserId(userId);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***List<Music>***REMOVED***musicList***REMOVED***=***REMOVED***new***REMOVED***ArrayList<>();

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***for***REMOVED***(UserPlayQueue***REMOVED***item***REMOVED***:***REMOVED***queueItems)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***Music***REMOVED***music***REMOVED***=***REMOVED***new***REMOVED***Music();
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***music.setId(Long.parseLong(item.getMusicId()));
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***music.setMid(item.getMusicMid());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***music.setSong(item.getMusicSong());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***music.setSinger(item.getMusicSinger());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***music.setAlbum(item.getMusicAlbum());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***music.setCover(item.getMusicCover());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***music.setPlayUrl(item.getMusicUrl());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***musicList.add(music);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***musicList;
***REMOVED******REMOVED******REMOVED******REMOVED***}
}
