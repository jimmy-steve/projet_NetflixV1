package controleur;

import dao.*;
import modeles.Abonnement;
import modeles.Client;
import modeles.Show;
import modeles.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import static utilitaire.GenerateurNombreSequentiel.genererNombre;

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


            /**
             * je créer un client typique
             */
            Client client = new Client(nom, prenom, adresse, email, telephone, Integer.parseInt(genererNombre()));
            /**
             * je créer un user typique
             */
            User user = new User(userName, passWord, "null");
            /**
             * j'enregistre le user dans la base de donnée
             */
            IShow userDao = new UserDao();
            userDao.insert(user);
            /**
             * J'enregistre le client dans la base de donnée
             */
            client.setIdUser(user.getIdUser());
            IShow clientDao = new ClientDao();
            clientDao.insert(client);

            /**
             * je créer un abonnement pour le user
             */
            Abonnement abonnement = new Abonnement(client.getIdAbonnement(), typeAbonnement, 25.77, user.getIdUser());

            /**
             * J"enregistre l'abonnement fans la base donnée
             */

            AbonnementDao abonnementDao = new AbonnementDao();
            abonnementDao.insert(abonnement);


        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }
}
