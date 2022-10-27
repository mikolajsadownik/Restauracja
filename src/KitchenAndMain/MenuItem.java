package KitchenAndMain;

import java.awt.Menu;

public class MenuItem {
    String name;
    String description;
    double price;
    boolean isAvailable;

    public MenuItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return name + "-" + description + "-" + price;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
