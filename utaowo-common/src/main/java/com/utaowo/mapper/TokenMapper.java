package com.utaowo.mapper;

import com.utaowo.entity.Token;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenMapper{

    Token queryByUserId(@Param("userId") Long userId);

    Token queryByToken(@Param("token") String token);

    int save(Token token);

    int update(Token token);
}
