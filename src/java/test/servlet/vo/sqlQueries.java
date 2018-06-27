package test.servlet.vo;

import java.sql.*;
import java.util.LinkedList;
import javax.servlet.http.HttpSession;

/**
 * @author ANONYMOUS
 *
 */
public class sqlQueries {

    /*Method for MySQL connection*/
    public Connection sqlConnection() {
        Connection con = null;
        try {
            String mysqlDriver = "com.mysql.jdbc.Driver";
            String databaseName = "webpagedb";
            String userName = "root";
            String password = "root@wolf";
            Class.forName(mysqlDriver);
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + databaseName, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error!!..." + e);
        }
        return con;
    }
    /*Method for MySQL statement*/
    public Statement sqlStatement(){
        Statement stmt = null;
        try {
            sqlConnection();
            stmt = sqlConnection().createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return stmt;
    }

    /*Method for MySQL Insert Data*/
    public void sqlConnectionInsert(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) {
        try {
            sqlConnection();
            String insert_in_student_db
                    = ("INSERT INTO student (`ID`, `Student Name`, `Father Name`, `Mobile#`, `E-mail`, `Address`) "
                    + "VALUES ('" + arg1 + "','" + arg2 + " ', '" + arg3 + "', '" + arg4 + "', '" + arg5 + "', '" + arg6 + "')");
            /*passing data to statement for insertion in database*/
            int insert_data = sqlStatement().executeUpdate(insert_in_student_db);

        } catch (SQLException e) {
            System.err.println("Error!!..." + e);
        }
    }

    /*Method for MySQL Retrieve Data*/
    public LinkedList sqlConnectionRetrieve() {
        LinkedList<Student> studentList = null;
        try {
            studentList = new LinkedList<>();
            sqlConnection();
            ResultSet rs = sqlStatement().executeQuery("select * FROM student");

            while (rs.next()) {
                Student student = new Student();
                student.setSerialNo(rs.getString(1));
                student.setId(rs.getString(2));
                student.setName(rs.getString(3));
                student.setFatherName(rs.getString(4));
                student.setContact(rs.getString(5));
                student.setEmail(rs.getString(6));
                student.setAddress(rs.getString(7));
                studentList.add(student);
            }

        } catch (SQLException e) {
            System.err.println("Error!!..." + e);
        }
        return studentList;
    }

    /*Method for MySQL Retrieve Data for UniversityDropDown servlet*/
    public LinkedList sqlUniversityDropDown() {
        LinkedList<UniversityNames> universityList = null;
        try {
            universityList = new LinkedList<>();
            sqlConnection();
            ResultSet rs = sqlStatement().executeQuery("select * FROM university");

            /*Saving Values in LinkedList "universityList" */
            while (rs.next()) {
                UniversityNames university = new UniversityNames();
                university.setUniversity(rs.getString(1));
                universityList.add(university);
            }
        } catch (SQLException e) {
            System.err.println("Error!!..." + e);
        }
        return universityList;
    }

    /*Method for MySQL Delete*/
    public void sqlDelete(String srNo) {
        try {
            sqlConnection();
            String query = "DELETE FROM student WHERE `S.No#` = ?";
            PreparedStatement preparedStmt = null;
            preparedStmt = sqlConnection().prepareStatement(query);
            preparedStmt.setString(1, srNo);
            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error!!..." + e);
        }
    }
    
    /*Method for MySQL Delete*/
    public void sqlEdit(){
        sqlConnection();
        
    }
}
