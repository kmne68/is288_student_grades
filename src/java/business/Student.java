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
    
    private static final double QUIZPROP = 0.50;
    private static final double MIDTERMPROP = 0.15;
    private static final double PROBLEMSPROP = 0.10;
    private static final double FINALPROP = 0.25;
    private static final int QUIZZESDROPPED = 2;    // works as the starting index in selecting highest scores
    
    private String studentID, lastName, firstName;
    char letterGrade;
    private double q1, q2, q3, q4, q5, qmkup, quizAverage;
    private double midterm, problems, finalExam;
    private double courseGrade;
    
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
        this.courseGrade = 0;
        this.quizAverage = 0;
        this.letterGrade = ' ';
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

    /*
    public char getLetterGrade() {
        return this.letterGrade;
    }
    
    public double getCourseGrade() {
        return this.courseGrade;
    }
    */
    
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
    //    double[] largeGrades = this.getLargestQuizGrades();
        
        return this.studentID + ", " + this.lastName + ", " +
                this.firstName + ", " + this.q1 + ", " +
                this.q2 + ", " + this.q3 + ", " +
                this.q4 + ", " + this.q5 + ", " +
                this.qmkup + ", " + this.midterm + ", " +
                this.problems + ", " +
                this.finalExam + ", " + this.courseGrade + ", " +
                this.letterGrade;
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
    public double getCourseGrade() {
        
        this.courseGrade = QUIZPROP * getQuizAverage() + MIDTERMPROP * this.midterm +
                PROBLEMSPROP * this.problems + FINALPROP * this.finalExam;

        return courseGrade;
    }
    
    
    public char getLetterGrade() {
        
        if(this.courseGrade >= 90.0 || (this.quizAverage >= 90.0 && this.midterm >= 90.0 && this.problems >= 90.0)) {
            letterGrade = 'A';
        }
        else if(this.courseGrade >= 80.0 && this.courseGrade <= 89.99) {
            letterGrade = 'B';
        }
        else if(this.courseGrade >= 70.0 && this.courseGrade <= 79.99) {
            letterGrade = 'C';
        }
        else if(this.courseGrade >= 60.0 && this.courseGrade <= 69.99) {
            letterGrade = 'D';
        }
        else if(this.courseGrade <= 50) {
            letterGrade = 'F';
        }
        
        return letterGrade;
    }
    
    
    // Get average of four highest quiz scores
    public double getQuizAverage() {
        
        double[] quizScores = getLargestQuizGrades();
        double quizSum = 0;
        int quizzes = 0;
        
        for(double score : quizScores) {
            quizzes++;
            quizSum += score;
        }
        
        quizAverage = quizSum / quizzes;    
        
        return quizAverage;
    }
    
    
    public double[] getLargestQuizGrades() {
        double[] sortedArray = null;
        double[] scores = {q1, q2, q3, q4, q5, qmkup};
        double[] largestQuizzes = null;
        Arrays.sort(scores);
        largestQuizzes = Arrays.copyOfRange(scores, QUIZZESDROPPED, scores.length);
        
        for(double quiz : largestQuizzes) {
            System.out.println(quiz);
        }
        
        return largestQuizzes;
    }
    
}
