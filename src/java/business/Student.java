/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author kmne6
 */
public class Student {
    
    private String studentID, lastName, firstName;
    private double quiz1, quiz2, quiz3, quiz4, quiz5, quizMkUp;
    private double midterm, problems, finalExam;
    
    public Student() {
        this.studentID = "";
        this.lastName = "";
        this.firstName = "";
        this.quiz1 = 0;
        this.quiz2 = 0;
        this.quiz3 = 0;
        this.quiz4 = 0;
        this.quiz5 = 0;
        this.quizMkUp = 0;
        this.midterm = 0;
        this.problems = 0;
        this.finalExam = 0;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getQuiz1() {
        return quiz1;
    }

    public void setQuiz1(double quiz1) {
        this.quiz1 = quiz1;
    }

    public double getQuiz2() {
        return quiz2;
    }

    public void setQuiz2(double quiz2) {
        this.quiz2 = quiz2;
    }

    public double getQuiz3() {
        return quiz3;
    }

    public void setQuiz3(double quiz3) {
        this.quiz3 = quiz3;
    }

    public double getQuiz4() {
        return quiz4;
    }

    public void setQuiz4(double quiz4) {
        this.quiz4 = quiz4;
    }

    public double getQuiz5() {
        return quiz5;
    }

    public void setQuiz5(double quiz5) {
        this.quiz5 = quiz5;
    }

    public double getQuizMkUp() {
        return quizMkUp;
    }

    public void setQuizMkUp(double quizMkUp) {
        this.quizMkUp = quizMkUp;
    }

    public double getMidterm() {
        return midterm;
    }

    public void setMidterm(double midterm) {
        this.midterm = midterm;
    }

    public double getProblems() {
        return problems;
    }

    public void setProblems(double problems) {
        this.problems = problems;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }
    
    
    public String toString() {
        return this.studentID + ", " + this.lastName + ", " +
                this.firstName + ", " + this.quiz1;
    }
}
