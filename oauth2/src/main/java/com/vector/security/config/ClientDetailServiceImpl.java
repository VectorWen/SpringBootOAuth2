package com.vector.security.config;

import com.vector.security.dao.ClientDao;
import com.vector.security.model.OAuthClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ClientDetailServiceImpl implements ClientDetailsService {

    @Autowired
    private ClientDao clientDao;

    @Override
    public ClientDetails loadClientByClientId(String clientId)
            throws ClientRegistrationException {

        OAuthClient client = clientDao.findById(clientId).orElse(null);
        if (client == null) {
            throw new NoSuchClientException("未找到客户端");
        }

        BaseClientDetails clientDetails = new BaseClientDetails();

        //相当于账号和密码
        clientDetails.setClientId(clientId);
        clientDetails.setClientSecret(client.getAppSecret());

        //支持的授权模式，OAuth2 定义了4种模式
        //一般用：password,refresh_token,authorization_code
        clientDetails.setAuthorizedGrantTypes(
                StringUtils.commaDelimitedListToSet(client.getGrantTypes()));

        //时间
        clientDetails.setAccessTokenValiditySeconds(client.getAccessTokenValidity());
        clientDetails.setRefreshTokenValiditySeconds(client.getRefreshTokenValidity());

        clientDetails.setScope(StringUtils.commaDelimitedListToSet(client.getScope()));
        clientDetails.setAutoApproveScopes(StringUtils.commaDelimitedListToSet(client.getAutoApproveScopes()));

        String redirectUrl = client.getRedirectUrl();
        if (!StringUtils.isEmpty(redirectUrl)) {
            clientDetails.setRegisteredRedirectUri(StringUtils.commaDelimitedListToSet(redirectUrl));
        }

        return clientDetails;
    }
}
