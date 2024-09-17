//File:SP2024_Product_Baratam.java
import java.text.DecimalFormat;
import java.util.stream.Collectors;
import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class SP2024_Product_Baratam 
{
    private int[] units; // Array to store the quantity of each product model sold.
    private static final double[] PRICES = {11.39, 12.59, 13.79, 14.99};// Array storing prices for each model.
    private static final double TAX_RATE = 0.0825;// Constant for the tax rate.
    // Date format for the receipt.
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("ddMMyyyy");
    private static final SimpleDateFormat MONTH_FORMAT = new SimpleDateFormat("MMyyyy");
    private static final SimpleDateFormat YEAR_FORMAT = new SimpleDateFormat("yyyy");
    

   // Constructor to initialize the units array.
    public SP2024_Product_Baratam() 
    {
        this.units = new int[4];
    }
// Constructor to initialize the units array with the given values.
    public SP2024_Product_Baratam(int[] units) 
    {
        this.units = units;
    }
//  Method to calculate the total price for each model sold.
    public double[] calculatePricePerModel() 
    {
        double[] totals = new double[this.units.length];
        for (int i = 0; i < this.units.length; i++) 
        {
            totals[i] = this.units[i] * PRICES[i];
        }
        return totals;
    }
// Method to calculate the subtotal of the sale.
    public double calculateSubtotal() 
    {
        double[] totals = calculatePricePerModel();
        double subtotal = 0;
        for (double total : totals) 
        {
            subtotal += total;
        }
        return subtotal;
    }
       //Method to calculate the tax amount.
    public double calculateTax(double subtotal) 
    {
        return subtotal * TAX_RATE;
    }
      // Method to calculate the total amount including tax.
    public double calculateTotal(double subtotal, double tax) 
    {
        return subtotal + tax;
    }

    // Method to format the receipt as a string.
    public String formatReceipt() 
    {
        StringBuilder receipt = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.00");
        double[] modelTotals = calculatePricePerModel();
        double subtotal = calculateSubtotal();
        double tax = calculateTax(subtotal);
        double total = calculateTotal(subtotal, tax);

        
        receipt.append("File:SP2024_SaleProductApplication_Baratam.java\n");
        receipt.append("Sale Product Receipt - Koushik Baratam\n");
        receipt.append("Day Report:\t").append(DATE_FORMAT.format(new Date())).append("\n");
        receipt.append("----------------------------------------------------\n");
        String[] models = {"MODEL A", "MODEL B", "MODEL C", "MODEL D"};
        for (int i = 0; i < models.length; i++) 
        {
            receipt.append(String.format("%s\t(%.2f)\t%d\t%.2f\n", models[i], PRICES[i], units[i], modelTotals[i]));
        }
        receipt.append("----------------------------------------------------\n");
        receipt.append("\nSubtotal:\t").append(df.format(subtotal))
              .append("\nTax:\t\t").append(df.format(tax))
              .append("\nTotal:\t\t").append(df.format(total)).append("\n");

        return receipt.toString();
    }
    // Method to print the day report.
    public void printDayReport() 
    {
        double subtotal = 0;
        System.out.println("\nFile:SP2024_SaleProductApplication_Baratam.java");
        System.out.println("Sale Product Receipt - Koushik Baratam");
        System.out.println("Day Report:\t" + new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < units.length; i++) 
        {
            double total = units[i] * PRICES[i];
            subtotal += total;
            System.out.printf("MODEL %s\t(%.2f)\t%d\t%.2f\n", (char) ('A' + i), PRICES[i], units[i], total);
        }
       
        System.out.println("----------------------------------------------------");
        System.out.printf("Subtotal:%22.2f\n", subtotal);
        double tax = subtotal * TAX_RATE;
        System.out.printf("Tax:%26.2f\n", tax);
        System.out.printf("Total:%25.2f\n", subtotal + tax);
    }
    // Method to print the month report.
    public void printMonthReport() 
    {
        double subtotal = 0;
        System.out.println("File:SP2024_SaleProductApplication_Baratam.java");
        System.out.println("Sale Product Receipt -Koushik Baratam");
        System.out.println("Month Report:\t" + new SimpleDateFormat("MM/yyyy").format(new Date()));
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < units.length; i++) 
        {
            double total = units[i] * PRICES[i];
            subtotal += total;
            System.out.printf("MODEL %s\t(%.2f)\t%d\t%.2f\n", (char) ('A' + i), PRICES[i], units[i], total);
        }
        System.out.println("----------------------------------------------------");
        System.out.printf("Subtotal: %23.2f\n", subtotal);
        double tax = subtotal *TAX_RATE; 
        System.out.printf("Tax:%27.2f\n", tax);
        System.out.printf("Total:%27.2f\n", subtotal + tax);
    }
    // Method to print the year report.
    public void printYearReport() 
    {
        double subtotal = 0;
        System.out.println("File:SP2024_SaleProductApplication_Baratam.java");
        System.out.println("Sale Product Receipt - Koushik Baratam");
        System.out.println("Year Report:\t" + new SimpleDateFormat("yyyy").format(new Date()));
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < units.length; i++) 
        {
            double total = units[i] * PRICES[i];
            subtotal += total;
            System.out.printf("MODEL %s\t(%.2f)\t%d\t%.2f\n", (char) ('A' + i), PRICES[i], units[i], total);
        }
        System.out.println("----------------------------------------------------");
        System.out.printf("Subtotal:%25.2f\n", subtotal);
        double tax = subtotal * TAX_RATE;
        System.out.printf("Tax:\t%25.2f\n", tax);
        System.out.printf("Total:\t%26.2f\n", subtotal + tax);
    }
    // Method to write the sale data to a file.
public void writeToFile() throws IOException 
{
    Date now = new Date();
    String dayFileName = "dayFile_" + DAY_FORMAT.format(now) + ".txt";
    String monthFileName = "monthFile_" + MONTH_FORMAT.format(now) + ".txt";
    String yearFileName = "yearFile_" + YEAR_FORMAT.format(now) + ".txt";

    int transactionNumber = getNewTransactionNumber(dayFileName); // Get the transaction number for the day
    aggregateData(dayFileName, transactionNumber, units, true); // true indicates this is the day file
    aggregateData(monthFileName, Integer.parseInt(DAY_FORMAT.format(now).substring(0, 2)), units, false);
    aggregateData(yearFileName, Integer.parseInt(MONTH_FORMAT.format(now).substring(0, 2)), units, false);
}
// Method to get the new transaction number for the day,by default, it returns 1 if the file does not exist.
private int getNewTransactionNumber(String fileName) throws IOException 
{
    Path path = Paths.get(fileName);        
    if (!Files.exists(path)) 
    {
        return 1;
    }
    List<String> lines = Files.readAllLines(path);
    if (lines.isEmpty())
    {
        return 1;
    }
    // Get the last line, get the transaction number from the last line
    String lastLine = lines.get(lines.size() - 1);
    int lastNumber = Integer.parseInt(lastLine.split(" ")[0]);
    return lastNumber + 1;
}
// Method to aggregate the data to the file by default, it appends the data to the file if it exists.
private void aggregateData(String fileName, int key, int[] newUnits, boolean isDayFile) throws IOException 
{
    File file = new File(fileName);
    if (isDayFile) 
    {  // If it is the day file, append the data to the file
        try (FileWriter fw = new FileWriter(file, true); PrintWriter pw = new PrintWriter(fw)) 
        {
            pw.printf("%04d %d %d %d %d%n", key, newUnits[0], newUnits[1], newUnits[2], newUnits[3]);
        }
    } 
    else 
    {// If it is not the day file, update the data in the file, if the key exists, update the units, otherwise add a new line.
        String[] existingData = file.exists() ? readDataFromFile(file) : new String[0];
        String updatedData = updateData(existingData, key, newUnits);
        try (FileWriter fw = new FileWriter(file, false); PrintWriter pw = new PrintWriter(fw)) 
        {
            pw.print(updatedData);
        }
    }
}
// Method to read the data from the file.
private String[] readDataFromFile(File file) throws IOException 
{
    List<String> lines = Files.readAllLines(file.toPath());
    return lines.toArray(new String[0]);
}
// Method to update the data in the file, if the key exists, update the units, otherwise add a new line.
private String updateData(String[] existingData, int key, int[] newUnits) 
{
    StringBuilder updatedData = new StringBuilder();
    boolean keyFound = false;
 // Iterate through the existing data, if the key exists, update the units, otherwise add a new line.
    for (String line : existingData) 
    {
        String[] parts = line.split(" ");
        int currentKey = Integer.parseInt(parts[0]);
   // If the key matches, update the units and append the updated data.
        if (currentKey == key) 
        {
            keyFound = true;
            updatedData.append(parts[0]); 
            // Update the units for each model, and append the updated data.
            for (int i = 0; i < newUnits.length; i++) 
            {
                int sum = Integer.parseInt(parts[i + 1]) + newUnits[i];
                updatedData.append(" ").append(sum); 
            }
            updatedData.append("\n");

        } 
        // If the key does not match, append the line as is.
        else  
        {
            updatedData.append(line).append("\n");
        }
    }
    // If the key is not found, append the units for each model add a new line with the key and units.
    if (!keyFound) 
    { 
        updatedData.append(key);
        for (int unit : newUnits) 
        {

            updatedData.append(" ").append(unit);
        }
        updatedData.append("\n");
    }
// Return the updated data as a string.
    return updatedData.toString();
}
}