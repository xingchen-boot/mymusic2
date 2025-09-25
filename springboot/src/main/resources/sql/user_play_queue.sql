-- 创建用户播放队列表
CREATE TABLE IF NOT EXISTS `user_play_queue` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '队列项ID',
    `user_id` BIGINT NOT NULL COMMENT '用户ID',
    `music_id` VARCHAR(100) NOT NULL COMMENT '音乐ID',
    `music_mid` VARCHAR(100) COMMENT '音乐MID',
    `music_song` VARCHAR(200) NOT NULL COMMENT '歌曲名称',
    `music_singer` VARCHAR(200) COMMENT '歌手名称',
    `music_album` VARCHAR(200) COMMENT '专辑名称',
    `music_cover` VARCHAR(500) COMMENT '封面图片URL',
    `music_url` VARCHAR(500) COMMENT '音乐文件URL',
    `sort_order` INT DEFAULT 0 COMMENT '排序顺序',
    `add_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `status` TINYINT DEFAULT 1 COMMENT '状态：0-删除，1-正常',
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户播放队列表';

-- 创建索引
CREATE INDEX idx_user_play_queue_user_id ON `user_play_queue`(`user_id`);
CREATE INDEX idx_user_play_queue_sort ON `user_play_queue`(`user_id`, `sort_order`);
