/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

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
}
