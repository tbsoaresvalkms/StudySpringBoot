http://localhost:8080/api/browser/index.html

mvn install

java -jar target/green-dog-delivery-1.0.0-SNAPSHOT.jar

```
<plugin>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-maven-plugin</artifactId>
<configuration>
<executable>true</executable>
</configuration>
</plugin>
```

```
dir /etc/systemd/system

file name.service

[Unit]
Description=Spring Boot
After=syslog.target
[Service]
User=tbsoares
ExecStart=/home/tbsoares/workspace/java/springboot/target/springboot-0.0.1-SNAPSHOT.jar
SuccessExitStatus=143
[Install]
WantedBy=multi-user.target
```

```
systemctl enable name.service
systemctl stop name.service
systemctl start name.service
systemctl status name.service
```

```
mvn spring-boot:run -Drun.arguments="--spring.profiles.active=production"
```