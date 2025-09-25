package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.entity.UserPlaylist;
import org.example.entity.PlaylistMusic;

import java.util.List;

/**
 * 用户播放列表数据访问层
 */
@Mapper
public interface UserPlaylistMapper {

    /**
     * 根据用户ID查询播放列表
     */
    @Select("SELECT * FROM user_playlist WHERE user_id = #{userId} AND status = 1 ORDER BY create_time DESC")
    List<UserPlaylist> findByUserId(@Param("userId") Long userId);

    /**
     * 根据ID查询播放列表
     */
    @Select("SELECT * FROM user_playlist WHERE id = #{id} AND status = 1")
    UserPlaylist findById(@Param("id") Long id);

    /**
     * 插入播放列表
     */
    @Insert("INSERT INTO user_playlist (user_id, name, description, cover_url, create_time, update_time, status) " +
            "VALUES (#{userId}, #{name}, #{description}, #{coverUrl}, #{createTime}, #{updateTime}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(UserPlaylist playlist);

    /**
     * 更新播放列表信息
     */
    @Update("UPDATE user_playlist SET name = #{name}, description = #{description}, cover_url = #{coverUrl}, " +
            "update_time = #{updateTime} WHERE id = #{id}")
    int update(UserPlaylist playlist);

    /**
     * 删除播放列表（软删除）
     */
    @Update("UPDATE user_playlist SET status = 0, update_time = #{updateTime} WHERE id = #{id}")
    int deleteById(@Param("id") Long id, @Param("updateTime") java.time.LocalDateTime updateTime);

    /**
     * 检查播放列表名称是否存在
     */
    @Select("SELECT COUNT(*) FROM user_playlist WHERE user_id = #{userId} AND name = #{name} AND status = 1")
    int checkNameExists(@Param("userId") Long userId, @Param("name") String name);

    /**
     * 添加音乐到播放列表
     */
    @Insert("INSERT INTO playlist_music (playlist_id, music_id, music_name, artist_name, album_name, " +
            "duration, music_url, cover_url, add_time, sort_order) " +
            "VALUES (#{playlistId}, #{musicId}, #{musicName}, #{artistName}, #{albumName}, " +
            "#{duration}, #{musicUrl}, #{coverUrl}, #{addTime}, #{sortOrder})")
    int addMusicToPlaylist(PlaylistMusic music);

    /**
     * 从播放列表移除音乐
     */
    @Delete("DELETE FROM playlist_music WHERE playlist_id = #{playlistId} AND music_id = #{musicId}")
    int removeMusicFromPlaylist(@Param("playlistId") Long playlistId, @Param("musicId") String musicId);

    /**
     * 查询播放列表中的音乐
     */
    @Select("SELECT * FROM playlist_music WHERE playlist_id = #{playlistId} ORDER BY sort_order ASC, add_time ASC")
    List<PlaylistMusic> findMusicByPlaylistId(@Param("playlistId") Long playlistId);

    /**
     * 更新音乐排序
     */
    @Update("UPDATE playlist_music SET sort_order = #{sortOrder} WHERE id = #{id}")
    int updateMusicSort(@Param("id") Long id, @Param("sortOrder") Integer sortOrder);

    /**
     * 清空播放列表
     */
    @Delete("DELETE FROM playlist_music WHERE playlist_id = #{playlistId}")
    int clearPlaylist(@Param("playlistId") Long playlistId);

    /**
     * 检查音乐是否在播放列表中
     */
    @Select("SELECT COUNT(*) FROM playlist_music WHERE playlist_id = #{playlistId} AND music_id = #{musicId}")
    int checkMusicInPlaylist(@Param("playlistId") Long playlistId, @Param("musicId") String musicId);
}

