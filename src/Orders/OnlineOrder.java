package Orders;

import KitchenAndMain.MenuItem;

import java.util.ArrayList;

public class OnlineOrder extends Order {
    String address;
    int waitTime;
    int prio = 2;

    public OnlineOrder(ArrayList<MenuItem> certainOrder,String address) {
        super(certainOrder);
        this.address = address;
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
        return "Zamównienie na miejscu, adres : " + address + ",nr zamówienia: " + getOrderNumber() +
                " cena zamówienia: " + priceOfOrder() + ", czas złożenia zamówienia " + super.date ;
    }

}
