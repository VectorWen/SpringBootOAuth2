package com.vector.security.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * author: vector.huang
 * date: 2018/09/19 21:09
 */
@Entity
@Table(name = "oauth_authority")
public class OAuthAuthority implements GrantedAuthority {

    private Integer id;
    private String authority;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
