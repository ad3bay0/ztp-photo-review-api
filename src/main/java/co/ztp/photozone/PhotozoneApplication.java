package co.ztp.photozone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PhotozoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotozoneApplication.class, args);
	}

}
