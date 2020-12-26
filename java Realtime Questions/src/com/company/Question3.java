package com.company;

/*
 Name
- Address
- City, State, and ZIP
- Telephone Number
- Account Balance
- Date of Last Payment
 */

import javax.lang.model.element.Name;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;


class CustomerAccountsDetails {
    Scanner scanner = new Scanner(System.in);
    private String Name, Address, City, State, DateofLastPayment;
    private int ZIP;
    private double TelephoneNumber, AccountBalance;


    public void setName() {
        System.out.println("Enter your Name");
        Name = scanner.nextLine();

    }

    public void setAddress() {
        System.out.println("Enter your Address");
        Address = scanner.nextLine();

    }

    public void setCityStateAndZIP() {
        System.out.println("Enter your City Name");
        City = scanner.nextLine();
        System.out.println("Enter your  State");
        State = scanner.nextLine();
        System.out.println("Enter your City's ZIP code");
        ZIP = scanner.nextInt();

    }

    public void setTelephoneNumber() {
        System.out.println("Enter your Telephone NUmber");
        TelephoneNumber = scanner.nextDouble();


    }

    public void setAccountBalance() {
        System.out.println("Enter your Account's Balance");
        AccountBalance = scanner.nextInt();


    }

    public void setDateOfLastPayment() {
        System.out.println("Enter your last date of payment");
        DateofLastPayment = scanner.nextLine();

    }


    void witeCustomerDetails() {

        try {
            FileWriter DetailsWriter = new FileWriter("CustomerDetails.txt");
            DetailsWriter.write("Customer's Account Balance " + AccountBalance + "\n");
            DetailsWriter.write("Customer's Address is " + Address + "\n");
            DetailsWriter.write("Customer's City is " + City + "\n");
            DetailsWriter.write("Customer's Last payment date was " + DateofLastPayment + "\n");
            DetailsWriter.write("Customer's Name is " + Name + "\n");
            DetailsWriter.write("Customer's State is " + State + "\n");
            DetailsWriter.write("Customer's Telephone  number is " + TelephoneNumber + "\n");
            DetailsWriter.write("Customer's City's ZIP code is " + ZIP + "\n");


            DetailsWriter.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    void searching(String ArrayMenue[]) // implementing BinarySearch
    {
        String ArraySearch;
        System.out.println("Following are the details you can search for customers\n Account Balance ,  Address , City ,  DateofLastPayment ,  Name , State , Telephone , ZIP");
        ArraySearch = scanner.nextLine();
        int result = Arrays.binarySearch(ArrayMenue, ArraySearch);

        for (int i = 0; i <= ArrayMenue.length; i++) {
            if (i == result) {

                try {
                    FileReader DetailsReader = new FileReader("CustomerDetails.txt");

                    String specific_line_text = Files.readAllLines(Paths.get("CustomerDetails.txt")).get(i);  // reading specific lines
                    System.out.println(specific_line_text);

                    DetailsReader.close();

                } catch (Exception e) {
                    System.out.println(e);

                }

            }
        }

    }

    void deleteBySearching(String ArrayMenue[]) {

        String ArraySearch;
        System.out.println("Following are the details you can search and deletes for customers\n Account Balance ,  Address , City ,  DateofLastPayment ,  Name , State , Telephone , ZIP");
        ArraySearch = scanner.nextLine();
        int result = Arrays.binarySearch(ArrayMenue, ArraySearch);

        for (int i = 0; i <= ArrayMenue.length; i++) {
            if (i == result) {

                try {
                    FileReader DetailsReader = new FileReader("CustomerDetails.txt");

                    String specific_line_text = Files.readAllLines(Paths.get("CustomerDetails.txt")).get(i);  // reading specific lines
                    System.out.println(specific_line_text);
                    System.out.println("Which of the following word do you want to delete from this??");
                    String str2 = scanner.nextLine();
                    specific_line_text = specific_line_text.replaceAll(str2, "");  // deleting a word using java built in method
                    System.out.println("The line after  deleting " + str2 + " is   " + specific_line_text);


                    DetailsReader.close();

                } catch (Exception e) {
                    System.out.println(e);

                }

            }
        }


    }

    void changeInLine(String ArrayMenue[]) {

        {

            String ArraySearch;
            System.out.println("Following are the details you can search and deletes for customers\n Account Balance ,  Address , City ,  DateofLastPayment ,  Name , State , Telephone , ZIP");
            ArraySearch = scanner.nextLine();
            int result = Arrays.binarySearch(ArrayMenue, ArraySearch);

            for (int i = 0; i <= ArrayMenue.length; i++) {
                if (i == result) {

                    try {
                        FileReader DetailsReader = new FileReader("CustomerDetails.txt");

                        String specific_line_text = Files.readAllLines(Paths.get("CustomerDetails.txt")).get(i);  // reading specific lines
                        System.out.println(specific_line_text);
                        System.out.println("Which of the following word do you want to change from this??");
                        String str2 = scanner.nextLine();
                        System.out.println("Enter a new data for replacement");
                        String str3 = scanner.nextLine();
                        specific_line_text = specific_line_text.replace(str2, str3);  //
                        System.out.println("The line after  changing " + str2 + " is   " + specific_line_text);
                        DetailsReader.close();

                    } catch (Exception e) {
                        System.out.println(e);

                    }

                }
            }


        }


    }


    void mainMenu() {
        char DecisionMenue;
        System.out.println("Following are the features in the Main Menue");
        System.out.println("press 1 for  Enter new records into the file.\n press 2 for Search for a particular customer’s record and display it.");
        System.out.println("press 3 for  Search for a particular customer’s record and delete it\n press 4 for Search for a particular customer’s record and change it. ");
        System.out.println("press 5 for • Display the contents of the entire file. ");

        DecisionMenue = scanner.nextLine().charAt(0);

        switch (DecisionMenue) {
            case '1': {
                setName();
                setAddress();
                setCityStateAndZIP();
                setDateOfLastPayment();
                setAccountBalance();

                setTelephoneNumber();


                witeCustomerDetails(); //for writting to a file


                break;


            }

            case '2': {
                String[] ArrayMenue = {"Account Balance", "Address", "City", "DateofLastPayment", "Name", "State", "Telephone", "ZIP"};

                searching(ArrayMenue);
                break;


            }

            case '3': {
                String[] ArrayMenue = {"Account Balance", "Address", "City", "DateofLastPayment", "Name", "State", "Telephone", "ZIP"};

                deleteBySearching(ArrayMenue);

                break;
            }

            case '4': {
                String[] ArrayMenue = {"Account Balance", "Address", "City", "DateofLastPayment", "Name", "State", "Telephone", "ZIP"};
                changeInLine(ArrayMenue);

                break;

            }

            case '5': {
                try {
                    FileReader fr = new FileReader("CustomerDetails.txt");
                    int i;
                    while ((i = fr.read()) != -1)
                        System.out.print((char) i);
                    fr.close();
                } catch (Exception e) {
                    System.out.println(e);
                }

            }


        }


    }


}


public class Question3 {
    public static void main(String[] args) {
        CustomerAccountsDetails customerAccountsDetails = new CustomerAccountsDetails();
        customerAccountsDetails.mainMenu();


    }
}
