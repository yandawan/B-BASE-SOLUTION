/*
 Navicat MySQL Data Transfer

 Source Server         : dyspro
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : dyspro:3306
 Source Schema         : shop_order

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 02/06/2020 23:01:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `orderNo` varchar(30) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(30) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `productName` varchar(50) DEFAULT NULL,
  `productImage` varchar(200) DEFAULT NULL,
  `productNum` int(11) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orders
-- ----------------------------
BEGIN;
INSERT INTO `orders` VALUES (1, '116480227524', 1, '小郭', 6698, '水果便携电脑', 'https://tva1.sinaimg.cn/large/00831rSTly1gdjvarklf0j319j0u0kjm.jpg', 11, '2020-04-02 15:35:30');
INSERT INTO `orders` VALUES (2, '116490227523', 1, '小王', 66980, '商务笔记本', 'https://tva1.sinaimg.cn/large/00831rSTly1gdjvblmw8uj31950u01kz.jpg', 2, '2020-04-03 15:35:30');
INSERT INTO `orders` VALUES (96, '1590203827696', NULL, 'test', 6698, '水果便携电脑', 'https://tva1.sinaimg.cn/large/00831rSTly1gdjvarklf0j319j0u0kjm.jpg', 1, '2020-05-23 11:17:08');
INSERT INTO `orders` VALUES (97, '1590240504452', NULL, 'test', 6698, '水果便携电脑', 'https://tva1.sinaimg.cn/large/00831rSTly1gdjvarklf0j319j0u0kjm.jpg', 1, '2020-05-23 13:28:24');
INSERT INTO `orders` VALUES (103, '1590242003059', NULL, 'test', 16698, '高性能工作站', 'https://tva1.sinaimg.cn/large/00831rSTly1gdjvd07jhdj31950u0npd.jpg', 1, '2020-05-23 13:53:23');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
