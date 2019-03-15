-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 06, 2018 at 04:43 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hd`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `eid` int(255) NOT NULL,
  `ename` varchar(255) NOT NULL,
  `intime` varchar(255) NOT NULL,
  `outtime` varchar(255) NOT NULL,
  `year` varchar(255) NOT NULL,
  `month` varchar(255) NOT NULL,
  `day` varchar(255) NOT NULL,
  `workhours` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`eid`, `ename`, `intime`, `outtime`, `year`, `month`, `day`, `workhours`) VALUES
(113, 'Prasadi', '11:56', '11:56', '2018', '10', '06', '0'),
(122, 'satharasinghe', '00:10', '01:13', '2018', '10', '06', '1'),
(123, 'Pathum', '18:24', 'Not leave', '2018', '10', '06', '0'),
(125, 'mahas', '00:10', '01:29', '2018', '10', '06', '1');

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `bid` varchar(60) NOT NULL,
  `Icode` varchar(20) NOT NULL,
  `price` double NOT NULL,
  `qty` int(30) NOT NULL,
  `NetPrice` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`bid`, `Icode`, `price`, `qty`, `NetPrice`) VALUES
('', 'jh55', 546, 5, 2730),
('', 'jknm', 456, 4, 1824),
('', 'kl6663', 456, 56, 25536),
('', 'jknm', 456, 5, 2235),
('', 'kl6663', 456, 56, 25486),
('', 'ET45', 455, 5, 2222),
('', ',mnbl,', 5255, 47, 246940),
('', ',mnbl,', 5255, 47, 246940),
('', ',mnbl,', 5255, 47, 246940),
('', ',mnbl,', 5255, 47, 246940),
('', 'kn', 456, 5, 2235),
('kl4569', 'kl6663', 456, 5, 2230),
('aas56', 'kl6663', 456, 5, 2230),
('aas56', 'kl6663', 456, 5, 2230),
('aas56', 'n2425', 5512, 26, 143223),
('df2345', 'ET45', 13213, 4, 52763),
('aas56', 'fgr4325', 890, 5, 4325),
('sd2354', 'lko5688', 45899, 87, 3993199),
('sd2354', 'kjk6666', 965, 4, 3816),
('2018823132148', 'qwe3456', 6878, 58, 398879),
('2018823132733', '2345', 343, 4, 1340),
('2018823132758', '34567', 5698, 4, 22745),
('2018823132817', '78976', 50000, 4, 199000),
('2018829164123', '2100', 6500, 36, 233944),
('2018829164438', 'ET45', 30000, 4, 119635),
('2018829164538', '55698', 5698, 4, 22747),
('201893132944', 'kl6663', 456, 5, 1915);

-- --------------------------------------------------------

--
-- Table structure for table `disc`
--

CREATE TABLE `disc` (
  `bid` varchar(60) NOT NULL,
  `disc` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `disc`
--

INSERT INTO `disc` (`bid`, `disc`) VALUES
('ghj856987', 9662),
('kjh74569963', 40000),
('4652', 456),
('4652', 456),
('22563', 112),
('jk85236', 10000),
('fg5698', 30000),
('7469', 200),
('3985', 600),
('45862', 865),
('8547741', 877),
('45862', 865),
('45869', 3000),
('5550', 477),
('hh648', 215),
('88569', 900),
('4622', 2852),
('586655', 125),
('78566', 253),
('55698', 5666),
('55698', 5666),
('55698', 50),
('9600', 774),
('55698', 77),
('2100', 56),
('ET45', 365),
('55698', 45),
('kl6663', 365),
('55698', 365),
('778585', 6000),
('2018104215647', 45000),
('2018104215647', 45000),
('20181004215769', 451126),
('20181004215935', 986632),
('20181004215769', 451126),
('20181004215935', 986632);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `nic` varchar(10) NOT NULL,
  `occupation` varchar(20) NOT NULL,
  `salary` int(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `contact` int(10) NOT NULL,
  `email` varchar(40) NOT NULL,
  `address` varchar(50) NOT NULL,
  `nationality` varchar(10) NOT NULL,
  `bdate` varchar(20) NOT NULL,
  `jdate` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `nic`, `occupation`, `salary`, `gender`, `contact`, `email`, `address`, `nationality`, `bdate`, `jdate`) VALUES
(113, 'Prasadi', '888888888V', 'cashier', 20000, 'female', 771965110, 'prasa123@gmail.com', 'Rathnapura', 'Sinhala', '1995/05/07', '2016/02/20'),
(114, 'Ishara', '555555555V', 'servant', 10000, 'male', 771122334, 'isharaer@gmail.com', 'negombo', 'Sinhala', '1989/09/06', '1998/03/10'),
(115, 'Kasun', '777777777V', 'employee', 14000, 'male', 771122334, 'kasunyy1@gmail.com', 'meegoda', 'Sinhala', '1985/09/06', '2015/06/10'),
(117, 'Rasanjana', '444444555V', 'employee', 100000, 'male', 771122334, 'rasanjana123@gmail.com', 'pannipitiya', 'Sinhala', '1978/09/06', '2014/06/10'),
(120, 'Lasny', '977867445V', 'manager', 20000, 'female', 771553452, 'lasny123@gmail.com', 'kadawatha', 'sinahala', '1997/02/06', '2017/01/20'),
(121, 'hasitha', '992634812V', 'teaboy', 1000, 'male', 771122333, 'hasitha123@gmail.com', 'naaththankudiya', 'tamil', '1999/01/02', '2016/03/18'),
(122, 'satharasinghe', '977867445V', 'employee', 10000, 'male', 779988435, 'sathara345@gmail.com', 'nugegoda', 'tamil', '1999/09/04', '2017/10/20'),
(123, 'Pathum', '854565758V', 'servant', 3000, 'female', 112567468, 'pathummahesha@gmail.com', 'polonnaruwa', 'tamil', '1985/01/02', '2014/02/20'),
(124, 'dulaj', '992655612V', 'employee', 10000, 'male', 112963456, 'duuu123@gmail.com', 'walgama', 'tamil', '1983/02/06', '2012/03/18'),
(125, 'mahas', '854577758V', 'servant', 20000, 'male', 771544452, 'mahas@gmail.com', 'homagama', 'sinahala', '1983/02/06', '2011/03/18'),
(126, 'perera', '458978906V', 'manager', 20000, 'male', 771553452, 'pererak@gmail.com', 'matara', 'sinahala', '1945/01/02', '1999/03/18'),
(127, 'Danushi', '977864445V', 'employee', 10000, 'female', 772669072, 'danulll@gmail.com', 'kiribathgoda', 'sinahala', '1997/11/06', '2017/09/20'),
(128, 'sujatha', '842634812V', 'employee', 15000, 'female', 112963499, 'sujatha1@gmail.com', 'uuruwathota', 'sinahala', '1984/09/04', '2010/03/18'),
(129, 'nihal', '780634812V', 'manager', 20000, 'male', 779988433, 'nihalwi@gmail.com', 'gampaha', 'sinahala', '1978/02/04', '1994/04/20'),
(130, 'Buddika', '854565000V', 'servant', 11000, 'female', 771155555, 'boody123@gmail.com', 'jaffna', 'tamil', '1985/02/28', '2011/02/08'),
(131, 'Isuru', '992634812V', 'servant', 3000, 'male', 771553452, 'isuru356@gmail.com', 'malabe', 'sinahala', '1999/09/04', '2012/03/13'),
(132, 'madusha', '557867445V', 'employee', 15000, 'male', 772119055, 'madusha99@gmail.com', 'athurugiriya', 'sinahala', '1999/01/02', '2014/02/20'),
(133, 'rathnasiri', '854565999V', 'servant', 3000, 'male', 112963456, 'rathnasiri@gmail.com', 'kotte', 'sinahala', '1983/02/06', '2017/01/20'),
(134, 'gayathri', '992634812V', 'servant', 11000, 'female', 772119656, 'gaya4545@gmail.com', 'pore', 'sinahala', '1985/01/02', '2017/10/23'),
(135, 'nawodh', '854566658V', 'employee', 15000, 'male', 774488435, 'nawodhdana@gmail.com', 'nawagamuwa', 'sinahala', '1985/02/06', '2011/10/20');

-- --------------------------------------------------------

--
-- Table structure for table `incometab`
--

CREATE TABLE `incometab` (
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ItemNo` varchar(45) NOT NULL,
  `itemName` varchar(80) NOT NULL,
  `qty` int(11) NOT NULL,
  `profit` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `incometab`
--

INSERT INTO `incometab` (`Date`, `ItemNo`, `itemName`, `qty`, `profit`) VALUES
('2018-09-20 04:26:24', '1', 'anduva', 4, 3000),
('2018-09-20 04:27:58', '2', 'sissor', 5, 5000),
('2018-09-20 04:28:28', '3', 'bolnut', 2, 500),
('2018-09-20 04:29:45', '4', 'ana', 3, 200),
('2018-09-20 07:05:04', '5', 'bag', 1, 300),
('2018-09-20 07:23:27', '6', 'vilbaro', 1, 600),
('2018-09-20 08:37:46', '7', 'bata', 3, 3500),
('2018-09-20 17:05:14', '8', 'gum', 2, 500),
('2018-09-20 17:08:12', '9', 'polythene', 2, 300),
('2018-09-20 18:30:29', '10', 'dgg', 2, 500),
('2018-09-21 11:24:44', '11', 'cdfgf', 2, 3000),
('2018-09-22 01:27:58', '12', 'dgrtg', 1, 500),
('2018-09-22 01:28:39', '13', 'jhjuy', 2, 300),
('2018-09-22 01:41:25', '14', 'bvbv', 1, 400),
('2018-09-22 12:19:11', '15', 'fr', 2, 3000),
('2018-09-22 12:20:32', '16', 'hgg', 5, 4500),
('2018-09-22 12:21:44', '17', 'bv', 2, 3000),
('2018-09-30 14:41:48', '1', 'Forceps', 4, 3000),
('2018-09-30 14:42:04', '4', 'Nails', 3, 200),
('2018-09-30 14:42:46', '6', 'WheelBarrow', 1, 600),
('2018-09-30 14:43:14', '7', 'PVC_Pipes', 3, 3500);

-- --------------------------------------------------------

--
-- Table structure for table `monthly_cost`
--

CREATE TABLE `monthly_cost` (
  `Id` int(11) NOT NULL,
  `noteDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `cost_type` varchar(80) NOT NULL,
  `amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `monthly_cost`
--

INSERT INTO `monthly_cost` (`Id`, `noteDate`, `cost_type`, `amount`) VALUES
(2, '2018-09-19 08:46:03', 'Current', 3500),
(3, '2018-09-19 08:46:16', 'Water', 2000),
(5, '2018-09-19 08:52:40', 'maintain', 5000),
(10, '2018-09-30 15:37:24', 'phone', 3000);

-- --------------------------------------------------------

--
-- Table structure for table `oder`
--

CREATE TABLE `oder` (
  `oderNo` varchar(45) COLLATE utf8_general_mysql500_ci NOT NULL,
  `customerName` varchar(45) COLLATE utf8_general_mysql500_ci NOT NULL,
  `address` varchar(45) COLLATE utf8_general_mysql500_ci NOT NULL,
  `telephoneNo` int(45) NOT NULL,
  `items` varchar(300) COLLATE utf8_general_mysql500_ci NOT NULL,
  `amount` int(45) NOT NULL,
  `deliveryCharges` int(45) NOT NULL,
  `finalAmount` int(45) NOT NULL,
  `deliveryStatus` varchar(45) COLLATE utf8_general_mysql500_ci NOT NULL,
  `quantity` int(20) NOT NULL,
  `billno` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Dumping data for table `oder`
--

INSERT INTO `oder` (`oderNo`, `customerName`, `address`, `telephoneNo`, `items`, `amount`, `deliveryCharges`, `finalAmount`, `deliveryStatus`, `quantity`, `billno`) VALUES
('111', 'Anjaani', 'galle', 774556444, 'sand', 2000, 400, 10400, 'Confirm', 5, 0),
('113', 'Senali', 'kiribathgoda', 771122334, 'cement', 1000, 100, 10100, 'Pending', 10, 0),
('114', 'Mayadunna', 'Athurugiriya', 771965110, 'paint', 950, 200, 12550, 'Pending', 13, 0),
('115', 'Dinithi', 'colombo', 778898965, 'glass', 450, 250, 1600, 'Pending', 3, 0),
('116', 'Himasha', 'korathota', 234567890, 'cement', 950, 200, 9700, 'Pending', 10, 0),
('117', 'Sachini', 'maharagama', 998877665, 'floorpaints', 2000, 800, 10800, 'Pending', 5, 0),
('118', 'Chandrasena', 'colombo', 772119995, 'bricks', 40, 1000, 101000, 'Pending', 2500, 0),
('119', 'Roshani', 'kaduwela', 787878787, 'tiles', 750, 300, 2250300, 'Pending', 3000, 0),
('120', 'Rajitha', 'gampaha', 771122334, 'paints', 950, 600, 25300, 'Pending', 26, 0),
('121', 'Gamage', 'kiribathgoda', 777777345, 'sand', 2000, 600, 10600, 'Pending', 5, 0);

-- --------------------------------------------------------

--
-- Table structure for table `removeemployee`
--

CREATE TABLE `removeemployee` (
  `id` varchar(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `occupation` varchar(20) NOT NULL,
  `salary` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contact` varchar(30) NOT NULL,
  `rdate` varchar(20) NOT NULL,
  `rreason` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `removeemployee`
--

INSERT INTO `removeemployee` (`id`, `name`, `occupation`, `salary`, `email`, `contact`, `rdate`, `rreason`) VALUES
('112', 'Dilrukshi', 'cashier', '30000', 'dil12@gmail.com', '234567890', '2018/08/01', 'nothing'),
('666', 'aaaa', 'hhhh', '22222222', 'yyy@kk.com', '222222222', '2018/08/01', 'not'),
('8', 'Geethika', 'manager', '4000000', 'roshanig@hotmail.com', '774556444', '99999999', 'not');

-- --------------------------------------------------------

--
-- Table structure for table `removesupplier`
--

CREATE TABLE `removesupplier` (
  `id` int(20) NOT NULL,
  `rReasone` varchar(50) NOT NULL,
  `rdate` varchar(20) NOT NULL,
  `name` varchar(40) NOT NULL,
  `address` varchar(100) NOT NULL,
  `contact` int(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `items` varchar(100) NOT NULL,
  `joindate` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `removesupplier`
--

INSERT INTO `removesupplier` (`id`, `rReasone`, `rdate`, `name`, `address`, `contact`, `email`, `items`, `joindate`) VALUES
(4444, 'not', '2018/08/0', 'Kavanthi', 'Gampaha', 771965110, 'ksm@gmail.com', 'cement', '2018/08/2');

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE `report` (
  `uname` varchar(255) NOT NULL,
  `ltime` varchar(50) NOT NULL,
  `otime` varchar(50) NOT NULL,
  `year` varchar(50) NOT NULL,
  `month` varchar(50) NOT NULL,
  `day` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `report`
--

INSERT INTO `report` (`uname`, `ltime`, `otime`, `year`, `month`, `day`) VALUES
('inusha', '00:20', '00:22', '2018', '10', '06'),
('inusha', '19:58', 'still loged in', '2018', '10', '06'),
('inusha', '20:11', '20:12', '2018', '10', '06'),
('kamal', '00:23', 'still loged in', '2018', '10', '06');

-- --------------------------------------------------------

--
-- Table structure for table `returnitem`
--

CREATE TABLE `returnitem` (
  `name` varchar(100) NOT NULL,
  `Id` int(11) NOT NULL,
  `supplierID` varchar(50) NOT NULL,
  `cuName` varchar(50) NOT NULL,
  `telNo` int(11) NOT NULL,
  `sellprice` double NOT NULL,
  `amount` int(11) NOT NULL,
  `date` varchar(20) NOT NULL,
  `today` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `returnitem`
--

INSERT INTO `returnitem` (`name`, `Id`, `supplierID`, `cuName`, `telNo`, `sellprice`, `amount`, `date`, `today`, `type`) VALUES
('Sandwich_Maker', 27, 'Earth_Star_271', 'Piumal_wikrama', 322000000, 10000, 1, '2018-09-20', '2018-10-01', '2018-10-01'),
('Sandwich_Maker', 27, 'Earth_Star_271', 'Piumal_wikrama', 322000000, 10000, 1, '2018-09-20', '2018-10-01', '2018-10-01'),
('Sandwich_Maker', 27, 'Earth_Star_271', 'Piumal_wikrama', 322000000, 10000, 1, '2018-09-20', '2018-10-01', '2018-10-01'),
('Rice_Cooker', 25, 'Sinbo25', 'Ruwani_Kumari', 782344001, 60000, 1, '2018-09-18', '2019-02-14', 'Reparing-item'),
('Rice_Cooker', 25, 'Sinbo25', 'Ruwani_Kumari', 782344001, 60000, 1, '2018-09-18', '2018-10-03', 'NonReparing-item'),
('Rice_Cooker', 25, 'Sinbo25', 'Dinuka_Kumara', 712344001, 60000, 1, '2018-09-18', '2018-10-02', 'Return-item'),
('Electric_Tea_Maker', 26, 'Sinbo25', 'Dinuka_Kumara', 712344001, 30000, 1, '2018-09-18', '2018-10-02', 'Return-item'),
('Electric_Tea_Maker', 26, 'Sinbo25', 'Sadali_Kumari', 772344891, 30000, 1, '2018-09-18', '2018-10-24', 'Return-item'),
('Electric_Tea_Maker', 26, 'Sinbo25', 'Dinuka_Saliya', 772344891, 30000, 1, '2018-09-18', '2018-10-24', 'NonReparing-item'),
('Electric_Tea_Maker', 26, 'Sinbo25', 'Dulika_Hevavitharana', 772354801, 30000, 1, '2018-09-18', '2018-10-11', 'Reparing-item'),
('Orange_LED', 28, 'Orange28', 'Hemamali_Perera', 777354801, 450, 4, '2018-09-18', '2018-10-11', 'Return-item'),
('Orange_LED', 29, 'Orange28', 'Ruwani_Kumari', 1234567890, 150, 2, '2018-09-04', '2018-09-05', 'Return-item'),
('Electric_Kettle', 29, 'Sinbo25', 'Hiruni_athanayaka', 772345121, 1500, 1, '2018-08-23', '2018-09-05', 'Reparing-item'),
('Electric_Kettle', 29, 'Sinbo25', 'Kumari_welgama', 772340000, 1500, 1, '2018-08-30', '2018-10-05', 'NonReparing-item'),
('Hand_Mixer', 30, 'Sinbo25', 'Piumal_wikrama', 712340800, 1500, 1, '2018-08-14', '2018-10-31', 'NonReparing-item');

-- --------------------------------------------------------

--
-- Table structure for table `stockdamageitem`
--

CREATE TABLE `stockdamageitem` (
  `Id` int(1) NOT NULL,
  `name` varchar(50) NOT NULL,
  `supplierID` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  `purchaseprice` double NOT NULL,
  `amount` int(11) NOT NULL,
  `type` varchar(50) NOT NULL,
  `cost` double NOT NULL,
  `today` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stockdamageitem`
--

INSERT INTO `stockdamageitem` (`Id`, `name`, `supplierID`, `description`, `purchaseprice`, `amount`, `type`, `cost`, `today`) VALUES
(1, 'Bataploa_Antina', 'Rthnapura12', 'Sri_Lanka_1', 1500, 4, 'Damage-item', 6000, '2018-10-03 15:06:30'),
(2, 'Bataploa_Antina', 'Rthnapura12', 'Indian_1', 1750, 2, 'Damage-item', 3500, '2018-10-03 15:07:21'),
(4, 'Floor_polish', 'DelcoPaint4', 'Multilac_paint7', 850, 15, 'Damage-item', 12750, '2018-10-03 15:11:21'),
(5, 'ABC_Box', 'RathnapuraPolicome5', 'size_700', 750, 30, 'Damage-item', 22500, '2018-10-03 15:14:44'),
(6, 'MCB_Box', 'RathnapuraPolicome5', 'size_900', 715, 20, 'Damage-item', 14300, '2018-10-03 15:16:18'),
(7, 'Gang_one', 'MiriswaththaH7', '6_Gang_one', 550, 12, 'Damage-item', 6600, '2018-10-03 15:19:55'),
(8, 'Gang_Two', 'MiriswaththaH7', '1_Gang_Two', 650, 2, 'Damage-item', 1300, '2018-10-03 15:20:50'),
(9, 'Fan_Control', 'MiriswaththaH7', 'Keviltan_2A', 800, 5, 'Damage-item', 4000, '2018-10-03 15:23:04'),
(10, 'Switch_Keviltan', 'MiriswaththaH7', 'Keviltan_12A', 500, 15, 'Damage-item', 7500, '2018-10-03 15:25:00'),
(11, 'Keviltan_Double', 'MiriswaththaH7', 'Keviltan_20A', 500, 9, 'Damage-item', 4500, '2018-10-03 15:26:26');

-- --------------------------------------------------------

--
-- Table structure for table `stockitem`
--

CREATE TABLE `stockitem` (
  `Id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `supplierID` varchar(100) NOT NULL,
  `description` varchar(50) NOT NULL,
  `purchaseprice` double NOT NULL,
  `sellprice` double NOT NULL,
  `amount` int(11) NOT NULL,
  `type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stockitem`
--

INSERT INTO `stockitem` (`Id`, `name`, `supplierID`, `description`, `purchaseprice`, `sellprice`, `amount`, `type`) VALUES
(37, 'Iron_Sheet', 'Vaitilingam1', '6_Feet', 51, 55, 3, 'Stock-item'),
(38, 'GI_pipe', 'Dayani2', '2_Inch', 1000, 1200, 100, 'Stock-item'),
(39, 'Cement', 'Sanasuma3', 'Santha_50Kg', 875, 950, 100, 'Stock-item'),
(40, 'Cement', 'Owesta4', 'LNT_50Kg', 870, 900, 100, 'Stock-item'),
(41, 'Thinner', 'SolaCemical5', 'Original', 180, 250, 50, 'Stock-item'),
(42, 'Thinner', 'SolaCemical5', 'Local', 150, 200, 50, 'Stock-item'),
(44, 'TV_Jack', 'Sinwa7', 'AL_1', 20, 40, 150, 'Stock-item'),
(45, 'Glouse_Rabare', 'Samantha8', 'Water_Seel', 100, 195, 300, 'Stock-item'),
(46, 'Glouse_Color', 'Samantha8', 'Water_Seel__Bloue_White', 100, 195, 300, 'Stock-item'),
(47, 'Tap_Conector', 'ASD8', 'Plastic', 10, 30, 1000, 'Stock-item'),
(48, 'Orange_LED', 'Orange28', 'W_200', 250, 300, 9, 'Stock-item'),
(49, 'Orange_LED', 'Orange28', 'W_100', 150, 200, 5, 'Stock-item'),
(50, 'Multilack_white', 'Macson56', 'Emulsion_White_2L', 2200, 3000, 3, 'Stock-item'),
(51, 'Multilack_Pink', 'Macson56', 'Emulsion_Pink_2L', 2600, 3600, 4, 'Stock-item');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id` int(5) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `joindate` varchar(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `contact` int(10) NOT NULL,
  `item` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id`, `email`, `address`, `joindate`, `name`, `contact`, `item`) VALUES
(999, 'kamayadunn1@gmail.com', 'colombo', '2018/08/01', 'anurada', 774556444, 'paints');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `uname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `uname`, `password`, `email`, `type`) VALUES
('U001', 'inusha', 'inusha123', 'inusha@gmail.com', 'Admin'),
('U002', 'Kamal', '123', 'kamal@gmail.com', 'User'),
('U0032', 'saman1234', '123', 'bnbn@g.ck', 'Admin'),
('U0038', 'saman', '123', 'bnbn@g.ck', 'User'),
('U006', 'gayan', '123', 'gayan@gmail.com', 'User'),
('U008', 'sewwandi', '12345', 'sewwandi@gmai.com', 'User'),
('U009', 'kshan', '1223', 'kshan@gmail.com', 'User'),
('U010', 'b', 'b', 'bnbn@g.ck', 'User'),
('U012', 'pasanS', '123', 'pasans@gmail.com', 'User'),
('U123', 'a', 'a', 'a123@tyt.juyu', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`eid`,`ename`,`year`,`month`,`day`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `incometab`
--
ALTER TABLE `incometab`
  ADD PRIMARY KEY (`Date`);

--
-- Indexes for table `monthly_cost`
--
ALTER TABLE `monthly_cost`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `oder`
--
ALTER TABLE `oder`
  ADD PRIMARY KEY (`oderNo`);

--
-- Indexes for table `removeemployee`
--
ALTER TABLE `removeemployee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `removesupplier`
--
ALTER TABLE `removesupplier`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`uname`,`ltime`,`year`,`month`,`day`);

--
-- Indexes for table `stockdamageitem`
--
ALTER TABLE `stockdamageitem`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `stockitem`
--
ALTER TABLE `stockitem`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `monthly_cost`
--
ALTER TABLE `monthly_cost`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `stockitem`
--
ALTER TABLE `stockitem`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
