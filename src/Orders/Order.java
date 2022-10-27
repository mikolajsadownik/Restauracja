package Orders;

import KitchenAndMain.MenuItem;

import java.time.Instant;
import java.util.*;

public class Order {
    private int prio = 3;
    private int orderNumber;
    Date date;
    ArrayList<MenuItem> certainOrder = new ArrayList<MenuItem>();

    public Order(ArrayList<MenuItem> certainOrder) {
        this.certainOrder = certainOrder;
    }

//    public void setMenu(Menu menuForOrder){
//        this.menuForOrder = menuForOrder;
//    }
    public void addItemsToOrder(int orderAmount, MenuItem menuItem) {
        for (int i = 0; i < orderAmount; i++)
            certainOrder.add(menuItem);

    }

    public void setTimeOfOrder(Date date) {
        this.date = date;
    }

    public void showAllItems() {
        for (MenuItem menuItem : certainOrder) {
            System.out.println(menuItem.getName() + " " + menuItem.getPrice() + "zł");
        }
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double priceOfOrder() {
        double price = 0;
        for (MenuItem menuItem : certainOrder) {
            price += menuItem.getPrice();
        }
        return price;
    }

    public ArrayList<MenuItem> getCertainOrder() {
        return certainOrder;
    }

    public int AmountOfMeals() {
        return this.certainOrder.size();
    }
    public int getPrio() {
        return prio;
    }
}



