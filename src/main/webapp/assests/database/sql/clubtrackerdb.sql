-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 20, 2020 at 07:54 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clubtrackerdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `authuserrole`
--

CREATE TABLE `authuserrole` (
  `authUserId` int(11) NOT NULL,
  `authRoleId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `authuserrole`
--

INSERT INTO `authuserrole` (`authUserId`, `authRoleId`) VALUES
(1, 1),
(2, 3),
(3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `auth_role`
--

CREATE TABLE `auth_role` (
  `auth_role_id` int(11) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `role_desc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `auth_role`
--

INSERT INTO `auth_role` (`auth_role_id`, `role_name`, `role_desc`) VALUES
(1, 'ADMIN', 'admin'),
(2, 'COACH', 'coach role'),
(3, 'PLAYER', 'player role');

-- --------------------------------------------------------

--
-- Table structure for table `auth_user`
--

CREATE TABLE `auth_user` (
  `authUserId` int(11) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `surname` varchar(30) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `auth_user`
--

INSERT INTO `auth_user` (`authUserId`, `firstName`, `surname`, `email`, `password`, `status`) VALUES
(1, 'Eamonn', 'Cooke', 'eamonncooke@gmail.com', '$2a$10$DD/FQ0hTIprg3fGarZl1reK1f7tzgM4RuFKjAKyun0Si60w6g3v5i', 'VERIFIED'),
(2, 'Eamonn', 'Cooke', 'cooke.eamonn@gmail.com', '$2a$10$DD/FQ0hTIprg3fGarZl1reK1f7tzgM4RuFKjAKyun0Si60w6g3v5i', 'VERIFIED'),
(3, 'Ken', 'Carter', 'coach@gmail.com', '$2a$10$DD/FQ0hTIprg3fGarZl1reK1f7tzgM4RuFKjAKyun0Si60w6g3v5i', 'VERIFIED');

-- --------------------------------------------------------

--
-- Table structure for table `club`
--

CREATE TABLE `club` (
  `clubId` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `street` varchar(50) NOT NULL,
  `town` varchar(22) NOT NULL,
  `county` varchar(9) NOT NULL,
  `contactName` varchar(50) NOT NULL,
  `contactEmail` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `club`
--

INSERT INTO `club` (`clubId`, `name`, `street`, `town`, `county`, `contactName`, `contactEmail`) VALUES
(1, 'Bruff RFC', 'Killballyowne', 'Bruff', 'Limerick', 'Tom', 'tom@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `coach`
--

CREATE TABLE `coach` (
  `coachId` int(11) NOT NULL,
  `authUserId` int(11) NOT NULL,
  `role` varchar(20) NOT NULL,
  `clubId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `coach`
--

INSERT INTO `coach` (`coachId`, `authUserId`, `role`, `clubId`) VALUES
(1, 3, 'Head Coach', 1);

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE `player` (
  `playerId` int(11) NOT NULL,
  `authUserId` int(11) NOT NULL,
  `postion` varchar(8) NOT NULL,
  `dob` date NOT NULL,
  `height` int(11) NOT NULL,
  `weight` float NOT NULL,
  `clubId` int(11) NOT NULL,
  `authId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`playerId`, `authUserId`, `postion`, `dob`, `height`, `weight`, `clubId`, `authId`) VALUES
(1, 2, 'Forward', '1994-01-17', 180, 104.3, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `testing`
--

CREATE TABLE `testing` (
  `testId` int(11) NOT NULL,
  `playerID` int(11) NOT NULL,
  `time` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `training`
--

CREATE TABLE `training` (
  `trainingId` int(11) NOT NULL,
  `playerID` int(11) NOT NULL,
  `geoLocation` varchar(20) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `authuserrole`
--
ALTER TABLE `authuserrole`
  ADD KEY `authUserId` (`authUserId`),
  ADD KEY `authRoleId` (`authRoleId`);

--
-- Indexes for table `auth_role`
--
ALTER TABLE `auth_role`
  ADD PRIMARY KEY (`auth_role_id`);

--
-- Indexes for table `auth_user`
--
ALTER TABLE `auth_user`
  ADD PRIMARY KEY (`authUserId`);

--
-- Indexes for table `club`
--
ALTER TABLE `club`
  ADD PRIMARY KEY (`clubId`);

--
-- Indexes for table `coach`
--
ALTER TABLE `coach`
  ADD PRIMARY KEY (`coachId`),
  ADD KEY `authUserId` (`authUserId`),
  ADD KEY `clubId` (`clubId`);

--
-- Indexes for table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`playerId`),
  ADD KEY `authUserId` (`authUserId`),
  ADD KEY `clubId` (`clubId`);

--
-- Indexes for table `testing`
--
ALTER TABLE `testing`
  ADD PRIMARY KEY (`testId`),
  ADD KEY `playerID` (`playerID`);

--
-- Indexes for table `training`
--
ALTER TABLE `training`
  ADD PRIMARY KEY (`trainingId`),
  ADD KEY `playerID` (`playerID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `auth_role`
--
ALTER TABLE `auth_role`
  MODIFY `auth_role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `auth_user`
--
ALTER TABLE `auth_user`
  MODIFY `authUserId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `club`
--
ALTER TABLE `club`
  MODIFY `clubId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `coach`
--
ALTER TABLE `coach`
  MODIFY `coachId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `player`
--
ALTER TABLE `player`
  MODIFY `playerId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `testing`
--
ALTER TABLE `testing`
  MODIFY `testId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `training`
--
ALTER TABLE `training`
  MODIFY `trainingId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `authuserrole`
--
ALTER TABLE `authuserrole`
  ADD CONSTRAINT `authuserrole_ibfk_1` FOREIGN KEY (`authUserId`) REFERENCES `auth_user` (`authUserId`),
  ADD CONSTRAINT `authuserrole_ibfk_2` FOREIGN KEY (`authRoleId`) REFERENCES `auth_role` (`auth_role_id`);

--
-- Constraints for table `coach`
--
ALTER TABLE `coach`
  ADD CONSTRAINT `coach_ibfk_1` FOREIGN KEY (`authUserId`) REFERENCES `auth_user` (`authUserId`),
  ADD CONSTRAINT `coach_ibfk_2` FOREIGN KEY (`clubId`) REFERENCES `club` (`clubId`);

--
-- Constraints for table `player`
--
ALTER TABLE `player`
  ADD CONSTRAINT `player_ibfk_1` FOREIGN KEY (`authUserId`) REFERENCES `auth_user` (`authUserId`),
  ADD CONSTRAINT `player_ibfk_2` FOREIGN KEY (`clubId`) REFERENCES `club` (`clubId`);

--
-- Constraints for table `testing`
--
ALTER TABLE `testing`
  ADD CONSTRAINT `testing_ibfk_1` FOREIGN KEY (`playerID`) REFERENCES `trackerforclub`.`player` (`playerId`),
  ADD CONSTRAINT `testing_ibfk_2` FOREIGN KEY (`playerID`) REFERENCES `player` (`playerId`);

--
-- Constraints for table `training`
--
ALTER TABLE `training`
  ADD CONSTRAINT `training_ibfk_1` FOREIGN KEY (`playerID`) REFERENCES `trackerforclub`.`player` (`playerId`),
  ADD CONSTRAINT `training_ibfk_2` FOREIGN KEY (`playerID`) REFERENCES `player` (`playerId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
