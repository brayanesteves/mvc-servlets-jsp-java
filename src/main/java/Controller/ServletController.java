package Controller;

import Model.Rectangle;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
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
            HttpSession httpSession = request.getSession();
            // 1. We process parameters.
            String action = request.getParameter("action");
            
            // 2. We create JavaBeans.
            Rectangle rectangle            = new Rectangle(3, 6);
            Rectangle rectangleRequest     = new Rectangle(1, 2);
            Rectangle rectangleSesion      = new Rectangle(3, 4);
            Rectangle rectangleApplication = new Rectangle(5, 6);
            
            // 3. We add the JavaBeans to some scope.
            request.setAttribute("message", "Greetings from the Servlet..");
            // Review action.
            if("addVariables".equals(action)) {
                // Scope request.
                request.setAttribute("rectangleRequest", rectangleRequest);
                // Scope session.
                httpSession.setAttribute("rectangleSession", rectangleSesion);
                // Scope application.
                ServletContext application = this.getServletContext();
                application.setAttribute("rectangleApplication", rectangleApplication);
                // Add message.
                request.setAttribute("messageAction", "The variables add successful.");
            }            
            
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
