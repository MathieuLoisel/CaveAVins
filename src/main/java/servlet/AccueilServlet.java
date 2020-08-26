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
import java.util.List;

@WebServlet("/accueil")
public class AccueilServlet extends HttpServlet {

    @Autowired
    GestionCouleur gestionCouleur;

    @Autowired
    GestionRegion gestionRegion;

    @Autowired
    GestionBouteille gestionBouteille;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());

/*        gestionCouleur.addCouleur(new Couleur("Rouge"));
        gestionCouleur.addCouleur(new Couleur("Blanc"));
        gestionCouleur.addCouleur(new Couleur("Rosé"));
        gestionCouleur.addCouleur(new Couleur("Jaune"));

        gestionRegion.addRegion(new Region("Bordeaux"));
        gestionRegion.addRegion(new Region("Provence"));
        gestionRegion.addRegion(new Region("Beaujolais"));
        gestionRegion.addRegion(new Region("Jura"));
        gestionRegion.addRegion(new Region("Alsace"));
        gestionRegion.addRegion(new Region("Bourgogne"));
        gestionRegion.addRegion(new Region("Corse"));*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Couleur> listeCouleur = gestionCouleur.getCouleurs();
        List<Region> listeRegion = gestionRegion.getRegions();

        request.getSession().setAttribute("listeCouleur", listeCouleur);
        request.getSession().setAttribute("listeRegion", listeRegion);

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
}
