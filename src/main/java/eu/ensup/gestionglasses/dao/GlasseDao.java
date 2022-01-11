package eu.ensup.gestionglasses.dao;

import eu.ensup.gestionglasses.domaine.Glasse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GlasseDao implements IDao {

    @Autowired
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
        System.out.println("DAO: update des lunettes " + glasse.toString());
        String query = "update Glasse set reference = ?, label = ?, price = ? where id = ?";
        jdbcTemplate.update(query, glasse.getReference(), glasse.getLabel(), glasse.getPrice(), glasse.getId());
        return glasse;
    }

    @Override
    public void deleteGlasse(Glasse glasse) {
        System.out.println("DAO: suppression des lunettes " + glasse.toString());
        String deleteQuery = "delete from Glasse where id = ?";
        jdbcTemplate.update(deleteQuery, glasse.getId());
    }

    @Override
    public List<Glasse> getAllGlasse() {
        return jdbcTemplate.query("SELECT * FROM Glasse", (resultSet, rowNum) -> {
            return new Glasse(resultSet.getInt("id"), resultSet.getInt("reference"), resultSet.getString("label"),
                    resultSet.getDouble("price"));
        });
    }

    @PostConstruct
    public void initialisation() {
        System.out.println("DAO: creation spring");
    }

    @PreDestroy
    public void destruction() {
        System.out.println("DAO: destruction spring");
    }
}
