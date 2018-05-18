package com.skytech.skytourism.usermanagement.domain.model;

import java.io.Serializable;

/**
 * Created by Lianhong_ on 2018/05/18 11:54
 */
public class User implements Serializable {

    private String id;
    private String name;

    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
