package com.vector.password;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;

/**
 * author: vector.huang
 * date: 2018/09/19 21:49
 */
public class PasswordTest {

    public static void main(String[] args) {
        System.out.println(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("app_secret"));
    }
}
