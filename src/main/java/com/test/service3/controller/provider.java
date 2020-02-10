package com.test.service3.controller;

import com.test.service3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Lei
 * @Date 2020/2/9 16:43
 * @Version 1.0
 */

@RestController
@RequestMapping("/provider")
public class provider {

    @Value("${eureka.instance.metadata-map.version}")
    private String version;
    @GetMapping("/getServiceInfo")
    public String getVersion(){
        return this.version;
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable("id")int id){
        User a = new User();
        a.setAge(id);
        a.setName("service3");
        return a;
    }

    @GetMapping("/only")
    public String a(){
        return "only 2.0 have";
    }
}
