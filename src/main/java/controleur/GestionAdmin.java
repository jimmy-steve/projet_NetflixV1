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

@WebServlet(name = "GestionAdmin", value = "/GestionAdmin")
public class GestionAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String source = request.getParameter("src");
        String dest = "/WEB-INF/Connecter.jsp";



        if (source.equals("client")){
            HttpSession session = request.getSession();
            Client clientTest = new Client(1,"Lafon", "frank", "87 rue de la montagne Québec",
                    "email@gmail.com", "(514)582-2459", 1, 1);

            User userTest = new User("frank", "1234", true);


            ClientDao clientDao = new ClientDao();
            UserDao userDao = new UserDao();

            List<Client> listClients = clientDao.getAllClients();
            List<User> listUsers = userDao.getAllUsers();


            session.setAttribute("listUsers", listUsers);
            session.setAttribute("listClients",listClients);
//
//            request.setAttribute("client",clientTest);
//            request.setAttribute("user",userTest);



            dest = "/WEB-INF/gestionClientAdmin.jsp";
        }else if (source.equals("abonnement")){
            dest = "/WEB-INF/gestionAbonnementAdmin.jsp";
        }else if (source.equals("show")){
            dest = "/WEB-INF/gestionShowAdmin.jsp";
        }



        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
