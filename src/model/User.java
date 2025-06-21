package model;

import java.util.ArrayList;
import java.util.List;



public class User {
    private static int userCount = 0;
    private String userId;
    private String name;
    private String gmail;
    private String role;
    private String phoneNumber;
    private String departmentName;

    public User(String userId, String name, String gmail, String role, String phoneNumber, String departmentName) {
        this.userId = userId;
        this.name = name;
        this.gmail = gmail;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.departmentName = departmentName;
        userCount++;
    }

    public User(String userId, String name, String gmail) {
        this(userId, name, gmail, "", "", "");
    }


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

    public static int getUserCount() {
        return userCount;
    }

    public static List<User> createUserList() {
        return new ArrayList<>();
    }
}
