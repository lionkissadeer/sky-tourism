package com.skytech.skytourism.usermanagement.domain.model;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Lianhong_ on 2018/05/18 11:54
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private String id;

    private String name;
    private String password;
    private String gender;
    private Integer age;
    private Date birthday;
    private String remark;

    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.password = "p@ssw0rd";
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
