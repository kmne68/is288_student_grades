<%-- 
    Document   : ClassList
    Created on : Sep 12, 2017, 9:08:06 PM
    Author     : kmne6
--%>

<%@page import="business.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Class List</title>
    </head>
    <body>
        <h1>Students on File</h1>
        
        <table border="1">
            <tr>
                <th>Student ID</th>
                <th>Name</th>
                <th>Quiz 1</th>
                <th>Quiz 2</th>
                <th>Quiz 3</th>
                <th>Quiz 4</th>
                <th>Quiz 5</th>
                <th>Quiz MkUp</th>
                <th>Midterm</th>
                <th>Problems</th>
                <th>Final</th>
                <th>Course</th>
                <th>Grade</th>
                <%
                    ArrayList<Student> sList = (ArrayList<Student>) request.getAttribute("stulist");
                    
                    for(int i = 0; i < sList.size(); i++) {
                    %>    
            <tr>
                <td><%= sList.get(i).getStudentID() %></td>
                <td><%= sList.get(i).getLastName() + ", " + sList.get(i).getFirstName() %></td>  
                <td><%= sList.get(i).getQuiz1() %></td>         
                <td><%= sList.get(i).getQuiz2() %></td>  
                <td><%= sList.get(i).getQuiz3() %></td>  
                <td><%= sList.get(i).getQuiz4() %></td>  
                <td><%= sList.get(i).getQuiz5() %></td>  
                <td><%= sList.get(i).getQuizMkUp()%></td>  
                <td><%= sList.get(i).getMidterm() %></td>  
                <td><%= sList.get(i).getProblems() %></td>  
                <td><%= sList.get(i).getFinalExam() %></td>  
                <td><%= sList.get(i).getClass() %></td>                
            </tr>
            <% } %>
        </table>
        <br>
        <a href="students.jsp">New Student</a>
    </body>
    
</html>
