package controleur;

import dao.ClientDao;
import dao.UserDao;
import modeles.Client;
import modeles.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * Name : GestionAdmin
 * Servlet permettant de gèrer le menu de gauche dans le côté administration
 * Elle renvoit les bonnes informations au différente page de gestion
 *
 * @author Francis Lafontaine
 * @version V1
 * @since 01/09/2022
 */
@WebServlet(name = "GestionAdmin", value = "/GestionAdmin")
public class GestionAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String source = request.getParameter("src");
        String dest = "/WEB-INF/Connecter.jsp";


        if (source.equals("client")) {
            HttpSession session = request.getSession();

            ClientDao clientDao = new ClientDao();
            UserDao userDao = new UserDao();

            List<Client> listClients = clientDao.getAllClients();
            List<User> listUsers = userDao.getAllUsers();

            session.setAttribute("listUsers", listUsers);
            session.setAttribute("listClients", listClients);


            dest = "/WEB-INF/gestionClientAdmin.jsp";
        } else if (source.equals("abonnement")) {
            dest = "/WEB-INF/gestionAbonnementAdmin.jsp";
        } else if (source.equals("show")) {
            dest = "/WEB-INF/gestionShowAdmin.jsp";
        }


        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
