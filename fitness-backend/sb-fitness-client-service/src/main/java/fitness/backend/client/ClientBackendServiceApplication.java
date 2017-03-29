package fitness.backend.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ClientBackendServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientBackendServiceApplication.class, args);
	}
}
