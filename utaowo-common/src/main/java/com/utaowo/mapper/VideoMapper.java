package com.utaowo.mapper;

import com.utaowo.entity.Video;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoMapper {

    public List<Video> queryList();
}
