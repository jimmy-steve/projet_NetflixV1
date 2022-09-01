package dao;

import modeles.Netflix;
import modeles.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserDao implements IItem {
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

    public User getUser(long idUser) {
        User user = null;
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            user = entityManager.find(User.class, idUser);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return user;
        } finally {
            entityManager.close();
        }
    }
}
