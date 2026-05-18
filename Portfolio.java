import java.util.ArrayList;
import java.util.HashMap;

public class Portfolio {

    private double balance;

    private HashMap<String, Integer> ownedStocks;

    private ArrayList<Transaction> transactions;

    // Constructor
    public Portfolio(double initialBalance) {

        this.balance = initialBalance;

        ownedStocks = new HashMap<>();

        transactions = new ArrayList<>();
    }

    // Get Current Balance
    public double getBalance() {
        return balance;
    }

    // Display Portfolio Balance
    public void displayBalance() {

        System.out.println("\n======================================");
        System.out.println("Current Balance : ₹" + balance);
        System.out.println("======================================");
    }

    // Buy Stock
    public void buyStock(Stock stock, int quantity) {

        double totalCost = stock.getStockPrice() * quantity;

        if (!stock.isMarketOpen()) {

            System.out.println("Market is closed.");
            return;
        }

        if (totalCost > balance) {

            System.out.println("Insufficient balance.");
            return;
        }

        balance -= totalCost;

        ownedStocks.put(
                stock.getStockSymbol(),

                ownedStocks.getOrDefault(
                        stock.getStockSymbol(),
                        0
                ) + quantity
        );

        Transaction transaction =
                new Transaction("BUY", stock, quantity);

        transactions.add(transaction);

        System.out.println("\nStock purchased successfully!");

        transaction.displayTransactionDetails();
    }

    // Sell Stock
    public void sellStock(Stock stock, int quantity) {

        String symbol = stock.getStockSymbol();

        if (!ownedStocks.containsKey(symbol)) {

            System.out.println("You do not own this stock.");
            return;
        }

        int availableQuantity = ownedStocks.get(symbol);

        if (quantity > availableQuantity) {

            System.out.println("Insufficient stock quantity.");
            return;
        }

        double totalAmount =
                quantity * stock.getStockPrice();

        balance += totalAmount;

        ownedStocks.put(
                symbol,
                availableQuantity - quantity
        );

        Transaction transaction =
                new Transaction("SELL", stock, quantity);

        transactions.add(transaction);

        System.out.println("\nStock sold successfully!");

        transaction.displayTransactionDetails();
    }

    // Display Owned Stocks
    public void displayOwnedStocks() {

        System.out.println("\n========== OWNED STOCKS ==========");

        if (ownedStocks.isEmpty()) {

            System.out.println("No stocks owned.");

            return;
        }

        for (String symbol : ownedStocks.keySet()) {

            System.out.println(
                    symbol + " : "
                    + ownedStocks.get(symbol)
                    + " Shares"
            );
        }
    }

    // Display Transaction History
    public void displayTransactionHistory() {

        System.out.println("\n======= TRANSACTION HISTORY =======");

        if (transactions.isEmpty()) {

            System.out.println("No transactions available.");

            return;
        }

        for (Transaction transaction : transactions) {

            transaction.displayTransactionDetails();
        }
    }

    // Portfolio Summary
    public void displayPortfolioSummary() {

        System.out.println("\n======================================");
        System.out.println("         PORTFOLIO SUMMARY");
        System.out.println("======================================");

        System.out.println("Available Balance : ₹" + balance);

        System.out.println("Owned Stocks Count: "
                + ownedStocks.size());

        System.out.println("Total Transactions: "
                + transactions.size());

        System.out.println("======================================");
    }
}