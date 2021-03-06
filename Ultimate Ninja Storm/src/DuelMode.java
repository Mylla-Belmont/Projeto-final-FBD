import java.util.Random;
import java.util.Scanner;

public class DuelMode{
    private Characters ChooseRandom(){
        Random random = new Random();
        BankAccess bank = new BankAccess();
        int size = bank.getNumCharacters();
        int aleatory = random.nextInt(size);
        if(aleatory == 0){
            aleatory++;
        }else{
            Characters personagem = bank.getCharacters(aleatory); 
            return personagem;
        } 
        return null;
    }

    private Characters ChooseCharacter(Scanner input, String tipo){
        BankAccess bank = new BankAccess();
        bank.listCharacters();
        System.out.println("\nYo! Escolha seu " + tipo + "...\n");
        String line = input.nextLine();
        Characters personagem = bank.getCharacters(Integer.parseInt(line));
        return personagem;
    }
    
    public void menuDuelo(String namePlayer){
        Appearance appearance = new Appearance();
        appearance.CleanScreen();
        Characters player = new Characters(null, 0, 0, 0, 0);                        
        Characters adversary = new Characters(null, 0, 0, 0, 0);      
        
        while(true){
            System.out.println("\nNARUTO ULTIMATE NINJA STORM!");
            System.out.println("\nDuelo...\n");
            System.out.println("1 - Escolher personagem");
            System.out.println("2 - Aleatorio");
            System.out.println("3 - Menu principal\n");

            Scanner input = new Scanner(System.in);
            String line = input.nextLine();                       

            if(line.equals("1")){
                appearance.CleanScreen();
                player = ChooseCharacter(input, "personagem");
                appearance.CleanScreen();
                adversary = ChooseCharacter(input, "adversario");
                appearance.CleanScreen();

            }else if(line.equals("2")){
                appearance.CleanScreen();
                player = ChooseRandom();    
                adversary = ChooseRandom();
                appearance.CleanScreen();

            }else if(line.equals("3")){
                Menu menu = new Menu();
                menu.menu(namePlayer);
            }else{
                appearance.CleanScreen();
                continue;
            }
        Battle Battle = new Battle();           
        Battle.fight(player, adversary, namePlayer);
        input.close();
        }
    }
}
