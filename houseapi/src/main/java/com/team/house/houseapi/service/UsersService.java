package com.team.house.houseapi.service;

import com.team.house.houseapi.entity.Users;


public interface UsersService {
    //实现注册
    public int regUser(Users users);

    //登录
    public Users Login(String username,String password);
}
