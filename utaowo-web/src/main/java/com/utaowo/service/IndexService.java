package com.utaowo.service;

import com.utaowo.entity.Ad;
import com.utaowo.mapper.AdMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @AUTHOR WYS
 * @DATE 2019-05-20
 * @VERSION v1.0
 */
@Service
public class IndexService {

    @Autowired
    private AdMapper adMapper;

    public List<Ad> queryList(Integer adType){
        return adMapper.queryList(adType);
    }
}
