package servlets;
import javax.ejb.EJB;
import beans.TareasREJB;
import entities.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "AltaUser", urlPatterns = {"/AltaUser"})
public class AltaUser extends HttpServlet {
        @EJB 
        TareasREJB ejb;
   public static final String STATUS_OK = "userOk";
    public static final String STATUS_ERROR = "userError";
   
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
        if("Registrar".equals(request.getParameter("registro"))){
           String username = request.getParameter("username");
           String pass = request.getParameter("pass");
           String name = request.getParameter("name");
           int age = Integer.parseInt(request.getParameter("age"));
           User user = new User(username,pass,name,age);
                  
           if(ejb.insertUser(user)){
                request.setAttribute("status", STATUS_OK);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                request.setAttribute("status", STATUS_ERROR);
            }}
        else{
            request.getRequestDispatcher("/index.jsp").forward(request, response);
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
