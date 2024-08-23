CREATE DATABASE QLTV	
USE QLTV
GO

CREATE TABLE QUAN_TRI(
Ma_Admin varchar(20) PRIMARY KEY,
Password varchar(20)
)	
--Thêm tài khoản và mật khẩu đăng nhập
INSERT INTO QUAN_TRI VALUES
('ledaoquyen','12345678')

--Tạo bảng sách
CREATE TABLE SACH(
	Ma_Sach varchar(10) PRIMARY KEY,
	Ten_Sach nvarchar(30),
	Ten_Tac_gia nvarchar(30),
	Nha_xb nvarchar(30),
	So_luong int
)

--Tạo bảng độc giả
CREATE TABLE KHACH_HANG(
	Ma_Khach_Hang varchar(10) PRIMARY KEY,
	Ten_Khach_hang nvarchar(30),
	Phone varchar(10),
	Email varchar(20)
)

--Tạo bảng phiếu mượn
CREATE TABLE Phieu_Muon(
Ma_Phieu_Muon varchar(10) PRIMARY KEY,
Ma_Khach_Hang varchar(10),
Ma_Sach varchar(10),
Ngay_muon datetime,
Ngaytra datetime,
So_luong int,
FOREIGN KEY (Ma_Khach_Hang) REFERENCES KHACH_HANG(Ma_Khach_Hang),
FOREIGN KEY (Ma_Sach) REFERENCES SACH(Ma_Sach)
)
