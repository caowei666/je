/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : exam_code

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 25/08/2020 00:21:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `qq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'caowei', NULL, '1143935d807f51e397d72b6759c8df91', NULL, NULL, 'cao', 1);
INSERT INTO `user` VALUES (2, 'awei', NULL, '1143935d807f51e397d72b6759c8df91', NULL, NULL, 'www', 1);
INSERT INTO `user` VALUES (3, 'test', NULL, '123456', NULL, NULL, 'ttt', 0);
INSERT INTO `user` VALUES (4, 'test1', NULL, '1143935d807f51e397d72b6759c8df91', NULL, NULL, 'wangnini', 0);
INSERT INTO `user` VALUES (5, NULL, NULL, 'a2e0449ec961155f6116e6c265dba855', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
