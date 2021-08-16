import java.util.Random;
import java.util.Scanner;

public class DuelMode{

    private Characters ChooseRandom(){
        Random random = new Random();
        int aleatory = random.nextInt(3);     //Pesquisar como saber tamanho do banco
        AcessoBanco banco = new AcessoBanco();
        Characters personagem = banco.getCharacters(aleatory);  
        return personagem;
    }

    private Characters ChooseCharacter(Scanner input, String tipo){
        AcessoBanco banco = new AcessoBanco();
        banco.listCharacters();
        System.out.println("\nYo! Escolha seu " + tipo + "...\n");
        String line = input.nextLine();
        Characters personagem = banco.getCharacters(Integer.parseInt(line));
        return personagem;
    }
    
    public void menuDuelo() throws Exception {
        Appearance appearance = new Appearance();
        appearance.CleanScreen();
        Characters player = new Characters(null, 0, 0, 0, 0);                        
        Characters adversary = new Characters(null, 0, 0, 0, 0);      
        
        while(true){
            System.out.println("\nNARUTO ULTIMATE NINJA STORM!");
            System.out.println("\nDuelo...\n");
            System.out.println("1 - Escolher Characters");
            System.out.println("2 - aleatory");
            System.out.println("3 - Menu principal\n");

            Scanner input = new Scanner(System.in);
            String line = input.nextLine();                       

            if(line.equals("1")){
                appearance.CleanScreen();
                player = ChooseCharacter(input, "player");
                appearance.CleanScreen();
                adversary = ChooseCharacter(input, "adversary");
                appearance.CleanScreen();

            }else if(line.equals("2")){
                appearance.CleanScreen();
                player = ChooseRandom();    
                adversary = ChooseRandom();
                appearance.CleanScreen();

            }else if(line.equals("3")){
                Menu.main(null);
            }else{
                appearance.CleanScreen();
                continue;
            }
        Battle Battle = new Battle();           
        Battle.fight(player, adversary);
        input.close();
        }
    }
}
