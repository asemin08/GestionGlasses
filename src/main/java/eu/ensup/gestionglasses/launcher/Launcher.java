package eu.ensup.gestionglasses.launcher;


import eu.ensup.gestionglasses.domaine.Glasse;
import eu.ensup.gestionglasses.service.GlasseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

    public static void main(String[] args) {

        // 1. Chargement du conteneur en 4.0.0 Spring
        ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) new ClassPathXmlApplicationContext(
                "GlasseBeans.xml");

        // 2. Recuperation d'un bean du conteneur
        GlasseService glasseService = (GlasseService) applicationContext.getBean("glasseService");


        System.out.println(glasseService.recuperationGlasse(1));
        Glasse glasse1 = new Glasse(12,11444,"lunette violette",100.00);
        glasseService.creerGlasse(glasse1);

        System.out.println(glasseService.recuperationGlasse());



    }

}
