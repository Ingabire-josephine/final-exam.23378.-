package models;

public class User {
    private int id;
    private String username;
    private String address;
    private String phone;
    private String role;
    private String password;

    // Constructor with all fields
    public User(int id, String username, String address, String phone, String role, String password) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.phone = phone;
        this.role = role;
        this.password = password;
    }

    // Constructor without ID (useful for inserting a new user)
    public User(String username, String address, String phone, String role, String password) {
        this.username = username;
        this.address = address;
        this.phone = phone;
        this.role = role;
        this.password = password;
    }

    // Getters
    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getRole() { return role; }
    public String getPassword() { return password; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setAddress(String address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setRole(String role) { this.role = role; }
    public void setPassword(String password) { this.password = password; }
}
