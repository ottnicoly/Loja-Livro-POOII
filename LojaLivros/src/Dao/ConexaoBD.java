package Dao;

import java.sql.*;

public class ConexaoBD {

    private ConexaoBD(){}
    private static ConexaoBD instancia;

    public synchronized static ConexaoBD getInstancia(){
        if(instancia == null){
            instancia = new ConexaoBD();
        }
        return instancia;
    }

    public Connection getConexao() throws SQLException {
        String url = "jdbc:sqlite:meu_banco.db";
        Connection conexao = DriverManager.getConnection(url);
        return conexao;
    }


}
