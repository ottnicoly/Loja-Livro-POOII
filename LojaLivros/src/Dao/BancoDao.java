package Dao;

import java.sql.Connection;
import java.sql.SQLException;

public class BancoDao {
    protected Connection con() throws SQLException {
        return ConexaoBD.getInstancia().getConexao();
    }

}
