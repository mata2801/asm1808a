package main;

import entity.Employee;
import model.EmployeeModel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        showMenu();




    }
    static EmployeeModel emModel = new EmployeeModel();

    static void showMenu() {
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println("Enter option:  ");
        Scanner scanner = new Scanner(System.in);
        String opt = scanner.nextLine();

        if ("1".equals(opt)) {
            System.out.println("enter name: ");
            String name = scanner.nextLine();
            System.out.println("enter address");
            String address = scanner.nextLine();
            System.out.println("enter email");
            String email = scanner.nextLine();
            System.out.println("enter user");
            String user = scanner.nextLine();
            Employee e = new Employee(name, address, email, user);
            Main.emModel.register(e);
            showMenu();
        } else if ("2".equals(opt)) {
            System.out.println("enter username");
            String username = scanner.nextLine();
            System.out.println("enter password");
            String password = scanner.nextLine();
            Employee employee = Main.emModel.login(username, password);
            System.out.println(employee);
            showMenu();
        } else if ("3".equals(opt)) {
        } else {
            System.out.println("Wrong option. Try again \n");
            showMenu();
        }
    }
}