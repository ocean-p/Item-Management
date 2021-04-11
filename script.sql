USE [master]
GO
/****** Object:  Database [ItemManagement]    Script Date: 4/11/2021 12:27:28 PM ******/
CREATE DATABASE [ItemManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ItemManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\ItemManagement.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'ItemManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\ItemManagement_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [ItemManagement] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ItemManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ItemManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ItemManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ItemManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ItemManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ItemManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [ItemManagement] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [ItemManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ItemManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ItemManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ItemManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ItemManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ItemManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ItemManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ItemManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ItemManagement] SET  ENABLE_BROKER 
GO
ALTER DATABASE [ItemManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ItemManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ItemManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ItemManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ItemManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ItemManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ItemManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ItemManagement] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ItemManagement] SET  MULTI_USER 
GO
ALTER DATABASE [ItemManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ItemManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ItemManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ItemManagement] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ItemManagement] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ItemManagement] SET QUERY_STORE = OFF
GO
USE [ItemManagement]
GO
/****** Object:  Table [dbo].[tblItems]    Script Date: 4/11/2021 12:27:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblItems](
	[itemCode] [varchar](10) NOT NULL,
	[itemName] [nvarchar](50) NULL,
	[unit] [varchar](50) NULL,
	[price] [float] NULL,
	[supplying] [bit] NULL,
	[supCode] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[itemCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblSuppliers]    Script Date: 4/11/2021 12:27:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblSuppliers](
	[supCode] [varchar](10) NOT NULL,
	[supName] [nvarchar](50) NULL,
	[address] [nvarchar](50) NULL,
	[collaborating] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[supCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUsers]    Script Date: 4/11/2021 12:27:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUsers](
	[userID] [varchar](10) NOT NULL,
	[fullName] [nvarchar](50) NULL,
	[password] [varchar](50) NULL,
	[status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblItems] ([itemCode], [itemName], [unit], [price], [supplying], [supCode]) VALUES (N'i2', N'thuốc lá', N'aa', 30000, 1, N's1')
INSERT [dbo].[tblItems] ([itemCode], [itemName], [unit], [price], [supplying], [supCode]) VALUES (N'i3', N'trà sữa', N'aa', 2000, 0, N's3')
INSERT [dbo].[tblItems] ([itemCode], [itemName], [unit], [price], [supplying], [supCode]) VALUES (N'i5', N'kẹo bạc hà', N'ba', 190, 0, N's5')
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N's', N'sdfghjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkl', N'sdfghjkl', 0)
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N's1', N'GS25+', N'35 Bạch Đằng', 1)
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N's2', N'Ministop', N'22 Phú Nhuận', 0)
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N's3', N'Family mart', N'11111111111111111111111111111111111111111', 1)
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N's5', N'The Coffee House', N'2B Nguyễn Ảnh Thủ', 0)
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N's6', N'Galaxy', N'25 Quang Trung', 1)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [status]) VALUES (N'A001', N'Hồng Đại Dương', N'123abc', 1)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [status]) VALUES (N'A002', N'Kim Yung Joon', N'1122def', 0)
ALTER TABLE [dbo].[tblItems]  WITH CHECK ADD FOREIGN KEY([supCode])
REFERENCES [dbo].[tblSuppliers] ([supCode])
GO
USE [master]
GO
ALTER DATABASE [ItemManagement] SET  READ_WRITE 
GO
