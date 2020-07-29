-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 29, 2020 at 01:15 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fikri`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id` int(11) NOT NULL,
  `gambar` varchar(25) NOT NULL,
  `judul` varchar(30) NOT NULL,
  `noisbn` varchar(20) NOT NULL,
  `penulis` varchar(25) NOT NULL,
  `penerbit` varchar(30) NOT NULL,
  `tahun` year(4) NOT NULL,
  `stok` int(4) NOT NULL,
  `harga_pokok` int(7) NOT NULL,
  `harga_jual` int(7) NOT NULL,
  `ppn` int(2) NOT NULL,
  `diskon` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id`, `gambar`, `judul`, `noisbn`, `penulis`, `penerbit`, `tahun`, `stok`, `harga_pokok`, `harga_jual`, `ppn`, `diskon`) VALUES
(1, 'dilan.jpg', 'Dilan 1990', '123123124', 'Pidi Baiq', 'Gramedia', 2015, 104, 100000, 88000, 10, 20),
(2, 'manusiasetengahsalmon.jpg', 'Manusia Setengah Salmon', '182189718', 'Raditya Dika', 'Gramedia', 2014, 100, 100000, 110000, 10, 0);

-- --------------------------------------------------------

--
-- Table structure for table `distributor`
--

CREATE TABLE `distributor` (
  `id` int(11) NOT NULL,
  `nama_distributor` varchar(30) NOT NULL,
  `alamat` text NOT NULL,
  `telepon` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `distributor`
--

INSERT INTO `distributor` (`id`, `nama_distributor`, `alamat`, `telepon`) VALUES
(2, 'PT Sejatera', 'Banten', '083112812812');

-- --------------------------------------------------------

--
-- Table structure for table `kasir`
--

CREATE TABLE `kasir` (
  `id` int(11) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` text NOT NULL,
  `hakakses` enum('Admin','Kasir') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kasir`
--

INSERT INTO `kasir` (`id`, `username`, `password`, `nama`, `alamat`, `hakakses`) VALUES
(1, 'fikri', '123', 'Fikri KS', 'Ciledug', 'Admin'),
(2, 'fikri1', '123', 'Fikri Khairul Shaleh', 'Ciledug', 'Kasir');

-- --------------------------------------------------------

--
-- Table structure for table `pasok`
--

CREATE TABLE `pasok` (
  `id` int(11) NOT NULL,
  `id_distributor` int(11) NOT NULL,
  `id_buku` int(11) NOT NULL,
  `jumlah` int(4) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pasok`
--

INSERT INTO `pasok` (`id`, `id_distributor`, `id_buku`, `jumlah`, `tanggal`) VALUES
(1, 2, 1, 10, '2020-02-25');

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `id` int(11) NOT NULL,
  `nota` varchar(11) NOT NULL,
  `id_kasir` int(11) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`id`, `nota`, `id_kasir`, `tanggal`) VALUES
(1, 'TB0001', 2, '2020-02-13'),
(2, 'TB0002', 2, '2020-02-25'),
(3, 'TB0003', 2, '2020-03-03'),
(4, 'TB0004', 2, '2020-05-28'),
(5, 'TB0005', 2, '2020-05-28');

-- --------------------------------------------------------

--
-- Table structure for table `penjualan_detail`
--

CREATE TABLE `penjualan_detail` (
  `id` int(11) NOT NULL,
  `id_penjualan` int(11) NOT NULL,
  `id_buku` int(11) NOT NULL,
  `qty` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penjualan_detail`
--

INSERT INTO `penjualan_detail` (`id`, `id_penjualan`, `id_buku`, `qty`) VALUES
(1, 1, 1, 2),
(2, 2, 1, 1),
(3, 3, 1, 1),
(4, 4, 1, 1),
(5, 5, 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `distributor`
--
ALTER TABLE `distributor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kasir`
--
ALTER TABLE `kasir`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pasok`
--
ALTER TABLE `pasok`
  ADD PRIMARY KEY (`id`),
  ADD KEY `relasi_pasok` (`id_buku`),
  ADD KEY `relasi_pasok1` (`id_distributor`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `relasi_penjualan` (`id_kasir`);

--
-- Indexes for table `penjualan_detail`
--
ALTER TABLE `penjualan_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `relasi_penjualandetail` (`id_buku`),
  ADD KEY `relasi_penjualandetail1` (`id_penjualan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `distributor`
--
ALTER TABLE `distributor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `kasir`
--
ALTER TABLE `kasir`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `pasok`
--
ALTER TABLE `pasok`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `penjualan_detail`
--
ALTER TABLE `penjualan_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pasok`
--
ALTER TABLE `pasok`
  ADD CONSTRAINT `relasi_pasok` FOREIGN KEY (`id_buku`) REFERENCES `buku` (`id`),
  ADD CONSTRAINT `relasi_pasok1` FOREIGN KEY (`id_distributor`) REFERENCES `distributor` (`id`);

--
-- Constraints for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `relasi_penjualan` FOREIGN KEY (`id_kasir`) REFERENCES `kasir` (`id`);

--
-- Constraints for table `penjualan_detail`
--
ALTER TABLE `penjualan_detail`
  ADD CONSTRAINT `relasi_penjualandetail` FOREIGN KEY (`id_buku`) REFERENCES `buku` (`id`),
  ADD CONSTRAINT `relasi_penjualandetail1` FOREIGN KEY (`id_penjualan`) REFERENCES `penjualan` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
