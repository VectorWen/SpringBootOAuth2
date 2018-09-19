package com.vector.security.model;

import javax.persistence.*;

/**
 * author: vector.huang
 * date: 2018/09/19 21:10
 */
@Entity
@Table(name = "oauth_user_authority")
public class OauthUserAuthority {

    private Integer id;
    private Integer userId;
    private OAuthAuthority oauthAuthority;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @OneToOne
    @JoinColumn(name = "authorityId")
    public OAuthAuthority getOauthAuthority() {
        return oauthAuthority;
    }

    public void setOauthAuthority(OAuthAuthority oauthAuthority) {
        this.oauthAuthority = oauthAuthority;
    }
}
