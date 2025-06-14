public class ItemLog {
    private String itemId;
    private String userId;
    private String action;
    private String timestamp;

    public ItemLog(String itemId, String userId, String action, String timestamp) {
        this.itemId = itemId;
        this.userId = userId;
        this.action = action;
        this.timestamp = timestamp;
    }

    public String getItemId() {
        return itemId;
    }

    public String getUserId() {
        return userId;
    }

    public String getAction() {
        return action;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "ItemLog{" +
                "itemId='" + itemId + '\'' +
                ", userId='" + userId + '\'' +
                ", action='" + action + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
