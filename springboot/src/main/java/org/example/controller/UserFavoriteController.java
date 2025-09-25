package org.example.controller;

import org.example.entity.ApiResponse;
import org.example.entity.UserFavorite;
import org.example.service.UserFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户收藏音乐控制器
 */
@RestController
@RequestMapping("/api/user-favorites")
public class UserFavoriteController {

    @Autowired
    private UserFavoriteService userFavoriteService;

    /**
     * 获取用户收藏列表
     */
    @GetMapping("/user/{userId}")
    public ApiResponse<List<UserFavorite>> getUserFavorites(@PathVariable Long userId) {
        try {
            List<UserFavorite> favorites = userFavoriteService.getUserFavorites(userId);
            return ApiResponse.success(favorites);
        } catch (Exception e) {
            return ApiResponse.error("获取收藏列表失败: " + e.getMessage());
        }
    }

    /**
     * 添加收藏
     */
    @PostMapping("/add")
    public ApiResponse<Boolean> addFavorite(@RequestParam Long userId,
                                           @RequestParam String musicId,
                                           @RequestParam(required = false) String musicMid,
                                           @RequestParam String musicSong,
                                           @RequestParam String musicSinger,
                                           @RequestParam(required = false) String musicAlbum,
                                           @RequestParam(required = false) String musicCover,
                                           @RequestParam(required = false) String musicTime,
                                           @RequestParam(required = false) String musicPay) {
        try {
            boolean success = userFavoriteService.addFavorite(userId, musicId, musicMid, musicSong,
                    musicSinger, musicAlbum, musicCover, musicTime, musicPay);
            return success ? ApiResponse.success(true) : ApiResponse.error("添加收藏失败");
        } catch (Exception e) {
            return ApiResponse.error("添加收藏失败: " + e.getMessage());
        }
    }

    /**
     * 删除收藏
     */
    @DeleteMapping("/remove")
    public ApiResponse<Boolean> removeFavorite(@RequestParam Long userId, @RequestParam String musicId) {
        try {
            boolean success = userFavoriteService.removeFavorite(userId, musicId);
            return success ? ApiResponse.success(true) : ApiResponse.error("删除收藏失败");
        } catch (Exception e) {
            return ApiResponse.error("删除收藏失败: " + e.getMessage());
        }
    }

    /**
     * 检查是否已收藏
     */
    @GetMapping("/check")
    public ApiResponse<Boolean> checkFavorite(@RequestParam Long userId, @RequestParam String musicId) {
        try {
            boolean isFavorite = userFavoriteService.isFavorite(userId, musicId);
            return ApiResponse.success(isFavorite);
        } catch (Exception e) {
            return ApiResponse.error("检查收藏状态失败: " + e.getMessage());
        }
    }

    /**
     * 获取用户收藏数量
     */
    @GetMapping("/count/{userId}")
    public ApiResponse<Integer> getFavoriteCount(@PathVariable Long userId) {
        try {
            int count = userFavoriteService.getFavoriteCount(userId);
            return ApiResponse.success(count);
        } catch (Exception e) {
            return ApiResponse.error("获取收藏数量失败: " + e.getMessage());
        }
    }
}
