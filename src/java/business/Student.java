/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Arrays;

/**
 *
 * @author kmne6
 */
public class Student {
    
    private String studentID, lastName, firstName;
    private double q1, q2, q3, q4, q5, qmkup;
    private double midterm, problems, finalExam;
    
    public Student() {
        this.studentID = "";
        this.lastName = "";
        this.firstName = "";
        this.q1 = 0;
        this.q2 = 0;
        this.q3 = 0;
        this.q4 = 0;
        this.q5 = 0;
        this.qmkup = 0;
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
        return q1;
    }

    public void setQuiz1(double quiz1) {
        this.q1 = quiz1;
    }

    public double getQuiz2() {
        return q2;
    }

    public void setQuiz2(double quiz2) {
        this.q2 = quiz2;
    }

    public double getQuiz3() {
        return q3;
    }

    public void setQuiz3(double quiz3) {
        this.q3 = quiz3;
    }

    public double getQuiz4() {
        return q4;
    }

    public void setQuiz4(double quiz4) {
        this.q4 = quiz4;
    }

    public double getQuiz5() {
        return q5;
    }

    public void setQuiz5(double quiz5) {
        this.q5 = quiz5;
    }

    public double getQuizMkUp() {
        return qmkup;
    }

    public void setQuizMkUp(double quizMkUp) {
        this.qmkup = quizMkUp;
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
        double[] largeGrades = this.getLargestQuizGrades();
        
        return this.studentID + ", " + this.lastName + ", " +
                this.firstName + ", " + this.q1 + ", " +
                this.q2 + ", " + this.q3 + ", " +
                this.q4 + ", " + this.q5 + ", " +
                this.qmkup + ", " + this.midterm + ", " +
                this.finalExam + ", " + "Largest quiz grades: " +
                largeGrades[0] + ", " + 
                largeGrades[1] + ", " +
                largeGrades[2] + ", " +
                largeGrades[3] + ", " + 
                largeGrades[4] + ", end array";
    }
    
    /**
     * The calculation of the grade is based on the following rules:
     * 50% for Quiz Average,
     * 15% for the MidTerm,
     * 10% for the Problems,
     * 25% for the final exam (except where not required – see below)
     * 
     * The quiz average is calculated from only the highest 4 scores; 
     * a quiz make-up test may or may not have been taken, 
     * but if it was, it should be considered along with all the other scores
     * as a possible quiz to be among the 4 counted for the grade.
     * 
     * @return 
     */
    public double calculateCourseGrade() {
        
        double courseGrade = 0;
        
        
        
        return courseGrade;
    }
    
    
    public double[] getLargestQuizGrades() {
        
        double[] scores = {q1, q2, q3, q4, q5, qmkup};
        double[] largestQuizzes = null;
        Arrays.sort(scores);
        
        largestQuizzes = Arrays.copyOfRange(scores, 1, scores.length);
        
        for(double quiz : largestQuizzes) {
            System.out.println(quiz);
        }
        
        return largestQuizzes;
    }
}
