/*
Navicat MySQL Data Transfer

Source Server         : ww_pro
Source Server Version : 50505
Source Host           : 192.168.100.40:3306
Source Database       : xcxdb

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-02-02 15:51:55
*/


create database xcxdb;
	
SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for sys_depart
-- ----------------------------
DROP TABLE IF EXISTS `sys_depart`;
CREATE TABLE `sys_depart` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(200) DEFAULT '',
  `CREATE_TIME` datetime DEFAULT sysdate(),
  `MODI_TIME` datetime DEFAULT sysdate(),
  `MODI_USER_ID` int(11) DEFAULT 0,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_depart
-- ----------------------------
INSERT INTO `sys_depart` VALUES ('1001', '运营部', '2017-09-21 20:16:37', '2017-09-21 20:16:37', '0');
INSERT INTO `sys_depart` VALUES ('1002', '超管部', '2017-09-21 20:17:11', '2017-09-21 20:17:11', '0');



-- ----------------------------
-- Table structure for sys_proxy_log_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_proxy_log_info`;
CREATE TABLE `sys_proxy_log_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `REQ_ID` varchar(36) CHARACTER SET utf8 DEFAULT '',
  `REQ_URL` varchar(5000) CHARACTER SET utf8 DEFAULT '',
  `REQ_METHOD` varchar(50) CHARACTER SET utf8 DEFAULT '',
  `REQ_PARAM` longtext CHARACTER SET utf8 DEFAULT NULL,
  `REQ_IP` varchar(50) CHARACTER SET utf8 DEFAULT '',
  `REQ_DATE` datetime DEFAULT sysdate(),
  `RESP_DATA` longtext CHARACTER SET utf8 DEFAULT NULL,
  `RESP_DATE` datetime DEFAULT sysdate(),
  `DONE_STATUS` varchar(11) COLLATE utf8_bin DEFAULT '99',
  `ERR_MSG` longtext CHARACTER SET utf8 DEFAULT NULL,
  `BUSINESS_ID` varchar(50) COLLATE utf8_bin DEFAULT '99999' COMMENT '业务id（即Resource请求的唯一编号）',
  `MODULE_NAME` varchar(100) COLLATE utf8_bin DEFAULT '' COMMENT '模块名称',
  `DESCRIPTION` varchar(220) COLLATE utf8_bin DEFAULT '' COMMENT '方法逻辑描述',
  `user_id` int(11) DEFAULT 0 COMMENT '系统用户or业务用户id',
  `Request_Type` int(11) DEFAULT 0,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10954 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;



-- ----------------------------
-- Table structure for sys_user_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(200) DEFAULT NULL COMMENT '名称',
  `PHONE` varchar(200) DEFAULT NULL,
  `ADDRESS` varchar(200) DEFAULT '' COMMENT '地址',
  `CREATE_TIME` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `LAST_LOGIN_TIME` datetime DEFAULT current_timestamp(),
  `DEPART_ID` int(11) DEFAULT 0,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user_info
-- ----------------------------
INSERT INTO `sys_user_info` VALUES ('1000', '快乐的小鸭子', '15088132421', '广州市XXXXXXX', '2017-09-12 16:41:47', '2017-09-12 16:41:52', '1001');



DROP TABLE IF EXISTS `sys_user_login`;
CREATE TABLE `sys_user_login` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '登录账号',
  `wx_id` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '微信登录id(无需密码)',
  `qq_id` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT 'qq登录id(无需密码)',
  `wb_id` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '微博登录id(无需密码)',
  `PWD` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '111111' COMMENT '登录密码 md5',
  `TYPE` int(11) unsigned NOT NULL DEFAULT 0 COMMENT '用户类型 0 业务用户， 98 运营用户只能查看，99超管用户',
  `STATUS` int(11) NOT NULL DEFAULT 0 COMMENT '用户状态 0正常，1下线',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `USER_FROM` int(11) DEFAULT NULL COMMENT '用户来源 0 壹号课堂，1网威幼小，99系统',
  `LAST_LOGIN_TIME` datetime DEFAULT NULL COMMENT '最后登录时间',
  `USER_INFO_ID` int(11) NOT NULL COMMENT '用户信息id， 现有 系统用户，壹号课堂用户',
  PRIMARY KEY (`ID`),
  KEY `yh_user_login_fk` (`USER_INFO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=56715793 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户登录授权表';