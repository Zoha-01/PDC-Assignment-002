import java.util.ArrayList;
import java.util.List;

// Trade Data Model Class
class TradeRecord {
    private String tradeId;
    private String symbol;
    private double amount;

    public TradeRecord(String tradeId, String symbol, double amount) {
        this.tradeId = tradeId;
        this.symbol = symbol;
        this.amount = amount;
    }

    public String getTradeId() { return tradeId; }
    public String getSymbol() { return symbol; }
    public double getAmount() { return amount; }

    @Override
    public String toString() {
        return "TradeRecord [ID=" + tradeId + ", Symbol=" + symbol + ", Amount=$" + amount + "]";
    }
}

// Main Analytics Driver Application
public class TradeAnalyticsApp {

    // Method to filter trades by Symbol
    public static List<TradeRecord> filterBySymbol(List<TradeRecord> trades, String targetSymbol) {
        List<TradeRecord> filtered = new ArrayList<>();
        for (TradeRecord trade : trades) {
            if (trade.getSymbol().equalsIgnoreCase(targetSymbol)) {
                filtered.add(trade);
            }
        }
        return filtered;
    }

    // Method to calculate total volume for filtered trades
    public static double calculateTotalVolume(List<TradeRecord> trades) {
        double total = 0.0;
        for (TradeRecord trade : trades) {
            total += trade.getAmount();
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("=== Starting Trade Analytics Engine ===");

        // Step 1: Initialize Trade Portfolio
        List<TradeRecord> portfolio = new ArrayList<>();
        portfolio.add(new TradeRecord("TRD_101", "AAPL", 15000.50));
        portfolio.add(new TradeRecord("TRD_102", "GOOGL", 22000.00));
        portfolio.add(new TradeRecord("TRD_103", "AAPL", 8500.25));
        portfolio.add(new TradeRecord("TRD_104", "MSFT", 12400.00));

        System.out.println("Total Trades Loaded: " + portfolio.size());
        System.out.println("----------------------------------------");

        // Step 2: Filter Trades for "AAPL"
        String targetSymbol = "AAPL";
        List<TradeRecord> aaplTrades = filterBySymbol(portfolio, targetSymbol);

        System.out.println("Filtered Trades for " + targetSymbol + ":");
        for (TradeRecord trade : aaplTrades) {
            System.out.println(" - " + trade);
        }

        // Step 3: Aggregate Analytics
        double totalVolume = calculateTotalVolume(aaplTrades);
        System.out.println("----------------------------------------");
        System.out.println("Total Trading Volume for " + targetSymbol + ": $" + totalVolume);
        System.out.println("=== Analytics Processing Complete ===");
    }
}