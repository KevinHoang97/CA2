package com.shared.ca.java;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by Konrad Gladysz on 02/11/2016.
 * This class is part of 'CA2 for Java'.
 */
public class Menu {

    private ArrayList<Student> students = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private static int fee = 3000;

    public static void main(String[] args) {
        new Menu();
        // Debug
    }
    private Menu() {
        auth();
        // Debug
        String[] sub = {"Software Development","Mathematics","Learning to Learn","Computer Architecture"};
        int[] marks = {100,90,80,70};
        students.add(new Student("X00127485", "pass", "Konrad Gladysz",sub,marks));
    }
    private void auth() {
        String user;
        String password;
        for(int i = 3; i <= 3; i--) {
            if(i == 0) {
                System.out.println("You have failed to login!");
                System.exit(0);
            }
            System.out.print("\nYou have " + i + " attempts to log in.");
            System.out.print("\nEnter username(xid): ");
            user = input.nextLine();
            System.out.print("Enter password: ");
            password = input.nextLine();
            if(!user.equals("")&&user.charAt(0) == 'X'){
                for(Student tmp: students) {
                    if(tmp.getId().equals(user)) {
                        if(tmp.getPasswd().equals(password)) {
                            landing(user);
                        }
                    }
                }
            } else {
                System.out.println("Wrong username or password.");
            }
        }
    }
    private void landing(String xid) {
        String choice = "";
        System.out.println("\t\tStudent Finance System");
        System.out.println("1. Calculate Student Grant");
        System.out.println("2. Current Overall Student Average");
        System.out.println("3. Fee Data");
        System.out.println("4. Grant Category Information");
        System.out.println("5. Exit");
        while (choice.equals(""))
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    register();
                    studentGrant(xid);
                    break;
                case "2":
                    System.out.println("Your current overall average result is: " + studentAvg(xid));
                    break;
                case "3":
                    //feeData();
                    break;
                case "4":
                    //grantCategoryInformation();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Input error.");
                    landing(xid);
        }
    }
    private void register() {
        String id = "";
        String name = "";
        String[] subjects = {"Software Development","Mathematics","Learning to Learn","Computer Architecture"};
        int[] marks = new int[subjects.length];
        for(int i = 0; i < 3; i++) {
            System.out.print("\nEnter student id: ");
            id = input.nextLine();
            if(id.charAt(0) == 'X') {
                break;
            }
            if(i == 2) {
                register();
            }
        }
        for(int i = 0; i < 3; i++) {
            System.out.print("\nEnter student name: ");
            name = input.nextLine();
            if(!name.equals("")) {
                break;
            }
            if(i == 2) {
                register();
            }
        }
        for(int i = 0; i < marks.length; i++) {
            System.out.print("\nEnter mark for "+subjects[i]+": ");
            marks[i] = input.nextInt();
        }
        String passwd = "";
        for(int i = 0; i < 3; i++) {
            System.out.print("\n Create a password");
            passwd = input.nextLine();
            if(passwd.equals("")) {

            }

        }
        students.add(new Student(id,passwd,name,subjects,marks));
        landing();
    }
    private void  studentGrant(String xid) {
        for(Student temp: students) {
            double avg = studentAvg(temp.getId());
            if (avg >=  90) {
                System.out.println("You are eligible for: " + fee / 1.0 + " which is : 100%");
                temp.setGrantStat(100);
            }
            else if (avg < 90) {
                System.out.println("You are eligible for: " + fee / .75 + " which is : 75%");
                temp.setGrantStat(75);
            }
            else if(avg < 70) {
                System.out.println("You are eligible for: " + fee / .50 + " which is : 50%");
                temp.setGrantStat(50);
            }
            else if (avg < 50) {
                System.out.println("You are not eligible for a grant.");
                temp.setGrantStat(0);
            }
        }
        landing(xid);
    }
    private double studentAvg(String xid) {
        int[] marks = new int[0];
        for(Student temp: students) {
            if(temp.getId().equals(xid)) {
                marks = temp.getMarksArray();
            }
        }
        double avg = 0.0;
        for(int i = 0; i < marks.length; i++) {
            avg += marks[i];
        }
        avg /= marks.length;
        return avg;
    }
}
