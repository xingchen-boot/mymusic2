package***REMOVED***org.example.mapper;

import***REMOVED***org.apache.ibatis.annotations.*;
import***REMOVED***org.example.entity.UserRecentPlay;

import***REMOVED***java.util.List;

/**
***REMOVED*******REMOVED***用户最近播放Mapper接口
***REMOVED****/
@Mapper
public***REMOVED***interface***REMOVED***UserRecentPlayMapper***REMOVED***{

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***插入或更新最近播放记录
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Insert("INSERT***REMOVED***INTO***REMOVED***user_recent_play***REMOVED***(user_id,***REMOVED***music_id,***REMOVED***music_mid,***REMOVED***music_song,***REMOVED***music_singer,***REMOVED***music_album,***REMOVED***music_cover,***REMOVED***music_time,***REMOVED***music_pay,***REMOVED***play_duration,***REMOVED***play_progress)***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"VALUES***REMOVED***(#{userId},***REMOVED***#{musicId},***REMOVED***#{musicMid},***REMOVED***#{musicSong},***REMOVED***#{musicSinger},***REMOVED***#{musicAlbum},***REMOVED***#{musicCover},***REMOVED***#{musicTime},***REMOVED***#{musicPay},***REMOVED***#{playDuration},***REMOVED***#{playProgress})***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"ON***REMOVED***DUPLICATE***REMOVED***KEY***REMOVED***UPDATE***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"music_mid***REMOVED***=***REMOVED***VALUES(music_mid),***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"music_song***REMOVED***=***REMOVED***VALUES(music_song),***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"music_singer***REMOVED***=***REMOVED***VALUES(music_singer),***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"music_album***REMOVED***=***REMOVED***VALUES(music_album),***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"music_cover***REMOVED***=***REMOVED***VALUES(music_cover),***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"music_time***REMOVED***=***REMOVED***VALUES(music_time),***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"music_pay***REMOVED***=***REMOVED***VALUES(music_pay),***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"play_time***REMOVED***=***REMOVED***CURRENT_TIMESTAMP,***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"play_duration***REMOVED***=***REMOVED***VALUES(play_duration),***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"play_progress***REMOVED***=***REMOVED***VALUES(play_progress),***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"update_time***REMOVED***=***REMOVED***CURRENT_TIMESTAMP")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***insertOrUpdate(UserRecentPlay***REMOVED***userRecentPlay);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***根据用户ID获取最近播放列表（按播放时间倒序）
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED*******REMOVED***FROM***REMOVED***user_recent_play***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}***REMOVED***ORDER***REMOVED***BY***REMOVED***play_time***REMOVED***DESC***REMOVED***LIMIT***REMOVED***#{limit}")
***REMOVED******REMOVED******REMOVED******REMOVED***List<UserRecentPlay>***REMOVED***findByUserIdOrderByPlayTimeDesc(@Param("userId")***REMOVED***Long***REMOVED***userId,***REMOVED***@Param("limit")***REMOVED***Integer***REMOVED***limit);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***根据用户ID和音乐ID获取播放记录
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED*******REMOVED***FROM***REMOVED***user_recent_play***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}***REMOVED***AND***REMOVED***music_id***REMOVED***=***REMOVED***#{musicId}")
***REMOVED******REMOVED******REMOVED******REMOVED***UserRecentPlay***REMOVED***findByUserIdAndMusicId(@Param("userId")***REMOVED***Long***REMOVED***userId,***REMOVED***@Param("musicId")***REMOVED***String***REMOVED***musicId);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***更新播放进度
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Update("UPDATE***REMOVED***user_recent_play***REMOVED***SET***REMOVED***play_duration***REMOVED***=***REMOVED***#{playDuration},***REMOVED***play_progress***REMOVED***=***REMOVED***#{playProgress},***REMOVED***play_time***REMOVED***=***REMOVED***CURRENT_TIMESTAMP,***REMOVED***update_time***REMOVED***=***REMOVED***CURRENT_TIMESTAMP***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}***REMOVED***AND***REMOVED***music_id***REMOVED***=***REMOVED***#{musicId}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***updatePlayProgress(@Param("userId")***REMOVED***Long***REMOVED***userId,***REMOVED***@Param("musicId")***REMOVED***String***REMOVED***musicId,***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@Param("playDuration")***REMOVED***Integer***REMOVED***playDuration,***REMOVED***@Param("playProgress")***REMOVED***java.math.BigDecimal***REMOVED***playProgress);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***删除指定用户的最近播放记录
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Delete("DELETE***REMOVED***FROM***REMOVED***user_recent_play***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}***REMOVED***AND***REMOVED***music_id***REMOVED***=***REMOVED***#{musicId}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***deleteByUserIdAndMusicId(@Param("userId")***REMOVED***Long***REMOVED***userId,***REMOVED***@Param("musicId")***REMOVED***String***REMOVED***musicId);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***清空用户的最近播放记录
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Delete("DELETE***REMOVED***FROM***REMOVED***user_recent_play***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***deleteByUserId(@Param("userId")***REMOVED***Long***REMOVED***userId);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***获取用户最近播放记录数量
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED***COUNT(*)***REMOVED***FROM***REMOVED***user_recent_play***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***countByUserId(@Param("userId")***REMOVED***Long***REMOVED***userId);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***删除用户最旧的播放记录（保留最新的N条）
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Delete("DELETE***REMOVED***FROM***REMOVED***user_recent_play***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}***REMOVED***AND***REMOVED***id***REMOVED***NOT***REMOVED***IN***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"(SELECT***REMOVED***id***REMOVED***FROM***REMOVED***(SELECT***REMOVED***id***REMOVED***FROM***REMOVED***user_recent_play***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}***REMOVED***ORDER***REMOVED***BY***REMOVED***play_time***REMOVED***DESC***REMOVED***LIMIT***REMOVED***#{keepCount})***REMOVED***AS***REMOVED***temp)")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***deleteOldRecords(@Param("userId")***REMOVED***Long***REMOVED***userId,***REMOVED***@Param("keepCount")***REMOVED***Integer***REMOVED***keepCount);
}
