import java.sql.ResultSet;

public class AcessoBanco{
    
    private conexaoPGSQL conectar(){
        conexaoPGSQL banco = new conexaoPGSQL();
        banco.Conectar("jdbc:postgresql://localhost:5432/Projeto_Ninja", "postgres", "creepypasta");  
        return banco;
    }

    public void getAllPersonagens(){
        conexaoPGSQL banco = conectar();
        String sql = "SELECT P.nome, P.agilidade, P.especial, A.nome from personagens P, ataques A where P.id = A.personagem";
        ResultSet resultado = banco.select(sql);
        try{
            while(resultado.next()){
                String nome = resultado.getString("nome");
                int agilidade = resultado.getInt("agilidade");
                int especial = resultado.getInt("especial");
                String ataque = resultado.getString("nome");
                System.out.println(nome + "\nAgilidade: " + agilidade + "\nEspecial: " + especial + "\nAtaques: "+ataque);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        banco.Desconectar();
    }

    public String getNomeAtaque(int tipo, String nomePersonagem){
        conexaoPGSQL banco = conectar();
        String sql = "select A.nome from ataques A, personagens P where A.tipo = '" + tipo + "' and A.personagem = P.id and P.nome = '" + nomePersonagem + "' ";
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
        String sql = "select A.força from ataques A, personagens P where A.tipo = '" + tipo + "' and A.personagem = P.id and P.nome = '" + nome + "' ";
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
