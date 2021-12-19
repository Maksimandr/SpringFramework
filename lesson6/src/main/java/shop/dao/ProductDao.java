package shop.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import shop.model.Product;

import java.util.List;

@Component
public class ProductDao {

    private final SessionFactoryDao sessionFactoryDao;

    public ProductDao(SessionFactoryDao sessionFactoryDao) {
        this.sessionFactoryDao = sessionFactoryDao;
    }

    /**
     * Возвращает по id
     */
    public Product findById(Long id) {
        try (Session session = sessionFactoryDao.getSession()) {
            session.getTransaction().begin();

            Product product = null;
            try {
                product = session.createNamedQuery("Product.findById", Product.class)
                        .setParameter("id", id)
                        .getSingleResult();
            } catch (Exception e) {
                System.out.println("нет такого id!");
            }

            session.getTransaction().commit();
            return product;
        }
    }

    /**
     * Возвращает весь список
     */
    public List<Product> findAll() {
        try (Session session = sessionFactoryDao.getSession()) {
            session.getTransaction().begin();

            List<Product> productList = session
                    .createNamedQuery("Product.findAll", Product.class)
                    .getResultList();

            session.getTransaction().commit();
            return productList;
        }
    }

    /**
     * Удаляет по id
     */
    public void deleteById(Long id) {
        try (Session session = sessionFactoryDao.getSession()) {
            session.getTransaction().begin();

            try {
                Product product = session.createNamedQuery("Product.findById", Product.class)
                        .setParameter("id", id)
                        .getSingleResult();
                session.delete(product);
            } catch (Exception e) {
                System.out.println("нет такого id!");
            }

            session.getTransaction().commit();
        }
    }

    /**
     * Обновляет по id или сохраняет нового
     */
    public void saveOrUpdate(Product product) {
        try (Session session = sessionFactoryDao.getSession()) {
            session.getTransaction().begin();

            session.saveOrUpdate(product);

            session.getTransaction().commit();
        }
    }
}
