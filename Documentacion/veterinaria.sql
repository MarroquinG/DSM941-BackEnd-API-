-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 28-05-2024 a las 03:00:24
-- Versión del servidor: 8.0.27
-- Versión de PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `veterinaria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

DROP TABLE IF EXISTS `citas`;
CREATE TABLE IF NOT EXISTS `citas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_Usuario` int NOT NULL,
  `id_Paciente_Mascota` int NOT NULL,
  `id_Estado_Cita` int NOT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `hora` time(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Usuario` (`id_Usuario`,`id_Paciente_Mascota`,`id_Estado_Cita`),
  KEY `id_Estado_Cita` (`id_Estado_Cita`),
  KEY `id_Paciente_Mascota` (`id_Paciente_Mascota`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`id`, `id_Usuario`, `id_Paciente_Mascota`, `id_Estado_Cita`, `fecha`, `hora`) VALUES
(1, 1, 1, 1, '2024-05-10 19:51:32.000000', '00:00:08.000000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encargado_mascota`
--

DROP TABLE IF EXISTS `encargado_mascota`;
CREATE TABLE IF NOT EXISTS `encargado_mascota` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(30) COLLATE utf8_bin NOT NULL,
  `Apellidos` varchar(50) COLLATE utf8_bin NOT NULL,
  `Dui` varchar(9) COLLATE utf8_bin NOT NULL,
  `Edad` varchar(10) COLLATE utf8_bin NOT NULL,
  `Ciudad` varchar(20) COLLATE utf8_bin NOT NULL,
  `Direccion` varchar(150) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `encargado_mascota`
--

INSERT INTO `encargado_mascota` (`id`, `Nombres`, `Apellidos`, `Dui`, `Edad`, `Ciudad`, `Direccion`) VALUES
(1, 'Jose', 'Gutierrez', '123456-8', '23', 'San salvador', 'Avenida sur no se donde vamos ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_cita`
--

DROP TABLE IF EXISTS `estado_cita`;
CREATE TABLE IF NOT EXISTS `estado_cita` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Nombre_Estado_Cita` varchar(30) COLLATE utf8_bin NOT NULL,
  `status` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `estado_cita`
--

INSERT INTO `estado_cita` (`id`, `Nombre_Estado_Cita`, `status`) VALUES
(1, 'Pendiente', 1),
(2, 'Finalizada  ', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente_mascota`
--

DROP TABLE IF EXISTS `paciente_mascota`;
CREATE TABLE IF NOT EXISTS `paciente_mascota` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) COLLATE utf8_bin NOT NULL,
  `Edad` varchar(30) COLLATE utf8_bin NOT NULL,
  `Raza` varchar(30) COLLATE utf8_bin NOT NULL,
  `Fecha_Nacimiento` datetime NOT NULL,
  `id_Encargado_Mascota` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Encargado_Mascota` (`id_Encargado_Mascota`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `paciente_mascota`
--

INSERT INTO `paciente_mascota` (`id`, `Nombre`, `Edad`, `Raza`, `Fecha_Nacimiento`, `id_Encargado_Mascota`) VALUES
(1, 'firulais', '1', 'Chiguagua ', '2023-05-04 12:26:41', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
CREATE TABLE IF NOT EXISTS `tipo_usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Nombre_Tipo_Usuario` varchar(50) COLLATE utf8_bin NOT NULL,
  `estatus` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`id`, `Nombre_Tipo_Usuario`, `estatus`) VALUES
(1, 'Administrador', 1),
(2, 'Veterinario', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(50) COLLATE utf8_bin NOT NULL,
  `Apellidos` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Correo` varchar(50) COLLATE utf8_bin NOT NULL,
  `Pass` varchar(50) COLLATE utf8_bin NOT NULL,
  `id_Tipo_Usuario` int NOT NULL,
  `estatus` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Tipo_Usuario` (`id_Tipo_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `Nombres`, `Apellidos`, `Correo`, `Pass`, `id_Tipo_Usuario`, `estatus`) VALUES
(1, 'Daniel', 'Marroquin', 'daniel@gmail.com', '123345678', 1, 1),
(2, 'sdf ', 'safd', 'sdf@gmail.com', '123345678', 2, 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `citas_ibfk_1` FOREIGN KEY (`id_Estado_Cita`) REFERENCES `estado_cita` (`id`),
  ADD CONSTRAINT `citas_ibfk_2` FOREIGN KEY (`id_Paciente_Mascota`) REFERENCES `paciente_mascota` (`id`),
  ADD CONSTRAINT `citas_ibfk_3` FOREIGN KEY (`id_Usuario`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `paciente_mascota`
--
ALTER TABLE `paciente_mascota`
  ADD CONSTRAINT `paciente_mascota_ibfk_1` FOREIGN KEY (`id_Encargado_Mascota`) REFERENCES `encargado_mascota` (`id`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_Tipo_Usuario`) REFERENCES `tipo_usuario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
