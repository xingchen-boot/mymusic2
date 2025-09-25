-- 创建用户最近播放表
CREATE TABLE IF NOT EXISTS `user_recent_play` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    `user_id` BIGINT NOT NULL COMMENT '用户ID',
    `music_id` VARCHAR(100) NOT NULL COMMENT '音乐ID',
    `music_mid` VARCHAR(100) COMMENT '音乐MID',
    `music_song` VARCHAR(200) NOT NULL COMMENT '歌曲名称',
    `music_singer` VARCHAR(200) COMMENT '歌手名称',
    `music_album` VARCHAR(200) COMMENT '专辑名称',
    `music_cover` VARCHAR(500) COMMENT '封面图片URL',
    `music_time` VARCHAR(20) COMMENT '歌曲时长',
    `music_pay` VARCHAR(20) COMMENT '付费信息',
    `play_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '播放时间',
    `play_duration` INT DEFAULT 0 COMMENT '播放时长（秒）',
    `play_progress` DECIMAL(5,2) DEFAULT 0.00 COMMENT '播放进度百分比',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    UNIQUE KEY `uk_user_music` (`user_id`, `music_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON DELETE CASCADE,
    INDEX `idx_user_play_time` (`user_id`, `play_time` DESC),
    INDEX `idx_play_time` (`play_time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户最近播放表';
