package com.vector.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ClientDetailServiceImpl implements ClientDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ClientDetails loadClientByClientId(String clientId)
            throws ClientRegistrationException {

        BaseClientDetails client = new BaseClientDetails();
        client.setClientId(clientId);
        client.setClientSecret(passwordEncoder.encode("123456"));

        client.setAuthorizedGrantTypes(StringUtils.commaDelimitedListToSet("password,refresh_token,authorization_code"));
        client.setScope(StringUtils.commaDelimitedListToSet("all,read,write"));

        client.setAccessTokenValiditySeconds(7200);

        client.setRegisteredRedirectUri(StringUtils.commaDelimitedListToSet("http://www.baidu.com"));

        return client;
    }
}
