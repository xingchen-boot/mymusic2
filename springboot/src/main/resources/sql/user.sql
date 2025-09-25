-- 创建用户表
CREATE TABLE IF NOT EXISTS `user` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '用户ID',
    `username` VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名',
    `password` VARCHAR(255) NOT NULL COMMENT '密码',
    `nickname` VARCHAR(50) COMMENT '昵称',
    `avatar` VARCHAR(255) COMMENT '头像URL',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `status` TINYINT DEFAULT 1 COMMENT '状态：0-禁用，1-启用'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

-- 插入测试用户数据
INSERT INTO `user` (`username`, `password`, `nickname`, `avatar`, `status`) VALUES
('admin', 'admin123', '管理员', 'https://picsum.photos/40/40?random=1', 1),
('test', 'test123', '测试用户', 'https://picsum.photos/40/40?random=2', 1);
