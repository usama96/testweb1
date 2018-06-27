<%-- 
    Document   : SecondPage
    Created on : May 30, 2018, 3:38:21 PM
    Author     : ANONYMOUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Data</title>        
    </head>
    <body>

        <form align="center" action="/UniversityDB/Add_Print_DB">
            <jsp:include page="my-header.html"/>
            <h3>University Name:</h3> <input style="text-align: center" type="text" size="50" name="universityTitle" value="${name}" readonly><br><br>
            <h3>Student ID:</h3> <input type="text" name="id" size="50" ><br><br>
            <h3>Student Name:</h3> <input type="text" name="Sname" size="50" ><br><br>
            <h3>Father Name:</h3> <input type="text" name="Fname" size="50" ><br><br>
            <h3>Mobile#:</h3> <input type="text" name="Mobile#" size="50" ><br><br>
            <h3>E-mail:</h3> <input type="text" name="E-mail" size="50" ><br><br>
            <h3>Address:</h3> <textarea rows="5" cols="60" name="address"></textarea><br><br>
            <input type="submit" value="Submit"><br>
            <jsp:include page="myfooter.jsp"/>
        </form>

    </body>
</html>
