package shop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 1. Есть класс Product (id, название, цена). Товары хранятся в бине ProductRepository, в виде List<Product>,
 * при старте в него нужно добавить 5 любых товаров.
 * 2. ProductRepository позволяет получить весь список или один товар по id. Создаем бин Cart, в который можно
 * добавлять и удалять товары по id.
 * 3. Написать консольное приложение, позволяющее управлять корзиной.
 * 4. При каждом запросе корзины из контекста, должна создаваться новая корзина.
 */

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);

        var cart1 = context.getBean(Cart.class);
        var cart2 = context.getBean(Cart.class);

        cart1.addProductById(1);
        cart1.addProductById(1);
        cart1.addProductById(1);
        cart1.addProductById(2);
        cart1.addProductById(3);
        cart1.addProductById(10);
        cart1.deleteProductById(1);

        cart2.addProductById(2);
        cart2.addProductById(2);
        cart2.addProductById(3);
        cart2.addProductById(3);
        cart2.addProductById(4);
        cart2.addProductById(10);
        cart2.deleteProductById(1);
        cart2.deleteProductById(2);

        System.out.println(cart1);
        System.out.println(cart2);

        context.close();
    }
}
