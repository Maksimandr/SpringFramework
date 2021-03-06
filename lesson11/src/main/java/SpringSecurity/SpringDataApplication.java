package SpringSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. Создать страницу со списком товаров, на которой можно добавлять позиции и редактировать существующие.
 * На эту страницу должны иметь доступ админы и менеджеры.
 * 2. Создать страницу со списком всех пользователей, к которой имеют доступ только админы.
 * 3. * Добавить роль суперадмина и дать ему возможность создавать новых пользователей и указывать роли существующим.
 */
@SpringBootApplication
public class SpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

}
