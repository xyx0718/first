package com.team.house.houseapi.controller;


import com.team.house.houseapi.entity.Street;
import com.team.house.houseapi.service.StreetService;
import com.team.house.houseapi.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/street/")
public class StreetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("getStreetData")
    public BaseResult getStreetData(Integer did){
        List<Street> list = streetService.getStreetByDid(did);
        return new BaseResult(200,list);
    }
}
