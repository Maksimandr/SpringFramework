package SpringRest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Реализуйте корзину на REST API, пока что в виде синглтон бина.
 */
@SpringBootApplication
public class SpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

}
