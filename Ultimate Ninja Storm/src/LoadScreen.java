import java.util.Scanner;

public class LoadScreen{
    private static void exit(Scanner input){
        try{
            while(true){
                System.out.println("\nAperte X para sair...");
                String line = input.nextLine();
                if(line.equals("x")){
                    main(null);
                }else
                    System.out.println("fail: Comando inválido");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void loadGame(Scanner input, Appearance appearance){
        System.out.println("\nNARUTO ULTIMATE NINJA STORM!\n");
        BankAccess bank = new BankAccess();
        int result = bank.getPlayers();
        if(result > 0){
            System.out.println("\nQual o seu save?\n");
            String id = input.nextLine();
                try{
                    String namePlayer = bank.getNamePlayer(id);
                    Menu menu = new Menu();
                    menu.menu(namePlayer);
                }catch (Exception e) {
                    e.printStackTrace();
                }
        }else{
            appearance.CleanScreen();
            System.out.println("\nfail: Não há nenhum save");
            exit(input);
        }
    }

    private static void newGame(Scanner input){
        System.out.println("\nNARUTO ULTIMATE NINJA STORM!");
        System.out.println("\nQual o seu nickname?");
        String namePlayer = input.nextLine();
        BankAccess bank = new BankAccess();
        bank.addPlayer(namePlayer);
        Menu menu = new Menu();
        try{
            menu.menu(namePlayer);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Appearance appearance = new Appearance();

        while(true){
            appearance.CleanScreen();
            System.out.println("\nNARUTO ULTIMATE NINJA STORM!");
            System.out.println("\n1 - Novo jogo");
            System.out.println("2 - Carrregar jogo");
            System.out.println("3 - Fechar jogo");

            String line = input.nextLine();                             
            System.out.println("\n");

            if(line.equals("1")){
                appearance.CleanScreen();
                newGame(input);
            }else if(line.equals("2")){
                appearance.CleanScreen();
                loadGame(input, appearance);
            }else if(line.equals("3")){
                appearance.CleanScreen();
                System.out.println("\n---------------------------------------\n");
                System.out.println("    Até o próximo treinamento ninja! ");
                System.out.println("\n---------------------------------------\n");
                break;
            }else
                continue;
            input.close();
        }
    }
}

//Ajeitar alguns outputs
//Reorganizar código
//Ajeitar tabelas
//Organizar readme git
//Fazer slide sobre o projeto com url do repositório
//Criar arquivo com código das tabelas postgeeSQL