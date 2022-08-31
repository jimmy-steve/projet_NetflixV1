package clientTest;

import dao.AbonnementDao;
import dao.ClientDao;
import dao.IShow;
import dao.UserDao;
import modeles.Abonnement;
import modeles.Client;
import modeles.User;
import org.junit.jupiter.api.Test;
import utilitaire.GenerateurNombreSequentiel;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static utilitaire.GenerateurNombreSequentiel.*;


public class ClientTest {
    @Test
    public void testInsert() {
        for (int i = 0; i < 10; i++) {
            Client client = new Client("testNom", "testPrenom", "testAdresse",
                    "testo@gmail.com", "(450)555-5555",
                    Integer.parseInt(genererNombre()));
            IShow clientDao = new ClientDao();
            clientDao.insert(client);
        }
    }

    @Test
    public void testGetAllClients() {
        ClientDao clientDao = new ClientDao();
        List<Client> listClients = clientDao.getAllClients();
        for (Client tmp : listClients
        ) {
            System.out.println(tmp);
        }
    }

    @Test
    public void testCreationNewClientAbonnement() {
        /**
         * je décide de créer plusieurs client avec les meme information nais avec id difféend
         */
        for (int i = 0; i < 10; i++) {
            /**
             * je créer un client typique
             */
            Client client = new Client("testNom", "testPrenom", "testAdresse",
                    "testo@gmail.com", "(450)555-5555", Integer.parseInt(genererNombre()));

            /**
             * je créer un user typique
             */
            User user = new User("test", "1234", "null2");
            /**
             * j'enregistre le user dans la base de donnée
             */
            IShow userDao = new UserDao();
            userDao.insert(user);
            /**
             * J'enregistre le client dans la base de donnée
             */
            client.setIdUser(user.getIdUser());
            IShow clientDao = new ClientDao();
            clientDao.insert(client);

            /**
             * je créer un abonnement pour le user
             */
            Abonnement abonnement = new Abonnement(client.getIdAbonnement(), "Annuel", 25.77, user.getIdUser());

            /**
             * J"enregistre l'abonnement fans la base donnée
             */

            AbonnementDao abonnementDao = new AbonnementDao();
            abonnementDao.insert(abonnement);
        }

    }


    @Test
    public void testGenererTableauSequentiel() {
        List<String> liste = new ArrayList();

        for (int i = 0; i < 50; i++) {
            String nbr = genererNombre();
            liste.add(nbr);
        }

        for (String tmp : liste
        ) {
            System.out.println(tmp);
        }
    }


}



