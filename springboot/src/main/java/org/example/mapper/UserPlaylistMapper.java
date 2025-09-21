package***REMOVED***org.example.mapper;

import***REMOVED***org.apache.ibatis.annotations.*;
import***REMOVED***org.example.entity.UserPlaylist;
import***REMOVED***org.example.entity.PlaylistMusic;

import***REMOVED***java.util.List;

/**
***REMOVED*******REMOVED***用户播放列表数据访问层
***REMOVED****/
@Mapper
public***REMOVED***interface***REMOVED***UserPlaylistMapper***REMOVED***{

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***根据用户ID查询播放列表
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED*******REMOVED***FROM***REMOVED***user_playlist***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}***REMOVED***AND***REMOVED***status***REMOVED***=***REMOVED***1***REMOVED***ORDER***REMOVED***BY***REMOVED***create_time***REMOVED***DESC")
***REMOVED******REMOVED******REMOVED******REMOVED***List<UserPlaylist>***REMOVED***findByUserId(@Param("userId")***REMOVED***Long***REMOVED***userId);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***根据ID查询播放列表
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED*******REMOVED***FROM***REMOVED***user_playlist***REMOVED***WHERE***REMOVED***id***REMOVED***=***REMOVED***#{id}***REMOVED***AND***REMOVED***status***REMOVED***=***REMOVED***1")
***REMOVED******REMOVED******REMOVED******REMOVED***UserPlaylist***REMOVED***findById(@Param("id")***REMOVED***Long***REMOVED***id);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***插入播放列表
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Insert("INSERT***REMOVED***INTO***REMOVED***user_playlist***REMOVED***(user_id,***REMOVED***name,***REMOVED***description,***REMOVED***cover_url,***REMOVED***create_time,***REMOVED***update_time,***REMOVED***status)***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"VALUES***REMOVED***(#{userId},***REMOVED***#{name},***REMOVED***#{description},***REMOVED***#{coverUrl},***REMOVED***#{createTime},***REMOVED***#{updateTime},***REMOVED***#{status})")
***REMOVED******REMOVED******REMOVED******REMOVED***@Options(useGeneratedKeys***REMOVED***=***REMOVED***true,***REMOVED***keyProperty***REMOVED***=***REMOVED***"id")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***insert(UserPlaylist***REMOVED***playlist);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***更新播放列表信息
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Update("UPDATE***REMOVED***user_playlist***REMOVED***SET***REMOVED***name***REMOVED***=***REMOVED***#{name},***REMOVED***description***REMOVED***=***REMOVED***#{description},***REMOVED***cover_url***REMOVED***=***REMOVED***#{coverUrl},***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"update_time***REMOVED***=***REMOVED***#{updateTime}***REMOVED***WHERE***REMOVED***id***REMOVED***=***REMOVED***#{id}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***update(UserPlaylist***REMOVED***playlist);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***删除播放列表（软删除）
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Update("UPDATE***REMOVED***user_playlist***REMOVED***SET***REMOVED***status***REMOVED***=***REMOVED***0,***REMOVED***update_time***REMOVED***=***REMOVED***#{updateTime}***REMOVED***WHERE***REMOVED***id***REMOVED***=***REMOVED***#{id}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***deleteById(@Param("id")***REMOVED***Long***REMOVED***id,***REMOVED***@Param("updateTime")***REMOVED***java.time.LocalDateTime***REMOVED***updateTime);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***检查播放列表名称是否存在
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED***COUNT(*)***REMOVED***FROM***REMOVED***user_playlist***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}***REMOVED***AND***REMOVED***name***REMOVED***=***REMOVED***#{name}***REMOVED***AND***REMOVED***status***REMOVED***=***REMOVED***1")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***checkNameExists(@Param("userId")***REMOVED***Long***REMOVED***userId,***REMOVED***@Param("name")***REMOVED***String***REMOVED***name);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***添加音乐到播放列表
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Insert("INSERT***REMOVED***INTO***REMOVED***playlist_music***REMOVED***(playlist_id,***REMOVED***music_id,***REMOVED***music_name,***REMOVED***artist_name,***REMOVED***album_name,***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"duration,***REMOVED***music_url,***REMOVED***cover_url,***REMOVED***add_time,***REMOVED***sort_order)***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"VALUES***REMOVED***(#{playlistId},***REMOVED***#{musicId},***REMOVED***#{musicName},***REMOVED***#{artistName},***REMOVED***#{albumName},***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"#{duration},***REMOVED***#{musicUrl},***REMOVED***#{coverUrl},***REMOVED***#{addTime},***REMOVED***#{sortOrder})")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***addMusicToPlaylist(PlaylistMusic***REMOVED***music);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***从播放列表移除音乐
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Delete("DELETE***REMOVED***FROM***REMOVED***playlist_music***REMOVED***WHERE***REMOVED***playlist_id***REMOVED***=***REMOVED***#{playlistId}***REMOVED***AND***REMOVED***music_id***REMOVED***=***REMOVED***#{musicId}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***removeMusicFromPlaylist(@Param("playlistId")***REMOVED***Long***REMOVED***playlistId,***REMOVED***@Param("musicId")***REMOVED***String***REMOVED***musicId);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***查询播放列表中的音乐
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED*******REMOVED***FROM***REMOVED***playlist_music***REMOVED***WHERE***REMOVED***playlist_id***REMOVED***=***REMOVED***#{playlistId}***REMOVED***ORDER***REMOVED***BY***REMOVED***sort_order***REMOVED***ASC,***REMOVED***add_time***REMOVED***ASC")
***REMOVED******REMOVED******REMOVED******REMOVED***List<PlaylistMusic>***REMOVED***findMusicByPlaylistId(@Param("playlistId")***REMOVED***Long***REMOVED***playlistId);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***更新音乐排序
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Update("UPDATE***REMOVED***playlist_music***REMOVED***SET***REMOVED***sort_order***REMOVED***=***REMOVED***#{sortOrder}***REMOVED***WHERE***REMOVED***id***REMOVED***=***REMOVED***#{id}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***updateMusicSort(@Param("id")***REMOVED***Long***REMOVED***id,***REMOVED***@Param("sortOrder")***REMOVED***Integer***REMOVED***sortOrder);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***清空播放列表
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Delete("DELETE***REMOVED***FROM***REMOVED***playlist_music***REMOVED***WHERE***REMOVED***playlist_id***REMOVED***=***REMOVED***#{playlistId}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***clearPlaylist(@Param("playlistId")***REMOVED***Long***REMOVED***playlistId);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***检查音乐是否在播放列表中
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED***COUNT(*)***REMOVED***FROM***REMOVED***playlist_music***REMOVED***WHERE***REMOVED***playlist_id***REMOVED***=***REMOVED***#{playlistId}***REMOVED***AND***REMOVED***music_id***REMOVED***=***REMOVED***#{musicId}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***checkMusicInPlaylist(@Param("playlistId")***REMOVED***Long***REMOVED***playlistId,***REMOVED***@Param("musicId")***REMOVED***String***REMOVED***musicId);
}

