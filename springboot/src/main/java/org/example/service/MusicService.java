package org.example.service;

import org.example.entity.Music;
import org.example.mapper.MusicFavoriteStatsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    private final MusicFavoriteStatsMapper musicFavoriteStatsMapper;

    public MusicService(MusicFavoriteStatsMapper musicFavoriteStatsMapper) {
        this.musicFavoriteStatsMapper = musicFavoriteStatsMapper;
    }

    public List<Music> getHotFromStats(int limit) {
        return musicFavoriteStatsMapper.selectHotAllTime(limit);
    }
}



