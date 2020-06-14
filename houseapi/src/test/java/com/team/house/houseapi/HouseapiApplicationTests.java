package com.team.house.houseapi;

import com.team.house.houseapi.entity.DistrictExample;
import com.team.house.houseapi.mapper.DistrictMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseapiApplicationTests {

    @Autowired(required = false)
    private DistrictMapper districtMapper;

    @Test
    public void contextLoads() {
        System.out.println("测试:" + districtMapper.selectByExample(new DistrictExample()).size());
    }
}
