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

@WebServlet("/lister")
public class ListerServlet extends HttpServlet {

    @Autowired
    GestionBouteille gestionBouteille;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Bouteille> listeBouteille = null;

        if (request.getParameter("filtre") != null && !request.getParameter("filtre").trim().equals("")){
            String filtre = request.getParameter("filtre");
            listeBouteille = gestionBouteille.findByNomContaining(filtre);
        } else {
            listeBouteille = gestionBouteille.getBouteilles();
        }

        request.setAttribute("listeBouteille", listeBouteille);

        RequestDispatcher rd = request.getRequestDispatcher("listeBouteilles.jsp");
        rd.forward(request, response);
    }
}
