# Getting Started

## IDE configuration

- Intellij

Settings->Editor->Code Style->Java->Schema

Import the following xml

https://raw.githubusercontent.com/google/styleguide/gh-pages/intellij-java-google-style.xml

## Deployment
Set up mongo db example:
> docker run -p27017:27017 -e'MONGO_INITDB_ROOT_USERNAME=admin' -e'MONGO_INITDB_ROOT_PASSWORD=admin' mongo

- To release a version you should specify at manual job the variables 
    - DEV_VER
    - RELEASE_VER
  
  example
>  RELEASE_VER 1.2.2 DEV_VER 1.2.3-SNAPSHOT

- Push an image to docker registry

> mvn jib:build

- Pull image
> docker pull 192.168.1.90:5000/ditect-service:latest

- Container environment variables
    -   DB_HOST
    -   DB_USER
    -   DB_PASS
    -   MNGM_PORT
    
### Dev env

At 192.168.1.46 path
> /home/user/ditect_dev

#### Identity Manager - Keycloak

http://192.168.1.46:8082/

see configuration at deploy/keycloak-compose.yml
