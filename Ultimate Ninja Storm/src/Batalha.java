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

    private void ExibirResultado(Personagens jogador, Personagens adversario){
        if(jogador.estaVivo() && !adversario.estaVivo()){
            System.out.println("VOCÊ GANHOU!");
            System.out.println("Hokage: -Parabéns" + jogador.nome + ", apesar de suas poucas habilidades, foi uma ótima luta.\n\n");
        }else if(adversario.estaVivo() && !jogador.estaVivo()){  
            System.out.println("VOCÊ PERDEU!"); 
            System.out.println("Hokage: -É " + jogador.nome + ", não foi dessa vez.\n\n");
        }else if(!jogador.estaVivo() && !adversario.estaVivo()){
            System.out.println("AMBOS PERDERAM!");
            System.out.println("Hokage: -Não consigo entender como...\n\n");
        }
    }

    private void Desistir(Personagens jogador) throws Exception{
        System.out.println(jogador.nome + " desistiu da luta!");
        System.out.println("\n--------------------------------\n");
        DuelMode voltaMenuDuelo = new DuelMode();
        voltaMenuDuelo.menuDuelo();
    }

    private void RecuperarChakra(Personagens jogador){
        if(jogador.recuperarChakra()){
            System.out.println("Yo! Você recuperou seu chakra!");
        }else
            System.out.println("Não foi possivel recuperar seu chakra...");
    }

    private void RecuperarVida(Personagens jogador){
        if(jogador.recuperarVida()){
            System.out.println("Yo! Você recuperou sua vida!");
        }else
            System.out.println("Não foi possivel recuperar sua vida...");
    }

    private void FazerEspecial(Personagens adversario, Personagens jogador, boolean aleatorio){
        if(adversario.diminuirAgilidade() && aleatorio){      
            System.out.println(adversario.nome + " desviou.");  
        }else if(jogador.ativarEspecial()){
            System.out.println("Você usuou o Jutsu avançado!");
            adversario.levarDano(jogador.getEspecial(jogador.nome));
        }else
            System.out.println("Não foi possivel usar a habilidade especial...");
    }

    private void Atacar(Personagens adversario, Personagens jogador, int ataque){
        if(adversario.diminuirAgilidade() == false){      
            System.out.println(adversario.nome + " desviou.");      
        }else{
            adversario.levarDano(jogador.ataque(ataque, jogador.nome));
            System.out.println("Yo! Você atacou com um " + jogador.getNomeAtaque(ataque, jogador.nome));       
            System.out.println(adversario.nome + " sofre dano!");     
        }
    }
    
    public void lutar(Personagens jogador, Personagens adversario) throws Exception{

        Scanner input = new Scanner(System.in);
        Random random = new Random();
        Boolean aleatorio = random.nextBoolean();
        Appearance appearance = new Appearance();

        while(jogador.estaVivo() && adversario.estaVivo()){
            System.out.println("1 - Atacar");
            System.out.println("2 - Fazer especial");
            System.out.println("3 - Recuperar Vida");
            System.out.println("4 - Recuperar Chakra");
            System.out.println("5 - Desistir"); 

            int ataque = random.nextInt(2);
            System.out.println("\n" + jogador.nome + ", escolha sua ação!");
            String entrada = input.nextLine();                       
            System.out.println("\n");

            if(entrada.equals("1")){      
                appearance.CleanScreen();
                Atacar(adversario, jogador, ataque); 
            }else 
            if(entrada.equals("2")){
                appearance.CleanScreen();
                FazerEspecial(adversario, jogador, aleatorio);   
            }else 
            if(entrada.equals("3")){
                appearance.CleanScreen();
                RecuperarVida(jogador);
            }else 
            if(entrada.equals("4")){
                appearance.CleanScreen();
                RecuperarChakra(jogador);
            }else 
            if(entrada.equals("5")){
                appearance.CleanScreen();
                Desistir(jogador);
            }else{
                appearance.CleanScreen();
                System.out.println("Erro: Comando inválido");
            }
            SistemaAdversario sistemaAdversario = new SistemaAdversario();
            sistemaAdversario.Comandos(jogador, adversario);
            System.out.println("\n" + jogador.toString());
            System.out.println(adversario.toString() + "\n");
        }
        ExibirResultado(jogador, adversario);
        sair(input);
        input.close();
    }
}
