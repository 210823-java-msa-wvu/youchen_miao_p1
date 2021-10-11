package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Employee;
import model.Manager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final UserServices userServices = new UserServices();
    private static final ObjectMapper om = new ObjectMapper();
    private static final Logger logger = LogManager.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.warn("do get method invoked but not implemented.");
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("method: "+ req.getMethod()+" URI: "+req.getRequestURI());
        logger.debug("method: "+ req.getMethod()+" URI: "+req.getRequestURI());
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");

        Employee emp;
        Manager m;

        emp = userServices.employeeLogin(name,pass);
        m = userServices.managerLogin(name,pass);
        if(emp==null&&m==null){
            resp.setStatus(403);
            resp.sendRedirect("http://Localhost:8080/Project1/bad_login.html");
        }
        else if(m==null){
            Cookie cookie = new Cookie("employeeinfo",om.writeValueAsString(emp));
            Manager manager = userServices.getManagerById(emp.getReport_to());
            Cookie cookie2 = new Cookie("report_to",manager.getLast());
            resp.addCookie(cookie);
            resp.addCookie(cookie2);
            resp.sendRedirect("http://Localhost:8080/Project1/employee.html");
        }
        else{
            Cookie cookie = new Cookie("managerinfo",om.writeValueAsString(m));
            resp.addCookie(cookie);
            if(m.getReport_to()!=0){
                Manager manager = userServices.getManagerById(m.getReport_to());
                Cookie cookie2 = new Cookie("report_to",manager.getLast());
                resp.addCookie(cookie2);
            }
            else{
                Cookie cookie2 = new Cookie("report_to","some higher being");
                resp.addCookie(cookie2);
            }
            resp.sendRedirect("http://Localhost:8080/Project1/manager.html");
        }
    }
}