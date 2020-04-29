package com.dlz.rabbitmq.enums;

public enum ExchangeEnum {

    EXCHANGE_1("exchange1"),EXCHANGE_2("exchange2"),EXCHANGE_3("exchange3");

    public final String name;

    ExchangeEnum(String name) {
        this.name = name;
    }
}
