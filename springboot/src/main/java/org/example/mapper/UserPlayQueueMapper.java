package***REMOVED***org.example.mapper;

import***REMOVED***org.apache.ibatis.annotations.*;
import***REMOVED***org.example.entity.UserPlayQueue;

import***REMOVED***java.util.List;

/**
***REMOVED*******REMOVED***用户播放队列数据访问层
***REMOVED****/
@Mapper
public***REMOVED***interface***REMOVED***UserPlayQueueMapper***REMOVED***{

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***根据用户ID查询播放队列
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED*******REMOVED***FROM***REMOVED***user_play_queue***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}***REMOVED***AND***REMOVED***status***REMOVED***=***REMOVED***1***REMOVED***ORDER***REMOVED***BY***REMOVED***sort_order***REMOVED***ASC,***REMOVED***add_time***REMOVED***ASC")
***REMOVED******REMOVED******REMOVED******REMOVED***List<UserPlayQueue>***REMOVED***findByUserId(@Param("userId")***REMOVED***Long***REMOVED***userId);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***插入播放队列项
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Insert("INSERT***REMOVED***INTO***REMOVED***user_play_queue***REMOVED***(user_id,***REMOVED***music_id,***REMOVED***music_mid,***REMOVED***music_song,***REMOVED***music_singer,***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"music_album,***REMOVED***music_cover,***REMOVED***music_url,***REMOVED***sort_order,***REMOVED***add_time,***REMOVED***status)***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"VALUES***REMOVED***(#{userId},***REMOVED***#{musicId},***REMOVED***#{musicMid},***REMOVED***#{musicSong},***REMOVED***#{musicSinger},***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"#{musicAlbum},***REMOVED***#{musicCover},***REMOVED***#{musicUrl},***REMOVED***#{sortOrder},***REMOVED***#{addTime},***REMOVED***#{status})")
***REMOVED******REMOVED******REMOVED******REMOVED***@Options(useGeneratedKeys***REMOVED***=***REMOVED***true,***REMOVED***keyProperty***REMOVED***=***REMOVED***"id")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***insert(UserPlayQueue***REMOVED***queueItem);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***根据用户ID和音乐ID删除播放队列项
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Delete("DELETE***REMOVED***FROM***REMOVED***user_play_queue***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}***REMOVED***AND***REMOVED***music_id***REMOVED***=***REMOVED***#{musicId}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***deleteByUserIdAndMusicId(@Param("userId")***REMOVED***Long***REMOVED***userId,***REMOVED***@Param("musicId")***REMOVED***String***REMOVED***musicId);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***清空用户播放队列
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Delete("DELETE***REMOVED***FROM***REMOVED***user_play_queue***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***clearByUserId(@Param("userId")***REMOVED***Long***REMOVED***userId);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***更新排序顺序
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Update("UPDATE***REMOVED***user_play_queue***REMOVED***SET***REMOVED***sort_order***REMOVED***=***REMOVED***#{sortOrder}***REMOVED***WHERE***REMOVED***id***REMOVED***=***REMOVED***#{id}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***updateSortOrder(@Param("id")***REMOVED***Long***REMOVED***id,***REMOVED***@Param("sortOrder")***REMOVED***Integer***REMOVED***sortOrder);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***检查音乐是否在播放队列中
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED***COUNT(*)***REMOVED***FROM***REMOVED***user_play_queue***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}***REMOVED***AND***REMOVED***music_id***REMOVED***=***REMOVED***#{musicId}***REMOVED***AND***REMOVED***status***REMOVED***=***REMOVED***1")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***checkMusicInQueue(@Param("userId")***REMOVED***Long***REMOVED***userId,***REMOVED***@Param("musicId")***REMOVED***String***REMOVED***musicId);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***获取用户播放队列的最大排序值
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED***COALESCE(MAX(sort_order),***REMOVED***0)***REMOVED***FROM***REMOVED***user_play_queue***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}***REMOVED***AND***REMOVED***status***REMOVED***=***REMOVED***1")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***getMaxSortOrder(@Param("userId")***REMOVED***Long***REMOVED***userId);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***批量插入播放队列项
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Insert("<script>"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"INSERT***REMOVED***INTO***REMOVED***user_play_queue***REMOVED***(user_id,***REMOVED***music_id,***REMOVED***music_mid,***REMOVED***music_song,***REMOVED***music_singer,***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"music_album,***REMOVED***music_cover,***REMOVED***music_url,***REMOVED***sort_order,***REMOVED***add_time,***REMOVED***status)***REMOVED***VALUES***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"<foreach***REMOVED***collection='queueItems'***REMOVED***item='item'***REMOVED***separator=','>"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"(#{item.userId},***REMOVED***#{item.musicId},***REMOVED***#{item.musicMid},***REMOVED***#{item.musicSong},***REMOVED***#{item.musicSinger},***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"#{item.musicAlbum},***REMOVED***#{item.musicCover},***REMOVED***#{item.musicUrl},***REMOVED***#{item.sortOrder},***REMOVED***#{item.addTime},***REMOVED***#{item.status})"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"</foreach>"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"</script>")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***batchInsert(@Param("queueItems")***REMOVED***List<UserPlayQueue>***REMOVED***queueItems);
}
