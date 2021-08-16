public class Appearance {
    public void CleanScreen(){
    
        try{
            if(System.getProperty("os.name").contains("Windows")){ 
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
            }else 
                Runtime.getRuntime().exec("clear"); 
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
