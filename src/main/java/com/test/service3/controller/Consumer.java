package com.test.service3.controller;

import com.test.service3.entity.User;
import com.test.service3.utils.MSendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Lei
 * @Date 2020/2/8 23:34
 *
 * @Version 1.0
 */

@RequestMapping("/consumer")
@RestController
public class Consumer {

    @Autowired
    private MSendRequest mSendRequest;

    @GetMapping("/get1")
    public User f(){
        return mSendRequest.sendRequest("http://gateway/service2/provider/getTest","1.0.0", User.class, RequestMethod.GET);
    }
    @GetMapping("/get2")
    public User as(){
        return mSendRequest.sendRequest("http://gateway/service2/provider/getTest", User.class, RequestMethod.GET);
    }
    @GetMapping("/get3")
    public User asa(){
        User user = new User();
        user.setAge(1);
        user.setName("adf");
        user.setUsername("asdasa");
        return mSendRequest.sendRequest("http://gateway/service2/provider/postTest", User.class, RequestMethod.POST,user);
    }

    @GetMapping("/get4")
    public String a(){
        return mSendRequest.sendRequest("http://gateway/service2/provider/only", String.class, RequestMethod.GET);
    }
}
