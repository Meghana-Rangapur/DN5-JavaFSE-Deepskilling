class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return productId + " | " + productName + " | Qty: " + quantity + " | Price: " + price;
    }
}

import java.util.*;

class InventorySystem {

    private HashMap<Integer, Product> inventory = new HashMap<>();

    // Add product
    public void addProduct(Product product) {
        inventory.put(product.productId, product);
        System.out.println("Product added: " + product.productName);
    }

    // Update product
    public void updateProduct(int id, int quantity, double price) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product updated: " + p.productName);
        } else {
            System.out.println("Product not found!");
        }
    }

    // Delete product
    public void deleteProduct(int id) {
        if (inventory.remove(id) != null) {
            System.out.println("Product deleted: " + id);
        } else {
            System.out.println("Product not found!");
        }
    }

    // Display all products
    public void showInventory() {
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {

        InventorySystem system = new InventorySystem();

        // Add products
        system.addProduct(new Product(101, "Laptop", 10, 55000));
        system.addProduct(new Product(102, "Mouse", 50, 500));

        // Display
        system.showInventory();

        // Update product
        system.updateProduct(101, 8, 52000);

        // Delete product
        system.deleteProduct(102);

        System.out.println("----- Final Inventory -----");
        system.showInventory();
    }
}