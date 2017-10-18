/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.Student;
import business.StudentIO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kmne6
 */
public class CalculateGradesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // TODO: Need to check for erros in input
    // if there is an error we want to go back to the jsp to ask for correct info
    // but keep any that is correct
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String grades[] = {"q1", "q2", "q3", "q4", "q5", "qmkup", "midterm", "probs", "final"};
        String URL = "/StudentGrade.jsp";
        String emsg = "";
        Student s = new Student();

        try {
            String sid = request.getParameter("sid"); // parameter must match name used in form
            String lname = request.getParameter("lastname");
            String fname = request.getParameter("firstname");

            if (sid.isEmpty() || lname.isEmpty() || fname.isEmpty()) {
                emsg += "Bad/missing ID fields<br>";
            } else {

                s.setStudentID(sid);
                s.setLastName(lname);
                s.setFirstName(fname);
            }
        } catch (Exception e) {
            emsg += "Servlet exception on ID: " + e.getMessage() + "<br>";
        }
        // try to create and set all numeric fields
        for (String grade : grades) {
            try {
                String gradeField = request.getParameter(grade);
                if (!gradeField.isEmpty()) {
                    double parsedGrade = Double.parseDouble(gradeField);
                    if (!Character.isDigit(gradeField.charAt(0))) {
                        parsedGrade = 0;
                        throw new NumberFormatException("score must be numeric");
                    } else
                    if (parsedGrade < 0 || parsedGrade > 125 ) {
                        throw new NumberFormatException("score out of bounds");
                    } else {

                        switch (grade) {
                            case "q1":
                                s.setQuiz1(parsedGrade);
                                break;
                            case "q2":
                                s.setQuiz2(parsedGrade);
                                break;
                            case "q3":
                                s.setQuiz3(parsedGrade);
                                break;
                            case "q4":
                                s.setQuiz4(parsedGrade);
                                break;
                            case "q5":
                                s.setQuiz5(parsedGrade);
                                break;
                            case "qmkup":
                                s.setQuizMkUp(parsedGrade);
                                break;
                            case "midterm":
                                s.setMidterm(parsedGrade);
                                break;
                            case "probs":
                                s.setProblems(parsedGrade);
                                break;
                            case "final":
                                s.setFinalExam(parsedGrade);
                        }
                    }

                } else {
                    emsg += grade + " is empty<br>";
                }
            } catch (NumberFormatException e) {
                emsg += grade + " error: " + e.getMessage() + "<br>";
            }
        }
        try {
            String sq1 = request.getParameter("q1");
            if (!sq1.isEmpty()) {    // if sq1 isn't empty, can it be parsed to a double?
                double q1 = Double.parseDouble(sq1);
                if (q1 < 0 || q1 > 125) {
                    throw new NumberFormatException("score out of bounds");
                } else {
                    //                   s.setq1(q1);
                }
            } else {
                emsg += "Q1 is empty <br>";
            }
        } catch (NumberFormatException e) {
            emsg += "Q1 error: " + e.getMessage() + "<br>";
        }

        // repeat for all scores except MakeUp quiz can be empty (=0)
        // if it is empty, set it to zero
        // consider a servlet that doesn't repeat each entry
        request.setAttribute("student", s);

        if (!emsg.isEmpty()) { // if error message is not empty...
            URL = "/students.jsp";
            request.setAttribute("emsg", emsg);
        } else {
            ServletContext context = getServletContext();
            String path = context.getRealPath("/WEB-INF/classlist.txt");

            // if it comes back false we have an issue
            if (!StudentIO.addStudent(s, path)) {
                emsg = "Unable to save Student<br>";
            } else {
                emsg = "Student record saved.<br>";
            }
            request.setAttribute("emsg", emsg);

        }

        RequestDispatcher disp = getServletContext().getRequestDispatcher(URL);
        disp.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
