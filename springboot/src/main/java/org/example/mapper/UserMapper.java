package***REMOVED***org.example.mapper;

import***REMOVED***org.apache.ibatis.annotations.*;
import***REMOVED***org.example.entity.User;

import***REMOVED***java.util.List;

/**
***REMOVED*******REMOVED***用户数据访问层
***REMOVED****/
@Mapper
public***REMOVED***interface***REMOVED***UserMapper***REMOVED***{

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***根据用户名查询用户
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED*******REMOVED***FROM***REMOVED***user***REMOVED***WHERE***REMOVED***username***REMOVED***=***REMOVED***#{username}***REMOVED***AND***REMOVED***status***REMOVED***=***REMOVED***1")
***REMOVED******REMOVED******REMOVED******REMOVED***User***REMOVED***findByUsername(@Param("username")***REMOVED***String***REMOVED***username);


***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***根据ID查询用户
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED*******REMOVED***FROM***REMOVED***user***REMOVED***WHERE***REMOVED***id***REMOVED***=***REMOVED***#{id}***REMOVED***AND***REMOVED***status***REMOVED***=***REMOVED***1")
***REMOVED******REMOVED******REMOVED******REMOVED***User***REMOVED***findById(@Param("id")***REMOVED***Long***REMOVED***id);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***插入用户
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Insert("INSERT***REMOVED***INTO***REMOVED***user***REMOVED***(username,***REMOVED***password,***REMOVED***nickname,***REMOVED***avatar,***REMOVED***create_time,***REMOVED***update_time,***REMOVED***status)***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"VALUES***REMOVED***(#{username},***REMOVED***#{password},***REMOVED***#{nickname},***REMOVED***#{avatar},***REMOVED***#{createTime},***REMOVED***#{updateTime},***REMOVED***#{status})")
***REMOVED******REMOVED******REMOVED******REMOVED***@Options(useGeneratedKeys***REMOVED***=***REMOVED***true,***REMOVED***keyProperty***REMOVED***=***REMOVED***"id")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***insert(User***REMOVED***user);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***更新用户信息（允许部分字段更新）。
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***使用***REMOVED***COALESCE***REMOVED***在传入为***REMOVED***NULL***REMOVED***时保留原值。
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Update("UPDATE***REMOVED***user***REMOVED***SET***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"nickname***REMOVED***=***REMOVED***COALESCE(#{nickname},***REMOVED***nickname),***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"avatar***REMOVED***=***REMOVED***COALESCE(#{avatar},***REMOVED***avatar),***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"update_time***REMOVED***=***REMOVED***#{updateTime}***REMOVED***"***REMOVED***+
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***"WHERE***REMOVED***id***REMOVED***=***REMOVED***#{id}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***updateUserInfo(User***REMOVED***user);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***更新密码
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Update("UPDATE***REMOVED***user***REMOVED***SET***REMOVED***password***REMOVED***=***REMOVED***#{password},***REMOVED***update_time***REMOVED***=***REMOVED***#{updateTime}***REMOVED***WHERE***REMOVED***id***REMOVED***=***REMOVED***#{id}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***updatePassword(@Param("id")***REMOVED***Long***REMOVED***id,***REMOVED***@Param("password")***REMOVED***String***REMOVED***password,***REMOVED***@Param("updateTime")***REMOVED***java.time.LocalDateTime***REMOVED***updateTime);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***检查用户名是否存在
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED***COUNT(*)***REMOVED***FROM***REMOVED***user***REMOVED***WHERE***REMOVED***username***REMOVED***=***REMOVED***#{username}")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***checkUsernameExists(@Param("username")***REMOVED***String***REMOVED***username);


***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***获取所有用户（分页）
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED*******REMOVED***FROM***REMOVED***user***REMOVED***WHERE***REMOVED***status***REMOVED***=***REMOVED***1***REMOVED***ORDER***REMOVED***BY***REMOVED***create_time***REMOVED***DESC***REMOVED***LIMIT***REMOVED***#{offset},***REMOVED***#{limit}")
***REMOVED******REMOVED******REMOVED******REMOVED***List<User>***REMOVED***findAll(@Param("offset")***REMOVED***int***REMOVED***offset,***REMOVED***@Param("limit")***REMOVED***int***REMOVED***limit);

***REMOVED******REMOVED******REMOVED******REMOVED***/**
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED*******REMOVED***获取用户总数
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED****/
***REMOVED******REMOVED******REMOVED******REMOVED***@Select("SELECT***REMOVED***COUNT(*)***REMOVED***FROM***REMOVED***user***REMOVED***WHERE***REMOVED***status***REMOVED***=***REMOVED***1")
***REMOVED******REMOVED******REMOVED******REMOVED***int***REMOVED***countAll();
}
