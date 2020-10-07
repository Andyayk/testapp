CREATE DATABASE TestData
GO

USE TestData  
GO  

CREATE TABLE alien  
   (aid int PRIMARY KEY NOT NULL,  
   aname varchar(25) NOT NULL)  
GO  

-- Standard syntax  
INSERT alien (aid, aname)  
    VALUES (102, 'Anna')  
GO   

-- The basic syntax for reading data from a single table  
SELECT aid, aname  
    FROM alien  
GO  

SELECT *
	FROM alien
GO

CREATE TABLE users
   (id varchar(25) PRIMARY KEY NOT NULL,  
   username varchar(25) NOT NULL,
   password varchar(25) NOT NULL)  
GO  

INSERT users (id, username, password)  
    VALUES (108, 'andy8', '123'),
	(107, 'andy7', '123')
GO  

SELECT *
	FROM users
GO

