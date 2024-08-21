package Dao;

import Entities.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDao extends BancoDao {

    public void inserir(Livro l) {
        String sql = """
                insert into livro(titulo, anoDeLancamento, id_autor) values(?, ?, ?);
                """;
        try (Connection con = con();
             PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setString(1, l.getTitulo());
            pre.setInt(2, l.getAnoDeLancamento());
            pre.setInt(3, l.getId_autor());
            pre.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Livro l){
        String sql = """
            update livro set titulo = ?, anoDeLancamento = ?, id_autor = ? where id_livro = ?;
            """;
        try(Connection con = con();
        PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1,l.getTitulo());
            pre.setInt(2,l.getAnoDeLancamento());
            pre.setInt(3,l.getId_autor());
            pre.setInt(4,l.getId_livro());
            pre.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(Livro l){
        String sql = """
                delete from livro where id_livro = ?;
                """;
        try(Connection con = con();
        PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1,l.getId_livro());
            pre.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Livro> obterTodos(){
        List<Livro> lista = new ArrayList<>();
        String sql = """
                select id_livro, titulo, anoDeLancamento, id_autor from livro
                order by titulo asc;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Livro l = new Livro();
                l.setId_livro(rs.getInt("id_livro"));
                l.setTitulo(rs.getString("titulo"));
                l.setAnoDeLancamento(rs.getInt("anoDeLancamento"));
                l.setId_autor(rs.getInt("id_autor"));
                lista.add(l);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
}
