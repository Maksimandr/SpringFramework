package shop.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import shop.model.Customer;

import java.util.List;

@Component
public class CustomerDao {

    private final SessionFactoryDao sessionFactoryDao;

    public CustomerDao(SessionFactoryDao sessionFactoryDao) {
        this.sessionFactoryDao = sessionFactoryDao;
    }

    public Customer findById(Long id) {
        try (Session session = sessionFactoryDao.getSession()) {
            session.getTransaction().begin();

            Customer customer = null;
            try {
                customer = session.createNamedQuery("Customer.findById", Customer.class)
                        .setParameter("id", id)
                        .getSingleResult();
            } catch (Exception e) {
                System.out.println("нет такого id!");
            }

            session.getTransaction().commit();
            return customer;
        }
    }

    public List<Customer> findAll() {
        try (Session session = sessionFactoryDao.getSession()) {
            session.getTransaction().begin();

            List<Customer> customerList = session
                    .createNamedQuery("Customer.findAll", Customer.class)
                    .getResultList();

            session.getTransaction().commit();
            return customerList;
        }
    }

    public void deleteById(Long id) {
        try (Session session = sessionFactoryDao.getSession()) {
            session.getTransaction().begin();

            try {
                Customer customer = session.createNamedQuery("Customer.findById", Customer.class)
                        .setParameter("id", id)
                        .getSingleResult();
                session.delete(customer);
            } catch (Exception e) {
                System.out.println("нет такого id!");
            }

            session.getTransaction().commit();
        }
    }

    public void saveOrUpdate(Customer customer) {
        try (Session session = sessionFactoryDao.getSession()) {
            session.getTransaction().begin();

            session.saveOrUpdate(customer);

            session.getTransaction().commit();
        }
    }
}
