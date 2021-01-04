USE [TestData]
GO

INSERT INTO [dbo].[Job]
	([jobId]
	,[datePosted]
	,[jobDescription]
	,[jobTitle])
VALUES
	('1','11/11/2021','Description','Teacher'),
	('2','11/11/2021','Description','Police')
GO


INSERT INTO [dbo].[AppUser]
	([jobId]
	,[email]
	,[isadmin]
	,[name]
	,[password]
	,[username])
VALUES
	('1','Test@Test.com',1,'Test','1234','Test'),
	('2','Test2@Test.com',1,'Test2','1234','Test2')
GO


