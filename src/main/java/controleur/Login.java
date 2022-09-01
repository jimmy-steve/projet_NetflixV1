package controleur;

import dao.IItem;
import dao.NetflixDao;
import modeles.Netflix;
import modeles.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
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

                IItem showDao = new NetflixDao();
                listeShows = ((NetflixDao) showDao).GetAllCanadianShowsRecent();
                session.setAttribute("listeshows", listeShows);

                dest = "WEB-INF/Connecter.jsp";

            } else if (userRegulier.getUsername().equals(userAdmin.getUsername()) && userRegulier.getHashPassword()
                    .equals(userAdmin.getHashPassword()) && !userRegulier.isAdmin()) {
                IItem showDao = new NetflixDao();
                listeShows = ((NetflixDao) showDao).GetAllCanadianShowsRecent();
                session.setAttribute("listeshows", listeShows);

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
