package dao;

import modeles.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Name : ClientDao
 * Cette classe qui implémente IItem
 * permet de persister les données pour le client
 *
 *
 * @author Francis Lafontaine
 * @version V1
 * @since 01/09/2022
 */
public class ClientDao implements IItem {
    static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("hibernate");

    /**
     * Name : GetAllClients
     * permettant d'aller chercher une listes de client dans la base de donnée
     * @return la liste de tout les clients
     */
    public List<Client> getAllClients() {
        List listeClients = null;

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("SELECT * FROM client;", Client.class);
            listeClients = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listeClients;
        } finally {
            entityManager.close();
        }
        return listeClients;
    }

    /**
     * Name : getClient
     * Méthode permettant d'aller cherche un client
     * @param numeroClient qui est son id de client
     * @return un objet de type client
     */
    public static Object getClient(long numeroClient) {
        Object client = null;

        EntityManager entityManager = null;
        /*
         * faire un try catch pour gerer les probleme lors de la transaction
         */
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            client = entityManager.find(Client.class, numeroClient);
            return client;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return client;
        } finally {
            entityManager.close();
        }
    }


}
