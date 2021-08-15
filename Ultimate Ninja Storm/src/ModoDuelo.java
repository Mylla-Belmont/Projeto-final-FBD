import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class ModoDuelo{

    private Personagens escolherAleatorio(){
        Random random = new Random();
        int aleatorio = random.nextInt(3);     //Pesquisar como saber tamanho do banco
        AcessoBanco banco = new AcessoBanco();
        Personagens personagem = banco.retornarPersonagem(aleatorio);  
        return personagem;
    }

    private Personagens escolherPersonagem(Scanner input, String tipo){
        AcessoBanco banco = new AcessoBanco();
        banco.listarPersonagens();
            System.out.println("\nYo! Escolha seu " + tipo + "...\n");
            String entrada = input.nextLine();
            Personagens personagem = banco.retornarPersonagem(Integer.parseInt(entrada));
        return personagem;
    }
    
    public void menuDuelo(Aparencia aparencia, Scanner input) throws InterruptedException, IOException {

        Personagens jogador = new Personagens(null, 0, 0, 0, 0);                        
        Personagens adversario = new Personagens(null, 0, 0, 0, 0);      
        
        while(true){
            System.out.println("\nNARUTO ULTIMATE NINJA STORM!");
            System.out.println("\nDuelo...\n");
            System.out.println("1 - Escolher personagens");
            System.out.println("2 - Aleatorio");
            System.out.println("3 - Menu principal\n");

            String entrada = input.nextLine();                       

            if(entrada.equals("1")){
                aparencia.limparTela();
                    jogador = escolherPersonagem(input, "jogador");
                aparencia.limparTela();
                    adversario = escolherPersonagem(input, "adversario");
                aparencia.limparTela();

            }else if(entrada.equals("2")){
                aparencia.limparTela();
                    jogador = escolherAleatorio();    
                    adversario = escolherAleatorio();

            }else if(entrada.equals("3")){
                input.close();
                break;
            }
            Batalha batalha = new Batalha();           
            batalha.lutar(jogador, adversario);
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
