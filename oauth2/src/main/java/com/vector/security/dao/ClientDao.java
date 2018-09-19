package com.vector.security.dao;

import com.vector.security.model.OAuthClient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: vector.huang
 * date: 2018/09/19 20:41
 */
public interface ClientDao extends JpaRepository<OAuthClient, String> {

}
