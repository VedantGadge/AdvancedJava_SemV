
// Observer interface for stock price changes
interface StockObserver {
	void update(String stock, double price);
}

// Subject class
class StockPriceTracker {
	private java.util.List<StockObserver> observers = new java.util.ArrayList<>();
	private java.util.Map<String, Double> stockPrices = new java.util.HashMap<>();

	public void addObserver(StockObserver observer) {
		observers.add(observer);
	}
	public void removeObserver(StockObserver observer) {
		observers.remove(observer);
	}
	public void setPrice(String stock, double price) {
		stockPrices.put(stock, price);
		notifyObservers(stock, price);
	}
	public Double getPrice(String stock) {
		return stockPrices.get(stock);
	}
	private void notifyObservers(String stock, double price) {
		for (StockObserver observer : observers) {
			observer.update(stock, price);
		}
	}
}

// Concrete Observer: PriceAlert
class PriceAlert implements StockObserver {
	private String stock;
	private double threshold;
	public PriceAlert(String stock, double threshold) {
		this.stock = stock;
		this.threshold = threshold;
	}
	public void update(String stock, double price) {
		if (this.stock.equalsIgnoreCase(stock) && price >= threshold) {
			System.out.println("[ALERT] " + stock + " price reached " + price + " (threshold: " + threshold + ")");
		}
	}
}

// Concrete Observer: DisplayBoard
class DisplayBoard implements StockObserver {
	public void update(String stock, double price) {
		System.out.println("[DisplayBoard] " + stock + " current price: " + price);
	}
}

public class q2 {
	public static void main(String[] args) {
		StockPriceTracker tracker = new StockPriceTracker();
		// Add observers
		tracker.addObserver(new DisplayBoard());
		tracker.addObserver(new PriceAlert("AAPL", 150.0));
		tracker.addObserver(new PriceAlert("GOOG", 2800.0));

		java.util.Scanner sc = new java.util.Scanner(System.in);
		while (true) {
			System.out.println("\nEnter stock symbol (or 'exit' to quit): ");
			String stock = sc.nextLine().trim();
			if (stock.equalsIgnoreCase("exit")) {
				System.out.println("Exiting...");
				break;
			}
			System.out.print("Enter new price for " + stock + ": ");
			double price;
			try {
				price = Double.parseDouble(sc.nextLine().trim());
			} catch (NumberFormatException e) {
				System.out.println("Invalid price. Try again.");
				continue;
			}
			tracker.setPrice(stock, price);
		}
		sc.close();
	}
}
