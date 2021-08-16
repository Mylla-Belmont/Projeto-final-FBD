import java.util.Scanner;

public class Menu {
    
    public void menu(String namePlayer){
        Scanner input = new Scanner(System.in);
        Appearance appearance = new Appearance();
        
        while(true){
            appearance.CleanScreen();
            System.out.println("\nNARUTO ULTIMATE NINJA STORM!");
            System.out.println("\nMenu Principal...\n");
            System.out.println("1 - Duelo");
            System.out.println("2 - Ranking");
            System.out.println("3 - Configurações");
            System.out.println("4 - Sair\n");

            String line = input.nextLine();                             
            System.out.println("\n");

            if(line.equals("1")){
                appearance.CleanScreen();
                DuelMode duel = new DuelMode();
                try{
                    duel.menuDuelo(namePlayer);
                }catch(Exception e){
                    e.printStackTrace();
                }
                
            }else if(line.equals("2")){
                appearance.CleanScreen();
            
            }else if(line.equals("3")){
                appearance.CleanScreen();
                Settings settings = new Settings();
                try{
                    settings.SettingsMenu(namePlayer);
                }catch(Exception e){
                    e.printStackTrace();
                }
            
            }else if(line.equals("4")){
                appearance.CleanScreen();
                System.out.println("\n----------------------------------------\n");
                System.out.println("\n\n   Até o próximo treinamento ninja!\n\n");
                System.out.println("\n----------------------------------------\n");  
                break;
            }else
                continue;
        }
        input.close();
    }
}
