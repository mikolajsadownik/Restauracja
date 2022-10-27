package Employees;

import java.util.ArrayList;

public class ListOfEmployees {
    private ArrayList<Employee> listOfEmployees = new ArrayList<>();

    public ListOfEmployees(ArrayList<Employee> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    }

    public void addEmployee(Employee employee) {
        listOfEmployees.add(employee);
    }


    public void removeEmployee(int position) {

        int counter = 0;
        if (position < listOfEmployees.size() && position >= 1) {
            String fired = "Zwolniono " + listOfEmployees.get(position);
            listOfEmployees.remove(position);
            System.out.println(fired);
            for (Employee employee : listOfEmployees) {
                if (employee.getClass() == listOfEmployees.get(position).getClass()) {
                    counter++;
                }
            }
            if (counter == 0)
                System.out.println("Zwolniono ostatniego " );
        } else System.out.println("Nie ma takiego pracownika ");

    }

    public void showEmployee(int position) {
        listOfEmployees.get(position);
    }

    public void showEveryEmployee() {
        int counter = 1;
        for (Employee employee : listOfEmployees) {
            System.out.println("[" + counter + "] " + employee);
            counter++;
        }
    }

    public void showAllWaiters() {
        for (Employee employee : listOfEmployees) {
            if (employee.getIdentifier().equals("wt"))
                System.out.println(employee);
        }
    }

    public void showAllDeliveryMans() {

        for (Employee employee : listOfEmployees) {
            if (employee.getIdentifier().equals("dm"))
                System.out.println(employee);
        }
    }

    public void showAllCooks() {

        for (Employee employee : listOfEmployees) {
            if (employee.getIdentifier() == "cc")
                System.out.println(employee);
        }

    }


}





