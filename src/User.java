import java.util.ArrayList;
import java.util.List;

public class User {
    // Static field to keep track of total users
    private static int userCount = 0;

    // Private fields (encapsulation)
    private String userId;
    private String name;
    private String gmail;
    private String role;
    private String phoneNumber;
    private String departmentName;

    // Default constructor (overloading)
    public User() {
        userCount++;
    }

    // Parameterized constructor (overloading)
    public User(String userId, String name, String gmail, String role, String phoneNumber, String departmentName) {
        this.userId = userId;
        this.name = name;
        this.gmail = gmail;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.departmentName = departmentName;
        userCount++;
    }

    // Public getters and setters (encapsulation)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    // Static method to get total users
    public static int getUserCount() {
        return userCount;
    }

    // Example usage of a collection (ArrayList)
    // We use ArrayList because it allows dynamic resizing and fast access by index.
    public static List<User> createUserList() {
        List<User> users = new ArrayList<>();
        users.add(new User("U001", "Alice", "alice@gmail.com", "Admin", "123456789", "IT"));
        users.add(new User("U002", "Bob", "bob@gmail.com", "User", "987654321", "HR"));
        return users;
    }
}
