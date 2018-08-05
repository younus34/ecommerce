-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema `changed`
--

CREATE DATABASE IF NOT EXISTS `changed`;
USE `changed`;

--
-- Definition of table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cat_id` int(10) unsigned NOT NULL auto_increment,
  `cat_name` varchar(45) NOT NULL,
  `cat_desc` varchar(45) NOT NULL,
  PRIMARY KEY  (`cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`cat_id`,`cat_name`,`cat_desc`) VALUES 
 (1,'Electronics','new items'),
 (2,'Men Cloths','men cloth'),
 (3,'Foods','dry food'),
 (4,'daily goods','available in stock '),
 (5,'Women Cloths','women cloth');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


--
-- Definition of table `customer_regi`
--

DROP TABLE IF EXISTS `customer_regi`;
CREATE TABLE `customer_regi` (
  `customer_id` int(10) unsigned NOT NULL auto_increment,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `customer_city` varchar(45) NOT NULL,
  `customer_address` varchar(45) NOT NULL,
  `customer_mobile` varchar(45) NOT NULL,
  `customer_email` varchar(45) NOT NULL,
  `join_date` date NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY  (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_regi`
--

/*!40000 ALTER TABLE `customer_regi` DISABLE KEYS */;
INSERT INTO `customer_regi` (`customer_id`,`first_name`,`last_name`,`gender`,`customer_city`,`customer_address`,`customer_mobile`,`customer_email`,`join_date`,`password`) VALUES 
 (1,'younus','s','m','d','d','0189','dfdf','2018-10-10','a123'),
 (2,'jonayet','islamul haq','Male','Dhaka','Dhaka','01946601722','ihyounus89@gmail.com','2018-10-10','p@456');
/*!40000 ALTER TABLE `customer_regi` ENABLE KEYS */;


--
-- Definition of table `login_info`
--

DROP TABLE IF EXISTS `login_info`;
CREATE TABLE `login_info` (
  `login_id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY  (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_info`
--

/*!40000 ALTER TABLE `login_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `login_info` ENABLE KEYS */;


--
-- Definition of table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
CREATE TABLE `order_details` (
  `order_detail_id` int(10) unsigned NOT NULL auto_increment,
  `order_id` int(10) unsigned NOT NULL,
  `order_qty` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`order_detail_id`),
  KEY `FK_order_details_order_id` (`order_id`),
  CONSTRAINT `FK_order_details_order_id` FOREIGN KEY (`order_id`) REFERENCES `product_order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_details`
--

/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
INSERT INTO `order_details` (`order_detail_id`,`order_id`,`order_qty`) VALUES 
 (1,1,0);
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;


--
-- Definition of table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `payment_id` int(10) unsigned NOT NULL auto_increment,
  `payment_type` varchar(45) NOT NULL,
  `payment_date` date NOT NULL,
  `discount` double NOT NULL,
  `grand_total` double NOT NULL,
  `customer_id` int(10) unsigned NOT NULL,
  `order_id` int(10) unsigned NOT NULL,
  `delivery_zone` varchar(45) NOT NULL,
  `netpayment` double NOT NULL,
  `payment_status` varchar(45) NOT NULL,
  `delivery_address` varchar(45) NOT NULL,
  PRIMARY KEY  (`payment_id`),
  KEY `FK_payment_customer_id` (`customer_id`),
  KEY `FK_payment_order_id` (`order_id`),
  CONSTRAINT `FK_payment_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer_regi` (`customer_id`),
  CONSTRAINT `FK_payment_order_id` FOREIGN KEY (`order_id`) REFERENCES `product_order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` (`payment_id`,`payment_type`,`payment_date`,`discount`,`grand_total`,`customer_id`,`order_id`,`delivery_zone`,`netpayment`,`payment_status`,`delivery_address`) VALUES 
 (1,'hand on','2018-10-10',50,10000,1,1,'Dhaka',0,'',''),
 (2,'credit card','2018-10-10',20,10000,2,1,'chittagong',0,'',''),
 (3,'hand on','2018-10-10',20,10000,1,1,'Dhaka',0,'',''),
 (4,'fdfdfd','2018-10-10',500,5000,2,1,'dhaka',0,'','');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;


--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(10) unsigned NOT NULL auto_increment,
  `product_name` varchar(45) NOT NULL,
  `product_desc` varchar(45) NOT NULL,
  `product_size` varchar(45) NOT NULL,
  `product_url` varchar(45) NOT NULL,
  `product_qty` int(10) unsigned NOT NULL,
  `sub_cat_id` int(10) unsigned NOT NULL,
  `cat_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`product_id`),
  KEY `FK_product_sub_cat_id` (`sub_cat_id`),
  KEY `FK_product_cat_id` (`cat_id`),
  CONSTRAINT `FK_product_cat_id` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`),
  CONSTRAINT `FK_product_sub_cat_id` FOREIGN KEY (`sub_cat_id`) REFERENCES `sub_category` (`sub_cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`product_id`,`product_name`,`product_desc`,`product_size`,`product_url`,`product_qty`,`sub_cat_id`,`cat_id`) VALUES 
 (1,'Samsung ','android marshmalow','5 inch','www',30,1,1),
 (2,'Samsung  s8','android nughat','5 inch','www',20,1,1),
 (3,'walton  s8','android marshallo verson','5 inch','www',20,1,1),
 (4,'Samsung jk','android nughat','5 inch','www',20,1,1),
 (6,'Samsung galaxy set','android marshmalow','5 inch','www',20,1,1),
 (7,'Samsung galaxy 10','android marshmalow','5 inch','www',20,5,2),
 (8,'pants','good','32','www',50,8,2),
 (9,'full  shirt','fdf','32','jjjj',20,6,2);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


--
-- Definition of table `product_order`
--

DROP TABLE IF EXISTS `product_order`;
CREATE TABLE `product_order` (
  `order_id` int(10) unsigned NOT NULL auto_increment,
  `order_item` varchar(46) NOT NULL,
  `order_date` date NOT NULL,
  `item_qty` int(10) unsigned NOT NULL,
  `product_id` int(10) unsigned NOT NULL,
  `customer_id` int(10) unsigned NOT NULL,
  `price` double NOT NULL,
  `total_price` double NOT NULL,
  `order_status` varchar(45) NOT NULL,
  `purchase_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`order_id`),
  KEY `FK_product_order_customer_id` (`customer_id`),
  KEY `FK_product_order_product_id` (`product_id`),
  KEY `FK_product_order_purchase_id` (`purchase_id`),
  CONSTRAINT `FK_product_order_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer_regi` (`customer_id`),
  CONSTRAINT `FK_product_order_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `FK_product_order_purchase_id` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`purchase_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_order`
--

/*!40000 ALTER TABLE `product_order` DISABLE KEYS */;
INSERT INTO `product_order` (`order_id`,`order_item`,`order_date`,`item_qty`,`product_id`,`customer_id`,`price`,`total_price`,`order_status`,`purchase_id`) VALUES 
 (1,'walton premo','2015-10-10',5,1,1,0,0,'not delivered',1),
 (2,'walton premo11','2015-10-10',5,1,1,0,0,'not delivered',1),
 (3,'symphony','2015-10-10',5,1,1,0,0,'not delivered',1),
 (4,'samasungs8','2015-10-10',5,1,1,0,0,'not delivered',1),
 (5,'walton','2015-10-10',5,1,1,1000,5000,'not delivered',1),
 (6,'walton7','2015-10-10',5,2,2,1000,5000,'',1);
/*!40000 ALTER TABLE `product_order` ENABLE KEYS */;


--
-- Definition of table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `purchase_id` int(10) unsigned NOT NULL auto_increment,
  `product_id` int(10) unsigned NOT NULL,
  `pur_unit_price` double NOT NULL,
  `product_qty` int(10) unsigned NOT NULL,
  `pur_date` date NOT NULL,
  `pur_total_price` double NOT NULL,
  `supplier_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`purchase_id`),
  KEY `FK_purchase_pro_id` (`product_id`),
  KEY `FK_purchase_supplier_id` (`supplier_id`),
  CONSTRAINT `FK_purchase_pro_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `FK_purchase_supplier_id` FOREIGN KEY (`supplier_id`) REFERENCES `supplier_info` (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase`
--

/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` (`purchase_id`,`product_id`,`pur_unit_price`,`product_qty`,`pur_date`,`pur_total_price`,`supplier_id`) VALUES 
 (1,1,20,10,'2018-10-10',500,1),
 (2,1,20,30,'2018-10-10',1000,1),
 (3,3,10000,30,'2018-10-10',10000,1),
 (4,1,10000,30,'2018-10-10',10000,1),
 (5,8,10000,40,'2018-10-10',1000,3);
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;


--
-- Definition of trigger `purchase_before_insert`
--

DROP TRIGGER /*!50030 IF EXISTS */ `purchase_before_insert`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER `purchase_before_insert` BEFORE INSERT ON `purchase` FOR EACH ROW BEGIN
update product 
set product_qty=product_qty+new.product_qty
where product_id=new.product_id;
END $$

DELIMITER ;

--
-- Definition of table `sale`
--

DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale` (
  `sale_id` int(10) unsigned NOT NULL auto_increment,
  `product_id` int(10) unsigned NOT NULL,
  `unit_sale_price` double NOT NULL,
  `sale_date` date NOT NULL,
  `product_qty` int(10) unsigned NOT NULL,
  `total_sale_price` double NOT NULL,
  `payment_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`sale_id`),
  KEY `FK_sale_product_id` (`product_id`),
  KEY `FK_sale_payment_id` (`payment_id`),
  CONSTRAINT `FK_sale_payment_id` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`payment_id`),
  CONSTRAINT `FK_sale_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sale`
--

/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` (`sale_id`,`product_id`,`unit_sale_price`,`sale_date`,`product_qty`,`total_sale_price`,`payment_id`) VALUES 
 (1,1,100,'2018-10-10',50,500,1),
 (2,1,100,'2018-10-10',20,2000,1);
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;


--
-- Definition of trigger `sale_before_insert`
--

DROP TRIGGER /*!50030 IF EXISTS */ `sale_before_insert`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER `sale_before_insert` BEFORE INSERT ON `sale` FOR EACH ROW BEGIN
update product 
set product_qty=product_qty-new.product_qty
where product_id=new.product_id;
END $$

DELIMITER ;

--
-- Definition of table `sub_category`
--

DROP TABLE IF EXISTS `sub_category`;
CREATE TABLE `sub_category` (
  `sub_cat_id` int(10) unsigned NOT NULL auto_increment,
  `sub_cat_name` varchar(45) NOT NULL,
  `sub_cat_desc` varchar(45) NOT NULL,
  `cat_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`sub_cat_id`),
  KEY `FK_sub_category_cat_id` (`cat_id`),
  CONSTRAINT `FK_sub_category_cat_id` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sub_category`
--

/*!40000 ALTER TABLE `sub_category` DISABLE KEYS */;
INSERT INTO `sub_category` (`sub_cat_id`,`sub_cat_name`,`sub_cat_desc`,`cat_id`) VALUES 
 (1,'mobile','android,iphone 6,etc',1),
 (3,'TV','color,non-color,led monitor etc',1),
 (4,'Freeze','Deep,normal,r etc',1),
 (5,'Computer','computer accessories,router etc',1),
 (6,'T-shirt','new desighn',2),
 (7,'Shirt','Full hand, Half hand',2),
 (8,'jints Pant','choose',2),
 (9,'shoe','lather',2),
 (10,'Panjabi','Long,short,sherwani',2),
 (11,'Bakery','sweet',3),
 (12,'Bread','sweet',3),
 (13,'Milk','powder,liquid',3),
 (14,'fast-food','varius items',3),
 (15,'Cold Drink','icecream,sandwitch ',3),
 (16,'Rice','minicate',4),
 (17,'Dal','good',4),
 (18,'sugar','good',4),
 (19,'salt','good',4);
/*!40000 ALTER TABLE `sub_category` ENABLE KEYS */;


--
-- Definition of table `supplier_info`
--

DROP TABLE IF EXISTS `supplier_info`;
CREATE TABLE `supplier_info` (
  `supplier_id` int(10) unsigned NOT NULL auto_increment,
  `supplier_name` varchar(45) NOT NULL,
  `supplier_address` varchar(45) NOT NULL,
  `supplier_city` varchar(45) NOT NULL,
  `supplier_state` varchar(45) NOT NULL,
  `supplier_zip` int(10) unsigned NOT NULL,
  `supplier_email` varchar(45) NOT NULL,
  `supplier_company` varchar(45) NOT NULL,
  `supplier_join_date` date NOT NULL,
  PRIMARY KEY  (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier_info`
--

/*!40000 ALTER TABLE `supplier_info` DISABLE KEYS */;
INSERT INTO `supplier_info` (`supplier_id`,`supplier_name`,`supplier_address`,`supplier_city`,`supplier_state`,`supplier_zip`,`supplier_email`,`supplier_company`,`supplier_join_date`) VALUES 
 (1,'younus khan','Dhaka','dhaka','bangladesh',1204,'ihyounus89@gmail.com','walton','2018-10-10'),
 (3,'jonayet','dhaka jatrabari','kabul','bangladesh',1204,'www.@gmail.com','bata','2015-10-15');
/*!40000 ALTER TABLE `supplier_info` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
