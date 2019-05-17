package com.utaowo.mapper;

import com.utaowo.entity.Ad;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface AdMapper {

    public List<Ad> getAll();
}
