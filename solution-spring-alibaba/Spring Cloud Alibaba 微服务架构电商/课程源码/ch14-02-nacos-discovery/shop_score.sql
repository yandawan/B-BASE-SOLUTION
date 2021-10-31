/*
 Navicat MySQL Data Transfer

 Source Server         : dyspro
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : dyspro:3306
 Source Schema         : shop_score

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 02/06/2020 23:01:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for score_detail
-- ----------------------------
DROP TABLE IF EXISTS `score_detail`;
CREATE TABLE `score_detail` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(30) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `orderNo` varchar(30) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of score_detail
-- ----------------------------
BEGIN;
INSERT INTO `score_detail` VALUES (96, NULL, 'test', 669, '1590203827696', '2020-05-23 11:17:09');
INSERT INTO `score_detail` VALUES (97, NULL, 'test', 669, '1590203827696', '2020-05-23 11:17:10');
INSERT INTO `score_detail` VALUES (98, NULL, 'test', 669, '1590240504452', '2020-05-23 13:28:26');
INSERT INTO `score_detail` VALUES (99, NULL, 'test', 669, '1590240504452', '2020-05-23 13:28:27');
INSERT INTO `score_detail` VALUES (100, NULL, 'test', 1669, '1590242003059', '2020-05-23 13:53:26');
INSERT INTO `score_detail` VALUES (101, NULL, 'test', 1669, '1590242003059', '2020-05-23 13:53:26');
INSERT INTO `score_detail` VALUES (102, NULL, 'test', 1669, '1590242003059', '2020-05-23 13:53:27');
COMMIT;

-- ----------------------------
-- Table structure for score_user
-- ----------------------------
DROP TABLE IF EXISTS `score_user`;
CREATE TABLE `score_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `userName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of score_user
-- ----------------------------
BEGIN;
INSERT INTO `score_user` VALUES (46, NULL, 7683, 'test');
COMMIT;

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of undo_log
-- ----------------------------
BEGIN;
INSERT INTO `undo_log` VALUES (5, 2011909102, '192.168.31.23:8091:2011909098', 'serializer=jackson', 0x7B7D, 1, '2020-05-17 14:36:57', '2020-05-17 14:36:57', NULL);
INSERT INTO `undo_log` VALUES (6, 2011909101, '192.168.31.23:8091:2011909098', 'serializer=jackson', 0x7B7D, 1, '2020-05-17 14:36:57', '2020-05-17 14:36:57', NULL);
INSERT INTO `undo_log` VALUES (7, 2011909100, '192.168.31.23:8091:2011909098', 'serializer=jackson', 0x7B7D, 1, '2020-05-17 14:36:57', '2020-05-17 14:36:57', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
