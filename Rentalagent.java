import java.util.*;

// Separated classes for better structure and readability
class Car {
    private int carNo;
    private String make;
    private String model;
    private int year;
    private double rentalPricePerDay;
    private boolean isAvailable;

    public Car(int carNo, String make, String model, int year, double rentalPricePerDay) {
        this.carNo = carNo;
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalPricePerDay = rentalPricePerDay;
        this.isAvailable = true;
    }

    public int getCarNo() { return carNo; }
    public boolean isAvailable() { return isAvailable; }

    public void rentCar() {
        if (!isAvailable) throw new IllegalStateException("Car is not available");
        isAvailable = false;
    }

    public void returnCar() { isAvailable = true; }
    
    public double calculateRentalCost(int days) {
        return rentalPricePerDay * days;// total cost is calculated using the fixed cost per day and number of days rented
    }
     public void displayCarInfo() {
        System.out.println("Car Registration Number: " + carNo);
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Rental Price Per Day: " + rentalPricePerDay);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("---------------------");
}
}

class Customer {
    private String customerName;
    private int customerId;

    public Customer(String customerName, int customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    public int getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
}

class Rental {
    private Car car;
    private Customer customer;
    private int days;
    private double totalCost;

    public Rental(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
        this.totalCost = car.calculateRentalCost(days);
    }

    public double getTotalCost() { return totalCost; }
}

public class Rentalagent {
    private List<Car> cars = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Rental> rentals = new ArrayList<>();

    public void addCar(Car car) { cars.add(car); }
    public void addCustomer(Customer customer) { customers.add(customer); }

    public Rental rentalCar(int carNo, int customerId, int days) {
        Car selectedCar = null;
        Customer selectedCustomer = null;

        for (Car car : cars) {
            if (car.getCarNo() == carNo && car.isAvailable()) {
                selectedCar = car;
                break;
            }
        }

        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                selectedCustomer = customer;
                break;
            }
        }

        if (selectedCar != null && selectedCustomer != null) {
            selectedCar.rentCar();
            Rental rental = new Rental(selectedCar, selectedCustomer, days);
            rentals.add(rental);
            return rental;
        }
        return null;
    }

    public static void main(String[] args) {
        // Handle Login First
        LoginSystem login = new LoginSystem();
        if (!login.authenticate()) {
            return; // Exit if login fails
        }

        Rentalagent agency = new Rentalagent();
        
        // Creating Car objects correctly
        Car c1 = new Car(11, "Subaru", "Cruiser", 2016, 1200);
        Car c2 = new Car(22, "Toyota", "Corolla", 2018, 1200);
        
        agency.addCar(c1);
        agency.addCar(c2);

        Customer cust1 = new Customer("Charlie", 15);
        agency.addCustomer(cust1);

        Rental r1 = agency.rentalCar(11, 15, 5);
        if (r1 != null) {
            System.out.println("Rental Success! Total Cost: " + r1.getTotalCost());
        }
    }
}

class LoginSystem {
    
    private final String USERNAME = "EILEEN";
    private final String PASSWORD = "1234";
 
    public boolean authenticate() {
        Scanner BSE = new Scanner(System.in);

        int attempts = 3;//allows only 3 trials

        while (attempts > 0) {

            System.out.print("Enter username: ");
            String user = BSE.nextLine();

            System.out.print("Enter password: ");
            String pass = BSE.nextLine();
            if (user.equalsIgnoreCase(USERNAME) && pass.equals(PASSWORD)) {
                System.out.println("Login successful!\n");
                return true;
            } else {
                attempts--;
                System.out.println("Invalid credentials. Attempts left: " + attempts);
            }
        }
        System.out.println("Account locked.");
        return false;
    }

}
