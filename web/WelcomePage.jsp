<%-- 
    Document   : WelcomePage
    Created on : Jun 7, 2018, 9:01:05 PM
    Author     : ANONYMOUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DataBase</title>
    </head>
    <body>
        <jsp:include page="my-header.html"/>
        <form align="center" action="UniversityDropDown" target="_blank" method="post">
            To add new student, Press <input type="submit" value="Add"/> button. 
            <br><br>           
        </form>
        <form align="center" action="viewDB" target="_blank" method="post">
            <br><br>
            To see previously added students, Press <input type="submit" value="View"> button.
            <br><br>            
        </form>
        <jsp:include page="myfooter.jsp"/>
    </body>
</html>