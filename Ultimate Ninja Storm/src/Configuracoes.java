import java.util.Scanner;

public class Configuracoes{

    private void sair(Scanner input) throws Exception{
        while(true){
            System.out.println("Aperte X para sair...");
            String entrada = input.nextLine();
            if(entrada.equals("x")){
                menuConfiguracoes();
            }else
                System.out.println("fail: Comando inválido");
        }
    }

    private void adicionarPersonagem(Scanner input) throws Exception{
        AcessoBanco banco = new AcessoBanco();
        System.out.println("Nome do personagem...");
            String nome = input.nextLine();
        System.out.println("\nTotal de agilidade do personagem...");
            String agilidade = input.nextLine();
        System.out.println("\nForça do especial...");
            String especial = input.nextLine();
        banco.addPersonagem(nome, Integer.parseInt(agilidade), Integer.parseInt(especial));
        sair(input);
    }

    private void verPersonagem(Scanner input) throws Exception{
        AcessoBanco banco = new AcessoBanco();
        banco.getAllPersonagens();
        sair(input);
    }

    public void menuConfiguracoes() throws Exception{
        Aparencia aparencia = new Aparencia();
        Scanner input = new Scanner(System.in);

        while(true){
            aparencia.limparTela();
            System.out.println("\nNARUTO ULTIMATE NINJA STORM!");
            System.out.println("\nConfigurações...\n");
            System.out.println("1 - Ver personagens");
            System.out.println("2 - Adicionar personagm");
            System.out.println("3 - Menu principal\n");

            String entrada = input.nextLine();  

            if(entrada.equals("1")){
                aparencia.limparTela();
                verPersonagem(input);
                
            }else if(entrada.equals("2")){
                aparencia.limparTela();
                adicionarPersonagem(input);

            }else if(entrada.equals("3")){
                aparencia.limparTela();
                Menu.main(null);
            }else
                continue;
            input.close();
        }
    }    
}
