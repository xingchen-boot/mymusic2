package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.entity.UserFavorite;

import java.util.List;

/**
 * 用户收藏音乐Mapper接口
 */
@Mapper
public interface UserFavoriteMapper {

    /**
     * 根据用户ID查询收藏列表
     */
    @Select("SELECT * FROM user_favorites WHERE user_id = #{userId} ORDER BY create_time DESC")
    List<UserFavorite> findByUserId(@Param("userId") Long userId);

    /**
     * 根据用户ID和音乐ID查询收藏记录
     */
    @Select("SELECT * FROM user_favorites WHERE user_id = #{userId} AND music_id = #{musicId}")
    UserFavorite findByUserIdAndMusicId(@Param("userId") Long userId, @Param("musicId") String musicId);

    /**
     * 添加收藏
     */
    @Insert("INSERT INTO user_favorites (user_id, music_id, music_mid, music_song, music_singer, " +
            "music_album, music_cover, music_time, music_pay) " +
            "VALUES (#{userId}, #{musicId}, #{musicMid}, #{musicSong}, #{musicSinger}, " +
            "#{musicAlbum}, #{musicCover}, #{musicTime}, #{musicPay})")
    int insert(UserFavorite userFavorite);

    /**
     * 删除收藏
     */
    @Delete("DELETE FROM user_favorites WHERE user_id = #{userId} AND music_id = #{musicId}")
    int deleteByUserIdAndMusicId(@Param("userId") Long userId, @Param("musicId") String musicId);

    /**
     * 检查是否已收藏
     */
    @Select("SELECT COUNT(*) FROM user_favorites WHERE user_id = #{userId} AND music_id = #{musicId}")
    int checkFavorite(@Param("userId") Long userId, @Param("musicId") String musicId);

    /**
     * 获取用户收藏数量
     */
    @Select("SELECT COUNT(*) FROM user_favorites WHERE user_id = #{userId}")
    int getFavoriteCount(@Param("userId") Long userId);
}
