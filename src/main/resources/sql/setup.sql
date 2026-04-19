USE `order_management`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `product`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
                         `username` varchar(50) NOT NULL,
                         `password` varchar(68) NOT NULL,
                         `enabled` tinyint NOT NULL,
                         PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users`
VALUES
    ('farhan','{noop}nomani',1),
    ('winnie','{noop}chugtai',1),
    ('rayan','{noop}deens',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `username` varchar(50) NOT NULL,
                               `authority` varchar(50) NOT NULL,
                               PRIMARY KEY (`id`),
                               UNIQUE KEY `id_UNIQUE` (`id`),
                               UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
                               CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities`
VALUES
    (null,'farhan','ROLE_ADMIN'),
    (null, 'winnie','ROLE_USER'),
    (null, 'rayan','ROLE_USER'),
    (null, 'farhan','ROLE_USER');

CREATE TABLE `product` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `name` varchar(255) NOT NULL,
                           `description` varchar(1000) DEFAULT NULL,
                           `price` decimal(10,2) NOT NULL,
                           `stock` int NOT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `id_UNIQUE` (`id`)
)
