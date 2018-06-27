<%-- 
    Document   : FirstPage
    Created on : May 30, 2018, 8:06:41 PM
    Author     : ANONYMOUS
--%>

<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="test.servlet.vo.UniversityNames" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>University DataBase</title>
    </head>
    <body>
        <form border="1" align="center" action="/UniversityDB/UniversityNameGet" method="post">
            <jsp:include page="my-header.html"/>
            <h3 align="center">Select your University</h3>
            <select name="universityName"> 
                <%
                    LinkedList<UniversityNames> printable2 = new LinkedList<>();
                    printable2 = (LinkedList) session.getAttribute("universities");
                    for (UniversityNames un : printable2) {
                %>

                <option value="<%= un.getUniversity().toString()%>"><%= un.getUniversity().toString()%></option>

                <%
                    }
                %>
            </select>
            <br><br>
            <input type="submit" value="Submit"/> 
            <jsp:include page="myfooter.jsp"/>
        </form>
    </body>
</html>
