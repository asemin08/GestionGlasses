package eu.ensup.gestionglasses.dao;

import eu.ensup.gestionglasses.domaine.Glasse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GlasseDao extends JpaRepository<Glasse, Integer> {

    public List<Glasse> findByLabel(String label);
}
