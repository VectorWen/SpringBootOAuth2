
INSERT INTO `oauth_authority` VALUES ('1', 'admin'), ('2', 'user');
INSERT INTO `user`(id,nickname,phone,avatar,password)
    VALUES ('1', 'admin', '13800138000','/avatar/logo.png','{bcrypt}$2a$10$LDIu79Omb8nAry0bIYv0zOhQYf29YWd/rHNlAvcAW9e0Hi6mJ3bQu');
INSERT INTO `oauth_user_authority`(user_id,authority_id) VALUES ('1', '1'), ('1', '2');

INSERT INTO `oauth_client_details`(app_id, app_secret, grant_types, authorities, scope, redirect_url, access_token_validity, refresh_token_validity, auto_approve_scopes) VALUES ('app', '{bcrypt}$2a$10$zpBPTVnFP/ETmOAPW48g7uTUpCSq57o931KFOnAsONOBaTdlrWghy',
    'password,refresh_token,authorization_code','admin,user','all',null,7200,108000,null);
