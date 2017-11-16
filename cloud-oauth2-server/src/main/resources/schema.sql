/*
 Navicat Premium Data Transfer
 Source Server         : jiangchao
 Source Server Type    : MySQL
 Source Server Version : 50505
 Source Host           : localhost
 Source Database       : alan-oauth
 Target Server Type    : MySQL
 Target Server Version : 50505
 File Encoding         : utf-8
 Date: 03/14/2017 14:09:46 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `authorities`
-- ----------------------------
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username`  VARCHAR(255) DEFAULT NULL,
  `authority` VARCHAR(255) DEFAULT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `authorities`
-- ----------------------------
BEGIN;
INSERT INTO `authorities` VALUES ('admin', 'ADMIN'), ('user', 'USER');
COMMIT;

-- ----------------------------
--  Table structure for `clientdetails`
-- ----------------------------
DROP TABLE IF EXISTS `clientdetails`;
CREATE TABLE `clientdetails` (
  `appId`                  VARCHAR(128) NOT NULL,
  `resourceIds`            VARCHAR(256)  DEFAULT NULL,
  `appSecret`              VARCHAR(256)  DEFAULT NULL,
  `scope`                  VARCHAR(256)  DEFAULT NULL,
  `grantTypes`             VARCHAR(256)  DEFAULT NULL,
  `redirectUrl`            VARCHAR(256)  DEFAULT NULL,
  `authorities`            VARCHAR(256)  DEFAULT NULL,
  `access_token_validity`  INT(11)       DEFAULT NULL,
  `refresh_token_validity` INT(11)       DEFAULT NULL,
  `additionalInformation`  VARCHAR(4096) DEFAULT NULL,
  `autoApproveScopes`      VARCHAR(256)  DEFAULT NULL,
  PRIMARY KEY (`appId`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Table structure for `oauth_access_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id`          VARCHAR(256) DEFAULT NULL,
  `token`             BLOB,
  `authentication_id` VARCHAR(128) NOT NULL,
  `user_name`         VARCHAR(256) DEFAULT NULL,
  `client_id`         VARCHAR(256) DEFAULT NULL,
  `authentication`    BLOB,
  `refresh_token`     VARCHAR(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Table structure for `oauth_approvals`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals` (
  `userId`         VARCHAR(256) DEFAULT NULL,
  `clientId`       VARCHAR(256) DEFAULT NULL,
  `scope`          VARCHAR(256) DEFAULT NULL,
  `status`         VARCHAR(10)  DEFAULT NULL,
  `expiresAt`      DATETIME     DEFAULT NULL,
  `lastModifiedAt` DATETIME     DEFAULT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Table structure for `oauth_client_details`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id`               VARCHAR(128) NOT NULL,
  `resource_ids`            VARCHAR(256)  DEFAULT NULL,
  `client_secret`           VARCHAR(256)  DEFAULT NULL,
  `scope`                   VARCHAR(256)  DEFAULT NULL,
  `authorized_grant_types`  VARCHAR(256)  DEFAULT NULL,
  `web_server_redirect_uri` VARCHAR(256)  DEFAULT NULL,
  `authorities`             VARCHAR(256)  DEFAULT NULL,
  `access_token_validity`   INT(11)       DEFAULT NULL,
  `refresh_token_validity`  INT(11)       DEFAULT NULL,
  `additional_information`  VARCHAR(4096) DEFAULT NULL,
  `autoapprove`             VARCHAR(256)  DEFAULT NULL,
  PRIMARY KEY (`client_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `oauth_client_details`
-- ----------------------------
BEGIN;
INSERT INTO `oauth_client_details` VALUES
  ('acme', 'oauth2-resource', 'acmesecret', 'app', 'authorization_code', '', NULL, NULL, NULL, NULL, 'app'),
  ('client', 'oauth2-resource', 'secret', 'app', 'password,authorization_code,refresh_token', '', NULL, 7200, 86400, NULL, 'app'),
  ('my-trusted-client', 'oauth2-resource', NULL, 'read', 'authorization_code', NULL, NULL, NULL, NULL, NULL, '');
COMMIT;

-- ----------------------------
--  Table structure for `oauth_client_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
  `token_id`          VARCHAR(256) DEFAULT NULL,
  `token`             BLOB,
  `authentication_id` VARCHAR(128) NOT NULL,
  `user_name`         VARCHAR(256) DEFAULT NULL,
  `client_id`         VARCHAR(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Table structure for `oauth_code`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
  `code`           VARCHAR(256) DEFAULT NULL,
  `authentication` BLOB
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Table structure for `oauth_refresh_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id`       VARCHAR(256) DEFAULT NULL,
  `token`          BLOB,
  `authentication` BLOB
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` VARCHAR(255) DEFAULT NULL,
  `password` VARCHAR(255) DEFAULT NULL,
  `enabled`  CHAR(50)     DEFAULT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `users`
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('admin', 'admin', 'Y'), ('user', 'user', 'Y');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;