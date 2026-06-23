// Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategy 1
class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

// Concrete Strategy 2
class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}

// Context Class
class PaymentContext {
    private PaymentStrategy strategy;

    // Set strategy at runtime
    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(double amount) {
        if (strategy == null) {
            System.out.println("No payment method selected!");
        } else {
            strategy.pay(amount);
        }
    }
}

// Test Class
public class StrategyPatternExample {
    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();

        // Use Credit Card
        context.setStrategy(new CreditCardPayment());
        context.executePayment(500);

        // Change strategy at runtime to PayPal
        context.setStrategy(new PayPalPayment());
        context.executePayment(1000);
    }
}