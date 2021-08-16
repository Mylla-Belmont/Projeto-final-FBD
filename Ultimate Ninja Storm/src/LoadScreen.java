import java.util.Scanner;

public class LoadScreen{

    private static void loadGame(Scanner input){
        BankAccess bank = new BankAccess();
        bank.getPlayers();
        System.out.println("\nQual o seu save?\n");
        String line = input.nextLine();
        //Carregar save
    }

    private static void newGame(Scanner input){
        System.out.println("Qual o seu nickname?");
        String nome = input.nextLine();
        BankAccess bank = new BankAccess();
        bank.addPlayer(nome);
        Menu menu = new Menu();
        try{
            menu.menu();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        Appearance appearance = new Appearance();

        appearance.CleanScreen();
        System.out.println("\nNARUTO ULTIMATE NINJA STORM!");
        System.out.println("\n1 - Novo jogo");
        System.out.println("2 - Carrregar jogo\n");

        String line = input.nextLine();                             
        System.out.println("\n");

        if(line.equals("1")){
            appearance.CleanScreen();
            newGame(input);
        
        }else if(line.equals("2")){
            appearance.CleanScreen();
            loadGame(input);
            //Carragar informações do jogo
        }
        
        input.close();
    }
}

//Criar metodo para alterar tabela e inserir informações
//Mudar nome variaveis (pra ficar bonito kkk)
//Fazer opção novo jogo
//Fazer opção carregar jogo
//Reorganizar código
//Criar nova tabela para Characters novos
//Mudar todos os throws para try catch
