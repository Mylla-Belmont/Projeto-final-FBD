import java.util.Scanner;

public class Configuracoes{

    private void verPersonagem(){
        AcessoBanco banco = new AcessoBanco();
        banco.getAllPersonagens();
    }

    public void menuConfiguracoes() throws Exception{
        Aparencia aparencia = new Aparencia();
        Scanner input = new Scanner(System.in);

        while(true){
            aparencia.limparTela();
            System.out.println("\nNARUTO ULTIMATE NINJA STORM!");
            System.out.println("\nConfigurações...\n");
            System.out.println("1 - Ver personagens");
            System.out.println("2 - Adicionar personagens");
            System.out.println("3 - Menu principal\n");

            String entrada = input.nextLine();  

            if(entrada.equals("1")){
                aparencia.limparTela();
                verPersonagem();

            }else if(entrada.equals("2")){
                aparencia.limparTela();
            }else if(entrada.equals("3")){
                aparencia.limparTela();
                Menu.main(null);
            }else
                continue;
            input.close();
        }
    }    
}
