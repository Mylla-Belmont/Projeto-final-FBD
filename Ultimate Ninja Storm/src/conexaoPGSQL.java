import java.sql.*;
import javax.swing.JOptionPane;

public class conexaoPGSQL{

    Connection con = null;

    //Conecta ao banco Projeto_Ninja
    public void Conectar(String strEnd, String strUsuario, String strSenha) {
        String endereco = strEnd; 
        String usuario = strUsuario;
        String senha = strSenha;

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(endereco, usuario, senha);
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar o driver");
            cnfe.printStackTrace();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();
        }
    }

    //Desconecta do banco Projeto_Ninja
    public void Desconectar() {
        try {
            con.close();
        } catch (SQLException onConClose) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar o banco");
            onConClose.printStackTrace();
        }
    }

    //Inseri valores dentro do banco
    public void update(String sql){
        try {
            Statement stmt = con.createStatement(); 
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Retorna valores dentro do banco
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