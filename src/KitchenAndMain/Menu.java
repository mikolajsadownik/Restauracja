package KitchenAndMain;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu implements MenuInterface{
    int counter = 1;
    HashMap<Integer, MenuItem> menu = new HashMap<Integer, MenuItem>();

    public void addItem(MenuItem menuItem) {
        menu.put(counter, menuItem);
        counter++;
    }

    public MenuItem getMenuItem(int positionOfItem) {
        if (positionOfItem > menu.size())
            System.out.println("Nie ma takiej pozycji");
        else {
            if (menu.get(positionOfItem).isAvailable) {
                return menu.get(positionOfItem);
            } else
                System.out.println("[BRAK]" + "-" + menu.get(positionOfItem));
        }
        return null;
    }


    public void removeItem(int positionOfItem) {
        if (positionOfItem > menu.size())
            System.out.println("Nie ma takiej pozycji");
        else {
            for (int i = positionOfItem; i < menu.size(); i++) {
                MenuItem tmp = menu.get(i + 1);
                menu.put(i, tmp);
            }
            menu.remove(menu.size());
            counter--;
        }
    }

    public void showEveryMenuItem() {
        if (menu.isEmpty() == true)
            System.out.println("Menu jest puste :(");
        else
            for (int item : menu.keySet()) {
                if (menu.get(item).isAvailable)
                    System.out.println(item + "-" + menu.get(item));
                else
                    System.out.println(item + "[BRAK]" + "-" + menu.get(item));
            }
    }

    public void showOneMenuItem(int positionOfItem) {
        if (positionOfItem > menu.size())
            System.out.println("Nie ma takiej pozycji");
        else {
            if (menu.get(positionOfItem).isAvailable) {
                System.out.println(menu.get(positionOfItem));
            } else
                System.out.println("[BRAK]" + "-" + menu.get(positionOfItem));
        }
    }

    public void changeAavailability(int positionOfItem) {
        if (menu.get(positionOfItem).isAvailable == true)
            menu.get(positionOfItem).isAvailable = false;
        else
            menu.get(positionOfItem).isAvailable = true;
    }

    public void saveMenuToFile(String newFileName) {
        try {
            FileWriter fileWriter = new FileWriter(newFileName);
            for (int item : menu.keySet()) {
                fileWriter.write(item + "-" + menu.get(item).toString() + '\n');
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMenuFromFile(String fileToRead) {

        ArrayList<String> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileToRead);
            Scanner scanner = new Scanner(fileReader);
            menu.clear();
            counter = 1;
            // czyszczę menu żeby dodać nowe
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            for (String e : list) {
                counter++;
                String[] tmp = e.split("-");
                for (String y : tmp) {
                    MenuItem menuItem = new MenuItem(tmp[1], tmp[2], Double.parseDouble(tmp[3]));
                    menu.put(Integer.parseInt(tmp[0]), menuItem);
                }
            }
            fileReader.close();
            System.out.println("Pomyślnie wczytano menu");
        } catch (IOException e) {
            System.out.println("Nie pliku o takiej nazwie :(");
        }
    }

    public int getMenuSize() {
        return menu.size();
    }

}



