package controleur;

import dao.IItem;
import dao.NetflixDao;
import modeles.Cart;
import modeles.Netflix;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Name : AjouterArticlePanier
 *
 * Permet d'ajouter un article a notre panier
 *
 * @author Francis Lafontaine
 * @since 01/09/2022
 * @version V1
 *
 */
@WebServlet(name = "AjouterArticlePanier", value = "/AjouterArticlePanier")
public class AjouterArticlePanier extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "cart.jsp";
        HttpSession session = request.getSession();
        if (session == null) {
            response.sendRedirect("http://localhost:82/error.html");
        }
        Cart cart = (Cart) session.getAttribute("cart");
        int id = Integer.parseInt(request.getParameter("id"));

        IItem showDao = new NetflixDao();
        Netflix netflix = showDao.getShow(id);

        cart.setQuantite(cart.getQuantite()+1);
        cart.getListFilms().add(netflix);


        session.setAttribute("listePersonnel", cart.getListFilms());

        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
