import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class ModoHistoria {

    private void personagemAleatorio(String entrada, Scanner input){
        Random random = new Random();
        int aleatorio = random.nextInt(10); //Pesquisar como saber tamanho do banco
        AcessoBanco banco = new AcessoBanco();
        Personagens jogador = banco.retornarPersonagem(aleatorio);   
            System.out.println(jogador);
        //Passar jogador para batalha
        //Mandar para batalha
    }

    private void escolherPersonagem(String entrada, Scanner input){
        AcessoBanco banco = new AcessoBanco();
        banco.listarPersonagens();
            System.out.println("\nQual você escolhe?\n");
        entrada = input.nextLine();
        Personagens jogador = banco.retornarPersonagem(Integer.parseInt(entrada));
            System.out.println(jogador);
        //Passar jogador para batalha
        //Adicionar adversarios com while conectado a tabela
    }

    public void menuHistoria(Aparencia aparencia) throws InterruptedException, IOException {
        System.out.println("\nNARUTO ULTIMATE NINJA STORM!");
        System.out.println("\nModo história...\n");
        System.out.println("1 - Escolher personagem");
        System.out.println("2 - Personagem aleatorio");
        System.out.println("3 - Menu principal\n");

        Scanner input = new Scanner(System.in);
        String entrada = input.nextLine();                             

        if(entrada.equals("1")){
            aparencia.limparTela();
            escolherPersonagem(entrada, input);

        }else if(entrada.equals("2")){
            aparencia.limparTela();
            personagemAleatorio(entrada, input);
            
        }else if(entrada.equals("3")){
            //Voltar ao menu (Com problemas!) resolver dps
        }
        input.close();
    }
}
