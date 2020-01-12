package com.gz.nanpu.nanpuservice.service;

import com.gz.nanpu.nanpuservice.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Service
@FeignClient(name= "NANPU-SERVICE")
public interface  UserService {

    @RequestMapping(value = "/user/getUser/{id}", method = RequestMethod.GET)
    public User Sel(@RequestParam(value="id") Integer id);

    @RequestMapping(value = "/user/findAllUser/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public List<User> findAllUser(@RequestParam(value="pageNum") int pageNum,@RequestParam(value="pageSize") int pageSize);

    @RequestMapping(value = "/user/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer addUser(@RequestBody User user);

    @RequestMapping(value = "/user/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer updateUser(@RequestBody User user);

    @RequestMapping(value = "/user/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer deleteUser(@RequestBody User user);

    @RequestMapping(value = "/user/findUserList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> findUserList(@RequestParam(value="pageNum") int pageNum,@RequestParam(value="pageSize") int pageSize);

}
