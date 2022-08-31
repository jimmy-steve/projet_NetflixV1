package dao;

import modeles.Show;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ShowDao implements IShow {

    static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("hibernate");

    /**
     * Permet d'aller cherche tout la liste des shows
     *
     * @return une liste de show complête
     */
    @Override
    public List<Show> getAllShows() {
        List listeShows = null;

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("SELECT * FROM netflix;", Show.class);
            listeShows = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listeShows;
        } finally {
            entityManager.close();
        }
        return listeShows;
    }

    /**
     * Permet d'aller chercher un show
     *
     * @return un show
     */
    @Override
    public Show getShow(int id) {
        Show show = null;

        EntityManager entityManager = null;
        /**
         * faire un try catch pour gerer les probleme lors de la transaction
         */
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            //show = entityManager.find(Show.class, id);

            Query query = entityManager.createNativeQuery("select * from netflix where id = "+id+";", Show.class);
            show = (Show) query.getResultStream().findFirst().get();


            return show;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();//----------------reviens en arrière
            return show;
        } finally {
            entityManager.close();//dans l'etat detached
        }
    }

    public List<Show> getAllAmericanMovies() {
        List<Show> listAmericanShows = new ArrayList<>();


        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("select * from netflix \n" +
                    "where country like 'United States' and type like 'Movie';", Show.class);
            listAmericanShows = query.getResultList();
            return listAmericanShows;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listAmericanShows;
        } finally {
            entityManager.close();
        }
    }

    public List<Show> GetAllCanadianShowsRecent() {
        List<Show> listCanadianShows = new ArrayList<>();

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("select * from netflix \n" +
                    "where country like 'Canada' and type like 'TV Show' and release_year >= 2020;", Show.class);
            listCanadianShows = query.getResultList();
            return listCanadianShows;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listCanadianShows;
        } finally {
            entityManager.close();
        }
    }

    public List<Show> GetAllCanadian() {
        List<Show> listCanadianShows = new ArrayList<>();

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("select * from netflix \n" +
                    "where country like 'Canada' ;", Show.class);
            listCanadianShows = query.getResultList();
            return listCanadianShows;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listCanadianShows;
        } finally {
            entityManager.close();
        }
    }

    public List<Show> GetAllAmerican() {
        List<Show> listAmerican = new ArrayList<>();

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("select * from netflix \n" +
                    "where country like 'United States';", Show.class);
            listAmerican = query.getResultList();
            return listAmerican;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listAmerican;
        } finally {
            entityManager.close();
        }
    }

    public List<Show> GetAllkids() {
        List<Show> listKids = new ArrayList<>();

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("select * from netflix where listed_in like '%Kids%';"
                    , Show.class);
            listKids = query.getResultList();
            return listKids;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listKids;
        } finally {
            entityManager.close();
        }
    }
}
