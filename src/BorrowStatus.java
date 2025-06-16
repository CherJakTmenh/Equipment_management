public class BorrowStatus {
    private String Record_ID;
    private int User_ID;
    private int Item_ID; // e.g., "borrowed", "returned", "overdue"
    private String borrowDate;
    private String Return_ID;

    public BorrowStatus(String recordId, int userId, int itemId, String borrowDate, String returnId) {
        this.Record_ID = recordId;
        this.User_ID = userId;
        this.Item_ID = itemId;
        this.borrowDate = borrowDate;
        this.Return_ID = returnId;
    }

    public String getRecordId() {
        return Record_ID;
    }
    public int getUserId() {
        return User_ID;
    }   
    public int getItemId() {
        return Item_ID;
    }
    public String getBorrowDate() {
        return borrowDate;
    }
    public String getReturnId() {
        return Return_ID;
    }

    @Override
    public String toString() {
        return "BorrowStatus{" +
                "Record_ID='" + Record_ID + '\'' +
                ", User_ID=" + User_ID +
                ", Item_ID=" + Item_ID +
                ", borrowDate='" + borrowDate + '\'' +
                ", Return_ID='" + Return_ID + '\'' +
                '}';
    }
}
