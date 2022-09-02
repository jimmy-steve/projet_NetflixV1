package controleur;

import dao.*;
import modeles.Abonnement;
import modeles.Client;
import modeles.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static utilitaire.GenerateurNombreSequentiel.genererNombre;

/**
 * Name : Register
 * Servlet permettant d'aller chercher toute les informations du clients et du users
 * Il insère également dans la BD 1 user et 1 client
 *
 * @author Francis Lafontaine
 * @version V1
 * @since 01/09/2022
 */
@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "confirm.jsp";

        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");

        String adresse = request.getParameter("adresse");
        String telephone = request.getParameter("telephone");

        String typeAbonnement = request.getParameter("typeAbonnement");

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");


        /*
         * je créer un client typique
         */
        Client client = new Client(nom, prenom, adresse, email, telephone, Integer.parseInt(genererNombre()));
        /*
         * je créer un user typique
         */
        User user = new User(userName, passWord, "null");
        /*
         * j'enregistre le user dans la base de donnée
         */
        IItem userDao = new UserDao();
        userDao.insert(user);
        /*
         * J'enregistre le client dans la base de donnée
         */
        client.setIdUser(user.getIdUser());
        IItem clientDao = new ClientDao();
        clientDao.insert(client);

        /*
         * je créer un abonnement pour le user
         */
        Abonnement abonnement = new Abonnement(client.getIdAbonnement(), typeAbonnement, 25.77, user.getIdUser());

        /*
         * J"enregistre l'abonnement fans la base donnée
         */

        AbonnementDao abonnementDao = new AbonnementDao();
        abonnementDao.insert(abonnement);

        request.setAttribute("client", client);
        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }
}
