import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        Aparencia aparencia = new Aparencia();

        while(true){
            aparencia.limparTela();
            System.out.println("\nNARUTO ULTIMATE NINJA STORM!");
            System.out.println("\nMenu Principal...\n");
            System.out.println("1 - Duelo");
            System.out.println("2 - Ranking");
            System.out.println("3 - Configurações");
            System.out.println("4 - Sair\n");

            String line = input.nextLine();                             
            System.out.println("\n");

            if(line.equals("1")){
                aparencia.limparTela();
                ModoDuelo duelo = new ModoDuelo();
                duelo.menuDuelo();
                
            }else if(line.equals("2")){
                aparencia.limparTela();
            
            }else if(line.equals("3")){
                aparencia.limparTela();
                Configuracoes configuracoes = new Configuracoes();
                configuracoes.menuConfiguracoes();
            
            }else if(line.equals("4")){
                aparencia.limparTela();
                System.out.println("\n----------------------------------------\n");
                System.out.println("\n\n   Até o próximo treinamento ninja!\n\n");
                System.out.println("\n----------------------------------------\n");  
                break;
            }else
                continue;
            input.close();
        }
    }
}

//Criar metodo para alterar tabela e inserir informações
//Mudar nome variaveis (pra ficar bonito kkk)
//Fazer opção novo jogo
//Fazer opção carregar jogo
//Reorganizar código
//Criar nova tabela para personagens novos
