/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50704
Source Host           : localhost:3306
Source Database       : hospital

Target Server Type    : MYSQL
Target Server Version : 50704
File Encoding         : 65001

Date: 2014-10-23 21:51:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `check_project_detail`
-- ----------------------------
DROP TABLE IF EXISTS `check_project_detail`;
CREATE TABLE `check_project_detail` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `project_number` varchar(128) DEFAULT NULL,
  `project_name` varchar(128) DEFAULT NULL,
  `check_number` varchar(128) DEFAULT NULL,
  `project_result` varchar(128) DEFAULT NULL,
  `project_unit` varchar(128) DEFAULT NULL,
  `project_reference_range` varchar(128) DEFAULT NULL,
  `project_tips` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of check_project_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `check_project_info`
-- ----------------------------
DROP TABLE IF EXISTS `check_project_info`;
CREATE TABLE `check_project_info` (
  `id` int(20) NOT NULL,
  `username` varchar(128) DEFAULT NULL,
  `check_numer` varchar(128) NOT NULL,
  `check_name` varchar(128) DEFAULT NULL,
  `sign_number` varchar(128) DEFAULT NULL,
  `doctor_name` varchar(128) DEFAULT NULL,
  `doctor_number` varchar(128) DEFAULT NULL,
  `check_date` varchar(128) DEFAULT NULL,
  `office_summary` varchar(1024) DEFAULT NULL,
  `office_advise` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`id`,`check_numer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of check_project_info
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) NOT NULL DEFAULT '',
  `password` varchar(128) NOT NULL DEFAULT '',
  `nick_name` varchar(128) DEFAULT '',
  `gender` varchar(4) DEFAULT NULL,
  `age` int(4) DEFAULT NULL,
  `register_time` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_index` (`user_name`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'jack', 'jack', 'jack', 'M', '11', '2014-10-11 10:01:01');
INSERT INTO `user` VALUES ('2', 'gaohl', '000', null, null, null, '2014-10-19 13:53:20');
INSERT INTO `user` VALUES ('3', 'gaohl01', '000', null, null, null, '2014-10-19 13:56:09');
INSERT INTO `user` VALUES ('4', 'gaohl0101', '000', null, null, null, '2014-10-19 13:56:16');
INSERT INTO `user` VALUES ('5', 'gaohl010100', '000', null, null, null, '2014-10-19 13:58:51');
INSERT INTO `user` VALUES ('6', '00', '0000001', null, null, null, '2014-10-19 14:00:31');
INSERT INTO `user` VALUES ('7', '0ddd0', '0000001', null, null, null, '2014-10-19 14:03:42');
INSERT INTO `user` VALUES ('8', '0dddd0', '0000001', null, null, null, '2014-10-19 14:03:50');
