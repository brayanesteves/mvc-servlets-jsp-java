package Controller;

import Model.Rectangle;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletContext;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession httpSession = request.getSession();
            RequestDispatcher requestDispatcher = null;
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
                
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
            } else if("listVariables".equals(action)) {
                // 4. Redirect to the selected view.
                request.getRequestDispatcher("WEB-INF/scopeVariables.jsp").forward(request, response);
            } else {
                // 4. Redirect to the selected view.
                request.setAttribute("messageAction", "Action unknown.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            /**
             * @Warning
             * Not use.
             */
            // 4. Redirect to the selected view.
            //requestDispatcher = request.getRequestDispatcher("View/deployVariables.jsp");
            //requestDispatcher.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ServletController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServletController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
