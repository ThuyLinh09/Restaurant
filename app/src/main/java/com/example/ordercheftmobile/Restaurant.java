package com.example.ordercheftmobile;


import java.io.Serializable;

public class Restaurant implements Serializable {
    private final String name;
    private final String lastAccess;

    public Restaurant(String name, String lastAccess) {
        this.name = name;
        this.lastAccess = lastAccess;
    }

    public String getName() {
        return name;
    }

    public String getLastAccess() {
        return lastAccess;
    }
}
