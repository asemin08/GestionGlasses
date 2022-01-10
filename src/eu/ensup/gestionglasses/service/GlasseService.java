package eu.ensup.gestionglasses.service;

import eu.ensup.gestionglasses.dao.GlasseDao;
import eu.ensup.gestionglasses.domaine.Glasse;

import java.util.List;

public class GlasseService {

    private GlasseDao glasseDao;

    public GlasseService() {
        super();
        this.glasseDao = new GlasseDao();
    }

    public Glasse recuperationGlasse(int id) {
        System.out.println("SERVICE: récupération des lunettes id=" + id);

        Glasse glasseReturn = glasseDao.getGlasseById(id);
        return glasseReturn;
    }

    public void creerGlasse( Glasse glasse) {
        System.out.println("SERVICE: création du glasse " + glasse.toString());

        glasseDao.createGlasse(glasse);
    }

    public Glasse mettreAJourGlasse(Glasse glasse) {
        System.out.println("SERVICE: mise à jour des lunettes " + glasse.toString());

        Glasse glasseReturn = glasseDao.updateGlasse(glasse);
        return glasseReturn;
    }

    public void supprimerGlasse(Glasse glasse) {
        System.out.println("SERVICE: suppression des lunettes " + glasse.toString());

        glasseDao.deleteGlasse(glasse);
    }

    public List<Glasse> recuperationGlasse() {
        System.out.println("SERVICE: récupération de toutes les lunettes");

        List<Glasse> compteListeRetour = glasseDao.getAllGlasse();
        return compteListeRetour;
    }

    public void comparaisonGlasse(Glasse glasse1, Glasse glasse2) {
        System.out.println("SERVICE: comparaison entre deux lunettes");
    }
}
