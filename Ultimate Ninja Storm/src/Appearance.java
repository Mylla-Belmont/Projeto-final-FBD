import java.io.IOException;

public class Appearance {
    public void CleanScreen() throws InterruptedException, IOException{
        if (System.getProperty("os.name").contains("Windows")){ 
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
        }else 
            Runtime.getRuntime().exec("clear"); 
    }
}
