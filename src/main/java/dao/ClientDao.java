package dao;

import modeles.Client;
import modeles.Netflix;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ClientDao implements IItem {
    static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("hibernate");


    Boolean insert(Client client) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(client);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    /**
     * Permet d'aller cherche tout la liste des shows
     *
     * @return une liste de show complête
     */
    @Override
    public List<Netflix> getAllShows() {
        return null;
    }

    /**
     * Permet d'aller chercher un show
     *
     * @param id
     * @return un show
     */
    @Override
    public Netflix getShow(int id) {
        return null;
    }


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

    public static Object getClient(long numeroClient) {
        Object client = null;

        EntityManager entityManager = null;
        /**
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

    public static Client getUnClient(long id) {
        Client client = null;
        EntityManager entityManager = null;
        try {

            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Client response = (Client) entityManager.find(Client.class, id);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return client;
        } finally {
            entityManager.close();
        }
    }


}
