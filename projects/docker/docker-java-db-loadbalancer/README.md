
``` shell
mvnc clean package
docker build . -t docker-spring-boot-postgres
docker-compose up  --scale app=4				
```
