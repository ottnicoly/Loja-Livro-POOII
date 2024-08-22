import dao.*;
import entity.*;
import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        AutorDAO autordao = new AutorDAO();
        LivroDAO livrodao = new LivroDAO();

        String url = "jdbc:sqlite:meu_banco.db";
        try (Connection con = DriverManager.getConnection(url)) {
            String sqlAutor = """
                CREATE TABLE IF NOT EXISTS autor (
                    id_autor INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL,
                    nacionalidade TEXT NOT NULL
                );
                """;

            String sqlLivro = """
                CREATE TABLE IF NOT EXISTS livro(
                    idlivro INTEGER PRIMARY KEY AUTOINCREMENT,
                    nomelivro TEXT NOT NULL,
                    ano INTEGER NOT NULL,
                    id_autor INTEGER,
                    FOREIGN KEY (id_autor) REFERENCES autor(id_autor));
                """;
            try (Statement pre = con.createStatement()) {
                pre.execute(sqlLivro);
                pre.execute(sqlAutor);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        //Adicionar Autor ->
//        Autor autor = new Autor("Casey McQuiston","estadunidense");
//        autordao.inserir(autor);

        //Atualizar Autor ->
//        Autor autoratualizar = new Autor("Coleen Hoover","Brasil");
//        autordao.atualizar(10,autoratualizar);

        //Deletar Autor ->
//        Autor autordeletar = autordao.getAutor(1);
//        autordao.excluir(autordeletar);

        //Obter Todos ->
        List<Autor> autortodos = autordao.obterTodos();
        System.out.println(autortodos);

//        --------------------------------------

        //Adicionar Livro ->
//        Livro livro = new Livro(1,"VERMELHO BRANCO E SANGUE AZUL",2019,1);
//        livrodao.inserir(livro);

        //Atualizar Livro ->
//        Livro livroatualizar = new Livro(2,"É Assim que Acaba",2016,10);
//        livrodao.atualizar(2,livroatualizar);


        //Deletar Livro ->
//        Livro livrodeletar = livrodao.getlivro(1);
//        livrodao.excluir(livrodeletar);

        //Obter Todos ->
        List<Livro> livrotodos = livrodao.obterTodos();
        System.out.println(livrotodos);

        //Listar por ID ->
        List<Livro> livropautor = livrodao.ListaPorAutor(1);
        System.out.println(livropautor);
    }
}




