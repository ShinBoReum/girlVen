package com.girlvengers.gvc.mapper;

import com.girlvengers.gvc.vo.CSVVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CSVMapper {
    
    List<CSVVo> selectRateList();

    int saveAll(List<CSVVo> rateData);
}
