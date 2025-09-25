package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.entity.Playlist;
import org.example.entity.PlaylistMusic;

import java.util.List;

/**
 * 播放列表Mapper接口
 */
@Mapper
public interface PlaylistMapper {
    
    // 播放列表相关操作
    @Insert("INSERT INTO playlists (name, description, cover, user_id) VALUES (#{name}, #{description}, #{cover}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertPlaylist(Playlist playlist);
    
    @Select("SELECT * FROM playlists WHERE id = #{id}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "description", column = "description"),
        @Result(property = "cover", column = "cover"),
        @Result(property = "userId", column = "user_id"),
        @Result(property = "createdAt", column = "created_at"),
        @Result(property = "updatedAt", column = "updated_at")
    })
    Playlist selectPlaylistById(Long id);
    
    @Select("SELECT * FROM playlists ORDER BY created_at DESC")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "description", column = "description"),
        @Result(property = "cover", column = "cover"),
        @Result(property = "userId", column = "user_id"),
        @Result(property = "createdAt", column = "created_at"),
        @Result(property = "updatedAt", column = "updated_at")
    })
    List<Playlist> selectAllPlaylists();
    
    @Update("UPDATE playlists SET name = #{name}, description = #{description}, cover = #{cover} WHERE id = #{id}")
    int updatePlaylist(Playlist playlist);
    
    @Delete("DELETE FROM playlists WHERE id = #{id}")
    int deletePlaylist(Long id);
    
    // 播放列表音乐相关操作
    @Insert("INSERT INTO playlist_music (playlist_id, music_id, music_mid, music_song, music_singer, music_album, music_cover, music_url, sort_order) " +
            "VALUES (#{playlistId}, #{musicId}, #{musicMid}, #{musicSong}, #{musicSinger}, #{musicAlbum}, #{musicCover}, #{musicUrl}, #{sortOrder})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertPlaylistMusic(PlaylistMusic playlistMusic);
    
    @Select("SELECT * FROM playlist_music WHERE playlist_id = #{playlistId} ORDER BY sort_order ASC, added_at ASC")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "playlistId", column = "playlist_id"),
        @Result(property = "musicId", column = "music_id"),
        @Result(property = "musicMid", column = "music_mid"),
        @Result(property = "musicSong", column = "music_song"),
        @Result(property = "musicSinger", column = "music_singer"),
        @Result(property = "musicAlbum", column = "music_album"),
        @Result(property = "musicCover", column = "music_cover"),
        @Result(property = "musicUrl", column = "music_url"),
        @Result(property = "sortOrder", column = "sort_order"),
        @Result(property = "addedAt", column = "added_at")
    })
    List<PlaylistMusic> selectMusicByPlaylistId(Long playlistId);
    
    @Select("SELECT COUNT(*) FROM playlist_music WHERE playlist_id = #{playlistId}")
    int countMusicByPlaylistId(Long playlistId);
    
    @Delete("DELETE FROM playlist_music WHERE playlist_id = #{playlistId} AND music_id = #{musicId}")
    int deleteMusicFromPlaylist(@Param("playlistId") Long playlistId, @Param("musicId") Long musicId);
    
    @Delete("DELETE FROM playlist_music WHERE playlist_id = #{playlistId}")
    int deleteAllMusicFromPlaylist(Long playlistId);
    
    @Select("SELECT EXISTS(SELECT 1 FROM playlist_music WHERE playlist_id = #{playlistId} AND music_id = #{musicId})")
    boolean existsMusicInPlaylist(@Param("playlistId") Long playlistId, @Param("musicId") Long musicId);
}
