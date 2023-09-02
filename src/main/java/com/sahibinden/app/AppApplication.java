package com.sahibinden.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// swaggert için kullanılacak URL
//http://localhost:8080/swagger-ui/index.html/

@OpenAPIDefinition(
		servers = @Server(url = "/", description = "Default Server URL"),
		info = @Info(
				title = "Demo",
				version = "1.0.0",
				description = "Demo APIs"
		)
)
@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
