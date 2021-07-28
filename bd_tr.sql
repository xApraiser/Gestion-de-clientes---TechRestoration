-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-07-2021 a las 01:18:10
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_tr`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `nombre_cliente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `rut_cliente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email_cliente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `telefono_cliente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `direcion_cliente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ult_modificacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='tabla que almacena los datos de los clientes';

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre_cliente`, `rut_cliente`, `email_cliente`, `telefono_cliente`, `direcion_cliente`, `ult_modificacion`) VALUES
(5, 'Jano', '18.312.712-8', 'prueba1@ejemplo.cl', '989652341', 'Cerro Moreno', 'recepcionista'),
(6, 'Belen', '8.123.456-7', 'prueba2@ejemplo2.cl', '98758463', 'Cerro Moreno', 'recepcionista'),
(7, 'Juan', '8.632.458-7', 'juan@prueba3.cl', '4569321478', 'Calle playa blanca', 'recepcionista'),
(8, 'Maria Saavedra', '8.963.458-8', 'maria@prueba4.cl', '89657489', 'Coloso 65655', 'recepcionista'),
(9, 'Sandra', '8.271.023-8', 'sandra@prueba1.cl', '789654123', 'cerro moreno', 'admin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

CREATE TABLE `equipos` (
  `id_equipo` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `tipo_equipo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `marca` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `modelo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `num_serie` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dia_ingreso` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `mes_ingreso` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `annio_ingreso` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `observaciones` longtext COLLATE utf8_unicode_ci NOT NULL,
  `estatus` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ultima_modificacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `comentarios_tenicos` longtext COLLATE utf8_unicode_ci NOT NULL,
  `revision_tecnica_de` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='tabla para el registro de equipos';

--
-- Volcado de datos para la tabla `equipos`
--

INSERT INTO `equipos` (`id_equipo`, `id_cliente`, `tipo_equipo`, `marca`, `modelo`, `num_serie`, `dia_ingreso`, `mes_ingreso`, `annio_ingreso`, `observaciones`, `estatus`, `ultima_modificacion`, `comentarios_tenicos`, `revision_tecnica_de`) VALUES
(5, 5, 'Notebook', 'Asus', 'Vivobook S15', 'N65989', '21', '6', '2021', 'No enciende', 'Reparado', 'recepcionista', 'Se cambia fuente de poder del notebook', 'tecnico'),
(6, 6, 'Notebook', 'HP', 'Pavillion x360', 'N458796', '21', '6', '2021', 'Computador muy lento y luego de uno minutos suele dar pantallazo azul', 'Entregado', 'recepcionista', 'Valor del servicio: $60.000\nSe entrega el equipo al cliente', 'tecnico'),
(7, 5, 'Impresora', 'Epson', 'Epson 450', 'N1236', '21', '6', '2021', 'Se traga la hojas', 'En revision', 'recepcionista', 'se cambia cabezal', 'tecnico'),
(8, 7, 'Notebook', 'Asus', 'Vivobook s16', 'AV4589', '25', '6', '2021', 'Problemas en la pantalla, tiene zonas que se ven negras cuando enciende el equipo', 'Nuevo ingreso', 'recepcionista', ' Se cambia la pantalla 2', 'tecnico'),
(9, 8, 'Desktop', 'Alienware', 'Aurora R12 11th generación I7-11700KF', '117000', '27', '6', '2021', 'No enciende y emite ruidos extraños, segun el cliente suena mecanico', 'En revision', 'recepcionista', 'El diagnostico arroja que la fuente de poder se encuentra en mal estado, posiblemente tenga piezas rotas dentro. Solucion: Se cambiara la fuente de poder por una nueva', 'tecnico'),
(10, 9, 'Desktop', 'Dell', 'Dell-1', 'D4598', '28', '6', '2021', 'No enciende. viene sin cable de energia', 'Nuevo ingreso', 'admin', 'Se reemplaza placa madre', 'tecnico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE `historial` (
  `id_historial` int(11) NOT NULL,
  `id_insumo` int(11) NOT NULL,
  `id_equipo` int(11) NOT NULL,
  `comentario_historial` longtext COLLATE utf8_unicode_ci NOT NULL,
  `dia` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `mes` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `annio` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `insumo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `revision_tecnica_de` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Historial de trabajo sobre un equipo';

--
-- Volcado de datos para la tabla `historial`
--

INSERT INTO `historial` (`id_historial`, `id_insumo`, `id_equipo`, `comentario_historial`, `dia`, `mes`, `annio`, `insumo`, `revision_tecnica_de`) VALUES
(15, 0, 5, 'Se inicia el diagnostico', '27', '6', '2021', '', 'tecnico'),
(16, 0, 5, 'Se cambia fuente de poder del notebook', '27', '6', '2021', 'fuente de poder notebook', 'tecnico'),
(17, 0, 5, 'Se cambia fuente de poder del notebook', '27', '6', '2021', 'Fuente de poder Notebook', 'tecnico'),
(18, 0, 10, 'Se inicia diagnostico', '28', '6', '2021', '', 'tecnico'),
(19, 2, 10, 'Se reemplaza placa madre', '28', '6', '2021', 'Placa Madre', 'tecnico'),
(20, 2, 10, 'Se reemplaza placa madre', '28', '6', '2021', 'Placa Madre', 'tecnico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `insumo`
--

CREATE TABLE `insumo` (
  `id_insumo` int(11) NOT NULL,
  `nombre_insumo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `marca_insumo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `modelo_insumo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `repuesto_para` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `num_serie_insumo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `cantidad` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Tabla para le ingreso de repuestos y/o insumos';

--
-- Volcado de datos para la tabla `insumo`
--

INSERT INTO `insumo` (`id_insumo`, `nombre_insumo`, `marca_insumo`, `modelo_insumo`, `repuesto_para`, `num_serie_insumo`, `cantidad`) VALUES
(2, 'Placa Madre', 'Biostar', 'TB360-BTC PRO', 'Desktop', 'LGA1151', 1),
(3, 'Memoria RAM SODDIM 8GB', 'Crucial', 'Sodimm', 'Notebook', 'PC3-12800', 4),
(4, 'Cabezal De Impresión De 5 Ranuras', 'Epson', 'D5468', 'Impresora', '54689', 3),
(5, 'Fuente de Poder Aero Bronze 650W', 'Aerocool', 'Aero Bronze 650W', 'Desktop', 'F98745', 6),
(6, 'Tarjeta de Red/WIFI Interna', 'TPLink', 'TL-WN781ND', 'Desktop', 'N150', 2),
(7, 'Tarjeta Grafica', 'NVidia', 'GTX-1080', 'Desktop', 'N459678', 3),
(8, 'Lector de CD/DVD', 'Lenovo', 'L9865', 'Desktop', 'N4512', 2),
(9, 'sdasd', 'asd', 'asd', 'Escaner', 'aasd89', 2),
(10, 'Fuente de poder Notebook', 'Asus', 'FP7854', 'Notebook', 'N9854', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre_usuario` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `telefono` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tipo_nivel` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `estatus` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `registrado_por` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Tabla para almacenamiento del registro de usuarios';

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre_usuario`, `email`, `telefono`, `username`, `password`, `tipo_nivel`, `estatus`, `registrado_por`) VALUES
(1, 'Alejandro Fredes', 'jano@ejemplo.cl', '62927160', 'admin', '1234', 'Administrador', 'Activo', 'admin'),
(2, 'Francisco Perez', 'francisco@ejemplo.cl', '62927160', 'tecnico', '1234', 'Tecnico', 'Activo', 'admin'),
(3, 'recepcionista', 'recepcionista@ejemplo.cl', '45698712', 'recepcionista', '1234', 'Recepcionista', 'Activo', 'admin'),
(4, 'pruenaconexion', 'conexion@prueba.cl', '98416575', 'conexion', '1234', 'Administrador', 'Inactivo', 'admin'),
(5, 'Jano', 'jano@gmail.cl', '95632145', 'jano12', '12345', 'Recepcionista', 'Inactivo', 'admin');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `equipos`
--
ALTER TABLE `equipos`
  ADD PRIMARY KEY (`id_equipo`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indices de la tabla `historial`
--
ALTER TABLE `historial`
  ADD PRIMARY KEY (`id_historial`);

--
-- Indices de la tabla `insumo`
--
ALTER TABLE `insumo`
  ADD PRIMARY KEY (`id_insumo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `equipos`
--
ALTER TABLE `equipos`
  MODIFY `id_equipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `historial`
--
ALTER TABLE `historial`
  MODIFY `id_historial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `insumo`
--
ALTER TABLE `insumo`
  MODIFY `id_insumo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `equipos`
--
ALTER TABLE `equipos`
  ADD CONSTRAINT `equipos_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
