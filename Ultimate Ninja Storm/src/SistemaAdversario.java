import java.util.Random;

public class SistemaAdversario{

    private void atacar(Personagens adversario, Personagens jogador, Random random){
        int ataqueAdversario = random.nextInt(3);
        if(ataqueAdversario != 3){
            jogador.levarDano(adversario.ataque(ataqueAdversario, adversario.nome));
            System.out.println(adversario.nome + " atacou com um " + adversario.getNomeAtaque(ataqueAdversario, adversario.nome));
        }else
            System.out.println(adversario.nome + " errou o golpe!");
    }

    private void fazerEspecial(Personagens jogador, Personagens adversario){
        if(adversario.ativarEspecial()){
            jogador.levarDano(adversario.getEspecial(adversario.nome));
            System.out.println(adversario.nome + " usou um Jutsu avançado!"); 
        }else
            System.out.println(adversario.nome + ": - Onde está sua determinação, idiota?!");
    }

    private void recuperarVida(Personagens adversario, Personagens jogador){
        if(adversario.recuperarVida()){
            System.out.println(adversario.nome + " recuperou vida!");
        }else
            System.out.println(jogador.nome + ", essa vitória é sua!");
    }

    private void recuperarChakra(Personagens adversario){
        if(adversario.recuperarChakra()){         
            System.out.println(adversario.nome + " recuperou chakra!");
        }else 
            System.out.println("Seu oponente é muito forte, mas ele não é pareo pra você!");
    }
    
    public void Comandos(Personagens jogador, Personagens adversario){
        Random random = new Random();
        int movimentoAdversario = random.nextInt(6);

        if(movimentoAdversario == 0){
            recuperarChakra(adversario);
        }else if(movimentoAdversario == 1){
            recuperarVida(adversario, jogador);
        }else if(movimentoAdversario == 2){
            fazerEspecial(jogador, adversario);
        }else{
            atacar(adversario, jogador, random);
        }
    }
}

