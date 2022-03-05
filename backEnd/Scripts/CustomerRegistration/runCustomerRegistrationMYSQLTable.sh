winpty docker exec -it mysqldb bash
mysql -u root -p

USE CustomersRegistrationDB
CREATE TABLE IF NOT EXISTS customers (
    -> firstName varchar(36),
    -> lastName varchar(36),
    -> email varchar(100) PRIMARY KEY NOT NULL,
    -> password varchar(36)
    -> );
