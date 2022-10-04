# Getting Started

## IDE configuration

- Intellij

Settings->Editor->Code Style->Java->Schema

Import the following xml

https://raw.githubusercontent.com/google/styleguide/gh-pages/intellij-java-google-style.xml

## Release a version

### CI
- To release a version you should specify at manual job the variables
  - DEV_VER
  - RELEASE_VER

  example:
>  RELEASE_VER 1.2.2 DEV_VER 1.2.3-SNAPSHOT

### LOCAL

```bash
mvn -B release:prepare -Dusername=$CI_USER -Dpassword=$CI_PASS -DreleaseVersion=$RELEASE_VER -DdevelopmentVersion=$DEV_VER -Darguments="-DskipTests=true"
```

```bash
mvn -B release:perform -Dusername=$CI_USER -Dpassword=$CI_PASS -Darguments="-Dmaven.javadoc.skip=true -Dmaven.deploy.skip=true -DskipTests=true"
```


## Deployment
Set up mongo db example:

```bash
docker run -p27017:27017 -e'MONGO_INITDB_ROOT_USERNAME=admin' -e'MONGO_INITDB_ROOT_PASSWORD=admin' mongo
```

Build the image locally

```bash
mvn compile jib:dockerBuild
```

Run the image

```bash
docker run -e'DB_HOST=your-db-host-or-ip' -e'DB_USER=your-db-user' -e'DB_PASS=your-db-secret' ditect-service:a-tag-name
```

You can access it on http://localhost:8080

- Container environment variables
  -   DB_HOST
  -   DB_USER
  -   DB_PASS
  -   MNGM_PORT


### Docker registry
- Push an image to docker registry

```bash
mvn jib:builds
```

- Pull image

```bash
docker pull 192.168.1.90:5000/ditect-service:latest
```

### Generate Rest api documentation
```bash
mvn clean package
```

The generated documentation located at `./target/generated-docs/api-guide.html`

#### Identity Manager - Keycloak

http://192.168.1.46:8082/

See configuration at `deploy/keycloak-compose.yml`

> ⚠️ Actually it is in a `deployment` repository in `ditect-eu` that is **private**, so thanks a lot for the really helpful docs! \s
