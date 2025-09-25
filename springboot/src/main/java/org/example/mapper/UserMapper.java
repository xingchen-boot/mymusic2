package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.entity.User;

import java.util.List;

/**
 * 用户数据访问层
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户名查询用户
     */
    @Select("SELECT * FROM user WHERE username = #{username} AND status = 1")
    User findByUsername(@Param("username") String username);


    /**
     * 根据ID查询用户
     */
    @Select("SELECT * FROM user WHERE id = #{id} AND status = 1")
    User findById(@Param("id") Long id);

    /**
     * 插入用户
     */
    @Insert("INSERT INTO user (username, password, nickname, avatar, create_time, update_time, status) " +
            "VALUES (#{username}, #{password}, #{nickname}, #{avatar}, #{createTime}, #{updateTime}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);

    /**
     * 更新用户信息（允许部分字段更新）。
     * 使用 COALESCE 在传入为 NULL 时保留原值。
     */
    @Update("UPDATE user SET " +
            "nickname = COALESCE(#{nickname}, nickname), " +
            "avatar = COALESCE(#{avatar}, avatar), " +
            "update_time = #{updateTime} " +
            "WHERE id = #{id}")
    int updateUserInfo(User user);

    /**
     * 更新密码
     */
    @Update("UPDATE user SET password = #{password}, update_time = #{updateTime} WHERE id = #{id}")
    int updatePassword(@Param("id") Long id, @Param("password") String password, @Param("updateTime") java.time.LocalDateTime updateTime);

    /**
     * 检查用户名是否存在
     */
    @Select("SELECT COUNT(*) FROM user WHERE username = #{username}")
    int checkUsernameExists(@Param("username") String username);


    /**
     * 获取所有用户（分页）
     */
    @Select("SELECT * FROM user WHERE status = 1 ORDER BY create_time DESC LIMIT #{offset}, #{limit}")
    List<User> findAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 获取用户总数
     */
    @Select("SELECT COUNT(*) FROM user WHERE status = 1")
    int countAll();
}
