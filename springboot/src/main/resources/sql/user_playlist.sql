-- 创建用户播放列表表
CREATE TABLE IF NOT EXISTS `user_playlist` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '播放列表ID',
    `user_id` BIGINT NOT NULL COMMENT '用户ID',
    `name` VARCHAR(100) NOT NULL COMMENT '播放列表名称',
    `description` TEXT COMMENT '播放列表描述',
    `cover_url` VARCHAR(255) COMMENT '封面图片URL',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `status` TINYINT DEFAULT 1 COMMENT '状态：0-删除，1-正常',
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户播放列表表';

-- 创建播放列表音乐关联表
CREATE TABLE IF NOT EXISTS `playlist_music` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '关联ID',
    `playlist_id` BIGINT NOT NULL COMMENT '播放列表ID',
    `music_id` VARCHAR(100) NOT NULL COMMENT '音乐ID',
    `music_name` VARCHAR(200) NOT NULL COMMENT '音乐名称',
    `artist_name` VARCHAR(200) COMMENT '艺术家名称',
    `album_name` VARCHAR(200) COMMENT '专辑名称',
    `duration` INT COMMENT '时长（秒）',
    `music_url` VARCHAR(500) COMMENT '音乐文件URL',
    `cover_url` VARCHAR(500) COMMENT '封面图片URL',
    `add_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `sort_order` INT DEFAULT 0 COMMENT '排序顺序',
    FOREIGN KEY (`playlist_id`) REFERENCES `user_playlist`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='播放列表音乐关联表';

-- 创建索引
CREATE INDEX idx_user_playlist_user_id ON `user_playlist`(`user_id`);
CREATE INDEX idx_playlist_music_playlist_id ON `playlist_music`(`playlist_id`);
CREATE INDEX idx_playlist_music_sort ON `playlist_music`(`playlist_id`, `sort_order`);

