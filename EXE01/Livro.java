package exercicio_aula1908;

public class Livro {
    
    private String ISBN;
    private Capitulo[] capitulos;

    public Livro(String ISBN) {
        this.ISBN = ISBN;
        
        capitulos = new Capitulo[5];
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    public Capitulo getCapitulo(int pos){
        return capitulos[pos];
    }
    
    public void setCapitulo(int pos, Capitulo c){
        capitulos[pos] = c;
    }    
}