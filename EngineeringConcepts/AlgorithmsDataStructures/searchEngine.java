class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}
class Search {

    // Linear Search
    public static Product linearSearch(Product[] arr, String name) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].productName.equalsIgnoreCase(name)) {
                return arr[i];
            }
        }
        return null;
    }
}
class BinarySearch {

    public static Product binarySearch(Product[] arr, String name) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int compare = arr[mid].productName.compareToIgnoreCase(name);

            if (compare == 0) {
                return arr[mid];
            }
            else if (compare < 0) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return null;
    }
}
public class EcommerceSearch {
    public static void main(String[] args) {

        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Mouse", "Electronics"),
            new Product(3, "Shoes", "Fashion"),
            new Product(4, "Phone", "Electronics")
        };

        // Linear Search
        Product result1 = Search.linearSearch(products, "Mouse");
        System.out.println("Linear Search Result: " + result1.productName);

        // Sorted array for binary search (by name)
        Product[] sortedProducts = {
            new Product(2, "Mouse", "Electronics"),
            new Product(1, "Laptop", "Electronics"),
            new Product(4, "Phone", "Electronics"),
            new Product(3, "Shoes", "Fashion")
        };

        Product result2 = BinarySearch.binarySearch(sortedProducts, "Phone");
        System.out.println("Binary Search Result: " + result2.productName);
    }
}