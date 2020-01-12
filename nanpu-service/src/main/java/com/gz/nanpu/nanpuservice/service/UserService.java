package com.gz.nanpu.nanpuservice.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gz.nanpu.nanpuservice.Mapper.UserMapper;
import com.gz.nanpu.nanpuservice.entity.User;
import com.gz.nanpu.nanpuservice.query.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User Sel(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }


    public int addUser(User user){
        return userMapper.insert(user);
    }

    public int updateUser(User user){
        return userMapper.updateByPrimaryKey(user);
    }

    public int deleteUser(User user){
        return userMapper.deleteByPrimaryKey(user.getId());
    }

    public List<User> findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        //设置分页信息
        PageHelper.startPage(pageNum, pageSize);
        UserExample example=new UserExample();
        return userMapper.selectByExample(example);
    }

   public Map<String,Object> findUserList(Integer pageNo, Integer pageSize){
        //设置分页信息
        PageHelper.startPage(pageNo,pageSize);
        UserExample example=new UserExample();
        List<User> users = userMapper.selectByExample(example);
        PageInfo<User> result=new PageInfo<>(users);
        List<User> list = result.getList();

        Map<String,Object> maps=new HashMap<>();
        maps.put("list",list);
        return maps;
    }

}
