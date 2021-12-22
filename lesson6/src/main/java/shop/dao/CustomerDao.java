package shop.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import shop.model.Customer;
import shop.model.Product;

import java.util.List;

@Component
public class CustomerDao {

    private final SessionFactoryManager sessionFactoryManager;

    public CustomerDao(SessionFactoryManager sessionFactoryManager) {
        this.sessionFactoryManager = sessionFactoryManager;
    }

    public Customer findById(Long id, boolean lazy) {
        try (Session session = sessionFactoryManager.getSession()) {
            session.getTransaction().begin();

            Customer customer = null;
            try {
                customer = session.createNamedQuery("Customer.findById", Customer.class)
                        .setParameter("id", id)
                        .getSingleResult();
                if (!lazy) {
                    customer.getProductList().forEach(Product::getId);
                }
            } catch (Exception e) {
                System.out.println("нет такого id!");
            }

            session.getTransaction().commit();
            return customer;
        }
    }

    public List<Customer> findAll() {
        try (Session session = sessionFactoryManager.getSession()) {
            session.getTransaction().begin();

            List<Customer> customerList = session
                    .createNamedQuery("Customer.findAll", Customer.class)
                    .getResultList();

            session.getTransaction().commit();
            return customerList;
        }
    }

    public void deleteById(Long id) {
        try (Session session = sessionFactoryManager.getSession()) {
            session.getTransaction().begin();

            try {
                session.createQuery("delete from Customer c where c.id = :id")
                        .setParameter("id", id)
                        .executeUpdate();
            } catch (Exception e) {
                System.out.println("нет такого id!");
            }

            session.getTransaction().commit();
        }
    }

    public void saveOrUpdate(Customer customer) {
        try (Session session = sessionFactoryManager.getSession()) {
            session.getTransaction().begin();

            session.saveOrUpdate(customer);

            session.getTransaction().commit();
        }
    }
}
