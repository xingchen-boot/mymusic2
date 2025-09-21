package***REMOVED***org.example.service;

import***REMOVED***org.example.entity.User;
import***REMOVED***org.example.mapper.UserMapper;
import***REMOVED***org.springframework.beans.factory.annotation.Autowired;
import***REMOVED***org.springframework.stereotype.Service;
import***REMOVED***org.springframework.util.DigestUtils;

import***REMOVED***java.time.LocalDateTime;
import***REMOVED***java.util.List;

/**
***REMOVED*******REMOVED***用户服务类
***REMOVED****/
@Service
public***REMOVED***class***REMOVED***UserService***REMOVED***{

***REMOVED******REMOVED******REMOVED******REMOVED***@Autowired
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***UserMapper***REMOVED***userMapper;

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***用户注册
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***User***REMOVED***register(String***REMOVED***username,***REMOVED***String***REMOVED***password,***REMOVED***String***REMOVED***nickname)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***检查用户名是否已存在
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(userMapper.checkUsernameExists(username)***REMOVED***>***REMOVED***0)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***throw***REMOVED***new***REMOVED***RuntimeException("用户名已存在");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***创建新用户
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***User***REMOVED***user***REMOVED***=***REMOVED***new***REMOVED***User(username,***REMOVED***password,***REMOVED***nickname);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***简单的密码加密（实际项目中应使用更安全的加密方式）
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userMapper.insert(user);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***user;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***用户登录
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***User***REMOVED***login(String***REMOVED***username,***REMOVED***String***REMOVED***password)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***User***REMOVED***user***REMOVED***=***REMOVED***userMapper.findByUsername(username);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(user***REMOVED***==***REMOVED***null)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***throw***REMOVED***new***REMOVED***RuntimeException("用户不存在");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***验证密码
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***String***REMOVED***encryptedPassword***REMOVED***=***REMOVED***DigestUtils.md5DigestAsHex(password.getBytes());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(!encryptedPassword.equals(user.getPassword()))***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***throw***REMOVED***new***REMOVED***RuntimeException("密码错误");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***user;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***根据用户名查找用户
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***User***REMOVED***findByUsername(String***REMOVED***username)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***userMapper.findByUsername(username);
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***根据ID查找用户
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***User***REMOVED***findById(Long***REMOVED***id)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***userMapper.findById(id);
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***更新用户信息
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***boolean***REMOVED***updateUserInfo(Long***REMOVED***id,***REMOVED***String***REMOVED***nickname,***REMOVED***String***REMOVED***avatar)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***User***REMOVED***user***REMOVED***=***REMOVED***new***REMOVED***User();
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***user.setId(id);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***user.setNickname(nickname);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***user.setAvatar(avatar);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***user.setUpdateTime(LocalDateTime.now());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***userMapper.updateUserInfo(user)***REMOVED***>***REMOVED***0;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***修改密码
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***boolean***REMOVED***changePassword(Long***REMOVED***id,***REMOVED***String***REMOVED***oldPassword,***REMOVED***String***REMOVED***newPassword)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***User***REMOVED***user***REMOVED***=***REMOVED***userMapper.findById(id);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(user***REMOVED***==***REMOVED***null)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***throw***REMOVED***new***REMOVED***RuntimeException("用户不存在");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***验证旧密码
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***String***REMOVED***encryptedOldPassword***REMOVED***=***REMOVED***DigestUtils.md5DigestAsHex(oldPassword.getBytes());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(!encryptedOldPassword.equals(user.getPassword()))***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***throw***REMOVED***new***REMOVED***RuntimeException("原密码错误");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***更新新密码
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***String***REMOVED***encryptedNewPassword***REMOVED***=***REMOVED***DigestUtils.md5DigestAsHex(newPassword.getBytes());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***userMapper.updatePassword(id,***REMOVED***encryptedNewPassword,***REMOVED***LocalDateTime.now())***REMOVED***>***REMOVED***0;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***获取用户列表
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***List<User>***REMOVED***getUserList(int***REMOVED***page,***REMOVED***int***REMOVED***size)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***offset***REMOVED***=***REMOVED***(page***REMOVED***-***REMOVED***1)***REMOVED*******REMOVED***size;
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***userMapper.findAll(offset,***REMOVED***size);
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***获取用户总数
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***int***REMOVED***getUserCount()***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***userMapper.countAll();
***REMOVED******REMOVED******REMOVED******REMOVED***}
}
