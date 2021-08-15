import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Batalha {

    private void sistemaAdversario(Personagens jogador, Personagens adversario){
        Random random = new Random();
        int movimentoAdversario = random.nextInt(6);

        switch (movimentoAdversario){
            case 0:
                if(adversario.recuperarChakra()){         
                    System.out.println(adversario.nome + " recuperou chakra!");
                }else{ 
                    System.out.println("Seu oponente é muito forte, mas ele não é pareo pra você!");
                }break;
            case 1:
                if(adversario.recuperarVida()){
                    System.out.println(adversario.nome + " recuperou vida!");
                }else{
                    System.out.println(jogador.nome + ", essa vitória é sua!");
                }break;
            case 2:
                if(adversario.ativarEspecial()){
                    jogador.levarDano(adversario.setEspecial(adversario.nome));
                    System.out.println(adversario.nome + " usou um jutsu avançado.");
                }else{
                    System.out.println(adversario.nome + ": - Onde está sua determinação, idiota?!");
                }break;

            default:
                int ataqueAdversario = random.nextInt(3);
                if(ataqueAdversario != 3){
                    jogador.levarDano(adversario.ataque(ataqueAdversario, adversario.nome));
                    System.out.println(adversario.nome + " atacou.");
                }else
                    System.out.println(adversario.nome + " errou o golpe!");

        }
    }
    
    public void lutar(Personagens jogador, Personagens adversario) throws InterruptedException, IOException{

        Scanner input = new Scanner(System.in);
        Random random = new Random();
        Boolean aleatorio = random.nextBoolean();
        Aparencia aparencia = new Aparencia();

        while(jogador.estaVivo() && adversario.estaVivo()){
            System.out.println("1 - Atacar");
            System.out.println("2 - Fazer especial");
            System.out.println("3 - Recuperar Vida");
            System.out.println("4 - Recuperar Chakra");
            System.out.println("5 - Desistir"); //Fazer isso tbm

            int ataque = random.nextInt(2);
            System.out.println("\n" + jogador.nome + ", escolha sua ação!");
            String entrada = input.nextLine();                       
            System.out.println("\n");

            if(entrada.equals("1")){      
                aparencia.limparTela();  
                if(adversario.diminuirAgilidade() == false){      
                    System.out.println(adversario.nome + " desviou.");      
                }else{
                    adversario.levarDano(jogador.ataque(ataque, jogador.nome));
                    System.out.println("Yo! Você atacou!");
                    System.out.println(adversario.nome + " sofre dano!");     // Tentar colocar nome do ataque
                }
            }else if(entrada.equals("2")){
                aparencia.limparTela();
                if(adversario.diminuirAgilidade() && aleatorio){      
                    System.out.println(adversario.nome + " desviou.");     
                }else 
                    if(jogador.ativarEspecial()){
                        System.out.println("Você usuou um Jutsu avançado!");
                        adversario.levarDano(jogador.setEspecial(jogador.nome));
                    }else
                        System.out.println("Não foi possivel usar a habilidade especial...");
                    
            }else if(entrada.equals("3")){
                aparencia.limparTela();
                if(jogador.recuperarVida()){
                    System.out.println("Yo! Você recuperou sua vida!");
                }else
                    System.out.println("Não foi possivel recuperar sua vida...");
                
            }else if(entrada.equals("4")){
                aparencia.limparTela();
                if(jogador.recuperarChakra()){
                    System.out.println("Yo! Você recuperou seu chakra!");
                }else
                    System.out.println("Não foi possivel recuperar seu chakra...");
    
            }else{
                aparencia.limparTela();
                System.out.println("Erro: Comando inválido");
            }
            sistemaAdversario(jogador, adversario);
            System.out.println("\n" + jogador.toString());
            System.out.println(adversario.toString() + "\n");
        }
        if(jogador.estaVivo() && !adversario.estaVivo()){
            System.out.println("\nVOCÊ GANHOU!");
            System.out.println("Hokage: -Parabéns" + jogador.nome + ", apesar de suas poucas habilidades, foi uma ótima luta.\n\n");
        }else if(adversario.estaVivo() && !jogador.estaVivo()){  
            System.out.println("\nVOCÊ PERDEU!"); 
            System.out.println("Hokage: -É " + jogador.nome + ", não foi dessa vez.\n\n");
        }else if(!jogador.estaVivo() && !adversario.estaVivo()){
            System.out.println("\nAMBOS PERDERAM!");
            System.out.println("Hokage: -Não consigo entender como...\n\n");
        }
        input.close();
    }
}
