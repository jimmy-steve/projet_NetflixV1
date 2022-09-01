package dao;

import modeles.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Name : UserDao
 * Classe qui implémente la classe IItem
 * et permet de persister tout les donnée et de faire les requête
 * pour le user
 *
 * @author Francis Lafontaine
 * @version V1
 * @since 01/09/2022
 */
public class UserDao implements IItem {
    /**
     * Name : getAllUsers
     * Méthode permmetant d'aller chercher tout la liste des users
     * pour pouvoir les modifié par apres
     * @return une liste de tous les users
     */
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

    /**
     * Name : GetUser
     * Permetant d'aller chercher un user pour modifié ces informations
     *
     * @param idUser pren un int en paramete qui est le id user
     * @return le user directement
     */
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
