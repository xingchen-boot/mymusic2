package org.example.controller;

import org.example.entity.ApiResponse;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public ApiResponse<Map<String, Object>> register(@RequestBody Map<String, String> request) {
        try {
            String username = request.get("username");
            String password = request.get("password");
            String nickname = request.get("nickname");

            // 参数验证
            if (username == null || username.trim().isEmpty()) {
                return ApiResponse.error("用户名不能为空");
            }
            if (password == null || password.trim().isEmpty()) {
                return ApiResponse.error("密码不能为空");
            }
            if (password.length() < 6) {
                return ApiResponse.error("密码长度不能少于6位");
            }

            User user = userService.register(username, password, nickname);
            
            // 返回用户信息（不包含密码）
            Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("id", user.getId());
            userInfo.put("username", user.getUsername());
            userInfo.put("nickname", user.getNickname());
            userInfo.put("avatar", user.getAvatar());
            userInfo.put("createTime", user.getCreateTime());

            return ApiResponse.success("注册成功", userInfo);
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public ApiResponse<Map<String, Object>> login(@RequestBody Map<String, String> request) {
        try {
            String username = request.get("username");
            String password = request.get("password");

            // 参数验证
            if (username == null || username.trim().isEmpty()) {
                return ApiResponse.error("用户名不能为空");
            }
            if (password == null || password.trim().isEmpty()) {
                return ApiResponse.error("密码不能为空");
            }

            User user = userService.login(username, password);
            
            // 返回用户信息（不包含密码）
            Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("id", user.getId());
            userInfo.put("username", user.getUsername());
            userInfo.put("nickname", user.getNickname());
            userInfo.put("avatar", user.getAvatar());
            userInfo.put("createTime", user.getCreateTime());

            return ApiResponse.success("登录成功", userInfo);
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 获取用户信息
     */
    @GetMapping("/info/{id}")
    public ApiResponse<Map<String, Object>> getUserInfo(@PathVariable Long id) {
        try {
            User user = userService.findById(id);
            if (user == null) {
                return ApiResponse.error("用户不存在");
            }

            Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("id", user.getId());
            userInfo.put("username", user.getUsername());
            userInfo.put("nickname", user.getNickname());
            userInfo.put("avatar", user.getAvatar());
            userInfo.put("createTime", user.getCreateTime());

            return ApiResponse.success("获取成功", userInfo);
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 更新用户信息
     */
    @PutMapping("/info/{id}")
    public ApiResponse<String> updateUserInfo(@PathVariable Long id, @RequestBody Map<String, String> request) {
        try {
            String nickname = request.get("nickname");
            String avatar = request.get("avatar");

            boolean success = userService.updateUserInfo(id, nickname, avatar);
            if (success) {
                return ApiResponse.success("更新成功", null);
            } else {
                return ApiResponse.error("更新失败");
            }
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 修改密码
     */
    @PutMapping("/password/{id}")
    public ApiResponse<String> changePassword(@PathVariable Long id, @RequestBody Map<String, String> request) {
        try {
            String oldPassword = request.get("oldPassword");
            String newPassword = request.get("newPassword");

            if (oldPassword == null || oldPassword.trim().isEmpty()) {
                return ApiResponse.error("原密码不能为空");
            }
            if (newPassword == null || newPassword.trim().isEmpty()) {
                return ApiResponse.error("新密码不能为空");
            }
            if (newPassword.length() < 6) {
                return ApiResponse.error("新密码长度不能少于6位");
            }

            boolean success = userService.changePassword(id, oldPassword, newPassword);
            if (success) {
                return ApiResponse.success("密码修改成功", null);
            } else {
                return ApiResponse.error("密码修改失败");
            }
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 检查用户名是否存在
     */
    @GetMapping("/check-username")
    public ApiResponse<Map<String, Boolean>> checkUsername(@RequestParam String username) {
        try {
            User user = userService.findByUsername(username);
            Map<String, Boolean> result = new HashMap<>();
            result.put("exists", user != null);
            return ApiResponse.success("检查完成", result);
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 获取用户列表（管理员功能）
     */
    @GetMapping("/list")
    public ApiResponse<Map<String, Object>> getUserList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            List<User> users = userService.getUserList(page, size);
            int total = userService.getUserCount();

            Map<String, Object> result = new HashMap<>();
            result.put("users", users);
            result.put("total", total);
            result.put("page", page);
            result.put("size", size);

            return ApiResponse.success("获取成功", result);
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }
}
