DROP DATABASE IF EXISTS products;
CREATE DATABASE products CHARACTER SET UTF8mb4 COLLATE utf8mb4_bin;

USE products;

CREATE TABLE IF NOT EXISTS products (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(200) NOT NULL,
description VARCHAR(200) NOT NULL,
price DECIMAL(5,2) NOT NULL,
picture VARCHAR(500) NOT NULL,
PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO products (name, description, price, picture) VALUES("Logitech G PRO X Wireless", "Mause von Logitech", "98.99", "https://cdn.pixabay.com/photo/2021/04/07/16/12/logitech-g-pro-x-superlight-6159548__340.jpg");
INSERT INTO products (name, description, price, picture) VALUES("NVIDIA GEFORCE RTX 2080", "Grafikkarte von Nvidia", "850", "https://cdn.pixabay.com/photo/2020/06/07/00/07/computer-5268574__340.jpg");
INSERT INTO products (name, description, price, picture) VALUES("Ryzen 3 1200", "CPU von AMD", "250", "https://cdn.pixabay.com/photo/2018/07/08/10/49/ryzen-3523675__340.jpg");
INSERT INTO products (name, description, price, picture) VALUES("Apple IPhone 11 Pro Max", "Iphone von Apple", "800", "https://cdn.pixabay.com/photo/2020/04/10/00/13/iphone-pro-max-5023497__340.jpg");
INSERT INTO products (name, description, price, picture) VALUES("Sony alpha 7", "Kamera von Sony", "650", "https://cdn.pixabay.com/photo/2020/02/09/15/38/camera-4833561__340.jpg");
INSERT INTO products (name, description, price, picture) VALUES("Kopfhörer", "Kopfhörer", "80", "https://pixabay.com/de/photos/kopfh%c3%b6rer-musik-audio-3683983/");
