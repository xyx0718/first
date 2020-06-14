package com.team.house.houseapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.houseapi.entity.House;
import com.team.house.houseapi.mapper.HouseMapper;
import com.team.house.houseapi.service.HouseService;
import com.team.house.houseapi.utils.HouseCondition;
import com.team.house.houseapi.utils.PageParmeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getHouseByUser(PageParmeter pageParmeter,Integer userid) {
        PageHelper.startPage(pageParmeter.getPage(),pageParmeter.getPageSize());
        List<House> list = houseMapper.getHouseByUser(userid);
        return new PageInfo<>(list);
    }

    @Override
    public int deleteHouse(String id, Integer delState) {
        House house = new House();
        house.setId(id);
        house.setIsdel(delState);
        return this.houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getBroswerHouse(HouseCondition houseCondition) {
        PageHelper.startPage(houseCondition.getPage(),houseCondition.getPageSize());
        List<House> list = this.houseMapper.browserHouse(houseCondition);
        return new PageInfo<House>(list);
    }

}














