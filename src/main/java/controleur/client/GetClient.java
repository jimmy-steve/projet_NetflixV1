package controleur.client;

import dao.ClientDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetClient", value = "/GetClient")
public class GetClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String dest = "/WEB-INF/gestionClientAdmin.jsp";

        int numeroClient = Integer.parseInt(request.getParameter("id"));


        ClientDao clientDao = new ClientDao();
        Object client = clientDao.getClient(numeroClient);


        session.setAttribute("client", client);
        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
