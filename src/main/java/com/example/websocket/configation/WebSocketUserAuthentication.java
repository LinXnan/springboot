package com.example.websocket.configation;

import java.security.Principal;

/**
 * describe:用于保存websocket连接过程中需要存储的业务参数
 *
 * @author 林旭南(linxnsz @ sinosoft.com.cn)
 * @date 2020-03-27 下午 04:34
 */
public class WebSocketUserAuthentication implements Principal {

    /**
     * 用户身份标识符
     */
    private String token;

    public WebSocketUserAuthentication(String token) {
        this.token = token;
    }

    public WebSocketUserAuthentication() {
    }

    /**
     * 获取用户登录令牌
     * @return
     */
    @Override
    public String getName() {
        return token;
    }
}
