package model;

public class Item {
    private String Item_ID;
    private String Name;
    private int Quantity;
    private int Category_ID; // Foreign key to Category

    public Item(String itemID, String name, int quantity, int categoryID) {
        this.Item_ID = itemID;
        this.Quantity = quantity;
        this.Name = name;
        this.Category_ID = categoryID;
    }

    public String getName() {
        return Name;
    }


    public String getItemId() {
        return Item_ID;
    }
    public int getQuantity() {
        return Quantity;
    }
    public int getCategoryId() {
        return Category_ID;
    }


}
