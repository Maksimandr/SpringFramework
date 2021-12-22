package shop.service;

import org.springframework.stereotype.Service;
import shop.dao.CustomerDao;
import shop.dao.ProductDao;
import shop.model.Customer;
import shop.model.Product;

import java.util.List;

@Service
public class CustomersProducts {
    private final CustomerDao customerDao;
    private final ProductDao productDao;

    public CustomersProducts(CustomerDao customerDao, ProductDao productDao) {
        this.customerDao = customerDao;
        this.productDao = productDao;
    }

    public List<Product> productsByCustomerId(Long id) {
        Customer customer = customerDao.findById(id, false);
        return customer.getProductList();
    }

    public List<Customer> customersByProductId(Long id) {
        Product product = productDao.findById(id, false);
        return product.getCustomerList();
    }
}
