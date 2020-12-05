# Echoserver
A simple Spring Boot HTTP echo server that echos detailed information about the current HTTP request. Start the server using Maven:

````shell
mvn spring-boot:run
````
Then issue a request, for example with `curl`:
```shell
curl http://localhost:8080/
```
which will yield a result like this:
```json
{
  "protocol": "HTTP/1.1",
  "parameters": {},
  "cookies": "null",
  "method": "GET",
  "body": "",
  "server": "Renss-MacBook-Pro.local/127.0.0.1",
  "path": "/",
  "headers": {
    "host": "localhost:8080",
    "user-agent": "curl/7.64.1",
    "accept": "*/*"
  }
}
```
## Docker
This project is also a showcase for building Docker images using different approaches.

### Docker
Build the container image using `docker build` and the `Dockerfile` provided in the project root:
```shell
docker build -t verhage/echoserver:docker .
```

### Spring Boot
Build the container image using the Spring Boot Maven plugin:
```shell
mvn spring-boot:build-image
```

### Jib
Build the container image using Google's Jib:
```shell
mvn jib:dockerBuild
```
