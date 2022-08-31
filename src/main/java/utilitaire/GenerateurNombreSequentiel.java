package utilitaire;

import java.time.LocalDate;

/**
 * GenerateurFacture
 * QUi permet de générer un nombre selon la date
 *
 * @author Francis Lafontaine
 * @since 27/08/2022
 */
public class GenerateurNombreSequentiel {




    static int serialNo = 000;
    static LocalDate todaysDate = LocalDate.now();

    /**
     * Méthode qui générer un nombre avec la date et une suite de nombre croissante par la suite
     *
     * @return un nombre séquentiel sur la date
     */
    public static String genererNombre() {
        String nombre = "";
        serialNo++;
        nombre = String.valueOf(todaysDate.getYear() + String.valueOf(todaysDate.getMonthValue())
                + String.valueOf(todaysDate.getDayOfMonth()) + serialNo);

        return nombre;
    }
}
