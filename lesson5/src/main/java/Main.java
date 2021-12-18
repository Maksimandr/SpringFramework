import dao.ProductDao;
import model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 1. Создайте сущность Product (Long id, String title, int price) и таблицу
 * в базе данных для хранения объектов этой сущности;
 * 2. Создайте класс ProductDao и реализуйте в нем логику выполнения CRUD-операций
 * над сущностью Product (Product findById(Long id), List<Product> findAll(),
 * void deleteById(Long id), Product saveOrUpdate(Product product));
 * 3. * Вшить ProductDao в веб-проект, и показывать товары, лежащие в базе данных.
 * Помните что в таком случае SessionFactory или обертку над ней надо будет делать
 * в виде Spring бина.
 */
public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        ProductDao productDao = new ProductDao(sessionFactory);

        System.out.println(productDao.findById(1L));
        productDao.deleteById(2L);
        productDao.findAll().forEach(System.out::println);
        productDao.saveOrUpdate(new Product(1, "Juice", 50));
        productDao.findAll().forEach(System.out::println);
    }
}
