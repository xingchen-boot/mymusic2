package***REMOVED***org.example.controller;

import***REMOVED***org.example.entity.ApiResponse;
import***REMOVED***org.example.entity.UserFavorite;
import***REMOVED***org.example.service.UserFavoriteService;
import***REMOVED***org.springframework.beans.factory.annotation.Autowired;
import***REMOVED***org.springframework.web.bind.annotation.*;

import***REMOVED***java.util.List;

/**
***REMOVED*******REMOVED***用户收藏音乐控制器
***REMOVED****/
@RestController
@RequestMapping("/api/user-favorites")
public***REMOVED***class***REMOVED***UserFavoriteController***REMOVED***{

***REMOVED******REMOVED******REMOVED******REMOVED***@Autowired
***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***UserFavoriteService***REMOVED***userFavoriteService;

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***获取用户收藏列表
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@GetMapping("/user/{userId}")
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***ApiResponse<List<UserFavorite>>***REMOVED***getUserFavorites(@PathVariable***REMOVED***Long***REMOVED***userId)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***List<UserFavorite>***REMOVED***favorites***REMOVED***=***REMOVED***userFavoriteService.getUserFavorites(userId);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.success(favorites);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(Exception***REMOVED***e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error("获取收藏列表失败:***REMOVED***"***REMOVED***+***REMOVED***e.getMessage());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***添加收藏
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@PostMapping("/add")
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***ApiResponse<Boolean>***REMOVED***addFavorite(@RequestParam***REMOVED***Long***REMOVED***userId,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@RequestParam***REMOVED***String***REMOVED***musicId,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@RequestParam(required***REMOVED***=***REMOVED***false)***REMOVED***String***REMOVED***musicMid,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@RequestParam***REMOVED***String***REMOVED***musicSong,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@RequestParam***REMOVED***String***REMOVED***musicSinger,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@RequestParam(required***REMOVED***=***REMOVED***false)***REMOVED***String***REMOVED***musicAlbum,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@RequestParam(required***REMOVED***=***REMOVED***false)***REMOVED***String***REMOVED***musicCover,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@RequestParam(required***REMOVED***=***REMOVED***false)***REMOVED***String***REMOVED***musicTime,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@RequestParam(required***REMOVED***=***REMOVED***false)***REMOVED***String***REMOVED***musicPay)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***boolean***REMOVED***success***REMOVED***=***REMOVED***userFavoriteService.addFavorite(userId,***REMOVED***musicId,***REMOVED***musicMid,***REMOVED***musicSong,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***musicSinger,***REMOVED***musicAlbum,***REMOVED***musicCover,***REMOVED***musicTime,***REMOVED***musicPay);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***success***REMOVED***?***REMOVED***ApiResponse.success(true)***REMOVED***:***REMOVED***ApiResponse.error("添加收藏失败");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(Exception***REMOVED***e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error("添加收藏失败:***REMOVED***"***REMOVED***+***REMOVED***e.getMessage());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***删除收藏
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@DeleteMapping("/remove")
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***ApiResponse<Boolean>***REMOVED***removeFavorite(@RequestParam***REMOVED***Long***REMOVED***userId,***REMOVED***@RequestParam***REMOVED***String***REMOVED***musicId)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***boolean***REMOVED***success***REMOVED***=***REMOVED***userFavoriteService.removeFavorite(userId,***REMOVED***musicId);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***success***REMOVED***?***REMOVED***ApiResponse.success(true)***REMOVED***:***REMOVED***ApiResponse.error("删除收藏失败");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(Exception***REMOVED***e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error("删除收藏失败:***REMOVED***"***REMOVED***+***REMOVED***e.getMessage());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***检查是否已收藏
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@GetMapping("/check")
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***ApiResponse<Boolean>***REMOVED***checkFavorite(@RequestParam***REMOVED***Long***REMOVED***userId,***REMOVED***@RequestParam***REMOVED***String***REMOVED***musicId)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***boolean***REMOVED***isFavorite***REMOVED***=***REMOVED***userFavoriteService.isFavorite(userId,***REMOVED***musicId);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.success(isFavorite);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(Exception***REMOVED***e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error("检查收藏状态失败:***REMOVED***"***REMOVED***+***REMOVED***e.getMessage());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***获取用户收藏数量
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@GetMapping("/count/{userId}")
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***ApiResponse<Integer>***REMOVED***getFavoriteCount(@PathVariable***REMOVED***Long***REMOVED***userId)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***count***REMOVED***=***REMOVED***userFavoriteService.getFavoriteCount(userId);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.success(count);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(Exception***REMOVED***e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ApiResponse.error("获取收藏数量失败:***REMOVED***"***REMOVED***+***REMOVED***e.getMessage());
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}
}
