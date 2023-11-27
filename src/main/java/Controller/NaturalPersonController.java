package Controller;

import Data.NaturalPersonDAO;
import Domain.NaturalPerson;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NaturalPersonController")
public class NaturalPersonController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            List<NaturalPerson> listNaturalPersons = new NaturalPersonDAO().list();
            request.setAttribute("naturalPersons", listNaturalPersons);
            request.setAttribute("naturalPersonsTotal", listNaturalPersons.size());
            request.setAttribute("naturalPersonsRemoved", this.sumNaturalPersonsRemoved(listNaturalPersons));
            request.getRequestDispatcher("naturalPersons.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(NaturalPersonController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NaturalPersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private int sumNaturalPersonsRemoved(List<NaturalPerson> listNaturalPersons) {
        int total = 0;
        for(NaturalPerson naturalPerson : listNaturalPersons) {
            if(naturalPerson.getRemoved() == 1) {
                total++;
            }
        }        
        return total;
    }
}