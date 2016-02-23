#!/bin/bash
sudo apt-get update
sudo apt-get install -y software-properties-common python-software-properties
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt-get update
sudo apt-get install -y openjdk-8-jdk
sudo wget http://www.us.apache.org/dist/tomcat/tomcat-8/v8.0.32/bin/apache-tomcat-8.0.32.tar.gz
sudo tar -zxvf apache-tomcat-8.0.32.tar.gz -C /var/local/
sudo mv /var/local/apache-tomcat-8.0.32 /var/local/tomcat8
sudo rm -rf /var/local/tomcat8/webapps/docs/ /var/local/tomcat8/webapps/examples/
sudo cp /home/vagrant/tomcat-users.xml /var/local/tomcat8/conf/tomcat-users.xml
sudo rm /home/vagrant/apache-tomcat-8.0.32.tar.gz /home/vagrant/tomcat-users.xml
sudo sh /var/local/tomcat8/bin/startup.sh
