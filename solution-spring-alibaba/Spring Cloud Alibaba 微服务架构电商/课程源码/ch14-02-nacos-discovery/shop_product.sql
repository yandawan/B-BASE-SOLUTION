/*
 Navicat MySQL Data Transfer

 Source Server         : dyspro
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : dyspro:3306
 Source Schema         : shop_product

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 02/06/2020 23:01:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of product
-- ----------------------------
BEGIN;
INSERT INTO `product` VALUES (1, '水果便携电脑', 6698, 'https://tva1.sinaimg.cn/large/00831rSTly1gdjvarklf0j319j0u0kjm.jpg', 'CPU型号：其他<br/>运行内存：8GB<br/>机身存储：256GB<br/>存储卡：支持MicroSD(TF)<br/>分辨率：1920 x 1080<br/>屏幕比例：16:9');
INSERT INTO `product` VALUES (2, '商务笔记本', 98, 'https://tva1.sinaimg.cn/large/00831rSTly1gdjvblmw8uj31950u01kz.jpg', NULL);
INSERT INTO `product` VALUES (3, '银色合金电脑', 8698, 'https://tva1.sinaimg.cn/large/00831rSTly1gdjvc6sc51j319d0u01ky.jpg', NULL);
INSERT INTO `product` VALUES (4, '高性能工作站', 16698, 'https://tva1.sinaimg.cn/large/00831rSTly1gdjvd07jhdj31950u0npd.jpg', NULL);
INSERT INTO `product` VALUES (5, 'FruitBook Pro', 7698, 'https://tva1.sinaimg.cn/large/00831rSTly1gdjv7vuekij30zk0np78f.jpg', NULL);
INSERT INTO `product` VALUES (6, '国行十代 X', 698, 'https://tva1.sinaimg.cn/large/00831rSTly1gdjvdu1snej319f0u0b2a.jpg', NULL);
INSERT INTO `product` VALUES (7, '畅玩大米8', 7698, 'https://tva1.sinaimg.cn/large/00831rSTly1gdjv7vog9tj30zk0npdkg.jpg', NULL);
INSERT INTO `product` VALUES (8, 'Hphone 18', 9998, 'https://tva1.sinaimg.cn/large/00831rSTly1gdjvehm2xij31940u0b29.jpg', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
