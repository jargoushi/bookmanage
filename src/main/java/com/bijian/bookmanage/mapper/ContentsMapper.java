package com.bijian.bookmanage.mapper;

import com.bijian.bookmanage.domain.Contents;
import java.util.List;

public interface ContentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Contents record);

    Contents selectByPrimaryKey(Integer id);

    List<Contents> selectAll();

    int updateByPrimaryKey(Contents record);
}