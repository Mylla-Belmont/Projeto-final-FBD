import java.util.Scanner;

public class Settings{

    private void Exit(Scanner input) throws Exception{
        while(true){
            System.out.println("Aperte X para exit...");
            String line = input.nextLine();
            if(line.equals("x")){
                SettingsMenu();
            }else
                System.out.println("fail: Comando inválido");
        }
    }

    private void RemoveCharacter(Scanner input) throws Exception{
        BankAccess bank = new BankAccess();
        bank.listCharacters();
        System.out.println("Digite o número do personagem para remove-lo...");
        String line = input.nextLine();
        bank.deleteAttacks(Integer.parseInt(line));
        bank.deleteCharacters(Integer.parseInt(line));
        Exit(input);
    }

    private void AddCharacter(Scanner input) throws Exception{
        BankAccess bank = new BankAccess();
        System.out.println("Nome do personagem...");
            String nome = input.nextLine();
        System.out.println("\nTotal de agilidade do personagem...");
            String agilidade = input.nextLine();
        System.out.println("\nForça do especial...");
            String especial = input.nextLine();
        bank.addCharacters(nome, Integer.parseInt(agilidade), Integer.parseInt(especial));
        int id = bank.getIdCharacters(nome);
        System.out.println("\nNome do attack 1...");
            String attack1 = input.nextLine();
        bank.addAttack(id, attack1, 10, 0);
        System.out.println("\nNome do attack 2...");
            String attack2 = input.nextLine();
        bank.addAttack(id, attack2, 20, 1);
        System.out.println("\nNome do attack 3...");
            String attack3 = input.nextLine();
        bank.addAttack(id, attack3, 30, 2);
        Exit(input);
    }

    private void SeeCharacters(Scanner input) throws Exception{
        BankAccess bank = new BankAccess();
        bank.getAllCharacters();
        Exit(input);
    }

    public void SettingsMenu() throws Exception{
        Appearance appearance = new Appearance();
        Scanner input = new Scanner(System.in);

        while(true){
            appearance.CleanScreen();
            System.out.println("\nNARUTO ULTIMATE NINJA STORM!");
            System.out.println("\nConfigurações...\n");
            System.out.println("1 - Ver Characters");
            System.out.println("2 - Adicionar personagm");
            System.out.println("3 - Remover personagem");
            System.out.println("4 - Menu principal\n");

            String line = input.nextLine();  

            if(line.equals("1")){
                appearance.CleanScreen();
                SeeCharacters(input);
                
            }else if(line.equals("2")){
                appearance.CleanScreen();
                AddCharacter(input);

            }else if(line.equals("3")){
                appearance.CleanScreen();
                RemoveCharacter(input);

            }else if(line.equals("4")){
                appearance.CleanScreen();
                input.close();
                Menu.main(null);
                break;
            }else
                continue;
        }
        input.close();
    }    
}
