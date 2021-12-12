package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductDao {

    SessionFactory sessionFactory;

    public ProductDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ProductDao() {
    }

    public Product findById(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
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

    public List<Product> findAll() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();

            List<Product> productList = session
                    .createNamedQuery("Product.findAll", Product.class)
                    .getResultList();

            session.getTransaction().commit();
            return productList;
        }
    }

    public void deleteById(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
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

    public void saveOrUpdate(Product product) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();

            session.saveOrUpdate(product);

            session.getTransaction().commit();
        }
    }
}
