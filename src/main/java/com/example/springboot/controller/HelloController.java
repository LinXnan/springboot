package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * describe:
 *
 * @author 林旭南(linxnsz @ sinosoft.com.cn)
 * @date 2020-03-26 下午 02:49
 */
@Controller
public class HelloController {
    @RequestMapping("/sayHello")
    public String sayHello(Model model){
        model.addAttribute("welcome","hello world");
        return "hello";
    }
}
