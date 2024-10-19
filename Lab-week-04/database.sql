-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.2.3-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for spring_data_jdbc
CREATE DATABASE IF NOT EXISTS `spring_data_jdbc` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci */;
USE `spring_data_jdbc`;

-- Dumping structure for table spring_data_jdbc.candidate
CREATE TABLE IF NOT EXISTS `candidate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(50) DEFAULT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

-- Dumping data for table spring_data_jdbc.candidate: ~2 rows (approximately)
INSERT INTO `candidate` (`id`, `last_name`, `middle_name`, `first_name`, `dob`, `email`, `phone`, `address`) VALUES
	(3, 'Tran', 'Hien ', 'Vinh', '2001-12-11', 'vinh1@gmail.com', '056445566', 'Ho Chi Minh City'),
	(4, 'Tran', 'Hien ', 'Vinh1', '2001-12-11', 'vinh1@gmail.com', '056445566', 'Ho Chi Minh City1');

-- Dumping structure for table spring_data_jdbc.candidate_skill
CREATE TABLE IF NOT EXISTS `candidate_skill` (
  `candidate_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  `skill_level` int(11) NOT NULL,
  PRIMARY KEY (`candidate_id`,`skill_id`),
  KEY `FK__skill` (`skill_id`),
  CONSTRAINT `FK__candidate` FOREIGN KEY (`candidate_id`) REFERENCES `candidate` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK__skill` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

-- Dumping data for table spring_data_jdbc.candidate_skill: ~5 rows (approximately)
INSERT INTO `candidate_skill` (`candidate_id`, `skill_id`, `skill_level`) VALUES
	(3, 2, 1),
	(3, 3, 4),
	(3, 7, 5),
	(4, 4, 3),
	(4, 7, 5);

-- Dumping structure for table spring_data_jdbc.job
CREATE TABLE IF NOT EXISTS `job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

-- Dumping data for table spring_data_jdbc.job: ~1 rows (approximately)
INSERT INTO `job` (`id`, `description`) VALUES
	(2, 'Java Developer2');

-- Dumping structure for table spring_data_jdbc.job_skill
CREATE TABLE IF NOT EXISTS `job_skill` (
  `job_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  `require_skill` int(11) DEFAULT NULL,
  PRIMARY KEY (`job_id`,`skill_id`),
  KEY `FK__skill_1` (`skill_id`),
  CONSTRAINT `FK__job_1` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK__skill_1` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

-- Dumping data for table spring_data_jdbc.job_skill: ~0 rows (approximately)

-- Dumping structure for table spring_data_jdbc.skill
CREATE TABLE IF NOT EXISTS `skill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `skill_name` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `field` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

-- Dumping data for table spring_data_jdbc.skill: ~6 rows (approximately)
INSERT INTO `skill` (`id`, `skill_name`, `description`, `field`) VALUES
	(2, 'PHP', 'PHP Developer', 'IT'),
	(3, 'Java', 'Java Developer', 'IT'),
	(4, 'JavaScript', 'JavaScript Developer', 'IT'),
	(5, 'C++', 'C++ Developer', 'IT'),
	(6, 'C#', 'C# Developer', 'IT'),
	(7, 'Python', 'Python Developer', 'IT');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
