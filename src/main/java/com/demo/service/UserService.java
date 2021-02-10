package com.demo.service;

import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> selectAllUser() {
        return userMapper.selectAll();
    }

    public int addUser(User user) {
        String id= StringUtils.replace(UUID.randomUUID().toString(),"-","");
        user.setId(id);
        return userMapper.insert(user);
    }

    public List<User> selectByDistance(String lng, String lat, String dis){

        List<User> users = userMapper.selectByDistance(lng, lat, dis);
        String latitude = users.get(0).getGis().getLat().toString();
        String longitude = users.get(0).getGis().getLng().toString();
        System.out.println(latitude +" "+ longitude);
        return users;
    }

}
