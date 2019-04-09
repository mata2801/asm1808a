package entity;

public class Employee {
    private String name;
    private String address;
    private String email;
    private String user;

    public Employee(String name, String address, String email, String user) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}