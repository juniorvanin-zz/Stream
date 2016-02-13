#!/bin/bash
sudo apt-get update
sudo apt-get install curl
curl -fsSL https://get.docker.com/ | sh
docker run hello-world
docker run -it ubuntu bash
