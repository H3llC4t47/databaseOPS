package main;

import java.sql.*;

public class main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/c3zoo", "root", ""

        );

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(
                "SELECT D.nazev FROM Zvirata AS Z JOIN Druhy AS D ON (D.id = Z.druh)"

        );

        while (result.next()) {

            String title = result.getString("jmeno");
            String nazevdruhu = result.getString("nazev");
            int id = result.getInt("id");
            System.out.println(nazevdruhu + "\t;" + title + "\t;" + id);

        }
        connection.close();
    }
}
