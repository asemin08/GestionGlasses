package eu.ensup.gestionglasses.container;

import eu.ensup.gestionglasses.dao.GlasseDao;
import org.springframework.context.annotation.Bean;

public class GlasseDaoBeansConfig {

    @Bean(initMethod = "initialisation", destroyMethod = "destruction")
    public GlasseDao glasseDao() {
        return new GlasseDao();
    }

}
