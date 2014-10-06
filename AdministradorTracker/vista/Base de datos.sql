
CREATE DATABASE /*!32312 IF NOT EXISTS*/`abm` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `abm`;

/*Table structure for table `clientes` */

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `fecha_nac` date NOT NULL,
  `peso` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;



INSERT INTO `clientes` (`id`, `nombre`, `apellido`, `fecha_nac`, `peso`) VALUES
(1, 'Lucas', 'Forchino', '2008-01-24', 95.5),
(2, 'Jorge', 'Solis', '1945-10-01', 55.2),
(3, 'Javier', 'Figueroa', '1981-09-02', 90),
(23, 'Jorge', 'Solisa', '2008-01-01', 55.2),
(24, 'Jorge', 'Solisan', '2007-12-01', 55.4);
