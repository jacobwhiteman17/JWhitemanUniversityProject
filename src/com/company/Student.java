package com.company;

public class Student {
    private int studentID;
    private static int nextID = 2000;//may need to make static?
    private float gpa;
    private Professor advisor;
    private int numberOfCredits;
    private String name;

    Student(Professor initialAdvisor, String studentName){
        name = studentName;
        advisor = initialAdvisor;
        gpa = 0.0f;
        numberOfCredits = 0;
        studentID = nextID;//update?
        nextID++;
    }

    public void takeClass(int credits, float grade){//fix this at the end
        numberOfCredits = credits;
        gpa = grade/numberOfCredits;
    }

    public void changeAdvisor(Professor newAdvisor){
        advisor = newAdvisor;
    }

    public float getGPA(){
        return gpa;
    }

    public int getCreditHours(){
        return numberOfCredits;
    }

    public int getStudentID(){
        return studentID;
    }

    public Professor getAdvisor() {
        return advisor;
    }

    public String toString(){
        String studentInfo = "Name: "+name+" studentID: "+studentID+" Advisor's Name: "+advisor+" GPA: "+gpa;
        return studentInfo;
    }
}
