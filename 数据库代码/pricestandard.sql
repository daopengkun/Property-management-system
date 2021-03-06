USE [单位房产管理系统]
GO

/****** Object:  Table [dbo].[PriceStandard]    Script Date: 2016/6/30 12:59:45 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[PriceStandard](
	[PSno] [char](20) NOT NULL,
	[WaterPrice] [float] NOT NULL,
	[ElectricityPrice] [float] NOT NULL,
	[NaturalGasPrice] [float] NOT NULL,
	[StartTime] [char](8) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[PSno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

