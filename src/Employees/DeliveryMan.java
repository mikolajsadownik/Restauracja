package Employees;

public class DeliveryMan extends Employee {
    private String indentifier;


    public DeliveryMan(String name, String surname, Integer phoneNumber) {
        super(name, surname, phoneNumber);
        this.indentifier = "dm";
    }




    @Override
    public String getIdentifier() {
        return super.getIdentifier();
    }



    }




