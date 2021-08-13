import java.io.IOException;

public class Aparencia {
    public void limparTela() throws InterruptedException, IOException{
        if (System.getProperty("os.name").contains("Windows")){ 
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
        }else 
            Runtime.getRuntime().exec("clear"); 
    }
}
