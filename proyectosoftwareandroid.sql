-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-09-2014 a las 06:20:53
-- Versión del servidor: 5.6.20
-- Versión de PHP: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `proyectosoftwareandroid`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dispositivos`
--

CREATE TABLE IF NOT EXISTS `dispositivos` (
  `imei` varchar(100) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `llamada`
--

CREATE TABLE IF NOT EXISTS `llamada` (
  `id_dispositivo` text NOT NULL,
`num_llamada` mediumint(9) NOT NULL,
  `telefono` text NOT NULL,
  `fecha` text NOT NULL,
  `estado` text NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `llamada`
--

INSERT INTO `llamada` (`id_dispositivo`, `num_llamada`, `telefono`, `fecha`, `estado`) VALUES
('355143040456708', 2, '04249740372', 'Sat Sep 13 12:53:06 GMT-04:30 2014', 'Entrante'),
('355143040456708', 3, '04249740372', 'Sat Sep 13 13:33:57 GMT-04:30 2014', 'Entrante'),
('355143040456708', 4, '04249740372', 'Sat Sep 13 15:34:34 GMT-04:30 2014', 'Entrante'),
('355143040456708', 5, '*88', 'Sat Sep 13 15:36:47 GMT-04:30 2014', 'Saliente'),
('355143040456708', 6, '*88', 'Sat Sep 13 15:40:17 GMT-04:30 2014', 'Saliente'),
('355143040456708', 7, '*88', 'Sat Sep 13 15:43:25 GMT-04:30 2014', 'Saliente'),
('000000000000000', 8, '+15552175049', 'Sun Sep 14 14:19:35 GMT+00:00 2014', 'Saliente'),
('000000000000000', 9, '+15552175049', 'Sun Sep 14 14:20:49 GMT+00:00 2014', 'Saliente'),
('000000000000000', 10, '+15552175049', 'Sat Sep 20 19:31:29 GMT+00:00 2014', 'Saliente'),
('000000000000000', 11, '+15552175049', 'Sat Sep 20 19:32:58 GMT+00:00 2014', 'Saliente'),
('000000000000000', 12, '+15552175049', 'Sun Sep 21 04:18:27 GMT+00:00 2014', 'Saliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

CREATE TABLE IF NOT EXISTS `mensaje` (
  `id_dispositivo` text NOT NULL,
`num_mensaje` mediumint(9) NOT NULL,
  `telefono` text NOT NULL,
  `fecha` text NOT NULL,
  `cuerpo` text NOT NULL,
  `estatus` text NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `mensaje`
--

INSERT INTO `mensaje` (`id_dispositivo`, `num_mensaje`, `telefono`, `fecha`, `cuerpo`, `estatus`) VALUES
('355143040456708', 2, '+584249740372', '13-09-2014', 'Prueba', 'Entrante'),
('355143040456708', 3, '+0811', '13-09-2014', 'Su saldo es Bs.F. 0,80, su bono es de Bs.F. 0,00 y sus cupos: llamadas al 811 20 llam', 'Entrante'),
('355143040456708', 4, '+0811', '13-09-2014', 'Su saldo es Bs.F. 0,80, su bono es de Bs.F. 0,00 y sus cupos: llamadas al 811 20 llam', 'Entrante'),
('355143040456708', 5, '+0811', '13-09-2014', 'Su saldo es Bs.F. 0,80, su bono es de Bs.F. 0,00 y sus cupos: llamadas al 811 20 llam', 'Entrante');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `procesos`
--

CREATE TABLE IF NOT EXISTS `procesos` (
`id_procesos` mediumint(9) NOT NULL,
  `id_dispositivo` text NOT NULL,
  `lista_procesos` text NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Volcado de datos para la tabla `procesos`
--

INSERT INTO `procesos` (`id_procesos`, `id_dispositivo`, `lista_procesos`) VALUES
(1, '000000000000000', 'my.app.proyectosoftwareandroid\ncom.svox.pico\ncom.android.defcontainer\njp.co.omronsoft.openwnn\nsystem\ncom.android.quicksearchbox\ncom.android.email\ncom.android.music\ncom.android.protips\ncom.android.phone\ncom.android.mms\nandroid.process.media\ncom.android.alarmclock\ncom.android.launcher\nandroid.process.acore\n'),
(2, '000000000000000', 'my.app.proyectosoftwareandroid\ncom.svox.pico\ncom.android.defcontainer\njp.co.omronsoft.openwnn\nsystem\ncom.android.quicksearchbox\ncom.android.email\ncom.android.music\ncom.android.protips\ncom.android.phone\ncom.android.mms\nandroid.process.media\ncom.android.alarmclock\ncom.android.launcher\nandroid.process.acore\n'),
(3, '000000000000000', 'my.app.proyectosoftwareandroid\ncom.svox.pico\ncom.android.defcontainer\njp.co.omronsoft.openwnn\nsystem\ncom.android.quicksearchbox\ncom.android.email\ncom.android.music\ncom.android.protips\ncom.android.phone\ncom.android.mms\nandroid.process.media\ncom.android.alarmclock\ncom.android.launcher\nandroid.process.acore\n'),
(4, '000000000000000', 'my.app.proyectosoftwareandroid\ncom.svox.pico\ncom.android.defcontainer\njp.co.omronsoft.openwnn\nsystem\ncom.android.quicksearchbox\ncom.android.email\ncom.android.music\ncom.android.protips\ncom.android.phone\ncom.android.mms\nandroid.process.media\ncom.android.alarmclock\ncom.android.launcher\nandroid.process.acore\n'),
(5, '000000000000000', 'my.app.proyectosoftwareandroid\ncom.svox.pico\ncom.android.defcontainer\njp.co.omronsoft.openwnn\nsystem\ncom.android.quicksearchbox\ncom.android.email\ncom.android.music\ncom.android.protips\ncom.android.phone\ncom.android.mms\nandroid.process.media\ncom.android.alarmclock\ncom.android.launcher\nandroid.process.acore\n'),
(6, '000000000000000', 'my.app.proyectosoftwareandroid\ncom.svox.pico\ncom.android.defcontainer\njp.co.omronsoft.openwnn\nsystem\ncom.android.quicksearchbox\ncom.android.email\ncom.android.music\ncom.android.protips\ncom.android.phone\ncom.android.mms\nandroid.process.media\ncom.android.alarmclock\ncom.android.launcher\nandroid.process.acore\n'),
(7, '000000000000000', 'my.app.proyectosoftwareandroid\nandroid.process.acore\ncom.android.settings\njp.co.omronsoft.openwnn\nsystem\ncom.android.launcher\ncom.svox.pico\ncom.android.defcontainer\ncom.android.quicksearchbox\ncom.android.email\ncom.android.music\ncom.android.protips\ncom.android.phone\ncom.android.mms\nandroid.process.media\ncom.android.alarmclock\n'),
(8, '000000000000000', 'my.app.proyectosoftwareandroid\nandroid.process.acore\ncom.android.settings\njp.co.omronsoft.openwnn\nsystem\ncom.android.launcher\ncom.svox.pico\ncom.android.defcontainer\ncom.android.quicksearchbox\ncom.android.email\ncom.android.music\ncom.android.protips\ncom.android.phone\ncom.android.mms\nandroid.process.media\ncom.android.alarmclock\n'),
(9, '000000000000000', 'my.app.proyectosoftwareandroid\njp.co.omronsoft.openwnn\nsystem\ncom.android.phone\nandroid.process.acore\ncom.android.settings\ncom.android.launcher\ncom.svox.pico\ncom.android.defcontainer\ncom.android.quicksearchbox\ncom.android.email\ncom.android.music\ncom.android.protips\ncom.android.mms\nandroid.process.media\ncom.android.alarmclock\n'),
(10, '000000000000000', 'my.app.proyectosoftwareandroid\njp.co.omronsoft.openwnn\nsystem\ncom.android.phone\nandroid.process.acore\ncom.android.settings\ncom.android.launcher\ncom.svox.pico\ncom.android.defcontainer\ncom.android.quicksearchbox\ncom.android.email\ncom.android.music\ncom.android.protips\ncom.android.mms\nandroid.process.media\ncom.android.alarmclock\n'),
(11, '000000000000000', 'my.app.proyectosoftwareandroid\njp.co.omronsoft.openwnn\nsystem\nandroid.process.acore\ncom.android.phone\ncom.android.settings\ncom.android.launcher\ncom.svox.pico\ncom.android.defcontainer\ncom.android.quicksearchbox\ncom.android.email\ncom.android.music\ncom.android.protips\ncom.android.mms\nandroid.process.media\ncom.android.alarmclock\n'),
(12, '000000000000000', 'my.app.proyectosoftwareandroid\njp.co.omronsoft.openwnn\nsystem\nandroid.process.acore\ncom.android.phone\ncom.android.settings\ncom.android.launcher\ncom.svox.pico\ncom.android.defcontainer\ncom.android.quicksearchbox\ncom.android.email\ncom.android.music\ncom.android.protips\ncom.android.mms\nandroid.process.media\ncom.android.alarmclock\n'),
(13, '000000000000000', 'my.app.proyectosoftwareandroid\njp.co.omronsoft.openwnn\nsystem\nandroid.process.acore\ncom.android.phone\ncom.android.settings\ncom.android.launcher\ncom.svox.pico\ncom.android.defcontainer\ncom.android.quicksearchbox\ncom.android.email\ncom.android.music\ncom.android.protips\ncom.android.mms\nandroid.process.media\ncom.android.alarmclock\n'),
(14, '000000000000000', 'my.app.proyectosoftwareandroid\njp.co.omronsoft.openwnn\nsystem\nandroid.process.acore\ncom.android.phone\ncom.android.settings\ncom.android.launcher\ncom.svox.pico\ncom.android.defcontainer\ncom.android.quicksearchbox\ncom.android.email\ncom.android.music\ncom.android.protips\ncom.android.mms\nandroid.process.media\ncom.android.alarmclock\n'),
(15, '000000000000000', 'my.app.proyectosoftwareandroid\njp.co.omronsoft.openwnn\nsystem\nandroid.process.acore\ncom.android.phone\ncom.android.settings\ncom.android.launcher\ncom.svox.pico\ncom.android.defcontainer\ncom.android.quicksearchbox\ncom.android.email\ncom.android.music\ncom.android.protips\ncom.android.mms\nandroid.process.media\ncom.android.alarmclock\n'),
(16, '000000000000000', 'my.app.proyectosoftwareandroid\njp.co.omronsoft.openwnn\nsystem\nandroid.process.acore\ncom.android.phone\ncom.android.settings\ncom.android.launcher\ncom.svox.pico\ncom.android.defcontainer\ncom.android.quicksearchbox\ncom.android.email\ncom.android.music\ncom.android.protips\ncom.android.mms\nandroid.process.media\ncom.android.alarmclock\n');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tablaprueba`
--

CREATE TABLE IF NOT EXISTS `tablaprueba` (
  `textotabla` text NOT NULL,
`idtabla` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=29 ;

--
-- Volcado de datos para la tabla `tablaprueba`
--

INSERT INTO `tablaprueba` (`textotabla`, `idtabla`) VALUES
('Texto desde phpMyAdmin', 1),
('Texto desde Aplicación Móvil Android', 2),
('Texto desde Aplicación Móvil Android', 3),
('Texto desde Aplicación Móvil Android', 4),
('Texto desde Aplicación Móvil Android', 5),
('Texto desde Aplicación Móvil Android en Laptop de Pablo', 6),
('Texto desde Aplicación Móvil Android', 7),
('Texto desde Aplicación Móvil Android', 8),
('Texto desde Aplicación Móvil Android', 9),
('Texto desde Aplicación Móvil Android', 10),
('Texto desde Aplicación Móvil Android', 11),
('Texto desde Aplicación Móvil Android', 12),
('Texto desde Aplicación Móvil Android', 13),
('Texto desde Aplicación Móvil Android', 14),
('Texto desde Aplicación Móvil Android', 15),
('Texto desde Aplicación Móvil Android', 16),
('Texto desde Aplicación Móvil Android', 17),
('Texto desde Aplicación Móvil Android', 18),
('Texto desde Aplicación Móvil Android', 19),
('Texto desde Aplicación Móvil Android', 20),
('Texto desde Aplicación Móvil Android', 21),
('Texto desde Aplicación Móvil Android', 22),
('Texto desde Aplicación Móvil Android', 23),
('Texto desde Aplicación Móvil Android', 24),
('Texto desde Aplicación Móvil Android', 25),
('Texto desde Aplicación Móvil Android', 26),
('Texto desde Aplicación Móvil Android', 27),
('Texto desde Aplicación Móvil Android', 28);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicaciones`
--

CREATE TABLE IF NOT EXISTS `ubicaciones` (
`id_ubicacion` int(11) NOT NULL,
  `imei` text NOT NULL,
  `location` point NOT NULL,
  `fecha_hora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=84 ;

--
-- Volcado de datos para la tabla `ubicaciones`
--

INSERT INTO `ubicaciones` (`id_ubicacion`, `imei`, `location`, `fecha_hora`) VALUES
(1, '2', '\0\0\0\0\0\0\0\0\0\0\0\0\0ð?\0\0\0\0\0\0ð?', '2014-09-20 18:16:05'),
(2, '2', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-20 18:36:49'),
(3, '2', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-20 18:37:09'),
(4, '2', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-20 18:37:29'),
(5, '2', '\0\0\0\0\0\0\06¬©,\n“ @µÀ)[OÀ', '2014-09-20 18:39:58'),
(6, '2', '\0\0\0\0\0\0\0.ñ6%’ @!‘¶ñ''[OÀ', '2014-09-20 18:40:17'),
(7, '2', '\0\0\0\0\0\0\0S¹ä\r‘ @3b?[OÀ', '2014-09-20 18:42:55'),
(8, '2', '\0\0\0\0\0\0\0¡‚Ã\r\n"’ @Ò &’C[OÀ', '2014-09-20 18:43:38'),
(9, '0000', '\0\0\0\0\0\0\0D�U��H@"��t0@', '2014-09-20 19:07:58'),
(10, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-20 20:15:19'),
(11, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-20 20:15:28'),
(12, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-20 20:15:38'),
(13, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-20 20:15:48'),
(14, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-20 20:15:58'),
(15, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-20 20:16:08'),
(16, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-20 20:16:18'),
(17, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-20 20:16:28'),
(18, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 01:57:31'),
(19, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 01:57:39'),
(20, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 01:57:49'),
(21, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 01:57:59'),
(22, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 01:58:09'),
(23, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 01:58:19'),
(24, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 01:58:29'),
(25, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 01:58:39'),
(26, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 01:58:49'),
(27, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 02:12:48'),
(28, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 02:12:58'),
(29, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 02:13:08'),
(30, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 02:13:18'),
(31, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 02:13:28'),
(32, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 02:21:16'),
(33, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 02:21:25'),
(34, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 02:21:35'),
(35, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 02:21:45'),
(36, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 02:21:55'),
(37, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 02:22:05'),
(38, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 02:22:15'),
(39, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 02:22:29'),
(40, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 03:54:23'),
(41, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 03:54:33'),
(42, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 03:54:42'),
(43, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 03:54:53'),
(44, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 03:55:02'),
(45, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 03:55:13'),
(46, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 03:55:23'),
(47, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 03:55:33'),
(48, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 03:55:43'),
(49, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 03:55:53'),
(50, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 03:56:02'),
(51, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 03:56:13'),
(52, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 03:56:22'),
(53, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 03:56:33'),
(54, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 03:56:42'),
(55, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 03:56:53'),
(56, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 03:57:02'),
(57, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 03:57:13'),
(58, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 03:57:22'),
(59, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:08:02'),
(60, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:08:11'),
(61, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:08:21'),
(62, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:08:31'),
(63, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:08:41'),
(64, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:08:51'),
(65, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:09:01'),
(66, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:09:11'),
(67, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:09:21'),
(68, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:17:13'),
(69, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:17:22'),
(70, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:17:32'),
(71, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:17:42'),
(72, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:17:52'),
(73, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:18:02'),
(74, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:18:13'),
(75, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:18:22'),
(76, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:18:33'),
(77, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:18:42'),
(78, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:18:52'),
(79, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:19:02'),
(80, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:19:12'),
(81, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:19:22'),
(82, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:19:32'),
(83, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-21 04:19:42');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
`id_user` int(11) NOT NULL,
  `username` varchar(10) NOT NULL,
  `passw` varchar(10) NOT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_user`, `username`, `passw`) VALUES
(1, 'jose', 'cosa1'),
(2, 'jose2', 'cosa2'),
(3, 'jose3', 'cosa3');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `dispositivos`
--
ALTER TABLE `dispositivos`
 ADD PRIMARY KEY (`imei`);

--
-- Indices de la tabla `llamada`
--
ALTER TABLE `llamada`
 ADD PRIMARY KEY (`num_llamada`);

--
-- Indices de la tabla `mensaje`
--
ALTER TABLE `mensaje`
 ADD PRIMARY KEY (`num_mensaje`);

--
-- Indices de la tabla `procesos`
--
ALTER TABLE `procesos`
 ADD PRIMARY KEY (`id_procesos`);

--
-- Indices de la tabla `tablaprueba`
--
ALTER TABLE `tablaprueba`
 ADD PRIMARY KEY (`idtabla`);

--
-- Indices de la tabla `ubicaciones`
--
ALTER TABLE `ubicaciones`
 ADD PRIMARY KEY (`id_ubicacion`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
 ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `llamada`
--
ALTER TABLE `llamada`
MODIFY `num_llamada` mediumint(9) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT de la tabla `mensaje`
--
ALTER TABLE `mensaje`
MODIFY `num_mensaje` mediumint(9) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `procesos`
--
ALTER TABLE `procesos`
MODIFY `id_procesos` mediumint(9) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT de la tabla `tablaprueba`
--
ALTER TABLE `tablaprueba`
MODIFY `idtabla` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT de la tabla `ubicaciones`
--
ALTER TABLE `ubicaciones`
MODIFY `id_ubicacion` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=84;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
