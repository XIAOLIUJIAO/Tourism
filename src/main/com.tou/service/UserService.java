package service;

import entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

public interface UserService {
    public User login(String username,String password);
}
