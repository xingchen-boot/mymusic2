@echo***REMOVED***off
echo***REMOVED***正在创建播放列表数据库表...

mysql***REMOVED***-u***REMOVED***root***REMOVED***-padmin123***REMOVED***-D***REMOVED***mymusic***REMOVED***<***REMOVED***"springboot\src\main\resources\sql\playlist.sql"

if***REMOVED***%errorlevel%***REMOVED***equ***REMOVED***0***REMOVED***(
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED***数据库表创建成功！
)***REMOVED***else***REMOVED***(
***REMOVED******REMOVED******REMOVED******REMOVED***echo***REMOVED***数据库表创建失败，请检查MySQL连接和权限
)

pause
