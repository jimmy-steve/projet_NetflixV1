package netflixTest;

import dao.IItem;
import dao.NetflixDao;
import modeles.Netflix;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NetflixRepositoryTests {

    @Test
    public void testInsertBase() {
        Netflix showTest = new Netflix("Test","Film","Title","director","cast",
                "country","date_added", 2024,"rating","duration",
                "listed in", "description");
        IItem showDao = new NetflixDao();
        showDao.insert(showTest);
        System.out.println(showTest);
    }

    @Test
    public void testGetAllShows() {
        NetflixDao showDao = new NetflixDao();
        List<Netflix> listShows = showDao.getAllShows();

        for (Netflix tmp : listShows
        ) {
            System.out.println(tmp);
        }
    }

    @Test
    public void testGetAllAmericanMovies() {
        NetflixDao showDao = new NetflixDao();
        List<Netflix> listShows = showDao.getAllAmericanMovies();

        for (Netflix tmp : listShows
        ) {
            System.out.println(tmp);
        }
    }

    @Test
    public void testGetAllCanadianShowsRecent() {
        NetflixDao showDao = new NetflixDao();
        List<Netflix> listCanadianShows = showDao.GetAllCanadianShowsRecent();

        for (Netflix tmp : listCanadianShows
        ) {
            System.out.println(tmp);
        }
    }

    @Test
    public void testGetShow() {
        NetflixDao showDao = new NetflixDao();
        Netflix show = showDao.getShow(5);
        System.out.println(show);
    }


}
