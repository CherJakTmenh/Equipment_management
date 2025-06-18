public class Notification {
    private String Noti_ID;
    private String User_ID;
    private String message;
    private String timestamp;

    public Notification(String notificationId, String userId, String message, String timestamp) {
        this.Noti_ID = notificationId;
        this.User_ID = userId;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getNotificationId() {
        return Noti_ID;
    }

    public String getUserId() {
        return User_ID;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + Noti_ID + '\'' +
                ", userId='" + User_ID + '\'' +
                ", message='" + message + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }   
}
