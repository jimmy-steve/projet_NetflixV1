package dao;

import modeles.Show;
import modeles.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserDao implements IShow{
    /**
     * Permet d'aller cherche tout la liste des shows
     *
     * @return une liste de show complête
     */
    @Override
    public List<Show> getAllShows() {
        return null;
    }

    /**
     * Permet d'aller chercher un show
     *
     * @param id
     * @return un show
     */
    @Override
    public Show getShow(int id) {
        return null;
    }

    public List<User> getAllUsers() {
        List listeUsers = null;

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("SELECT * FROM User;", User.class);
            listeUsers = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listeUsers;
        } finally {
            entityManager.close();
        }
        return listeUsers;
    }
}
