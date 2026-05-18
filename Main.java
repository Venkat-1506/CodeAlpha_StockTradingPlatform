import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TradingPlatform tradingPlatform =
                new TradingPlatform();

        boolean running = true;

        System.out.println("======================================");
        System.out.println("   WELCOME TO STOCK TRADING SYSTEM");
        System.out.println("======================================");

        while (running) {

            System.out.println("\n========== MAIN MENU ==========");

            System.out.println("1. View Market Stocks");
            System.out.println("2. Buy Stocks");
            System.out.println("3. Sell Stocks");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Balance");
            System.out.println("6. Transaction History");
            System.out.println("7. Platform Statistics");
            System.out.println("8. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {

                case 1:

                    tradingPlatform.displayMarketStocks();

                    break;

                case 2:

                    System.out.println("\n========== BUY STOCK ==========");

                    System.out.print("Enter Stock Symbol: ");

                    String buySymbol =
                            scanner.nextLine();

                    System.out.print("Enter Quantity: ");

                    int buyQuantity =
                            scanner.nextInt();

                    scanner.nextLine();

                    tradingPlatform.buyStock(
                            buySymbol,
                            buyQuantity
                    );

                    break;

                case 3:

                    System.out.println("\n========== SELL STOCK ==========");

                    System.out.print("Enter Stock Symbol: ");

                    String sellSymbol =
                            scanner.nextLine();

                    System.out.print("Enter Quantity: ");

                    int sellQuantity =
                            scanner.nextInt();

                    scanner.nextLine();

                    tradingPlatform.sellStock(
                            sellSymbol,
                            sellQuantity
                    );

                    break;

                case 4:

                    tradingPlatform.displayPortfolio();

                    break;

                case 5:

                    tradingPlatform.displayBalance();

                    break;

                case 6:

                    tradingPlatform.displayTransactions();

                    break;

                case 7:

                    tradingPlatform.displayPlatformStatistics();

                    break;

                case 8:

                    running = false;

                    System.out.println(
                            "\nThank You For Using Stock Trading System!"
                    );

                    break;

                default:

                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}