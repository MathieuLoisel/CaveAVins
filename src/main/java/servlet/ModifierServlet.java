package servlet;

import bll.GestionBouteille;
import bll.GestionCouleur;
import bll.GestionRegion;
import bo.Bouteille;
import bo.Couleur;
import bo.Region;
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

@WebServlet("/editer")
public class ModifierServlet extends HttpServlet {

    @Autowired
    GestionCouleur gestionCouleur;

    @Autowired
    GestionBouteille gestionBouteille;

    @Autowired
    GestionRegion gestionRegion;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("index"));
        Bouteille bouteille = gestionBouteille.getBouteilleById(id);

        bouteille.setNom(request.getParameter("nomDuVin"));
        bouteille.setMillesime(request.getParameter("millesime"));
        bouteille.setIsPetillant(Boolean.parseBoolean(request.getParameter("petillant")));
        bouteille.setQuantite(Integer.parseInt(request.getParameter("quantite")));
        bouteille.setCouleur(gestionCouleur.getCouleurById(Integer.parseInt(request.getParameter("couleur"))));
        bouteille.setRegion(gestionRegion.getRegionById(Integer.parseInt(request.getParameter("region"))));

        gestionBouteille.updateBouteille(bouteille);

//        request.getSession().setAttribute("index", id);
        request.setAttribute("vin", bouteille);

        RequestDispatcher rd = request.getRequestDispatcher("afficherBouteille.jsp");
        rd.forward(request, response);
//        response.sendRedirect("afficher");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("index"));

        request.setAttribute("vin", gestionBouteille.getBouteilleById(id));

        RequestDispatcher rd = request.getRequestDispatcher("editerBouteille.jsp");
        rd.forward(request, response);
    }
}
