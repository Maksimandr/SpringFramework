package SpringData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. Создать сущность «Товар» (id, название, стоимость) и соответствующую таблицу в БД.
 * Заполнить таблицу тестовыми данными (20 записей).
 * 2. Сделать RestController позволяющий выполнять следующий набор операции над этой сущностью:
 * получение товара по id [ GET .../app/products/{id} ]
 * получение всех товаров [ GET .../app/products ]
 * создание нового товара [ POST .../app/products ]
 * удаление товара по id.[ GET .../app/products/delete/{id} ]
 * (Замечание: пока делаем немного не по правилам REST API, эта тема будет разбираться на
 * следующих занятиях, поэтому удаление выполняется через http-метод GET, а не DELETE)
 *
 * 3. * К запросу всех товаров добавьте возможность фильтрации по минимальной и максимальной цене
 * (в трех вариантах: товары дороже min цены, товары дешевле max цены, или товары, цена которых
 * находится в пределах min-max).
 */
@SpringBootApplication
public class SpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

}
