package eu.ensup.gestionglasses.launcher;


import eu.ensup.gestionglasses.dao.GlasseDao;
import eu.ensup.gestionglasses.dao.GlasseDaoJpa;
import eu.ensup.gestionglasses.dao.IDao;
import eu.ensup.gestionglasses.domaine.Glasse;
import eu.ensup.gestionglasses.service.GlasseService;

public class Launcher {

    public static void main(String[] args) {
        Glasse glasse1 = new Glasse(1, 123456789, "Rouge", 120.00);

        IDao iDao = new GlasseDao();

        IDao iDaoJpa = new GlasseDaoJpa();

        GlasseService glasseService = new GlasseService(iDaoJpa);
        glasseService.creerGlasse(glasse1);

        Glasse glasse2 = glasseService.recuperationGlasse(2);
        if (glasse2 != null) {
            System.out.println("LAUNCHER: Récuperation du compte réussie " + glasse2.toString());
        } else {
            System.out.println("LAUNCHER: Récuperation des lunettes échoué");
        }
    }

}
