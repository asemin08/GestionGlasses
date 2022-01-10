package eu.ensup.gestionglasses.container;

import eu.ensup.gestionglasses.dao.GlasseDao;
import eu.ensup.gestionglasses.dao.GlasseDaoJpa;
import eu.ensup.gestionglasses.service.GlasseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlasseServiceBeansConfig {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(GlasseDaoBeansConfig.class);

    GlasseDao glasseDao = (GlasseDao) applicationContext.getBean("glasseDao");

    @Bean(initMethod = "initialisation", destroyMethod = "destruction")
    public GlasseService glasseService() {
        return new GlasseService(glasseDao);
    }

}
