package model;

import java.util.ArrayList;
import java.util.List;


public class Request {
    private String requestId;
    private String userId;
    private String itemId;
    private int quantity;
    private String status;

    // Static field to keep track of the number of requests
    private static int requestCount = 0;

    private static List<Request> allRequests = new ArrayList<>();


    public Request() {
        requestCount++;
        allRequests.add(this);
    }

   
    public Request(String requestId, String userId, String itemId, int quantity, String status) {
        this.requestId = requestId;
        this.userId = userId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.status = status;
        requestCount++;
        allRequests.add(this);
    }

    // Static method to get the number of requests
    public static int getRequestCount() {
        return requestCount;
    }

    // Static method to get all requests
    public static List<Request> getAllRequests() {
        return allRequests;
    }

    // Getters and setters for encapsulation
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
}
