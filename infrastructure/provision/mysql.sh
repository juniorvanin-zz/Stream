sudo apt-get update
sudo apt-get install -y mysql-server

#Ask for user password
sudo echo "[mysqld]" > /etc/mysql/conf.d/allow_external.cnf
sudo echo " bind-address = 0.0.0.0" >> /etc/mysql/conf.d/allow_external.cnf

sudo service mysql restart

mysqladmin -u root -p create stream_schema

mysql -u root -p -e "SHOW DATABASES"

mysql -u root -p -e "DELETE FROM mysql.user where user=''; FLUSH PRIVILEGES"

mysql -u root -p -e "GRANT ALL PRIVILEGES ON stream_schema.* TO 'stream'@'%' IDENTIFIED BY 'streamsecret';"

mysql -u stream -p stream_schema -e 'select database(), user()'


