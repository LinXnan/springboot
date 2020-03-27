package com.example.websocket.configation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Map;

/**
 * describe:
 *
 * @author 林旭南(linxnsz @ sinosoft.com.cn)
 * @date 2020-03-27 下午 04:38
 */
public class MyPrincipalHandshakeHandler extends DefaultHandshakeHandler {
    private static final Logger log = LoggerFactory.getLogger(MyPrincipalHandshakeHandler.class);

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {

        HttpSession httpSession = getSession(request);
        // 获取登录的信息，就是controller 跳转页面存的信息，可以根据业务修改
        String user = (String)httpSession.getAttribute("loginName");

        if(StringUtils.isEmpty(user)){
            log.error("未登录系统，禁止登录websocket!");
            return null;
        }
        log.info(" MyDefaultHandshakeHandler login = " + user);
        return new WebSocketUserAuthentication(user);
    }

    private HttpSession getSession(ServerHttpRequest request) {
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest serverRequest = (ServletServerHttpRequest) request;
            return serverRequest.getServletRequest().getSession(false);
        }
        return null;
    }
}
