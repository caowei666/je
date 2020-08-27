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

 Date: 25/08/2020 00:21:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `icon` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `perms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (2, '权限管理', NULL, NULL, NULL, NULL, '0', 1);
INSERT INTO `menu` VALUES (3, '菜单管理', 2, '/sys/menu.html', NULL, NULL, '1', 1000);
INSERT INTO `menu` VALUES (4, '角色管理', 2, '/sys/role.html', NULL, NULL, '1', 1000);
INSERT INTO `menu` VALUES (5, '用户管理', 2, '/sys/user.html', NULL, NULL, '1', 1000);
INSERT INTO `menu` VALUES (6, '添加', 5, NULL, NULL, NULL, '2', 1000);
INSERT INTO `menu` VALUES (7, '修改', 5, NULL, NULL, NULL, '2', 1000);
INSERT INTO `menu` VALUES (8, '删除', 5, NULL, NULL, NULL, '2', 1000);
INSERT INTO `menu` VALUES (9, '授权', 5, NULL, NULL, NULL, '2', 1000);
INSERT INTO `menu` VALUES (10, '修改', 3, NULL, NULL, NULL, '2', 1000);
INSERT INTO `menu` VALUES (11, '添加', 3, NULL, NULL, NULL, '2', 1000);
INSERT INTO `menu` VALUES (16, '删除', 4, NULL, NULL, NULL, '2', NULL);
INSERT INTO `menu` VALUES (17, '修改', 4, NULL, NULL, NULL, '2', NULL);
INSERT INTO `menu` VALUES (18, '删除', 4, NULL, NULL, NULL, '2', NULL);
INSERT INTO `menu` VALUES (19, '授权', 4, NULL, NULL, NULL, '2', NULL);
INSERT INTO `menu` VALUES (20, '路由管理', NULL, '/sys/api_mapping.html ', NULL, NULL, '1', NULL);
INSERT INTO `menu` VALUES (21, '修改', 20, NULL, NULL, NULL, '2', NULL);
INSERT INTO `menu` VALUES (22, '添加', 20, NULL, NULL, NULL, '2', NULL);
INSERT INTO `menu` VALUES (23, '删除', 20, NULL, NULL, NULL, '2', NULL);

SET FOREIGN_KEY_CHECKS = 1;
