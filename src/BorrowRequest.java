// BorrowRequest {
//   req_ID integer unique
//   User_ID integer //Foreign_Key
//   Item_ID integer //Foreign_key
//   req_date timestamp
//   req_Status bool
//   Description text
// }

public class BorrowRequest {
    private String itemId;
    private String userId;
    private String borrowDate;
    private String returnDate;

    public BorrowRequest(String itemId, String userId, String borrowDate, String returnDate) {
        this.itemId = itemId;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getItemId() {
        return itemId;
    }

    public String getUserId() {
        return userId;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }
}
