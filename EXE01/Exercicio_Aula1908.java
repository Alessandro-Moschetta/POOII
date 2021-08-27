package exercicio_aula1908;

public class Exercicio_Aula1908 {

    public static void main(String[] args) {
        
        Autor autor = new Autor("João da Silva");
        Biblioteca biblio = new Biblioteca("Biblioteca Municipal de Caçador");
        Livro livro = new Livro("Estudos POO - Nova Geração");
        
        System.out.println("Quem é o Autor? " + autor.getNome());
        System.out.println("O Livro está na " + biblio.getNome());
        
        Capitulo c1 = new Capitulo(1);
        Capitulo c2 = new Capitulo(3);
        Capitulo c3 = new Capitulo(5);
        Capitulo c4 = new Capitulo(7);
        
        livro.setCapitulo(0, c1);
        livro.setCapitulo(1, c2);
        livro.setCapitulo(2, c3);
        livro.setCapitulo(3, c4);
        
        System.out.println("Capitulo numero: " + livro.getCapitulo(0).getNum());
        System.out.println("Capitulo numero: " + livro.getCapitulo(1).getNum());
        System.out.println("Capitulo numero: " + livro.getCapitulo(2).getNum());
        System.out.println("Capitulo numero: " + livro.getCapitulo(3).getNum());
    }    
}