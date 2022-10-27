package KitchenAndMain;

public interface MenuInterface {

    public void removeItem(int positionOfItem);
    public void showEveryMenuItem();
    public void showOneMenuItem(int positionOfItem);
    public void changeAavailability(int positionOfItem);
    public void saveMenuToFile(String newFileName);
    public void readMenuFromFile(String fileToRead);
    public int getMenuSize();





}
