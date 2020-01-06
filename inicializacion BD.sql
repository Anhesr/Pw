-- phpMyAdmin SQL Dump
-- version 2.7.0-pl2
-- http://www.phpmyadmin.net
-- 
-- Servidor: oraclepr.uco.es
-- Tiempo de generación: 06-01-2020 a las 14:15:11
-- Versión del servidor: 5.1.73
-- Versión de PHP: 5.3.3
-- 
-- Base de datos: `i72saraf`
-- 
CREATE DATABASE `i72saraf` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE i72saraf;

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `amigos`
-- 

CREATE TABLE `amigos` (
  `ID_USUARIO` int(11) NOT NULL,
  `ID_AMIGO` int(11) NOT NULL,
  PRIMARY KEY (`ID_USUARIO`,`ID_AMIGO`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- 
-- Volcar la base de datos para la tabla `amigos`
-- 

INSERT INTO `amigos` VALUES (35, 1);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `comentarios`
-- 

CREATE TABLE `comentarios` (
  `IDUSUARIO` int(11) NOT NULL,
  `IDPUBLICACION` int(11) NOT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `APELLIDOS` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `CUERPO` varchar(2048) COLLATE utf8_spanish_ci NOT NULL,
  `FECHA_PUBLICACION` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `IDPUBLICACION` (`IDPUBLICACION`)
) ENGINE=MyISAM AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=63 ;

-- 
-- Volcar la base de datos para la tabla `comentarios`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `curriculums`
-- 

CREATE TABLE `curriculums` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL,
  `SITUACION_LABORAL` set('Activo','En paro','Estudiante') CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `FORMACION_ACADEMICA` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `UNIVERSIDAD` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `INTERESES_PROFESIONALES` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `EXPERIENCIA_CIENTIFICA` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `LOGROS_CIENTIFICOS` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

-- 
-- Volcar la base de datos para la tabla `curriculums`
-- 

INSERT INTO `curriculums` VALUES (1, 1, 'Activo', 'Ciclo en DAW y carrera en la vida', 'Universidad de la calle', 'DiseÃ±o de aplicaciones WEB y apps nopor', 'Mucha, tuve un set de quÃ­mica de quimicefa', 'Nada');
INSERT INTO `curriculums` VALUES (2, 34, 'En paro', 'prueba', 'prueba', 'prueba', 'prueba', 'prueba');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `publicaciones`
-- 

CREATE TABLE `publicaciones` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AUTOR_ID` int(11) NOT NULL,
  `NOMBRE` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `CUERPO` varchar(2048) COLLATE utf8_spanish_ci NOT NULL,
  `FECHA_PUBLICACION` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `VISITAS` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`),
  KEY `AUTOR_ID` (`AUTOR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=58 ;

-- 
-- Volcar la base de datos para la tabla `publicaciones`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `usuarios`
-- 

CREATE TABLE `usuarios` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CURRICULUM_ID` int(11) DEFAULT NULL,
  `NOMBRE` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `APELLIDOS` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `FECHA_NACIMIENTO` date NOT NULL,
  `CORREO_ELECTRONICO` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `TELEFONO` int(15) NOT NULL,
  `USUARIO` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `PASSWORD` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `IMAGEN` mediumblob,
  PRIMARY KEY (`ID`),
  KEY `CURRICULUM_ID_2` (`CURRICULUM_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=37 ;
