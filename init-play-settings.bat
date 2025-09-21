@echo***REMOVED***off
echo***REMOVED***正在初始化用户播放设置数据库表...

mysql***REMOVED***-u***REMOVED***root***REMOVED***-padmin123***REMOVED***-D***REMOVED***mymusic***REMOVED***<***REMOVED***springboot\src\main\resources\sql\user_play_settings.sql

if***REMOVED***%errorlevel%***REMOVED***equ***REMOVED***0***REMOVED***(
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED***✅***REMOVED***用户播放设置数据库表初始化成功！
)***REMOVED***else***REMOVED***(
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED***❌***REMOVED***用户播放设置数据库表初始化失败！
)

pause
