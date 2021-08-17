import java.util.Scanner;

public class Ranking {
    private void exit(Scanner input, String namePlayer){
        try{
            while(true){
                System.out.println("Aperte X para sair...");
                String line = input.nextLine();
                if(line.equals("x")){
                    Menu menu = new Menu();
                    menu.menu(namePlayer);
                }else
                    System.out.println("fail: Comando inválido");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void system(String namePlayer){
        Scanner input = new Scanner(System.in);
        BankAccess bank = new BankAccess();
        bank.getRanking();
        exit(input, namePlayer);
    }    
}

//Melhorar ranking
