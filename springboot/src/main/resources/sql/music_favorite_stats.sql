-- 全局用户收藏统计表
CREATE TABLE IF NOT EXISTS `music_favorite_stats` (
    `music_id` VARCHAR(255) NOT NULL COMMENT '音乐ID',
    `music_song` VARCHAR(255) NOT NULL COMMENT '歌曲名',
    `music_singer` VARCHAR(255) COMMENT '歌手',
    `music_album` VARCHAR(255) COMMENT '专辑',
    `music_cover` VARCHAR(500) COMMENT '封面',
    `favorite_count` BIGINT NOT NULL DEFAULT 0 COMMENT '全局收藏次数',
    `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`music_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='全局收藏统计表';

CREATE INDEX idx_mfs_count ON `music_favorite_stats` (`favorite_count` DESC, `updated_at` DESC);


