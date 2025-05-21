FROM ubuntu:latest
RUN apt-get update && apt-get install -y git vim curl
WORKDIR /root
RUN apt update
RUN apt install -y nodejs npm
RUN apt install -y python3 python3-pip python3-venv
RUN python3 --version
RUN pip3 --version

COPY . /root
