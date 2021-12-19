package shop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shop.dao.CustomerDao;
import shop.dao.ProductDao;
import shop.service.CustomersProducts;

/**
 * 1. В базе данных необходимо реализовать возможность хранить информацию о покупателях (id, имя)
 * и товарах (id, название, стоимость). У каждого покупателя свой набор купленных товаров;
 * 2. Для обеих сущностей создаете Dao классы. Работу с SessionFactory выносите во вспомогательный класс;
 * 3. * Создаете сервис, позволяющий по id покупателя узнать список купленных им товаров, и по id товара
 * узнавать список покупателей этого товара;
 * 4. ** Добавить детализацию по паре «покупатель — товар»: сколько стоил товар в момент покупки клиентом;
 * ВАЖНО И ОБЯЗАТЕЛЬНО! Dao классы и сервис должны являться Spring бинами (Вам нужен Spring Context без веб части).
 * Контроллеры создавать не надо.
 * ВАЖНО! Выкидываете код по подготовке данных и таблиц, и делаете отдельный скрипт и формируете базу заранее.
 * Покупателей и товары в базу складываете заранее, через код этого делать не надо (лишнее усложнение).
 * SQL-скрипт прикрепите к работе.
 */

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);

        ProductDao productDao = context.getBean(ProductDao.class);
//        System.out.println(productDao.findById(1L, true));
//        System.out.println("------------------------------------");
//        productDao.findAll().forEach(System.out::println);
//        System.out.println("------------------------------------");
//        productDao.deleteById(2L);
//        System.out.println("------------------------------------");
//        productDao.findAll().forEach(System.out::println);

        CustomerDao customerDao = context.getBean(CustomerDao.class);
//        System.out.println(customerDao.findById(1L, true));
//        System.out.println("------------------------------------");
//        customerDao.findAll().forEach(System.out::println);
//        System.out.println("------------------------------------");
//        customerDao.deleteById(2L);
//        System.out.println("------------------------------------");
//        customerDao.findAll().forEach(System.out::println);

        CustomersProducts customersProducts = context.getBean(CustomersProducts.class);
        customersProducts.productsByCustomerId(1L).forEach(System.out::println);
        customersProducts.customersByProductId(1L).forEach(System.out::println);

    }
}
