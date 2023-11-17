/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 5.6.41-log : Database - orderapi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`orderapi` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `orderapi`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `address_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `pincode` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FKda8tuywtf0gb6sedwk7la1pgi` (`user_id`),
  CONSTRAINT `FKda8tuywtf0gb6sedwk7la1pgi` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `address` */

insert  into `address`(`address_id`,`city`,`contact_number`,`pincode`,`state`,`user_address`,`user_name`,`user_id`) values 
(1,'Bangalore','9986060833','560097','Karnataka','B302 BML Vidyaranayapur','Ramesh Kumar',1),
(2,'Bangalore','9986060833','560097','Karnataka','B302 BML Vidyaranayapur','Ramesh Kumar',2),
(3,'Bangalore','3749873498','560097','Karnataka','BML','Ramesh Kumar',3),
(4,'Bangalore','3749873498','560097','Karnataka','BML Palms','Ramesh Kumar Add',NULL),
(6,'Bangalore','3749873498','560097','Karnataka','BML Palms','Ramesh Kumar Add',NULL),
(7,'Bangalore','3749873498','560097','Karnataka','BML Palms','Ramesh Kumar Add',3);

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `pages` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `book` */

insert  into `book`(`id`,`author`,`pages`,`title`) values 
(1,'Josh Long',484,'Reactive Spring'),
(2,'Mark Heckler',328,'Spring Boot Up & Running'),
(3,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(4,'Ramesh',100,'My First Book'),
(52,'Josh Long',484,'Reactive Spring'),
(53,'Mark Heckler',328,'Spring Boot Up & Running'),
(54,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(102,'Josh Long',484,'Reactive Spring'),
(103,'Mark Heckler',328,'Spring Boot Up & Running'),
(104,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(152,'Josh Long',484,'Reactive Spring'),
(153,'Mark Heckler',328,'Spring Boot Up & Running'),
(154,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(202,'Josh Long',484,'Reactive Spring'),
(203,'Mark Heckler',328,'Spring Boot Up & Running'),
(204,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(252,'Josh Long',484,'Reactive Spring'),
(253,'Mark Heckler',328,'Spring Boot Up & Running'),
(254,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(302,'Josh Long',484,'Reactive Spring'),
(303,'Mark Heckler',328,'Spring Boot Up & Running'),
(304,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(352,'Josh Long',484,'Reactive Spring'),
(353,'Mark Heckler',328,'Spring Boot Up & Running'),
(354,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(402,'Josh Long',484,'Reactive Spring'),
(403,'Mark Heckler',328,'Spring Boot Up & Running'),
(404,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(452,'Josh Long',484,'Reactive Spring'),
(453,'Mark Heckler',328,'Spring Boot Up & Running'),
(454,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(502,'Josh Long',484,'Reactive Spring'),
(503,'Mark Heckler',328,'Spring Boot Up & Running'),
(504,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(552,'Josh Long',484,'Reactive Spring'),
(553,'Mark Heckler',328,'Spring Boot Up & Running'),
(554,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(602,'Josh Long',484,'Reactive Spring'),
(603,'Mark Heckler',328,'Spring Boot Up & Running'),
(604,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(652,'Josh Long',484,'Reactive Spring'),
(653,'Mark Heckler',328,'Spring Boot Up & Running'),
(654,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(702,'Josh Long',484,'Reactive Spring'),
(703,'Mark Heckler',328,'Spring Boot Up & Running'),
(704,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(752,'Josh Long',484,'Reactive Spring'),
(753,'Mark Heckler',328,'Spring Boot Up & Running'),
(754,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(802,'Josh Long',484,'Reactive Spring'),
(803,'Mark Heckler',328,'Spring Boot Up & Running'),
(804,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(852,'Josh Long',484,'Reactive Spring'),
(853,'Mark Heckler',328,'Spring Boot Up & Running'),
(854,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(902,'Josh Long',484,'Reactive Spring'),
(903,'Mark Heckler',328,'Spring Boot Up & Running'),
(904,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(952,'Josh Long',484,'Reactive Spring'),
(953,'Mark Heckler',328,'Spring Boot Up & Running'),
(954,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(1002,'Josh Long',484,'Reactive Spring'),
(1003,'Mark Heckler',328,'Spring Boot Up & Running'),
(1004,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(1052,'Josh Long',484,'Reactive Spring'),
(1053,'Mark Heckler',328,'Spring Boot Up & Running'),
(1054,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(1102,'Josh Long',484,'Reactive Spring'),
(1103,'Mark Heckler',328,'Spring Boot Up & Running'),
(1104,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(1152,'Josh Long',484,'Reactive Spring'),
(1153,'Mark Heckler',328,'Spring Boot Up & Running'),
(1154,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(1202,'Josh Long',484,'Reactive Spring'),
(1203,'Mark Heckler',328,'Spring Boot Up & Running'),
(1204,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(1252,'Josh Long',484,'Reactive Spring'),
(1253,'Mark Heckler',328,'Spring Boot Up & Running'),
(1254,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(1302,'Josh Long',484,'Reactive Spring'),
(1303,'Mark Heckler',328,'Spring Boot Up & Running'),
(1304,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(1352,'Josh Long',484,'Reactive Spring'),
(1353,'Mark Heckler',328,'Spring Boot Up & Running'),
(1354,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(1402,'Josh Long',484,'Reactive Spring'),
(1403,'Mark Heckler',328,'Spring Boot Up & Running'),
(1404,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(1452,'Josh Long',484,'Reactive Spring'),
(1453,'Mark Heckler',328,'Spring Boot Up & Running'),
(1454,'Greg Turnquist',392,'Hacking with Spring Boot 2.3'),
(1502,'Josh Long',484,'Reactive Spring'),
(1503,'Mark Heckler',328,'Spring Boot Up & Running'),
(1504,'Greg Turnquist',392,'Hacking with Spring Boot 2.3');

/*Table structure for table `book_seq` */

DROP TABLE IF EXISTS `book_seq`;

CREATE TABLE `book_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `book_seq` */

insert  into `book_seq`(`next_val`) values 
(1601);

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `cart_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cart_id`),
  UNIQUE KEY `UK_9emlp6m95v5er2bcqkjsw48he` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `cart` */

insert  into `cart`(`cart_id`,`user_id`) values 
(1,3);

/*Table structure for table `cart_item` */

DROP TABLE IF EXISTS `cart_item`;

CREATE TABLE `cart_item` (
  `cart_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `list_price` varchar(255) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `sales_price` varchar(255) DEFAULT NULL,
  `cart_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cart_item_id`),
  KEY `FK1uobyhgl1wvgt1jpccia8xxs3` (`cart_id`),
  CONSTRAINT `FK1uobyhgl1wvgt1jpccia8xxs3` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `cart_item` */

insert  into `cart_item`(`cart_item_id`,`list_price`,`product_id`,`quantity`,`sales_price`,`cart_id`) values 
(1,'68.0','2',2,'68.0',1);

/*Table structure for table `order_header` */

DROP TABLE IF EXISTS `order_header`;

CREATE TABLE `order_header` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_total` double DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `order_header` */

insert  into `order_header`(`order_id`,`order_total`,`user_id`,`address_id`,`payment_mode`,`order_date`,`order_status`) values 
(1,136,3,NULL,'COD','2023-11-04 11:21:39','CREATED'),
(2,136,3,1,'COD','2023-11-07 12:21:39','CREATED'),
(3,136,3,1,'COD','2023-11-07 15:21:39','CREATED');

/*Table structure for table `order_item` */

DROP TABLE IF EXISTS `order_item`;

CREATE TABLE `order_item` (
  `order_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `list_price` varchar(255) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `sales_price` varchar(255) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`order_item_id`),
  KEY `FKeffbgeew9ymyostv1fxuwmr2x` (`order_id`),
  CONSTRAINT `FKeffbgeew9ymyostv1fxuwmr2x` FOREIGN KEY (`order_id`) REFERENCES `order_header` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `order_item` */

insert  into `order_item`(`order_item_id`,`list_price`,`product_id`,`quantity`,`sales_price`,`order_id`) values 
(1,'68.0','2',2,'68.0',1),
(2,'68.0','2',2,'68.0',2),
(3,'68.0','2',2,'68.0',3);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `currency` varchar(255) DEFAULT NULL,
  `list_price` double NOT NULL,
  `product_image` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_stock` varchar(255) DEFAULT NULL,
  `sales_price` double NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `product` */

insert  into `product`(`product_id`,`currency`,`list_price`,`product_image`,`product_name`,`product_stock`,`sales_price`) values 
(1,'INR',66,'img1.jpg','Mutation Product1',NULL,66),
(2,'INR',68,'img1.jpg','Mutation Product2',NULL,68),
(3,'INR',65,'img3.jpg','Mutation Product3',NULL,65);

/*Table structure for table `review` */

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
  `id` int(11) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK70yrt09r4r54tcgkrwbeqenbs` (`book_id`),
  CONSTRAINT `FK70yrt09r4r54tcgkrwbeqenbs` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `review` */

insert  into `review`(`id`,`comment`,`title`,`book_id`) values 
(1,'I really enjoyed this book','Great book',1),
(2,'I really enjoyed this book','Great book',52),
(52,'I really enjoyed this book','Great book',102),
(102,'I really enjoyed this book','Great book',152),
(152,'I really enjoyed this book','Great book',202),
(202,'I really enjoyed this book','Great book',252),
(252,'I really enjoyed this book','Great book',302),
(302,'I really enjoyed this book','Great book',352),
(352,'I really enjoyed this book','Great book',402),
(402,'I really enjoyed this book','Great book',452),
(452,'I really enjoyed this book','Great book',502),
(502,'I really enjoyed this book','Great book',552),
(552,'I really enjoyed this book','Great book',602),
(602,'I really enjoyed this book','Great book',652),
(652,'I really enjoyed this book','Great book',702),
(702,'I really enjoyed this book','Great book',752),
(752,'I really enjoyed this book','Great book',802),
(802,'I really enjoyed this book','Great book',852),
(852,'I really enjoyed this book','Great book',902),
(902,'I really enjoyed this book','Great book',952),
(952,'I really enjoyed this book','Great book',1002),
(1002,'I really enjoyed this book','Great book',1052),
(1052,'I really enjoyed this book','Great book',1102),
(1102,'I really enjoyed this book','Great book',1152),
(1152,'I really enjoyed this book','Great book',1202),
(1202,'I really enjoyed this book','Great book',1252),
(1252,'I really enjoyed this book','Great book',1302),
(1302,'I really enjoyed this book','Great book',1352),
(1352,'I really enjoyed this book','Great book',1402),
(1402,'I really enjoyed this book','Great book',1452),
(1452,'I really enjoyed this book','Great book',1502);

/*Table structure for table `review_seq` */

DROP TABLE IF EXISTS `review_seq`;

CREATE TABLE `review_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `review_seq` */

insert  into `review_seq`(`next_val`) values 
(1551);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`user_id`,`email_id`,`user_name`,`user_status`) values 
(1,'ramesh1@gmail.com','Ramesh Kumar','Active'),
(2,'rameshy@gmail.com','Rmesh Kumar Y',NULL),
(3,'rameshy1@gmail.com','Rmesh Kumar Y',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
