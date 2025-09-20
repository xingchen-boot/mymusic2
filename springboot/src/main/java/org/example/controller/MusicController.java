package***REMOVED***org.example.controller;

import***REMOVED***org.example.entity.ApiResponse;
import***REMOVED***org.example.entity.Music;
import***REMOVED***org.example.service.MusicApiService;
import***REMOVED***org.springframework.http.ResponseEntity;
import***REMOVED***org.springframework.web.bind.annotation.*;

import***REMOVED***java.util.List;
import***REMOVED***java.util.Map;

@RestController
@RequestMapping("/api/music")
@CrossOrigin(origins***REMOVED***=***REMOVED***"*")
public***REMOVED***class***REMOVED***MusicController***REMOVED***{

***REMOVED******REMOVED******REMOVED******REMOVED***private***REMOVED***final***REMOVED***MusicApiService***REMOVED***musicApiService;
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***MusicController(MusicApiService***REMOVED***musicApiService)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***this.musicApiService***REMOVED***=***REMOVED***musicApiService;
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***搜索音乐
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@GetMapping("/search")
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***ResponseEntity<ApiResponse<List<Music>>>***REMOVED***searchMusic(
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@RequestParam***REMOVED***String***REMOVED***keyword,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@RequestParam(defaultValue***REMOVED***=***REMOVED***"1")***REMOVED***Integer***REMOVED***page,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@RequestParam(defaultValue***REMOVED***=***REMOVED***"20")***REMOVED***Integer***REMOVED***size)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***Map<String,***REMOVED***Object>***REMOVED***result***REMOVED***=***REMOVED***musicApiService.searchMusic(keyword,***REMOVED***page,***REMOVED***size);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***List<Music>***REMOVED***musicList***REMOVED***=***REMOVED***(List<Music>)***REMOVED***result.get("data");
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***ApiResponse<List<Music>>***REMOVED***response***REMOVED***=***REMOVED***ApiResponse.success("搜索成功",***REMOVED***musicList);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***response.setTotal(result.get("total"));
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***response.setPage(page);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***response.setSize(size);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ResponseEntity.ok(response);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(Exception***REMOVED***e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ResponseEntity.ok(ApiResponse.error("搜索失败:***REMOVED***"***REMOVED***+***REMOVED***e.getMessage()));
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***获取音乐播放URL
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@GetMapping("/url")
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***ResponseEntity<ApiResponse<Object>>***REMOVED***getMusicUrl(
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@RequestParam(required***REMOVED***=***REMOVED***false)***REMOVED***String***REMOVED***mid,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@RequestParam(required***REMOVED***=***REMOVED***false)***REMOVED***String***REMOVED***id)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***Map<String,***REMOVED***Object>***REMOVED***result***REMOVED***=***REMOVED***musicApiService.getMusicUrl(mid,***REMOVED***id);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ResponseEntity.ok(ApiResponse.success("获取成功",***REMOVED***result));
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(Exception***REMOVED***e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ResponseEntity.ok(ApiResponse.error("获取失败:***REMOVED***"***REMOVED***+***REMOVED***e.getMessage()));
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***获取歌词
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@GetMapping("/lyrics")
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***ResponseEntity<ApiResponse<Object>>***REMOVED***getLyrics(
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@RequestParam(required***REMOVED***=***REMOVED***false)***REMOVED***String***REMOVED***mid,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@RequestParam(required***REMOVED***=***REMOVED***false)***REMOVED***String***REMOVED***id)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***Map<String,***REMOVED***Object>***REMOVED***result***REMOVED***=***REMOVED***musicApiService.getLyrics(mid,***REMOVED***id);
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ResponseEntity.ok(ApiResponse.success("获取成功",***REMOVED***result));
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(Exception***REMOVED***e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***ResponseEntity.ok(ApiResponse.error("获取失败:***REMOVED***"***REMOVED***+***REMOVED***e.getMessage()));
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}
}
