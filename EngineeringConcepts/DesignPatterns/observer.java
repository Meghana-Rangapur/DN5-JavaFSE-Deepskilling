import java.util.*;

// Observer Interface
interface Observer {
    void update(double price);
}

// Subject Interface
interface Stock {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// Concrete Subject
class StockMarket implements Stock {

    private List<Observer> observers = new ArrayList<>();
    private double price;

    public void setPrice(double price) {
        this.price = price;
        notifyObservers(); // notify when price changes
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(price);
        }
    }
}

// Concrete Observer 1
class MobileApp implements Observer {
    public void update(double price) {
        System.out.println("Mobile App: Stock price updated to " + price);
    }
}

// Concrete Observer 2
class WebApp implements Observer {
    public void update(double price) {
        System.out.println("Web App: Stock price updated to " + price);
    }
}

// Test Class
public class ObserverPatternExample {
    public static void main(String[] args) {

        StockMarket stock = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        // Register observers
        stock.registerObserver(mobileApp);
        stock.registerObserver(webApp);

        // Change stock price → notifies all observers
        stock.setPrice(100.5);
        stock.setPrice(120.0);

        // Remove one observer
        stock.removeObserver(mobileApp);

        System.out.println("----- After removing Mobile App -----");

        stock.setPrice(150.0);
    }
}