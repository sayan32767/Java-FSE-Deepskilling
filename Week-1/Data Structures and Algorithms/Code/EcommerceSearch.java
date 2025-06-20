class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }
}

public class EcommerceSearch {
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null;
    }

    private static Product binarySearch(Product[] sortedProducts, int targetId, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        int midId = sortedProducts[mid].getProductId();
        if (midId == targetId) {
            return sortedProducts[mid];
        } else if (midId < targetId) {
            return binarySearch(sortedProducts, targetId, mid + 1, high);
        } else {
            return binarySearch(sortedProducts, targetId, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(203, "Desk Chair", "Furniture"),
            new Product(145, "Running Shoes", "Sports"),
            new Product(307, "Coffee Maker", "Home Appliances")
        };

        Product[] sortedProducts = {
            new Product(101, "Laptop", "Electronics"),
            new Product(145, "Running Shoes", "Sports"),
            new Product(203, "Desk Chair", "Furniture"),
            new Product(307, "Coffee Maker", "Home Appliances")
        };

        Product linearResult = linearSearch(products, 145);
        System.out.println("Linear Search: " + 
            (linearResult != null ? "Found" : "Not Found"));

        Product binaryResult = binarySearch(sortedProducts, 203, 0, sortedProducts.length);
        System.out.println("Binary Search: " + 
            (binaryResult != null ? "Found" : "Not Found"));
    }
}
