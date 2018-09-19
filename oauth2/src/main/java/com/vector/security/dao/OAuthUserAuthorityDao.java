package com.vector.security.dao;

import com.vector.security.model.OauthUserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author: vector.huang
 * date: 2018/09/19 21:19
 */
public interface OAuthUserAuthorityDao extends JpaRepository<OauthUserAuthority, Integer> {


    List<OauthUserAuthority> findByUserId(Integer userId);

}
