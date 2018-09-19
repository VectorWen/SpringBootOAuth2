package com.vector.security.dao;

import com.vector.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: vector.huang
 * date: 2018/09/19 20:42
 */
public interface UserDao extends JpaRepository<User, Integer> {

    User findByNickname(String nickname);

    User findByPhone(String phone);
}
