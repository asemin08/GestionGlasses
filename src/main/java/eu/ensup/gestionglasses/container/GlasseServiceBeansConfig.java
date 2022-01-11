package eu.ensup.gestionglasses.container;

import eu.ensup.gestionglasses.dao.GlasseDao;
import eu.ensup.gestionglasses.dao.GlasseDaoJpa;
import eu.ensup.gestionglasses.service.GlasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GlasseDaoBeansConfig.class)
public class GlasseServiceBeansConfig {

    @Autowired
    private GlasseDao glasseDao;

    @Bean(initMethod = "initialisation", destroyMethod = "destruction")
    public GlasseService glasseService() {
        return new GlasseService(glasseDao);
    }

}
