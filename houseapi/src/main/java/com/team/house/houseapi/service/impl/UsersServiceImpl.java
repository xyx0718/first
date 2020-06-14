package com.team.house.houseapi.service.impl;

import com.team.house.houseapi.entity.Users;
import com.team.house.houseapi.mapper.UsersMapper;
import com.team.house.houseapi.service.UsersService;
import com.team.house.houseapi.entity.UsersExample;

import com.team.house.houseapi.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int regUser(Users users) {
        //导入md5工具类
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        return usersMapper.insertSelective(users);
    }

    @Override
    public Users Login(String username, String password) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(username);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> list = usersMapper.selectByExample(usersExample);
        if (list!=null&&list.size()==1){
            return list.get(0);
        }else
        return null;
    }
}
