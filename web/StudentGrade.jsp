<%-- 
    Document   : StudentGrade
    Created on : Aug 29, 2017, 9:41:29 PM
    Author     : kmne6
--%>

<%@page import="business.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grade Results</title>
    </head>
    <body>
        <h1>Student Grade</h1>
        <%
            Student s = (Student) request.getAttribute("student");
        %>
        ID:<%= s.getStudentID()%><br>
        Name:<%= s.getFirstName()%><%= s.getLastName()%><br>
        Quiz 1:<%= s.getQuiz1()%><br>
        Quiz 2:<%= s.getQuiz2()%><br>
        Quiz 3:<%= s.getQuiz3() %><br>
        Quiz 4:<%= s.getQuiz4() %><br>
        Quiz 5:<%= s.getQuiz5() %><br>
        Make up quiz:<%= s.getQuizMkUp() %><br>
        Midterm:<%= s.getMidterm() %><br>
        Problems:<%= s.getProblems() %><br>
        Final Exam:<%= s.getFinalExam() %><br>   
        Course Grade:<%= s.getCourseGrade() %><br>

        <a href="students.jsp">New Student</a>
    </body>
    ${emsg}
</html>
