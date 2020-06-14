package com.team.house.houseapi.service;

import com.github.pagehelper.PageInfo;
import com.team.house.houseapi.entity.House;
import com.team.house.houseapi.utils.HouseCondition;
import com.team.house.houseapi.utils.PageParmeter;

public interface HouseService {
    //发布出租房
    public int addHouse(House house);
    //查询某用户下的出租房
    public PageInfo<House> getHouseByUser(PageParmeter pageParmeter,Integer userid);

    //删除\恢复
    public int deleteHouse(String id,Integer delState);

    //浏览出租房
    public PageInfo<House> getBroswerHouse(HouseCondition houseCondition);
}
