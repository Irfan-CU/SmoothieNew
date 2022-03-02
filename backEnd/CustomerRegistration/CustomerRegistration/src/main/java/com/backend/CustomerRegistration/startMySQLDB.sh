docker run -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=CustomersRegistrationDB mysql
docker cp CustomersRegistrationDB.sql mysqldb:/
winpty docker exec -it mysqldb bash
mysql -u root -p
CREATE DATABASE CustomersRegistrationDB;
USE CustomersRegistrationDB;
SOURCE CustomersRegistrationDB.sql


