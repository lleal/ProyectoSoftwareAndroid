-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 26, 2014 at 01:46 PM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `demo`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(600) NOT NULL,
  `password` varchar(600) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `status`) VALUES
(1, 'superuser', 'WXpOV2QxcFlTbmRaV0U1NlpESTVlVnBCUFQwPQ== ', 1),
(2, 'metauser', 'WWxkV01GbFlRbWhqTTA0ellqTkthdz09 ', 1),
(3, 'googler', 'V2pJNWRsb3llR3hqUjBaNll6TmtkbU50VVQwPQ==', 1),
(4, 'asif18', 'WTBkR2VtTXpaSFpqYlZFOQ== ', 1);
