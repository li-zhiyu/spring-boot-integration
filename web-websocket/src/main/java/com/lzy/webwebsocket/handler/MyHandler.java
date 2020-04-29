package com.lzy.webwebsocket.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class MyHandler extends TextWebSocketHandler {

    private static Map<String, WebSocketSession> clients = new ConcurrentHashMap<>();

    private static final Logger logger = LoggerFactory.getLogger(MyHandler.class);
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("接收到客户端消息:"+message.getPayload());
        /**
         * 接收客户端传过来的消息，进行业务处理。。。。
         */
        TimeUnit.SECONDS.sleep(1);
        session.sendMessage(new TextMessage(message.getPayload()));//发送消息给客户端
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("建立WebSocket连接");
        clients.put(session.getId(),session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("关闭WebSocket连接");
        clients.remove(session.getId());
    }

    /**
     * 给某个用户发送消息
     *
     */
    public void sendMessageToUser(String sessionId, TextMessage message) {
        for (WebSocketSession client : clients.values()) {
            if (client.getId().equals(sessionId)) {
                try {
                    if (client.isOpen()) {
                        client.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession client : clients.values()) {
            try {
                if (client.isOpen()) {
                    client.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
