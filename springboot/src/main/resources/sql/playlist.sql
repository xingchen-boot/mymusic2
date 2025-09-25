-- 播放列表表
CREATE TABLE IF NOT EXISTS playlists (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL COMMENT '播放列表名称',
    description TEXT COMMENT '播放列表描述',
    cover VARCHAR(500) COMMENT '播放列表封面',
    user_id BIGINT COMMENT '用户ID（预留）',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_user_id (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='播放列表表';

-- 播放列表音乐关联表
CREATE TABLE IF NOT EXISTS playlist_music (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    playlist_id BIGINT NOT NULL COMMENT '播放列表ID',
    music_id BIGINT NOT NULL COMMENT '音乐ID',
    music_mid VARCHAR(100) NOT NULL COMMENT '音乐MID',
    music_song VARCHAR(255) NOT NULL COMMENT '歌曲名',
    music_singer VARCHAR(255) NOT NULL COMMENT '歌手',
    music_album VARCHAR(255) COMMENT '专辑',
    music_cover VARCHAR(500) COMMENT '封面',
    music_url VARCHAR(500) COMMENT '播放URL',
    sort_order INT DEFAULT 0 COMMENT '排序',
    added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    FOREIGN KEY (playlist_id) REFERENCES playlists(id) ON DELETE CASCADE,
    INDEX idx_playlist_id (playlist_id),
    INDEX idx_music_id (music_id),
    UNIQUE KEY uk_playlist_music (playlist_id, music_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='播放列表音乐关联表';
