package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.entity.UserPlayQueue;

import java.util.List;

/**
 * 用户播放队列数据访问层
 */
@Mapper
public interface UserPlayQueueMapper {

    /**
     * 根据用户ID查询播放队列
     */
    @Select("SELECT * FROM user_play_queue WHERE user_id = #{userId} AND status = 1 ORDER BY sort_order ASC, add_time ASC")
    List<UserPlayQueue> findByUserId(@Param("userId") Long userId);

    /**
     * 插入播放队列项
     */
    @Insert("INSERT INTO user_play_queue (user_id, music_id, music_mid, music_song, music_singer, " +
            "music_album, music_cover, music_url, sort_order, add_time, status) " +
            "VALUES (#{userId}, #{musicId}, #{musicMid}, #{musicSong}, #{musicSinger}, " +
            "#{musicAlbum}, #{musicCover}, #{musicUrl}, #{sortOrder}, #{addTime}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(UserPlayQueue queueItem);

    /**
     * 根据用户ID和音乐ID删除播放队列项
     */
    @Delete("DELETE FROM user_play_queue WHERE user_id = #{userId} AND music_id = #{musicId}")
    int deleteByUserIdAndMusicId(@Param("userId") Long userId, @Param("musicId") String musicId);

    /**
     * 清空用户播放队列
     */
    @Delete("DELETE FROM user_play_queue WHERE user_id = #{userId}")
    int clearByUserId(@Param("userId") Long userId);

    /**
     * 更新排序顺序
     */
    @Update("UPDATE user_play_queue SET sort_order = #{sortOrder} WHERE id = #{id}")
    int updateSortOrder(@Param("id") Long id, @Param("sortOrder") Integer sortOrder);

    /**
     * 检查音乐是否在播放队列中
     */
    @Select("SELECT COUNT(*) FROM user_play_queue WHERE user_id = #{userId} AND music_id = #{musicId} AND status = 1")
    int checkMusicInQueue(@Param("userId") Long userId, @Param("musicId") String musicId);

    /**
     * 获取用户播放队列的最大排序值
     */
    @Select("SELECT COALESCE(MAX(sort_order), 0) FROM user_play_queue WHERE user_id = #{userId} AND status = 1")
    int getMaxSortOrder(@Param("userId") Long userId);

    /**
     * 批量插入播放队列项
     */
    @Insert("<script>" +
            "INSERT INTO user_play_queue (user_id, music_id, music_mid, music_song, music_singer, " +
            "music_album, music_cover, music_url, sort_order, add_time, status) VALUES " +
            "<foreach collection='queueItems' item='item' separator=','>" +
            "(#{item.userId}, #{item.musicId}, #{item.musicMid}, #{item.musicSong}, #{item.musicSinger}, " +
            "#{item.musicAlbum}, #{item.musicCover}, #{item.musicUrl}, #{item.sortOrder}, #{item.addTime}, #{item.status})" +
            "</foreach>" +
            "</script>")
    int batchInsert(@Param("queueItems") List<UserPlayQueue> queueItems);
}
