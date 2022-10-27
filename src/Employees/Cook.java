package Employees;

import Employees.Employee;

public class Cook extends Employee {
    private String indentifier = "cc";

    public Cook(String name, String surname, int phoneNumber) {
        super(name, surname, phoneNumber);
        this.indentifier = "cc";

    }

    @Override
    public String getIdentifier() {
        return super.getIdentifier();
    }
}
