package com.shared.ca.java;

/**
 * Created by Konrad Gladysz on 05/11/2016.
 * This class is part of 'CA2 for Java'.
 */
public class Student {

    private String id;
    private String passwd;
    private String name;
    private String[] subjects = new String[4];
    private int[] marks = new int[4];
    private int grantStat = 0;

    public Student(String id, String passwd, String name, String[] subjects, int[] marks) {
        this.id = id;
        this.passwd = passwd;
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
    }

    public String getId() {
        return id;
    }
    public String getPasswd() { return passwd; }
    public String getName() {
        return name;
    }
    public String[] getSubjectsArray() {
        return subjects;
    }
    public int[] getMarksArray() {
        return marks;
    }
    public String getSubject(int pos) {
        return subjects[pos];
    }
    public int getMark(int pos) {
        return  marks[pos];
    }
    public void setGrantStat(int grantStat) {
        this.grantStat = grantStat;
    }
    public int getGrantStat() {
        return grantStat;
    }

}
