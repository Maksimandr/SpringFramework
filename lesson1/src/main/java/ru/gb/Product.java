package ru.gb;

public class Product {

    private static int count = 0;

    private final int id;
    private String title;
    private int cost;

    public Product() {
        this.id = count++;
        this.title = "";
        for (int i = 0; i < 1 + id / 26; i++) {
            this.title += String.valueOf((char) ((id % 26) + 65));
        }
        this.cost = (id + 1) * 10;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
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
