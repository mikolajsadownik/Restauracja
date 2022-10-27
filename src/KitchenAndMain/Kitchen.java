package KitchenAndMain;
import Employees.Cook;
import Orders.Order;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Kitchen {
    public static Comparator<Order> comparator = (order1, order2) -> {
        if (order1.getPrio() < order2.getPrio()) return -1;
        if (order1.getPrio() > order2.getPrio()) return 1;
        if (order1.getOrderNumber() < order2.getOrderNumber()) return -1;
        if (order1.getOrderNumber() > order2.getOrderNumber()) return 1;
        return 0;
    };
    ArrayList<Cook> listOfCooks;
    PriorityQueue<Order> orderPriorityQueue;
    ArrayList<Order> completedOrders;


    public Kitchen(PriorityQueue<Order> orderPriorityQueue, ArrayList<Cook> listOfCooks, ArrayList<Order> completedOrders) {
        this.orderPriorityQueue = orderPriorityQueue;
        this.listOfCooks = listOfCooks;
        this.completedOrders = completedOrders;
    }
    public void takeOrder(Order order) {
        synchronized (orderPriorityQueue) {
            orderPriorityQueue.add(order);
            System.out.println("Dodano zamówienie do kuchni");
            orderPriorityQueue.notify();
        }
    }
    public void cook() {
        while (true) {
            if (listOfCooks.isEmpty())
                System.out.println("Nie można rozpocząć pracy kuchni, brak kucharzy");
            else {
                Order currentOrder;
                synchronized (orderPriorityQueue) {
                    while (orderPriorityQueue.isEmpty()) {
                        try {
                            orderPriorityQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    currentOrder = orderPriorityQueue.poll();
                }
                //
                    for (MenuItem menuItem : currentOrder.getCertainOrder()) {
                        try {

                            Thread.sleep(30_000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    completedOrders.add(currentOrder);
                    System.out.println("Przygotowano zamówienie nr: " + currentOrder.getOrderNumber());
                }
            }
        }
    }






