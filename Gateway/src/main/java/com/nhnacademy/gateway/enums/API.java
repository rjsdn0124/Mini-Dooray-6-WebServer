package com.nhnacademy.gateway.enums;

public enum API {
    ACCOUNT("http://localhost:8081/api"), TASK("http://localhost:8082/api");
    String domain;

    API(String domain){
        this.domain = domain;
    }

    public String toString(){
        return this.domain;
    }
}
