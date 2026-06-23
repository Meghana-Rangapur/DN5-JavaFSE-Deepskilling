// Subject Interface
interface Image {
    void display();
}

// Real Object (loads image from server)
class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromServer(); // heavy operation
    }

    private void loadFromServer() {
        System.out.println("Loading image from remote server: " + fileName);
    }

    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}

// Proxy Class
class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {

        // Lazy initialization (create only when needed)
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }

        // Cache used object, reuse it next time
        realImage.display();
    }
}

// Test Class
public class ProxyPatternExample {
    public static void main(String[] args) {

        Image image1 = new ProxyImage("photo1.jpg");

        // First call → loads image
        image1.display();

        System.out.println("----- Second Call -----");

        // Second call → uses cached image (no reload)
        image1.display();
    }
}