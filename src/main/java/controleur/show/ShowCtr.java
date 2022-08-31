package controleur.show;

import dao.ShowDao;
import modeles.Show;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowCtr", value = "/ShowCtr")
public class ShowCtr extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "AffListeShow.jsp";
        List<Show> listeShows = null;
        String option1 = request.getParameter("pays");
        String action = request.getParameter("action");
        String type = request.getParameter("type");

        System.out.println(option1);
        ShowDao showDao = new ShowDao();

        if (action.equals("admin")){
            dest = "/WEB-INF/Connecter.jsp";
        }


        if (option1.equals("all") && type.equals("kids")){
            listeShows = showDao.GetAllkids();
        }else if( option1.equals("canada") ){
            listeShows = showDao.GetAllCanadian();
        }


        else if (option1.equals("usa")){
            listeShows = showDao.GetAllAmerican();
        }else if (option1.equals("recentCanadianTV")){
            listeShows = showDao.GetAllCanadianShowsRecent();
        }else if (option1.equals("all")){
            listeShows = showDao.getAllShows();
        }



        request.setAttribute("listeShows", listeShows);

        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }
}
