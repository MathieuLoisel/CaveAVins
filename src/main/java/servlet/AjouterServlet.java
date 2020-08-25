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

@WebServlet("/ajouter")
public class AjouterServlet extends HttpServlet {

    @Autowired
    GestionRegion gestionRegion;

    @Autowired
    GestionCouleur gestionCouleur;

    @Autowired
    GestionBouteille gestionBouteille;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nom = request.getParameter("nomDuVin");
        String millesime = request.getParameter("millesime");
        boolean isPetillant = Boolean.parseBoolean(request.getParameter("petillant"));
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        Couleur couleur = gestionCouleur.getCouleurById(Integer.parseInt(request.getParameter("couleur")));
        Region region = gestionRegion.getRegionById(Integer.parseInt(request.getParameter("region")));


        Bouteille bouteille = new Bouteille(nom, millesime, isPetillant, quantite, couleur, region);
        gestionBouteille.addBouteille(bouteille);

        ((List<Bouteille>) request.getSession().getAttribute("listeBouteille")).add(bouteille);

        response.sendRedirect("lister");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("ajouterBouteille.jsp");
        rd.forward(request, response);
    }
}
