package KitchenAndMain;

import Employees.*;
import Orders.DineInOrder;
import Orders.OnlineOrder;
import Orders.Order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main extends Thread {
    public static void main(String[] args) throws InterruptedException {


            int counter = 1;
            Cook e1 = new Cook("Michał", "Orzechowski", 555333444);
            DeliveryMan e2 = new DeliveryMan("Bartek", "Głasek", 222111777);
            Waiter e3 = new Waiter("Edward", "Makłowicz", 999000222);
            MenuItem menuItem1 = new MenuItem("Pizza hawajska", "Pizza z sosem pomidorowym, sarem i ananasem", 21.99);
            MenuItem menuItem2 = new MenuItem("Spaghetti", "Makaron z mięsem wołowym, oraz sosem pomidorowym", 23.20);
            MenuItem menuItem3 = new MenuItem("Łosoś", "Łosoś w panierce podawany z pieczonymi ziemniakami ", 17.40);
            MenuItem menuItem4 = new MenuItem("chudy gzik", "bardzo smaczne danie", 18.40);
            MenuItem menuItem5 = new MenuItem("chlebek", "boży chlebek", 1.40);
            Menu meni = new Menu();
            ArrayList<Cook> cooks = new ArrayList<>();
            ArrayList<Waiter> waiters = new ArrayList<>();
            ArrayList<DeliveryMan> deliveryMEN = new ArrayList<>();
            cooks.add(e1);
            waiters.add(e3);
            deliveryMEN.add(e2);

            ArrayList<MenuItem> listForStartingOrders= new ArrayList<>();
            listForStartingOrders.add(menuItem1);
            listForStartingOrders.add(menuItem2);
            listForStartingOrders.add(menuItem3);

            OnlineOrder o1 = new OnlineOrder(listForStartingOrders,"Warszawa");
            OnlineOrder o2 = new OnlineOrder(listForStartingOrders,"Berlin");
            OnlineOrder o3 = new OnlineOrder(listForStartingOrders,"Tokyo");
            DineInOrder o4 = new DineInOrder(listForStartingOrders,12);
            DineInOrder o5 = new DineInOrder(listForStartingOrders,13);
            DineInOrder o6 = new DineInOrder(listForStartingOrders,14);
            DineInOrder o7 = new DineInOrder(listForStartingOrders,15);
            DineInOrder o8 = new DineInOrder(listForStartingOrders,16);
            OnlineOrder o9 = new OnlineOrder(listForStartingOrders,"Odrano-wola");
            OnlineOrder o10 = new OnlineOrder(listForStartingOrders,"Milanówek");

            PriorityQueue<Order> orderPriorityQueue = new PriorityQueue<>(Kitchen.comparator);
            ArrayList<Order> finishedOrders = new ArrayList<>();

            /**robienie startowych zamówień **/

            Date date1 = new Date();
            o1.setTimeOfOrder(date1);
            o1.setOrderNumber(counter);
            counter++;
            o2.setTimeOfOrder(date1);
            o2.setOrderNumber(counter);
            counter++;
            o3.setTimeOfOrder(date1);
            o3.setOrderNumber(counter);
            counter++;
            o4.setTimeOfOrder(date1);
            o4.setOrderNumber(counter);
            counter++;
            o5.setTimeOfOrder(date1);
            o5.setOrderNumber(counter);
            counter++;
            o6.setTimeOfOrder(date1);
            o6.setOrderNumber(counter);
            counter++;
            o7.setTimeOfOrder(date1);
            o7.setOrderNumber(counter);
            counter++;
            o8.setTimeOfOrder(date1);
            o8.setOrderNumber(counter);
            counter++;
            o9.setTimeOfOrder(date1);
            o9.setOrderNumber(counter);
            counter++;
            o10.setTimeOfOrder(date1);
            o10.setOrderNumber(counter);
            counter++;
            /** Koniec preparowania zamówień **/



            ArrayList<Employee> list = new ArrayList<>();
            list.add(e1);
            list.add(e2);
            list.add(e3);

            meni.addItem(menuItem1);
            meni.addItem(menuItem2);
            meni.addItem(menuItem3);
            meni.addItem(menuItem4);
            meni.addItem(menuItem5);

        Kitchen kitchen = new Kitchen(orderPriorityQueue, cooks, finishedOrders);

        /** Rozpoczynanie pracy kuchni **/

        Thread kitchenTh= new Thread(()->{
            kitchen.cook();
        });
        kitchenTh.start();

        /** Dodawanie zamówień do kolejki w kuchni **/

        kitchen.takeOrder(o1);
        kitchen.takeOrder(o2);
        kitchen.takeOrder(o3);
        kitchen.takeOrder(o4);
        kitchen.takeOrder(o5);
        kitchen.takeOrder(o6);
        kitchen.takeOrder(o7);
        kitchen.takeOrder(o8);
        kitchen.takeOrder(o9);
        kitchen.takeOrder(o10);


            while (true) {
                Scanner myObj1 = new Scanner(System.in);
                System.out.println("Co chcesz zrobić? ");
                System.out.println("[0] Zakończ program ");
                System.out.println("[1] Menu ");
                System.out.println("[2] Złóż zamówienie ");
                System.out.println("[3] Pracownicy ");
                System.out.println("[4] Kuchnia ");
                int choice1 = myObj1.nextInt();
                switch (choice1) {
                    case 0 ->{
                        System.exit(0);
                    }
                    case 1 -> {
                        System.out.println("Co chcesz zrobić?");
                        System.out.println("[1] Wyświetl całe menu ");
                        System.out.println("[2] Wyświetl daną pozycję");
                        System.out.println("[3] Usuń pozycję z menu");
                        System.out.println("[4] Dodaj pozycję do menu");
                        System.out.println("[5] Wczytaj menu z pliku");
                        System.out.println("[6] Zapisz menu do pliku");
                        System.out.println("[7] Zmień dostępność danej pozycji z menu ");
                        Scanner myObj2 = new Scanner(System.in);

                        switch (myObj2.nextInt()) {
                            case 1 -> {
                                meni.showEveryMenuItem();

                            }
                            case 2 -> {
                                System.out.println("Podaj numer pozycji ");
                                int input = myObj2.nextInt();
                                meni.showOneMenuItem(input);

                            }
                            case 3 -> {
                                System.out.println("Podaj numer pozycji którą chcesz usunąć");
                                int input = myObj2.nextInt();
                                meni.removeItem(input);

                            }
                            case 4 -> {
                                System.out.println("Podaj nazwę dania ");
                                String name = myObj2.next();
                                System.out.println("Podaj krótki opis ");
                                String description = myObj2.next();
                                System.out.println("Podaj cenę ");
                                double price = myObj2.nextDouble();
                                MenuItem menuItem = new MenuItem(name, description, price);
                                meni.addItem(menuItem);

                            }
                            case 5 -> {
                                System.out.println("Podaj nazwę pliku ");
                                String nameOfFile = myObj2.next();
                                meni.readMenuFromFile(nameOfFile);

                            }
                            case 6 -> {
                                System.out.println("Podaj nazwę pliku do którego chcesz zapisać menu");
                                String nameOfFile = myObj2.next();
                                meni.saveMenuToFile(nameOfFile);

                            }
                            case 7 -> {
                                System.out.println("Podaj numer pozycji z menu której dostępność chcesz zmienić");
                                int positionOfItem = myObj2.nextInt();
                                if (positionOfItem <= meni.counter) {
                                    if (meni.menu.get(positionOfItem).isAvailable) {
                                        System.out.println("Aktualnie " + meni.menu.get(positionOfItem).name + " jest dostępny/a, czy chcesz to zmienić?");
                                        System.out.println("[0] Nie");
                                        System.out.println("[1] Tak");
                                        int anwser = myObj2.nextInt();
                                        if (anwser == 1) {
                                            meni.changeAavailability(positionOfItem);
                                            System.out.println("Zmieniono dostępność");
                                        }
                                        if (anwser == 0) {
                                            meni.changeAavailability(positionOfItem);
                                            System.out.println("Nie zmieniono dostępności");
                                        }
                                    } else {
                                        int anwser = myObj2.nextInt();
                                        System.out.println("Aktualnie " + meni.menu.get(positionOfItem).name + " jest niedostępny/a, czy chcesz to zmienić?");
                                        if (anwser == 1) {
                                            meni.changeAavailability(positionOfItem);
                                            System.out.println("Zmieniono dostępność");
                                        }
                                        if (anwser == 0) {
                                            meni.changeAavailability(positionOfItem);
                                            System.out.println("Nie zmieniono dostępności");
                                        }
                                    }
                                } else
                                    System.out.println("Nie ma takiej pozycji");

                            }

                            default -> throw new IllegalStateException("Unexpected value: " + myObj2.nextLine());
                        }
                    }
                    case 2 -> {
                        System.out.println("Wybierz opcję zamówienia");
                        System.out.println("[1] Zamówienie stacjonarne");
                        System.out.println("[2] Zamówienie z dostawą");
                        System.out.println("[3] Losowe zamówienie");
                        Scanner myObj = new Scanner(System.in);
                        int stop = 1;
                        switch (myObj.nextInt()) {
                            case 1 -> {
                                ArrayList<MenuItem> menuItems = new ArrayList<>();
                                while (stop != 2) {
                                    System.out.println("Podaj numer pozycji z menu ");
                                    int position = myObj.nextInt();
                                    System.out.println("Podaj ilość ");
                                    int amount = myObj.nextInt();
                                    for (int i = 0; i < amount; i++) {
                                        if (meni.getMenuItem(position) != null)
                                            menuItems.add(meni.getMenuItem(position));
                                        else
                                            System.out.println("Pozycja niedostępna ");
                                    }
                                    System.out.println("Twój koszyk: ");
                                    for (MenuItem item : menuItems) {
                                        System.out.println(item);
                                    }
                                    System.out.println("Czy chcesz dodać coś jeszcze?");
                                    System.out.println("[1] Tak");
                                    System.out.println("[2] Nie");
                                    stop = myObj.nextInt();
                                }
                                System.out.println("Podaj numer stolika ");
                                int tableNumber = myObj.nextInt();
                                DineInOrder dineInOrder = new DineInOrder(menuItems, tableNumber);
                                dineInOrder.setOrderNumber(counter);
                                counter++;
                                Date date = new Date();
                                dineInOrder.setTimeOfOrder(date);
                                System.out.println("Zamówienie zostało złożone, cena zamówienia: " + dineInOrder.priceOfOrder());
                                kitchen.takeOrder(dineInOrder);





                            }
                            case 2 -> {

                                ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
                                while (stop != 2) {
                                    System.out.println("Podaj numer pozycji z menu ");
                                    int position = myObj.nextInt();
                                    System.out.println("Podaj ilość ");
                                    int amount = myObj.nextInt();
                                    for (int i = 0; i < amount; i++) {
                                        if (meni.getMenuItem(position) != null)
                                            menuItems.add(meni.getMenuItem(position));
                                        else
                                            System.out.println("Pozycja niedostępna ");
                                    }
                                    System.out.println("Twój koszyk: ");
                                    for (MenuItem item : menuItems) {
                                        System.out.println(item);
                                    }

                                    System.out.println("Czy chcesz dodać coś jeszcze?");
                                    System.out.println("[1] Tak");
                                    System.out.println("[2] Nie");
                                    stop = myObj.nextInt();

                                }
                                System.out.println("Podaj adres ");
                                String adress = myObj.next();
                                OnlineOrder onlineOrder = new OnlineOrder(menuItems, adress);
                                onlineOrder.setOrderNumber(counter);
                                counter++;
                                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                Date date = new Date();
                                onlineOrder.setTimeOfOrder(date);


                                kitchen.takeOrder(onlineOrder);

                                System.out.println("Zamówienie zostało złożone, cena zamówienia: " + onlineOrder.priceOfOrder());


                            }
                            case 3 -> {
                                ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
                                int random = (int) (Math.random() * 2);
                                if (random == 0) {
                                    int randomAmount = (int) (Math.random() * 5);
                                    MenuItem randomMenuItem = meni.getMenuItem((int) (Math.random() * meni.getMenuSize()));
                                    for (int i = 0; i < randomAmount; i++) {
                                        if (randomMenuItem != null)
                                            menuItems.add(randomMenuItem);
                                        else
                                            System.out.println("Pozycja niedostępna ");
                                    }

                                    System.out.println("Wylosowałeś zamówienie na miejscu, podaj numer stolika ");
                                    int tableNumber = myObj.nextInt();
                                    System.out.println("Twój koszyk: ");
                                    for (MenuItem item : menuItems) {
                                        System.out.println(item);
                                    }
                                    DineInOrder dineInOrder = new DineInOrder(menuItems, tableNumber);
                                    dineInOrder.setOrderNumber(counter);
                                    counter++;
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                    Date date = new Date();
                                    dineInOrder.setTimeOfOrder(date);


                                    kitchen.takeOrder(dineInOrder);


                                    System.out.println("Zamówienie zostało złożone, cena zamówienia: " + dineInOrder.priceOfOrder());

                                } else {
                                    int randomAmount = (int) (Math.random() * 5);
                                    MenuItem randomMenuItem = meni.getMenuItem((int) (Math.random() * meni.getMenuSize()));
                                    for (int i = 0; i < randomAmount; i++) {
                                        if (randomMenuItem != null)
                                            menuItems.add(randomMenuItem);
                                    }

                                    System.out.println("Wylosowałeś zamówienie online, podaj adres ");
                                    String adress = myObj.next();
                                    System.out.println("Twój koszyk: ");
                                    for (MenuItem item : menuItems) {
                                        System.out.println(item);
                                    }
                                    OnlineOrder onlineOrder = new OnlineOrder(menuItems, adress);
                                    counter++;
                                    System.out.println("Zamówienie zostało złożone, cena zamówienia: " + onlineOrder.priceOfOrder());
                                    Date date = new Date();
                                    onlineOrder.setTimeOfOrder(date);

                                    kitchen.takeOrder(onlineOrder);

                                }
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println("Co chcesz zrobić?");
                        System.out.println("[1] Pokaż wszystkich pracowników");
                        System.out.println("[2] Pokaż wszystkich kucharzy");
                        System.out.println("[3] Pokaż wszystkich dostawców");
                        System.out.println("[4] Pokaż wszystkich kelnerów");
                        System.out.println("[5] Zatrudnij nowego pracownika");
                        System.out.println("[6] Zwolnij pracownika");
                        Scanner myObj = new Scanner(System.in);
                        switch (myObj.nextInt()) {
                            case 1 -> {
                                for (Cook cook : cooks)
                                    System.out.println(cook);
                                for (DeliveryMan deliveryMan : deliveryMEN)
                                    System.out.println(deliveryMan);
                                for (Waiter waiter : waiters)
                                    System.out.println(waiter);
                            }
                            case 2 -> {
                                for (Cook cook : cooks)
                                    System.out.println(cook);

                            }
                            case 3 -> {
                                for (DeliveryMan deliveryMan : deliveryMEN)
                                    System.out.println(deliveryMan);
                            }
                            case 4 -> {
                                for (Waiter waiter : waiters)
                                    System.out.println(waiter);
                            }
                            case 5 -> {
                                System.out.println("Na jakie stanowisko chcesz zatrudnić pracownika?");
                                System.out.println("[1] Kucharz");
                                System.out.println("[2] Kelner");
                                System.out.println("[3] Dostawca");
                                int choice = myObj.nextInt();
                                switch (choice) {
                                    case 1 -> {
                                        System.out.println("Podaj imię pracownika");
                                        String name = myObj.next();
                                        System.out.println("Podaj nazwisko pracownika");
                                        String surname = myObj.next();
                                        System.out.println("Podaj numer telefonu pracownika");
                                        int phoneNumber = myObj.nextInt();
                                        Cook cook = new Cook(name, surname, phoneNumber);
                                        cooks.add(cook);
                                    }
                                    case 2 -> {
                                        System.out.println("Podaj imię pracownika");
                                        String name = myObj.next();
                                        System.out.println("Podaj nazwisko pracownika");
                                        String surname = myObj.next();
                                        System.out.println("Podaj numer telefonu pracownika");
                                        int phoneNumber = myObj.nextInt();
                                        Waiter waiter = new Waiter(name, surname, phoneNumber);
                                        waiters.add(waiter);
                                    }
                                    case 3 -> {
                                        System.out.println("Podaj imię pracownika");
                                        String name = myObj.next();
                                        System.out.println("Podaj nazwisko pracownika");
                                        String surname = myObj.next();
                                        System.out.println("Podaj numer telefonu pracownika");
                                        int phoneNumber = myObj.nextInt();
                                        DeliveryMan deliveryMan = new DeliveryMan(name, surname, phoneNumber);
                                        deliveryMEN.add(deliveryMan);
                                    }
                                }

                            }
                            case 6 -> {
                                System.out.println("Jakiego pracownika chcesz usunąć? Podaj pozycję. ");
                                System.out.println("[1] Kucharz");
                                System.out.println("[2] Kelner");
                                System.out.println("[3] Dostawca");
                                switch (myObj.nextInt()) {
                                    case 1 -> {
                                        int tmp = 1;
                                        for (Cook cook : cooks)
                                            System.out.println("[" + tmp + "] " + cook);

                                        System.out.println("Podaj pozycję kucharza którego chcesz zwolnić ");
                                        int position = myObj.nextInt();
                                        cooks.remove(position - 1);
                                        System.out.println("Pracownik został zwolniony");
                                        if (cooks.isEmpty())
                                            System.out.println("Był to ostatni kucharz");

                                    }
                                    case 2 -> {
                                        int tmp = 1;
                                        for (Waiter waiter : waiters)
                                            System.out.println("[" + tmp + "] " + waiter);

                                        System.out.println("Podaj pozycję kucharza którego chcesz zwolnić ");
                                        int position = myObj.nextInt();
                                        cooks.remove(position - 1);
                                        System.out.println("Pracownik został zwolniony");
                                        if (cooks.isEmpty())
                                            System.out.println("Był to ostatni Kelner");
                                    }
                                    case 3 -> {
                                        int tmp = 1;
                                        for (DeliveryMan deliveryMan : deliveryMEN)
                                            System.out.println("[" + tmp + "] " + deliveryMan);

                                        System.out.println("Podaj pozycję kucharza którego chcesz zwolnić ");
                                        int position = myObj.nextInt();
                                        cooks.remove(position - 1);
                                        System.out.println("Pracownik został zwolniony");
                                        if (cooks.isEmpty())
                                            System.out.println("Był to ostatni Dostawca");
                                    }
                                }

                            }


                        }

                    }
                    case 4 -> {
                        System.out.println("[1] Pokaż zrobione zamówienia ");
                        System.out.println("[2] Pokaż zamówienia oczekujące");
                        int choice = myObj1.nextInt();
                        switch(choice){
                            case 1 -> {
                                for(Order order : finishedOrders)
                                    System.out.println(order);
                            }
                            case 2 ->{
                                for(Order order : orderPriorityQueue)
                                    System.out.println(order);
                            }
                        }
                    }

                    default -> System.out.println("Błedna wartość");

                }
            }

    }
}
