import java.sql.ResultSet;

public class AcessoBanco{
    
    private conexaoPGSQL conectar(){
        conexaoPGSQL banco = new conexaoPGSQL();
        banco.Conectar("jdbc:postgresql://localhost:5432/Projeto_Ninja", "postgres", "creepypasta");  
        return banco;
    }

    public void deleteAttacks(int id){
        conexaoPGSQL banco = conectar();
        String sql = "DELETE FROM ataques where personagem = " + id;
        int result= banco.update(sql);
        try{
            while(true){
                if(result> 0){
                    System.out.println("\nAtaques removidos com sucesso!");
                    banco.Desconectar();
                    break;
                }else
                    System.out.println("fail: Erro ao remover personagem...");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        banco.Desconectar();
    }

    public void deleteCharacters(int id){
        conexaoPGSQL banco = conectar();
        String sql = "DELETE FROM Characters where id = " + id;
        int result= banco.update(sql);
        try{
            while(true){
                if(result> 0){
                    System.out.println("\nPersonagem removido com sucesso!");
                    banco.Desconectar();
                    break;
                }else
                    System.out.println("fail: Erro ao remover personagem...");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        banco.Desconectar();
    }

    public void addAttack(int id, String ataque, int força, int tipo){
        conexaoPGSQL banco = conectar();
        String sql = "INSERT INTO ataques(personagem, nome, força, tipo) values(" + id + ", '" + ataque+ "'," + força + ", " + tipo + ")"; 
        int result= banco.update(sql);
        try{
            while(true){
                if(result> 0){
                    System.out.println("\nAtaque configurado!");
                    banco.Desconectar();
                    break;
                }else
                    System.out.println("fail: Erro ao adicionar ataques...");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        banco.Desconectar();
    }

    public void addCharacters(String nome, int agilidade, int especial){
        conexaoPGSQL banco = conectar();
        String sql = "INSERT INTO Characters(id ,nome, vida, chakra, agilidade, especial)" +
                     "VALUES(default,'"+nome+"',100,100, "+agilidade+", "+especial+")";
        int result= banco.update(sql);
        try{
            while(true){
                if(result> 0){
                    System.out.println("\n" + nome + " adicionado com sucesso!");
                    banco.Desconectar();
                    break;
                }else
                    System.out.println("fail: Erro ao adicionar personagem...");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        banco.Desconectar();
    }

    public void getAllCharacters(){
        conexaoPGSQL banco = conectar();
        String sql = "SELECT P.nome, P.agilidade, P.especial from Characters P";
        ResultSet result= banco.select(sql);
        try{
            while(result.next()){
                String nome = result.getString("nome");
                int agilidade = result.getInt("agilidade");
                int especial = result.getInt("especial");
                System.out.println(nome + "\nAgilidade: " + agilidade + "\nEspecial: " + especial + "\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        banco.Desconectar();
    }

    public String getNameAttack(int tipo, String nomePersonagem){
        conexaoPGSQL banco = conectar();
        String sql = "select A.nome from ataques A, Characters P where A.tipo = '" + tipo + 
                     "' and A.personagem = P.id and P.nome = '" + nomePersonagem + "' ";
        ResultSet result= banco.select(sql);
        try{
            String nomeAtaque = null;
            while(result.next()) {
                nomeAtaque = result.getString("nome");
            } 
            return nomeAtaque;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getSpecial(String nome){
        conexaoPGSQL banco = conectar();
        String sql = "select especial from Characters where nome = '" + nome + "' ";
        ResultSet result= banco.select(sql);
        try {
            int especial = 0;
            while(result.next()){
                especial = result.getInt("especial");
            } 
            return especial;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getAttack(int tipo, String nome){
        conexaoPGSQL banco = conectar();
        String sql = "select A.força from ataques A, Characters P where A.tipo = '" + tipo + 
                     "' and A.personagem = P.id and P.nome = '" + nome + "' ";
        ResultSet result= banco.select(sql);
        try{
            int ataque = 0;
            while(result.next()){
                ataque = result.getInt("força");
            }
            return ataque;
        }catch (Exception e){
            e.printStackTrace();
        }
        banco.Desconectar();
        return 0;
    }

    public int getIdCharacters(String nome){
        conexaoPGSQL banco = conectar();
        String sql = "SELECT id FROM Characters WHERE nome = '" + nome + "'";
        ResultSet result= banco.select(sql);
        try{
            while(result.next()) {
                int id = result.getInt("id");
                return id;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public Characters getCharacters(int line){
        conexaoPGSQL banco = conectar();
        String sql = "select nome, vida, chakra, especial, agilidade from Characters where id = '" + line + "' ";
        ResultSet result= banco.select(sql);
        try{
            String nome = null;
            int vida = 0;
            int chakra = 0;
            int especial = 0;
            int agilidade = 0;
                while(result.next()){
                    nome = result.getString("nome");
                    vida = result.getInt("vida");
                    chakra = result.getInt("chakra");
                    especial = result.getInt("especial");
                    agilidade = result.getInt("agilidade");
                }
            Characters player = new Characters(nome, vida, chakra, especial, agilidade);
            return player;
        }catch(Exception e){
            e.printStackTrace();
        }
        banco.Desconectar();
        return null;
    }

    public void listCharacters(){
        conexaoPGSQL banco = conectar();
        String sql = "select id, nome from Characters";
        ResultSet result= banco.select(sql);
        try{
            while(result.next()){
                int id = result.getInt("id");
                String nome = result.getString("nome");
                System.out.println(id+ " - "+ nome);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        banco.Desconectar();
    }
}
