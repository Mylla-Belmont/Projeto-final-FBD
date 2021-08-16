import java.sql.ResultSet;

public class AcessoBanco{
    
    private conexaoPGSQL conectar(){
        conexaoPGSQL banco = new conexaoPGSQL();
        banco.Conectar("jdbc:postgresql://localhost:5432/Projeto_Ninja", "postgres", "creepypasta");  
        return banco;
    }

    public void deletePersonagem(int id){
        conexaoPGSQL banco = conectar();
        String sql = "DELETE FROM personagens where id = " + id;
        int resultado = banco.update(sql);
        try{
            while(true){
                if(resultado > 0){
                    System.out.println("\nPersonagem removido com sucesso!");
                    banco.Desconectar();
                    break;
                }else
                    System.out.println("fail: Erro ao remover personagem...");
            }
            banco.Desconectar();
        }catch(Exception e){
            e.printStackTrace();
        }
        banco.Desconectar();
    }

    public void addAtaques(int id, String ataque, int força, int tipo){
        conexaoPGSQL banco = conectar();
        String sql = "INSERT INTO ataques(personagem, nome, força, tipo) values(" + id + ", '" + ataque+ "'," + força + ", " + tipo + ")"; 
        int resultado = banco.update(sql);
        try{
            while(true){
                if(resultado > 0){
                    System.out.println("\nAtaques configurados!");
                    banco.Desconectar();
                    break;
                }else
                    System.out.println("fail: Erro ao adicionar personagem...");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        banco.Desconectar();
    }

    public void addPersonagem(String nome, int agilidade, int especial){
        conexaoPGSQL banco = conectar();
        String sql = "INSERT INTO personagens(id ,nome, vida, chakra, agilidade, especial)" +
                     "VALUES(default,'"+nome+"',100,100, "+agilidade+", "+especial+")";
        int resultado = banco.update(sql);
        try{
            while(true){
                if(resultado > 0){
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

    public void getAllPersonagens(){
        conexaoPGSQL banco = conectar();
        String sql = "SELECT P.nome, P.agilidade, P.especial from personagens P";
        ResultSet resultado = banco.select(sql);
        try{
            while(resultado.next()){
                String nome = resultado.getString("nome");
                int agilidade = resultado.getInt("agilidade");
                int especial = resultado.getInt("especial");
                System.out.println(nome + "\nAgilidade: " + agilidade + "\nEspecial: " + especial + "\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        banco.Desconectar();
    }

    public String getNomeAtaque(int tipo, String nomePersonagem){
        conexaoPGSQL banco = conectar();
        String sql = "select A.nome from ataques A, personagens P where A.tipo = '" + tipo + 
                     "' and A.personagem = P.id and P.nome = '" + nomePersonagem + "' ";
        ResultSet resultado = banco.select(sql);
        try{
            String nomeAtaque = null;
            while(resultado.next()) {
                nomeAtaque = resultado.getString("nome");
            } 
            return nomeAtaque;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getEspecial(String nome){
        conexaoPGSQL banco = conectar();
        String sql = "select especial from personagens where nome = '" + nome + "' ";
        ResultSet resultado = banco.select(sql);
        try {
            int especial = 0;
            while(resultado.next()){
                especial = resultado.getInt("especial");
            } 
            return especial;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getAtaque(int tipo, String nome){
        conexaoPGSQL banco = conectar();
        String sql = "select A.força from ataques A, personagens P where A.tipo = '" + tipo + 
                     "' and A.personagem = P.id and P.nome = '" + nome + "' ";
        ResultSet resultado = banco.select(sql);
        try{
            int ataque = 0;
            while(resultado.next()){
                ataque = resultado.getInt("força");
            }
            return ataque;
        }catch (Exception e){
            e.printStackTrace();
        }
        banco.Desconectar();
        return 0;
    }

    public int getIdPersonagem(String nome){
        conexaoPGSQL banco = conectar();
        String sql = "SELECT id FROM personagens WHERE nome = '" + nome + "'";
        ResultSet resultado = banco.select(sql);
        try{
            while(resultado.next()) {
                int id = resultado.getInt("id");
                return id;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public Personagens getPersonagem(int entrada){
        conexaoPGSQL banco = conectar();
        String sql = "select nome, vida, chakra, especial, agilidade from personagens where id = '" + entrada + "' ";
        ResultSet resultado = banco.select(sql);
        try{
            String nome = null;
            int vida = 0;
            int chakra = 0;
            int especial = 0;
            int agilidade = 0;
                while(resultado.next()){
                    nome = resultado.getString("nome");
                    vida = resultado.getInt("vida");
                    chakra = resultado.getInt("chakra");
                    especial = resultado.getInt("especial");
                    agilidade = resultado.getInt("agilidade");
                }
            Personagens jogador = new Personagens(nome, vida, chakra, especial, agilidade);
            return jogador;
        }catch(Exception e){
            e.printStackTrace();
        }
        banco.Desconectar();
        return null;
    }

    public void listPersonagens(){
        conexaoPGSQL banco = conectar();
        String sql = "select id, nome from personagens";
        ResultSet resultado = banco.select(sql);
        try{
            while(resultado.next()){
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                System.out.println(id+ " - "+ nome);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        banco.Desconectar();
    }
}
