
package csc151_project;

import java.util.Scanner;

public class CSC151_Project_1 
{
    public static Car cars[] = new Car[20];

    //keeps track of the length of the array since the array length is hard coded at 20
    public static int currentObject = 0;
    
    public static void main(String[] args) 
    {
        mainMenu();
    }
    public static void mainMenu()
    {
        Scanner input = new Scanner(System.in);
        int check = 0;
        int choice = 0;
           
        while (check == 0)
        {        
        System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n" , "Press 1 if you want to add a car." ,
                                                         "Press 2 if you want to change a specific car." ,
                                                         "Press 3 if you want to display the data for a specific car",
                                                         "Press 4 if you want to see the data for all of the cars",
                                                         "Press 5 if you want to see the average mileage." ,
                                                         "Press 6 if you want to see the cheapest car.",
                                                         "Press 7 if you want to make an offer." ,
                                                         "Press 8 to close the program");
        
        
            choice = input.nextInt();
            
            if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6 || choice == 7 || choice == 8)
            {
                check = 1;
            } else 
            {
                System.out.println("Wrong value enetered.");
            }
        }
        
        makeSelection(choice);
        
    }
    public static void pauseForMenu()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Press any ENTER to continue");
        String pause = input.nextLine();


        mainMenu();

    }
    
    public static void makeSelection(int choice)
    {
        switch (choice)

        {

            case 1:
                addCar();
                break;

            case 2:
                changeCar();
                break;

            case 3:
                printSingleCar();
                break;

            case 4:
                printAllCars();
                break;

            case 5:
                findAveragegMileage();
                break;

            case 6:
                printCheapest();
                break;

            case 7:
                makeOffer();
                break;
            case 8:
                System.out.println("Closing program....");
                break;
        }
    }
    
    public static void addCar() {

        Scanner input = new Scanner(System.in);

        System.out.println("Vin: ");
        String vin = input.next();

        System.out.println("Make: ");
        String make = input.next();

        System.out.println("Model: ");
        String model = input.next();

        System.out.println("Year: ");
        int year = input.nextInt();

        System.out.println("Mileage: ");
        double mileage = input.nextDouble();

        System.out.println("Price: ");
        double price = input.nextDouble();

        cars[currentObject] = new Car(vin, make, model, year, mileage, price);

        currentObject++;

        pauseForMenu();

    }
    
    public static void changeCar() {
        int realObject = currentObject - 1;
        int check = 0;
        
        Scanner input = new Scanner(System.in);

         
        System.out.println("What car do you want to change? Select from 0 to " + realObject);
        int carChoice = input.nextInt();
        
        while (check == 0)
        { 
        System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n","Press 1 if you would like to edit the vin.",
                                                    "Press 2 if you want to edit the make.",
                                                    "Press 3 if you want to edit the model",
                                                    "Press 4 if you want to edit the year",
                                                    "Press 5 if you want to edit the mileage",
                                                    "Press 6 if you want to edit the Price");
        int partChanged = input.nextInt();

        switch (partChanged)

        {

            case 1:
                System.out.println("Enter the vin");
                String vin = input.next();

                cars[carChoice].setVin(vin);
                break;

            case 2:
                System.out.println("Enter the make");
                String make = input.next();

                cars[carChoice].setMake(make);
                break;

            case 3:
                System.out.println("Enter the model");
                String model = input.next();

                cars[carChoice].setModel(model);
                break;

            case 4:
                System.out.println("Enter the year");
                double year = input.nextInt();

                cars[carChoice].setYear(year);
                break;

            case 5:
                System.out.println("Enter the mileage");
                double mileage = input.nextDouble();

                cars[carChoice].setMileage(mileage);
                break;

            case 6:
                System.out.println("Enter the price");
                double price = input.nextDouble();

                cars[carChoice].setPrice(price);
                break;
            
        }
        System.out.println("Would you like to make another change to the same car??");
        System.out.println("Press 1 for yes and 2 for no.");
        
        int runAgain = input.nextInt();
        
        if (runAgain == 2)
        {
            check = 1;
        }
        }

        pauseForMenu();

    }
     
     public static void printSingleCar() 
     {
         int realObject = currentObject - 1;

        Scanner input = new Scanner(System.in);

        System.out.println("Choose a car from 0 to " + realObject);
        int car = input.nextInt();

        cars[car].printCar();
        
        pauseForMenu();
     }
     public static void printAllCars() {

        for (int i = 0; i < currentObject; i++) {

            System.out.printf( "%s%d%s%n","Car # " , i , " is :");
            cars[i].printCar();

        }
        pauseForMenu();


    }
     
     public static void findAveragegMileage() 
     {

        double runningMiles = 0;

        for (int i = 0; i < currentObject; i++) 
        {
            runningMiles = cars[i].getMileage() + runningMiles;
        }
        
        double average = runningMiles / currentObject;
        double remainder = runningMiles % currentObject;
        average = average + remainder;

        System.out.println("The average mileage is " + average);
        
        pauseForMenu();


    }
     
     public static void printCheapest() 
     {
        int cheapest = 0;
        double price = 1000000;

        for (int i = 0; i < currentObject; i++) 
        {
            
            double runningPrice = cars[i].getPrice();
            if (runningPrice < price)
            {
                cheapest = i;
            }
        }


        System.out.println("The cheapest car is: ");
        cars[cheapest].printCar();
        
        pauseForMenu();

        

    }
     
     public static void makeOffer() 
     {
         int realObject = currentObject - 1;

        Scanner input = new Scanner(System.in);
        double price;
        
        System.out.println("What car are you interested in? Select 0 to " + realObject);
        int car = input.nextInt();

        System.out.printf("%s%n%s%n%s%n%s%n" , "Is the customer: " 
                             , "1: Very interested."
                             , "2: Somewhat Interested."
                             , "3: Not interested.");

        int customerDisposition = input.nextInt();
        
        switch(customerDisposition)
        {
            case 1:
                price = cars[car].getPrice() - 100;

                System.out.println("Adjusted price for the " + cars[car].getMake() + " " + cars[car].getVin() + " is " + price );
                break;

            case 2:
                price = cars[car].getPrice() - 200;

                System.out.println("Adjusted price for the " + cars[car].getMake() + " " + cars[car].getVin() + " is " + price );
                break;

            case 3:
                price = cars[car].getPrice() - 500;

                System.out.println("Adjusted price for the " + cars[car].getMake() + " " + cars[car].getVin() + " is " + price );
                break;
        }
        
        pauseForMenu();
    }    
}
 