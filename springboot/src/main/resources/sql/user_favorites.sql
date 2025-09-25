-- 创建用户收藏音乐表
CREATE TABLE IF NOT EXISTS `user_favorites` (
    `id` BIGINT AUTO_INCREMENT COMMENT '主键ID',
    `user_id` BIGINT NOT NULL COMMENT '用户ID',
    `music_id` VARCHAR(255) NOT NULL COMMENT '音乐ID',
    `music_mid` VARCHAR(255) COMMENT '音乐MID',
    `music_song` VARCHAR(255) NOT NULL COMMENT '音乐名称',
    `music_singer` VARCHAR(255) NOT NULL COMMENT '音乐艺术家',
    `music_album` VARCHAR(255) COMMENT '音乐专辑',
    `music_cover` VARCHAR(255) COMMENT '音乐封面',
    `music_time` VARCHAR(50) COMMENT '音乐时长',
    `music_pay` VARCHAR(50) COMMENT '音乐付费信息',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '收藏时间',
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_music` (`user_id`, `music_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户收藏音乐表';
