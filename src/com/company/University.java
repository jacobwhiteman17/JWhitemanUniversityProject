package com.company;

import java.util.ArrayList;
import java.util.Optional;

public class University {
    private ArrayList<Student> studentList;
    private ArrayList<Professor> faculty;

    University(){
        studentList = new ArrayList<Student>();
        faculty = new ArrayList<Professor>();
    }

    public Optional findStudent(int studentID){
        studentList = new ArrayList<Student>();
        for (var student: studentList){//fix this later? says list is always empty
            if(student.getStudentID()==studentID){
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    public void hireProfessor(Professor newFaculty){
        var newMember = newFaculty;
        faculty.add(newMember);
    }

    public void  admitStudent(Student newStudent){
        var newKid = newStudent;
        studentList.add(newKid);
    }

    public void graduateStudents(){
        studentList = new ArrayList<Student>(){};
        for(var student: studentList){
            if(student.getGPA()>=2 && student.getCreditHours()>=20){//might have to change this?
                studentList.remove(student);
                System.out.println("CONGRATULATIONS "+student);
                if(student.getGPA()>=3.7){
                    System.out.println("You graduated with high honors! WOW!");
                }
                if(student.getGPA()<=3.3 && student.getGPA()>=3){
                    System.out.println("You graduated with honors! Nice!");
                }
            }
            System.out.println("Sorry, try again!");
        }
    }

    public void runUniversity(){

    }
}
