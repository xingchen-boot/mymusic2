package***REMOVED***org.example.controller;

import***REMOVED***org.example.entity.ApiResponse;
import***REMOVED***org.example.entity.User;
import***REMOVED***org.example.service.UserService;
import***REMOVED***org.springframework.beans.factory.annotation.Autowired;
import***REMOVED***org.springframework.web.bind.annotation.*;

import***REMOVED***java.util.HashMap;
import***REMOVED***java.util.List;
import***REMOVED***java.util.Map;

/**
***REMOVED*******REMOVED***用户控制器
***REMOVED****/
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins***REMOVED***=***REMOVED***"*")
public***REMOVED***class***REMOVED***UserController***REMOVED***{

***REMOVED******REMOVED******REMOVED******REMOVED***@Autowired
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***UserService***REMOVED***userService;

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***用户注册
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@PostMapping("/register")
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***ApiResponse<Map<String,***REMOVED***Object>>***REMOVED***register(@RequestBody***REMOVED***Map<String,***REMOVED***String>***REMOVED***request)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***String***REMOVED***username***REMOVED***=***REMOVED***request.get("username");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***String***REMOVED***password***REMOVED***=***REMOVED***request.get("password");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***String***REMOVED***nickname***REMOVED***=***REMOVED***request.get("nickname");

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***参数验证
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(username***REMOVED***==***REMOVED***null***REMOVED***||***REMOVED***username.trim().isEmpty())***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error("用户名不能为空");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(password***REMOVED***==***REMOVED***null***REMOVED***||***REMOVED***password.trim().isEmpty())***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error("密码不能为空");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(password.length()***REMOVED***<***REMOVED***6)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error("密码长度不能少于6位");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***User***REMOVED***user***REMOVED***=***REMOVED***userService.register(username,***REMOVED***password,***REMOVED***nickname);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***返回用户信息（不包含密码）
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***Map<String,***REMOVED***Object>***REMOVED***userInfo***REMOVED***=***REMOVED***new***REMOVED***HashMap<>();
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userInfo.put("id",***REMOVED***user.getId());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userInfo.put("username",***REMOVED***user.getUsername());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userInfo.put("nickname",***REMOVED***user.getNickname());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userInfo.put("avatar",***REMOVED***user.getAvatar());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userInfo.put("createTime",***REMOVED***user.getCreateTime());

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.success("注册成功",***REMOVED***userInfo);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(Exception***REMOVED***e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error(e.getMessage());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***用户登录
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@PostMapping("/login")
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***ApiResponse<Map<String,***REMOVED***Object>>***REMOVED***login(@RequestBody***REMOVED***Map<String,***REMOVED***String>***REMOVED***request)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***String***REMOVED***username***REMOVED***=***REMOVED***request.get("username");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***String***REMOVED***password***REMOVED***=***REMOVED***request.get("password");

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***参数验证
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(username***REMOVED***==***REMOVED***null***REMOVED***||***REMOVED***username.trim().isEmpty())***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error("用户名不能为空");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(password***REMOVED***==***REMOVED***null***REMOVED***||***REMOVED***password.trim().isEmpty())***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error("密码不能为空");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***User***REMOVED***user***REMOVED***=***REMOVED***userService.login(username,***REMOVED***password);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***返回用户信息（不包含密码）
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***Map<String,***REMOVED***Object>***REMOVED***userInfo***REMOVED***=***REMOVED***new***REMOVED***HashMap<>();
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userInfo.put("id",***REMOVED***user.getId());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userInfo.put("username",***REMOVED***user.getUsername());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userInfo.put("nickname",***REMOVED***user.getNickname());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userInfo.put("avatar",***REMOVED***user.getAvatar());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userInfo.put("createTime",***REMOVED***user.getCreateTime());

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.success("登录成功",***REMOVED***userInfo);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(Exception***REMOVED***e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error(e.getMessage());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***获取用户信息
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@GetMapping("/info/{id}")
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***ApiResponse<Map<String,***REMOVED***Object>>***REMOVED***getUserInfo(@PathVariable***REMOVED***Long***REMOVED***id)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***User***REMOVED***user***REMOVED***=***REMOVED***userService.findById(id);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(user***REMOVED***==***REMOVED***null)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error("用户不存在");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***Map<String,***REMOVED***Object>***REMOVED***userInfo***REMOVED***=***REMOVED***new***REMOVED***HashMap<>();
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userInfo.put("id",***REMOVED***user.getId());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userInfo.put("username",***REMOVED***user.getUsername());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userInfo.put("nickname",***REMOVED***user.getNickname());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userInfo.put("avatar",***REMOVED***user.getAvatar());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userInfo.put("createTime",***REMOVED***user.getCreateTime());

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.success("获取成功",***REMOVED***userInfo);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(Exception***REMOVED***e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error(e.getMessage());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***更新用户信息
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@PutMapping("/info/{id}")
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***ApiResponse<String>***REMOVED***updateUserInfo(@PathVariable***REMOVED***Long***REMOVED***id,***REMOVED***@RequestBody***REMOVED***Map<String,***REMOVED***String>***REMOVED***request)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***String***REMOVED***nickname***REMOVED***=***REMOVED***request.get("nickname");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***String***REMOVED***avatar***REMOVED***=***REMOVED***request.get("avatar");

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***boolean***REMOVED***success***REMOVED***=***REMOVED***userService.updateUserInfo(id,***REMOVED***nickname,***REMOVED***avatar);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(success)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.success("更新成功",***REMOVED***null);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***else***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error("更新失败");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(Exception***REMOVED***e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error(e.getMessage());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***修改密码
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@PutMapping("/password/{id}")
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***ApiResponse<String>***REMOVED***changePassword(@PathVariable***REMOVED***Long***REMOVED***id,***REMOVED***@RequestBody***REMOVED***Map<String,***REMOVED***String>***REMOVED***request)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***String***REMOVED***oldPassword***REMOVED***=***REMOVED***request.get("oldPassword");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***String***REMOVED***newPassword***REMOVED***=***REMOVED***request.get("newPassword");

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(oldPassword***REMOVED***==***REMOVED***null***REMOVED***||***REMOVED***oldPassword.trim().isEmpty())***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error("原密码不能为空");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(newPassword***REMOVED***==***REMOVED***null***REMOVED***||***REMOVED***newPassword.trim().isEmpty())***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error("新密码不能为空");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(newPassword.length()***REMOVED***<***REMOVED***6)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error("新密码长度不能少于6位");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***boolean***REMOVED***success***REMOVED***=***REMOVED***userService.changePassword(id,***REMOVED***oldPassword,***REMOVED***newPassword);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(success)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.success("密码修改成功",***REMOVED***null);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***else***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error("密码修改失败");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(Exception***REMOVED***e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error(e.getMessage());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***检查用户名是否存在
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@GetMapping("/check-username")
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***ApiResponse<Map<String,***REMOVED***Boolean>>***REMOVED***checkUsername(@RequestParam***REMOVED***String***REMOVED***username)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***User***REMOVED***user***REMOVED***=***REMOVED***userService.findByUsername(username);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***Map<String,***REMOVED***Boolean>***REMOVED***result***REMOVED***=***REMOVED***new***REMOVED***HashMap<>();
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***result.put("exists",***REMOVED***user***REMOVED***!=***REMOVED***null);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.success("检查完成",***REMOVED***result);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(Exception***REMOVED***e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error(e.getMessage());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***获取用户列表（管理员功能）
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@GetMapping("/list")
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***ApiResponse<Map<String,***REMOVED***Object>>***REMOVED***getUserList(
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@RequestParam(defaultValue***REMOVED***=***REMOVED***"1")***REMOVED***int***REMOVED***page,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@RequestParam(defaultValue***REMOVED***=***REMOVED***"10")***REMOVED***int***REMOVED***size)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***List<User>***REMOVED***users***REMOVED***=***REMOVED***userService.getUserList(page,***REMOVED***size);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***total***REMOVED***=***REMOVED***userService.getUserCount();

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***Map<String,***REMOVED***Object>***REMOVED***result***REMOVED***=***REMOVED***new***REMOVED***HashMap<>();
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***result.put("users",***REMOVED***users);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***result.put("total",***REMOVED***total);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***result.put("page",***REMOVED***page);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***result.put("size",***REMOVED***size);

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.success("获取成功",***REMOVED***result);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(Exception***REMOVED***e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error(e.getMessage());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}
}
