package com.team.house.houseapi.controller;

import com.team.house.houseapi.entity.Users;
import com.team.house.houseapi.service.UsersService;
import com.team.house.houseapi.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user/")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("regUser")
    public BaseResult regUser(Users users){
        //调用业务
        int temp = usersService.regUser(users);

        if (temp>0){
            return new BaseResult(BaseResult.RESULT_SUCCESS,"");
        }else {
            return new BaseResult(BaseResult.RESULT_FAIL,"出错了");
        }
    }

    @RequestMapping("userLogin")
    public BaseResult userLogin(HttpSession session,String username, String password){
        Users users = usersService.Login(username, password);
        if (users==null){
            return new BaseResult(BaseResult.RESULT_FAIL,"用户名或密码错误");
        }else {
            session.setAttribute("loginInfo",users);
            session.setMaxInactiveInterval(6000);
            return new BaseResult(BaseResult.RESULT_SUCCESS,"");
        }
    }
}
