package com.gz.nanpu.nanpuservice.controller;


import com.gz.nanpu.nanpuservice.api.BaseApiService;
import com.gz.nanpu.nanpuservice.entity.User;
import com.gz.nanpu.nanpuservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/userController")
public class UserController extends BaseApiService {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/getUser/{id}", produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> GetUser(@PathVariable int id){
       return  setResutSuccessData(userService.Sel(id));
    }


    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap){
        Map<String,Object> userList = userService.findUserList(1,4);
        System.out.println(userList);
        List<User> list = (List<User>)userList.get("list");
        modelMap.put("userList",list);
        modelMap.put("error","0000");
        modelMap.put("success","ok****");
        return  "ftl/index";
    }

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> addUser(User user){
        int j= userService.addUser(user);
        if(j>0){
            return  setResutSuccess();
        }else{
            return  setResutError("添加失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/update", produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> updateUser(User user){
       int j= userService.updateUser(user);
        if(j>0){
            return  setResutSuccess();
        }else{
            return  setResutError("更新失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> deleteUser(User user){
        int j= userService.deleteUser(user);
        if(j>0){
            return  setResutSuccess();
        }else{
            return  setResutError("删除失败");
        }
    }


    @ResponseBody
    @RequestMapping(value = "/findAllUser/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        return  setResutSuccessData(userService.findAllUser(pageNum,pageSize));
    }

}
