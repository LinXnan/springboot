package com.example.websocket.configation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * describe:
 *
 * @author 林旭南(linxnsz @ sinosoft.com.cn)
 * @date 2020-03-27 下午 06:03
 */
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {
    private Logger logger = LoggerFactory.getLogger(WebSocketHandshakeInterceptor.class);
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        HttpSession session = getSession(request);
        if(session == null ){
            logger.error("websocket权限拒绝");
            return false;
        }
        attributes.put("HTTP_SESSION",session);
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }
    private HttpSession getSession(ServerHttpRequest request) {
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest serverRequest = (ServletServerHttpRequest) request;
            return serverRequest.getServletRequest().getSession(false);
        }
        return null;
    }
}
