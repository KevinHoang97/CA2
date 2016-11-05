package com.shared.ca.java;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by Konrad Gladysz on 02/11/2016.
 * This class is part of 'CA2 for Java'.
 */
public class Menu {

    private ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        new Menu();
    }
    private Menu() {
        auth();
    }
    private void auth() {
        Scanner input = new Scanner(System.in);
        String user;
        String password;
        for(int i = 3; i <= 3; i--) {
            if(i == 0) {
                System.out.println("You have failed to login!");
                System.exit(0);
            }
            System.out.print("\nYou have " + i + " attempts to log in.");
            System.out.print("\nEnter username: ");
            user = input.nextLine();
            System.out.print("Enter password: ");
            password = input.nextLine();
            if(user.equals("username")&&password.equals("password")){
                landing();
                break;
            }
        }
    }
    private void landing() {
        System.out.println("Eagle has landed! :)");
    }
}
