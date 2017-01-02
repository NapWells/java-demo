package com.liu.takeout.dao;

import com.liu.takeout.pojo.Product;
import com.liu.takeout.pojo.ProductKey;

public interface ProductMapper {
    int deleteByPrimaryKey(ProductKey key);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(ProductKey key);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}