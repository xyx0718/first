package com.team.house.houseapi.controller;


import com.github.pagehelper.PageInfo;
import com.team.house.houseapi.entity.House;
import com.team.house.houseapi.entity.Users;
import com.team.house.houseapi.service.HouseService;
import com.team.house.houseapi.utils.BaseResult;
import com.team.house.houseapi.utils.FileUploadUtil;
import com.team.house.houseapi.utils.HouseCondition;
import com.team.house.houseapi.utils.PageParmeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/house/")

public class HouseController {
    @Autowired
    private HouseService houseService;
    //发布出租房
    @RequestMapping("upHouseData")
    //@CrossOrigin(value = "*",allowCredentials ="true")
    public BaseResult upHouseData(
            House house,   //接收输入的内容
            @RequestParam(value = "pfile",required = false) MultipartFile pfile,
            HttpSession session){
        //一、实现文件上传
        //注意：a.将上传的文件保存到文件服务器中(d://images充当文件服务器)
        //     b.一个上传的文件域对应一个MultipartFile类的对象
        try {
            //利用上传文件的工具类实现上传文件
            String path="E:\\images";
            String fileName= FileUploadUtil.upload(pfile,path);
            //二、将输入的出租房信息保存到数据库
            //设置出租房的随机唯一编号(采用时间毫秒)
            house.setId(System.currentTimeMillis()+"");
            //设置当前所属的用户编号
            //Users users=(Users)session.getAttribute("logininfo");
            //house.setUserId(users.getId());  //设置用户编号

            //设置上传文件路径
            house.setPath(fileName);
            //调用业务保存信息
            houseService.addHouse(house);
            return new BaseResult(BaseResult.RESULT_SUCCESS,"");
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(BaseResult.RESULT_FAIL,"发布失败:"+e.getMessage());
        }
    }

    //获取用户出租房信息
    @RequestMapping("getHouseByPage")
    public BaseResult getHouseByPage(PageParmeter pageParmeter,HttpSession session){
        //调用业务获取分页信息
        //Users users = (Users) session.getAttribute("loginInfo");
        Integer userid = 1007;
        PageInfo<House> pageInfo = this.houseService.getHouseByUser(pageParmeter,userid);
        //返回总页数，当前页的数据
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("totalPage",pageInfo.getPages());   //总页数
        map.put("row",pageInfo.getList());  //当前页的数据
        return new BaseResult(200,map);
    }

    //删除
    @RequestMapping("delHouse")
    public BaseResult delHouse(String id){
        //1表示删除
        int temp = this.houseService.deleteHouse(id, 1);
        if (temp>0) {
            return new BaseResult(BaseResult.RESULT_SUCCESS, "");
        }
        else {
            return new BaseResult(BaseResult.RESULT_FAIL, "失败");
        }
    }

    //浏览出租房 houseCondition接受前端所有的数据
    @RequestMapping("searchHouse")
    public BaseResult searchHouse(HouseCondition houseCondition){
        //1表示删除
        PageInfo<House> list = this.houseService.getBroswerHouse(houseCondition);
        //封装返回数据
        Map<String,Object> map = new HashMap<>();
        map.put("curPage",list.getPageNum());
        map.put("totalPage",houseCondition.getPageSize());
        map.put("list",list.getList());
        return new BaseResult(200,map);
    }

}






















