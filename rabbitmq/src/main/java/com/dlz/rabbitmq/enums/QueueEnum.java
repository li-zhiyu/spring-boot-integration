package com.dlz.rabbitmq.enums;

public enum QueueEnum {
    QUEUE_1("queue1"),
    QUEUE_2("queue2"),
    QUEUE_3("queue3");

    public final String name;

    QueueEnum(String name) {
        this.name = name;
    }
}
