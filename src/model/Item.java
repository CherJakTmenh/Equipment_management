package model;

import java.util.ArrayList;
import java.util.List;


// Represents an item entity from the database
public class Item {
    // Fields (private for encapsulation)
    private String itemId;
    private String name;
    private int quantity;
    private int categoryId;

    // Static field
    private static int itemCount = 0;


    private static List<Item> items = new ArrayList<>();


    // Constructor
    public Item(String itemId, String name, int quantity, int categoryId) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
        this.categoryId = categoryId;
        itemCount++;
        items.add(this);
    }

    // Overloaded constructor (no category)
    public Item(String itemId, String name, int quantity) {
        this(itemId, name, quantity, -1); // -1 means no category
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

    // Static method to get total items created
    public static int getItemCount() {
        return itemCount;
    }

    // Static method to get all items
    public static List<Item> getAllItems() {
        return items;
    }
}
