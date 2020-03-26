package com.example.springboot.controller;

import com.example.springboot.dto.Gentor;
import com.example.springboot.dto.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * describe:
 *
 * @author 林旭南(linxnsz @ sinosoft.com.cn)
 * @date 2019-12-25 下午 02:51
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;



    @GetMapping("/list")
    public List<User> findAll() {
        System.out.println(userService.findAll().get(0).getGentor().getValue());
        return userService.findAll();
    }

    @GetMapping("/save")
    public void save(){
        User user = new User();
        user.setBirthday(new Date());
        user.setGentor(Gentor.MAN);
        user.setName("hhhh");
        userService.insert(user);
    }

    @PostMapping("/add")
    public String add(@RequestBody @Valid User user){
        userService.insert(user);
        return "success";
    }
}
