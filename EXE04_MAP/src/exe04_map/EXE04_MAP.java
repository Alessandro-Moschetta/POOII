package exe04_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EXE04_MAP {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Map<String,String> hm = new HashMap<>();
        //int cont = 0;
        String nome = "";
        String fone = "";
        while(!nome.equals("*")){
            System.out.println("Digite um Nome (* finaliza): ");
            nome = sc.nextLine();
            System.out.println("Informe um Telefone: ");
            fone = sc.nextLine();
            if (nome.equals("*")) continue;
            hm.put(nome, fone);
            System.out.println(hm);
        }
        do {
            System.out.println("Digite um nome para Excluir (* finaliza): ");
            nome = sc.nextLine();
            fone = sc.nextLine();
            if (nome.equals("*")) continue;
            if (hm.containsKey(nome)){
                hm.remove(nome, fone);
                System.out.println("Nome e Fone removido.\n" +hm);
            }
            else{
                System.out.println("Nome não Encontrado.\n" +hm);
            }
        } while (!nome.equals("*"));
        sc.close();
    }
}