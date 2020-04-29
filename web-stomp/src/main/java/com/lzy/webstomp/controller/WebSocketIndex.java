package com.lzy.webstomp.controller;

import com.lzy.webstomp.service.ServerPushMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebSocketIndex {
    @Autowired
    private ServerPushMessage pushMessage;

    @GetMapping("/websocket")
    public String index(){
        return "websocket";
    }

    @PostMapping("/pushMessage")
    @ResponseBody
    public void pushMessage(){
        pushMessage.templateTest();
    }

}
