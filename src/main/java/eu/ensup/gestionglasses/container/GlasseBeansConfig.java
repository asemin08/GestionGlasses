package eu.ensup.gestionglasses.container;

import eu.ensup.gestionglasses.dao.GlasseDao;
import eu.ensup.gestionglasses.dao.GlasseDaoJpa;
import eu.ensup.gestionglasses.service.GlasseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlasseBeansConfig {
    @Bean(initMethod = "initialisation", destroyMethod = "destruction")
    public GlasseService glasseService() {
        return new GlasseService(glasseDaoJpa());
    }

    @Bean(initMethod = "initialisation", destroyMethod = "destruction")
    public GlasseDao glasseDao() {
        return new GlasseDao();
    }

    @Bean(initMethod = "initialisation", destroyMethod = "destruction")
    public GlasseDaoJpa glasseDaoJpa() {
        return new GlasseDaoJpa();
    }
}
