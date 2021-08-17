import java.sql.ResultSet;

public class BankAccess{
    
    private ConnectionPGSQL connect(){
        ConnectionPGSQL bank = new ConnectionPGSQL();
        bank.connect("jdbc:postgresql://localhost:5432/Projeto_Ninja", "postgres", "creepypasta");  
        return bank;
    }

    public void deleteAttacks(int id){
        ConnectionPGSQL bank = connect();
        String sql = "DELETE FROM ataques where personagem = " + id;
        int result= bank.update(sql);
        try{
            while(true){
                if(result> 0){
                    bank.disconnect();
                    break;
                }else
                    System.out.println("fail: Erro ao remover personagem...");
            }
        }catch(Exception e){
            e.printStackTrace();
        }bank.disconnect();
    }

    public void deleteCharacters(int id){
        ConnectionPGSQL bank = connect();
        String sql = "DELETE FROM personagens where id = " + id;
        int result= bank.update(sql);
        try{
            while(true){
                if(result> 0){
                    bank.disconnect();
                    break;
                }else
                    System.out.println("fail: Erro ao remover personagem...");
            }
        }catch(Exception e){
            e.printStackTrace();
        }bank.disconnect();
    }

    public void addPlayerDefeat(int id){
        ConnectionPGSQL bank = connect();
        String sql = "UPDATE jogador SET derrotas = derrotas + 1 where id = " + id;
        int result= bank.update(sql);
        try{
            while(true){
                if(result> 0){
                    bank.disconnect();
                    break;
                }else
                    System.out.println("fail: Erro ao adicionar derrota...");
            }
        }catch (Exception e){
            e.printStackTrace();
        }bank.disconnect();
    }

    public void addPlayerWin(int id){
        ConnectionPGSQL bank = connect();
        String sql = "UPDATE jogador SET vitorias = vitorias + 1 where id = " + id;
        int result= bank.update(sql);
        try{
            while(true){
                if(result> 0){
                    bank.disconnect();
                    break;
                }else
                    System.out.println("fail: Erro ao adicionar vitória...");
            }
        }catch (Exception e){
            e.printStackTrace();
        }bank.disconnect();
    }

    public void addPlayer(String nome){
        ConnectionPGSQL bank = connect();
        String sql = "insert into jogador (id, nickname, vitorias, derrotas) values (default, '" + nome + "', 0, 0)";
        int result= bank.update(sql);
        try{
            while(true){
                if(result> 0){
                    bank.disconnect();
                    break;
                }else
                    System.out.println("fail: Erro ao adicionar jogador...");
            }
        }catch (Exception e){
            e.printStackTrace();
        }bank.disconnect();
    }

    public void addAttack(int id, String attack, int força, int tipo){
        ConnectionPGSQL bank = connect();
        String sql = "INSERT INTO ataques(personagem, nome, força, tipo) values(" + id + ", '" + attack+ "'," + força + ", " + tipo + ")"; 
        int result= bank.update(sql);
        try{
            while(true){
                if(result> 0){
                    System.out.println("\nAtaque configurado!");
                    bank.disconnect();
                    break;
                }else
                    System.out.println("fail: Erro ao adicionar attacks...");
            }
        }catch(Exception e){
            e.printStackTrace();
        }bank.disconnect();
    }

    public void addCharacters(String nome, int agilidade, int especial){
        ConnectionPGSQL bank = connect();
        String sql = "INSERT INTO personagens(id ,nome, vida, chakra, agilidade, especial)" +
                     "VALUES(default,'"+nome+"',100,100, "+agilidade+", "+especial+")";
        int result= bank.update(sql);
        try{
            while(true){
                if(result> 0){
                    System.out.println("\n" + nome + " adicionado com sucesso!");
                    bank.disconnect();
                    break;
                }else
                    System.out.println("fail: Erro ao adicionar personagem...");
            }
        }catch(Exception e){
            e.printStackTrace();
        }bank.disconnect();
    }

    public String getNamePlayer(String id){
        ConnectionPGSQL bank = connect();
        String sql = "SELECT nickname from jogador where id = " + Integer.parseInt(id);
        ResultSet result = bank.select(sql);
        try{
            String namePlayer = null;
            while(result.next()){
                namePlayer = result.getString("nickname");
            }
            bank.disconnect();
            return namePlayer;
        }catch(Exception e){
            e.printStackTrace();
        }bank.disconnect();
        return null;
    }

    public void getRanking(){
        ConnectionPGSQL bank = connect();
        String sql = "SELECT nickname, vitorias from jogador";
        ResultSet result = bank.select(sql);
        try{
            String nickname = null;
            int vitorias = 0;
            while(result.next()){
                nickname = result.getString("nickname");
                vitorias = result.getInt("vitorias");
                System.out.println("--------------------------------");
                System.out.println("\n" + nickname + " - " + vitorias + " vitórias");
            }bank.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }bank.disconnect();
    }

    public int getIdPlayer(String name){
        ConnectionPGSQL bank = connect();
        String sql = "SELECT id from jogador where nickname = '" + name + "'";
        ResultSet result = bank.select(sql);
        try{
            int id = 0;
            while(result.next()) {
                id = result.getInt("id");
            }bank.disconnect();
            return id;
        }catch (Exception e){
            e.printStackTrace();
        }bank.disconnect();
        return 0;
    }

    public int getPlayers(){
        ConnectionPGSQL bank = connect();
        String sql = "SELECT id, nickname from jogador";
        ResultSet result = bank.select(sql);
        try{
            int id = 0;
            String nome = null;
            while(result.next()){
                id = result.getInt("id");
                nome = result.getString("nickname");
                System.out.println(id + " - " + nome);
            }
            if(nome.equals(null)){
                bank.disconnect();
                return 0;
            }else
                return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }bank.disconnect();
        return 0;
    }

    public void getAllCharacters(){
        ConnectionPGSQL bank = connect();
        String sql = "SELECT P.nome, P.agilidade, P.especial from personagens P";
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
        }bank.disconnect();
    }

    public String getNameAttack(int tipo, String nomePersonagem){
        ConnectionPGSQL bank = connect();
        String sql = "select A.nome from ataques A, personagens P where A.tipo = '" + tipo + 
                     "' and A.personagem = P.id and P.nome = '" + nomePersonagem + "' ";
        ResultSet result= bank.select(sql);
        try{
            String nomeattack = null;
            while(result.next()) {
                nomeattack = result.getString("nome");
            }return nomeattack;
        }catch(Exception e){
            e.printStackTrace();
        }return null;
    }

    public int getSpecial(String nome){
        ConnectionPGSQL bank = connect();
        String sql = "select especial from personagens where nome = '" + nome + "' ";
        ResultSet result= bank.select(sql);
        try{
            int especial = 0;
            while(result.next()){
                especial = result.getInt("especial");
            }bank.disconnect();
            return especial;
        }catch (Exception e) {
            e.printStackTrace();
        }bank.disconnect();
        return 0;
    }

    public int getAttack(int tipo, String nome){
        ConnectionPGSQL bank = connect();
        String sql = "select A.força from ataques A, personagens P where A.tipo = '" + tipo + 
                     "' and A.personagem = P.id and P.nome = '" + nome + "' ";
        ResultSet result= bank.select(sql);
        try{
            int attack = 0;
            while(result.next()){
                attack = result.getInt("força");
            }bank.disconnect();
            return attack;
        }catch (Exception e){
            e.printStackTrace();
        }bank.disconnect();
        return 0;
    }

    public int getIdCharacters(String nome){
        ConnectionPGSQL bank = connect();
        String sql = "SELECT id FROM personagens WHERE nome = '" + nome + "'";
        ResultSet result= bank.select(sql);
        try{
            int id = 0;
            while(result.next()) {
                id = result.getInt("id");
            }bank.disconnect();
            return id;
        }catch(Exception e){
            e.printStackTrace();
        }bank.disconnect();
        return 0;
    }

    public Characters getCharacters(int line){
        ConnectionPGSQL bank = connect();
        String sql = "select nome, vida, chakra, especial, agilidade from personagens where id = '" + line + "' ";
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
            bank.disconnect();
            return player;
        }catch(Exception e){
            e.printStackTrace();
        }bank.disconnect();
        return null;
    }

    public void listCharacters(){
        ConnectionPGSQL bank = connect();
        String sql = "select id, nome from personagens";
        ResultSet result= bank.select(sql);
        try{
            while(result.next()){
                int id = result.getInt("id");
                String nome = result.getString("nome");
                System.out.println(id+ " - "+ nome);
            }
        }catch(Exception e){
            e.printStackTrace();
        }bank.disconnect();
    }
}
