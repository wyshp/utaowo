package com.utaowo.service;

import com.utaowo.entity.User;
import com.utaowo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @AUTHOR WYS
 * @DATE 2019-05-22
 * @VERSION v1.0
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryByOpenId(String openId) {
        return userMapper.queryByOpenId(openId);
    }

    public void save(User user){
        userMapper.save(user);
    }

    public void update(User user){
        userMapper.update(user);
    }
}
