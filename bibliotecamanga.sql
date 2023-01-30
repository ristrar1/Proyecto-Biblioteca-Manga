-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-04-2022 a las 14:01:29
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bibliotecamanga`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mangas`
--

CREATE TABLE `mangas` (
  `idmanga` int(10) NOT NULL,
  `titulo` varchar(200) NOT NULL,
  `genero` varchar(40) NOT NULL,
  `sinopsis` varchar(400) NOT NULL,
  `autores` varchar(100) NOT NULL,
  `numtomos` varchar(10) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `imagen` varchar(400) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `mangas`
--

INSERT INTO `mangas` (`idmanga`, `titulo`, `genero`, `sinopsis`, `autores`, `numtomos`, `tipo`, `imagen`) VALUES
(1, 'The Promised Neverland', 'Thriller', 'Emma, Norman y Ray son tres huérfanos que viven felices en el idílico orfanato Grace Field House, esperando el momento en\n el que se les asignará una familia adoptiva. Todo cambia cuando descubren accidentalmente la horrorosa realidad de su \nexistencia, así que deciden rebelarse y luchar hasta las últimas consecuencias en una oscura y aterradora aventura. \nPero su tiempo se acaba..', 'Kaiu Shirai - Posuka Demizu', '20', 'Shounen', 'C:\\ejava\\Proyectos Netbeans\\PRO\\T8\\BibliotecaManga\\imagenes\\promised.jpeg'),
(2, 'Chainsaw Man', 'Acción - Thriller', 'Denji es un chico sin un duro que se deja la piel trabajando como Devil Hunter junto a su perro demoníaco Pochita para resarcir una deuda astronómica, pero entonces... ¡¡una sangrienta traición da un giro radical a su miserable vida!!', 'Tatsuki Fujimoto', '12', 'Shounen', 'C:\\ejava\\Proyectos Netbeans\\PRO\\T8\\BibliotecaManga\\imagenes\\chainsaw.jpeg'),
(3, 'One Punch-Man', 'Acción', '¡Él aniquila a sus oponentes de un solo golpe! Saitama es un superhéroe tan fuerte que con sólo un golpederrota a cualquier clase de monstruo, criatura extraña o villano. Aunque para él, no es precisamente bueno... ¡¡Así comienza la leyenda del héroe más poderoso y apático de la historia!! Su camino es buscar enemigos quesí representen un desafío para él.', 'ONE - Yusuke Murata', '24 ?', 'Shounen', 'C:\\ejava\\Proyectos Netbeans\\PRO\\T8\\BibliotecaManga\\imagenes\\onepunchman.jpg'),
(4, 'One Piece', 'Accion - Aventura', 'Cuando tenía 7 años, Monkey D. Luffy se comió accidentalmente una mítica Fruta del Diablo, lo que le convirtió en un hombre elástico. Pero tuvo que pagar un precio muy alto. Una década después, con 17 años, Luffy pretende seguir la estela de su admirado pirata Shanks  y sale al mar para encontrar el legendario tesoro One Piece. Si lo consigue, llegará a ser el Rey de los Piratas.', 'Eichiro Oda', '100', 'Shounen', 'C:\\ejava\\Proyectos Netbeans\\PRO\\T8\\BibliotecaManga\\imagenes\\onepiece.jpg');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `mangas`
--
ALTER TABLE `mangas`
  ADD PRIMARY KEY (`idmanga`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
