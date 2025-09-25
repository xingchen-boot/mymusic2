-- 创建用户播放设置表
CREATE TABLE IF NOT EXISTS `user_play_settings` (
    `id` BIGINT AUTO_INCREMENT COMMENT '主键ID',
    `user_id` BIGINT NOT NULL COMMENT '用户ID',
    `volume` INT NOT NULL DEFAULT 70 COMMENT '音量 (0-100)',
    `is_muted` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否静音 (0:否, 1:是)',
    `play_mode` VARCHAR(20) NOT NULL DEFAULT 'list' COMMENT '播放模式 (list:列表循环, single:单曲循环, random:随机播放)',
    `current_music_id` VARCHAR(255) COMMENT '当前播放音乐ID',
    `current_music_name` VARCHAR(255) COMMENT '当前播放音乐名称',
    `current_music_artist` VARCHAR(255) COMMENT '当前播放音乐艺术家',
    `current_music_cover` VARCHAR(255) COMMENT '当前播放音乐封面',
    `current_music_url` VARCHAR(255) COMMENT '当前播放音乐URL',
    `play_progress` DOUBLE NOT NULL DEFAULT 0 COMMENT '播放进度 (0-100)',
    `play_time` DOUBLE NOT NULL DEFAULT 0 COMMENT '当前播放时间 (秒)',
    `is_playing` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否正在播放 (0:否, 1:是)',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_id` (`user_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户播放设置表';
