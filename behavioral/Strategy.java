/**
 * Strategy pattern is used when we have multiple algorithm for a specific task and client decides the actual implementation to be used at runtime.
 * This pattern comes under behavior pattern category.
 * In Strategy pattern, we create objects which represent various strategies and a context object whose behavior varies as per its strategy object.
 * The strategy object changes the executing algorithm of the context object.
 */

interface PaymentStrategy {
    void pay(int amount);
}

class CardPayment implements PaymentStrategy {
    private final String cardNumber;
    private final String name;

    CardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    @Override
    public void pay(int amount) {
        System.out.printf("Paid %d INR using card %s\n", amount, cardNumber);
    }
}

class UpiPayment implements PaymentStrategy {
    private final String upiId;

    UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(int amount) {
        System.out.printf("Paid %d INR using upi id %s\n", amount, upiId);
    }
}

class ShoppingCart {
    private final PaymentStrategy paymentStrategy;

    ShoppingCart(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        System.out.println("Checking out shopping cart..");
        this.paymentStrategy.pay(amount);
    }
}

public class Strategy {

    public static void main(String[] args) {
        PaymentStrategy p1 = new CardPayment("1234-5678-9876-5432", "John Doe");
        ShoppingCart s1 = new ShoppingCart(p1);

        PaymentStrategy p2 = new UpiPayment("userid@sbi");
        ShoppingCart s2 = new ShoppingCart(p2);

        s1.checkout(100);
        s2.checkout(5000);
    }

}


