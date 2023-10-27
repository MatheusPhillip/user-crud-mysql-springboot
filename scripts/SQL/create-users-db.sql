CREATE DATABASE users_db;

USE users_db;

CREATE TABLE user(
	id	INTEGER AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password TEXT NOT NULL,
    phone VARCHAR(15) NOT NULL
);

INSERT INTO user (first_name, last_name, email, password, phone) VALUES ("Matheus", "Phillip", "matheusphillip@gmail.com", "senha", "8899443322");

SELECT * FROM user;