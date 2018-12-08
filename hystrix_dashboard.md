#### Enabling Hystrix Dashboard

* In Day03Client application, add the following dependency to pom.xml

```xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
	<version>2.0.1.RELEASE</version>
</dependency>
```
* In **Day03ClientApplication.java** add **@EnableHystrixDashboard** annotation to the class
* In **application.properties** add the following line

```
management.server.port=8081
```

* Open **http:localhost:8080/hystrix** in the browser
* In the textbox to enter a stream enter **http://localhost:8081/actuator/hystrix.stream**


* Now, access http://localhost:8080/weatherinfo/chennai service from a different browser tab. Bring your NodeJS up and down and access the client service

* Monitor the dashboard
* Hit refresh on the client 20-25 times and monitor the dashboard


