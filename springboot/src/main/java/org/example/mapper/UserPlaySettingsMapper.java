package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.entity.UserPlaySettings;

/**
 * 用户播放设置Mapper接口
 */
@Mapper
public interface UserPlaySettingsMapper {

    /**
     * 根据用户ID查询播放设置
     */
    @Select("SELECT * FROM user_play_settings WHERE user_id = #{userId}")
    UserPlaySettings findByUserId(@Param("userId") Long userId);

    /**
     * 插入用户播放设置
     */
    @Insert("INSERT INTO user_play_settings (user_id, volume, is_muted, play_mode) " +
            "VALUES (#{userId}, #{volume}, #{isMuted}, #{playMode})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(UserPlaySettings settings);

    /**
     * 更新用户播放设置
     */
    @Update("UPDATE user_play_settings SET volume = #{volume}, is_muted = #{isMuted}, " +
            "play_mode = #{playMode}, current_music_id = #{currentMusicId}, " +
            "current_music_name = #{currentMusicName}, current_music_artist = #{currentMusicArtist}, " +
            "current_music_cover = #{currentMusicCover}, current_music_url = #{currentMusicUrl}, " +
            "play_progress = #{playProgress}, play_time = #{playTime}, is_playing = #{isPlaying}, " +
            "update_time = CURRENT_TIMESTAMP WHERE user_id = #{userId}")
    int updateByUserId(UserPlaySettings settings);

    /**
     * 插入或更新用户播放设置
     */
    @Insert("INSERT INTO user_play_settings (user_id, volume, is_muted, play_mode, " +
            "current_music_id, current_music_name, current_music_artist, current_music_cover, " +
            "current_music_url, play_progress, play_time, is_playing) " +
            "VALUES (#{userId}, #{volume}, #{isMuted}, #{playMode}, #{currentMusicId}, " +
            "#{currentMusicName}, #{currentMusicArtist}, #{currentMusicCover}, #{currentMusicUrl}, " +
            "#{playProgress}, #{playTime}, #{isPlaying}) " +
            "ON DUPLICATE KEY UPDATE volume = #{volume}, is_muted = #{isMuted}, " +
            "play_mode = #{playMode}, current_music_id = #{currentMusicId}, " +
            "current_music_name = #{currentMusicName}, current_music_artist = #{currentMusicArtist}, " +
            "current_music_cover = #{currentMusicCover}, current_music_url = #{currentMusicUrl}, " +
            "play_progress = #{playProgress}, play_time = #{playTime}, is_playing = #{isPlaying}, " +
            "update_time = CURRENT_TIMESTAMP")
    int insertOrUpdate(UserPlaySettings settings);

    /**
     * 删除用户播放设置
     */
    @Delete("DELETE FROM user_play_settings WHERE user_id = #{userId}")
    int deleteByUserId(@Param("userId") Long userId);
}
