public class BorrowStatus {
    private String itemId;
    private String userId;
    private String status; // e.g., "borrowed", "returned", "overdue"
    private String borrowDate;
    private String returnDate;

    public BorrowStatus(String itemId, String userId, String status, String borrowDate, String returnDate) {
        this.itemId = itemId;
        this.userId = userId;
        this.status = status;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getItemId() {
        return itemId;
    }

    public String getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        return "BorrowStatus{" +
                "itemId='" + itemId + '\'' +
                ", userId='" + userId + '\'' +
                ", status='" + status + '\'' +
                ", borrowDate='" + borrowDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
