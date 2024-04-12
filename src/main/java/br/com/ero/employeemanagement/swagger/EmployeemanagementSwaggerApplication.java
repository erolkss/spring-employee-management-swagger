package br.com.ero.employeemanagement.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class EmployeemanagementSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagementSwaggerApplication.class, args);
	}

}
