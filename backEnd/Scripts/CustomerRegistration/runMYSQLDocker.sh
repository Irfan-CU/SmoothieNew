#!/bin/sh
docker run -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=CustomersRegistrationDB mysql