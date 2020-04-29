package com.lzy.webwebsocket.Controller;

import com.lzy.webwebsocket.handler.MyWebsocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsocketController {

    @Autowired
    private MyWebsocket myWebsocket;

    @GetMapping("test2")
    public String websocket2(){
        return "test2";
    }

    @GetMapping("test1")
    public String websocket1(){
        return "test1";
    }

    @GetMapping("innerTrigger")
    public String test(){
        myWebsocket.sendAll("内部调用");
        return "innerTrigger";
    }

}
