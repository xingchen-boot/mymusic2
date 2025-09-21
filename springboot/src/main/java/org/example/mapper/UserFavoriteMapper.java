package***REMOVED***org.example.mapper;

import***REMOVED***org.apache.ibatis.annotations.*;
import***REMOVED***org.example.entity.UserFavorite;

import***REMOVED***java.util.List;

/**
***REMOVED*******REMOVED***用户收藏音乐Mapper接口
***REMOVED****/
@Mapper
public***REMOVED***interface***REMOVED***UserFavoriteMapper***REMOVED***{

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***根据用户ID查询收藏列表
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED*******REMOVED***FROM***REMOVED***user_favorites***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}***REMOVED***ORDER***REMOVED***BY***REMOVED***create_time***REMOVED***DESC")
***REMOVED******REMOVED******REMOVED******REMOVED***List<UserFavorite>***REMOVED***findByUserId(@Param("userId")***REMOVED***Long***REMOVED***userId);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***根据用户ID和音乐ID查询收藏记录
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED*******REMOVED***FROM***REMOVED***user_favorites***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}***REMOVED***AND***REMOVED***music_id***REMOVED***=***REMOVED***#{musicId}")
***REMOVED******REMOVED******REMOVED******REMOVED***UserFavorite***REMOVED***findByUserIdAndMusicId(@Param("userId")***REMOVED***Long***REMOVED***userId,***REMOVED***@Param("musicId")***REMOVED***String***REMOVED***musicId);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***添加收藏
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Insert("INSERT***REMOVED***INTO***REMOVED***user_favorites***REMOVED***(user_id,***REMOVED***music_id,***REMOVED***music_mid,***REMOVED***music_song,***REMOVED***music_singer,***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"music_album,***REMOVED***music_cover,***REMOVED***music_time,***REMOVED***music_pay)***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"VALUES***REMOVED***(#{userId},***REMOVED***#{musicId},***REMOVED***#{musicMid},***REMOVED***#{musicSong},***REMOVED***#{musicSinger},***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"#{musicAlbum},***REMOVED***#{musicCover},***REMOVED***#{musicTime},***REMOVED***#{musicPay})")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***insert(UserFavorite***REMOVED***userFavorite);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***删除收藏
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Delete("DELETE***REMOVED***FROM***REMOVED***user_favorites***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}***REMOVED***AND***REMOVED***music_id***REMOVED***=***REMOVED***#{musicId}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***deleteByUserIdAndMusicId(@Param("userId")***REMOVED***Long***REMOVED***userId,***REMOVED***@Param("musicId")***REMOVED***String***REMOVED***musicId);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***检查是否已收藏
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED***COUNT(*)***REMOVED***FROM***REMOVED***user_favorites***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}***REMOVED***AND***REMOVED***music_id***REMOVED***=***REMOVED***#{musicId}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***checkFavorite(@Param("userId")***REMOVED***Long***REMOVED***userId,***REMOVED***@Param("musicId")***REMOVED***String***REMOVED***musicId);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***获取用户收藏数量
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED***COUNT(*)***REMOVED***FROM***REMOVED***user_favorites***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***getFavoriteCount(@Param("userId")***REMOVED***Long***REMOVED***userId);
}
