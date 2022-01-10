package eu.ensup.gestionglasses.dao;

import eu.ensup.gestionglasses.domaine.Glasse;

import java.util.List;

public class GlasseDao implements IDao {

    @Override
    public Glasse getGlasseById(int id) {
        System.out.println("DAO: récupération des lunettes id=" + id);

        if (id == 2) {
            return new Glasse(2, 0001, "bordeau", 100.00);
        }
        return null;
    }

    @Override
    public void createGlasse(Glasse glasse) {
        System.out.println("DAO: création des lunettes " + glasse.toString());
    }

    @Override
    public Glasse updateGlasse(Glasse glasse) {
        System.out.println("DAO: mise à jour du lunettes " + glasse.toString());
        return null;
    }

    @Override
    public void deleteGlasse(Glasse glasse) {
        System.out.println("DAO: suppression des lunettes " + glasse.toString());
    }

    @Override
    public List<Glasse> getAllGlasse() {
        System.out.println("DAO: récupération de toutes les lunettes");
        return null;
    }

    public void initialisation() {
        System.out.println("DAO: creation spring");
    }

    public void destruction() {
        System.out.println("DAO: destruction spring");
    }
}
