package com.vector.security.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * author: vector.huang
 * date: 2018/09/19 20:26
 */
@Entity
@Table(name = "user")
public class User {

    private Integer id;
    private String nickname;       //昵称，唯一的，可用于登录，也用于显示
    private String phone;          //电话号码，唯一的，可用于登录
    private String avatar;         //头像
    private String password;       //密码
    private Integer enabled;        //用户冻结状态
    private Integer sex;
    private Integer status;
    private Timestamp created;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
