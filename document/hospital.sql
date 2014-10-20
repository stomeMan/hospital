/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50704
Source Host           : localhost:3306
Source Database       : hospital

Target Server Type    : MYSQL
Target Server Version : 50704
File Encoding         : 65001

Date: 2014-10-19 22:15:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL DEFAULT '',
  `password` varchar(128) NOT NULL DEFAULT '',
  `nick_name` varchar(128) DEFAULT '',
  `gender` varchar(4) DEFAULT NULL,
  `age` int(4) DEFAULT NULL,
  `register_time` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_index` (`name`) USING HASH
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
