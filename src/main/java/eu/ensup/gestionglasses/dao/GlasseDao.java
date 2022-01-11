package eu.ensup.gestionglasses.dao;

import eu.ensup.gestionglasses.domaine.Glasse;

import javax.sql.DataSource;
import javax.sql.rowset.spi.SyncResolver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GlasseDao implements IDao {

    private DataSource bdd;

    public DataSource getBdd() {
        return bdd;
    }

    public void setBdd(DataSource bdd) {
        this.bdd = bdd;
    }


    @Override
    public Glasse getGlasseById(int id) {

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        /// TODO Remove Try/Catch
        try{
            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            cn = bdd.getConnection();
            System.out.println(cn);

            // Etape 3 : Création d'un statement
            st = cn.createStatement();

            /// TODO Utiliser des prepareStatement
            String sql = "SELECT * FROM Glasse WHERE id = " + id;

            // Etape 4 : exécution requête
            rs = st.executeQuery(sql);

            // Si récup données alors étapes 5 (parcours Resultset)

            while (rs.next()) {
                return new Glasse(rs.getInt("id"), rs.getInt("reference"), rs.getString("label"),
                        rs.getDouble("price"));
            }
        } catch(SQLException | ClassNotFoundException e){
            // TODO Remove stack Trace
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
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            cn = bdd.getConnection();

            // Etape 3 : Création d'un statement
            st = cn.createStatement();

            String sql = "INSERT INTO Glasse (reference, label, price) VALUES (" + glasse.getReference()
                    + ", '" + glasse.getLabel() + "', '" + glasse.getPrice() + "' )";


            // Etape 4 : exécution requête
            st.executeQuery(sql);


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

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            cn = bdd.getConnection();

            // Etape 3 : Création d'un statement
            st = cn.createStatement();

            String sql = "SELECT * FROM Glasse";


            // Etape 4 : exécution requête
            rs = st.executeQuery(sql);

            // Si récup données alors étapes 5 (parcours Resultset)

            List<Glasse> glassesList = new ArrayList<Glasse>();
            while (rs.next()) {
                glassesList.add(new Glasse(rs.getInt("id"), rs.getInt("reference"), rs.getString("label"),
                        rs.getDouble("price")));
            }
            return glassesList;
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

    public void initialisation() {
        System.out.println("DAO: creation spring");
    }

    public void destruction() {
        System.out.println("DAO: destruction spring");
    }
}
