package com.gigi.portingjavaospedale.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PazienteDAO {
    private static ArrayList<Paziente> pazienti;

    public static ArrayList<Paziente> getPazienti() {
        pazienti = new ArrayList<>();
        String query = "SELECT * FROM Patients";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ospedale", "root", "");
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            while (resultSet.next()){
                pazienti.add(new Paziente(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("cognome"), resultSet.getString("sesso"), String.valueOf(resultSet.getObject("dataNascita"))));
            }
            resultSet.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return pazienti;
    }
}
