
import com.sun.org.apache.regexp.internal.recompile;
import test.servlet.vo.Student;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import javax.servlet.http.HttpSession;
import test.servlet.vo.sqlQueries;

/**
 *
 * @author ANONYMOUS
 */
@WebServlet(urlPatterns = {"/Add_Print_DB"})
public class Add_Print_DB extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            /* TODO output your page here. You may use following sample code. */
            /*For MySQL Connection & Insert*/
            String arg_1 = request.getParameter("id");
            String arg_2 = request.getParameter("Sname");
            String arg_3 = request.getParameter("Fname");
            String arg_4 = request.getParameter("Mobile#");
            String arg_5 = request.getParameter("E-mail");
            String arg_6 = request.getParameter("address");
            sqlQueries query = new sqlQueries();
            query.sqlConnectionInsert(arg_1, arg_2, arg_3, arg_4, arg_5, arg_6);
            query.sqlConnectionRetrieve();
            HttpSession session = request.getSession(false);
            session.setAttribute("students", query.sqlConnectionRetrieve());
            /*Open Last Page to show data*/
            response.sendRedirect("DBprint.jsp");

        } catch (Exception e) {
            System.err.print(e);
        }
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
