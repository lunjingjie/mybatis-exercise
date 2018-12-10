/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50638
Source Host           : localhost:3306
Source Database       : mybatis-source

Target Server Type    : MYSQL
Target Server Version : 50638
File Encoding         : 65001

Date: 2018-12-10 16:55:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_employee
-- ----------------------------
DROP TABLE IF EXISTS `tbl_employee`;
CREATE TABLE `tbl_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_employee
-- ----------------------------
INSERT INTO `tbl_employee` VALUES ('1', 'tom', '男', '123');
INSERT INTO `tbl_employee` VALUES ('2', 'dami', '0', 'myEmail');
INSERT INTO `tbl_employee` VALUES ('4', 'mcjin', '0', 'abcemail');
INSERT INTO `tbl_employee` VALUES ('5', 'mcjin', '0', 'abcemail');
INSERT INTO `tbl_employee` VALUES ('6', 'mcjin', '0', 'abcemail');

-- ----------------------------
-- Table structure for tbl_score
-- ----------------------------
DROP TABLE IF EXISTS `tbl_score`;
CREATE TABLE `tbl_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(20) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_score
-- ----------------------------
INSERT INTO `tbl_score` VALUES ('1', '语文', '85', '1');
INSERT INTO `tbl_score` VALUES ('2', '数学', '90', '1');
INSERT INTO `tbl_score` VALUES ('3', '英语', '90', '1');

-- ----------------------------
-- Table structure for tbl_student
-- ----------------------------
DROP TABLE IF EXISTS `tbl_student`;
CREATE TABLE `tbl_student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(10) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_student
-- ----------------------------
INSERT INTO `tbl_student` VALUES ('1', '小明', '0');
