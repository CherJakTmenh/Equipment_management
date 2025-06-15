// BorrowRequest {
//   req_ID integer unique
//   User_ID integer //Foreign_Key
//   Item_ID integer //Foreign_key
//   req_date timestamp
//   req_Status bool
//   Description text
// }

public class BorrowRequest {
    private int Req_ID;
    private int User_ID;
    private int Item_ID;
    private String Req_date;
    private boolean Req_status;
    private String Description;
    

    // public BorrowRequest(String itemId, String userId, String borrowDate, String returnDate) {
    //     this.Req_ID = 0; // Assuming ID will be set by the database
    //     this.User_ID = Integer.parseInt(userId);
    //     this.Item_ID = Integer.parseInt(itemId);
    //     this.Req_date = borrowDate;
    //     this.Req_status = true; // Assuming the request is active when created
    //     this.Description = "Borrow request for item " + itemId + " by user " + userId + " from " + borrowDate + " to " + returnDate;
    // }
    public BorrowRequest(int reqId, int userId, int itemId, String reqDate, boolean reqStatus, String description) {
        this.Req_ID = reqId;
        this.User_ID = userId;
        this.Item_ID = itemId;
        this.Req_date = reqDate;
        this.Req_status = reqStatus;
        this.Description = description;
    }
    public int getReqId() {
        return Req_ID;
    }
    public String getItemId() {
        return String.valueOf(Item_ID);
    }

    public String getUserId() {
        return String.valueOf(User_ID);
    }

    public String getRequest_date() {
        return Req_date;
    }

    public boolean isRequestStatus() {
        return Req_status;
    }
    public String getDescription() {
        return Description;
    }

}
