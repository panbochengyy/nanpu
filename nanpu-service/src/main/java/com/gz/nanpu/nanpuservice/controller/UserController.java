package com.gz.nanpu.nanpuservice.controller;

import com.gz.nanpu.nanpuservice.entity.User;
import com.gz.nanpu.nanpuservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public User getUser(@PathVariable int id){
        return userService.Sel(id);
    }

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"},consumes = "application/json")
    public int addUser(@RequestBody User user){
        return userService.addUser(user);
    }



    @ResponseBody
    @RequestMapping(value = "/delete", produces = {"application/json;charset=UTF-8"},consumes = "application/json")
    public int deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/update", produces = {"application/json;charset=UTF-8"},consumes = "application/json")
    public int updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/findAllUser/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public List<User> findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return userService.findAllUser(pageNum,pageSize);
    }


    @ResponseBody
    @RequestMapping(value = "/findUserList", produces = {"application/json;charset=UTF-8"})
    public  Map<String,Object> findUserList(@RequestParam(value="pageNum") Integer pageNum, @RequestParam(value="pageSize") Integer pageSize){
        return userService.findUserList(pageNum,pageSize);
    }


}
