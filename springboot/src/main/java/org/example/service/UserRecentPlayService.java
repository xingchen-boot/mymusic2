package***REMOVED***org.example.service;

import***REMOVED***org.example.entity.UserRecentPlay;
import***REMOVED***org.example.mapper.UserRecentPlayMapper;
import***REMOVED***org.springframework.beans.factory.annotation.Autowired;
import***REMOVED***org.springframework.stereotype.Service;

import***REMOVED***java.math.BigDecimal;
import***REMOVED***java.util.List;

/**
***REMOVED*******REMOVED***用户最近播放服务类
***REMOVED****/
@Service
public***REMOVED***class***REMOVED***UserRecentPlayService***REMOVED***{

***REMOVED******REMOVED******REMOVED******REMOVED***@Autowired
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***UserRecentPlayMapper***REMOVED***userRecentPlayMapper;

***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***static***REMOVED***final***REMOVED***int***REMOVED***MAX_RECENT_PLAYS***REMOVED***=***REMOVED***100;***REMOVED***//***REMOVED***最多保留100条最近播放记录

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***记录用户播放音乐
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***recordPlay(Long***REMOVED***userId,***REMOVED***String***REMOVED***musicId,***REMOVED***String***REMOVED***musicMid,***REMOVED***String***REMOVED***musicSong,***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***String***REMOVED***musicSinger,***REMOVED***String***REMOVED***musicAlbum,***REMOVED***String***REMOVED***musicCover,***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***String***REMOVED***musicTime,***REMOVED***String***REMOVED***musicPay,***REMOVED***Integer***REMOVED***playDuration,***REMOVED***BigDecimal***REMOVED***playProgress)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***UserRecentPlay***REMOVED***recentPlay***REMOVED***=***REMOVED***new***REMOVED***UserRecentPlay(
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userId,***REMOVED***musicId,***REMOVED***musicMid,***REMOVED***musicSong,***REMOVED***musicSinger,***REMOVED***musicAlbum,***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***musicCover,***REMOVED***musicTime,***REMOVED***musicPay,***REMOVED***playDuration,***REMOVED***playProgress
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***插入或更新记录
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userRecentPlayMapper.insertOrUpdate(recentPlay);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***检查是否需要删除旧记录
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***totalCount***REMOVED***=***REMOVED***userRecentPlayMapper.countByUserId(userId);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(totalCount***REMOVED***>***REMOVED***MAX_RECENT_PLAYS)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userRecentPlayMapper.deleteOldRecords(userId,***REMOVED***MAX_RECENT_PLAYS);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(Exception***REMOVED***e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***System.err.println("记录最近播放失败:***REMOVED***"***REMOVED***+***REMOVED***e.getMessage());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***不抛出异常，避免影响播放功能
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***更新播放进度
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***updatePlayProgress(Long***REMOVED***userId,***REMOVED***String***REMOVED***musicId,***REMOVED***Integer***REMOVED***playDuration,***REMOVED***BigDecimal***REMOVED***playProgress)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userRecentPlayMapper.updatePlayProgress(userId,***REMOVED***musicId,***REMOVED***playDuration,***REMOVED***playProgress);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(Exception***REMOVED***e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***System.err.println("更新播放进度失败:***REMOVED***"***REMOVED***+***REMOVED***e.getMessage());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***获取用户最近播放列表
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***List<UserRecentPlay>***REMOVED***getRecentPlays(Long***REMOVED***userId,***REMOVED***Integer***REMOVED***limit)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(limit***REMOVED***==***REMOVED***null***REMOVED***||***REMOVED***limit***REMOVED***<=***REMOVED***0)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***limit***REMOVED***=***REMOVED***50;***REMOVED***//***REMOVED***默认返回50条
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***userRecentPlayMapper.findByUserIdOrderByPlayTimeDesc(userId,***REMOVED***limit);
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***获取用户最近播放列表（默认50条）
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***List<UserRecentPlay>***REMOVED***getRecentPlays(Long***REMOVED***userId)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***getRecentPlays(userId,***REMOVED***50);
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***检查音乐是否在最近播放中
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***boolean***REMOVED***isInRecentPlays(Long***REMOVED***userId,***REMOVED***String***REMOVED***musicId)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***UserRecentPlay***REMOVED***recentPlay***REMOVED***=***REMOVED***userRecentPlayMapper.findByUserIdAndMusicId(userId,***REMOVED***musicId);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***recentPlay***REMOVED***!=***REMOVED***null;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***从最近播放中移除音乐
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***boolean***REMOVED***removeFromRecentPlays(Long***REMOVED***userId,***REMOVED***String***REMOVED***musicId)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***result***REMOVED***=***REMOVED***userRecentPlayMapper.deleteByUserIdAndMusicId(userId,***REMOVED***musicId);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***result***REMOVED***>***REMOVED***0;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(Exception***REMOVED***e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***System.err.println("从最近播放移除失败:***REMOVED***"***REMOVED***+***REMOVED***e.getMessage());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***false;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***清空用户最近播放记录
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***boolean***REMOVED***clearRecentPlays(Long***REMOVED***userId)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***result***REMOVED***=***REMOVED***userRecentPlayMapper.deleteByUserId(userId);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***result***REMOVED***>=***REMOVED***0;***REMOVED***//***REMOVED***即使没有记录也返回true
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(Exception***REMOVED***e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***System.err.println("清空最近播放失败:***REMOVED***"***REMOVED***+***REMOVED***e.getMessage());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***false;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***获取用户最近播放数量
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***int***REMOVED***getRecentPlaysCount(Long***REMOVED***userId)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***userRecentPlayMapper.countByUserId(userId);
***REMOVED******REMOVED******REMOVED******REMOVED***}
}
