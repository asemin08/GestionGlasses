package eu.ensup.gestionglasses.launcher;


import eu.ensup.gestionglasses.dao.GlasseDao;
import eu.ensup.gestionglasses.dao.GlasseDaoJpa;
import eu.ensup.gestionglasses.dao.IDao;
import eu.ensup.gestionglasses.domaine.Glasse;
import eu.ensup.gestionglasses.service.GlasseService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

    public static void main(String[] args) {

        // 1. Chargement du conteneur en 4.0.0 Spring
        ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) new ClassPathXmlApplicationContext(
                "glasse-beans.xml");

        // 2. Recuperation d'un bean du conteneur
        GlasseService compteService = (GlasseService) applicationContext.getBean("glasseService");

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
        applicationContext.close();

    }

}
