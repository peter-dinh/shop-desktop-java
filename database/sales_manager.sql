-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 20, 2017 at 01:32 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sales_manager`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `id` int(11) NOT NULL,
  `id_customer` varchar(12) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_staff` varchar(6) COLLATE utf8_unicode_ci DEFAULT NULL,
  `datetime` datetime NOT NULL,
  `payment` tinyint(1) NOT NULL,
  `sum_bill` bigint(16) NOT NULL,
  `sale` int(2) NOT NULL,
  `shell_out` bigint(16) NOT NULL,
  `note` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`id`, `id_customer`, `id_staff`, `datetime`, `payment`, `sum_bill`, `sale`, `shell_out`, `note`) VALUES
(1, '123456789', '100001', '2017-05-19 21:25:39', 0, 3040000, 3, 2948800, 'Đinh Dương\n0919934122\nViệt Nam\nVIP1'),
(2, '123456782', '100001', '2017-05-19 21:26:45', 0, 1575000, 3, 1527750, 'Đinh Hiệp\n0919934122\nViệt Nam\nVIP1'),
(3, '123456784', '100001', '2017-05-19 21:27:23', 0, 6175000, 3, 5989750, 'Đinh Vân\n0919934122\nViệt Nam\nVIP1'),
(4, '123456789', '100001', '2017-05-19 21:29:41', 0, 297000, 5, 282150, 'Đinh Dương\n0919934122\nViệt Nam\nVIP2'),
(5, '123456782', '100001', '2017-05-19 21:32:31', 0, 6000000, 5, 5700000, 'Đinh Hiệp\n0919934122\nViệt Nam\nVIP2');

-- --------------------------------------------------------

--
-- Table structure for table `bill_info`
--

CREATE TABLE `bill_info` (
  `id_bill` int(11) NOT NULL,
  `id_product` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `count` int(11) NOT NULL,
  `price` bigint(16) NOT NULL,
  `sale` int(2) NOT NULL,
  `sum` bigint(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `bill_info`
--

INSERT INTO `bill_info` (`id_bill`, `id_product`, `count`, `price`, `sale`, `sum`) VALUES
(1, '0103000001', 1, 3200000, 5, 3040000),
(2, '0114000001', 1, 50000, 0, 50000),
(2, '0208000001', 2, 350000, 5, 665000),
(2, '0304000001', 1, 1000000, 14, 860000),
(3, '0704000001', 1, 6500000, 5, 6175000),
(4, '1007000003', 1, 20000, 0, 20000),
(4, '1007000004', 2, 21000, 0, 42000),
(4, '1307000001', 1, 235000, 0, 235000),
(5, '1716000001', 1, 6000000, 0, 6000000);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `id_district` int(2) NOT NULL,
  `phone` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `accumulation` bigint(16) NOT NULL,
  `id_rank` int(2) NOT NULL,
  `date_register` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `first_name`, `last_name`, `address`, `id_district`, `phone`, `accumulation`, `id_rank`, `date_register`) VALUES
('123456781', 'Đinh', 'Trưởng', 'Việt Nam', 8, '0919934122', 0, 10, '2017-05-19'),
('123456782', 'Đinh', 'Hiệp', 'Việt Nam', 2, '0919934122', 7575000, 30, '2017-05-19'),
('123456783', 'Đinh', 'Minh', 'Việt Nam', 1, '0919934122', 0, 10, '2017-05-19'),
('123456784', 'Đinh', 'Vân', 'Việt Nam', 1, '0919934122', 6175000, 30, '2017-05-19'),
('123456785', 'Đinh', 'Trang', 'Việt Nam', 3, '0919934122', 0, 10, '2017-05-19'),
('123456786', 'Đinh', 'Trúc', 'Việt Nam', 8, '0919934122', 0, 10, '2017-05-19'),
('123456787', 'Đinh', 'Ngọc', 'Việt Nam', 6, '0919934122', 0, 10, '2017-05-19'),
('123456788', 'Đinh', 'Hải', 'Việt Nam', 8, '0919934122', 0, 10, '2017-05-19'),
('123456789', 'Đinh', 'Dương', 'Việt Nam', 12, '0919934122', 3337000, 20, '2017-05-19');

-- --------------------------------------------------------

--
-- Table structure for table `district`
--

CREATE TABLE `district` (
  `id` int(2) NOT NULL,
  `name_district` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `name_city` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `district`
--

INSERT INTO `district` (`id`, `name_district`, `name_city`) VALUES
(1, 'Quận 1', 'Hồ Chí Minh'),
(2, 'Quận 2', 'Hồ Chí Minh'),
(3, 'Quận 3', 'Hồ Chí Minh'),
(4, 'Quận 4', 'Hồ Chí Minh'),
(5, 'Quận 5', 'Hồ Chí Minh'),
(6, 'Quận 6', 'Hồ Chí Minh'),
(7, 'Quận 7', 'Hồ Chí Minh'),
(8, 'Quận 8', 'Hồ Chí Minh'),
(9, 'Quận 9', 'Hồ Chí Minh'),
(10, 'Quận 10', 'Hồ Chí Minh'),
(11, 'Quận 11', 'Hồ Chí Minh'),
(12, 'Quan 12', 'Ho Chi Minh');

-- --------------------------------------------------------

--
-- Table structure for table `producer`
--

CREATE TABLE `producer` (
  `id` int(2) NOT NULL,
  `name_producer` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `mail` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `producer`
--

INSERT INTO `producer` (`id`, `name_producer`, `address`, `phone`, `mail`) VALUES
(1, 'Vinamike', 'Ha noi', '3654654654', 'vinamike@gmail.com'),
(2, 'Lazada', 'Ho Chi Minh', '123123', 'lazada@gmail.com'),
(3, 'VinaGame', 'Ho Chi Minh', '123', '123'),
(4, 'VinaGiay', 'Ha Noi', '123', '123'),
(5, 'Sendo', 'Ho Chi Minh', '123123', 'lazada@gmail.com'),
(6, 'Vincom', 'Ho Chi Minh', '123123', 'lazada@gmail.com'),
(7, 'Comark', 'Ho Chi Minh', '123123', 'lazada2@gmail.com'),
(8, 'Việt Tiến', 'Ho Chi Minh', '123123', 'lazada3@gmail.com'),
(9, 'Bitist', 'Ho Chi Minh', '123123', 'lazada4@gmail.com'),
(10, 'Hòa Phát', 'Ho Chi Minh', '123123', 'lazada5@gmail.com'),
(11, 'KFC', 'Ho Chi Minh', '123123', 'lazada1@gmail.com'),
(12, 'KeyTech', 'Ho Chi Minh', '123123', 'lazada2@gmail.com'),
(13, 'Tân Hiệp Phát', 'Ho Chi Minh', '123123', 'lazada3@gmail.com'),
(14, 'Vietlott', 'Ho Chi Minh', '123123', 'lazada4@gmail.com'),
(15, 'Lotte', 'Ho Chi Minh', '123123', 'lazada5@gmail.com'),
(16, 'Vincom', 'Ho Chi Minh', '123123', 'lazada1@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `id_type` int(2) NOT NULL,
  `price` bigint(16) NOT NULL,
  `sale` int(2) NOT NULL,
  `unit` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_producer` int(2) NOT NULL,
  `count` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `id_type`, `price`, `sale`, `unit`, `image`, `id_producer`, `count`) VALUES
('0103000001', 'Áo đầm nữ', 1, 3200000, 5, 'c', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/ao_khoac_dam_dang_xoe_nut_boc_2in1_d6e3.jpg', 3, 9),
('0108000001', 'Áo thể thao nam', 1, 360000, 0, 'c', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/ao-nam-adidas-uncontrol-climachill-tee-s26998.jpg', 8, 20),
('0108000002', 'Áo sơ mi nam', 1, 650000, 0, 'c', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/ao_so_mi_nam_tay_ngan_mot_tre_forboss_abn004_a325.jpg', 8, 20),
('0108000003', 'Áo véc nữ', 1, 2100000, 24, 'c', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/ao_vest_nu_cong_so_co_tru_thoi_trang_4226.jpg', 8, 20),
('0114000001', 'Áo khoác dài tay', 1, 50000, 0, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/ao_khoac_nu_xo_ngon_nang_dong_e354.jpg', 14, 9),
('0208000001', 'Quần bò nam', 2, 350000, 5, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/0dec8b_simg_b5529c_250x250_maxb.jpg', 8, 18),
('0208000002', 'Quần tây nam', 2, 1200000, 6, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/1675.jpg', 8, 10),
('0304000001', 'Giày nam cao cấp', 3, 1000000, 14, 'đôi', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/144800911271.jpg', 4, 29),
('0304000002', 'Guốc thời trang nữ', 3, 860000, 5, 'đôi', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/3(714).jpg', 4, 30),
('0404000001', 'Thắt lưng nam', 4, 100000, 5, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/14641574391.jpg', 4, 30),
('0508000001', 'Mũ lưỡi chai nam', 5, 120000, 10, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/cyb1216114115.jpg', 8, 20),
('0606000001', 'Kính thời trang', 6, 860000, 0, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/CvVZdcAS.jpg', 6, 10),
('0704000001', 'Túi sách MK', 7, 6500000, 5, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/95-tui-xach-da-that-mk-sang-chanh.jpg', 4, 9),
('0706000001', 'Túi sách nữ hồng', 7, 2500000, 10, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/dIfimy1s.jpg', 6, 10),
('0805000001', 'Đồng hồ thời trang nam', 8, 1500000, 0, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/1.jpg', 5, 10),
('0806000001', 'Đồng hồ da', 8, 2900000, 0, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/465107302_dong-ho-bruno-BS-17-13158-241 web.jpg', 6, 10),
('1007000001', 'Súp lơ xanh', 10, 20000, 0, 'g', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/120131afamily-AN-soup-rau-cu-1_303d3.jpg', 7, 200),
('1007000002', 'Cà chua tươi', 10, 23000, 0, 'g', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/3-nhom-rau-cu-qua-giup-thai-doc-cho-da-trong-mua-lanh.jpg', 7, 200),
('1007000003', 'Bắp ngô', 10, 20000, 0, 'b', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/Bắp-Mĩ-Cung-Cấp-Rau-Củ-Quả-Nấm-Sỉ-tại-Sài-Gòn-TPHCM-e1466944205996.jpg', 7, 149),
('1007000004', 'Cải bắp', 10, 21000, 0, 'bắp', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/cac-loai-rau-cu-qua-an-luoc-la-tot-nhat-hinh-9.jpg', 7, 148),
('1107000001', 'Cam tươi', 11, 68000, 0, 'kg', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/108-d5.jpg', 7, 150),
('1307000001', 'Thịt bò', 13, 235000, 0, 'kg', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/1448858753-thit-heo-nuong-dspl4.jpg', 7, 59),
('1407000001', 'Cá chép', 14, 30000, 0, 'kg', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/1438828087-Gia-mua-ban-ca-chep.jpg', 7, 20),
('1407000002', 'Cá ngừ', 14, 120000, 0, 'kg', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/bi-quyet-nuong-ca-bang-lo-nuong-thom-ngon.jpg', 7, 20),
('1514000001', 'Dầu gội head shoulders', 15, 35000, 10, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/dau goi dau Head shoulders suon mem ong muot 180ml.jpg', 14, 10),
('1514000002', 'Dầu gội Sunsilk', 15, 63000, 10, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/DG Sunsilk mem muot 1L.jpg', 14, 10),
('1514000003', 'Dầu gội Clear', 15, 20000, 0, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/Dầu-Gội-Clear-Mát-Lạnh-Bạc-Hà-650g.jpg', 14, 10),
('1614000001', 'bàn chải đánh răng', 16, 12000, 0, 'c', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/bàn-chải-đánh-răng-tiki2.jpg', 14, 10),
('1614000002', 'Kem đánh răng Colgate', 16, 25000, 0, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/Cac-loai-kem-danh-rang-cho-be_1470906265.jpg', 14, 10),
('1614000003', 'Khăn tắm', 16, 58000, 0, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/combo-4-khan-tam-thuong-hieu-Nha-Dep-1.jpg', 14, 10),
('1710000001', 'Bộ xong, chảo chống dính', 17, 5000000, 10, 'bộ', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/bo-5-noi-xung-chao-inox-nap-kinh-fivestars-fs08cg1-trang-kim-3298-149492-1.jpg', 10, 10),
('1714000001', 'Bếp ga', 17, 5000000, 10, 'Cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/0add1f50-c24d-414e-b1e6-56c57aa0513e_kangaroo-bep-gas-bep-gas-duong-2-lo-nau-mat-kinh-kg505-bep-ga-duong-mat-kinh-kangaroo-kg505.jpg', 14, 10),
('1716000001', 'Bát, đĩa sứ', 17, 6000000, 0, 'b', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/bat-dia-hoa-tiet-in-hoa.jpg', 16, 9),
('1812000001', 'Tủ Lanh 1 cửa', 18, 15000000, 2, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/003dea59-f089-4e2e-89e3-2da208d87935_tu-lanh-301l-mitsubishi-mr-bf36e-st-v-2-canh-ngan-da-duoi.jpg', 12, 10),
('1812000002', 'Nồi cơm điện', 18, 2300000, 10, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/9432286._thumbnail.jpg', 12, 20),
('1812000003', 'Ấm nước điện', 18, 1200000, 2, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/am-dun-sieu-toc-sunhouse-shd1053-mt3.jpg', 12, 10),
('1902000001', 'Sách tin học căn bản', 19, 26000, 0, 'cuốn', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/cung-hoc-tin-hoc-(tap-1-3)-1458025736.jpg', 2, 20),
('1910000001', 'Sách Tư tưởng HCM', 19, 90000, 5, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/9786045704813.jpg', 10, 10),
('2009000001', 'Cặp sách', 20, 200000, 0, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/ca92811d079f4df1a0fb0b1cf38528ab.jpg', 9, 20),
('2009000002', 'Cặp sách 5 anh em siêu nhân', 20, 350000, 10, 'cái', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/cap1.jpg', 9, 20),
('2009000003', 'Đồ dùng học tập', 20, 350000, 10, 'bộ', '/home/dinhtruong/NetBeansProjects/software_sales/image/product/chuan-bi-gi-cho-nam-hoc-moi2.jpg', 9, 20);

-- --------------------------------------------------------

--
-- Table structure for table `rank`
--

CREATE TABLE `rank` (
  `id` int(2) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `sale` int(2) NOT NULL,
  `rules` bigint(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `rank`
--

INSERT INTO `rank` (`id`, `name`, `sale`, `rules`) VALUES
(10, 'VIP1', 3, 0),
(20, 'VIP2', 5, 1000000),
(30, 'VIP3', 10, 5000000),
(40, 'VIP4', 12, 10000000),
(50, 'VIP5', 15, 20000000),
(60, 'VIP6', 25, 50000000);

-- --------------------------------------------------------

--
-- Table structure for table `receive`
--

CREATE TABLE `receive` (
  `id` int(11) NOT NULL,
  `id_producer` int(2) DEFAULT '0',
  `id_staff` varchar(6) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_time` datetime NOT NULL,
  `sum_receive` bigint(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

--
-- Dumping data for table `receive`
--

INSERT INTO `receive` (`id`, `id_producer`, `id_staff`, `date_time`, `sum_receive`) VALUES
(1, 2, '100001', '2017-05-09 19:51:55', 500000),
(2, 3, '100001', '2017-05-09 19:55:17', 30000000),
(3, 4, '100001', '2017-05-09 20:23:05', 114300000),
(4, 5, '100001', '2017-05-09 20:25:42', 15000000),
(5, 6, '100001', '2017-05-09 20:29:07', 54100000),
(6, 7, '100001', '2017-05-09 20:34:56', 21800000),
(9, 10, '100001', '2017-05-09 22:19:11', 40800000),
(10, 7, '100001', '2017-05-09 22:40:02', 10700000),
(11, 8, '100001', '2017-05-09 22:42:23', 41100000),
(12, 9, '100001', '2017-05-09 22:44:47', 4000000),
(13, 12, '100001', '2017-05-09 22:45:56', 192000000),
(14, 14, '100001', '2017-05-09 22:48:33', 47080000),
(15, 16, '100001', '2017-05-09 22:49:21', 58000000),
(16, 9, '100001', '2017-05-10 09:20:19', 6000000);

-- --------------------------------------------------------

--
-- Table structure for table `receive_info`
--

CREATE TABLE `receive_info` (
  `id_receive` int(11) NOT NULL,
  `id_product` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `count` int(11) NOT NULL,
  `cost` bigint(16) NOT NULL,
  `sum` bigint(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

--
-- Dumping data for table `receive_info`
--

INSERT INTO `receive_info` (`id_receive`, `id_product`, `count`, `cost`, `sum`) VALUES
(1, '1902000001', 20, 25000, 500000),
(2, '0103000001', 10, 3000000, 30000000),
(3, '0304000001', 30, 900000, 27000000),
(3, '0304000002', 30, 820000, 24600000),
(3, '0404000001', 30, 90000, 2700000),
(3, '0704000001', 10, 6000000, 60000000),
(4, '0805000001', 10, 1500000, 15000000),
(5, '0606000001', 10, 810000, 8100000),
(5, '0706000001', 10, 2100000, 21000000),
(5, '0806000001', 10, 2500000, 25000000),
(6, '1007000001', 100, 10000, 1000000),
(6, '1007000002', 100, 20000, 2000000),
(6, '1007000003', 100, 10000, 1000000),
(6, '1007000004', 100, 15000, 1500000),
(6, '1107000001', 100, 50000, 5000000),
(6, '1307000001', 50, 200000, 10000000),
(6, '1407000001', 10, 30000, 300000),
(6, '1407000002', 10, 100000, 1000000),
(9, '1710000001', 10, 4000000, 40000000),
(9, '1910000001', 10, 80000, 800000),
(10, '1007000001', 100, 10000, 1000000),
(10, '1007000002', 100, 20000, 2000000),
(10, '1007000003', 50, 10000, 500000),
(10, '1007000004', 50, 20000, 1000000),
(10, '1107000001', 50, 60000, 3000000),
(10, '1307000001', 10, 200000, 2000000),
(10, '1407000001', 10, 20000, 200000),
(10, '1407000002', 10, 100000, 1000000),
(11, '0108000001', 10, 360000, 3600000),
(11, '0108000002', 10, 600000, 6000000),
(11, '0108000003', 10, 1800000, 18000000),
(11, '0208000001', 10, 250000, 2500000),
(11, '0208000002', 10, 1000000, 10000000),
(11, '0508000001', 10, 100000, 1000000),
(12, '2009000001', 10, 100000, 1000000),
(12, '2009000002', 10, 300000, 3000000),
(13, '1812000001', 10, 14000000, 140000000),
(13, '1812000002', 20, 2000000, 40000000),
(13, '1812000003', 10, 1200000, 12000000),
(14, '0114000001', 10, 40000, 400000),
(14, '1514000001', 10, 25000, 250000),
(14, '1514000002', 10, 53000, 530000),
(14, '1514000003', 10, 10000, 100000),
(14, '1614000001', 10, 10000, 100000),
(14, '1614000002', 10, 20000, 200000),
(14, '1614000003', 10, 50000, 500000),
(14, '1714000001', 10, 4500000, 45000000),
(15, '1716000001', 10, 5800000, 58000000),
(16, '2009000003', 20, 300000, 6000000);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `id` varchar(6) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `sex` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date NOT NULL,
  `address` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `credit_card` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `online` tinyint(1) NOT NULL,
  `username` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `id_type` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`id`, `first_name`, `last_name`, `sex`, `birthday`, `address`, `phone`, `credit_card`, `online`, `username`, `password`, `id_type`) VALUES
('100001', 'Dinh', 'Truong', 'Nam', '1997-11-18', 'Viet Nam', '8989', '123123', 1, 'dinhtruong', '123123', 10),
('200001', 'Đinh Thị', 'Anh Thư', 'Nữ', '1997-01-01', 'Viet Nam', '234', '123123', 0, 'dinhvan', '123123', 20),
('300001', 'Dinh', 'Tai', 'Nam', '1997-01-01', 'Viet Nam', '123', '321', 0, 'dinhtai', '123123', 30);

-- --------------------------------------------------------

--
-- Table structure for table `type_product`
--

CREATE TABLE `type_product` (
  `id` int(2) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `type_product`
--

INSERT INTO `type_product` (`id`, `name`) VALUES
(1, 'Áo'),
(2, 'Quần'),
(3, 'Giày'),
(4, 'Dây da'),
(5, 'Mũ'),
(6, 'Kính'),
(7, 'Túi xách'),
(8, 'Đồng hồ'),
(9, 'Gạo'),
(10, 'Rau, củ'),
(11, 'Trái cây'),
(12, 'Sữa'),
(13, 'Thịt'),
(14, 'Cá'),
(15, 'Dầu gội'),
(16, 'Dụng cụ nhà tắm'),
(17, 'Dụng cụ nhà bếp'),
(18, 'Đồ điện tử'),
(19, 'Sách'),
(20, 'Dụng cụ học tập');

-- --------------------------------------------------------

--
-- Table structure for table `type_staff`
--

CREATE TABLE `type_staff` (
  `id` int(2) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `salary` bigint(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `type_staff`
--

INSERT INTO `type_staff` (`id`, `name`, `salary`) VALUES
(10, 'Admin', 0),
(20, 'Giám đốc', 23000000),
(30, 'Quản lý', 18000000),
(40, 'Nhân viên chăm sóc khách hàng', 12000000),
(50, 'Nhân viên kho hàng', 10000000),
(60, 'Nhân viên bán hàng', 10000000),
(70, 'Nhân viên giao hàng', 7000000),
(80, 'Nhân viên coi xe', 5000000),
(90, 'Bảo vệ', 5000000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_bill_staff` (`id_staff`),
  ADD KEY `fk_bill_customer` (`id_customer`);

--
-- Indexes for table `bill_info`
--
ALTER TABLE `bill_info`
  ADD PRIMARY KEY (`id_bill`,`id_product`),
  ADD KEY `fk_bill_info_product` (`id_product`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_customer_district` (`id_district`),
  ADD KEY `fk_customer_rank` (`id_rank`);

--
-- Indexes for table `district`
--
ALTER TABLE `district`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `producer`
--
ALTER TABLE `producer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_product_producer` (`id_producer`),
  ADD KEY `fk_product_type_product` (`id_type`);

--
-- Indexes for table `rank`
--
ALTER TABLE `rank`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `receive`
--
ALTER TABLE `receive`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_receive_producer` (`id_producer`),
  ADD KEY `fk_receive_staff` (`id_staff`);

--
-- Indexes for table `receive_info`
--
ALTER TABLE `receive_info`
  ADD PRIMARY KEY (`id_receive`,`id_product`),
  ADD KEY `fk_receive_info_product` (`id_product`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `fk_staff_type_staff` (`id_type`);

--
-- Indexes for table `type_product`
--
ALTER TABLE `type_product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type_staff`
--
ALTER TABLE `type_staff`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `fk_bill_customer` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `fk_bill_staff` FOREIGN KEY (`id_staff`) REFERENCES `staff` (`id`);

--
-- Constraints for table `bill_info`
--
ALTER TABLE `bill_info`
  ADD CONSTRAINT `fk_bill_info_bill` FOREIGN KEY (`id_bill`) REFERENCES `bill` (`id`),
  ADD CONSTRAINT `fk_bill_info_product` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `fk_customer_district` FOREIGN KEY (`id_district`) REFERENCES `district` (`id`),
  ADD CONSTRAINT `fk_customer_rank` FOREIGN KEY (`id_rank`) REFERENCES `rank` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `fk_product_producer` FOREIGN KEY (`id_producer`) REFERENCES `producer` (`id`),
  ADD CONSTRAINT `fk_product_type_product` FOREIGN KEY (`id_type`) REFERENCES `type_product` (`id`);

--
-- Constraints for table `receive`
--
ALTER TABLE `receive`
  ADD CONSTRAINT `fk_receive_producer` FOREIGN KEY (`id_producer`) REFERENCES `producer` (`id`),
  ADD CONSTRAINT `fk_receive_staff` FOREIGN KEY (`id_staff`) REFERENCES `staff` (`id`);

--
-- Constraints for table `receive_info`
--
ALTER TABLE `receive_info`
  ADD CONSTRAINT `fk_receive_info_product` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `fk_receive_info_receive` FOREIGN KEY (`id_receive`) REFERENCES `receive` (`id`);

--
-- Constraints for table `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `fk_staff_type_staff` FOREIGN KEY (`id_type`) REFERENCES `type_staff` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
