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

    private void removerPersonagem(Scanner input) throws Exception{
        AcessoBanco banco = new AcessoBanco();
        banco.listPersonagens();
        System.out.println("Digite o número do personagem para remove-lo...");
        String entrada = input.nextLine();
        banco.deletePersonagem(Integer.parseInt(entrada));
        sair(input);
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
        int id = banco.getIdPersonagem(nome);
        System.out.println("Nome do ataque 1...");
            String ataque1 = input.nextLine();
        banco.addAtaques(id, ataque1, 10, 0);
        System.out.println("\nNome do ataque 2...");
            String ataque2 = input.nextLine();
        banco.addAtaques(id, ataque2, 20, 1);
        System.out.println("\nNome do ataque 3...");
            String ataque3 = input.nextLine();
        banco.addAtaques(id, ataque3, 30, 2);
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
            System.out.println("3 - Remover personagem");
            System.out.println("4 - Menu principal\n");

            String entrada = input.nextLine();  

            if(entrada.equals("1")){
                aparencia.limparTela();
                verPersonagem(input);
                
            }else if(entrada.equals("2")){
                aparencia.limparTela();
                adicionarPersonagem(input);

            }else if(entrada.equals("3")){
                aparencia.limparTela();
                removerPersonagem(input);

            }else if(entrada.equals("4")){
                aparencia.limparTela();
                input.close();
                Menu.main(null);
            }else
                continue;
            input.close();
        }
    }    
}
