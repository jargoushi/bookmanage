package com.bijian.bookmanage.mapper;

import com.bijian.bookmanage.domain.Book;
import com.bijian.bookmanage.response.Analyse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    Book selectByPrimaryKey(Integer id);

    List<Book> selectAll();

    int updateByPrimaryKey(Book record);

    String queryMostExpensiveName();

    String queryEarliestName();

    Analyse summaryAmountAndCount();

    List<Book> getBookListByCategoryName(String categoryName);

    Book getBookByTitle(String title);

    List<Book> getBookListMatchingTitle(String title);

    List<String> groupByCategory();

    List<Book> queryBooksByCategory(String category);

    List<String> groupByPress();

    List<Book> queryBooksByPress(String press);
}