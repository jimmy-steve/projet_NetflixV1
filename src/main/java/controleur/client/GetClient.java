package controleur.client;

import dao.ClientDao;
import dao.UserDao;
import modeles.Client;
import modeles.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetClient", value = "/GetClient")
public class GetClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //HttpSession session = request.getSession();
        String dest = "/WEB-INF/gestionClientAdmin.jsp";

        long numeroClient = Long.parseLong(request.getParameter("id"));


        ClientDao clientDao = new ClientDao();
        Client client = (Client) clientDao.getClient(numeroClient);
        UserDao userDao = new UserDao();

        User user = userDao.getUser(client.getIdUser());

        System.out.println(user);

        System.out.println(client);

        request.setAttribute("user", user);
        request.setAttribute("client", client);
        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
