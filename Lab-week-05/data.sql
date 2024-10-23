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


-- Dumping database structure for demo_spring_data_jpa
CREATE DATABASE IF NOT EXISTS `demo_spring_data_jpa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `demo_spring_data_jpa`;

-- Dumping structure for table demo_spring_data_jpa.account
CREATE TABLE IF NOT EXISTS `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `balance` double NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `number_account` varchar(255) NOT NULL,
  `owner_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKje14thmnqiph0626m2f4m0fre` (`number_account`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table demo_spring_data_jpa.account: ~100 rows (approximately)
INSERT INTO `account` (`id`, `balance`, `email`, `number_account`, `owner_name`, `password`) VALUES
	(1, 324.42659478340175, 'owner0@gmail.com', '1f007f22-997f-4423-80b5-a27bc18866e2', 'Owner 0', '123456'),
	(2, 390.97722231614875, 'owner1@gmail.com', '6e22371f-973f-4ba8-90ad-f0e5752b720b', 'Owner 1', '123456'),
	(3, 721.2271239057374, 'owner2@gmail.com', '7f16e14c-a3e4-41c1-8051-f5d1ded53d92', 'Owner 2', '123456'),
	(4, 335.5536058725859, 'owner3@gmail.com', '2bc71dcf-f855-4e78-a388-b6606af368d0', 'Owner 3', '123456'),
	(5, 498.9152453956424, 'owner4@gmail.com', '28b5363d-15c5-4743-bfb3-7fbfbfe8ee3b', 'Owner 4', '123456'),
	(6, 685.030697372098, 'owner5@gmail.com', '0750fea4-4b0e-42dc-8f14-edc604187ae7', 'Owner 5', '123456'),
	(7, 608.0263396671278, 'owner6@gmail.com', 'a0054089-a1da-473e-aa5e-fe14ee5daeaf', 'Owner 6', '123456'),
	(8, 906.7035780626378, 'owner7@gmail.com', '546af579-ee0a-4d45-bc03-6ee436d2a13f', 'Owner 7', '123456'),
	(9, 216.20101531236168, 'owner8@gmail.com', '55fb9db5-e496-4456-9b1d-712744137020', 'Owner 8', '123456'),
	(10, 907.1739703620877, 'owner9@gmail.com', 'c01b6fd4-8a31-40bb-96eb-bf6fc0a53235', 'Owner 9', '123456'),
	(11, 412.2322539750444, 'owner10@gmail.com', 'ac3ad951-6eb1-4ca9-8d52-1a4fd018e402', 'Owner 10', '123456'),
	(12, 374.5140716957031, 'owner11@gmail.com', 'a28180ef-98f1-45ea-9f85-c7987d940ae1', 'Owner 11', '123456'),
	(13, 990.2983814670205, 'owner12@gmail.com', '991d8a8a-149c-4469-b8b2-6ef32a796c56', 'Owner 12', '123456'),
	(14, 540.4155584911736, 'owner13@gmail.com', 'e82e0203-9030-4a48-aea2-0c0d99fab3f6', 'Owner 13', '123456'),
	(15, 922.7373356398315, 'owner14@gmail.com', '585ae1e5-9270-4d71-8cf0-4f21d5e38e38', 'Owner 14', '123456'),
	(16, 620.8311154428927, 'owner15@gmail.com', '2eabf4a1-8f4a-4e56-aead-5dc39d069a45', 'Owner 15', '123456'),
	(17, 920.6937916413241, 'owner16@gmail.com', 'c788be08-3b97-40bb-9565-daea8163c322', 'Owner 16', '123456'),
	(18, 53.32438070159851, 'owner17@gmail.com', '22d315e3-2621-41e2-8b34-b1ee6a67b9f0', 'Owner 17', '123456'),
	(19, 110.62830163850268, 'owner18@gmail.com', '761ad411-5bb4-4499-bb42-96a3322d75de', 'Owner 18', '123456'),
	(20, 708.9155166520958, 'owner19@gmail.com', '0a9b93e0-07fe-42b7-a6f1-a55e43f3ee2e', 'Owner 19', '123456'),
	(21, 413.0259753721895, 'owner20@gmail.com', '2858a6ca-d524-4a2d-9a2f-65ec71640464', 'Owner 20', '123456'),
	(22, 742.0941048973675, 'owner21@gmail.com', '98502ade-2a73-4575-8cda-d564b907f3db', 'Owner 21', '123456'),
	(23, 798.0822629148685, 'owner22@gmail.com', '051e1593-9534-4767-befc-3dfb64dea52a', 'Owner 22', '123456'),
	(24, 175.96937310408413, 'owner23@gmail.com', 'cac0a15d-4ab1-4da3-b660-a4eb6666ec18', 'Owner 23', '123456'),
	(25, 118.58041080443805, 'owner24@gmail.com', 'c312d174-2f6f-451d-a492-1d0679d48219', 'Owner 24', '123456'),
	(26, 384.20145703083233, 'owner25@gmail.com', '0c981585-95eb-4836-b52c-4e6a14324bf2', 'Owner 25', '123456'),
	(27, 695.4887484757902, 'owner26@gmail.com', '5f941dbc-9554-408d-9800-eb69adb6b65e', 'Owner 26', '123456'),
	(28, 743.8249468982978, 'owner27@gmail.com', '3edbd45b-5315-4fb9-8c55-d04ea585c353', 'Owner 27', '123456'),
	(29, 51.53753710999898, 'owner28@gmail.com', 'cee407c5-a86c-483f-ab71-1e623eb7c1f2', 'Owner 28', '123456'),
	(30, 6.259386786019672, 'owner29@gmail.com', '2fd48d13-8f96-4ff9-bd22-ef7e385fdab4', 'Owner 29', '123456'),
	(31, 737.3323075900475, 'owner30@gmail.com', 'a03dde1e-baee-4ca8-81c7-0a02b46c72e2', 'Owner 30', '123456'),
	(32, 7.0191354336778256, 'owner31@gmail.com', 'c4008a38-e9f1-4d2b-9c22-879cc2400b71', 'Owner 31', '123456'),
	(33, 522.3746501416002, 'owner32@gmail.com', '097a05a3-2bdf-4ac3-a94e-23fba02dae99', 'Owner 32', '123456'),
	(34, 59.24753043436204, 'owner33@gmail.com', '724b8670-d877-4748-a1d6-9c2e1b3ab71d', 'Owner 33', '123456'),
	(35, 927.3168336165115, 'owner34@gmail.com', '2c6e6487-8d5e-4c07-b6dc-a3d6a6bdc8c0', 'Owner 34', '123456'),
	(36, 951.9929102631652, 'owner35@gmail.com', 'ef035527-233d-4ae5-9fb9-673709bdd559', 'Owner 35', '123456'),
	(37, 429.32824966234415, 'owner36@gmail.com', 'f2f69f3c-726b-4e3c-a085-cdc01d8edfa6', 'Owner 36', '123456'),
	(38, 746.8760607199229, 'owner37@gmail.com', '2d2e602c-c6e5-42e5-b07a-e1f57d22933d', 'Owner 37', '123456'),
	(39, 899.6933868877825, 'owner38@gmail.com', '671d5b98-8365-4dd2-89a1-9ef20a098535', 'Owner 38', '123456'),
	(40, 746.5416128562223, 'owner39@gmail.com', '45daf1a8-62d5-4e2d-972d-56a9f66d7406', 'Owner 39', '123456'),
	(41, 808.1802017214336, 'owner40@gmail.com', '5308aa03-bb43-43c2-a568-510c28fa635b', 'Owner 40', '123456'),
	(42, 22.43961576179576, 'owner41@gmail.com', '6c1d7e4b-ef47-4801-95cc-647ad1dc9257', 'Owner 41', '123456'),
	(43, 619.4289683007902, 'owner42@gmail.com', '4df5ad1b-d52c-4e46-8e14-4fc79d795f9f', 'Owner 42', '123456'),
	(44, 212.58047578396776, 'owner43@gmail.com', '1e033339-79c9-4161-b75e-03734f6ac357', 'Owner 43', '123456'),
	(45, 763.5980331575423, 'owner44@gmail.com', 'e4b3536f-b207-49ba-a971-e07aaf08b056', 'Owner 44', '123456'),
	(46, 528.7422499097474, 'owner45@gmail.com', '1e91f739-09d1-4c60-bb4c-9bc6f504d844', 'Owner 45', '123456'),
	(47, 141.12948387678682, 'owner46@gmail.com', 'bde7ab15-ef27-4a32-9ad1-1185258f2789', 'Owner 46', '123456'),
	(48, 278.3208797505986, 'owner47@gmail.com', '0e10c971-de1a-4f73-bce4-40f0fd8fa78b', 'Owner 47', '123456'),
	(49, 611.6231874256662, 'owner48@gmail.com', 'e2716f27-03b3-4746-96c2-a06cd780a5da', 'Owner 48', '123456'),
	(50, 150.80318692230165, 'owner49@gmail.com', 'b1acdee5-f40c-4506-a31e-3ea60e97e80c', 'Owner 49', '123456'),
	(51, 158.40855991011392, 'owner50@gmail.com', '04308ee8-cfd5-426a-a19d-a00d590bb857', 'Owner 50', '123456'),
	(52, 223.23717245521334, 'owner51@gmail.com', 'd6027f16-9ed5-4beb-baa6-53df7f465b82', 'Owner 51', '123456'),
	(53, 822.8272863488121, 'owner52@gmail.com', '066124c0-57a0-41ff-b40f-4202a63c31ac', 'Owner 52', '123456'),
	(54, 892.1746782027977, 'owner53@gmail.com', '2e51e877-2f70-42c1-8683-b88430f0528e', 'Owner 53', '123456'),
	(55, 329.00223222319727, 'owner54@gmail.com', '585b832a-3789-4cd7-a552-4ae2ac64c936', 'Owner 54', '123456'),
	(56, 598.5826505950498, 'owner55@gmail.com', '03c8df22-e24c-4da3-9bc2-3f76071172c6', 'Owner 55', '123456'),
	(57, 317.09154631681747, 'owner56@gmail.com', 'a907d255-cb98-48e3-b39b-84e3f678bae0', 'Owner 56', '123456'),
	(58, 16.59652515152066, 'owner57@gmail.com', '6f999dc8-e24d-48be-ba05-8abd7f9faaa0', 'Owner 57', '123456'),
	(59, 230.43002714168236, 'owner58@gmail.com', 'a1702549-5400-4253-8c4e-6e264990b7c4', 'Owner 58', '123456'),
	(60, 12.511114950121694, 'owner59@gmail.com', '4f62536f-5cca-477e-a9d3-a7bfd8dbb29f', 'Owner 59', '123456'),
	(61, 358.8169174503051, 'owner60@gmail.com', 'd5960ebe-67c3-4603-91ac-8dbf8f47133e', 'Owner 60', '123456'),
	(62, 135.86053985104562, 'owner61@gmail.com', 'bf253d87-447c-4deb-aad6-a324cb304d61', 'Owner 61', '123456'),
	(63, 584.1049298710387, 'owner62@gmail.com', '7ecf5763-72f6-48df-b1bc-6e1fc26c367d', 'Owner 62', '123456'),
	(64, 891.1067613222925, 'owner63@gmail.com', 'e6dd8772-e3f7-4dec-8fef-2e108073ae73', 'Owner 63', '123456'),
	(65, 795.55308696041, 'owner64@gmail.com', '3efc8e9e-9908-4c78-9d8a-406d4062d00f', 'Owner 64', '123456'),
	(66, 615.2449570283051, 'owner65@gmail.com', 'e482340e-c9a8-48e2-8dc1-2f28a6cc8909', 'Owner 65', '123456'),
	(67, 127.46459694296452, 'owner66@gmail.com', 'dd37e5a1-a383-4a59-9823-2db69668c93c', 'Owner 66', '123456'),
	(68, 75.62359261688067, 'owner67@gmail.com', '88cfad9c-1271-4e17-b371-6aaf72b0926f', 'Owner 67', '123456'),
	(69, 334.901784324939, 'owner68@gmail.com', '746cc292-c045-4f09-ad01-9b7e1ce167b3', 'Owner 68', '123456'),
	(70, 0.5714918832393501, 'owner69@gmail.com', 'ee901ede-b7d0-420d-9c89-c2ac319f6714', 'Owner 69', '123456'),
	(71, 312.92283973535797, 'owner70@gmail.com', '8892c39d-9267-4f55-9cf2-dfab50893e67', 'Owner 70', '123456'),
	(72, 25.94873849851598, 'owner71@gmail.com', 'd6e033f6-f605-4706-9fed-64716b73b7ee', 'Owner 71', '123456'),
	(73, 462.4485337068782, 'owner72@gmail.com', 'e1212fad-ddaa-4db3-9e78-d9644ecae4ce', 'Owner 72', '123456'),
	(74, 980.4850833459673, 'owner73@gmail.com', '8d449f90-ad41-4e13-b8b1-468bd3fce1dc', 'Owner 73', '123456'),
	(75, 376.6012866395162, 'owner74@gmail.com', 'cdfcf2d8-9c6a-46fe-8758-eaa1499ef47c', 'Owner 74', '123456'),
	(76, 898.6366440002079, 'owner75@gmail.com', 'be375ad7-650d-4900-bab9-929e218dccd9', 'Owner 75', '123456'),
	(77, 573.5123193213717, 'owner76@gmail.com', 'f4446dd8-9ca8-4368-ab9f-b2e3db6ee59c', 'Owner 76', '123456'),
	(78, 278.99274969571894, 'owner77@gmail.com', 'e70f4f24-50ae-46ab-baa5-9214ece96118', 'Owner 77', '123456'),
	(79, 260.36637928441695, 'owner78@gmail.com', 'a0700823-f075-4d69-815e-a2404aef9f45', 'Owner 78', '123456'),
	(80, 153.90811400866843, 'owner79@gmail.com', '2967a495-24cf-4bf5-a846-fedc9894fa64', 'Owner 79', '123456'),
	(81, 50.97665574207988, 'owner80@gmail.com', '572be07d-8233-48ad-b6e8-33713db40d1d', 'Owner 80', '123456'),
	(82, 111.40686245383868, 'owner81@gmail.com', 'e73f4e8a-3b88-4a46-8e21-da62f1b18385', 'Owner 81', '123456'),
	(83, 469.25344331755804, 'owner82@gmail.com', '12c325c2-c9d8-4151-95ee-255fade02eb7', 'Owner 82', '123456'),
	(84, 39.63363245184159, 'owner83@gmail.com', '38832299-0b78-4c69-bab7-373ef22ca730', 'Owner 83', '123456'),
	(85, 854.1117327176721, 'owner84@gmail.com', '28be324c-bb73-4d6e-86c2-8e5559c27a23', 'Owner 84', '123456'),
	(86, 67.45663493703324, 'owner85@gmail.com', '971b29c6-6ef7-4bfc-8806-7ebfcfad92de', 'Owner 85', '123456'),
	(87, 627.1020254805103, 'owner86@gmail.com', '49bb8df0-e8ba-4e39-a456-0133952d09e4', 'Owner 86', '123456'),
	(88, 880.857572019834, 'owner87@gmail.com', 'cc969639-8bee-469b-a90c-09a88d75e435', 'Owner 87', '123456'),
	(89, 794.6277066093589, 'owner88@gmail.com', '9cdd6726-2378-4583-93e5-e7ad4e2ddea2', 'Owner 88', '123456'),
	(90, 811.5343017388132, 'owner89@gmail.com', 'b5ad7535-34c7-41c0-9088-247126fb91f7', 'Owner 89', '123456'),
	(91, 301.25988061363887, 'owner90@gmail.com', 'adf4461d-285f-411f-9ff2-c66e3dad57a6', 'Owner 90', '123456'),
	(92, 988.8864368874314, 'owner91@gmail.com', '4a910167-4ec7-4c92-8808-05ad36a952f1', 'Owner 91', '123456'),
	(93, 385.23065642931607, 'owner92@gmail.com', 'e0d8e590-236f-4360-9aab-2f66b18477d4', 'Owner 92', '123456'),
	(94, 429.30367109552645, 'owner93@gmail.com', '523c8896-590e-4c99-bcc7-8515e8ff809f', 'Owner 93', '123456'),
	(95, 657.4492870652529, 'owner94@gmail.com', '2c63a304-7d73-41eb-82af-fdf4e31bb81c', 'Owner 94', '123456'),
	(96, 330.9572566905733, 'owner95@gmail.com', '76016966-de67-46d9-a6d8-169efedf8576', 'Owner 95', '123456'),
	(97, 574.7504655948602, 'owner96@gmail.com', '6c7a5900-7183-4576-b1ea-e7d3131ff518', 'Owner 96', '123456'),
	(98, 181.18476436073905, 'owner97@gmail.com', '9fca746a-a13a-4c68-a498-cb99cd9e62ed', 'Owner 97', '123456'),
	(99, 41.656619228672255, 'owner98@gmail.com', '3be3db26-b68d-4992-95d7-195d5ceeb8c0', 'Owner 98', '123456'),
	(100, 536.2620385503801, 'owner99@gmail.com', '5233c018-6c0e-4552-bb31-04db657696b6', 'Owner 99', '123456');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
