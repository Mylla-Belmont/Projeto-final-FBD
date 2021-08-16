import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionPGSQL{

    Connection connection = null;

    public void connect(String strEnd, String strUsuario, String strSenha) {
        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection(strEnd, strUsuario, strSenha);
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar o driver");
            cnfe.printStackTrace();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Erro na query");
            sqlex.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException onConClose) {
            JOptionPane.showMessageDialog(null, "Erro ao desconnect o bank");
            onConClose.printStackTrace();
        }
    }

    public int update(String sql){
        try {
            Statement stmt = connection.createStatement(); 
            int res = stmt.executeUpdate(sql);
            connection.close();
            return res;
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ResultSet select(String sql){
        try {
            Statement stmt = connection.createStatement(); 
            ResultSet res = stmt.executeQuery(sql);
            connection.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}