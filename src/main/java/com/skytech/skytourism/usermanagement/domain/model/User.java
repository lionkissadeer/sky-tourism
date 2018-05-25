package com.skytech.skytourism.usermanagement.domain.model;



import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Lianhong_ on 2018/05/18 11:54
 */
@Entity
@Table(name = "user")
public class User implements Serializable, Identifiable<String> {

    @Id
    @GeneratedValue
    private String id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private Integer age;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "remark")
    private String remark;
    @Column(name = "role")
    private String role;

    public User() {
    }

    public User(String id, String username, String gender, Integer age, String birthday, String remark) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
