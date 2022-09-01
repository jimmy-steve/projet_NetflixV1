package controleur.show;

import dao.IItem;
import dao.NetflixDao;
import modeles.Netflix;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Name: DetailShow
 * Servlet permettant d'aller chercher les information de chaque films
 * lorsque l'on clique sur le bouton detail mais serais utilisé juste pour le client-------------À vérifier----
 *
 * @author Francis Lafontaine
 * @version V1
 * @since 01/09/2022
 */
@WebServlet(name = "DetailShow", value = "/DetailShow")
public class DetailShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "AffDetailShow.jsp";

        int id = Integer.parseInt(request.getParameter("id"));

        IItem showDao = new NetflixDao();
        Netflix netflix = showDao.getShow(id);
        request.setAttribute("show", netflix);
        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
