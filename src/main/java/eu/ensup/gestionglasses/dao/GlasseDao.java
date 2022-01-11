package eu.ensup.gestionglasses.dao;

import eu.ensup.gestionglasses.domaine.Glasse;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GlasseDao implements IDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Glasse getGlasseById(int id) {

        System.out.println("DAO: récupération de la lunette id=" + id);


        Object[] arguments = new Object[1];
        arguments[0] = id;
        String sql = "SELECT * FROM Glasse WHERE id = " + id;
		return (Glasse) jdbcTemplate.queryForObject(sql, (resultSet, rowNum) -> {
			return new Glasse(resultSet.getInt("id"), resultSet.getInt("reference"), resultSet.getString("label"),
					resultSet.getDouble("price"));
		});

    }

    @Override
    public void createGlasse(Glasse glasse) {
        System.out.println("DAO: création des lunettes " + glasse.toString());
        String query = "insert into Glasse(reference, label, price) value(?,?,?)";
        jdbcTemplate.update(query, glasse.getReference(), glasse.getLabel(), glasse.getPrice());
    }

    @Override
    public Glasse updateGlasse(Glasse glasse) {
        return glasse;
    }

    @Override
    public void deleteGlasse(Glasse glasse) {
        System.out.println("DAO: suppression des lunettes " + glasse.toString());
    }

    @Override
    public List<Glasse> getAllGlasse() {
        return jdbcTemplate.query("SELECT * FROM Glasse", (resultSet, rowNum) -> {
            return new Glasse(resultSet.getInt("id"), resultSet.getInt("reference"), resultSet.getString("label"),
                    resultSet.getDouble("price"));
        });
    }

    public void initialisation() {
        System.out.println("DAO: creation spring");
    }

    public void destruction() {
        System.out.println("DAO: destruction spring");
    }
}
