package SpringBoot.dto;

public class Product {
    private int id;
    private String title;
    private float cost;

    public Product(int id, String name, float cost) {
        this.id = id;
        this.title = name;
        this.cost = cost;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
