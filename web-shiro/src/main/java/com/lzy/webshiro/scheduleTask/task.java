package com.lzy.webshiro.scheduleTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class task {

    @Scheduled(cron = "0 0 17 * * ?")
    private void test() {
        System.out.println("执行定时任务:17:00");
    }
}
