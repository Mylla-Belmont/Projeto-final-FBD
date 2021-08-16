import java.util.Random;
import java.util.Scanner;

public class Battle{

    private void exit(Scanner input, String namePlayer){
        try{
            while(true){
                System.out.println("Aperte X para exit...");
                String res = input.nextLine();
                if(res.equals("x")){
                    DuelMode backDuelMenu = new DuelMode();
                    backDuelMenu.menuDuelo(namePlayer);
                }else
                    System.out.println("fail: Comando inválido");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void showResults(Characters player, Characters adversary, BankAccess bank, String namePlayer){
        int id = bank.getIdPlayer(namePlayer);
        if(player.estaVivo() && !adversary.estaVivo()){
            System.out.println("VOCÊ GANHOU!");
            System.out.println("Hokage: -Parabéns" + player.nome + ", apesar de suas poucas habilidades, foi uma ótima luta.\n\n");
            bank.addPlayerWin(id);
        }else if(adversary.estaVivo() && !player.estaVivo()){  
            System.out.println("VOCÊ PERDEU!"); 
            System.out.println("Hokage: -É " + player.nome + ", não foi dessa vez.\n\n");
            bank.addPlayerDefeat(id);
        }else if(!player.estaVivo() && !adversary.estaVivo()){
            System.out.println("AMBOS PERDERAM!");
            System.out.println("Hokage: -Não consigo entender como...\n\n");
            bank.addPlayerDefeat(id);
        }
    }

    private void desist(Characters player, String namePlayer){
        try{
            System.out.println(player.nome + " desistiu da luta!");
            System.out.println("\n--------------------------------\n");
            DuelMode backDuelMenu = new DuelMode();
            backDuelMenu.menuDuelo(namePlayer);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void recoverChakra(Characters player){
        if(player.recoverChakra()){
            System.out.println("Yo! Você recuperou seu chakra!");
        }else
            System.out.println("Não foi possivel recuperar seu chakra...");
    }

    private void recoverLife(Characters player){
        if(player.recoverLife()){
            System.out.println("Yo! Você recuperou sua vida!");
        }else
            System.out.println("Não foi possivel recuperar sua vida...");
    }

    private void makeSpecial(Characters adversary, Characters player, boolean aleatory){
        if(adversary.decreaseAgility() && aleatory){      
            System.out.println(adversary.nome + " desviou.");  
        }else if(player.activateSpecial()){
            System.out.println("Você usuou o Jutsu avançado!");
            adversary.takeDamage(player.getSpecial(player.nome));
        }else
            System.out.println("Não foi possivel usar a habilidade especial...");
    }

    private void attack(Characters adversary, Characters player, int attack){
        if(adversary.decreaseAgility() == false){      
            System.out.println(adversary.nome + " desviou.");      
        }else{
            adversary.takeDamage(player.attack(attack, player.nome));
            System.out.println("Yo! Você atacou com um " + player.getNameAttack(attack, player.nome));       
            System.out.println(adversary.nome + " sofre dano!");     
        }
    }
    
    public void fight(Characters player, Characters adversary, String namePlayer){
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        Boolean aleatory = random.nextBoolean();
        Appearance appearance = new Appearance();
        BankAccess bank = new BankAccess();

        while(player.estaVivo() && adversary.estaVivo()){
            System.out.println("1 - Atacar");
            System.out.println("2 - Fazer especial");
            System.out.println("3 - Recuperar Vida");
            System.out.println("4 - Recuperar Chakra");
            System.out.println("5 - Desistir"); 

            int attack = random.nextInt(2);
            System.out.println("\n" + player.nome + ", escolha sua ação!");
            String line = input.nextLine();                       
            System.out.println("\n");

            if(line.equals("1")){      
                appearance.CleanScreen();
                attack(adversary, player, attack); 

            }else if(line.equals("2")){
                appearance.CleanScreen();
                makeSpecial(adversary, player, aleatory);   

            }else if(line.equals("3")){
                appearance.CleanScreen();
                recoverLife(player);

            }else if(line.equals("4")){
                appearance.CleanScreen();
                recoverChakra(player);
                
            }else if(line.equals("5")){
                appearance.CleanScreen();
                desist(player, namePlayer);
            }else{
                appearance.CleanScreen();
                System.out.println("Erro: Comando inválido");
            }
            AdversarySystem AdversarySystem = new AdversarySystem();
            AdversarySystem.Comandos(player, adversary);
            System.out.println("\n" + player.toString());
            System.out.println(adversary.toString() + "\n");
        }
        showResults(player, adversary, bank, namePlayer);
        exit(input, namePlayer);
        input.close();
    }
}
