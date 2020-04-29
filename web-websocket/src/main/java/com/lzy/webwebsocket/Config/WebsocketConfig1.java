package com.lzy.webwebsocket.Config;

import com.lzy.webwebsocket.handler.MyHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * WebSocket两种使用使用方式：
 * 方式一：通过@EnableWebSocket，实现WebSocketConfigurer接口注册websocketHandler（绑定handler和客户端）
 * 方式二：通过注解@ServerEndpoint(value = "/test2")
 */
@Configuration
@EnableWebSocket
public class WebsocketConfig1 implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(myHandler(),"/test");
    }

    @Bean
    public MyHandler myHandler(){
        return new MyHandler();
    }
}
