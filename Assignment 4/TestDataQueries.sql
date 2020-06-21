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