//File: SP2024_SaleProductApplication_Baratam.java
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SP2024_SaleProductApplication_Baratam 
{
    private static Scanner scanner = new Scanner(System.in);
    private static int transactionCount = 0001; // Keep track of transaction numbers

    public static void main(String[] args) 
    {   // Main method
        int choice;
        do // Do-while loop
        {
            // switch case to write the menu
            displayMenu();
            choice = scanner.nextInt();
            switch (choice) 
            {
                case 1:
                    saleProduct();
                    break;
                case 2:
                    printDayReport();
                    break;
                case 3:
                    printMonthReport();
                    break;
                case 4:
                    printYearReport();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 4.");
            }
        } while (choice != 0);
    }
    // Display menu, get user choice, and call the corresponding method 
    private static void displayMenu() 
    {
        System.out.println("\nSP24 COMPANY MENU - Koushik Baratam");
        System.out.println("Today: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        System.out.println("----------------------------------------------------");
        System.out.println("1. Sale SP24 Product");
        System.out.println("2. Print Day Sale Report");
        System.out.println("3. Print Month Sale Report");
        System.out.println("4. Print Year Sale Report");
        System.out.println("0. Exit");
        System.out.print("Enter a number 1 to 4 to select a task or 0 to exit: ");
    }
// Sale product method, get user input for product model and units, create product object, print receipt, and write to file.
    private static void saleProduct() 
    {
        int[] unitsModel = new int[4]; // Array to store units for each model
        int modelChoice;
        do {
            System.out.println("\nPRODUCT MODELS MENU - Koushik Baratam");
            System.out.println("Today: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
            System.out.println("----------------------------------------------------");
            System.out.println("1. Model A - $11.39");
            System.out.println("2. Model B - $12.59");
            System.out.println("3. Model C - $13.79");
            System.out.println("4. Model D - $14.99");
            System.out.println("0. Exit");
            System.out.print("Enter 1, 2, 3, 4 to select the product model or 0 to Exit: ");
            modelChoice = scanner.nextInt();
            if (modelChoice > 0 && modelChoice <= 4) 
            {
                System.out.print("Enter the number of units: ");
                int units = scanner.nextInt();
                unitsModel[modelChoice - 1] += units; 
            }
        } 
        // Exit the loop if the user enters 0
        while (modelChoice != 0);
        // Create a product object, print receipt, and write to file
        SP2024_Product_Baratam product = new SP2024_Product_Baratam(unitsModel);
        System.out.println(product.formatReceipt());
        // Write to file, catch exception if any.
        try 
        {
            product.writeToFile();
        } 
        catch (IOException e) 
        {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
 // Print day report method, get user input for filename, read file, process each line, aggregate units, and print day report.
    private static void printDayReport() 
    {
        System.out.print("Enter the filename for the day report (e.g., dayFile_MMddyyyy.txt): ");
        String filename = scanner.next();
        int[] totalUnits = {0, 0, 0, 0};
        File file = new File(filename);
    //buffered reader to read the file,and aggregate the units.
        if (file.exists()) 
        {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    processLineAndAggregate(line, totalUnits);
                }
                SP2024_Product_Baratam product = new SP2024_Product_Baratam(totalUnits);
                product.printDayReport();
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } 
        else 
        {
            System.out.println("File does not exist.");
        }
    }
    // Print month report method, get user input for filename, read file, process each line, aggregate units, and print month report.
    private static void printMonthReport() 
    {
        System.out.print("Enter the filename for the month report (e.g., monthFile_MMyyyy.txt): ");
        String filename = scanner.next();
        int[] totalUnits = {0, 0, 0, 0};
        File file = new File(filename);
        if (file.exists()) 
        {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    processLineAndAggregate(line, totalUnits);
                }
                SP2024_Product_Baratam product = new SP2024_Product_Baratam(totalUnits);
                product.printMonthReport();
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } 
        else 
        {
            System.out.println("File does not exist.");
        }
    }
    // Print year report method, get user input for filename, read file, process each line, aggregate units, and print year report.
    private static void printYearReport() 
    {
        System.out.print("Enter the filename for the year report (e.g., yearFile_yyyy.txt): ");
        String filename = scanner.next();
        int[] totalUnits = {0, 0, 0, 0};
        File file = new File(filename);
        if (file.exists()) 
        {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    processLineAndAggregate(line, totalUnits);
                }
                SP2024_Product_Baratam product = new SP2024_Product_Baratam(totalUnits);
                product.printYearReport();
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } 
        else 
        {
            System.out.println("File does not exist.");
        }
    }
    // Process each line and aggregate the units for each model
    private static void processLineAndAggregate(String line, int[] totalUnits) 
    {
        String[] parts = line.split(" ");
        for (int i = 1; i < parts.length; i++) 
        { 
            totalUnits[i - 1] += Integer.parseInt(parts[i]);
        }
    }
}