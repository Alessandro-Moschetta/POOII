package exercicio_aula1908;

public class Autor {
    
    private String nome;
    private Livro livro;

    public Autor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    void setCapitulo(int i, Capitulo c1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    Object getCapitulo(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}