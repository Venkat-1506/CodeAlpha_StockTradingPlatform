import java.util.ArrayList;

public class TradingPlatform {

    private ArrayList<Stock> marketStocks;

    private Portfolio portfolio;

    // Constructor
    public TradingPlatform() {

        marketStocks = new ArrayList<>();

        portfolio = new Portfolio(100000);

        addDefaultStocks();
    }

    // Add Initial Stocks
    private void addDefaultStocks() {

        marketStocks.add(
                new Stock(
                        "TCS",
                        "Tata Consultancy Services",
                        3500,
                        120000
                )
        );

        marketStocks.add(
                new Stock(
                        "INFY",
                        "Infosys",
                        1500,
                        90000
                )
        );

        marketStocks.add(
                new Stock(
                        "RELIANCE",
                        "Reliance Industries",
                        2800,
                        180000
                )
        );

        marketStocks.add(
                new Stock(
                        "HDFC",
                        "HDFC Bank",
                        1700,
                        110000
                )
        );

        marketStocks.add(
                new Stock(
                        "WIPRO",
                        "Wipro",
                        450,
                        40000
                )
        );
    }

    // Display Market Stocks
    public void displayMarketStocks() {

        System.out.println("\n========== STOCK MARKET ==========");

        for (Stock stock : marketStocks) {

            stock.displayStockDetails();
        }
    }

    // Search Stock By Symbol
    public Stock searchStock(String symbol) {

        for (Stock stock : marketStocks) {

            if (stock.getStockSymbol()
                    .equalsIgnoreCase(symbol)) {

                return stock;
            }
        }

        return null;
    }

    // Buy Stock
    public void buyStock(String symbol, int quantity) {

        Stock stock = searchStock(symbol);

        if (stock == null) {

            System.out.println("Stock not found.");

            return;
        }

        portfolio.buyStock(stock, quantity);
    }

    // Sell Stock
    public void sellStock(String symbol, int quantity) {

        Stock stock = searchStock(symbol);

        if (stock == null) {

            System.out.println("Stock not found.");

            return;
        }

        portfolio.sellStock(stock, quantity);
    }

    // Display Portfolio
    public void displayPortfolio() {

        portfolio.displayPortfolioSummary();

        portfolio.displayOwnedStocks();
    }

    // Display Transactions
    public void displayTransactions() {

        portfolio.displayTransactionHistory();
    }

    // Display Balance
    public void displayBalance() {

        portfolio.displayBalance();
    }

    // Platform Statistics
    public void displayPlatformStatistics() {

        System.out.println("\n======================================");
        System.out.println("      TRADING PLATFORM STATS");
        System.out.println("======================================");

        System.out.println("Total Listed Stocks : "
                + marketStocks.size());

        System.out.println("Platform Status     : ACTIVE");

        System.out.println("Trading Support     : ENABLED");

        System.out.println("======================================");
    }
}