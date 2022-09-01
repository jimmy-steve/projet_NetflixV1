package controleur;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Name : UserNameLogin
 * SErvlet permettant de saisir le username sur la page d'acceuil
 * et tranfert l'information dans le formulaire de connexion pour faire comme netflix
 *
 * @author Francis Lafontaine
 * @version V1
 * @since 01/09/2022
 */
@WebServlet(name = "UserNameLogin", value = "/UserNameLogin")
public class UserNameLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "formulaireLogin.jsp";
        String userName = request.getParameter("username");

        request.setAttribute("username", userName);

        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }
}
