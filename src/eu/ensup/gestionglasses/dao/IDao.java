package eu.ensup.gestionglasses.dao;

import eu.ensup.gestionglasses.domaine.Glasse;

import java.util.List;


public interface IDao {

    Glasse getGlasseById(int id);

    void createGlasse(Glasse glasse);

    Glasse updateGlasse(Glasse glasse);

    void deleteGlasse(Glasse glasse);

    List<Glasse> getAllGlasse();

}