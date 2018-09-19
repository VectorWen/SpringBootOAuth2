
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `client_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `authentication` blob,
  `refresh_token` blob,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `token` blob,
  `authentication` blob,
  PRIMARY KEY (`token_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for security_authorities
-- ----------------------------
DROP TABLE IF EXISTS `oauth_authority`;
CREATE TABLE `oauth_authority` (
  `id` int NOT NULL AUTO_INCREMENT,
  `authority` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for security_user_authority
-- ----------------------------
DROP TABLE IF EXISTS `oauth_user_authority`;
CREATE TABLE `oauth_user_authority` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `authority_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

ALTER TABLE `oauth_user_authority` ADD index userId (`user_id`);


-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `app_id` varchar(64) NOT NULL,
  `app_secret` varchar(255) NOT NULL,
  `grant_types` varchar(255) NOT NULL,
  `authorities` varchar(255) NOT NULL,
  `scope` varchar(255) NOT NULL,
  `redirect_url` varchar(255) NULL,
  `access_token_validity` int NULL,
  `refresh_token_validity` int NULL,
  `auto_approve_scopes` varchar(255) NULL,
  `status` int NOT NULL default 0,
  `created` datetime NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(64) NOT NULL,
  `phone` varchar(32) NOT NULL,
  `avatar` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enabled` int NOT NULL default 1,
  `sex` int NOT NULL default 0,
  `status` int NOT NULL default 0,
  `created` datetime NOT NULL default CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

ALTER TABLE user ADD UNIQUE u_phone (`phone`);
ALTER TABLE user ADD UNIQUE u_nickname (`nickname`);