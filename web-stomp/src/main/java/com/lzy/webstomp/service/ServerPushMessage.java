package com.lzy.webstomp.service;

import com.lzy.webstomp.entity.ServerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ServerPushMessage {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    //客户端只要订阅了/topic/subscribeTest主题，调用这个方法即可向他主动发送消息
    public void templateTest() {
        messagingTemplate.convertAndSend("/topic/subscribeTest", new ServerMessage("服务器主动推的数据"));
    }
}
