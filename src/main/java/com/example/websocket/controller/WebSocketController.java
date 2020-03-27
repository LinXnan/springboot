package com.example.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * describe:
 *
 * @author 林旭南(linxnsz @ sinosoft.com.cn)
 * @date 2020-03-27 下午 04:56
 */
@Controller
@RequestMapping("/websocket")
public class WebSocketController {

    // 跳转stomp websocket 页面
    @GetMapping("/spring/stompSocket")
    public String toStompWebSocket(HttpSession session, HttpServletRequest request, Model model)
    {
        // 这里封装一个登录的用户组参数，模拟进入通讯后的简单初始化
        model.addAttribute("groupId","user_groupId");
        model.addAttribute("session_id",session.getId());
        System.out.println("跳转：" + session.getId());
        session.setAttribute("loginName",session.getId());
        return "/websocket/simple/ws-broadcast";

    }
}
