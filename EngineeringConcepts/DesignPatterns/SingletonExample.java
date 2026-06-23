public class SingletonExample {
    private static SingletonExample instance;
    private SingletonExample() {
        // Private constructor to prevent instantiation
        System.out.println("SingletonExample instance created.");
    }
    public static SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
        }
        return instance;
    }
    public void log(String message) {
        System.out.println("Log: " + message);
    }

    public static void main(String[] args) {

        SingletonExample singleton1 = SingletonExample.getInstance();
        SingletonExample singleton2 = SingletonExample.getInstance();

        singleton1.log("First message");
        singleton2.log("Second message");

        // Check whether both references point to the same object
        if (singleton1 == singleton2) {
            System.out.println("Only one SingletonExample instance exists.");
        } else {
            System.out.println("Multiple SingletonExample instances exist.");
        }

        System.out.println("singleton1 HashCode: " + singleton1.hashCode());
        System.out.println("singleton2 HashCode: " + singleton2.hashCode());
    }
}
