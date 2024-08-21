import Dao.*;
import Entities.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        inicializarbd();

        AutorDao autordao = new AutorDao();
        LivroDao livrodao = new LivroDao();

        Autor autor = new Autor();
        autor.setNome("CÃ¡tia");
        autor.setNacionalidade("Brasil");

        autordao.inserir(autor);

        Livro livro = new Livro();
        livro.setTitulo("Anjos");
        livro.setAnoDeLancamento(2024);
        livro.setId_autor(autor.getId_autor());
        livrodao.inserir(livro);

    }

    private static void inicializarbd(){
        String sqlAutor = """
                CREATE TABLE IF NOT EXISTS autor (
                    id_autor INT PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL,
                    nacionalidade TEXT
                );
                """;

        String sqlLivro = """
                CREATE TABLE IF NOT EXISTS livro (
                    id_livro INT PRIMARY KEY AUTOINCREMENT,
                    titulo TEXT NOT NULL,
                    anoDeLancamento INTEGER NOT NULL,
                    id_autor INTEGER,
                    FOREIGN KEY (id_autor) REFERENCES autor(id_autor)
                );
                """;
        try (Connection con = ConexaoBD.getInstancia().getConexao();
             Statement pre = con.createStatement()) {
            pre.execute(sqlLivro);
            pre.execute(sqlAutor);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}