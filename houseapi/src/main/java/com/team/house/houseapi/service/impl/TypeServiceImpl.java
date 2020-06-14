package com.team.house.houseapi.service.impl;


import com.team.house.houseapi.entity.Type;
import com.team.house.houseapi.entity.TypeExample;
import com.team.house.houseapi.mapper.TypeMapper;
import com.team.house.houseapi.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> getAllType() {
        return typeMapper.selectByExample(new TypeExample());
    }
}
