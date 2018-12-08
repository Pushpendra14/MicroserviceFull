#### Setting up Config Server

* Create a new Spring Boot project say, **MyConfigServer**
* Select **web** and **Config Server** libraries while creating the project
* Add **@EnableConfigServer** annotation to the **MyConfigServerApplication.java**

* Create **bootstrap.properties** file in *resources* folder
* Add the following lines to bootstrap.properties

```
server.port=8000
spring.profiles.active=native
```


#### Setting up Config Client

* Create a new Spring Boot project say, **SaturdayService**
* Select **web** and **Config Client** libraries while creating the project

* Create **bootstrap.properties** file in *resources* folder
* Add the following lines to bootstrap.properties

```
spring.application.name=saturday
spring.cloud.config.uri=http://localhost:8000
welcome=Welcome to Saturday local
```

* Create a HelloController class

```java
@RestController
public class HelloController {

	@Value("${welcome}")
	private String welcome;
	
	@GetMapping("/")
	public String index() {
		return welcome;
	}
}
```
* Run http://localhost:8080/ and observe the message you get


