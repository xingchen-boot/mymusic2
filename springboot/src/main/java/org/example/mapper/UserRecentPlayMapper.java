package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.entity.UserRecentPlay;

import java.util.List;

/**
 * 用户最近播放Mapper接口
 */
@Mapper
public interface UserRecentPlayMapper {

    /**
     * 插入或更新最近播放记录
     */
    @Insert("INSERT INTO user_recent_play (user_id, music_id, music_mid, music_song, music_singer, music_album, music_cover, music_time, music_pay, play_duration, play_progress) " +
            "VALUES (#{userId}, #{musicId}, #{musicMid}, #{musicSong}, #{musicSinger}, #{musicAlbum}, #{musicCover}, #{musicTime}, #{musicPay}, #{playDuration}, #{playProgress}) " +
            "ON DUPLICATE KEY UPDATE " +
            "music_mid = VALUES(music_mid), " +
            "music_song = VALUES(music_song), " +
            "music_singer = VALUES(music_singer), " +
            "music_album = VALUES(music_album), " +
            "music_cover = VALUES(music_cover), " +
            "music_time = VALUES(music_time), " +
            "music_pay = VALUES(music_pay), " +
            "play_time = CURRENT_TIMESTAMP, " +
            "play_duration = VALUES(play_duration), " +
            "play_progress = VALUES(play_progress), " +
            "update_time = CURRENT_TIMESTAMP")
    int insertOrUpdate(UserRecentPlay userRecentPlay);

    /**
     * 根据用户ID获取最近播放列表（按播放时间倒序）
     */
    @Select("SELECT * FROM user_recent_play WHERE user_id = #{userId} ORDER BY play_time DESC LIMIT #{limit}")
    List<UserRecentPlay> findByUserIdOrderByPlayTimeDesc(@Param("userId") Long userId, @Param("limit") Integer limit);

    /**
     * 根据用户ID和音乐ID获取播放记录
     */
    @Select("SELECT * FROM user_recent_play WHERE user_id = #{userId} AND music_id = #{musicId}")
    UserRecentPlay findByUserIdAndMusicId(@Param("userId") Long userId, @Param("musicId") String musicId);

    /**
     * 更新播放进度
     */
    @Update("UPDATE user_recent_play SET play_duration = #{playDuration}, play_progress = #{playProgress}, play_time = CURRENT_TIMESTAMP, update_time = CURRENT_TIMESTAMP " +
            "WHERE user_id = #{userId} AND music_id = #{musicId}")
    int updatePlayProgress(@Param("userId") Long userId, @Param("musicId") String musicId, 
                          @Param("playDuration") Integer playDuration, @Param("playProgress") java.math.BigDecimal playProgress);

    /**
     * 删除指定用户的最近播放记录
     */
    @Delete("DELETE FROM user_recent_play WHERE user_id = #{userId} AND music_id = #{musicId}")
    int deleteByUserIdAndMusicId(@Param("userId") Long userId, @Param("musicId") String musicId);

    /**
     * 清空用户的最近播放记录
     */
    @Delete("DELETE FROM user_recent_play WHERE user_id = #{userId}")
    int deleteByUserId(@Param("userId") Long userId);

    /**
     * 获取用户最近播放记录数量
     */
    @Select("SELECT COUNT(*) FROM user_recent_play WHERE user_id = #{userId}")
    int countByUserId(@Param("userId") Long userId);

    /**
     * 删除用户最旧的播放记录（保留最新的N条）
     */
    @Delete("DELETE FROM user_recent_play WHERE user_id = #{userId} AND id NOT IN " +
            "(SELECT id FROM (SELECT id FROM user_recent_play WHERE user_id = #{userId} ORDER BY play_time DESC LIMIT #{keepCount}) AS temp)")
    int deleteOldRecords(@Param("userId") Long userId, @Param("keepCount") Integer keepCount);
}
