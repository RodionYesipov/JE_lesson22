package com.yesipov;

import com.yesipov.model.User;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        UserService userService = new UserService();

        userService.removeAll();
        userService.addUser(new User("Rodion", 26));
        userService.addUser(new User("Alex", 55));
        userService.addUser(new User("Ben", 19));

        System.out.println("Primary list of users:");
        System.out.println(Arrays.asList(userService.getAllUsers()));

        System.out.println(userService.getMinId());
        int id = userService.getMinId();
        System.out.println("\n\n\nGet user id = " + id);
        System.out.println(userService.getUser(id));

        System.out.println("\n\n\nGet all users");
        System.out.println(Arrays.asList(userService.getAllUsers()));

        System.out.println("\n\n\nRemove user id = " + id);
        userService.removeUser(id);

        System.out.println("List after remove");
        System.out.println(Arrays.asList(userService.getAllUsers()));

        String name = "Alex";
        System.out.println("\n\n\nRemove user name = " + name);
        userService.removeUserByName(name);

        System.out.println("List after remove");
        System.out.println(Arrays.asList(userService.getAllUsers()));

        Thread.sleep(5000);

        id = userService.getMinId();
        User user = userService.getUser(id);
        System.out.println("\n\n\nUpdate user: \n" + user);
        user.setName("Bagration");
        userService.updateUser(user);

        System.out.println("List after update");
        System.out.println(Arrays.asList(userService.getAllUsers()));

        System.out.println("\n\n\nRemove all users");
        userService.removeAll();

        System.out.println("List after remove");
        System.out.println(Arrays.asList(userService.getAllUsers()));
    }
}
