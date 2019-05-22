package com.utaowo.service;

import com.utaowo.entity.Video;
import com.utaowo.mapper.VideoMapper;
import java.util.List;
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
public class VideoService {

    @Autowired
    private VideoMapper videoMapper;

    public List<Video> queryVideoList(){
        return videoMapper.queryList();
    }

}
