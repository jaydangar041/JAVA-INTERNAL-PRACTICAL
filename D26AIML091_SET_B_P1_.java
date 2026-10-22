
import java.util.Scanner;

class Product {
    private final String name;
    private final int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    static Product findProduct(char code) {
        return switch (code) {
            case 'N' -> new Product("Notebook", 45);
            case 'P' -> new Product("Pen", 10);
            case 'M' -> new Product("Marker", 25);
            case 'F' -> new Product("File", 30);
            default -> null;
        };
    }
}

class Purchase {
    private int receiptNo;
    private Product product;
    private int quantity;

    private static int nextReceipt = 201;
    private static int totalPurchases = 0;
    private static int totalRevenue = 0;

    Purchase(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.receiptNo = nextReceipt++;

        totalPurchases++;
        totalRevenue += getAmount();
    }

    public int getAmount() {
        return product.getPrice() * quantity;
    }

    public static int getTotalPurchases() {
        return totalPurchases;
    }

    public static int getTotalRevenue() {
        return totalRevenue;
    }

    @Override
    public String toString() {
        return "Receipt " + receiptNo + ": "
                + product.getName() + " x "
                + quantity + " = " + getAmount();
    }
}

public class D26AIML091_SET_B_P1_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Product Purchase System =====");
        System.out.println("Available Products:");
        System.out.println("N - Notebook (Rs. 45)");
        System.out.println("P - Pen      (Rs. 10)");
        System.out.println("M - Marker   (Rs. 25)");
        System.out.println("F - File     (Rs. 30)");
        System.out.println("Enter the product code and quantity.");
        System.out.println("Quantity must be greater than 0.");
        System.out.print("Enter number of purchases: ");

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nPurchase " + (i + 1) + ":");
            System.out.print("Enter product code (N/P/M/F): ");
            char code = sc.next().charAt(0);

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();

            Product product = Product.findProduct(
                Character.toUpperCase(code)
            );

            if (product == null || quantity <= 0) {
                System.out.println(
                    "Invalid item: " + code + " " + quantity
                );
            } else {
                Purchase purchase = new Purchase(product, quantity);
                System.out.println(purchase);
            }
        }

        System.out.println(
            "\nTotal receipts: " + Purchase.getTotalPurchases()
            + ", Total revenue: " + Purchase.getTotalRevenue()
        );

        sc.close();
    }
}
