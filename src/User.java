public class User {
    private String User_ID;
    private String Name;
    private String Gmail;
    private String Role;
    private String Phone_Number;
    private String Department_Name;

    public User(String userId, String name, String email, String role, String phoneNumber, String departmentName) {
        this.User_ID = userId;
        this.Name = name;
        this.Gmail = email;
        this.Role = role;
        this.Phone_Number = phoneNumber;
        this.Department_Name = departmentName;
    }

    public String getUserId() {
        return User_ID;
    }

    public String getName() {
        return Name;
    }

    public String getGmail() {
        return Gmail;
    }

    public String getRole() {
        return Role;
    }

    public String getPhoneNumber() {
        return Phone_Number;
    }

    public String getDepartmentName() {
        return Department_Name;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + User_ID + '\'' +
                ", name='" + Name + '\'' +
                ", email='" + Gmail + '\'' +
                ", role='" + Role + '\'' +
                ", phoneNumber='" + Phone_Number + '\'' +
                ", departmentName='" + Department_Name + '\''+
                '}';
    }   
}
