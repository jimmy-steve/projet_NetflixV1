package controleur.show;

import dao.ShowDao;
import modeles.Show;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailShow", value = "/DetailShow")
public class DetailShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "AffDetailShow.jsp";

       int id = Integer.parseInt(request.getParameter("id"));


//        ShowDao showDao = new ShowDao();
//        Show show = (Show) showDao.getShow(id);
//        request.setAttribute("show", show);
        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "AffDetailShow.jsp";

        int id = Integer.parseInt(request.getParameter("id"));


//        ShowDao showDao = new ShowDao();
//        Show show = (Show) showDao.getShow(id);
//        request.setAttribute("show", show);
        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }
}
