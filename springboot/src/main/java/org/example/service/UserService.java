package org.example.service;

import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户服务类
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     */
    public User register(String username, String password, String nickname) {
        // 检查用户名是否已存在
        if (userMapper.checkUsernameExists(username) > 0) {
            throw new RuntimeException("用户名已存在");
        }

        // 创建新用户
        User user = new User(username, password, nickname);
        // 简单的密码加密（实际项目中应使用更安全的加密方式）
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        
        userMapper.insert(user);
        return user;
    }

    /**
     * 用户登录
     */
    public User login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }

        // 验证密码
        String encryptedPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!encryptedPassword.equals(user.getPassword())) {
            throw new RuntimeException("密码错误");
        }

        return user;
    }

    /**
     * 根据用户名查找用户
     */
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    /**
     * 根据ID查找用户
     */
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    /**
     * 更新用户信息
     */
    public boolean updateUserInfo(Long id, String nickname, String avatar) {
        // 允许部分更新：若前端不想改某字段，则传 null
        if (nickname != null) {
            nickname = nickname.trim();
            if (nickname.isEmpty()) nickname = null;
        }
        if (avatar != null) {
            // 若 Base64 过大，可在此做阈值校验或改为存储URL
            if (avatar.length() > 1024 * 1024) { // 1MB字符长度保护
                throw new RuntimeException("头像数据过大，请压缩后重试");
            }
        }

        User user = new User();
        user.setId(id);
        user.setNickname(nickname); // 可能为 null，COALESCE 保留原值
        user.setAvatar(avatar);     // 可能为 null，COALESCE 保留原值
        user.setUpdateTime(LocalDateTime.now());
        return userMapper.updateUserInfo(user) > 0;
    }

    /**
     * 修改密码
     */
    public boolean changePassword(Long id, String oldPassword, String newPassword) {
        User user = userMapper.findById(id);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }

        // 验证旧密码
        String encryptedOldPassword = DigestUtils.md5DigestAsHex(oldPassword.getBytes());
        if (!encryptedOldPassword.equals(user.getPassword())) {
            throw new RuntimeException("原密码错误");
        }

        // 更新新密码
        String encryptedNewPassword = DigestUtils.md5DigestAsHex(newPassword.getBytes());
        return userMapper.updatePassword(id, encryptedNewPassword, LocalDateTime.now()) > 0;
    }

    /**
     * 获取用户列表
     */
    public List<User> getUserList(int page, int size) {
        int offset = (page - 1) * size;
        return userMapper.findAll(offset, size);
    }

    /**
     * 获取用户总数
     */
    public int getUserCount() {
        return userMapper.countAll();
    }
}
