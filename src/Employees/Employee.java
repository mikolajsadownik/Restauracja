package Employees;

public class Employee {
    private String name;
    private String surname;
    private Integer phoneNumber;
    private String identifier = "n";

    public Employee(String name, String surname, Integer phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Imię: " + name + " | Nazwisko: " + surname + " | Numer telefonu " + phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getIdentifier() {
        return identifier;
    }
}
