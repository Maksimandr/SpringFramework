package shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "select p from Product p"),
        @NamedQuery(name = "Product.findById", query = "select p from Product p where p.id = :id")
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private Integer cost;

    @ManyToMany
    @JoinTable(
            name = "customers_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Customer> customerList;

    public Product(long id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public String info() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", customerList=" + customerList.stream().map(Customer::getName).collect(Collectors.toList()) +
                '}';
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }
}
