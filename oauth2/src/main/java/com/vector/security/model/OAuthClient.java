package com.vector.security.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * author: vector.huang
 * date: 2018/09/19 20:17
 */
@Entity
@Table(name = "oauth_client_details")
public class OAuthClient {

    //相当于账号和密码
    private String appId;
    private String appSecret;

    //支持的授权模式，OAuth2 定义了4种模式
    //一般用：password,refresh_token,authorization_code
    private String grantTypes;

    //应该授予的权限，根据这两个字段再做判断，跟自己用的
    private String authorities;
    private String scope;

    //token的有效期，单位：s
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;

    //授权码方式认证的时候需要
    private String redirectUrl;

    //在特定范围内进行用户批准
    private String autoApproveScopes;

    @Id
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getGrantTypes() {
        return grantTypes;
    }

    public void setGrantTypes(String grantTypes) {
        this.grantTypes = grantTypes;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAutoApproveScopes() {
        return autoApproveScopes;
    }

    public void setAutoApproveScopes(String autoApproveScopes) {
        this.autoApproveScopes = autoApproveScopes;
    }
}
