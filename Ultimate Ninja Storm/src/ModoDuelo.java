import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class ModoDuelo{

    private Personagens escolherAleatorio(Scanner input){
        Random random = new Random();
        int aleatorio = random.nextInt(10);     //Pesquisar como saber tamanho do banco
        AcessoBanco banco = new AcessoBanco();
        Personagens personagem = banco.retornarPersonagem(aleatorio);  
        return personagem;
    }

    private Personagens escolherPersonagem(Scanner input, String tipo){
        String entrada;
        AcessoBanco banco = new AcessoBanco();
        banco.listarPersonagens();
            System.out.println("\nYo! Escolha seu " + tipo + "...\n");
            entrada = input.nextLine();
            Personagens personagem = banco.retornarPersonagem(Integer.parseInt(entrada));
        return personagem;
    }
    
    public void menuDuelo(Aparencia aparencia) throws InterruptedException, IOException {
        System.out.println("\nNARUTO ULTIMATE NINJA STORM!");
        System.out.println("\nDuelo...\n");
        System.out.println("1 - Escolher personagens");
        System.out.println("2 - Aleatorio");
        System.out.println("3 - Menu principal\n");

        Scanner input = new Scanner(System.in);
        String entrada = input.nextLine();                             

        if(entrada.equals("1")){
            aparencia.limparTela();
            Personagens jogador = escolherPersonagem(input, "jogador");
            aparencia.limparTela();
            Personagens adversario = escolherPersonagem(input, "adversario");
            aparencia.limparTela();

            Batalha batalha = new Batalha();            //Finalizar batalha
            batalha.lutar(jogador, adversario);

        }else if(entrada.equals("2")){
            aparencia.limparTela();
            Personagens jogador = escolherAleatorio(input);     //Mandar pra batalha
            Personagens adversario = escolherAleatorio(input);

            Batalha batalha = new Batalha();            //Finalizar batalha
            batalha.lutar(jogador, adversario);
            
        }else if(entrada.equals("3")){
            //Voltar ao menu (Com problemas!) resolver dps
        }
        input.close();
    }
}
