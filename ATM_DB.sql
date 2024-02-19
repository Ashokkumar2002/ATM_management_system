CREATE DATABASE IF NOT EXISTS demo;
USE demo;
CREATE TABLE IF NOT EXISTS user (
    customer_id INT PRIMARY KEY NOT NULL,
    username VARCHAR(20),
    pin INT UNIQUE,
    balance INT
);
INSERT INTO user (customer_id, username, pin, balance) VALUES 
(1, "Ashok", 1905, 20000),
(2, "Ravi", 1234, 10000),
(3, "Kavin", 1596, 45000),
(4, "Gowreesh", 3698, 80000);
INSERT INTO user (customer_id, username, pin, balance) VALUES 
(5, "Sara", 2468, 30000),
(6, "Priya", 7890, 60000),
(7, "John", 5678, 70000),
(8, "Emily", 4321, 40000),
(9, "David", 9876, 55000),
(10, "Michael", 6543, 90000);

DELIMITER $$
CREATE PROCEDURE GetNameByPin(IN user_pin INT)
BEGIN
    SELECT username FROM user WHERE pin = user_pin;
END$$
DELIMITER ;
DELIMITER $$
CREATE PROCEDURE GetIdByPin(IN user_pin INT)
BEGIN
    SELECT customer_id FROM user WHERE pin = user_pin;
END$$
DELIMITER ;
SELECT * FROM user;
drop database demo;