package Electricity;

import java.sql.*;

public class Conn {

    public static Connection connect() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql:///Electricity", "root", "");
    }
}
