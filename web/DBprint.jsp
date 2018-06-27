<%-- 
    Document   : DBprint
    Created on : Jun 3, 2018, 1:26:01 PM
    Author     : ANONYMOUS
--%>
<%@page import="test.servlet.vo.UniversityNames"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="test.servlet.vo.Student" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stored Entries</title>
        <link rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <div>
            <form action="/UniversityDB/DeleteDbEntry">
                <table  id="table" align="center" width="1300" border="2" cellspacing="5">

                    <tr bgcolor="black" >    
                        <th>Serial Number</th>
                        <th>ID</th>
                        <th>Student Name</th>
                        <th>Father Name</th>
                        <th>Contact #</th>
                        <th>E-mail</th>
                        <th>Address</th>
                        <th>Delete</th>
                    </tr>

                    <tr>
                        <%  LinkedList<Student> printable0 = new LinkedList<>();
                            LinkedList<UniversityNames> printable1 = new LinkedList<>();

                            printable0 = (LinkedList) session.getAttribute("students");
                            for (Student s : printable0) {
                        %>
                        <td> <%out.println(s.getSerialNo());%> </td> 
                        <td> <%out.println(s.getId());%> </td> 
                        <td> <%out.println(s.getName());%> </td> 
                        <td> <%out.println(s.getFatherName());%> </td> 
                        <td> <%out.println(s.getContact());%> </td> 
                        <td> <%out.println(s.getEmail());%> </td> 
                        <td> <%out.println(s.getAddress());%> </td>
                        <td> <input id="btnDelete" type="submit" value="Delete" onclick="toDelete('<%=s.getSerialNo()%>')"></td>
                        
                    </tr>
                    <%  }
                    %>
                    <a href="/UniversityDB/WelcomePage.jsp">Go To Main Page</a><br><br>

                    Selected Serial Number : <input type="text" name="serialNo" id="sr" readonly><br>
                </table>
            </form>
            <script type="text/javascript">
                function toDelete(serialNumber) {
                    document.getElementById("sr").value = serialNumber;
                    alert(serialNumber + 'th Entry will be deleted.');
                }
                ;
                function toEdit(serialNumber) {
                    document.getElementById("sr").value = serialNumber;
                    alert(serialNumber + 'th Entry will be Edited.');
                }
                ;
            </script>
        </div>
    </body>
</html>
