import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionPGSQL{

    Connection con = null;

    //Conecta ao bank Projeto_Ninja
    public void Conectar(String strEnd, String strUsuario, String strSenha) {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(strEnd, strUsuario, strSenha);
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar o driver");
            cnfe.printStackTrace();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();
        }
    }

    //Desconecta do bank Projeto_Ninja
    public void Desconectar() {
        try {
            con.close();
        } catch (SQLException onConClose) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar o bank");
            onConClose.printStackTrace();
        }
    }

    //Inseri valores dentro do bank
    public int update(String sql){
        try {
            Statement stmt = con.createStatement(); 
            int res = stmt.executeUpdate(sql);
            con.close();
            return res;
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //Retorna valores dentro do bank
    public ResultSet select(String sql){
        try {
            Statement stmt = con.createStatement(); 
            ResultSet res = stmt.executeQuery(sql);
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}