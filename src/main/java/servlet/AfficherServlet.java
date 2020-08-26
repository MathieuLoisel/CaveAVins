package servlet;

import bll.GestionBouteille;
import bo.Bouteille;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/afficher")
public class AfficherServlet extends HttpServlet {

    @Autowired
    GestionBouteille gestionBouteille;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Bouteille bouteille = null;
        System.out.println("ContextPath"  + request.getServletPath());



//        if (request.getContextPath().equals("/editer")){
//           bouteille = gestionBouteille.getBouteilleById((Integer) request.getSession().getAttribute("index"));
//        } else {
            bouteille = gestionBouteille.getBouteilleById(Integer.parseInt(request.getParameter("index")));
//        }
        request.setAttribute("vin", bouteille);

        RequestDispatcher rd = request.getRequestDispatcher("afficherBouteille.jsp");
        rd.forward(request, response);
    }
}
