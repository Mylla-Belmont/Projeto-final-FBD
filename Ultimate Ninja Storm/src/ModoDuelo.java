import java.util.Random;
import java.util.Scanner;

public class ModoDuelo{

    private Personagens escolherAleatorio(){
        Random random = new Random();
        int aleatorio = random.nextInt(3);     //Pesquisar como saber tamanho do banco
        AcessoBanco banco = new AcessoBanco();
        Personagens personagem = banco.getPersonagem(aleatorio);  
        return personagem;
    }

    private Personagens escolherPersonagem(Scanner input, String tipo){
        AcessoBanco banco = new AcessoBanco();
        banco.listPersonagens();
        System.out.println("\nYo! Escolha seu " + tipo + "...\n");
        String entrada = input.nextLine();
        Personagens personagem = banco.getPersonagem(Integer.parseInt(entrada));
        return personagem;
    }
    
    public void menuDuelo() throws Exception {
        Aparencia aparencia = new Aparencia();
        aparencia.limparTela();
        Personagens jogador = new Personagens(null, 0, 0, 0, 0);                        
        Personagens adversario = new Personagens(null, 0, 0, 0, 0);      
        
        while(true){
            System.out.println("\nNARUTO ULTIMATE NINJA STORM!");
            System.out.println("\nDuelo...\n");
            System.out.println("1 - Escolher personagens");
            System.out.println("2 - Aleatorio");
            System.out.println("3 - Menu principal\n");

            Scanner input = new Scanner(System.in);
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
                aparencia.limparTela();

            }else if(entrada.equals("3")){
                Menu.main(null);
            }else{
                aparencia.limparTela();
                continue;
            }
        Batalha batalha = new Batalha();           
        batalha.lutar(jogador, adversario);
        input.close();
        }
    }
}
