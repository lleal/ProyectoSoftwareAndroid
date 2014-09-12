-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-09-2014 a las 01:26:42
-- Versión del servidor: 5.6.20
-- Versión de PHP: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE DATABASE proyectosoftwareandroid;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `proyectosoftwareandroid`
--

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tablaprueba`
--



CREATE TABLE IF NOT EXISTS `tablaprueba` (
  `textotabla` text NOT NULL,
`idtabla` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `tablaprueba`
--

INSERT INTO `tablaprueba` (`textotabla`, `idtabla`) VALUES
('Texto desde phpMyAdmin', 1),
('Texto desde Aplicación Móvil Android', 2),
('Texto desde Aplicación Móvil Android', 3);

--
-- Índices para tablas volcadas
--

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
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `llamada`
--
ALTER TABLE `llamada`
MODIFY `num_llamada` mediumint(9) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `mensaje`
--
ALTER TABLE `mensaje`
MODIFY `num_mensaje` mediumint(9) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tablaprueba`
--
ALTER TABLE `tablaprueba`
MODIFY `idtabla` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
