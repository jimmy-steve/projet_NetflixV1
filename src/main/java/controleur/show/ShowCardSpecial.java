package controleur.show;

import dao.ShowDao;
import modeles.Show;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowCardSpecial", value = "/ShowCardSpecial")
public class ShowCardSpecial extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "AffCardTourne.jsp";

        ShowDao showDao = new ShowDao();
        List<Show> listeShows = showDao.GetAllCanadianShowsRecent();
        request.setAttribute("listeShows", listeShows);
        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }
}
