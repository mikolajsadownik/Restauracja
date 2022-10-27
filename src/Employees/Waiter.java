package Employees;

public class Waiter extends Employee {

    private String identifier;

    public Waiter(String name, String surname, Integer phoneNumber) {
        super(name, surname, phoneNumber);
        this.identifier = "wt";
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }
}
