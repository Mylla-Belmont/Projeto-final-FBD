import java.util.Scanner;

public class Settings{

    private void Exit(Scanner input) throws Exception{
        while(true){
            System.out.println("Aperte X para sair...");
            String line = input.nextLine();
            if(line.equals("x")){
                SettingsMenu();
            }else
                System.out.println("fail: Comando inválido");
        }
    }

    private void RemoveCharacter(Scanner input) throws Exception{
        AcessoBanco banco = new AcessoBanco();
        banco.listCharacters();
        System.out.println("Digite o número do personagem para remove-lo...");
        String line = input.nextLine();
        banco.deleteAttacks(Integer.parseInt(line));
        banco.deleteCharacters(Integer.parseInt(line));
        Exit(input);
    }

    private void AddCharacter(Scanner input) throws Exception{
        AcessoBanco banco = new AcessoBanco();
        System.out.println("Nome do personagem...");
            String nome = input.nextLine();
        System.out.println("\nTotal de agilidade do personagem...");
            String agilidade = input.nextLine();
        System.out.println("\nForça do especial...");
            String especial = input.nextLine();
        banco.addCharacters(nome, Integer.parseInt(agilidade), Integer.parseInt(especial));
        int id = banco.getIdCharacters(nome);
        System.out.println("\nNome do ataque 1...");
            String ataque1 = input.nextLine();
        banco.addAttack(id, ataque1, 10, 0);
        System.out.println("\nNome do ataque 2...");
            String ataque2 = input.nextLine();
        banco.addAttack(id, ataque2, 20, 1);
        System.out.println("\nNome do ataque 3...");
            String ataque3 = input.nextLine();
        banco.addAttack(id, ataque3, 30, 2);
        Exit(input);
    }

    private void SeeCharacters(Scanner input) throws Exception{
        AcessoBanco banco = new AcessoBanco();
        banco.getAllCharacters();
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
