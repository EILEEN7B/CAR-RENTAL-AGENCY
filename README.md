# CAR-RENTAL-AGENCY
this application is used for managing cars,customers and rental transactions within a company, using a user authentication.

##overview
This application allows
 1. customers to be added into the rental system
 2. allows cars to be added into the inventory
 3. calculates the total rental bill of a customer
 4. authenticates the customers- the program gives a user 3 tries to enter the user name and password


    CLASSES INCLUDE
      1.Car Class
   it is the vehicle to be rented from the available collection
   - Tracks availability of the vehicles in the inventory
   - Calculates rental costs based on rental cost per day
   - Displays car information

2. Customer Class
   - Stores customer information
   - takes in customer information

3. Rental Class
   - Represents a rental transaction
   - Links customers with rented cars
   - Calculates total rental costs


 4. Rentalagent Class
   - this is the main class
   - Handles car inventory and customer lists
   - Processes rental transactions
   - Entry point with main() method

 5. LoginSystem Class
   - Handles user authentication
   - Implements 3-attempt limit
   - Prevents unauthorized access


     The test data used include

 For cars:
  1. Subaru Cruiser (2016) - $1200/day for the rental cost a day
  2. Toyota Corolla (2018) - $1200/day for the rental cost a day

Customer data:
- Charlie (ID: 15)
