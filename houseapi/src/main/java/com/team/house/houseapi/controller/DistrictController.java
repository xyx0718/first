package com.team.house.houseapi.controller;

import com.team.house.houseapi.entity.District;
import com.team.house.houseapi.service.DistrictService;
import com.team.house.houseapi.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/district/")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("getDistrictData")
    public BaseResult getDistrictData(){
        List<District> list = districtService.getAllDistrict();
        return new BaseResult(200,list);
    }
}
