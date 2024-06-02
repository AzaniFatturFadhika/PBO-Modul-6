-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 02, 2024 at 04:35 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pegawai`
--

-- --------------------------------------------------------

--
-- Table structure for table `r_pegawai`
--

CREATE TABLE `r_pegawai` (
  `id` varchar(12) NOT NULL,
  `nip` varchar(20) DEFAULT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `sex` enum('P','L') DEFAULT NULL,
  `hp` varchar(14) DEFAULT NULL,
  `jabatan` varchar(20) DEFAULT NULL,
  `alamat` varchar(30) DEFAULT NULL,
  `kota` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `r_pegawai`
--

INSERT INTO `r_pegawai` (`id`, `nip`, `nama`, `sex`, `hp`, `jabatan`, `alamat`, `kota`) VALUES
('001', '001', 'Ahmad', 'L', '081234567890', 'Manager', 'Jl. Kenangan No. 12', 'Jakarta'),
('002', '002', 'Budi', 'L', '081234567891', 'Staff', 'Jl. Ketenaran No. 34', 'Bandung'),
('003', '003', 'Citra', 'P', '081234567892', 'Senior Staff', 'Jl. Sudirman No. 3', 'Surabaya'),
('004', '004', 'Dewi', 'P', '081234567893', 'Assistant Manager', 'Jl. Jenderal Suedirman No. 9', 'Medan'),
('005', '005', 'Eko', 'L', '081234567894', 'Manager', 'Jl. Timur Raya No. 1', 'Yogyakarta'),
('006', '006', 'Fitri', 'P', '081234567895', 'Staff', 'Jl. Soekarno No. 3', 'Semarang'),
('007', '007', 'Gunawan', 'L', '081234567896', 'Senior Staff', 'Jl. Tunara No. 9', 'Makassar'),
('008', '008', 'Hani', 'P', '081234567897', 'Assistant Manager', 'Jl. Diponegoro No. 8', 'Palembang'),
('009', '009', 'Iwan', 'L', '081234567898', 'Manager', 'Jl. Selomerto No. 9', 'Denpasar'),
('010', '010', 'Joko', 'L', '081234567899', 'Staff', 'Jl. Teraga No. 10', 'Malang'),
('011', '011', 'Kartika', 'P', '081234567900', 'Senior Staff', 'Jl. Pasar Ibu No. 11', 'Pontianak'),
('012', '012', 'Lina', 'P', '081234567901', 'Assistant Manager', 'Jl. Sudirman No. 12', 'Balikpapan'),
('013', '013', 'Mulyadi', 'L', '081234567902', 'Manager', 'Jl. Panaraga No. 13', 'Batam'),
('014', '014', 'Nina', 'P', '081234567903', 'Staff', 'Jl. Padang Paran No. 14', 'Padang'),
('015', '015', 'Oka', 'L', '081234567904', 'Senior Staff', 'Jl. Banjarmasin No. 15', 'Banjarmasin'),
('016', '016', 'Putri', 'P', '081234567905', 'Assistant Manager', 'Jl. Samarinda No. 16', 'Samarinda');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `r_pegawai`
--
ALTER TABLE `r_pegawai`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
