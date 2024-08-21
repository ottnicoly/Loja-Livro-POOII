package Dao;
import Entities.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AutorDao extends BancoDao {

    public void inserir (Autor a){
        String sql = """
                insert into autor(nome, nacionalidade) values(?, ?);
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1,a.getNome());
            pre.setString(2,a.getNacionalidade());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizar(Autor a){
        String sql = """
                update autor set nome = ?, nacionalidade = ? where id_autor = ?;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1,a.getNome());
            pre.setString(2,a.getNacionalidade());
            pre.setInt(3,a.getId_autor());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar (Autor a){
        String sql = """
                delete from autor where id_autor = ?;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1,a.getId_autor());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Autor> obterTodos(){
        List<Autor> lista = new ArrayList<>();
        String sql = """
                select id_autor, nome from pessoa
                order by nome asc;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Autor a = new Autor();
                a.setId_autor(rs.getInt("id_autor"));
                a.setNome(rs.getString("nome"));
                a.setNacionalidade(rs.getString("nacionalidade"));
                lista.add(a);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }


}
