#!/bin/bash

sudo yum update -y
sudo yum upgrade

echo "Installing Java 17"
sudo yum install java-17-amazon-corretto -y
java -version

echo "Install Docker engine"
sudo yum install docker -y
usermod -aG docker ec2-user
sudo systemctl enable docker

echo "Install git"
sudo yum install -y git