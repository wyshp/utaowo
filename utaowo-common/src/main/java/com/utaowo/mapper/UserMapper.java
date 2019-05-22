package com.utaowo.mapper;

import com.utaowo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User queryByOpenId(@Param("openId") String openId);

    int save(User user);

    int update(User user);
}
