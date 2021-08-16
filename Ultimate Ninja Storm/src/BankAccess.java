import java.sql.ResultSet;

public class BankAccess{
    
    private ConnectionPGSQL conectar(){
        ConnectionPGSQL bank = new ConnectionPGSQL();
        bank.Conectar("jdbc:postgresql://localhost:5432/Projeto_Ninja", "postgres", "creepypasta");  
        return bank;
    }

    public void deleteAttacks(int id){
        ConnectionPGSQL bank = conectar();
        String sql = "DELETE FROM attacks where personagem = " + id;
        int result= bank.update(sql);
        try{
            while(true){
                if(result> 0){
                    System.out.println("\nattacks removidos com sucesso!");
                    bank.Desconectar();
                    break;
                }else
                    System.out.println("fail: Erro ao remover personagem...");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        bank.Desconectar();
    }

    public void deleteCharacters(int id){
        ConnectionPGSQL bank = conectar();
        String sql = "DELETE FROM Characters where id = " + id;
        int result= bank.update(sql);
        try{
            while(true){
                if(result> 0){
                    System.out.println("\nPersonagem removido com sucesso!");
                    bank.Desconectar();
                    break;
                }else
                    System.out.println("fail: Erro ao remover personagem...");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        bank.Desconectar();
    }

    public void addAttack(int id, String attack, int força, int tipo){
        ConnectionPGSQL bank = conectar();
        String sql = "INSERT INTO attacks(personagem, nome, força, tipo) values(" + id + ", '" + attack+ "'," + força + ", " + tipo + ")"; 
        int result= bank.update(sql);
        try{
            while(true){
                if(result> 0){
                    System.out.println("\nattack configurado!");
                    bank.Desconectar();
                    break;
                }else
                    System.out.println("fail: Erro ao adicionar attacks...");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        bank.Desconectar();
    }

    public void addCharacters(String nome, int agilidade, int especial){
        ConnectionPGSQL bank = conectar();
        String sql = "INSERT INTO Characters(id ,nome, vida, chakra, agilidade, especial)" +
                     "VALUES(default,'"+nome+"',100,100, "+agilidade+", "+especial+")";
        int result= bank.update(sql);
        try{
            while(true){
                if(result> 0){
                    System.out.println("\n" + nome + " adicionado com sucesso!");
                    bank.Desconectar();
                    break;
                }else
                    System.out.println("fail: Erro ao adicionar personagem...");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        bank.Desconectar();
    }

    public void getAllCharacters(){
        ConnectionPGSQL bank = conectar();
        String sql = "SELECT P.nome, P.agilidade, P.especial from Characters P";
        ResultSet result= bank.select(sql);
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
        bank.Desconectar();
    }

    public String getNameAttack(int tipo, String nomePersonagem){
        ConnectionPGSQL bank = conectar();
        String sql = "select A.nome from attacks A, Characters P where A.tipo = '" + tipo + 
                     "' and A.personagem = P.id and P.nome = '" + nomePersonagem + "' ";
        ResultSet result= bank.select(sql);
        try{
            String nomeattack = null;
            while(result.next()) {
                nomeattack = result.getString("nome");
            } 
            return nomeattack;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getSpecial(String nome){
        ConnectionPGSQL bank = conectar();
        String sql = "select especial from Characters where nome = '" + nome + "' ";
        ResultSet result= bank.select(sql);
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
        ConnectionPGSQL bank = conectar();
        String sql = "select A.força from attacks A, Characters P where A.tipo = '" + tipo + 
                     "' and A.personagem = P.id and P.nome = '" + nome + "' ";
        ResultSet result= bank.select(sql);
        try{
            int attack = 0;
            while(result.next()){
                attack = result.getInt("força");
            }
            return attack;
        }catch (Exception e){
            e.printStackTrace();
        }
        bank.Desconectar();
        return 0;
    }

    public int getIdCharacters(String nome){
        ConnectionPGSQL bank = conectar();
        String sql = "SELECT id FROM Characters WHERE nome = '" + nome + "'";
        ResultSet result= bank.select(sql);
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
        ConnectionPGSQL bank = conectar();
        String sql = "select nome, vida, chakra, especial, agilidade from Characters where id = '" + line + "' ";
        ResultSet result= bank.select(sql);
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
        bank.Desconectar();
        return null;
    }

    public void listCharacters(){
        ConnectionPGSQL bank = conectar();
        String sql = "select id, nome from Characters";
        ResultSet result= bank.select(sql);
        try{
            while(result.next()){
                int id = result.getInt("id");
                String nome = result.getString("nome");
                System.out.println(id+ " - "+ nome);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        bank.Desconectar();
    }
}
