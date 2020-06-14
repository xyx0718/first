package com.team.house.houseapi.mapper;

import com.team.house.houseapi.entity.House;
import com.team.house.houseapi.entity.HouseExample;
import com.team.house.houseapi.utils.HouseCondition;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    //查询某用户下的所有出租房
    //修改实体添加 添加关联属性 区域名称 类型名称 街道名称
    List<House> getHouseByUser(Integer id);

    //浏览出租房
    List<House> browserHouse(HouseCondition houseCondition);
}