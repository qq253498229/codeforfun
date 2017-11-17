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

-- ----------------------------
--  Table structure for `authorities`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `authorities` (
  `username`  VARCHAR(255) DEFAULT NULL,
  `authority` VARCHAR(255) DEFAULT NULL
)
  ENGINE = InnoDB;

-- ----------------------------
--  Table structure for `clientdetails`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `clientdetails` (
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
  ENGINE = InnoDB;

-- ----------------------------
--  Table structure for `oauth_access_token`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `oauth_access_token` (
  `token_id`          VARCHAR(256) DEFAULT NULL,
  `token`             BLOB,
  `authentication_id` VARCHAR(128) NOT NULL,
  `user_name`         VARCHAR(256) DEFAULT NULL,
  `client_id`         VARCHAR(256) DEFAULT NULL,
  `authentication`    BLOB,
  `refresh_token`     VARCHAR(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
)
  ENGINE = InnoDB;

-- ----------------------------
--  Table structure for `oauth_approvals`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `oauth_approvals` (
  `userId`         VARCHAR(256) DEFAULT NULL,
  `clientId`       VARCHAR(256) DEFAULT NULL,
  `scope`          VARCHAR(256) DEFAULT NULL,
  `status`         VARCHAR(10)  DEFAULT NULL,
  `expiresAt`      DATETIME     DEFAULT NULL,
  `lastModifiedAt` DATETIME     DEFAULT NULL
)
  ENGINE = InnoDB;

-- ----------------------------
--  Table structure for `oauth_client_details`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `oauth_client_details` (
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
  ENGINE = InnoDB;

-- ----------------------------
--  Table structure for `oauth_client_token`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `oauth_client_token` (
  `token_id`          VARCHAR(256) DEFAULT NULL,
  `token`             BLOB,
  `authentication_id` VARCHAR(128) NOT NULL,
  `user_name`         VARCHAR(256) DEFAULT NULL,
  `client_id`         VARCHAR(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
)
  ENGINE = InnoDB;

-- ----------------------------
--  Table structure for `oauth_code`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `oauth_code` (
  `code`           VARCHAR(256) DEFAULT NULL,
  `authentication` BLOB
)
  ENGINE = InnoDB;

-- ----------------------------
--  Table structure for `oauth_refresh_token`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `oauth_refresh_token` (
  `token_id`       VARCHAR(256) DEFAULT NULL,
  `token`          BLOB,
  `authentication` BLOB
)
  ENGINE = InnoDB;
-- ----------------------------
--  Table structure for `users`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `users` (
  `username` VARCHAR(255) NOT NULL PRIMARY KEY ,
  `password` VARCHAR(255) DEFAULT NULL,
  `enabled`  CHAR(50)     DEFAULT NULL
)
  ENGINE = InnoDB;