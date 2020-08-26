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
import java.util.List;

@WebServlet("/trier")
public class TrierServlet extends HttpServlet {

    @Autowired
    GestionBouteille gestionBouteille;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Bouteille> listeBouteille = null;

        String filtre = request.getParameter("filtre");
        String ordre = request.getParameter("order");

        switch (ordre) {
            case "ASC":
                listeBouteille = gestionBouteille.findAsc(filtre);
                break;

            case "DESC":
                listeBouteille = gestionBouteille.findDesc(filtre);
                break;

            default:
                listeBouteille = gestionBouteille.getBouteilles();
        }

        request.setAttribute("listeBouteille", listeBouteille);
        RequestDispatcher rd = request.getRequestDispatcher("listeBouteilles.jsp");
        rd.forward(request, response);
    }
}
