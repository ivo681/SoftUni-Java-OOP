package ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money){
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public void buyProduct(Product product){
        if (this.getMoney() < product.getCost()){
            throw new IllegalStateException(this.getName() + " can't afford " + product.getName());
        }
        this.setMoney(this.getMoney() - product.getCost());
        products.add(product);
        System.out.println(this.getName() + " bought " + product.getName());
    }

    public String getName() {
        return this.name;
    }

    public double getMoney() {
        return this.money;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name.trim();
    }

    public void setMoney(double money) {
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

    @Override
    public String toString() {
        if (this.products.isEmpty()){
            return String.format("%s - Nothing bought", getName());
        } else {
            return String.format(this.getName() + " - " + products.stream().map(Product::getName).collect(Collectors.joining(", ")));
        }
    }
}
