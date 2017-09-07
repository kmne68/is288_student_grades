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

    </body>
    ${emsg}
</html>
