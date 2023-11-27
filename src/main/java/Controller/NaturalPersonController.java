package Controller;

import Data.NaturalPersonDAO;
import Domain.NaturalPerson;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/NaturalPersonController")
public class NaturalPersonController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        
        String action = request.getParameter("action");
        if(action != null) {
            switch (action) {
                
                case "edit":
                    this.edit(request, response);
                    break;
                default:
                    this.actionDefault(request, response);
                    
            }
        } else {
            this.actionDefault(request, response);
        }
    }
    
    private void actionDefault(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<NaturalPerson> listNaturalPersons = new NaturalPersonDAO().list();
            
            HttpSession httpSession = request.getSession();
            
            httpSession.setAttribute("naturalPersons", listNaturalPersons);
            httpSession.setAttribute("naturalPersonsTotal", listNaturalPersons.size());
            httpSession.setAttribute("naturalPersonsRemoved", this.sumNaturalPersonsRemoved(listNaturalPersons));
            
            request.setAttribute("naturalPersons", listNaturalPersons);
            request.setAttribute("naturalPersonsTotal", listNaturalPersons.size());
            request.setAttribute("naturalPersonsRemoved", this.sumNaturalPersonsRemoved(listNaturalPersons));
            // request.getRequestDispatcher("naturalPersons.jsp").forward(request, response);
            
            response.sendRedirect("naturalPersons.jsp");
            
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
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        
        String action = request.getParameter("action");
        if(action != null) {
            switch (action) {
                
                case "add":
                    this.add(request, response);
                    break;
                default:
                    this.actionDefault(request, response);
                    
            }
        } else {
            this.actionDefault(request, response);
        }
        
    }
    
    private void add(HttpServletRequest request, HttpServletResponse response) {
        try {
            Date date = new Date();
            // Retrieve form field values.
            String referenceNacionality   = request.getParameter("referenceNacionality");
            String referenceCountry       = request.getParameter("referenceCountry");
            String identificationDocument = request.getParameter("identificationDocument");
            String names                  = request.getParameter("names");
            String surnames               = request.getParameter("surnames");
            String referentialPhoneNumber = request.getParameter("referentialPhoneNumber");
            String taxAddress             = request.getParameter("taxAddress");
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            String currentDate = sdf.format(date);
            Date dateAdmission = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate);
            int hour = date.getHours();
            Time checkTime = new Time(hour / 100, // Hours
                    hour % 100 / 60, // Minutes
                    hour % 100 % 60); // Seconds
            // We create the (Model) object.
            NaturalPerson naturalPerson = new NaturalPerson(Integer.parseInt(referenceNacionality), Integer.parseInt(referenceCountry), identificationDocument, names, surnames, referentialPhoneNumber, taxAddress, 1, 0, 0, dateAdmission, checkTime);
            int modifiedRecords = new NaturalPersonDAO().add(naturalPerson);
            this.actionDefault(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(NaturalPersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            
            int reference               = Integer.parseInt(request.getParameter("reference"));
            
            NaturalPerson naturalPerson = new NaturalPersonDAO().findByReference(new NaturalPerson(reference));
            
            request.setAttribute("naturalPerson", naturalPerson.getReferenceNacionality());
            
            // request.setAttribute("referenceNacionality", naturalPerson.getReferenceNacionality());
            // request.setAttribute("referenceCountry", naturalPerson.getReferenceCountry());
            // request.setAttribute("identificationDocument", naturalPerson.getIdentificationDocument());
            // request.setAttribute("names", naturalPerson.getNames());
            // request.setAttribute("surnames", naturalPerson.getSurnames());
            // request.setAttribute("referentialPhoneNumber", naturalPerson.getReferentialPhoneNumber());
            // request.setAttribute("taxAddress", naturalPerson.getTaxAddress());
            
            String jspEdit = "/WEB-INF/pages/naturalperson/editNaturalPerson.jsp";
            
            request.getRequestDispatcher(jspEdit).forward(request, response);
            
        } catch (ServletException ex) {
            Logger.getLogger(NaturalPersonController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NaturalPersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}