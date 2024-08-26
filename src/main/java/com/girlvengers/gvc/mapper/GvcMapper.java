package com.girlvengers.gvc.mapper;
import java.util.List;

import com.girlvengers.gvc.vo.GvcVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GvcMapper {
    List<GvcVo> selectTest();
}
