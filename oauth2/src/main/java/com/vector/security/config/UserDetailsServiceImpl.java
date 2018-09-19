package com.vector.security.config;

import com.vector.security.dao.OAuthUserAuthorityDao;
import com.vector.security.dao.UserDao;
import com.vector.security.model.OAuthAuthority;
import com.vector.security.model.OauthUserAuthority;
import com.vector.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private OAuthUserAuthorityDao authorityDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.findByNickname(username);
        if (user == null) {
            user = userDao.findByPhone(username);
        }
        if (user == null) {
            throw new UsernameNotFoundException("未找到该用户");
        }

        //组合权限
        List<OauthUserAuthority> userAuthorities = authorityDao.findByUserId(user.getId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (OauthUserAuthority userAuthority : userAuthorities) {

            OAuthAuthority oAuthAuthority = userAuthority.getOauthAuthority();
            oAuthAuthority.setAuthority("ROLE_" + oAuthAuthority.getAuthority());
            authorities.add(oAuthAuthority);
        }


        //用户数据应该是从数据库读取的
        return new org.springframework.security.core.userdetails
                //用户名和密码
                .User(username, user.getPassword(),
                //4 个状态
                user.getEnabled() > 0, true, true, true,
                //权限配置
                authorities);
    }
}