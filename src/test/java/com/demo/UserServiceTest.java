package com.demo;

import com.demo.common.mybatis.GeoPoint;
import com.demo.pojo.User;
import com.demo.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.math.BigDecimal;



public class UserServiceTest extends BaseTest{
    @Autowired
    UserService userService;

    @Test
    public void testAddUser(){
        User user = new User();
        user.setGis(new GeoPoint(new BigDecimal("121.312"), new BigDecimal("25.431")));
        user.setName("julian");
        user.setId("1");
        userService.addUser(user);
        Assertions.assertEquals(2, userService.selectAllUser().size());
    }
}
