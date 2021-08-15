import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        Aparencia aparencia = new Aparencia();

        aparencia.limparTela();
        System.out.println("\nNARUTO ULTIMATE NINJA STORM!");
        System.out.println("\nMenu Principal...\n");
        System.out.println("1 - Modo história");
        System.out.println("2 - Duelo");
        System.out.println("3 - Ranking");
        System.out.println("4 - Configurações");
        System.out.println("5 - Sair\n");

        String line = input.nextLine();                             
        System.out.println("\n");

        //Criar metodo para alterar tabela e inserir informações
        if(line.equals("1")){
            aparencia.limparTela();
            ModoHistoria historia = new ModoHistoria();
            historia.menuHistoria(aparencia);
            
        }else if(line.equals("2")){
            aparencia.limparTela();
            ModoDuelo duelo = new ModoDuelo();
            duelo.menuDuelo();
            
        }else if(line.equals("3")){
            aparencia.limparTela();
        
        }else if(line.equals("4")){
            aparencia.limparTela();
        
        }else if(line.equals("5")){
            aparencia.limparTela();
            System.out.println("\n----------------------------------------\n");
            System.out.println("\n\n   Até o próximo treinamento ninja!\n\n");
            System.out.println("\n----------------------------------------\n");  
        }
        input.close();
    }
}
