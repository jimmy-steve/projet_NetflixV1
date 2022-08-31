package modeles;

import javax.persistence.*;

@Entity
public class Abonnement {
    @Id
    @Column(name = "id_abonnement")
    private int idAbonnement;
    @Column(name = "type_abonnement")
    private String typeAbonnement;
    private double prix;
    @Column(name = "id_user")
    private long idUser;

    public Abonnement() {
    }

    public Abonnement(int idAbonnement, String typeAbonnement, double prix, long idUser) {
        this.idAbonnement = idAbonnement;
        this.typeAbonnement = typeAbonnement;
        this.prix = prix;
        this.idUser = idUser;
    }

    public int getIdAbonnement() {
        return idAbonnement;
    }

    public void setIdAbonnement(int idAbonnement) {
        this.idAbonnement = idAbonnement;
    }

    public String getTypeAbonnement() {
        return typeAbonnement;
    }

    public void setTypeAbonnement(String typeAbonnement) {
        this.typeAbonnement = typeAbonnement;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Abonnement{" +
                "idAbonnement=" + idAbonnement +
                ", typeAbonnement='" + typeAbonnement + '\'' +
                ", prix=" + prix +
                ", idUser=" + idUser +
                '}';
    }
}
