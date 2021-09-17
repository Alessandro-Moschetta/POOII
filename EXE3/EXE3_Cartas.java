package exe3_carta;

public class EXE3_Cartas {

    public static void main(String[] args){
        
        try {
            Baralho b1 = new Baralho();
            b1.imprimeBaralho();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}