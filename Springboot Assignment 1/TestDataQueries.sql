CREATE DATABASE TestData
GO

USE TestData  
GO  

CREATE TABLE appuser
   (employeeid varchar(25) PRIMARY KEY NOT NULL,  
   username varchar(25) NOT NULL,
   password varchar(25) NOT NULL,
   name varchar(25) NOT NULL,
   email varchar(25) NOT NULL,
   isadmin bit NOT NULL
   )  
GO

CREATE TABLE popularjob
   (id int IDENTITY(1,1) PRIMARY KEY NOT NULL, 
   jobId varchar(25) NOT NULL,
   jobTitle varchar(25) NOT NULL,
   jobDescription varchar(25) NOT NULL,
   datePosted varchar(25) NOT NULL,
   favouriteCount varchar(25) NOT NULL,
   dateRetrieved varchar(25) NOT NULL
   )  
GO 

INSERT appuser (employeeid, username, password, name, email, isadmin)  
    VALUES ('1', 'admin1', '1234', 'admin 1', 'admin1@gmail.com', 1),
	('2', 'user1', '1234', 'user 1', 'user1@gmail.com', 0)
GO

INSERT popularjob (jobId, jobTitle, jobDescription, datePosted, favouriteCount, dateRetrieved)  
    VALUES ('1', 'a', 'b', '2020-12-31', 6, '2020-12-31')
GO  

SELECT *
	FROM appuser
GO

SELECT *
	from popularjob
GO

DROP TABLE dbo.appuser
GO

DROP TABLE dbo.popularjob
GO

DROP DATABASE TestData
GO
