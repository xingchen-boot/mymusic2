package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.entity.Music;

import java.util.List;

@Mapper
public interface MusicFavoriteStatsMapper {

    @Insert("INSERT INTO music_favorite_stats (music_id, music_song, music_singer, music_album, music_cover, favorite_count) " +
            "VALUES (#{musicId}, #{song}, #{singer}, #{album}, #{cover}, 1) " +
            "ON DUPLICATE KEY UPDATE favorite_count = favorite_count + 1, music_song = VALUES(music_song), music_singer = VALUES(music_singer), music_album = VALUES(music_album), music_cover = VALUES(music_cover)")
    int incrementFavorite(@Param("musicId") String musicId,
                          @Param("song") String song,
                          @Param("singer") String singer,
                          @Param("album") String album,
                          @Param("cover") String cover);

    @Update("UPDATE music_favorite_stats SET favorite_count = GREATEST(favorite_count - 1, 0) WHERE music_id = #{musicId}")
    int decrementFavorite(@Param("musicId") String musicId);

    @Select("SELECT CAST(music_id AS SIGNED) AS id, music_song AS song, music_singer AS singer, music_album AS album, music_cover AS cover " +
            "FROM music_favorite_stats ORDER BY favorite_count DESC, updated_at DESC LIMIT #{limit}")
    List<Music> selectHotAllTime(@Param("limit") int limit);
}



