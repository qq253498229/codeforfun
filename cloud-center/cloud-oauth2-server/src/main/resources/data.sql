-- ----------------------------
--  Records of `authorities`
-- ----------------------------
INSERT IGNORE INTO authorities VALUES ('admin', 'ADMIN'), ('user', 'USER');

-- ----------------------------
--  Records of `oauth_client_details`
-- ----------------------------
INSERT IGNORE INTO oauth_client_details VALUES
  ('client', 'oauth2-resource', 'secret', 'read,write', 'password,authorization_code,refresh_token',
             '', NULL, 7200, 86400, NULL, TRUE);

-- ----------------------------
--  Records of `users`
-- ----------------------------
INSERT IGNORE INTO users VALUES ('admin', 'admin', 'Y'), ('user', 'user', 'Y');
