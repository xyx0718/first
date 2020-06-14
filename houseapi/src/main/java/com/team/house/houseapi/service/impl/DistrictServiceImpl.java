package com.team.house.houseapi.service.impl;


import com.team.house.houseapi.entity.District;
import com.team.house.houseapi.entity.DistrictExample;
import com.team.house.houseapi.mapper.DistrictMapper;
import com.team.house.houseapi.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> getAllDistrict() {
        return districtMapper.selectByExample(new DistrictExample());
    }
}
