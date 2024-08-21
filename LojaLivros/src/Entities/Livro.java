package Entities;

public class Livro {
    private int id_livro;
    private String titulo;
    private int anoDeLancamento;
    private int id_autor;

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String toString() {
        return "Livro: " + "id_livro = " + id_livro + ", nome = " + titulo + ", ano de lançamento = " + anoDeLancamento + "id_autor = " + id_autor;
    }
}
