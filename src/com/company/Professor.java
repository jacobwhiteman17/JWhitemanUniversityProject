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
}
