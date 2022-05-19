package conexaoDB;

import java.sql.*;

public class ConexaoDB {

    public Connection getConexaoDB() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/projeto_final_loja",
                "root",
                ""
        );
        return connection;
    }
}
