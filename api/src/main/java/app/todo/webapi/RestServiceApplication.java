package app.todo.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("app.todo.storage")
@EntityScan("app.todo.storage.entities")
public class RestServiceApplication {
    public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}
}
