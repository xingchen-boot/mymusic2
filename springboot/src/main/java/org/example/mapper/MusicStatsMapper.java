package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.entity.Music;

import java.util.List;

/**
 * 热门音乐统计（基于收藏表）
 */
@Mapper
public interface MusicStatsMapper {

    // rollback: keep mapper empty or remove file if unused
}


