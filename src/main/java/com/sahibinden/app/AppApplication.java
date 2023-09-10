package com.sahibinden.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// swaggert için kullanılacak URL
//spring.datasource.url=jdbc:mysql://130.61.142.197:3306/sahibinden?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
//		spring.datasource.username=root
//		spring.datasource.password=qW16182666!!.
//		spring.jpa.hibernate.ddl-auto=update
	//	spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
	//	logging.level.org.springframework.web=DEBUG




//http://localhost:8080/swagger-ui/index.html/                Oracle MySQL Sifre: Ekrem1111

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
