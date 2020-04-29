package com.bijian.bookmanage.mapper;

import com.bijian.bookmanage.domain.Contents;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Contents record);

    Contents selectByPrimaryKey(Integer id);

    List<Contents> selectAll();

    int updateByPrimaryKey(Contents record);

    Contents selectByBookId(String bookId);
}