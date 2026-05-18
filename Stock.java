import java.io.Serializable;

public class Stock implements Serializable {

    private String stockSymbol;
    private String companyName;
    private double stockPrice;
    private double marketCap;
    private boolean marketOpen;

    // Constructor
    public Stock(String stockSymbol,
                 String companyName,
                 double stockPrice,
                 double marketCap) {

        this.stockSymbol = stockSymbol;
        this.companyName = companyName;
        this.stockPrice = stockPrice;
        this.marketCap = marketCap;
        this.marketOpen = true;
    }

    // Getters
    public String getStockSymbol() {
        return stockSymbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public boolean isMarketOpen() {
        return marketOpen;
    }

    // Update Stock Price
    public void updateStockPrice(double newPrice) {

        if (newPrice > 0) {

            stockPrice = newPrice;

            System.out.println("Stock price updated successfully.");
        }
        else {

            System.out.println("Invalid stock price.");
        }
    }

    // Open Market
    public void openMarket() {

        marketOpen = true;

        System.out.println("Market opened for " + stockSymbol);
    }

    // Close Market
    public void closeMarket() {

        marketOpen = false;

        System.out.println("Market closed for " + stockSymbol);
    }

    // Display Stock Information
    public void displayStockDetails() {

        System.out.println("\n======================================");
        System.out.println("           STOCK DETAILS");
        System.out.println("======================================");

        System.out.println("Stock Symbol : " + stockSymbol);
        System.out.println("Company Name : " + companyName);
        System.out.println("Stock Price  : ₹" + stockPrice);
        System.out.println("Market Cap   : ₹" + marketCap + " Cr");

        System.out.println("Market Status: "
                + (marketOpen ? "OPEN" : "CLOSED"));

        System.out.println("======================================");
    }

    // Stock Summary
    public String getStockSummary() {

        return stockSymbol + " | "
                + companyName + " | ₹"
                + stockPrice;
    }
}