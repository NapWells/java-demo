package com.liu.takeout.dao;

import com.liu.takeout.pojo.Rider;

public interface RiderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Rider record);

    int insertSelective(Rider record);

    Rider selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Rider record);

    int updateByPrimaryKey(Rider record);
}