/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50704
Source Host           : localhost:3306
Source Database       : hospital

Target Server Type    : MYSQL
Target Server Version : 50704
File Encoding         : 65001

Date: 2014-10-28 22:52:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `check_project_detail`
-- ----------------------------
DROP TABLE IF EXISTS `check_project_detail`;
CREATE TABLE `check_project_detail` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `project_name` varchar(128) DEFAULT '',
  `single_project_name` varchar(128) DEFAULT '',
  `project_result` varchar(128) DEFAULT '',
  `project_unit` varchar(128) DEFAULT '',
  `project_reference_range` varchar(128) DEFAULT '',
  `project_tips` varchar(128) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of check_project_detail
-- ----------------------------
INSERT INTO `check_project_detail` VALUES ('1', '一般检查项目', '身高 ', '175.5', '厘米', '～ ', null);
INSERT INTO `check_project_detail` VALUES ('2', '一般检查项目', '体重 ', '84.6 ', '公斤 ', null, '偏高 ');
INSERT INTO `check_project_detail` VALUES ('3', '一般检查项目', '体重指数', '27.47', null, '18.5～24 ', null);
INSERT INTO `check_project_detail` VALUES ('4', '一般检查项目', '收缩压 ', '129.00', 'mmHg ', '90～139 ', null);
INSERT INTO `check_project_detail` VALUES ('5', '一般检查项目', '舒张压 ', '75.00', 'mmHg ', '60～89', null);

-- ----------------------------
-- Table structure for `check_project_info`
-- ----------------------------
DROP TABLE IF EXISTS `check_project_info`;
CREATE TABLE `check_project_info` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `project_numer` varchar(128) NOT NULL DEFAULT '',
  `project_name` varchar(128) DEFAULT '',
  `username` varchar(128) DEFAULT '',
  `sign_number` varchar(128) DEFAULT '',
  `doctor_name` varchar(128) DEFAULT '',
  `doctor_number` varchar(128) DEFAULT '',
  `check_date` varchar(128) DEFAULT NULL,
  `office_summary` varchar(1024) DEFAULT NULL,
  `office_advise` varchar(2048) DEFAULT '',
  PRIMARY KEY (`id`,`project_numer`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of check_project_info
-- ----------------------------
INSERT INTO `check_project_info` VALUES ('1', '001', '一般检查项目', 'jack', '20131104-008', '温素芳', '温素芳', '2014.04.16', '体重指数偏高(27.47)', '◆体重指数偏高:\r\n体重指数≥ 24为超重，≥28为肥胖。超出正常者易患高血压、糖尿病、冠心病等。请注意：\r\n(1)首要措施是合理控制饮食，低盐、低脂和低糖类饮食。\r\n(2)多食新鲜水果，保证食物纤维、维生素及微量元素的摄入，烹调时多用凉拌水煮、少用炒、煎、炸的方法。\r\n(3)细嚼慢咽，减少进食量，晚餐宜清淡，睡前四小时不要进食。\r\n(4)坚持多做有氧运动，如打网球、跑步、游泳、跳舞等。\r\n◆体重指数偏高:\r\n体重指数≥ 24为超重，≥28为肥胖。超出正常者易患高血压、糖尿病、冠心病等。请注意：\r\n(1)首要措施是合理控制饮食，低盐、低脂和低糖类饮食。\r\n(2)多食新鲜水果，保证食物纤维、维生素及微量元素的摄入，烹调时多用凉拌水煮、少用炒、煎、炸的方法。\r\n(3)细嚼慢咽，减少进食量，晚餐宜清淡，睡前四小时不要进食。\r\n(4)坚持多做有氧运动，如打网球、跑步、游泳、跳舞等。\r\n');

-- ----------------------------
-- Table structure for `reservation`
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `update_time` varchar(32) DEFAULT NULL,
  `reservation_time` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reservation
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
  `phone` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_index` (`user_name`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'jack', 'jack', 'jack', 'M', '11', '2014-10-11 10:01:01', null);
INSERT INTO `user` VALUES ('2', 'gaohl', '000', null, null, null, '2014-10-19 13:53:20', null);
INSERT INTO `user` VALUES ('3', 'gaohl01', '000', null, null, null, '2014-10-19 13:56:09', null);
INSERT INTO `user` VALUES ('4', 'gaohl0101', '000', null, null, null, '2014-10-19 13:56:16', null);
INSERT INTO `user` VALUES ('5', 'gaohl010100', '000', null, null, null, '2014-10-19 13:58:51', null);
INSERT INTO `user` VALUES ('6', '00', '0000001', null, null, null, '2014-10-19 14:00:31', null);
INSERT INTO `user` VALUES ('7', '0ddd0', '0000001', null, null, null, '2014-10-19 14:03:42', null);
INSERT INTO `user` VALUES ('8', '0dddd0', '0000001', null, null, null, '2014-10-19 14:03:50', null);
