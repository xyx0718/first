package com.team.house.houseapi.service;

import com.team.house.houseapi.entity.Street;

import java.util.List;

public interface StreetService {
    //查询街道
    public List<Street> getStreetByDid(Integer did);
}
