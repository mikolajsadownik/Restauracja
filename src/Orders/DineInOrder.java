package Orders;

import KitchenAndMain.MenuItem;

import java.util.ArrayList;

public class DineInOrder extends Order {
    int tableNumber;
    int prio = 1;
    public DineInOrder(ArrayList<MenuItem> certainOrder,int tableNumber) {
        super(certainOrder);
        this.tableNumber = tableNumber;
    }

//    public double priceOfOrder() {
//        double price = 0;
//        for (MenuItem menuItem : certainOrder) {
//            price += menuItem.getPrice();
//        }
//        return price;
//    }
    public int getPrio() {
        return prio;
    }

    @Override
    public String toString() {
        return "Zamównienie na miejscu, nr stolika: " + tableNumber + ",nr zamówienia: " + getOrderNumber() +
                " cena zamówienia: " + priceOfOrder() + ", czas złożenia zamówienia " + super.date ;
    }
}
