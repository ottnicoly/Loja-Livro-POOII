package Entities;

public class Autor {
    private int id_autor;
    private String nome;
    private String nacionalidade;

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String toString() {
        return "Autor: " +
                "id_autor = " + id_autor +
                ", nome = '" + nome +
                ", nacionalidade = " + nacionalidade;
    }
}
