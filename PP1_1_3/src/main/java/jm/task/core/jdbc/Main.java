package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    private static String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static String LOGIN = "root";
    private static String PASSWORD = "root";


    public static void main(String[] args) {
        // реализуйте алгоритм здесь\
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Marat", "Safin", (byte)20);
        userService.saveUser("Ivan", "Ivanov", (byte)24);
        userService.saveUser("Dmitry", "Karpuhin", (byte) 35);
        userService.saveUser("Ruslan", "Stepanov", (byte) 39);
        userService.removeUserById((long)3);

        List<User> user = userService.getAllUsers();
        user.forEach(System.out::println);

        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
