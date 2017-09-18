/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author kmne6
 */
public class StudentIO {

    public static boolean addStudent(Student s, String path) {

        try {
            File f = new File(path);
            PrintWriter out = new PrintWriter(
                    new FileWriter(f, true));
            out.println(s.toString());
            out.close();
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    // return all students
    public static ArrayList<Student> getStudentList(String path) {

        ArrayList<Student> sList = new ArrayList<>();

        String s;
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));

            s = in.readLine();
            while (s != null) {
                Student stud = parseStudent(s);
                sList.add(stud);
                s = in.readLine();
            }
            in.close();

        } catch (FileNotFoundException e) {
            //  sList.add("File not found.");
        } catch (IOException e) {
            //  sList.add("Error reading " + path);
        }

        return sList;
    }

    private static Student parseStudent(String s) {

        Student stud = new Student();

        // split string into an array of strings
        try {
            String[] sarray = s.split(", ");

            stud.setStudentID(sarray[0]);
            stud.setLastName(sarray[1]);
            stud.setFirstName(sarray[2]);
            stud.setQuiz1(Double.parseDouble(sarray[3]));
            stud.setQuiz2(Double.parseDouble(sarray[4]));
            stud.setQuiz3(Double.parseDouble(sarray[5]));
            stud.setQuiz4(Double.parseDouble(sarray[6]));
            stud.setQuiz5(Double.parseDouble(sarray[7]));
            stud.setQuizMkUp(Double.parseDouble(sarray[8]));
            stud.setMidterm(Double.parseDouble(sarray[9]));
            stud.setProblems(Double.parseDouble(sarray[10]));
            stud.setFinalExam(Double.parseDouble(sarray[11]));

        } catch (Exception e) {
            return (new Student());
        }
        return stud;
    }

}
