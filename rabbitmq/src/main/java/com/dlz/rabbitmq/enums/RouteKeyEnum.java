package com.dlz.rabbitmq.enums;

public enum  RouteKeyEnum {
    ROUTEKEY_1("route1"),
    ROUTEKEY_2("route2"),
    ROUTEKEY_3("route3");

    public final String name;

    RouteKeyEnum(String name) {
        this.name = name;
    }
}
