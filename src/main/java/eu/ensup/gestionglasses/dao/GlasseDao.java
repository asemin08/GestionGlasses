package eu.ensup.gestionglasses.dao;

import eu.ensup.gestionglasses.domaine.Glasse;

import java.sql.*;
import java.util.List;

public class GlasseDao implements IDao {

    private String url = "jdbc:mysql://vps-0c0ccce5.vps.ovh.net:3306/spring";
    private String login = "root";
    private String passwd = "0D2B87E1DE55A9BD89009B37979CACD984AA773C7197BE3F46DCB15B0CAE7E6D";

    @Override
    public Glasse getGlasseById(int id) {

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);

            // Etape 3 : Création d'un statement
            st = cn.createStatement();

            String sql = "SELECT * FROM Glasse WHERE id = " + id;


            // Etape 4 : exécution requête
            rs = st.executeQuery(sql);

            // Si récup données alors étapes 5 (parcours Resultset)

            while (rs.next()) {
                return new Glasse(rs.getInt("id"), rs.getInt("reference"), rs.getString("label"),
                        rs.getDouble("price"));
            }
        } catch(SQLException | ClassNotFoundException e){
            // TODO Remove
            e.printStackTrace();
        } finally {
            try {
                // Etape 6 : libérer ressources de la mémoire.
                cn.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
