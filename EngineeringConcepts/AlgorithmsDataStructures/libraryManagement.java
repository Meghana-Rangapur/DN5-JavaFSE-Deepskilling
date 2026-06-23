class Book {
    int bookId;
    String title;
    String author;

    // Constructor
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    // Display method
    public void display() {
        System.out.println("Book ID: " + bookId +
                ", Title: " + title +
                ", Author: " + author);
    }
}

class LibrarySearch {

    // Linear Search by title
    public static Book linearSearch(Book[] books, String targetTitle) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].title.equalsIgnoreCase(targetTitle)) {
                return books[i];
            }
        }
        return null;
    }

    // Binary Search by title (array must be sorted by title)
    public static Book binarySearch(Book[] books, String targetTitle) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int result = books[mid].title.compareToIgnoreCase(targetTitle);

            if (result == 0) {
                return books[mid]; // found
            } 
            else if (result < 0) {
                low = mid + 1; // search right half
            } 
            else {
                high = mid - 1; // search left half
            }
        }

        return null; // not found
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {

        // Unsorted array for linear search
        Book[] books1 = {
                new Book(101, "Java", "James Gosling"),
                new Book(102, "Python", "Guido van Rossum"),
                new Book(103, "DBMS", "Korth"),
                new Book(104, "Operating Systems", "Galvin"),
                new Book(105, "Computer Networks", "Tanenbaum")
        };

        // Linear Search
        System.out.println("Linear Search Result:");
        Book found1 = LibrarySearch.linearSearch(books1, "DBMS");
        if (found1 != null) {
            found1.display();
        } else {
            System.out.println("Book not found.");
        }

        System.out.println();

        // Sorted array by title for binary search
        Book[] books2 = {
                new Book(105, "Computer Networks", "Tanenbaum"),
                new Book(103, "DBMS", "Korth"),
                new Book(101, "Java", "James Gosling"),
                new Book(104, "Operating Systems", "Galvin"),
                new Book(102, "Python", "Guido van Rossum")
        };

        // Binary Search
        System.out.println("Binary Search Result:");
        Book found2 = LibrarySearch.binarySearch(books2, "Java");
        if (found2 != null) {
            found2.display();
        } else {
            System.out.println("Book not found.");
        }
    }
}