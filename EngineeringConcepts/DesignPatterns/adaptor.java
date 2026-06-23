// Target Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Adaptee 1 - Different Payment Gateway (PayPal style)
class PayPalGateway {
    public void sendPayment(double amount) {
        System.out.println("Payment of " + amount + " processed via PayPal");
    }
}

// Adaptee 2 - Different Payment Gateway (Stripe style)
class StripeGateway {
    public void makeCharge(double amount) {
        System.out.println("Payment of " + amount + " processed via Stripe");
    }
}

// Adapter for PayPal
class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPal = new PayPalGateway();

    public void processPayment(double amount) {
        payPal.sendPayment(amount);
    }
}

// Adapter for Stripe
class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe = new StripeGateway();

    public void processPayment(double amount) {
        stripe.makeCharge(amount);
    }
}

// Test Class
public class AdapterPatternExample {
    public static void main(String[] args) {

        PaymentProcessor paypal = new PayPalAdapter();
        paypal.processPayment(500);

        PaymentProcessor stripe = new StripeAdapter();
        stripe.processPayment(1000);
    }
}