package com.utaowo.mapper;

import com.utaowo.entity.Ad;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdMapper {

    public List<Ad> queryList(@Param("adType") Integer adType);
}
