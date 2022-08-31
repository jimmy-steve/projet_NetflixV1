package showTest;

import dao.IShow;
import dao.ShowDao;
import modeles.Show;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ShowRepositoryTests {

    @Test
    public void testInsertBase() {
        Show showTest = new Show("Test", 2024);
        IShow showDao = new ShowDao();
        showDao.insert(showTest);

        System.out.println(showTest);
    }

    @Test
    public void testGetAllShows() {
        ShowDao showDao = new ShowDao();
        List<Show> listShows = showDao.getAllShows();

        for (Show tmp : listShows
        ) {
            System.out.println(tmp);
        }
    }

    @Test
    public void testGetAllAmericanMovies() {
        ShowDao showDao = new ShowDao();
        List<Show> listShows = showDao.getAllAmericanMovies();

        for (Show tmp : listShows
        ) {
            System.out.println(tmp);
        }
    }

    @Test
    public void testGetAllCanadianShowsRecent() {
        ShowDao showDao = new ShowDao();
        List<Show> listCanadianShows = showDao.GetAllCanadianShowsRecent();

        for (Show tmp : listCanadianShows
        ) {
            System.out.println(tmp);
        }
    }

    @Test
    public void testGetShow() {
        ShowDao showDao = new ShowDao();
        Show show = showDao.getShow(5);
        System.out.println(show);
    }


}
