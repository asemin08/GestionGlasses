package eu.ensup.gestionglasses.service;

import eu.ensup.gestionglasses.dao.GlasseDao;
import eu.ensup.gestionglasses.dao.IDao;
import eu.ensup.gestionglasses.domaine.Glasse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class GlasseService {

    @Autowired
    private IDao iDao;

    public GlasseService(IDao iDao) {
        super();
        this.iDao = iDao;
    }

    public GlasseService() {
        super();
    }

    public Glasse recuperationGlasse(int id) {
        System.out.println("SERVICE: récupération des lunettes id=" + id);

        Glasse glasseReturn = iDao.getGlasseById(id);
        return glasseReturn;
    }

    public void creerGlasse( Glasse glasse) {
        System.out.println("SERVICE: création du glasse " + glasse.toString());

        iDao.createGlasse(glasse);
    }

    public Glasse mettreAJourGlasse(Glasse glasse) {
        System.out.println("SERVICE: mise à jour des lunettes " + glasse.toString());

        Glasse glasseReturn = iDao.updateGlasse(glasse);
        return glasseReturn;
    }

    public void supprimerGlasse(Glasse glasse) {
        System.out.println("SERVICE: suppression des lunettes " + glasse.toString());

        iDao.deleteGlasse(glasse);
    }

    public List<Glasse> recuperationGlasse() {
        System.out.println("SERVICE: récupération de toutes les lunettes");

        List<Glasse> compteListeRetour = iDao.getAllGlasse();
        return compteListeRetour;
    }

    public void comparaisonGlasse(Glasse glasse1, Glasse glasse2) {
        System.out.println("SERVICE: comparaison entre deux lunettes");
    }

    @PostConstruct
    public void initialisation() {
        System.out.println("Service: creation spring");
    }

    @PreDestroy
    public void destruction() {
        System.out.println("Service: destruction spring");
    }

    public IDao getiDao() {
        return iDao;
    }

    public void setiDao(IDao iDao) {
        this.iDao = iDao;
    }
}
