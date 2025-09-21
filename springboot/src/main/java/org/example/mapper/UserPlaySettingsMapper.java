package***REMOVED***org.example.mapper;

import***REMOVED***org.apache.ibatis.annotations.*;
import***REMOVED***org.example.entity.UserPlaySettings;

/**
***REMOVED*******REMOVED***用户播放设置Mapper接口
***REMOVED****/
@Mapper
public***REMOVED***interface***REMOVED***UserPlaySettingsMapper***REMOVED***{

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***根据用户ID查询播放设置
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED*******REMOVED***FROM***REMOVED***user_play_settings***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}")
***REMOVED******REMOVED******REMOVED******REMOVED***UserPlaySettings***REMOVED***findByUserId(@Param("userId")***REMOVED***Long***REMOVED***userId);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***插入用户播放设置
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Insert("INSERT***REMOVED***INTO***REMOVED***user_play_settings***REMOVED***(user_id,***REMOVED***volume,***REMOVED***is_muted,***REMOVED***play_mode)***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"VALUES***REMOVED***(#{userId},***REMOVED***#{volume},***REMOVED***#{isMuted},***REMOVED***#{playMode})")
***REMOVED******REMOVED******REMOVED******REMOVED***@Options(useGeneratedKeys***REMOVED***=***REMOVED***true,***REMOVED***keyProperty***REMOVED***=***REMOVED***"id")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***insert(UserPlaySettings***REMOVED***settings);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***更新用户播放设置
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Update("UPDATE***REMOVED***user_play_settings***REMOVED***SET***REMOVED***volume***REMOVED***=***REMOVED***#{volume},***REMOVED***is_muted***REMOVED***=***REMOVED***#{isMuted},***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"play_mode***REMOVED***=***REMOVED***#{playMode},***REMOVED***update_time***REMOVED***=***REMOVED***CURRENT_TIMESTAMP***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***updateByUserId(UserPlaySettings***REMOVED***settings);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***插入或更新用户播放设置
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Insert("INSERT***REMOVED***INTO***REMOVED***user_play_settings***REMOVED***(user_id,***REMOVED***volume,***REMOVED***is_muted,***REMOVED***play_mode)***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"VALUES***REMOVED***(#{userId},***REMOVED***#{volume},***REMOVED***#{isMuted},***REMOVED***#{playMode})***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"ON***REMOVED***DUPLICATE***REMOVED***KEY***REMOVED***UPDATE***REMOVED***volume***REMOVED***=***REMOVED***#{volume},***REMOVED***is_muted***REMOVED***=***REMOVED***#{isMuted},***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"play_mode***REMOVED***=***REMOVED***#{playMode},***REMOVED***update_time***REMOVED***=***REMOVED***CURRENT_TIMESTAMP")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***insertOrUpdate(UserPlaySettings***REMOVED***settings);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***删除用户播放设置
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Delete("DELETE***REMOVED***FROM***REMOVED***user_play_settings***REMOVED***WHERE***REMOVED***user_id***REMOVED***=***REMOVED***#{userId}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***deleteByUserId(@Param("userId")***REMOVED***Long***REMOVED***userId);
}
