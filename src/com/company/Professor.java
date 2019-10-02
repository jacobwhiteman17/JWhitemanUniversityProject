package com.company;

import java.util.ArrayList;

public class Professor {
    private ArrayList<Student> adviseeList;
    private String name;
    private String department;

    Professor(String profName, String dept){
        name = profName;
        department = dept;
        adviseeList = new ArrayList<Student>();
    }

    public void addAdvisee(Student newAdvisee){
        var student = newAdvisee;
        adviseeList.add(student);
    }

    public void removeAdvisee(Student formerAdvisee){
        var student = formerAdvisee;
        adviseeList.remove(student);
    }

    public String getName(){
        return name;
    }

    public String toString(){
        String profInfo = "Professor: "+name+" Department: "+department;
        return profInfo;
    }
}
