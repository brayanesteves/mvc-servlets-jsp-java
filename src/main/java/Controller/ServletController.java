package Controller;

import Model.Rectangle;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 1. We process parameters.
            
            // 2. We create JavaBeans.
            Rectangle rectangle = new Rectangle(3, 6);
            
            // 3. We add the JavaBeans to some scope.
            request.setAttribute("message", "Greetings from the Servlet..");
            
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("rectangle", rectangle);
            
            // 4. Redirect to the selected view.
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/deployVariables.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ServletController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServletController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
