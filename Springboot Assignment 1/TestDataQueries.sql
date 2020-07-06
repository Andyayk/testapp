CREATE DATABASE TestData
GO

USE TestData  
GO  

CREATE TABLE app_user
   (employeeid varchar(25) PRIMARY KEY NOT NULL,  
   username varchar(25) NOT NULL,
   password varchar(25) NOT NULL,
   name varchar(25) NOT NULL,
   email varchar(25) NOT NULL,
   isadmin bit NOT NULL
   )  
GO  

INSERT app_user (employeeid, username, password, name, email, isadmin)  
    VALUES ('1', 'admin1', '1234', 'admin 1', 'admin1@gmail.com', 1),
	('2', 'user1', '1234', 'user 1', 'user1@gmail.com', 0)
GO  

SELECT *
	FROM app_user
GO

DROP TABLE dbo.app_user
GO

DROP DATABASE TestData
GO
