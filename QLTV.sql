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
INSERT INTO SACH VALUES
('MS01', N'Dế mèn phiêu lưu ký', N'Tô Hoài', N'Bộ Giáo dục', 100),
('MS02', N'Rùa và thỏ', 'Jean de La Fontaine', N'NXB Văn học', 100);

--Tạo bảng độc giả
CREATE TABLE KHACH_HANG(
	Ma_Khach_Hang varchar(10) PRIMARY KEY,
	Ten_Khach_hang nvarchar(30),
	Phone varchar(10),
	Email varchar(20)
)
INSERT INTO KHACH_HANG VALUES
('KH01', N'Lê Văn A', '0123456789', 'levana@gmail.com'),
('KH02', N'Nguyễn Thị B', '0987654321', 'nguyenthib@gmail.com');

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
INSERT INTO Phieu_Muon VALUES
('PM01', 'KH02', 'MS01', 2024-3-3, 2024-26-3, 1),
('PM02', 'KH01', 'MS02', 2024-15-5, 2024-26-5, 1);

