import java.io.IOException;
import java.util.Scanner;

public class Configuracoes{

    public void menuConfiguracoes() throws InterruptedException, IOException{
        Aparencia aparencia = new Aparencia();

        while(true){
            aparencia.limparTela();
            System.out.println("\nNARUTO ULTIMATE NINJA STORM!");
            System.out.println("\nConfigurações...\n");
            System.out.println("1 - Ver personagens");
            System.out.println("2 - Adicionar personagens");
            System.out.println("3 - Menu principal\n");

            Scanner input = new Scanner(System.in);
            String entrada = input.nextLine();  

            if(entrada.equals("1")){
                aparencia.limparTela();
            }else if(entrada.equals("2")){
                aparencia.limparTela();
            }else if(entrada.equals("3")){
                aparencia.limparTela();
            }else
                continue;
            input.close();
        }
    }    
}
