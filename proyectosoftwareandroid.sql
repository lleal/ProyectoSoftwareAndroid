-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-09-2014 a las 22:20:03
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

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
('000000000000000', 11, '+15552175049', 'Sat Sep 20 19:32:58 GMT+00:00 2014', 'Saliente');

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
-- Estructura de tabla para la tabla `tablaprueba`
--

CREATE TABLE IF NOT EXISTS `tablaprueba` (
  `textotabla` text NOT NULL,
`idtabla` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

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
('Texto desde Aplicación Móvil Android', 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicaciones`
--

CREATE TABLE IF NOT EXISTS `ubicaciones` (
`id_ubicacion` int(11) NOT NULL,
  `imei` text NOT NULL,
  `location` point NOT NULL,
  `fecha_hora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

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
(17, '0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '2014-09-20 20:16:28');

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
MODIFY `num_llamada` mediumint(9) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `mensaje`
--
ALTER TABLE `mensaje`
MODIFY `num_mensaje` mediumint(9) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `tablaprueba`
--
ALTER TABLE `tablaprueba`
MODIFY `idtabla` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT de la tabla `ubicaciones`
--
ALTER TABLE `ubicaciones`
MODIFY `id_ubicacion` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
