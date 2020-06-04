-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 04 Jun 2020 pada 15.21
-- Versi server: 10.4.8-MariaDB
-- Versi PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ravenclaw`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengeluaran`
--

CREATE TABLE `pengeluaran` (
  `IDPengeluaran` int(50) NOT NULL,
  `Jenis_pengeluaran` varchar(50) NOT NULL,
  `Jumlah_pengeluaran` int(25) NOT NULL,
  `Deskripsi_pengeluaran` text NOT NULL,
  `CreateDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengeluaran`
--

INSERT INTO `pengeluaran` (`IDPengeluaran`, `Jenis_pengeluaran`, `Jumlah_pengeluaran`, `Deskripsi_pengeluaran`, `CreateDate`) VALUES
(1, 'Beli baju', 15000, 'Baju biasaaja', '2020-06-01 15:07:34'),
(2, 'Beli Sayur', 2000, 'Beli sayur bayam', '2020-06-01 15:19:15'),
(3, 'Beli kfc', 57000, 'udah pengen hmm', '2020-06-02 10:30:31'),
(4, 'Bayar Kos', 800000, 'udah tanggalnya hm', '2020-06-02 11:30:33'),
(5, 'Beli Kepala Charger', 50000, 'Rusak yang lama', '2020-06-02 11:40:04'),
(6, 'Beli RAM', 400000, '', '2020-06-02 20:38:12'),
(7, 'Beli Dompet', 250000, 'Untuk mamake', '2020-06-02 20:37:24');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD PRIMARY KEY (`IDPengeluaran`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `pengeluaran`
--
ALTER TABLE `pengeluaran`
  MODIFY `IDPengeluaran` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
