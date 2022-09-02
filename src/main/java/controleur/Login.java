package controleur;

import dao.IItem;
import dao.NetflixDao;
import modeles.Cart;
import modeles.Netflix;
import modeles.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Name : Login
 * Servlet permettant de controller le login
 * devrait être modifié pour être intégrer au bloque de gabriel Gagnon------------------------a vérifier
 * car les user ne sont pas valider .... il sont écrit en dur
 * frank password=1234---admin
 * alex password=1234--- client régulier
 *
 * @author Francis Lafontaine
 * @version V1
 * @since 01/09/2022
 */
@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session == null) {
            response.sendRedirect("http://localhost:82/error.html");
        }


        String dest = "";
        List<Netflix> listeShows = null;
        User user = new User("frank", "1234", true);

        User userRegulier = new User("alex", "1234", false);

        try {
            String userName = request.getParameter("username");
            String passWord = request.getParameter("password");
            User userAdmin = new User(userName, passWord, true);

            if (user.getUsername().equals(userAdmin.getUsername()) && user.getHashPassword()
                    .equals(userAdmin.getHashPassword()) && userAdmin.isAdmin()) {


                NetflixDao showDao = new NetflixDao();
                listeShows = showDao.GetAllCanadianShowsRecent();
                session.setAttribute("listeshows", listeShows);

                dest = "WEB-INF/Connecter.jsp";

            } else if (userRegulier.getUsername().equals(userAdmin.getUsername()) && userRegulier.getHashPassword()
                    .equals(userAdmin.getHashPassword()) && !userRegulier.isAdmin()) {

                /*
                on créer un nouveau panier on y donne une quantité de 0 et une list de film vide
                */

                List<Netflix> listFilmsPersonel = new ArrayList<Netflix>();
                Cart cart = new Cart(0, listFilmsPersonel);

                /*
                on prépare une liste de film a afficher
                 */
                NetflixDao showDao = new NetflixDao();
                listeShows = showDao.GetAllCanadianShowsRecent();
                session.setAttribute("listeshows", listeShows);
                session.setAttribute("cart", cart);
                dest = "index.jsp";
            } else {
                dest = "WEB-INF/erreurConnection.jsp";
            }
            session.setAttribute("user", userAdmin);
        } catch (NumberFormatException e) {
            dest = "WEB-INF/erreur.jsp";
        }
        session.setAttribute("listeShows", listeShows);

        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }
}
