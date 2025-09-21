@echo***REMOVED***off
echo***REMOVED***正在初始化用户收藏音乐表...
echo.

cd***REMOVED***/d***REMOVED***"%~dp0"

echo***REMOVED***执行SQL脚本...
mysql***REMOVED***-u***REMOVED***root***REMOVED***-p***REMOVED***mymusic***REMOVED***<***REMOVED***springboot\src\main\resources\sql\user_favorites.sql

if***REMOVED***%errorlevel%***REMOVED***equ***REMOVED***0***REMOVED***(
***REMOVED******REMOVED******REMOVED******REMOVED***echo.
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED***✅***REMOVED***用户收藏音乐表创建成功！
***REMOVED******REMOVED******REMOVED******REMOVED***echo.
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED***表结构：
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED***-***REMOVED***user_favorites:***REMOVED***用户收藏音乐表
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED******REMOVED******REMOVED***-***REMOVED***id:***REMOVED***主键ID
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED******REMOVED******REMOVED***-***REMOVED***user_id:***REMOVED***用户ID
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED******REMOVED******REMOVED***-***REMOVED***music_id:***REMOVED***音乐ID
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED******REMOVED******REMOVED***-***REMOVED***music_mid:***REMOVED***音乐MID
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED******REMOVED******REMOVED***-***REMOVED***music_song:***REMOVED***音乐名称
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED******REMOVED******REMOVED***-***REMOVED***music_singer:***REMOVED***音乐艺术家
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED******REMOVED******REMOVED***-***REMOVED***music_album:***REMOVED***音乐专辑
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED******REMOVED******REMOVED***-***REMOVED***music_cover:***REMOVED***音乐封面
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED******REMOVED******REMOVED***-***REMOVED***music_time:***REMOVED***音乐时长
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED******REMOVED******REMOVED***-***REMOVED***music_pay:***REMOVED***音乐付费信息
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED******REMOVED******REMOVED***-***REMOVED***create_time:***REMOVED***收藏时间
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED******REMOVED******REMOVED***-***REMOVED***update_time:***REMOVED***更新时间
***REMOVED******REMOVED******REMOVED******REMOVED***echo.
)***REMOVED***else***REMOVED***(
***REMOVED******REMOVED******REMOVED******REMOVED***echo.
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED***❌***REMOVED***用户收藏音乐表创建失败！
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED***请检查MySQL连接和权限设置
***REMOVED******REMOVED******REMOVED******REMOVED***echo.
)

pause
