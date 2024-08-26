package com.girlvengers.gvc.service;

import com.girlvengers.gvc.mapper.GvcMapper;
import com.girlvengers.gvc.vo.GvcVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GvcService {

    @Autowired
    public GvcMapper mapper;

    public List<GvcVo> selectTest(){
        return mapper.selectTest();
    }
}
