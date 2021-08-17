import java.sql.ResultSet;

public class BankAccess{
    
    private ConnectionPGSQL connect(){
        ConnectionPGSQL bank = new ConnectionPGSQL();
        bank.connect("jdbc:postgresql://localhost:5432/Projeto_Ninja", "postgres", "creepypasta");  
        return bank;
    }

    public void deleteAttacks(int id){
        ConnectionPGSQL bank = connect();
        String sql = "delete from ataques where personagem = " + id;
        int result= bank.update(sql);
        try{
            if(result> 0){
                bank.disconnect();
            }else
                System.out.println("fail: Erro ao remover personagem...");
        }catch(Exception e){
            e.printStackTrace();
        }bank.disconnect();
    }

    public void deleteCharacters(int id){
        ConnectionPGSQL bank = connect();
        String sql = "delete from personagens where id_personagem = " + id;
        int result= bank.update(sql);
        try{
            if(result> 0){
                bank.disconnect();
            }else
                System.out.println("fail: Erro ao remover personagem...");
        }catch(Exception e){
            e.printStackTrace();
        }bank.disconnect();
    }

    public void addPlayerDefeat(int id){
        ConnectionPGSQL bank = connect();
        String sql = "update jogador set derrotas = derrotas + 1 where id_jogador = " + id;
        int result= bank.update(sql);
        try{
            if(result> 0){
                bank.disconnect();
            }else
                System.out.println("fail: Erro ao adicionar derrota...");
        }catch(Exception e){
            e.printStackTrace();
        }bank.disconnect();
    }

    public void addPlayerWin(int id){
        ConnectionPGSQL bank = connect();
        String sql = "update jogador set vitorias = vitorias + 1 where id_jogador = " + id;
        int result= bank.update(sql);
        try{ 
            if(result> 0){
                bank.disconnect();
            }else
                System.out.println("fail: Erro ao adicionar vitória...");
        }catch (Exception e){
            e.printStackTrace();
        }bank.disconnect();
    }

    public void addPlayer(String nome){
        ConnectionPGSQL bank = connect();
        String sql = "insert into jogador(id_jogador, nickname, vitorias, derrotas) values (default, '" + nome + "', 0, 0)";
        int result= bank.update(sql);
        try{
            if(result> 0){
                bank.disconnect();
            }else{
                System.out.println("fail: Erro ao adicionar jogador...");
            }
        }catch (Exception e){
            e.printStackTrace();
        }bank.disconnect();
    }

    public void addAttack(int personagem, String attack, int força, int tipo){
        ConnectionPGSQL bank = connect();
        String sql = "insert into ataques(id_ataques, personagem, nome, força, tipo) values(default, " + personagem + ", '" + attack+ "'," + força + ", " + tipo + ")"; 
        int result= bank.update(sql);
        try{
            if(result> 0){
                bank.disconnect();
            }else{
                System.out.println("fail: Erro ao adicionar attacks...");
            }
        }catch(Exception e){
            e.printStackTrace();
        }bank.disconnect();
    }

    public void addCharacters(String nome, int agilidade, int especial){
        ConnectionPGSQL bank = connect();
        String sql = "insert into personagens(id_personagem ,nome, vida, chakra, agilidade, especial)" +
                     "values(default,'" + nome + "',100,100, " + agilidade + ", " + especial + ")";
        int result= bank.update(sql);
        try{
            if(result> 0){
                System.out.println("\n" + nome + " adicionado com sucesso!");
                bank.disconnect();
            }else
                System.out.println("fail: Erro ao adicionar personagem...");
        }catch(Exception e){
            e.printStackTrace();
        }bank.disconnect();
    }

    public String getNamePlayer(String id){
        ConnectionPGSQL bank = connect();
        String sql = "select nickname from jogador where id_jogador = " + Integer.parseInt(id);
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
        String sql = "select nickname, vitorias from jogador";
        ResultSet result = bank.select(sql);
        try{
            String nickname = null;
            int vitorias = 0;
            while(result.next()){
                nickname = result.getString("nickname");
                vitorias = result.getInt("vitorias");
                System.out.println("--------------------------------");
                System.out.println("\n" + nickname + " - " + vitorias + " vitórias\n");
            }System.out.println("--------------------------------");
            bank.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }bank.disconnect();
    }

    public int getIdPlayer(String name){
        ConnectionPGSQL bank = connect();
        String sql = "select id_jogador from jogador where nickname = '" + name + "'";
        ResultSet result = bank.select(sql);
        try{
            int id = 0;
            while(result.next()) {
                id = result.getInt("id_jogador");
            }bank.disconnect();
            return id;
        }catch (Exception e){
            e.printStackTrace();
        }bank.disconnect();
        return 0;
    }

    public int getPlayers(){
        ConnectionPGSQL bank = connect();
        String sql = "select id_jogador, nickname from jogador";
        ResultSet result = bank.select(sql);
        try{
            int id = 0;
            String nome = null;
            while(result.next()){
                id = result.getInt("id_jogador");
                nome = result.getString("nickname");
                System.out.println(id + " - " + nome);
            }if(nome.equals(null)){
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
        String sql = "select P.nome, P.agilidade, P.especial from personagens P";
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
                     "' and A.personagem = P.id_personagem and P.nome = '" + nomePersonagem + "' ";
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
                     "' and A.personagem = P.id_personagem and P.nome = '" + nome + "' ";
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
        String sql = "select id_personagem from personagens where nome = '" + nome + "'";
        ResultSet result= bank.select(sql);
        try{
            int id = 0;
            while(result.next()) {
                id = result.getInt("id_personagem");
            }bank.disconnect();
            return id;
        }catch(Exception e){
            e.printStackTrace();
        }bank.disconnect();
        return 0;
    }

    public Characters getCharacters(int id){
        ConnectionPGSQL bank = connect();
        String sql = "select nome, vida, chakra, especial, agilidade from personagens where id_personagem = '" + id + "' ";
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
        String sql = "select id_personagem, nome from personagens";
        ResultSet result= bank.select(sql);
        try{
            while(result.next()){
                int id = result.getInt("id_personagem");
                String nome = result.getString("nome");
                System.out.println(id+ " - "+ nome);
            }
        }catch(Exception e){
            e.printStackTrace();
        }bank.disconnect();
    }
}
