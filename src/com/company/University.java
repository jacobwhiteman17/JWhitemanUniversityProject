package com.company;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class University {
    private ArrayList<Student> studentList;
    private ArrayList<Professor> faculty;

    University() {
        studentList = new ArrayList<Student>();
        faculty = new ArrayList<Professor>();
    }

    public Optional findStudent(int studentID) {
        studentList = new ArrayList<Student>();
        for (var student : studentList) {//fix this later? says list is always empty
            if (student.getStudentID() == studentID) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    public void hireProfessor(Professor newFaculty) {
        var newMember = newFaculty;
        faculty.add(newMember);
    }

    public void admitStudent(Student newStudent) {
        var newKid = newStudent;
        studentList.add(newKid);
    }

    public void graduateStudents() {
        studentList = new ArrayList<Student>();
        for (var student : studentList) {
            if (student.getGPA() >= 2 && student.getCreditHours() >= 20) {//might have to change this?
                studentList.remove(student);
                System.out.println("CONGRATULATIONS " + student);
                if (student.getGPA() >= 3.7) {
                    System.out.println("You graduated with high honors! WOW!");
                }
                if (student.getGPA() <= 3.3 && student.getGPA() >= 3) {
                    System.out.println("You graduated with honors! Nice!");
                }
            }
            System.out.println("Sorry, try again!");
        }
    }

    private void printMenu() {
        System.out.println("Please Select One of the Following:");
        System.out.println("  [1] Admit Student");
        System.out.println("  [2] Hire Professor");
        System.out.println("  [3] Process Graduation");
        System.out.println("  [4] Look Up Student");
        System.out.println("  [5] Exit the program");
        System.out.print("Type the number of your selection:");
    }

    public void studentMenu(){

    }

    public void runUniversity() {
        var input = new Scanner(System.in);
        var rand = new Random();
        while (true) {
            printMenu();
            var userResponse = input.nextInt();
            input.nextLine();
            switch (userResponse) {
                case 1:
                    System.out.println("Enter your name: ");
                    var name = input.nextLine();
                    var prof = faculty.get(rand.nextInt(faculty.size()+1));//this method does not work yet
                    var newStudent = new Student(prof, name);
                    admitStudent(newStudent);
                    System.out.println(name +" is now admitted");
                    break;
                case 2:
                    System.out.println("Enter the name of the professor:");
                    var profName = input.nextLine();
                    System.out.println("Enter the name of the department ");
                    var profDepart = input.nextLine();
                    var newProfessor = new Professor(profName,profDepart);
                    hireProfessor(newProfessor);
                    System.out.println(profName+" has been hired to the "+profDepart+" department");
                    break;
                case 3:
                    graduateStudents();
                    break;
                case 4:
                    System.out.println("Enter a studentID: ");
                    var studentID = input.nextInt();
                    var student= findStudent(studentID);
                    if (student.isPresent()) {
                        System.out.println(student.toString());
                        System.out.println("Would you like to bring up the student menu? (Type 'Y' if so)");
                        var selectMenu = input.nextLine();
                        if(!selectMenu.toUpperCase().equals("Y"))
                            studentMenu();
                        else
                            break;
                    }
                    else
                        System.out.println("There is no student with that ID");

                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("I don't know how to do that");
            }
        }
    }
}