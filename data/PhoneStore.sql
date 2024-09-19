-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost
-- Thời gian đã tạo: Th9 18, 2024 lúc 06:37 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `taytay`
--
CREATE DATABASE IF NOT EXISTS `taytay` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `taytay`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `Email` varchar(255) NOT NULL,
  `TenTaiKhoan` varchar(50) NOT NULL,
  `MatKhau` varchar(50) NOT NULL,
  `MaNV` varchar(10) NOT NULL,
  `MaQuyen` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`Email`, `TenTaiKhoan`, `MatKhau`, `MaNV`, `MaQuyen`) VALUES
('admin@example.com', 'admin', 'Thanh123', 'NV12', 'Q4'),
('baduoc@example.com', 'BaDuocSeller', 'baduoc@123', 'NV3', 'Q2'),
('nhanvien@example.com', 'NhanVien', 'feafe@123', 'NV20', 'Q2'),
('quanly@example.com', 'Quan Ly', 'quanly@123', 'NV9', 'Q1'),
('thanhtu@example.com', 'ThanhTuNH', 'thanhtu@434', 'NV5', 'Q5'),
('tridung@example.com', 'TriDungSeller', 'tridung@fe3', 'NV1', 'Q2'),
('vanhoang@example.com', 'VanHoangAdmin', 'vanhoang@feaf2', 'NV4', 'Q3'),
('vantai@example.com', 'VanTaiNH', 'vantai@1212', 'NV12', 'Q5'),
('yenhan@example.com', 'YenHanPhuBH', 'yenhan@123', 'NV23', 'Q3');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `MaKH` varchar(10) NOT NULL,
  `TenKH` varchar(50) NOT NULL,
  `DiaChi` varchar(100) NOT NULL,
  `SDT` varchar(15) NOT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`MaKH`, `TenKH`, `DiaChi`, `SDT`, `TrangThai`) VALUES
('KH1', 'Trần Văn Hoàng', 'TP HCM', '0123456789', 0),
('KH10', 'Trần Ngọc Hải', 'Kiên Giang', '0905271941', 0),
('KH11', 'Nguyễn Xuân Diệu', 'TP HCM', '0301279552', 0),
('KH12', 'Trần Thanh Thiện', 'Hà Nội', '0123617389', 0),
('KH13', 'Huỳnh Minh Mẫn', 'An Giang', '0389230581', 0),
('KH14', 'Trần Xuân An', 'Long An', '0972136531', 0),
('KH15', 'Nguyễn Thị Xuân', 'TP HCM', '0702571936', 0),
('KH16', 'Huỳnh Anh Thư', 'Bến Tre', '0892383623', 0),
('KH17', 'Trần Thanh Nhã', 'TP HCM', '0702397442', 0),
('KH18', 'Huỳnh Nhựt Trường', 'TP HCM', '0120982736', 0),
('KH19', 'Trần Ngọc Hà', 'TP HCM', '0702843627', 0),
('KH2', 'Nguyễn Thiên Hữu', 'Huế', '0126461589', 1),
('KH20', 'Trần Thị Hoài Anh', 'TP HCM', '0126729137', 0),
('KH21', 'Nguyễn Văn Thắng', 'Kiên Giang', '0723812935', 0),
('KH22', 'Huỳnh Lê Diệu Hân', 'Hà Nội', '0306279178', 1),
('KH3', 'Phan Thanh Tùng', 'Hà Nội', '0952612771', 0),
('KH4', 'Trần Thanh Sơn', 'Hải Phòng', '0120617231', 0),
('KH5', 'Trần Thanh Thái', 'Bến Tre', '0912385524', 1),
('KH6', 'Nguyễn Hồng Nhung', 'Huế', '0967263941', 0),
('KH7', 'Từ Ngọc Cảnh', 'Sóc Trăng', '0306172915', 0),
('KH8', 'Nguyễn Thiên Phụng', 'Vũng Tàu', '0703167293', 0),
('KH9', 'Nguyễn Diệu Ái', 'TP HCM', '0805178293', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employee`
--

CREATE TABLE `employee` (
  `MaNV` varchar(10) NOT NULL,
  `TenNV` text NOT NULL,
  `NgaySinh` date NOT NULL,
  `DiaChi` varchar(100) NOT NULL,
  `SDT` varchar(15) NOT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `employee`
--

INSERT INTO `employee` (`MaNV`, `TenNV`, `NgaySinh`, `DiaChi`, `SDT`, `TrangThai`) VALUES
('NV1', 'Phan Trí Dũng', '1978-04-05', 'Đà Nẵng', '0145647854', 0),
('NV10', 'Nguyễn Thị Hồng Hạnh', '1993-11-29', 'Bến Tre', '01262368193', 0),
('NV100', 'Nguyễn C', '1924-01-01', 'Bình Dương', '0354454813', 0),
('NV11', 'Phan Thị Hồng Trinh', '1993-12-11', 'Nghệ An', '0366227168', 1),
('NV12', 'Thanh dep trai ', '1924-04-26', 'Kiên Giang', '0981578293', 0),
('NV13', 'Lê Công Huynh', '1991-09-12', 'Sóc Trăng', '0977232173', 0),
('NV14', 'Lê Hồng Hoa', '1924-01-13', 'TP HCM', '0805126735', 1),
('NV15', 'Nguyễn Thị My', '1992-12-30', 'Hà Nội', '0703689147', 0),
('NV16', 'Trương Thị Hồng Huệ', '1992-11-28', 'TP HCM', '0825719263', 0),
('NV17', 'Nguyễn Thành Trung', '1992-01-16', 'Thanh Hoá', '0123691368', 0),
('NV18', 'Nguyễn Thị Cẩm Duyên', '1995-11-03', 'TP HCM', '0120984178', 0),
('NV19', 'Lê Thanh Quang', '1995-04-19', 'Huế', '0956146728', 0),
('NV2', 'Trần Văn Hi', '1999-04-05', 'TP HCM', '0123456489', 0),
('NV20', 'Nguyễn Hồ Phương Tây', '1924-07-21', 'thắng kiên', '0702536184', 0),
('NV21', 'Huỳnh Công Thành', '1996-11-20', 'Long An', '0709123175', 0),
('NV22', 'Huỳnh Thị Hồng Hương', '1994-11-27', 'TP HCM', '0912635198', 0),
('NV23', 'Phan Yến Hân', '1996-03-14', 'Bến Tre', '0123671823', 0),
('NV24', 'Trương Thanh Dũng', '1997-10-28', 'Đồng Tháp', '0981237651', 0),
('NV3', 'Nguyễn Thị Hồng Thắm', '1998-04-05', 'Hà Nội', '0128456786', 1),
('NV4', 'Anh Thư', '1999-11-12', 'TP HCM', '01207764668', 0),
('NV5', 'Lê Thanh Tú', '1991-04-11', 'Hải Phòng', '0367756753', 0),
('NV6', 'Nguyễn Hải Âu', '1992-04-24', 'Huế', '0364198226', 0),
('NV7', 'Hoàng Thanh Hùng', '1989-11-13', 'Long An', '0276886265', 0),
('NV8', 'Trịnh Văn Công', '1990-07-16', 'Tiền Giang', '0392656931', 0),
('NV9', 'Dương Thanh Hồng', '1991-12-03', 'Vũng Tàu', '0977268398', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `import`
--

CREATE TABLE `import` (
  `MaPN` varchar(10) NOT NULL,
  `MaNCC` varchar(10) NOT NULL,
  `MaNV` varchar(10) NOT NULL,
  `NgayNhap` date NOT NULL,
  `GioNhap` time NOT NULL,
  `TongTien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `import`
--

INSERT INTO `import` (`MaPN`, `MaNCC`, `MaNV`, `NgayNhap`, `GioNhap`, `TongTien`) VALUES
('PN1', 'NCC2', 'NV1', '2019-04-24', '01:25:08', 296),
('PN10', 'NCC4', 'NV12', '2024-09-11', '07:35:27', 40),
('PN11', 'NCC1', 'NV12', '2024-09-11', '07:48:58', 62.7),
('PN12', 'NCC4', 'NV12', '2024-09-18', '20:24:58', 5.5),
('PN13', 'NCC8', 'NV12', '2024-09-18', '20:27:16', 5.5),
('PN14', 'NCC3', 'NV12', '2024-09-18', '20:34:09', 5),
('PN2', 'NCC3', 'NV1', '2019-04-24', '01:25:23', 276.5),
('PN3', 'NCC5', 'NV12', '2019-04-25', '17:06:52', 100),
('PN4', 'NCC4', 'NV12', '2019-04-26', '02:51:18', 48.8),
('PN5', 'NCC5', 'NV12', '2019-04-26', '17:54:01', 46.9),
('PN6', 'NCC8', 'NV12', '2019-04-26', '17:58:26', 106.9),
('PN7', 'NCC6', 'NV12', '2019-05-01', '14:15:27', 1190),
('PN8', 'NCC1', 'NV12', '2019-05-10', '11:19:10', 119),
('PN9', 'NCC2', 'NV12', '2019-05-10', '11:19:53', 200);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `import_details`
--

CREATE TABLE `import_details` (
  `MaPN` varchar(10) NOT NULL,
  `MaSP` varchar(10) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` float UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `import_details`
--

INSERT INTO `import_details` (`MaPN`, `MaSP`, `SoLuong`, `DonGia`) VALUES
('PN1', 'SP8', 2, 23),
('PN1', 'SP24', 10, 25),
('PN2', 'SP3', 35, 7.9),
('PN3', 'SP1', 5, 20),
('PN4', 'SP14', 1, 5.5),
('PN4', 'SP12', 1, 7.9),
('PN4', 'SP1', 1, 20),
('PN4', 'SP7', 1, 15.4),
('PN5', 'SP15', 1, 5.5),
('PN5', 'SP14', 1, 5.5),
('PN5', 'SP11', 1, 15.9),
('PN5', 'SP1', 1, 20),
('PN6', 'SP10', 1, 23.9),
('PN6', 'SP15', 10, 5.5),
('PN6', 'SP17', 5, 5.6),
('PN7', 'SP21', 100, 8),
('PN7', 'SP22', 10, 39),
('PN8', 'SP16', 10, 11.9),
('PN9', 'SP1', 10, 20),
('PN1', 'SP8', 2, 23),
('PN1', 'SP24', 10, 25),
('PN2', 'SP3', 35, 7.9),
('PN3', 'SP1', 5, 20),
('PN4', 'SP14', 1, 5.5),
('PN4', 'SP12', 1, 7.9),
('PN4', 'SP1', 1, 20),
('PN4', 'SP7', 1, 15.4),
('PN5', 'SP15', 1, 5.5),
('PN5', 'SP14', 1, 5.5),
('PN5', 'SP11', 1, 15.9),
('PN5', 'SP1', 1, 20),
('PN6', 'SP10', 1, 23.9),
('PN6', 'SP15', 10, 5.5),
('PN6', 'SP17', 5, 5.6),
('PN7', 'SP21', 100, 8),
('PN7', 'SP22', 10, 39),
('PN8', 'SP16', 10, 11.9),
('PN9', 'SP1', 10, 20),
('PN1', 'SP8', 2, 23),
('PN1', 'SP24', 10, 25),
('PN2', 'SP3', 35, 7.9),
('PN3', 'SP1', 5, 20),
('PN4', 'SP14', 1, 5.5),
('PN4', 'SP12', 1, 7.9),
('PN4', 'SP1', 1, 20),
('PN4', 'SP7', 1, 15.4),
('PN5', 'SP15', 1, 5.5),
('PN5', 'SP14', 1, 5.5),
('PN5', 'SP11', 1, 15.9),
('PN5', 'SP1', 1, 20),
('PN6', 'SP10', 1, 23.9),
('PN6', 'SP15', 10, 5.5),
('PN6', 'SP17', 5, 5.6),
('PN7', 'SP21', 100, 8),
('PN7', 'SP22', 10, 39),
('PN8', 'SP16', 10, 11.9),
('PN9', 'SP1', 10, 20),
('PN1', 'SP8', 2, 23),
('PN1', 'SP24', 10, 25),
('PN2', 'SP3', 35, 7.9),
('PN3', 'SP1', 5, 20),
('PN4', 'SP14', 1, 5.5),
('PN4', 'SP12', 1, 7.9),
('PN4', 'SP1', 1, 20),
('PN4', 'SP7', 1, 15.4),
('PN5', 'SP15', 1, 5.5),
('PN5', 'SP14', 1, 5.5),
('PN5', 'SP11', 1, 15.9),
('PN5', 'SP1', 1, 20),
('PN6', 'SP10', 1, 23.9),
('PN6', 'SP15', 10, 5.5),
('PN6', 'SP17', 5, 5.6),
('PN7', 'SP21', 100, 8),
('PN7', 'SP22', 10, 39),
('PN8', 'SP16', 10, 11.9),
('PN9', 'SP1', 10, 20),
('PN10', 'SP1', 2, 20),
('PN11', 'SP22', 1, 39),
('PN11', 'SP3', 3, 7.9),
('PN11', 'SP1', 93, 20),
('PN12', 'SP15', 1, 5.5),
('PN13', 'SP14', 1, 5.5),
('PN14', 'SP20', 1, 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `invoice`
--

CREATE TABLE `invoice` (
  `MaHD` varchar(10) NOT NULL,
  `MaNV` varchar(10) NOT NULL,
  `MaKH` varchar(10) NOT NULL,
  `MaKM` varchar(10) NOT NULL,
  `NgayLap` date NOT NULL,
  `GioLap` time NOT NULL,
  `TongTien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `invoice`
--

INSERT INTO `invoice` (`MaHD`, `MaNV`, `MaKH`, `MaKM`, `NgayLap`, `GioLap`, `TongTien`) VALUES
('HD1', 'NV2', 'KH2', 'KM2', '2019-04-18', '22:45:52', 188.9),
('HD10', 'NV23', 'KH16', 'KM1', '2019-04-24', '22:16:58', 329.9),
('HD11', 'NV12', 'KH22', 'KM1', '2019-04-25', '13:20:37', 75.7),
('HD12', 'NV12', 'KH19', 'KM3', '2019-04-26', '17:59:11', 84),
('HD13', 'NV12', 'KH14', 'KM1', '2019-04-26', '18:58:06', 101.2),
('HD14', 'NV12', 'KH19', 'KM3', '2019-05-01', '14:14:27', 975.1),
('HD15', 'NV12', 'KH15', 'KM5', '2019-05-05', '15:12:27', 100.9),
('HD16', 'NV12', 'KH1', 'KM4', '2019-05-10', '11:21:12', 400),
('HD17', 'NV12', 'KH15', 'KM1', '2024-09-11', '07:35:27', 63),
('HD18', 'NV12', 'KH14', 'KM1', '2024-09-11', '07:36:14', 25),
('HD19', 'NV12', 'KH12', 'KM5', '2024-09-11', '07:48:58', 537.75),
('HD2', 'NV1', 'KH1', 'KM1', '2019-04-18', '23:15:36', 105),
('HD20', 'NV12', 'KH17', 'KM1', '2024-09-18', '16:25:14', 622.7),
('HD21', 'NV12', 'KH1', 'KM1', '2024-09-18', '16:40:14', 23.7),
('HD22', 'NV12', 'KH13', 'KM1', '2024-09-18', '20:11:14', 31.6),
('HD23', 'NV12', 'KH13', 'KM1', '2024-09-18', '20:11:14', 78),
('HD24', 'NV12', 'KH10', 'KM1', '2024-09-18', '20:22:34', 87),
('HD25', 'NV12', 'KH13', 'KM1', '2024-09-18', '20:24:58', 39),
('HD26', 'NV12', 'KH14', 'KM1', '2024-09-18', '20:27:16', 11.9),
('HD27', 'NV12', 'KH14', 'KM1', '2024-09-18', '20:27:16', 35.9),
('HD28', 'NV12', 'KH10', 'KM1', '2024-09-18', '23:04:50', 22.4),
('HD3', 'NV1', 'KH1', 'KM1', '2019-04-19', '18:44:34', 10.4),
('HD4', 'NV1', 'KH1', 'KM1', '2019-04-21', '12:13:48', 60),
('HD5', 'NV15', 'KH1', 'KM1', '2019-04-24', '03:18:01', 31.6),
('HD6', 'NV15', 'KH7', 'KM1', '2019-04-24', '03:21:35', 174.6),
('HD7', 'NV15', 'KH13', 'KM1', '2019-04-24', '03:22:30', 81),
('HD8', 'NV15', 'KH3', 'KM1', '2019-04-24', '11:29:50', 17.4),
('HD9', 'NV15', 'KH12', 'KM1', '2019-04-24', '21:43:30', 43.9);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `invoice_details`
--

CREATE TABLE `invoice_details` (
  `MaHD` varchar(10) NOT NULL,
  `MaSP` varchar(10) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `invoice_details`
--

INSERT INTO `invoice_details` (`MaHD`, `MaSP`, `SoLuong`, `DonGia`) VALUES
('HD2', 'SP6', 10, 6.5),
('HD2', 'SP1', 2, 20),
('HD1', 'SP1', 1, 20),
('HD3', 'SP4', 1, 3.9),
('HD3', 'SP6', 1, 6.5),
('HD1', 'SP2', 10, 8.2),
('HD1', 'SP3', 11, 7.9),
('HD4', 'SP1', 3, 20),
('HD5', 'SP23', 1, 19.9),
('HD5', 'SP4', 3, 3.9),
('HD6', 'SP4', 1, 3.9),
('HD6', 'SP3', 1, 7.9),
('HD6', 'SP8', 5, 23),
('HD6', 'SP10', 2, 23.9),
('HD7', 'SP10', 1, 23.9),
('HD7', 'SP12', 2, 7.9),
('HD7', 'SP16', 3, 11.9),
('HD7', 'SP17', 1, 5.6),
('HD8', 'SP15', 1, 5.5),
('HD8', 'SP16', 1, 11.9),
('HD9', 'SP10', 1, 23.9),
('HD9', 'SP1', 1, 20),
('HD10', 'SP13', 1, 7.9),
('HD10', 'SP5', 10, 25.7),
('HD10', 'SP6', 10, 6.5),
('HD11', 'SP1', 1, 20),
('HD11', 'SP10', 1, 23.9),
('HD11', 'SP11', 2, 15.9),
('HD12', 'SP15', 2, 5.5),
('HD12', 'SP17', 1, 5.6),
('HD12', 'SP12', 1, 7.9),
('HD12', 'SP16', 5, 11.9),
('HD13', 'SP5', 1, 25.7),
('HD13', 'SP6', 1, 6.5),
('HD13', 'SP8', 3, 23),
('HD14', 'SP23', 49, 19.9),
('HD15', 'SP10', 1, 23.9),
('HD15', 'SP1', 2, 20),
('HD15', 'SP18', 1, 24),
('HD15', 'SP19', 1, 13),
('HD16', 'SP1', 20, 20),
('HD2', 'SP6', 10, 6.5),
('HD2', 'SP1', 2, 20),
('HD1', 'SP1', 1, 20),
('HD3', 'SP4', 1, 3.9),
('HD3', 'SP6', 1, 6.5),
('HD1', 'SP2', 10, 8.2),
('HD1', 'SP3', 11, 7.9),
('HD4', 'SP1', 3, 20),
('HD5', 'SP23', 1, 19.9),
('HD5', 'SP4', 3, 3.9),
('HD6', 'SP4', 1, 3.9),
('HD6', 'SP3', 1, 7.9),
('HD6', 'SP8', 5, 23),
('HD6', 'SP10', 2, 23.9),
('HD7', 'SP10', 1, 23.9),
('HD7', 'SP12', 2, 7.9),
('HD7', 'SP16', 3, 11.9),
('HD7', 'SP17', 1, 5.6),
('HD8', 'SP15', 1, 5.5),
('HD8', 'SP16', 1, 11.9),
('HD9', 'SP10', 1, 23.9),
('HD9', 'SP1', 1, 20),
('HD10', 'SP13', 1, 7.9),
('HD10', 'SP5', 10, 25.7),
('HD10', 'SP6', 10, 6.5),
('HD11', 'SP1', 1, 20),
('HD11', 'SP10', 1, 23.9),
('HD11', 'SP11', 2, 15.9),
('HD12', 'SP15', 2, 5.5),
('HD12', 'SP17', 1, 5.6),
('HD12', 'SP12', 1, 7.9),
('HD12', 'SP16', 5, 11.9),
('HD13', 'SP5', 1, 25.7),
('HD13', 'SP6', 1, 6.5),
('HD13', 'SP8', 3, 23),
('HD14', 'SP23', 49, 19.9),
('HD15', 'SP10', 1, 23.9),
('HD15', 'SP1', 2, 20),
('HD15', 'SP18', 1, 24),
('HD15', 'SP19', 1, 13),
('HD16', 'SP1', 20, 20),
('HD2', 'SP6', 10, 6.5),
('HD2', 'SP1', 2, 20),
('HD1', 'SP1', 1, 20),
('HD3', 'SP4', 1, 3.9),
('HD3', 'SP6', 1, 6.5),
('HD1', 'SP2', 10, 8.2),
('HD1', 'SP3', 11, 7.9),
('HD4', 'SP1', 3, 20),
('HD5', 'SP23', 1, 19.9),
('HD5', 'SP4', 3, 3.9),
('HD6', 'SP4', 1, 3.9),
('HD6', 'SP3', 1, 7.9),
('HD6', 'SP8', 5, 23),
('HD6', 'SP10', 2, 23.9),
('HD7', 'SP10', 1, 23.9),
('HD7', 'SP12', 2, 7.9),
('HD7', 'SP16', 3, 11.9),
('HD7', 'SP17', 1, 5.6),
('HD8', 'SP15', 1, 5.5),
('HD8', 'SP16', 1, 11.9),
('HD9', 'SP10', 1, 23.9),
('HD9', 'SP1', 1, 20),
('HD10', 'SP13', 1, 7.9),
('HD10', 'SP5', 10, 25.7),
('HD10', 'SP6', 10, 6.5),
('HD11', 'SP1', 1, 20),
('HD11', 'SP10', 1, 23.9),
('HD11', 'SP11', 2, 15.9),
('HD12', 'SP15', 2, 5.5),
('HD12', 'SP17', 1, 5.6),
('HD12', 'SP12', 1, 7.9),
('HD12', 'SP16', 5, 11.9),
('HD13', 'SP5', 1, 25.7),
('HD13', 'SP6', 1, 6.5),
('HD13', 'SP8', 3, 23),
('HD14', 'SP23', 49, 19.9),
('HD15', 'SP10', 1, 23.9),
('HD15', 'SP1', 2, 20),
('HD15', 'SP18', 1, 24),
('HD15', 'SP19', 1, 13),
('HD16', 'SP1', 20, 20),
('HD2', 'SP6', 10, 6.5),
('HD2', 'SP1', 2, 20),
('HD1', 'SP1', 1, 20),
('HD3', 'SP4', 1, 3.9),
('HD3', 'SP6', 1, 6.5),
('HD1', 'SP2', 10, 8.2),
('HD1', 'SP3', 11, 7.9),
('HD4', 'SP1', 3, 20),
('HD5', 'SP23', 1, 19.9),
('HD5', 'SP4', 3, 3.9),
('HD6', 'SP4', 1, 3.9),
('HD6', 'SP3', 1, 7.9),
('HD6', 'SP8', 5, 23),
('HD6', 'SP10', 2, 23.9),
('HD7', 'SP10', 1, 23.9),
('HD7', 'SP12', 2, 7.9),
('HD7', 'SP16', 3, 11.9),
('HD7', 'SP17', 1, 5.6),
('HD8', 'SP15', 1, 5.5),
('HD8', 'SP16', 1, 11.9),
('HD9', 'SP10', 1, 23.9),
('HD9', 'SP1', 1, 20),
('HD10', 'SP13', 1, 7.9),
('HD10', 'SP5', 10, 25.7),
('HD10', 'SP6', 10, 6.5),
('HD11', 'SP1', 1, 20),
('HD11', 'SP10', 1, 23.9),
('HD11', 'SP11', 2, 15.9),
('HD12', 'SP15', 2, 5.5),
('HD12', 'SP17', 1, 5.6),
('HD12', 'SP12', 1, 7.9),
('HD12', 'SP16', 5, 11.9),
('HD13', 'SP5', 1, 25.7),
('HD13', 'SP6', 1, 6.5),
('HD13', 'SP8', 3, 23),
('HD14', 'SP23', 49, 19.9),
('HD15', 'SP10', 1, 23.9),
('HD15', 'SP1', 2, 20),
('HD15', 'SP18', 1, 24),
('HD15', 'SP19', 1, 13),
('HD16', 'SP1', 20, 20),
('HD17', 'SP18', 1, 24),
('HD17', 'SP22', 1, 39),
('HD18', 'SP20', 5, 5),
('HD19', 'SP10', 75, 23.9),
('HD20', 'SP1', 11, 50),
('HD20', 'SP11', 3, 15.9),
('HD20', 'SP24', 1, 25),
('HD21', 'SP13', 3, 7.9),
('HD22', 'SP3', 4, 7.9),
('HD23', 'SP22', 2, 39),
('HD24', 'SP21', 6, 8),
('HD24', 'SP22', 1, 39),
('HD25', 'SP22', 1, 39),
('HD26', 'SP16', 1, 11.9),
('HD27', 'SP16', 1, 11.9),
('HD27', 'SP18', 1, 24),
('HD28', 'SP17', 4, 5.6);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Kho`
--

CREATE TABLE `Kho` (
  `MaKho` varchar(10) NOT NULL,
  `TenKho` varchar(70) NOT NULL,
  `DiaChi` varchar(200) NOT NULL,
  `SoDienThoai` varchar(20) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `NguoiQuanLy` varchar(50) DEFAULT NULL,
  `TrangThai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `permission`
--

CREATE TABLE `permission` (
  `MaQuyen` varchar(10) NOT NULL,
  `TenQuyen` varchar(20) NOT NULL,
  `ChiTietQuyen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `permission`
--

INSERT INTO `permission` (`MaQuyen`, `TenQuyen`, `ChiTietQuyen`) VALUES
('Q1', 'Quản lý', 'xemsanpham xemloaisanpham xemhoadon quanlynhanvien quanlykhachhang xemphieunhap xemnhacungcap quanlytaikhoan quanlyquyen'),
('Q2', 'Nhân viên Bán hàng', 'quanlybanhang xemsanpham xemloaisanpham xemhoadon xemnhanvien xemkhachhang'),
('Q3', 'Phụ Bán Hàng', 'quanlybanhang xemsanpham xemkhuyenmai xemkhachhang'),
('Q4', 'Admin', 'quanlybanhang quanlynhaphang quanlysanpham quanlyloaisanpham quanlyhoadon quanlykhuyenmai quanlynhanvien quanlykhachhang quanlyphieunhap quanlynhacungcap quanlytaikhoan quanlyquyen'),
('Q5', 'Nhân viên Nhập hàng', 'quanlynhaphang xemsanpham xemloaisanpham xemnhanvien quanlyphieunhap quanlynhacungcap');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `MaSP` varchar(10) NOT NULL,
  `MaLSP` varchar(30) NOT NULL,
  `TenSP` varchar(70) NOT NULL,
  `DonGia` float NOT NULL,
  `SoLuong` int(10) UNSIGNED NOT NULL DEFAULT 1,
  `HinhAnh` varchar(200) NOT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`MaSP`, `MaLSP`, `TenSP`, `DonGia`, `SoLuong`, `HinhAnh`, `TrangThai`) VALUES
('SP1', 'LSP1', 'IPhone X', 50, 174, 'iphone-xr-128gb-red-400x400.jpg', 0),
('SP10', 'LSP1', 'iPhone Xr 256GB', 23.9, 0, 'iphone-xr-256gb-white-400x400.jpg', 0),
('SP101', 'LSP10', 'Iphone X', 10, 10, 'icons8_angle_down_30px.png', 1),
('SP11', 'LSP2', 'OPPO R17 Pro', 15.9, 96, '/Users/m1lt43/Documents/ảnh/832___06/IMG_4817.JPG', 0),
('SP12', 'LSP8', 'Vivo V15', 7.9, 257, 'vivo-v15-quanghai-400x460.jpg', 0),
('SP13', 'LSP6', 'Blackberry Evolve', 7.9, 43, 'blackberry-evolve6xvk3-640.jpg', 0),
('SP14', 'LSP7', 'Huawei Y9 (2019)', 5.5, 38, 'huawei-y9-2019-blue-400x460.jpg', 0),
('SP15', 'LSP2', 'OPPO F7', 5.5, 362, 'oppo-f7-red-mtp-400x460.jpg', 0),
('SP16', 'LSP9', 'Xiaomi Mi 8', 11.9, 49, 'xiaomi-mi-8-1-400x460-400x460.jpg', 0),
('SP17', 'LSP9', 'Xiaomi Redmi Note 6 Pro 64GB', 5.6, 64, 'xiaomi-redmi-note-6-pro-black-1-400x460.jpg', 0),
('SP18', 'LSP3', 'Samsung Galaxy Note 9 512GB', 24, 57, 'samsung-galaxy-note-9-512gb-blue-400x460.jpg', 0),
('SP19', 'LSP7', 'Huawei Mate 20', 13, 44, 'huawei-mate-20-black-400x460.jpg', 0),
('SP2', 'LSP2', 'Oppo A7', 100, 70, 'oppo-a7-400x460.jpg', 0),
('SP20', 'LSP8', 'Vivo Y85', 5, 32, 'vivo-y85-red-docquyen-400x460.jpg', 0),
('SP21', 'LSP8', 'Vivo V11', 8, 124, 'vivo-v11-400x460.jpg', 0),
('SP22', 'LSP1', 'iPhone Xs Max 512GB', 39, 51, 'iphone-xs-max-512gb-gold-400x460.jpg', 0),
('SP23', 'LSP2', 'OPPO Fid X', 19.9, 0, 'oppo-find-x-1-400x460-400x460.jpg', 0),
('SP24', 'LSP1', 'Iphone abc', 25, 19, 'iphone-xr-256gb-white-400x400.jpg', 0),
('SP25', 'LSP1', 'Apple 4566', 42.5, 45, 'huawei-mate-20-black-400x460.jpg', 0),
('SP3', 'LSP5', 'Nokia 8.1', 7.9, 68, 'nokia-81-silver-400x460.jpg', 0),
('SP4', 'LSP4', 'Philips S327', 3.9, 56, 'philips-s327-400-400x460.jpg', 0),
('SP5', 'LSP1', 'iPhone 8 Plus 256GB', 25.7, 167, 'iphone-8-plus-256gb-gold-400x460.jpg', 0),
('SP6', 'LSP5', 'Nokia 6.1 Plus', 6.5, 44, 'nokia-61-plus-3-400x460.jpg', 0),
('SP7', 'LSP2', 'Oppo NEO 3', 15.4, 101, 'oppo-a7-32gb-gold-400x400.jpg', 1),
('SP8', 'LSP7', 'Huawei P30 Pro', 23, 69, 'huawei-p30-pro-1-400x460.jpg', 0),
('SP9', 'LSP3', 'Samsung Galaxy S10+ (512GB)', 29, 57, 'samsung-galaxy-s10-plus-512gb-ceramic-black-400x460.jpg', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `promotion`
--

CREATE TABLE `promotion` (
  `MaKM` varchar(10) NOT NULL,
  `TenKM` varchar(100) NOT NULL,
  `DieuKienKM` float NOT NULL,
  `PhanTramKM` float NOT NULL,
  `NgayBD` date DEFAULT NULL,
  `NgayKT` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `promotion`
--

INSERT INTO `promotion` (`MaKM`, `TenKM`, `DieuKienKM`, `PhanTramKM`, `NgayBD`, `NgayKT`) VALUES
('KM1', 'Không khuyến mãi', 0, 0, '2023-04-01', '2030-04-01'),
('KM2', 'Giảm giá nhân ngày 30/4', 5, 5, '2023-04-28', '2024-05-02'),
('KM3', 'Giảm giá 1/5', 20, 7.5, '2023-04-25', '2024-10-02'),
('KM4', 'Giảm giá tết', 15, 5, '2025-02-24', '2025-04-01'),
('KM5', 'Khuyến mãi xả hàng', 100, 70, '2019-05-05', '2025-05-06');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `supplier`
--

CREATE TABLE `supplier` (
  `MaNCC` varchar(10) NOT NULL,
  `TenNCC` varchar(70) NOT NULL,
  `DiaChi` varchar(100) NOT NULL,
  `SDT` varchar(15) NOT NULL,
  `Fax` varchar(30) DEFAULT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `supplier`
--

INSERT INTO `supplier` (`MaNCC`, `TenNCC`, `DiaChi`, `SDT`, `Fax`, `TrangThai`) VALUES
('NCC1', 'Cty Samsung', 'TP HCM', '0123456789', '4598-8789-8789-7897', 0),
('NCC2', 'Cty Thương Mại Công Nghệ', 'Hà Nội', '0120728815', '3672-1782-3923-6091', 1),
('NCC3', 'Cty Di Động Trường Sơn', 'TP HCM', '0703192738', '2364-2974-2384-2394', 0),
('NCC4', 'Cty Viễn Thông Thành Đạt', 'TP HCM', '0501239237', '9823-6738-6739-6766', 0),
('NCC5', 'Thế Giới Công Nghệ', 'Bình Dương', '0801729329', '1830-7288-8900-7712', 0),
('NCC6', 'Cty TNHH Hoàng Bá', 'Long An', '0303676818', '7623-9812-3876-2834', 1),
('NCC7', 'Cty Di Động Thành Tiến', 'Hà Nội', '0989140736', '1873-1738-8736-4761', 0),
('NCC8', 'Cty Toàn Thắng', 'TP HCM', '0120628918', '8127-9382-1974-2983', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `type_product`
--

CREATE TABLE `type_product` (
  `MaLSP` varchar(10) NOT NULL,
  `TenLSP` varchar(70) NOT NULL,
  `Mota` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `type_product`
--

INSERT INTO `type_product` (`MaLSP`, `TenLSP`, `Mota`) VALUES
('LSP1', 'Apple', 'Các sản phẩm của Apple'),
('LSP10', 'Nokia', 'Sản phẩm của Nokia'),
('LSP2', 'Oppo', 'Camara Selphi cực chất từ Oppo'),
('LSP3', 'SamSung', 'Khuyến mãi lớn từ SamSung'),
('LSP4', 'Phillip', 'Các sản phẩm tuyệt đẹp đến từ phillip'),
('LSP5', 'Nokia', 'Các sản phẩm đến từ thương hiệu Nokia'),
('LSP6', 'Blackbery', 'BlackBery is the best'),
('LSP7', 'Huawei', 'Các sản phẩm đến từ thương hiệu Huawei'),
('LSP8', 'Vivo', 'Các sản phẩm đến từ Vivo'),
('LSP9', 'Xiaomi', 'Các sản phẩm đến từ thương hiệu Xiaomi');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`MaKH`);

--
-- Chỉ mục cho bảng `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`MaNV`);

--
-- Chỉ mục cho bảng `import`
--
ALTER TABLE `import`
  ADD PRIMARY KEY (`MaPN`),
  ADD KEY `MaNCC` (`MaNCC`),
  ADD KEY `MaNV` (`MaNV`);

--
-- Chỉ mục cho bảng `import_details`
--
ALTER TABLE `import_details`
  ADD KEY `MaSP` (`MaSP`),
  ADD KEY `MaPN` (`MaPN`);

--
-- Chỉ mục cho bảng `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`MaHD`),
  ADD KEY `MaNV` (`MaNV`),
  ADD KEY `MaKH` (`MaKH`),
  ADD KEY `MaKM` (`MaKM`);

--
-- Chỉ mục cho bảng `invoice_details`
--
ALTER TABLE `invoice_details`
  ADD KEY `MaSP` (`MaSP`),
  ADD KEY `MaHD` (`MaHD`);

--
-- Chỉ mục cho bảng `Kho`
--
ALTER TABLE `Kho`
  ADD PRIMARY KEY (`MaKho`);

--
-- Chỉ mục cho bảng `permission`
--
ALTER TABLE `permission`
  ADD PRIMARY KEY (`MaQuyen`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`MaSP`),
  ADD KEY `LoaiSP` (`MaLSP`);

--
-- Chỉ mục cho bảng `promotion`
--
ALTER TABLE `promotion`
  ADD PRIMARY KEY (`MaKM`);

--
-- Chỉ mục cho bảng `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Chỉ mục cho bảng `type_product`
--
ALTER TABLE `type_product`
  ADD PRIMARY KEY (`MaLSP`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `import`
--
ALTER TABLE `import`
  ADD CONSTRAINT `import_ibfk_1` FOREIGN KEY (`MaNCC`) REFERENCES `supplier` (`MaNCC`) ON UPDATE CASCADE,
  ADD CONSTRAINT `import_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `employee` (`MaNV`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `import_details`
--
ALTER TABLE `import_details`
  ADD CONSTRAINT `import_details_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `product` (`MaSP`) ON UPDATE CASCADE,
  ADD CONSTRAINT `import_details_ibfk_3` FOREIGN KEY (`MaPN`) REFERENCES `import` (`MaPN`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`MaKH`) REFERENCES `customer` (`MaKH`) ON UPDATE CASCADE,
  ADD CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `employee` (`MaNV`) ON UPDATE CASCADE,
  ADD CONSTRAINT `promotion_ibfk_3` FOREIGN KEY (`MaKM`) REFERENCES `promotion` (`MaKM`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `invoice_details`
--
ALTER TABLE `invoice_details`
  ADD CONSTRAINT `invoice_details_ibfk_1` FOREIGN KEY (`MaHD`) REFERENCES `invoice` (`MaHD`) ON UPDATE CASCADE,
  ADD CONSTRAINT `invoice_details_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `product` (`MaSP`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`MaLSP`) REFERENCES `type_product` (`MaLSP`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
