import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction implements Serializable {

    private String transactionType;
    private Stock stock;
    private int quantity;
    private double totalAmount;
    private LocalDateTime transactionTime;

    // Constructor
    public Transaction(String transactionType,
                       Stock stock,
                       int quantity) {

        this.transactionType = transactionType;
        this.stock = stock;
        this.quantity = quantity;

        this.totalAmount = quantity * stock.getStockPrice();

        this.transactionTime = LocalDateTime.now();
    }

    // Getters
    public String getTransactionType() {
        return transactionType;
    }

    public Stock getStock() {
        return stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    // Display Transaction Details
    public void displayTransactionDetails() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("\n======================================");
        System.out.println("        TRANSACTION DETAILS");
        System.out.println("======================================");

        System.out.println("Transaction Type : " + transactionType);

        System.out.println("Stock Symbol     : "
                + stock.getStockSymbol());

        System.out.println("Company Name     : "
                + stock.getCompanyName());

        System.out.println("Quantity         : " + quantity);

        System.out.println("Stock Price      : ₹"
                + stock.getStockPrice());

        System.out.println("Total Amount     : ₹"
                + totalAmount);

        System.out.println("Transaction Time : "
                + transactionTime.format(formatter));

        System.out.println("======================================");
    }

    // Transaction Summary
    public String getTransactionSummary() {

        return transactionType + " | "
                + stock.getStockSymbol() + " | Qty: "
                + quantity + " | ₹"
                + totalAmount;
    }
}