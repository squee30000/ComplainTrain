-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 10, 2019 at 09:00 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `complaintraincore`
--
CREATE DATABASE IF NOT EXISTS `complaintraincore` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `complaintraincore`;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `categID` int(11) NOT NULL,
  `catgName` tinytext NOT NULL,
  `catgAlias` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`categID`, `catgName`, `catgAlias`) VALUES
(1, 'Personal Complaints', 'PERS');

-- --------------------------------------------------------

--
-- Table structure for table `complaint`
--

CREATE TABLE `complaint` (
  `complaintID` int(11) NOT NULL,
  `complaintBody` text NOT NULL,
  `complaintResolution` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `complaint`
--

INSERT INTO `complaint` (`complaintID`, `complaintBody`, `complaintResolution`) VALUES
(1, 'I just think Kevin is not living up to the standards of this fictitious company', 0);

-- --------------------------------------------------------

--
-- Table structure for table `complaintcategory`
--

CREATE TABLE `complaintcategory` (
  `complaintID` int(11) NOT NULL,
  `categoryID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `complaintcategory`
--

INSERT INTO `complaintcategory` (`complaintID`, `categoryID`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `complaintemployee`
--

CREATE TABLE `complaintemployee` (
  `complaintID` int(11) NOT NULL,
  `employeeID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `complaintemployee`
--

INSERT INTO `complaintemployee` (`complaintID`, `employeeID`) VALUES
(1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `DeptID` int(11) NOT NULL,
  `DeptName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`DeptID`, `DeptName`) VALUES
(1, 'Managment'),
(2, 'Human Resources'),
(3, 'Logistics');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `EmployeeID` int(11) NOT NULL,
  `FName` varchar(20) NOT NULL,
  `LName` varchar(30) NOT NULL,
  `Address` tinytext NOT NULL,
  `Department` int(11) NOT NULL,
  `Rank` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EmployeeID`, `FName`, `LName`, `Address`, `Department`, `Rank`) VALUES
(1, 'Admin', 'Administrator', 'Doesnt matter', 1, 2),
(3, 'Eli', 'Smithson', 'Not important', 1, 2),
(4, 'Ben', 'Van Oss', 'Dont know', 2, 3),
(5, 'Kevin', 'Walbrunk', 'Earth', 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `rank`
--

CREATE TABLE `rank` (
  `rankID` int(11) NOT NULL,
  `rankName` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rank`
--

INSERT INTO `rank` (`rankID`, `rankName`) VALUES
(1, 'Employee'),
(2, 'Admin'),
(3, 'HR');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`categID`);

--
-- Indexes for table `complaint`
--
ALTER TABLE `complaint`
  ADD PRIMARY KEY (`complaintID`);

--
-- Indexes for table `complaintcategory`
--
ALTER TABLE `complaintcategory`
  ADD KEY `complaintID` (`complaintID`,`categoryID`),
  ADD KEY `categoryID` (`categoryID`);

--
-- Indexes for table `complaintemployee`
--
ALTER TABLE `complaintemployee`
  ADD KEY `complaintID` (`complaintID`,`employeeID`),
  ADD KEY `employeeID` (`employeeID`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`DeptID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`EmployeeID`),
  ADD KEY `Rank` (`Rank`),
  ADD KEY `Department` (`Department`) USING BTREE;

--
-- Indexes for table `rank`
--
ALTER TABLE `rank`
  ADD PRIMARY KEY (`rankID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `categID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `complaint`
--
ALTER TABLE `complaint`
  MODIFY `complaintID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `DeptID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `EmployeeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `rank`
--
ALTER TABLE `rank`
  MODIFY `rankID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `complaintcategory`
--
ALTER TABLE `complaintcategory`
  ADD CONSTRAINT `complaintcategory_ibfk_1` FOREIGN KEY (`categoryID`) REFERENCES `category` (`categID`),
  ADD CONSTRAINT `complaintcategory_ibfk_2` FOREIGN KEY (`complaintID`) REFERENCES `complaint` (`complaintID`);

--
-- Constraints for table `complaintemployee`
--
ALTER TABLE `complaintemployee`
  ADD CONSTRAINT `complaintemployee_ibfk_1` FOREIGN KEY (`complaintID`) REFERENCES `complaint` (`complaintID`),
  ADD CONSTRAINT `complaintemployee_ibfk_2` FOREIGN KEY (`employeeID`) REFERENCES `employee` (`EmployeeID`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`Rank`) REFERENCES `rank` (`rankID`),
  ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`Department`) REFERENCES `department` (`DeptID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
