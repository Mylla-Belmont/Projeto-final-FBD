import java.sql.ResultSet;

public class AcessoBanco{
    
    private conexaoPGSQL conectar(){
        conexaoPGSQL banco = new conexaoPGSQL();
        banco.Conectar("jdbc:postgresql://localhost:5432/Projeto_Ninja", "postgres", "creepypasta");  
        return banco;
    }

    public int retornaEspecial(String nome){
        conexaoPGSQL banco = conectar();
        String sql = "select especial from ataques where nome = " + nome;
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

    public int retornarAtaque(int tipo, String nome){
        conexaoPGSQL banco = conectar();
        String sql = "select A.força from ataques A, personagens P where A.tipo =" + tipo + "and A.personagem = P.id and P.nome = "+ nome;
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

    public Personagens retornarPersonagem(int entrada){
        conexaoPGSQL banco = conectar();
        String sql = "select nome, vida, chakra, especial, agilidade from personagens where id = " + entrada;
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

    public void listarPersonagens(){
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
