/*
SQLyog Community Edition- MySQL GUI v8.02 
MySQL - 5.5.27 : Database - expenses
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`expenses` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `expenses`;

/*Table structure for table `academicyear` */

DROP TABLE IF EXISTS `academicyear`;

CREATE TABLE `academicyear` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `academicyear` */

insert  into `academicyear`(`id`,`created_time`,`updated_time`,`name`,`status`) values (15,'2018-08-07 11:39:07','2018-10-04 16:11:04','2018-2019',1),(16,'2018-08-07 15:56:07','2018-10-04 16:11:04','2019-2020',0);

/*Table structure for table `accounthead` */

DROP TABLE IF EXISTS `accounthead`;

CREATE TABLE `accounthead` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `accounthead` */

insert  into `accounthead`(`id`,`created_time`,`updated_time`,`name`) values (13,'2018-08-25 21:36:14','2018-08-25 21:36:14','backup'),(14,'2018-08-25 21:37:06','2018-08-25 21:37:06','Salary'),(15,'2018-08-25 21:44:23','2018-08-25 21:44:23','Telugu'),(16,'2018-12-11 14:41:47','2018-12-11 14:41:47','charvi');

/*Table structure for table `attendance` */

DROP TABLE IF EXISTS `attendance`;

CREATE TABLE `attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `studentId` varchar(255) DEFAULT NULL,
  `absentSection` varchar(255) DEFAULT NULL,
  `senderId` varchar(255) DEFAULT NULL,
  `message` varchar(1000) DEFAULT NULL,
  `notificationId` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `attendance` */

insert  into `attendance`(`id`,`created_time`,`updated_time`,`studentId`,`absentSection`,`senderId`,`message`,`notificationId`) values (1,'2018-06-07 17:06:19','2018-06-07 17:06:19','504','Morning','1','Your child Telugu is absent for today (Morning session). Please send your child regularly.','3'),(2,'2018-08-27 13:04:52','2018-08-27 13:04:52','514','Fullday','1','Your child Prasad Bhavani is absent for today (Fullday session). Please send your child regularly.','1'),(3,'2018-08-27 13:04:52','2018-08-27 13:04:52','513','Fullday','1','Your child KANKIPATI.THOMAS SASTRY is absent for today (Fullday session). Please send your child regularly.','1'),(4,'2018-08-27 13:04:52','2018-08-27 13:04:52','512','Fullday','1','Your child SHAIK.FAREEDA TABASSUM. is absent for today (Fullday session). Please send your child regularly.','1'),(5,'2018-08-27 13:04:52','2018-08-27 13:04:52','510','Fullday','1','Your child CHENNAMCHETTI.KAVYA PRIYA is absent for today (Fullday session). Please send your child regularly.','1'),(6,'2018-08-27 13:04:52','2018-08-27 13:04:52','509','Fullday','1','Your child NEELAM AMRUTHAVARSHINI is absent for today (Fullday session). Please send your child regularly.','1');

/*Table structure for table `birthdaynotification` */

DROP TABLE IF EXISTS `birthdaynotification`;

CREATE TABLE `birthdaynotification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `studentId` varchar(255) DEFAULT NULL,
  `senderId` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `notificationId` varchar(255) DEFAULT NULL,
  `active` int(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `birthdaynotification` */

/*Table structure for table `boardname` */

DROP TABLE IF EXISTS `boardname`;

CREATE TABLE `boardname` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `boardname` */

insert  into `boardname`(`id`,`created_time`,`updated_time`,`name`) values (10,'2018-05-23 10:32:05','2018-05-23 10:32:05','CBSC'),(11,'2018-08-23 14:58:28','2018-08-23 14:59:42','SSC');

/*Table structure for table `busroute` */

DROP TABLE IF EXISTS `busroute`;

CREATE TABLE `busroute` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `routeName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `busroute` */

insert  into `busroute`(`id`,`createdTime`,`updatedTime`,`routeName`) values (9,'2018-09-21 16:25:34','2018-09-21 16:25:34','Mangalgiri'),(10,'2018-09-21 16:29:56','2018-09-21 16:29:56','Tenali');

/*Table structure for table `busroutefees` */

DROP TABLE IF EXISTS `busroutefees`;

CREATE TABLE `busroutefees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `boardId` int(11) DEFAULT NULL,
  `classId` int(11) DEFAULT NULL,
  `sectionId` int(11) DEFAULT NULL,
  `mediumId` int(11) DEFAULT NULL,
  `routeId` int(11) DEFAULT NULL,
  `busFee` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `busroutefees` */

insert  into `busroutefees`(`id`,`createdTime`,`updatedTime`,`boardId`,`classId`,`sectionId`,`mediumId`,`routeId`,`busFee`) values (10,'2018-09-21 16:29:44','2018-09-21 16:29:44',11,16,20,3,9,2000.00),(12,'2018-09-21 16:42:16','2018-09-21 16:42:16',10,19,24,3,9,2000.00);

/*Table structure for table `classcreation` */

DROP TABLE IF EXISTS `classcreation`;

CREATE TABLE `classcreation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `boardId` int(20) DEFAULT NULL,
  `mediamId` int(20) DEFAULT NULL,
  `className` varchar(255) DEFAULT NULL,
  `section` varchar(255) DEFAULT NULL,
  `fee` double(20,2) DEFAULT '0.00',
  `admissionFee` double(20,2) DEFAULT '0.00',
  `tutionFee` double(20,2) DEFAULT '0.00',
  `transportationFee` double(20,2) DEFAULT '0.00',
  `hostelFee` double(20,2) DEFAULT '0.00',
  `termOne` double(20,2) DEFAULT '0.00',
  `termTwo` double(20,2) DEFAULT '0.00',
  `termThree` double(20,2) DEFAULT '0.00',
  `stationaryFee` double(20,2) DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `classcreation` */

insert  into `classcreation`(`id`,`created_time`,`updated_time`,`boardId`,`mediamId`,`className`,`section`,`fee`,`admissionFee`,`tutionFee`,`transportationFee`,`hostelFee`,`termOne`,`termTwo`,`termThree`,`stationaryFee`) values (6,'2018-05-24 11:56:30','2018-10-12 12:03:17',10,3,'19','24',20000.00,5000.00,5000.00,0.00,5000.00,1666.67,1666.67,1666.67,5000.00),(7,'2018-05-24 12:05:21','2018-10-13 15:53:06',10,3,'19','25',8000.00,2000.00,2000.00,0.00,2000.00,1500.00,500.00,0.00,2000.00),(8,'2018-05-24 12:05:52','2018-10-13 16:04:18',11,3,'16','20',12000.00,3000.00,3000.00,0.00,3000.00,1500.00,1000.00,500.00,3000.00),(9,'2018-05-24 12:06:26','2018-09-19 09:45:11',11,3,'16','21',20000.00,4000.00,4000.00,0.00,4000.00,0.00,0.00,0.00,4000.00),(10,'2018-09-19 11:01:55','2018-09-19 11:01:55',11,4,'18','22',15000.00,3000.00,4000.00,0.00,3000.00,0.00,0.00,0.00,5000.00);

/*Table structure for table `classsubjects` */

DROP TABLE IF EXISTS `classsubjects`;

CREATE TABLE `classsubjects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `boardId` varchar(200) DEFAULT NULL,
  `classId` varchar(200) DEFAULT NULL,
  `subjectId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `classsubjects` */

insert  into `classsubjects`(`id`,`created_time`,`updated_time`,`boardId`,`classId`,`subjectId`) values (1,'2018-06-12 15:10:13','2018-06-12 15:10:13','11','16','1'),(2,'2018-06-12 15:10:20','2018-06-12 15:10:20','11','16','2'),(3,'2018-06-12 15:10:29','2018-06-12 15:10:29','11','16','3'),(4,'2018-06-12 15:10:38','2018-06-12 15:10:38','11','16','4'),(5,'2018-06-12 15:10:54','2018-06-12 15:10:54','11','16','5'),(6,'2018-06-12 15:11:00','2018-06-12 15:11:00','11','16','6'),(7,'2018-08-27 12:18:08','2018-08-27 12:18:08','11','16','7');

/*Table structure for table `classtable` */

DROP TABLE IF EXISTS `classtable`;

CREATE TABLE `classtable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) DEFAULT NULL,
  `boardid` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `classtable` */

insert  into `classtable`(`id`,`created_time`,`updated_time`,`name`,`boardid`) values (16,'2018-05-24 11:12:29','2018-05-24 11:12:45','CLASS VIII',11),(17,'2018-05-24 11:14:44','2018-05-24 11:14:44','CLASS IX',10),(18,'2018-05-24 11:14:55','2018-05-24 11:14:55','CLASS VII',11),(19,'2018-05-24 11:42:44','2018-06-08 10:44:23','CLASS IX',10),(20,'2018-06-09 10:31:26','2018-06-09 10:31:26','sample',11);

/*Table structure for table `client` */

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `clientName` varchar(250) DEFAULT NULL,
  `contactName` varchar(250) DEFAULT NULL,
  `phone` varchar(250) DEFAULT NULL,
  `gmail` varchar(250) DEFAULT NULL,
  `gstIn` varchar(250) DEFAULT NULL,
  `tin` varchar(250) DEFAULT NULL,
  `pan` varchar(250) DEFAULT NULL,
  `vatNo` varchar(250) DEFAULT NULL,
  `billingAddress` varchar(250) DEFAULT NULL,
  `city` varchar(250) DEFAULT NULL,
  `state` varchar(250) DEFAULT NULL,
  `pincode` varchar(250) DEFAULT NULL,
  `country` varchar(250) DEFAULT NULL,
  `pcDetails` varchar(250) DEFAULT NULL,
  `ocDetails` varchar(250) DEFAULT NULL,
  `shippingAddress` varchar(250) DEFAULT NULL,
  `shippingCity` varchar(250) DEFAULT NULL,
  `shippingState` varchar(250) DEFAULT NULL,
  `shippingPincode` varchar(250) DEFAULT NULL,
  `shippingCountry` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `client` */

/*Table structure for table `collections` */

DROP TABLE IF EXISTS `collections`;

CREATE TABLE `collections` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `date` varchar(50) DEFAULT NULL,
  `client` varchar(50) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `amount` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `collections` */

insert  into `collections`(`id`,`date`,`client`,`description`,`amount`) values (1,'12/1/2019','Arjuna','Arjun from collections page','22000'),(2,'11/1/2019','krishna','collections page from daybook','22000'),(3,'dfdfdrrr','krishnaArjuna','description of collecitons page','2000'),(4,'12/1/2019','krishna','description of collecitons page','22000'),(5,'1/1/2019','Arjun','Arjun from collections page','22000');

/*Table structure for table `daybook` */

DROP TABLE IF EXISTS `daybook`;

CREATE TABLE `daybook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `paymentDate` timestamp NULL DEFAULT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `mobileNumber` varchar(20) DEFAULT '0.00',
  `amount` double(10,2) DEFAULT '0.00',
  `paidAmount` double(10,2) DEFAULT NULL,
  `invoiceId` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

/*Data for the table `daybook` */

insert  into `daybook`(`id`,`created_time`,`updated_time`,`paymentDate`,`userName`,`mobileNumber`,`amount`,`paidAmount`,`invoiceId`,`status`) values (40,'2018-12-12 18:10:42','2018-12-12 18:22:40','2018-12-11 00:00:00','raju ','8555863691',2000.00,1000.00,45655,1);

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `EmpId` int(5) NOT NULL,
  `EmpName` varchar(10) DEFAULT NULL,
  `EmpDesg` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`EmpId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

/*Table structure for table `exam_type` */

DROP TABLE IF EXISTS `exam_type`;

CREATE TABLE `exam_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `examType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `exam_type` */

insert  into `exam_type`(`id`,`created_time`,`updated_time`,`examType`) values (1,'2018-06-12 15:01:49','2018-06-12 15:01:49','FA-1'),(2,'2018-06-12 15:01:54','2018-07-21 11:36:06','FA-2'),(3,'2018-06-12 15:02:13','2018-06-12 15:02:13','SA-1'),(4,'2018-06-12 15:02:27','2018-07-21 11:36:15','FA-3'),(5,'2018-06-12 15:02:31','2018-07-21 11:36:42','SA-2'),(6,'2018-06-12 15:02:36','2018-06-12 15:02:36','FA-4'),(7,'2018-07-21 11:43:54','2018-07-21 11:43:54','SA-3');

/*Table structure for table `exammarksmaster` */

DROP TABLE IF EXISTS `exammarksmaster`;

CREATE TABLE `exammarksmaster` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `boardId` varchar(200) DEFAULT NULL,
  `classId` varchar(200) DEFAULT NULL,
  `subjectId` varchar(255) DEFAULT NULL,
  `examtypeId` varchar(255) DEFAULT NULL,
  `maxMarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `exammarksmaster` */

/*Table structure for table `exampattern` */

DROP TABLE IF EXISTS `exampattern`;

CREATE TABLE `exampattern` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `boardId` varchar(255) DEFAULT NULL,
  `sectionId` varchar(255) DEFAULT NULL,
  `mediumId` varchar(255) DEFAULT NULL,
  `examTypeId` varchar(255) DEFAULT NULL,
  `subjectId` varchar(255) DEFAULT NULL,
  `maxMarks` varchar(255) DEFAULT NULL,
  `createdTime` timestamp NULL DEFAULT NULL,
  `updatedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `classId` varchar(255) DEFAULT NULL,
  `randomnum` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `exampattern` */

insert  into `exampattern`(`id`,`boardId`,`sectionId`,`mediumId`,`examTypeId`,`subjectId`,`maxMarks`,`createdTime`,`updatedTime`,`classId`,`randomnum`) values (25,'11','20','3','2','1','100','2018-08-21 10:29:42','2018-08-21 10:29:42','16','25'),(26,'11','20','3','2','2','100','2018-08-21 10:29:42','2018-08-21 10:29:42','16','25'),(27,'11','20','3','2','3','100','2018-08-21 10:29:42','2018-08-21 10:29:42','16','25'),(28,'11','20','3','2','4','100','2018-08-21 10:29:42','2018-08-21 10:29:42','16','25'),(29,'11','20','3','2','5','100','2018-08-21 10:29:42','2018-08-21 10:29:42','16','25'),(30,'11','20','3','2','6','100','2018-08-21 10:29:42','2018-08-21 10:29:42','16','25'),(31,'11','20','3','1','1','10','2018-08-24 10:59:34','2018-08-24 10:59:34','16','70'),(32,'11','20','3','1','2','20','2018-08-24 10:59:34','2018-08-24 10:59:34','16','70'),(33,'11','20','3','1','3','30','2018-08-24 10:59:34','2018-08-24 10:59:34','16','70'),(34,'11','20','3','1','4','40','2018-08-24 10:59:34','2018-08-24 10:59:34','16','70'),(35,'11','20','3','1','5','50','2018-08-24 10:59:34','2018-08-24 10:59:34','16','70'),(36,'11','20','3','1','6','100','2018-08-24 10:59:34','2018-08-24 10:59:34','16','70');

/*Table structure for table `exams` */

DROP TABLE IF EXISTS `exams`;

CREATE TABLE `exams` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `exam_name` varchar(255) DEFAULT NULL,
  `exam_date` timestamp NULL DEFAULT NULL,
  `studentId` varchar(255) DEFAULT NULL,
  `class` varchar(255) DEFAULT NULL,
  `section` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `exams` */

/*Table structure for table `examschedule` */

DROP TABLE IF EXISTS `examschedule`;

CREATE TABLE `examschedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdTime` timestamp NULL DEFAULT NULL,
  `updatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `boardId` varchar(253) DEFAULT NULL,
  `classId` varchar(253) DEFAULT NULL,
  `section` varchar(253) DEFAULT NULL,
  `medium` varchar(253) DEFAULT NULL,
  `examTypeId` varchar(253) DEFAULT NULL,
  `subjectId` varchar(253) DEFAULT NULL,
  `examDate` varchar(253) NOT NULL,
  `fromTime` varchar(253) NOT NULL,
  `toTime` varchar(253) NOT NULL,
  `academicYearId` varchar(253) DEFAULT NULL,
  `randomnum` varchar(253) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `examschedule` */

insert  into `examschedule`(`id`,`createdTime`,`updatedTime`,`boardId`,`classId`,`section`,`medium`,`examTypeId`,`subjectId`,`examDate`,`fromTime`,`toTime`,`academicYearId`,`randomnum`) values (2,'2018-08-22 12:43:05','2018-08-22 12:43:05','11','16','20','3','1','1','22-August-2018','12:42 PM','1:42 PM','15','737'),(3,'2018-08-22 12:43:05','2018-08-22 12:43:05','11','16','20','3','1','2','23-August-2018','11:42 AM','12:42 PM','15','737'),(4,'2018-08-22 12:43:05','2018-08-22 12:43:05','11','16','20','3','1','3','24-August-2018','10:42 AM','11:42 AM','15','737'),(5,'2018-08-22 12:43:05','2018-08-22 12:43:05','11','16','20','3','1','4','25-August-2018','9:42 AM','10:42 AM','15','737'),(6,'2018-08-22 12:43:05','2018-08-22 12:43:05','11','16','20','3','1','5','26-August-2018','8:42 AM','9:42 AM','15','737'),(7,'2018-08-22 12:43:05','2018-08-22 12:43:05','11','16','20','3','1','6','27-August-2018','7:42 AM','8:42 AM','15','737'),(8,'2018-08-22 14:43:07','2018-08-22 14:43:07','10','19','24','3','2','1','28-August-2018','3:42 PM','2:42 PM','15','817'),(9,'2018-08-22 14:43:07','2018-08-22 14:43:07','10','19','24','3','2','2','23-August-2018','2:42 PM','2:43 PM','15','817'),(10,'2018-08-22 14:43:07','2018-08-22 14:43:07','10','19','24','3','2','3','29-August-2018','2:42 PM','2:43 PM','15','817'),(11,'2018-08-22 14:43:07','2018-08-22 14:43:07','10','19','24','3','2','4','23-August-2018','2:42 PM','2:43 PM','15','817'),(12,'2018-08-22 14:43:07','2018-08-22 14:43:07','10','19','24','3','2','5','25-August-2018','2:42 PM','2:43 PM','15','817'),(13,'2018-08-22 14:43:07','2018-08-22 14:43:07','10','19','24','3','2','6','27-August-2018','2:42 PM','2:42 PM','15','817');

/*Table structure for table `faculty` */

DROP TABLE IF EXISTS `faculty`;

CREATE TABLE `faculty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `qualifaction` varchar(255) DEFAULT NULL,
  `contactNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `faculty` */

insert  into `faculty`(`id`,`created_time`,`updated_time`,`name`,`gender`,`qualifaction`,`contactNumber`) values (1,'2018-06-08 10:34:42','2018-06-08 10:34:42','Raju','Male','Msc','8555863691');

/*Table structure for table `facultynotification` */

DROP TABLE IF EXISTS `facultynotification`;

CREATE TABLE `facultynotification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `facultyId` varchar(255) DEFAULT NULL,
  `senderId` varchar(255) DEFAULT NULL,
  `message` varchar(2000) DEFAULT NULL,
  `notificationId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `facultynotification` */

/*Table structure for table `facultysubjects` */

DROP TABLE IF EXISTS `facultysubjects`;

CREATE TABLE `facultysubjects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `facultyId` varchar(255) DEFAULT NULL,
  `boardId` varchar(255) DEFAULT NULL,
  `mediumId` varchar(255) DEFAULT NULL,
  `classId` varchar(255) DEFAULT NULL,
  `sectionId` varchar(255) DEFAULT NULL,
  `subjectId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `facultysubjects` */

insert  into `facultysubjects`(`id`,`created_time`,`updated_time`,`facultyId`,`boardId`,`mediumId`,`classId`,`sectionId`,`subjectId`) values (1,'2018-09-24 15:32:30','2018-09-24 15:32:30','1','11','3','16','20','1');

/*Table structure for table `gst` */

DROP TABLE IF EXISTS `gst`;

CREATE TABLE `gst` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `pdescription` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `qty` double(10,2) DEFAULT '0.00',
  `unit` varchar(255) DEFAULT '0.00',
  `rate` double(10,2) DEFAULT '0.00',
  `totalvalue` double(10,2) DEFAULT '0.00',
  `discount` double(10,2) DEFAULT '0.00',
  `taxable` double(10,2) DEFAULT '0.00',
  `CGSTp` double(10,2) DEFAULT '0.00',
  `CGSTa` double(10,2) DEFAULT '0.00',
  `SGSTp` double(10,2) DEFAULT '0.00',
  `SGSTa` double(10,2) DEFAULT '0.00',
  `IGSTp` double(10,2) DEFAULT '0.00',
  `IGSTa` double(10,2) DEFAULT '0.00',
  `invoiceid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `gst` */

/*Table structure for table `gst_invoice` */

DROP TABLE IF EXISTS `gst_invoice`;

CREATE TABLE `gst_invoice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `invoice_name` varchar(255) DEFAULT NULL,
  `invoice_date` timestamp NULL DEFAULT NULL,
  `party_pan` varchar(255) DEFAULT NULL,
  `party_gst` varchar(255) DEFAULT 'null',
  `party_state` varchar(255) DEFAULT NULL,
  `total_invoice` double(10,2) DEFAULT NULL,
  `total_discount` double(10,2) DEFAULT NULL,
  `total_taxablevalue` double(10,2) DEFAULT NULL,
  `total_cgst` double(10,2) DEFAULT NULL,
  `total_sgst` double(10,2) DEFAULT NULL,
  `total_igst` double(10,2) DEFAULT NULL,
  `grandtotal` double(10,2) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `customer_address` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `gst_invoice` */

/*Table structure for table `gst_percentages` */

DROP TABLE IF EXISTS `gst_percentages`;

CREATE TABLE `gst_percentages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) DEFAULT NULL,
  `percentage` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `gst_percentages` */

/*Table structure for table `ledger` */

DROP TABLE IF EXISTS `ledger`;

CREATE TABLE `ledger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdTime` timestamp NULL DEFAULT NULL,
  `updatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `accountHeadId` int(11) DEFAULT NULL,
  `discription` varchar(255) DEFAULT NULL,
  `amount` double(10,2) DEFAULT NULL,
  `dairydate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `academicYearId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

/*Data for the table `ledger` */

insert  into `ledger`(`id`,`createdTime`,`updatedTime`,`accountHeadId`,`discription`,`amount`,`dairydate`,`academicYearId`) values (4,'2018-07-28 11:07:43','2018-07-28 11:07:43',13,'salary',2000.00,'2018-07-28 11:07:43',15),(5,'2018-07-28 11:07:48','2018-07-28 11:07:48',14,'auto',8000.00,'2018-07-28 11:07:48',15),(6,'2018-07-29 11:07:54','2018-08-10 16:35:21',13,'test',6000.00,'2018-06-28 00:00:00',15),(12,'2018-08-23 17:09:22','2018-08-23 17:09:22',15,'salary',3000.00,'2018-08-23 00:00:00',15),(13,'2018-08-23 17:09:56','2018-08-23 17:11:58',15,'salary',1111.00,'2018-07-03 00:00:00',15),(14,'2018-08-24 17:57:28','2018-08-24 17:57:28',13,'salary',5000.00,'2018-08-24 00:00:00',15),(15,'2018-09-06 21:07:01','2018-09-06 21:07:01',14,'Salary',10000.00,'2018-09-01 00:00:00',15),(16,'2018-09-11 11:12:54','2018-09-11 12:05:17',15,'salary',20000.00,'2018-09-11 00:00:00',15),(17,'2018-09-14 11:51:15','2018-09-14 11:51:15',13,'salary',20000.00,'2018-09-14 00:00:00',15),(18,'2018-09-24 11:39:32','2018-09-24 11:39:32',14,'salary',1000.00,'2018-09-24 00:00:00',15),(19,'2019-01-10 10:56:26','2019-01-10 10:56:26',13,'salary',10000.00,'2019-01-10 00:00:00',NULL);

/*Table structure for table `marks` */

DROP TABLE IF EXISTS `marks`;

CREATE TABLE `marks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `examId` varchar(255) DEFAULT NULL,
  `subject_name` varchar(255) DEFAULT NULL,
  `obtained_marks` varchar(255) DEFAULT NULL,
  `max_marks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `marks` */

/*Table structure for table `marks3` */

DROP TABLE IF EXISTS `marks3`;

CREATE TABLE `marks3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) DEFAULT NULL,
  `examName` varchar(255) DEFAULT NULL,
  `conductedOn` varchar(255) DEFAULT NULL,
  `subject1Name` varchar(255) DEFAULT NULL,
  `obtained1Marks` varchar(255) DEFAULT NULL,
  `max1Marks` varchar(255) DEFAULT NULL,
  `subject2Name` varchar(255) DEFAULT NULL,
  `obtained2Marks` varchar(255) DEFAULT NULL,
  `max2Marks` varchar(255) DEFAULT NULL,
  `subject3Name` varchar(255) DEFAULT NULL,
  `obtained3Marks` varchar(255) DEFAULT NULL,
  `max3Marks` varchar(255) DEFAULT NULL,
  `subject4Name` varchar(255) DEFAULT NULL,
  `obtained4Marks` varchar(255) DEFAULT NULL,
  `max4Marks` varchar(255) DEFAULT NULL,
  `subject5Name` varchar(255) DEFAULT NULL,
  `obtained5Marks` varchar(255) DEFAULT NULL,
  `max5Marks` varchar(255) DEFAULT NULL,
  `subject6Name` varchar(255) DEFAULT NULL,
  `obtained6Marks` varchar(255) DEFAULT NULL,
  `max6Marks` varchar(255) DEFAULT NULL,
  `totalObtainedMarks` varchar(255) DEFAULT NULL,
  `totalMarks` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `message` varchar(2000) CHARACTER SET utf8 DEFAULT NULL,
  `admissionNum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `marks3` */

/*Table structure for table `mediam` */

DROP TABLE IF EXISTS `mediam`;

CREATE TABLE `mediam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `mediam` */

insert  into `mediam`(`id`,`created_time`,`updated_time`,`name`) values (3,'2018-05-22 12:46:13','2018-05-22 12:46:13','English'),(4,'2018-05-23 10:31:37','2018-05-23 10:31:37','Telugu'),(7,'2018-08-28 21:17:02','2018-08-28 21:17:02','Hindi');

/*Table structure for table `notification` */

DROP TABLE IF EXISTS `notification`;

CREATE TABLE `notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `studentId` varchar(255) DEFAULT NULL,
  `senderId` varchar(255) DEFAULT NULL,
  `message` varchar(2000) DEFAULT NULL,
  `notificationId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

/*Data for the table `notification` */

insert  into `notification`(`id`,`created_time`,`updated_time`,`studentId`,`senderId`,`message`,`notificationId`) values (3,'2018-05-22 17:31:57','2018-05-22 17:31:57','220','1','dfsaf','1'),(4,'2018-05-22 17:31:57','2018-05-22 17:31:57','236','1','dfsaf','1'),(5,'2018-05-22 17:31:57','2018-05-22 17:31:57','227','1','dfsaf','1'),(6,'2018-08-21 16:48:23','2018-08-23 08:24:15','513','1','Good Evening parents.\nTake care of you kids','3'),(7,'2018-08-24 12:32:40','2018-08-24 12:32:40','514','1','Hi Telugu :English :Maths :Physics :Chemistry :Social ::','1'),(8,'2018-08-24 12:40:52','2018-08-24 12:40:52','514','1','hi\nTelugu :\nEnglish :\nMaths :\nPhysics :\nChemistry :\nSocial :\n:','1'),(9,'2018-08-24 12:45:47','2018-08-24 12:45:47','514','1','Hi\nTelugu : 22-August-2018 undefined undefined \n\nEnglish : 23-August-2018 undefined undefined \n\nMaths : 24-August-2018 undefined undefined \n\nPhysics : 25-August-2018 undefined undefined \n\nChemistry : 26-August-2018 undefined undefined \n\nSocial : 27-August-2018 undefined undefined \n\n: undefined undefined undefined \n','1'),(10,'2018-08-24 14:58:16','2018-08-24 14:58:16','514','1','Hi\nTelugu : 22-August-2018 undefined undefined \n\nEnglish : 23-August-2018 undefined undefined \n\nMaths : 24-August-2018 undefined undefined \n\nPhysics : 25-August-2018 undefined undefined \n\nChemistry : 26-August-2018 undefined undefined \n\nSocial : 27-August-2018 undefined undefined \n\n: undefined undefined undefined \n','1'),(11,'2018-08-24 14:59:53','2018-08-24 14:59:53','514','1','hi\nTelugu : 22-August-2018 undefined undefined \n\nEnglish : 23-August-2018 undefined undefined \n\nMaths : 24-August-2018 undefined undefined \n\nPhysics : 25-August-2018 undefined undefined \n\nChemistry : 26-August-2018 undefined undefined \n\nSocial : 27-August-2018 undefined undefined \n\n: undefined undefined undefined \n','1'),(12,'2018-08-24 15:24:29','2018-08-24 15:24:29','514','1','hi\nTelugu : 22-August-2018 12:42 PM 1:42 PM \n\nEnglish : 23-August-2018 11:42 AM 12:42 PM \n\nMaths : 24-August-2018 10:42 AM 11:42 AM \n\nPhysics : 25-August-2018 9:42 AM 10:42 AM \n\nChemistry : 26-August-2018 8:42 AM 9:42 AM \n\nSocial : 27-August-2018 7:42 AM 8:42 AM \n\n: undefined undefined undefined \n','1'),(13,'2018-08-24 15:26:56','2018-08-24 15:26:56','514','1','Hi \nTelugu : 22-August-2018 12:42 PM 1:42 PM \n\nEnglish : 23-August-2018 11:42 AM 12:42 PM \n\nMaths : 24-August-2018 10:42 AM 11:42 AM \n\nPhysics : 25-August-2018 9:42 AM 10:42 AM \n\nChemistry : 26-August-2018 8:42 AM 9:42 AM \n\nSocial : 27-August-2018 7:42 AM 8:42 AM \n\n: undefined undefined undefined \n','1'),(14,'2018-08-24 15:28:11','2018-08-24 15:28:11','514','1','Hi\nTelugu : 22-August-2018 From 12:42 PM To 1:42 PM \n\nEnglish : 23-August-2018 From 11:42 AM To 12:42 PM \n\nMaths : 24-August-2018 From 10:42 AM To 11:42 AM \n\nPhysics : 25-August-2018 From 9:42 AM To 10:42 AM \n\nChemistry : 26-August-2018 From 8:42 AM To 9:42 AM \n\nSocial : 27-August-2018 From 7:42 AM To 8:42 AM \n\n: undefined From undefined To undefined \n','1'),(15,'2018-08-24 15:36:50','2018-08-24 15:36:50','514','1','hi\nTelugu : 22-August-2018 From 12:42 PM To 1:42 PM \n\nEnglish : 23-August-2018 From 11:42 AM To 12:42 PM \n\nMaths : 24-August-2018 From 10:42 AM To 11:42 AM \n\nPhysics : 25-August-2018 From 9:42 AM To 10:42 AM \n\nChemistry : 26-August-2018 From 8:42 AM To 9:42 AM \n\nSocial : 27-August-2018 From 7:42 AM To 8:42 AM \n\n: undefined From undefined To undefined \n','1'),(16,'2018-08-24 15:41:44','2018-08-24 15:41:44','514','1','Hi\nTelugu : 22-August-2018 From 12:42 PM To 1:42 PM \n\nEnglish : 23-August-2018 From 11:42 AM To 12:42 PM \n\nMaths : 24-August-2018 From 10:42 AM To 11:42 AM \n\nPhysics : 25-August-2018 From 9:42 AM To 10:42 AM \n\nChemistry : 26-August-2018 From 8:42 AM To 9:42 AM \n\nSocial : 27-August-2018 From 7:42 AM To 8:42 AM \n\n: undefined From undefined To undefined \n','1'),(17,'2018-08-24 17:45:13','2018-08-24 17:45:13','514','1','Hi , prepare well u childrens \nTelugu : 22-August-2018 From 12:42 PM To 1:42 PM \n\nEnglish : 23-August-2018 From 11:42 AM To 12:42 PM \n\nMaths : 24-August-2018 From 10:42 AM To 11:42 AM \n\nPhysics : 25-August-2018 From 9:42 AM To 10:42 AM \n\nChemistry : 26-August-2018 From 8:42 AM To 9:42 AM \n\nSocial : 27-August-2018 From 7:42 AM To 8:42 AM \n','1'),(18,'2018-08-27 13:03:50','2018-08-27 13:03:50','514','1','Today prasada rao party\nB shift vaallu oka ganta mundhu randi','1'),(19,'2018-08-27 13:03:51','2018-08-27 13:03:51','513','1','Today prasada rao party\nB shift vaallu oka ganta mundhu randi','1'),(20,'2018-08-27 13:03:51','2018-08-27 13:03:51','512','1','Today prasada rao party\nB shift vaallu oka ganta mundhu randi','1'),(21,'2018-08-27 13:03:51','2018-08-27 13:03:51','510','1','Today prasada rao party\nB shift vaallu oka ganta mundhu randi','1'),(22,'2018-08-27 13:03:51','2018-08-27 13:03:51','509','1','Today prasada rao party\nB shift vaallu oka ganta mundhu randi','1'),(23,'2018-08-27 13:03:51','2018-08-27 13:03:51','506','1','Today prasada rao party\nB shift vaallu oka ganta mundhu randi','1'),(24,'2018-08-27 13:03:51','2018-08-27 13:03:51','505','1','Today prasada rao party\nB shift vaallu oka ganta mundhu randi','1'),(25,'2018-08-27 13:03:53','2018-08-27 13:03:53','502','1','Today prasada rao party\nB shift vaallu oka ganta mundhu randi','1'),(26,'2018-08-27 13:03:53','2018-08-27 13:03:53','501','1','Today prasada rao party\nB shift vaallu oka ganta mundhu randi','1'),(27,'2018-08-27 13:03:53','2018-08-27 13:03:53','500','1','Today prasada rao party\nB shift vaallu oka ganta mundhu randi','1'),(28,'2018-08-27 13:03:53','2018-08-27 13:03:53','499','1','Today prasada rao party\nB shift vaallu oka ganta mundhu randi','1'),(29,'2018-09-10 18:19:00','2018-09-10 18:19:00','515','1','HI','1');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `productName` varchar(255) DEFAULT NULL,
  `unitPrice` double(10,2) DEFAULT '0.00',
  `quantity` double(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product` */

/*Table structure for table `product1` */

DROP TABLE IF EXISTS `product1`;

CREATE TABLE `product1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `productType` varchar(255) DEFAULT NULL,
  `productUom` varchar(255) DEFAULT NULL,
  `productSku` varchar(255) DEFAULT NULL,
  `productName` varchar(255) DEFAULT NULL,
  `productDescription` varchar(255) DEFAULT NULL,
  `hsn` varchar(255) DEFAULT NULL,
  `unitPrice` double(10,2) DEFAULT '0.00',
  `tax` double(10,2) DEFAULT '0.00',
  `purchaseRate` double(10,2) DEFAULT '0.00',
  `quantity` double(10,2) DEFAULT '0.00',
  `oldProduct` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product1` */

/*Table structure for table `sectiontable` */

DROP TABLE IF EXISTS `sectiontable`;

CREATE TABLE `sectiontable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) DEFAULT NULL,
  `classid` int(11) DEFAULT '0',
  `boardid` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

/*Data for the table `sectiontable` */

insert  into `sectiontable`(`id`,`created_time`,`updated_time`,`name`,`classid`,`boardid`) values (17,'2018-05-24 11:15:19','2018-05-24 11:15:19','A',17,10),(18,'2018-05-24 11:15:25','2018-05-24 11:15:25','B',14,10),(19,'2018-05-24 11:15:36','2018-05-24 11:15:36','B',17,10),(20,'2018-05-24 11:15:45','2018-05-24 11:15:45','A',16,11),(21,'2018-05-24 11:15:51','2018-05-24 11:15:51','B',16,11),(22,'2018-05-24 11:15:57','2018-05-24 11:15:57','A',18,11),(23,'2018-05-24 11:16:02','2018-05-24 11:16:02','B',18,11),(24,'2018-05-24 11:44:27','2018-05-24 11:44:27','A',19,10),(25,'2018-05-24 11:44:35','2018-05-24 11:44:35','B',19,10);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `snoPk` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NOT NULL,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) DEFAULT NULL,
  `boardName` varchar(255) DEFAULT NULL,
  `medium` varchar(255) DEFAULT NULL,
  `className` varchar(255) DEFAULT NULL,
  `section` varchar(255) DEFAULT NULL,
  `rollNum` varchar(255) DEFAULT NULL,
  `admissionNum` varchar(255) DEFAULT NULL,
  `fatherName` varchar(255) DEFAULT NULL,
  `fatherOccupation` varchar(255) DEFAULT NULL,
  `motherName` varchar(255) DEFAULT NULL,
  `motherOccupation` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `alternativeMobile` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `blodgroup` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `dob` timestamp NULL DEFAULT NULL,
  `admissionDate` timestamp NULL DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `previousInstitue` varchar(255) DEFAULT NULL,
  `caste` varchar(255) DEFAULT NULL,
  `acomitation` varchar(255) DEFAULT NULL,
  `buspesility` varchar(255) DEFAULT NULL,
  `busroute` varchar(255) DEFAULT NULL,
  `religion` varchar(255) DEFAULT NULL,
  `imagePath` varchar(255) DEFAULT NULL,
  `totalFee` double(10,2) DEFAULT '0.00',
  `discountFee` double(10,2) DEFAULT '0.00',
  `netFee` double(10,2) DEFAULT '0.00',
  `admissionFee` double(10,2) DEFAULT '0.00',
  `tutionFee` double(10,2) DEFAULT '0.00',
  `transportationFee` double(10,2) DEFAULT '0.00',
  `hostelFee` double(10,2) DEFAULT '0.00',
  `termOne` double(10,2) DEFAULT '0.00',
  `termTwo` double(10,2) DEFAULT '0.00',
  `termThree` double(10,2) DEFAULT '0.00',
  `stationaryFee` double(10,2) DEFAULT '0.00',
  `adharNumber` varchar(20) DEFAULT NULL,
  `academicYearId` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`snoPk`)
) ENGINE=InnoDB AUTO_INCREMENT=592 DEFAULT CHARSET=latin1;

/*Data for the table `student` */

insert  into `student`(`snoPk`,`id`,`created_time`,`updated_time`,`name`,`boardName`,`medium`,`className`,`section`,`rollNum`,`admissionNum`,`fatherName`,`fatherOccupation`,`motherName`,`motherOccupation`,`mobile`,`alternativeMobile`,`email`,`blodgroup`,`gender`,`dob`,`admissionDate`,`region`,`address`,`previousInstitue`,`caste`,`acomitation`,`buspesility`,`busroute`,`religion`,`imagePath`,`totalFee`,`discountFee`,`netFee`,`admissionFee`,`tutionFee`,`transportationFee`,`hostelFee`,`termOne`,`termTwo`,`termThree`,`stationaryFee`,`adharNumber`,`academicYearId`,`status`) values (520,499,'2018-05-24 12:34:02','2018-10-13 11:38:05','NAMBURI SESHA VENKATA PAVAN','10','3','19','24','','3','Reddy','it','house wife','house wife','9676422945','','','','Male','1994-07-29 00:00:00','2018-07-24 00:00:00',NULL,'kodad','','','','','','',NULL,25000.00,6000.00,19000.00,5000.00,5000.00,3000.00,3000.00,1000.00,1000.00,1000.00,3000.00,'1234567890123456',15,1),(521,500,'2018-05-24 13:08:05','2018-10-13 11:47:34','JONNADULA KARTHIK RAM','10','3','19','24','','4','Bandi','politician','politician','house wife','9978451245','','','','Male','1991-05-17 00:00:00','2018-07-24 00:00:00',NULL,'dfgfdgfd','','',NULL,'','','',NULL,25000.00,6000.00,19000.00,2000.00,2000.00,5000.00,5000.00,1666.67,1666.67,1666.67,5000.00,'1234567890123456',15,1),(522,501,'2018-05-24 13:10:43','2018-10-12 12:43:03','Kotaiah','10','3','19','24','','5','Koti','it','it','house wife','9944454545','','','','Male','1990-05-09 00:00:00','2018-07-24 00:00:00',NULL,'hgjhgj','','','','','','',NULL,25000.00,12000.00,13000.00,5000.00,1000.00,1000.00,1000.00,0.00,0.00,0.00,5000.00,'1234567890123456',15,1),(523,502,'2018-05-24 13:31:31','2018-10-13 11:50:34','KATABATHULA.PAVAN CHARAN','10','3','19','24','','6','Reddy','it','house wife','house wife','9978451236','','','','Male','2018-05-03 00:00:00','2018-07-24 00:00:00',NULL,'vfdsfds','','',NULL,'','','',NULL,25000.00,6000.00,19000.00,4000.00,5000.00,5000.00,2000.00,666.67,666.67,666.67,3000.00,'1234567890123456',15,1),(524,505,'2018-06-05 12:37:37','2018-10-12 12:43:03','CHITROJU.YATHEENDRA RANGA CHARYULU','10','3','19','24','515','7','bha','politician','house wife','house wife','8555863691','8555863691','rjrv.143@gmail.com','B+','Male','1987-06-02 00:00:00','2018-07-24 00:00:00',NULL,'hyd','beds','BC','Day-Scholar','No','','Hindu',NULL,15000.00,5000.00,10000.00,1000.00,4000.00,0.00,0.00,0.00,0.00,0.00,5000.00,'1234567890123456',15,1),(525,506,'2018-06-13 11:35:45','2018-10-12 12:43:03','VENEGALLA DEVI SIVA VENKATA SANTHOSHI','10','3','19','24','','56565656','ravi','it','house wife','house wife','9010410484','','','','Male','2018-06-06 00:00:00','2018-07-24 00:00:00',NULL,'hyd','','','Day-Scholar','No',NULL,'',NULL,15000.00,0.00,15000.00,5000.00,5000.00,0.00,0.00,0.00,0.00,0.00,5000.00,'1234567890123456',15,1),(526,509,'2018-06-27 15:47:01','2018-10-12 12:43:03','NEELAM AMRUTHAVARSHINI','11','3','16','20','514','9','ravi','politician','it','house wife','7877878797','','dfsdf@gmail.com','B+','Male','2018-06-13 00:00:00','2018-07-24 00:00:00',NULL,'fasdf','','','Day-Scholar','No','1','Hindu',NULL,12000.00,0.00,12000.00,3000.00,3000.00,3000.00,0.00,0.00,0.00,0.00,3000.00,'1234567890123456',15,1),(527,510,'2018-06-28 12:07:03','2018-10-13 11:39:04','CHENNAMCHETTI.KAVYA PRIYA','11','3','16','20','','8','Ramesh','it','it','house wife','8555863691','','','','Male','2018-06-28 00:00:00','2018-07-24 00:00:00',NULL,'sadfasdf','','',NULL,'','','',NULL,15000.00,0.00,15000.00,3000.00,3000.00,3000.00,3000.00,1000.00,1000.00,1000.00,3000.00,'1234567890123456',15,1),(528,513,'2018-07-24 17:41:27','2018-10-13 11:38:59','KANKIPATI.THOMAS SASTRY','11','3','16','20','','1','fasd','dfasdf','asfas','asdfsdf','9494629050','','','B+','Male','1977-07-04 00:00:00','2018-07-24 00:00:00',NULL,'fasdf','','OC',NULL,'Yes','','',NULL,15000.00,0.00,15000.00,3000.00,3000.00,3000.00,3000.00,1000.00,1000.00,1000.00,3000.00,'5314364654564654',15,1),(529,514,'2018-08-23 11:46:35','2018-10-13 11:38:53','Prasad Bhavani','11','3','16','20','123','033333333333334','fasd','fasd','fasd','fasdf','8555863691','9491862697','test@gmail.com','','Male','2018-08-21 00:00:00','2018-08-17 00:00:00',NULL,'AT','','OC',NULL,'No',NULL,'Hindu',NULL,12000.00,0.00,12000.00,3000.00,3000.00,0.00,3000.00,1000.00,1000.00,1000.00,3000.00,'1234567890123456',15,1),(530,515,'2018-09-10 14:33:17','2018-10-13 11:38:47','Manibabu','11','3','16','20','29','2','VenkatRao','Farmer','Satyavathi','Housewife','9542143848','','manibabu82554@gmail.com','B+','Male','1994-11-12 00:00:00','2001-09-04 00:00:00',NULL,'Nsp','','OC',NULL,'No','','Hindu',NULL,12000.00,0.00,12000.00,3000.00,3000.00,0.00,3000.00,1000.00,1000.00,1000.00,3000.00,'592696827839',15,1),(531,518,'2018-09-20 14:48:56','2018-10-12 12:43:03','fsdfsdaf','11','3','16','20',NULL,NULL,'dfa',NULL,NULL,NULL,'8555863691',NULL,'',NULL,'Male','2001-09-04 00:00:00','2018-08-01 00:00:00',NULL,NULL,NULL,NULL,'Day-Scholar','Yes','5',NULL,NULL,0.00,0.00,0.00,0.00,0.00,2000.00,0.00,0.00,0.00,0.00,0.00,'2555555665446456',15,1),(532,519,'2018-09-20 14:57:59','2018-10-12 12:43:03','leela','11','3','16','20','','12','rrrrr','Software','Amma Garu','House wife asa','8555863691','','','','Female','2000-09-05 00:00:00','2018-08-04 00:00:00',NULL,'Vij','','','Day-Scholar',NULL,NULL,'',NULL,16000.00,0.00,16000.00,3000.00,3000.00,7000.00,0.00,0.00,0.00,0.00,3000.00,'3663621151561654',15,0),(534,520,'2018-10-02 13:51:23','2018-10-13 11:38:36','muthu','11','3','16','20','','13','fn','fo','mn','mo','8555863691','','','','Male','2002-10-02 00:00:00','2018-10-02 00:00:00',NULL,'Vijayawada','','','Hostel',NULL,NULL,'Hindu',NULL,12000.00,0.00,12000.00,3000.00,3000.00,0.00,3000.00,1000.00,1000.00,1000.00,3000.00,'8946465141694616',15,1),(580,520,'2018-10-02 13:51:23','2018-10-12 12:43:03','muthu','10','3','19','25','','14','fn','fo','mn','mo','8555863691','','','','Male','2002-10-02 00:00:00','2018-10-02 00:00:00',NULL,'Vijayawada','','','Hostel',NULL,NULL,'Hindu',NULL,6000.00,0.00,6000.00,0.00,2000.00,0.00,2000.00,0.00,0.00,0.00,2000.00,'8946465141694616',15,1),(581,519,'2018-09-20 14:57:59','2018-10-12 12:43:03','leela','10','3','19','25','','15','rrrrr','Software','Amma Garu','House wife asa','8555863691','','','','Female','2000-09-05 00:00:00','2018-08-04 00:00:00',NULL,'Vij','','','Day-Scholar',NULL,NULL,'',NULL,6000.00,0.00,6000.00,0.00,2000.00,0.00,2000.00,0.00,0.00,0.00,2000.00,'3663621151561654',15,0),(582,518,'2018-09-20 14:48:56','2018-10-12 12:43:03','fsdfsdaf','10','3','19','25',NULL,'16','dfa',NULL,NULL,NULL,'8555863691',NULL,'',NULL,'Male','2001-09-04 00:00:00','2018-08-01 00:00:00',NULL,NULL,NULL,NULL,'Day-Scholar','Yes','5',NULL,NULL,6000.00,0.00,6000.00,0.00,2000.00,0.00,2000.00,0.00,0.00,0.00,2000.00,'2555555665446456',15,1),(583,515,'2018-09-10 14:33:17','2018-10-12 12:43:03','Manibabu','10','3','19','25','29','2','VenkatRao','Farmer','Satyavathi','Housewife','9542143848','','manibabu82554@gmail.com','B+','Male','1994-11-12 00:00:00','2001-09-04 00:00:00',NULL,'Nsp','','OC',NULL,'No','','Hindu',NULL,6000.00,0.00,6000.00,0.00,2000.00,0.00,2000.00,0.00,0.00,0.00,2000.00,'592696827839',15,1),(585,513,'2018-07-24 17:41:27','2018-10-12 12:43:03','KANKIPATI.THOMAS SASTRY','10','3','19','25','','1','fasd','dfasdf','asfas','asdfsdf','9494629050','','','B+','Male','1977-07-04 00:00:00','2018-07-24 00:00:00',NULL,'fasdf','','OC',NULL,'Yes','','',NULL,6000.00,0.00,6000.00,0.00,2000.00,0.00,2000.00,0.00,0.00,0.00,2000.00,'5314364654564654',15,1),(586,510,'2018-06-28 12:07:03','2018-10-12 12:43:03','CHENNAMCHETTI.KAVYA PRIYA','10','3','19','25','','8','Ramesh','it','it','house wife','8555863691','','','','Male','2018-06-28 00:00:00','2018-07-24 00:00:00',NULL,'sadfasdf','','',NULL,'','','',NULL,6000.00,0.00,6000.00,0.00,2000.00,0.00,2000.00,0.00,0.00,0.00,2000.00,'1234567890123456',15,1),(587,509,'2018-06-27 15:47:01','2018-10-12 12:43:03','NEELAM AMRUTHAVARSHINI','10','3','19','25','514','9','ravi','politician','it','house wife','7877878797','','dfsdf@gmail.com','B+','Male','2018-06-13 00:00:00','2018-07-24 00:00:00',NULL,'fasdf','','','Day-Scholar','No','1','Hindu',NULL,6000.00,0.00,6000.00,0.00,2000.00,0.00,2000.00,0.00,0.00,0.00,2000.00,'1234567890123456',15,1),(588,521,'2018-10-04 17:12:09','2018-10-13 11:46:44','venkar ','11','3','16','20','','17','lj','lkjlk','ven','ven','8555863691','','','','Male','2001-10-02 00:00:00','2018-10-04 00:00:00',NULL,'man','','',NULL,'','','',NULL,12000.00,0.00,12000.00,3000.00,3000.00,0.00,3000.00,1000.00,1000.00,1000.00,3000.00,'5454544215646413',15,1),(589,522,'2018-10-04 17:22:15','2018-10-13 11:38:21','ganesh','11','3','16','20','',NULL,'ga','ga','ga','ga','8555863691','','','','Male','2001-10-10 00:00:00','2018-10-03 00:00:00',NULL,'guntur','','','Hostel',NULL,NULL,'',NULL,12000.00,0.00,12000.00,3000.00,3000.00,0.00,3000.00,1000.00,1000.00,1000.00,3000.00,'7644178639643131',15,1),(590,523,'2018-10-04 17:29:55','2018-10-12 15:14:19','hari','11','3','16','20','','033333333333335','har','har','har','har','8555863691','','','','Male','2000-10-30 00:00:00','2018-10-02 00:00:00',NULL,'hye','','',NULL,'','','',NULL,12000.00,0.00,12000.00,3000.00,3000.00,0.00,3000.00,1000.00,1000.00,1000.00,3000.00,'5489465463134654',15,1),(591,524,'2018-10-09 15:34:20','2018-10-13 11:46:02','veerababu','11','3','16','20','','033333333333336','Nanna Garu','Software','Amma Garu','House wife','8555863691','','','','Male','2002-10-01 00:00:00','2018-10-09 00:00:00',NULL,'vij','','',NULL,'No','','',NULL,12000.00,0.00,12000.00,3000.00,3000.00,0.00,3000.00,1000.00,1000.00,1000.00,3000.00,'6542522231055312',15,1);

/*Table structure for table `studentfee` */

DROP TABLE IF EXISTS `studentfee`;

CREATE TABLE `studentfee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `paymentDate` timestamp NULL DEFAULT NULL,
  `studentId` varchar(20) DEFAULT NULL,
  `fee` double(10,2) DEFAULT '0.00',
  `admissionFee` double(10,2) DEFAULT '0.00',
  `tutionFee` double(10,2) DEFAULT '0.00',
  `transportationFee` double(10,2) DEFAULT '0.00',
  `hostelFee` double(10,2) DEFAULT '0.00',
  `termOne` double(10,2) DEFAULT '0.00',
  `termTwo` double(10,2) DEFAULT '0.00',
  `termThree` double(10,2) DEFAULT '0.00',
  `stationaryFee` double(10,2) DEFAULT '0.00',
  `dueFee1` double(10,2) DEFAULT '0.00',
  `userId` int(11) DEFAULT NULL,
  `invoiceId` int(11) DEFAULT NULL,
  `academicYearId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

/*Data for the table `studentfee` */

insert  into `studentfee`(`id`,`created_time`,`updated_time`,`paymentDate`,`studentId`,`fee`,`admissionFee`,`tutionFee`,`transportationFee`,`hostelFee`,`termOne`,`termTwo`,`termThree`,`stationaryFee`,`dueFee1`,`userId`,`invoiceId`,`academicYearId`) values (1,'2018-06-29 16:17:16','2018-09-26 11:52:22','2018-07-06 00:00:00','510',3000.00,3000.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,12000.00,2,67338,15),(6,'2018-07-17 10:57:46','2018-09-26 11:52:22','2018-08-01 00:00:00','510',3000.00,0.00,3000.00,0.00,0.00,0.00,0.00,0.00,0.00,9000.00,1,49221,15),(12,'2018-07-17 12:34:44','2018-09-26 11:52:22','2018-08-02 00:00:00','510',9000.00,0.00,0.00,3000.00,3000.00,0.00,0.00,0.00,3000.00,0.00,1,81276,15),(13,'2018-07-17 15:09:13','2018-09-26 11:52:22','2018-08-03 00:00:00','499',5000.00,5000.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,14000.00,1,91366,15),(14,'2018-07-17 15:11:55','2018-09-26 11:52:22','2018-08-04 00:00:00','499',14000.00,0.00,5000.00,3000.00,3000.00,0.00,0.00,0.00,3000.00,0.00,1,84843,15),(15,'2018-07-18 08:50:35','2018-09-26 11:52:22','2018-08-05 00:00:00','500',2000.00,2000.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,17000.00,1,83411,15),(16,'2018-07-18 08:51:12','2018-09-26 11:52:22','2018-08-06 00:00:00','500',17000.00,0.00,2000.00,5000.00,5000.00,0.00,0.00,0.00,5000.00,0.00,1,88322,15),(22,'2018-08-07 07:53:46','2018-09-26 11:52:22','2018-08-06 00:00:00','509',3000.00,0.00,3000.00,0.00,0.00,0.00,0.00,0.00,0.00,9000.00,1,63439,15),(36,'2018-10-10 11:44:26','2018-10-10 11:44:26','2018-10-10 00:00:00','524',3000.00,0.00,0.00,0.00,3000.00,1000.00,1000.00,1000.00,0.00,9000.00,1,3457,15),(37,'2018-10-10 11:47:48','2018-10-10 11:47:48','2018-10-10 00:00:00','524',9000.00,3000.00,3000.00,0.00,0.00,0.00,0.00,0.00,3000.00,0.00,1,54496,15),(38,'2018-10-12 17:12:27','2018-10-13 11:57:30','2018-10-12 00:00:00','523',1000.00,0.00,0.00,0.00,1000.00,1000.00,0.00,0.00,0.00,11000.00,1,95146,15),(39,'2018-10-12 17:13:00','2018-10-13 11:57:39','2018-10-12 00:00:00','523',500.00,0.00,0.00,0.00,1000.00,0.00,1000.00,0.00,0.00,10500.00,1,99777,15);

/*Table structure for table `studentmarks` */

DROP TABLE IF EXISTS `studentmarks`;

CREATE TABLE `studentmarks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdTime` timestamp NULL DEFAULT NULL,
  `updatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `examTypeId` varchar(255) DEFAULT NULL,
  `boardId` varchar(255) DEFAULT NULL,
  `classId` varchar(255) DEFAULT NULL,
  `sectionId` varchar(255) DEFAULT NULL,
  `mediumId` varchar(255) DEFAULT NULL,
  `subjectId` varchar(255) DEFAULT NULL,
  `studentMarks` varchar(255) DEFAULT NULL,
  `subjectMaxMarks` varchar(255) DEFAULT NULL,
  `studentId` varchar(255) DEFAULT NULL,
  `academicYearId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

/*Data for the table `studentmarks` */

insert  into `studentmarks`(`id`,`createdTime`,`updatedTime`,`examTypeId`,`boardId`,`classId`,`sectionId`,`mediumId`,`subjectId`,`studentMarks`,`subjectMaxMarks`,`studentId`,`academicYearId`) values (31,'2018-10-23 17:43:45','2018-10-23 17:43:45','1','11','16','20','3','1','10','10','523',15),(32,'2018-10-23 17:43:45','2018-10-23 17:43:45','1','11','16','20','3','2','20','20','523',15),(33,'2018-10-23 17:43:45','2018-10-23 17:43:45','1','11','16','20','3','3','30','30','523',15),(34,'2018-10-23 17:43:45','2018-10-23 17:43:45','1','11','16','20','3','4','40','40','523',15),(35,'2018-10-23 17:43:45','2018-10-23 17:43:45','1','11','16','20','3','5','50','50','523',15),(36,'2018-10-23 17:43:45','2018-10-23 17:43:45','1','11','16','20','3','6','60','100','523',15);

/*Table structure for table `subject` */

DROP TABLE IF EXISTS `subject`;

CREATE TABLE `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `subject` */

insert  into `subject`(`id`,`created_time`,`updated_time`,`name`) values (1,'2018-06-12 15:05:57','2018-06-12 15:05:57','Telugu'),(2,'2018-06-12 15:06:04','2018-06-12 15:06:04','English'),(3,'2018-06-12 15:07:52','2018-06-12 15:07:52','Maths'),(4,'2018-06-12 15:08:32','2018-06-12 15:08:32','Physics'),(5,'2018-06-12 15:08:45','2018-06-12 15:08:45','Chemistry'),(6,'2018-06-12 15:09:31','2018-06-12 15:09:31','Social'),(7,'2018-08-27 12:17:52','2018-08-27 12:17:52','Hindi');

/*Table structure for table `timetable` */

DROP TABLE IF EXISTS `timetable`;

CREATE TABLE `timetable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `filePath` varchar(22) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

/*Data for the table `timetable` */

insert  into `timetable`(`id`,`created_time`,`updated_time`,`filePath`) values (8,'2018-06-13 16:17:03','2018-06-13 16:17:03','documents/BOMMD.pdf'),(9,'2018-06-13 16:22:36','2018-06-13 16:22:36','documents/PP5AG.pdf'),(10,'2018-06-13 16:56:28','2018-06-13 16:56:28','documents/U6G7A.xls'),(11,'2018-06-13 17:22:05','2018-06-13 17:22:05','documents/STUCK.xls'),(12,'2018-06-13 17:24:10','2018-06-13 17:24:10','documents/YY29M.xls'),(13,'2018-06-13 17:24:50','2018-06-13 17:24:50','documents/IKZ8M.xls'),(14,'2018-06-13 17:25:51','2018-06-13 17:25:51','documents/03CN8.xls'),(15,'2018-06-13 17:26:38','2018-06-13 17:26:38','documents/JM31R.xls'),(16,'2018-06-13 17:26:56','2018-06-13 17:26:56','documents/H17KB.xls'),(17,'2018-06-13 17:27:58','2018-06-13 17:27:58','documents/2F506.xls'),(18,'2018-06-13 17:36:49','2018-06-13 17:36:49','documents/H5YH9.xls'),(19,'2018-06-13 17:37:53','2018-06-13 17:37:53','documents/NU1BE.xls'),(20,'2018-06-13 17:37:54','2018-06-13 17:37:54','documents/BDL0M.xls'),(21,'2018-06-13 17:38:27','2018-06-13 17:38:27','documents/IC4LB.xls'),(22,'2018-06-13 17:38:29','2018-06-13 17:38:29','documents/3BEDO.xls'),(23,'2018-06-13 17:41:37','2018-06-13 17:41:37','documents/DURXC.xls'),(24,'2018-06-13 17:45:26','2018-06-13 17:45:26','documents/K3EQD.xls'),(25,'2018-08-27 12:23:44','2018-08-27 12:23:44','documents/2YSVR.png');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rolId` int(11) DEFAULT NULL,
  `mobile` varchar(200) DEFAULT 'null',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=473 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`id`,`name`,`password`,`rolId`,`mobile`) values (1,'admin','admin',1,'9948939252'),(2,'accountant','1234',2,'9491121535'),(3,'parent','1234',3,'9948939252'),(9,'Venkat','8IDZA',3,'9640782431'),(10,'VenkatRao','MAR1Z',3,'9542143848'),(11,'Venkat','5SB1G',3,'9542143848'),(12,'Reddy','DUSTQ',3,'9676422945'),(148,'JAGHAN','MDWCY',3,'8985511884'),(149,'VENKATA STYANARAYANA','YC55V',3,'9949814504'),(150,'SRINIVAS RAO','FD4CR',3,'9573342408'),(151,'SURESH','W0QI8',3,'9247521140'),(152,'KOTESWAR RAO','980WT',3,'7474747474'),(153,'SRINIVAS','45MSH',3,'9948619698'),(154,'NAGARAJU','GMZ3N',3,'9963599817'),(155,'SRIMANNARAYANA','WKYKI',3,'9866294665'),(156,'SATYANARAYANA','ZK30O',3,'9948381488'),(157,'SRINU','E97PR',3,'9848928894'),(158,'MALLAIAH','J299C',3,'9052378933'),(159,'VEERANJANAILU','SWVHW',3,'8801156365'),(160,'ESWAR RAO','N4EK8',3,'9290875824'),(161,'MALLIKARJUN','S65ZK',3,'9963033986'),(162,'KAMALAKAR','NC5HK',3,'9848535434'),(163,'VENKATESWAR RAO','OHLHZ',3,'9059051217'),(164,'SIVANARAYANA','QYMK5',3,'7842334824'),(165,'RAM BABU','GU154',3,'9705383462'),(166,'VENKATESWA RAO','OLWRZ',3,'9032274429'),(167,'SRINIVAS','A2EPS',3,'7207431890'),(168,'VENKATESWA RAO','88QOL',3,'9652552038'),(169,'AMAR BABU','LVPPX',3,'9346633003'),(170,'SITA RAMAIAH','1BF9F',3,'9885756272'),(171,'SANGEETHA RAO','MDVOY',3,'9052602407'),(172,'Bangaru Babu','91XE8',3,'8875757575'),(173,'Rajasekar','K6MFN',3,'9703111675'),(174,'Babu','IUFM0',3,'9603858746'),(175,'Baji','WFXRP',3,'7095892537'),(176,'Naresh','7WIJ1',3,'9885020912'),(177,'MAHABUB','3YVZ6',3,'8143187469'),(178,'VENKATESWARLU','U0HR6',3,'9573113112'),(179,'SUDHAKAR','GB1GP',3,'8686920127'),(180,'BHASAKAR RAO','1B4EH',3,'9848249582'),(181,'SRINIVAS RAO','WTZGR',3,'8096251296'),(182,'VENKATESWAR ARO','1C34C',3,'9030440664'),(183,'BHASKAR','YVCHE',3,'994870861'),(184,'VENKATA SATISH','D4ML5',3,'9966691086'),(185,'TARAKA NATH','CLFLP',3,'9705296663'),(186,'MALLIKARJUN','UW0ME',3,'9963022986'),(187,'MANIKYALA RAO','X8IEA',3,'9493920561'),(188,'SIVA NAGA RAJU','1WW2X',3,'9291851989'),(189,'RAMESH','FRALX',3,'9493924720'),(190,'NAGESWAR RAO','R577G',3,'9959304142'),(191,'ADI NARAYANA','YREJU',3,'9989963275'),(192,'SIVA SUNDHAR','D4CK4',3,'9550822173'),(193,'ANAND','BT7NJ',3,'9440088301'),(194,'Venkateswar Rao','36OTA',3,'9160414429'),(195,'Durga venkata satyanarayana','UMQ99',3,'9912466163'),(196,'Hema Raju','65T2L',3,'9908460956'),(197,'Nagarjuna','CW5U3',3,'9247295759'),(198,'Sunil kumar','8H4H1',3,'9000489835'),(199,'Kishna','TTTHX',3,'9701881181'),(200,'PRASAD','J620A',3,'9959681874'),(201,'VEERANJANEYULU','OJ4UG',3,'9848693565'),(202,'NAGA RAJU','6PVS7',3,'9059036591'),(203,'KONDALA RAO','5TCGU',3,'9010092356'),(204,'AMAR BABU','4UT9A',3,'9392233003'),(205,'NAGA RAJU','P8OBK',3,'8686170064'),(206,'SURESH','EM86W',3,'9494914890'),(207,'srinivasarao','VODSY',3,'9177441756'),(208,'LAKSHMAIAH','JOHGR',3,'9553114859'),(209,'RAM PRASAD','L2OBZ',3,'9948716284'),(210,'SUBANI','LA9X3',3,'9705784816'),(211,'VENKATESWARLU','BSO7S',3,'9949359112'),(212,'VENKATESWARLU','TG8MD',3,'8886249679'),(213,'Bangaru babu','M5LST',3,'8874747474'),(214,'Venkateswa rao','OQZXR',3,'9642415335'),(215,'Satyanarayana','42TJY',3,'8875757574'),(216,'B.Suresh','ZZP5Q',3,'9502493763'),(217,'Kishore','TPM1J',3,'9577603541'),(218,'RIZWAN','7FYQC',3,'9676765001'),(219,'YUGANDHAR','SO27T',3,'9705985522'),(220,'SATYANARAYANA','EJ0AE',3,'9030422887'),(221,'SAMBA SIVA RAO','OJS9H',3,'7095695866'),(222,'HANIFSHA KHADRI','8XRCQ',3,'9848334661'),(223,'SREE RAM','1A0I5',3,'9966220596'),(224,'srinivasarao','HFKDQ',3,'8977500893'),(225,'Srinivasa Rao','WKDSH',3,'9296752531'),(226,'Reddy','IG1U1',3,'9978451236'),(227,'SUDHAKAR','DC5RY',3,'9966383852'),(228,'CHINNI KRISHNA','KGL2Z',3,'9966468186'),(229,'MUKANTSWARAO','G6G75',3,'8438048082'),(230,'PURNA SHEKAR','Y2WBJ',3,'9704097226'),(231,'SIVA SANKAR RAO','T9A72',3,'9553564154'),(232,'VIJAYA BHASKAR','PH866',3,'9959665340'),(233,'SIVS NAGA MALLESWARA RAO','22ZOF',3,'9704448263'),(234,'CHENDRASHEKA RAO','2TK9A',3,'7207986276'),(235,'MOULALI','R0FN8',3,'9133201254'),(236,'VENU GOPALA RAO','E4W8N',3,'7799577994'),(237,'Durga venkata satyanarayana','4XOP4',3,'9848148472'),(238,'JACOB JOSEPH','C8Q6A',3,'7893682164'),(239,'PADMAVATHI','WO8OW',3,'8896741236'),(240,'NAGA MURALI KRISHNA','GQG66',3,'8247406998'),(241,'PEDA MUKANTESWAR RAO','2NHJB',3,'8498048082'),(242,'YVS PRASAD','7I1MR',3,'9949910104'),(243,'Venkateswa Rao [late]','KCWD3',3,'7674074978'),(244,'AJAY BABU','5FKB3',3,'9985185296'),(245,'VIJAYA BHASKAR','0LI7C',3,'9492936916'),(246,'NAGARAJU','RQFLZ',3,'7095099901'),(247,'Yedu kondalu','JXYBA',3,'9553809364'),(248,'Gopi','1YQMX',3,'9290627032'),(249,'Loknath','U86QQ',3,'9290877678'),(250,'Neela Rani','WTMVG',3,'8874744545'),(251,'Ramalingeswara rao','7NCYV',3,'9618084344'),(252,'Jeeva Ratnam','8LRUP',3,'8297132487'),(253,'Srinu','B6BER',3,'9346464667'),(254,'DILEEP KUMAR','1VYND',3,'8686858166'),(255,'SAILENDRA','HZV3H',3,'9154243417'),(256,'KOTESWARA RAO','EI60L',3,'8008787589'),(257,'NARASIMHA RAO','7VMCT',3,'9885158355'),(258,'PRASAD','CU8RT',3,'9573063212'),(259,'SIVA ADHINARAYANA','1GFFX',3,'9701877534'),(260,'RAMESH','2ZPEA',3,'9912527542'),(261,'LAXMANA RAO','NZ625',3,'9885521419'),(262,'KIRAN','X7V8T',3,'9160605963'),(263,'UDAY KUMAR','XS0QF',3,'9505950279'),(264,'SRINIVASA RAO','W6BKE',3,'8008688729'),(265,'VENKATESH','XKYR2',3,'7201700916'),(266,'RAMU','5P3ZG',3,'9550852032'),(267,'ABDUL RAWOOF','D5PV8',3,'9963546837'),(268,'VIJAY RAJU','87NVH',3,'9966836137'),(269,'VENKATA RATNAM','490O8',3,'9010475022'),(270,'SUNAND','LSOGW',3,'9000095057'),(271,'SANKAR BABU','SNKOK',3,'903226672'),(272,'VAMSI','XIU3V',3,'9848935858'),(273,'NARASIMHA RAO','LL4QK',3,'9948060018'),(274,'LAKSHMI NARAYANA','OEH12',3,'9963656513'),(275,'VEERABRAHMAM','OSVKC',3,'9912640543'),(276,'ganesh kumar','7XV86',3,'7036001821'),(277,'Bala Subramnyam','WCKC4',3,'9866549485'),(278,'NAGANJANEYULU','1E3RA',3,'7842172908'),(279,'VENKATESWAR RAO','DL7T6',3,'9908774490'),(280,'SRINIVASA RAO','5DR7I',3,'9705400705'),(281,'MAABU SUBHANI','B17L5',3,'7896858585'),(282,'RAMU','4TQT1',3,'9177247920'),(283,'VENKATA KRISHNA','1CZ0P',3,'9949569533'),(284,'RAMANJU','ACVU3',3,'7799639932'),(285,'RAJASEKAR','UKSAD',3,'8184908908'),(286,'LAXMAYYA','414RW',3,'9032438761'),(287,'KISHORE BABU','C7NNY',3,'9550507775'),(288,'VENKATESWAR RAO','V86TB',3,'8977095556'),(289,'SRINIVAS RAO','7S3Y7',3,'9059492186'),(290,'NAGESWAR RAO','F7V8U',3,'9059504022'),(291,'ASHOK KUMAR','6Z4S1',3,'9494108191'),(292,'LENIN BABU','YPOAB',3,'9515345372'),(293,'HARIKRISHNA','88BZM',3,'9666922649'),(294,'SIVAJI','T0MK1',3,'9959779060'),(295,'VENKATA RATNAM','GJPJF',3,'8874747456'),(296,'ANIL KUMAR','RKGYJ',3,'9502500411'),(297,'VARALU','94XWH',3,'9133951090'),(298,'SUDHAKAR','3X3CG',3,'8522824763'),(299,'SATYANARAYANA','66TZN',3,'8878774512'),(300,'Naresh','VAR8L',3,'8874747556'),(301,'Prasad Rao','0XM8C',3,'9978451296'),(302,'Naga Raju','D84NO',3,'8019218926'),(303,'Saidu Babu','989HN',3,'7674851388'),(304,'Rajesh','71RYK',3,'9703044060'),(305,'Srinivas Rao','YFGA0',3,'7036430279'),(306,'Mabu subhani','4DV6K',3,'8899745869'),(307,'Sitha Ramprasad','C72CE',3,'9493017010'),(308,'Gurunadham','5CKDQ',3,'7416569113'),(309,'Mohamad Rafi','PQIDI',3,'8179178063'),(310,'Ramu','NUBQX',3,'8367598330'),(311,'Durga Prasad','ZQ0DS',3,'7680035304'),(312,'Venu Kumar','KXLRQ',3,'8008334448'),(313,'Surya kumar','IM07L',3,'9346943009'),(314,'Mahesh','07X17',3,'9494909673'),(315,'Ramanjaneyulu','EYFVE',3,'8121325490'),(316,'Venu','9CEP3',3,'9985580220'),(317,'Nagaraju','QD5SQ',3,'8143835740'),(318,'Satya Narayana','UW8R1',3,'9949814505'),(319,'Venkataratnam','L48XS',3,'90104775022'),(320,'Vara Prasad','1EOAJ',3,'9515443343'),(321,'Mastan Valli','RWAV7',3,'9154417312'),(322,'Syam Sundar','6QSNB',3,'9959185218'),(323,'NAGA VENKATA PRASANNA KUMAR','5NKHK',3,'9948401287'),(324,'VENKATA RAMAIAH','5MCCP',3,'9703994092'),(325,'SRINIVAS','M3ZZK',3,'8574123644'),(326,'CHAKRAVARTHI','R44SU',3,'7744859612'),(327,'V.V.S. NAGA BHAVANI','MQPIK',3,'9441664999'),(328,'SATISH','XX0SU',3,'8008081143'),(329,'LAKSHMI NARAYANA','PEUVA',3,'9550860252'),(330,'PRASAD','LVRP2',3,'8886276227'),(331,'KOTESWAR RAO','ZT544',3,'9848465323'),(332,'KEDHARNATH','RPO4H',3,'9642575427'),(333,'LAKSHMAN KUMAR','OLA47',3,'9010723288'),(334,'DURGHA SRINIVAS','AP2PQ',3,'9848103749'),(335,'SRIKANTH','JSHPE',3,'9396125144'),(336,'SIVA SANKAR','MKD4E',3,'9848850334'),(337,'GANESH','EFWGQ',3,'9963182099'),(338,'RAMULU','NP2ZJ',3,'8501887227'),(339,'VENKATESWARLU','SJKYM',3,'9441864152'),(340,'JOGESWAR RAO','Y4517',3,'9959951156'),(341,'SIVA SANKAR RAO','T9RVV',3,'9603676586'),(342,'ANIL KUMAR','CO8OG',3,'9849331499'),(343,'VENKATARATNAM','0N4DW',3,'9014091995'),(344,'KIRAN DAS','H2E26',3,'9885203139'),(345,'Durga Rao','VEYZH',3,'9010555279'),(346,'DURGA PRASAD','1334U',3,'9666056169'),(347,'HARISH','RA35W',3,'9000098820'),(348,'SAI','4I0BZ',3,'9848143738'),(349,'Suresh','NVXH0',3,'9966645215'),(350,'VENKATA KRISHNA','KISG2',3,'8977090235'),(351,'VENKATESWAR RAO','VGKSP',3,'9490083248'),(352,'SURESH','8D08U',3,'9618768005'),(353,'BHASKAR','JSEYG',3,'8143206320'),(354,'SANKAR','K2FUF',3,'9703410001'),(355,'DURGHA NAGA MALLI','T08K0',3,'8790734102'),(356,'ADI NARAYANA','7JE73',3,'989963275'),(357,'SIVA SHANKAR','TTEM9',3,'9912887328'),(358,'KIRAN','0YCYK',3,'9912421485'),(359,'KOTESWAR RAO','DIIES',3,'8121923562'),(360,'RAJESH','EG10L',3,'7032469971'),(361,'VENKATESH','K2CLT',3,'7207100976'),(362,'YEDU KONDALU','AD0WR',3,'9848996517'),(363,'BHASKAR RAO','8G7JT',3,'9948708617'),(364,'SAIDULU','43S4O',3,'9052234759'),(365,'SRINIVAS RAO','L8WKI',3,'9492101386'),(366,'VARA PRASAD','OMVC6',3,'9298004542'),(367,'SIVA NAGA MALLESWARAO','SMYNQ',3,'970448263'),(368,'BHASKAR RAO','M708S',3,'9848649582'),(369,'SUNAND','YGCMB',3,'900005057'),(370,'NAGARAJU','HQ8EZ',3,'9652819022'),(371,'PEDDI RAJU','2GNS0',3,'9441031473'),(372,'MADHAVA RAO','T1IJ2',3,'90308229944'),(373,'RAJESH','QJ11O',3,'9550306601'),(374,'YEDUKONDALU','BJUX2',3,'9160105056'),(375,'SYAM PRASD','XNB3S',3,'9705867050'),(376,'VENKATESWA RAO','7LU4V',3,'9553645223'),(377,'BIKSHA RAO','4X85H',3,'8341986915'),(378,'VENKATA VASANTH KUMAR','KX1TO',3,'9290351986'),(379,'SATHYANAND','QX0P3',3,'9014646387'),(380,'AYYAPPA','MH5FE',3,'9885251474'),(381,'NAGAMANI','ZQOEU',3,'9848522525'),(382,'MOHAN','Q0V91',3,'9951586361'),(383,'KAMACHARI','A7N7D',3,'7396618119'),(384,'SOMESWAR RAO','T07KO',3,'9966133281'),(385,'PRATAP','ZUDCR',3,'7386383937'),(386,'BHASKAR RAO','4PZN5',3,'8497977899'),(387,'RAJENDRA','Z7T81',3,'7382053005'),(388,'Vankatesh','K5LH3',3,'9885233342'),(456,'Raju','raju',2,'9999999999'),(457,'sssssssssssss','2OYXT',3,'9999999997'),(458,'sssssssssssss','P6Y1Z',3,'9977874455'),(459,'Bandi','GAU1N',3,'9978451245'),(460,'Koti','OFXS8',3,'9944454545'),(461,'WDEQw','SCJKN',3,'7666666666'),(462,'fasd','N3T72',3,'9491862697'),(463,'ravi','SD0SM',3,'7877878797'),(464,'Ramesh','KUDK8',3,'7799878777'),(465,'fasd','7HJOX',3,'9494629050'),(466,'fasd','PDNK8',3,'7777777777'),(467,'rrrrr','5LNIT',3,'8555863691'),(468,NULL,'XF7OL',3,NULL),(469,'lj','RS9F5',3,'8555863691'),(470,'ga','7C9R5',3,'8555863691'),(471,'har','2CPZ0',3,'8555863691'),(472,'Nanna Garu','B6VLW',3,'8555863691');

/*Table structure for table `attendanceview` */

DROP TABLE IF EXISTS `attendanceview`;

/*!50001 DROP VIEW IF EXISTS `attendanceview` */;
/*!50001 DROP TABLE IF EXISTS `attendanceview` */;

/*!50001 CREATE TABLE `attendanceview` (
  `studentId` int(11) NOT NULL,
  `boardId` int(11) NOT NULL DEFAULT '0',
  `mobile` varchar(255) DEFAULT NULL,
  `mediumId` int(11) NOT NULL DEFAULT '0',
  `classId` int(11) NOT NULL DEFAULT '0',
  `sectionId` int(11) NOT NULL DEFAULT '0',
  `studentName` varchar(255) DEFAULT NULL,
  `absentSection` varchar(255) DEFAULT NULL,
  `absentDate` date DEFAULT NULL,
  `message` varchar(1000) DEFAULT NULL,
  `className` varchar(255) DEFAULT NULL,
  `sectionName` varchar(255) DEFAULT NULL,
  `boardName` varchar(255) DEFAULT NULL,
  `admissionNum` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 */;

/*Table structure for table `notificationview` */

DROP TABLE IF EXISTS `notificationview`;

/*!50001 DROP VIEW IF EXISTS `notificationview` */;
/*!50001 DROP TABLE IF EXISTS `notificationview` */;

/*!50001 CREATE TABLE `notificationview` (
  `studentId` int(11) NOT NULL,
  `studentName` varchar(255) DEFAULT NULL,
  `notificationCreatedtime` date DEFAULT NULL,
  `sectionId` int(11) NOT NULL DEFAULT '0',
  `boardId` int(11) NOT NULL DEFAULT '0',
  `mediumId` int(11) NOT NULL DEFAULT '0',
  `classId` int(11) NOT NULL DEFAULT '0',
  `absentDate` date DEFAULT NULL,
  `message` varchar(2000) DEFAULT NULL,
  `className` varchar(255) DEFAULT NULL,
  `sectionName` varchar(255) DEFAULT NULL,
  `boardName` varchar(255) DEFAULT NULL,
  `admissionNum` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 */;

/*Table structure for table `studentlist` */

DROP TABLE IF EXISTS `studentlist`;

/*!50001 DROP VIEW IF EXISTS `studentlist` */;
/*!50001 DROP TABLE IF EXISTS `studentlist` */;

/*!50001 CREATE TABLE `studentlist` (
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 */;

/*Table structure for table `studentlistview` */

DROP TABLE IF EXISTS `studentlistview`;

/*!50001 DROP VIEW IF EXISTS `studentlistview` */;
/*!50001 DROP TABLE IF EXISTS `studentlistview` */;

/*!50001 CREATE TABLE `studentlistview` (
  `studentId` int(11) NOT NULL,
  `studentName` varchar(255) DEFAULT NULL,
  `absentSection` varchar(255) DEFAULT NULL,
  `absentDate` date DEFAULT NULL,
  `message` varchar(1000) DEFAULT NULL,
  `className` varchar(255) DEFAULT NULL,
  `sectionName` varchar(255) DEFAULT NULL,
  `boardName` varchar(255) DEFAULT NULL,
  `admissionNum` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 */;

/*View structure for view attendanceview */

/*!50001 DROP TABLE IF EXISTS `attendanceview` */;
/*!50001 DROP VIEW IF EXISTS `attendanceview` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `attendanceview` AS select `s`.`id` AS `studentId`,`bn`.`id` AS `boardId`,`s`.`mobile` AS `mobile`,`m`.`id` AS `mediumId`,`ct`.`id` AS `classId`,`st`.`id` AS `sectionId`,`s`.`name` AS `studentName`,`att`.`absentSection` AS `absentSection`,cast(`att`.`created_time` as date) AS `absentDate`,`att`.`message` AS `message`,`ct`.`name` AS `className`,`st`.`name` AS `sectionName`,`bn`.`name` AS `boardName`,`s`.`admissionNum` AS `admissionNum` from (((((`attendance` `att` join `student` `s`) join `classtable` `ct`) join `sectiontable` `st`) join `boardname` `bn`) join `mediam` `m`) where ((`s`.`id` = `att`.`studentId`) and (`s`.`section` = `st`.`id`) and (`s`.`className` = `ct`.`id`) and (`st`.`id` = `s`.`section`) and (`s`.`boardName` = `bn`.`id`) and (`m`.`id` = `s`.`medium`)) */;

/*View structure for view notificationview */

/*!50001 DROP TABLE IF EXISTS `notificationview` */;
/*!50001 DROP VIEW IF EXISTS `notificationview` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `notificationview` AS select `s`.`id` AS `studentId`,`s`.`name` AS `studentName`,cast(`nt`.`created_time` as date) AS `notificationCreatedtime`,`st`.`id` AS `sectionId`,`bn`.`id` AS `boardId`,`m`.`id` AS `mediumId`,`ct`.`id` AS `classId`,cast(`nt`.`created_time` as date) AS `absentDate`,`nt`.`message` AS `message`,`ct`.`name` AS `className`,`st`.`name` AS `sectionName`,`bn`.`name` AS `boardName`,`s`.`admissionNum` AS `admissionNum` from (((((`notification` `nt` join `student` `s`) join `classtable` `ct`) join `sectiontable` `st`) join `boardname` `bn`) join `mediam` `m`) where ((`s`.`id` = `nt`.`studentId`) and (`s`.`section` = `st`.`id`) and (`s`.`className` = `ct`.`id`) and (`st`.`id` = `s`.`section`) and (`s`.`boardName` = `bn`.`id`) and (`m`.`id` = `s`.`medium`)) */;

/*View structure for view studentlist */

/*!50001 DROP TABLE IF EXISTS `studentlist` */;
/*!50001 DROP VIEW IF EXISTS `studentlist` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `studentlist` AS select `s`.`name` AS `name` from ((`student` `s` join `mediam` `m`) join `classtable` `ct`) where ((`s`.`medium` = `m`.`id`) and (`s`.`className` = `ct`.`id`)) */;

/*View structure for view studentlistview */

/*!50001 DROP TABLE IF EXISTS `studentlistview` */;
/*!50001 DROP VIEW IF EXISTS `studentlistview` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `studentlistview` AS select `s`.`id` AS `studentId`,`s`.`name` AS `studentName`,`att`.`absentSection` AS `absentSection`,cast(`att`.`created_time` as date) AS `absentDate`,`att`.`message` AS `message`,`ct`.`name` AS `className`,`st`.`name` AS `sectionName`,`bn`.`name` AS `boardName`,`s`.`admissionNum` AS `admissionNum` from (((((`attendance` `att` join `student` `s`) join `classtable` `ct`) join `sectiontable` `st`) join `boardname` `bn`) join `mediam` `m`) where ((`s`.`id` = `att`.`studentId`) and (`s`.`section` = `st`.`id`) and (`s`.`className` = `ct`.`id`) and (`st`.`id` = `s`.`section`) and (`s`.`boardName` = `bn`.`id`) and (`m`.`id` = `s`.`medium`)) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
