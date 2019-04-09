package model;

import connection.Connector;
import entity.Employee;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EmployeeModel {
    private static EmployeeModel instance = null;

    public EmployeeModel() {
    }

    public static EmployeeModel getInstance() {
        if(instance == null) {
            return new EmployeeModel();
        } else {
            return instance;
        }
    }
    public boolean register(Employee e) {
        Connector connector = new Connector();
        try {
            if(!checkExistAccount(e.getUser())) {

                Date date = new Date();
                date.getTime();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter new password");
                String pass = scanner.nextLine();
                connector.stmt.executeUpdate("INSERT INTO employees (name, address, user, password, email, dateRegister, dateUpdate, status)" +
                        " VALUES('" +e.getName()+"','" + e.getAddress() +"','" + e.getUser() + "','" + pass + "','" +
                        e.getEmail() +"','" + dateFormat.format(date) + "','" + dateFormat.format(date) +"', 1)");
                return true;
            } else {
                System.out.println("This account was exist");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean checkExistAccount(String acc) {
        String sql = "SELECT id from employees WHERE  user = '" + acc + "'";

        Connector connector = new Connector();
        try{

            ResultSet rs = connector.stmt.executeQuery(sql);

            if(rs.next()) {
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Employee login(String username, String password) {
        String sql = "SELECT * FROM employees WHERE  user = '" + username + "' AND password = '" + password + "'";
        Connector connector = new Connector();
        Employee e = null;
        try{
            ResultSet rs = connector.stmt.executeQuery(sql);
            if(rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String user = rs.getString("user");
                return new Employee(name, address, email, user);
            } else {
                System.out.println("Dang nhap that bai");
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return e;
    }
}