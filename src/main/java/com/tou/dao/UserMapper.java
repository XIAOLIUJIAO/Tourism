package com.tou.dao;

import com.tou.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public User login(@Param("username") String username, @Param("password") String password);
}
