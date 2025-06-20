import java.util.ArrayList;
import java.util.List;

public class Item {
    // Fields (private for encapsulation)
    private String itemId;
    private String name;
    private int quantity;
    private int categoryId; // Foreign key to Category

    // Static field: keeps track of total items created
    private static int totalItems = 0;

    // Static collection: stores all Item objects
    private static List<Item> items = new ArrayList<>();
    // We use ArrayList because it allows dynamic resizing and fast access by index.

    // Constructor
    public Item(String itemId, String name, int quantity, int categoryId) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
        this.categoryId = categoryId;
        totalItems++;
        items.add(this);
    }

    // Overloaded constructor (quantity defaults to 0)
    public Item(String itemId, String name, int categoryId) {
        this(itemId, name, 0, categoryId);
    }

    // Getters (public for access control)
    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    // Setters (optional, for encapsulation)
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Static method: get total number of items created
    public static int getTotalItems() {
        return totalItems;
    }

    // Static method: get all items
    public static List<Item> getAllItems() {
        return items;
    }
}
