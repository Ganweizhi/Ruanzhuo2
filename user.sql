/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : db1

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 02/04/2019 16:15:52
*/


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11)  AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(30) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
);

INSERT INTO `user` VALUES (1, 'guojianxiong', 26);
INSERT INTO `user` VALUES (2, 'wangsheng', 27);
INSERT INTO `user` VALUES (3, '李华', 34);
INSERT INTO `user` VALUES (4, '林忆莲', 45);

