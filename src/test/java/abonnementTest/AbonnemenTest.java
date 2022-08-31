package abonnementTest;

import dao.AbonnementDao;
import dao.IShow;
import modeles.Abonnement;
import org.junit.jupiter.api.Test;

public class AbonnemenTest {
    @Test
    public void testInsert() {
        Abonnement abonnement = new Abonnement(1,"Annuelle",20.99,1);
        IShow abonnementDao = new AbonnementDao();
        abonnementDao.insert(abonnement);
    }
}
