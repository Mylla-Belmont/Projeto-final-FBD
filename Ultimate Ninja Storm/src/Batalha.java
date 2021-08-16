import java.util.Random;
import java.util.Scanner;

public class Batalha{

    private void sair(Scanner input) throws Exception{
        while(true){
            System.out.println("Aperte X para sair...");
            String res = input.nextLine();
            if(res.equals("x")){
                DuelMode voltaMenuDuelo = new DuelMode();
                voltaMenuDuelo.menuDuelo();
            }else
                System.out.println("fail: Comando inválido");
        }
    }

    private void Exibirresult(Characters player, Characters adversary){
        if(player.estaVivo() && !adversary.estaVivo()){
            System.out.println("VOCÊ GANHOU!");
            System.out.println("Hokage: -Parabéns" + player.nome + ", apesar de suas poucas habilidades, foi uma ótima luta.\n\n");
        }else if(adversary.estaVivo() && !player.estaVivo()){  
            System.out.println("VOCÊ PERDEU!"); 
            System.out.println("Hokage: -É " + player.nome + ", não foi dessa vez.\n\n");
        }else if(!player.estaVivo() && !adversary.estaVivo()){
            System.out.println("AMBOS PERDERAM!");
            System.out.println("Hokage: -Não consigo entender como...\n\n");
        }
    }

    private void Desistir(Characters player) throws Exception{
        System.out.println(player.nome + " desistiu da luta!");
        System.out.println("\n--------------------------------\n");
        DuelMode voltaMenuDuelo = new DuelMode();
        voltaMenuDuelo.menuDuelo();
    }

    private void RecuperarChakra(Characters player){
        if(player.recuperarChakra()){
            System.out.println("Yo! Você recuperou seu chakra!");
        }else
            System.out.println("Não foi possivel recuperar seu chakra...");
    }

    private void RecuperarVida(Characters player){
        if(player.recuperarVida()){
            System.out.println("Yo! Você recuperou sua vida!");
        }else
            System.out.println("Não foi possivel recuperar sua vida...");
    }

    private void FazerEspecial(Characters adversary, Characters player, boolean aleatorio){
        if(adversary.diminuirAgilidade() && aleatorio){      
            System.out.println(adversary.nome + " desviou.");  
        }else if(player.ativarEspecial()){
            System.out.println("Você usuou o Jutsu avançado!");
            adversary.levarDano(player.getSpecial(player.nome));
        }else
            System.out.println("Não foi possivel usar a habilidade especial...");
    }

    private void Atacar(Characters adversary, Characters player, int ataque){
        if(adversary.diminuirAgilidade() == false){      
            System.out.println(adversary.nome + " desviou.");      
        }else{
            adversary.levarDano(player.ataque(ataque, player.nome));
            System.out.println("Yo! Você atacou com um " + player.getNameAttack(ataque, player.nome));       
            System.out.println(adversary.nome + " sofre dano!");     
        }
    }
    
    public void lutar(Characters player, Characters adversary) throws Exception{

        Scanner input = new Scanner(System.in);
        Random random = new Random();
        Boolean aleatorio = random.nextBoolean();
        Appearance appearance = new Appearance();

        while(player.estaVivo() && adversary.estaVivo()){
            System.out.println("1 - Atacar");
            System.out.println("2 - Fazer especial");
            System.out.println("3 - Recuperar Vida");
            System.out.println("4 - Recuperar Chakra");
            System.out.println("5 - Desistir"); 

            int ataque = random.nextInt(2);
            System.out.println("\n" + player.nome + ", escolha sua ação!");
            String line = input.nextLine();                       
            System.out.println("\n");

            if(line.equals("1")){      
                appearance.CleanScreen();
                Atacar(adversary, player, ataque); 
            }else 
            if(line.equals("2")){
                appearance.CleanScreen();
                FazerEspecial(adversary, player, aleatorio);   
            }else 
            if(line.equals("3")){
                appearance.CleanScreen();
                RecuperarVida(player);
            }else 
            if(line.equals("4")){
                appearance.CleanScreen();
                RecuperarChakra(player);
            }else 
            if(line.equals("5")){
                appearance.CleanScreen();
                Desistir(player);
            }else{
                appearance.CleanScreen();
                System.out.println("Erro: Comando inválido");
            }
            AdversarySystem AdversarySystem = new AdversarySystem();
            AdversarySystem.Comandos(player, adversary);
            System.out.println("\n" + player.toString());
            System.out.println(adversary.toString() + "\n");
        }
        Exibirresult(player, adversary);
        sair(input);
        input.close();
    }
}
