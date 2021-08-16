import java.util.Random;

public class AdversarySystem{

    private void atacar(Characters adversary, Characters player, Random random){
        int ataqueadversary = random.nextInt(3);
        if(ataqueadversary != 3){
            player.levarDano(adversary.ataque(ataqueadversary, adversary.nome));
            System.out.println(adversary.nome + " atacou com um " + adversary.getNameAttack(ataqueadversary, adversary.nome));
        }else
            System.out.println(adversary.nome + " errou o golpe!");
    }

    private void fazerEspecial(Characters player, Characters adversary){
        if(adversary.ativarEspecial()){
            player.levarDano(adversary.getSpecial(adversary.nome));
            System.out.println(adversary.nome + " usou um Jutsu avançado!"); 
        }else
            System.out.println(adversary.nome + ": - Onde está sua determinação, idiota?!");
    }

    private void recuperarVida(Characters adversary, Characters player){
        if(adversary.recuperarVida()){
            System.out.println(adversary.nome + " recuperou vida!");
        }else
            System.out.println(player.nome + ", essa vitória é sua!");
    }

    private void recuperarChakra(Characters adversary){
        if(adversary.recuperarChakra()){         
            System.out.println(adversary.nome + " recuperou chakra!");
        }else 
            System.out.println("Seu oponente é muito forte, mas ele não é pareo pra você!");
    }
    
    public void Comandos(Characters player, Characters adversary){
        Random random = new Random();
        int movimentoadversary = random.nextInt(6);

        if(movimentoadversary == 0){
            recuperarChakra(adversary);
        }else if(movimentoadversary == 1){
            recuperarVida(adversary, player);
        }else if(movimentoadversary == 2){
            fazerEspecial(player, adversary);
        }else{
            atacar(adversary, player, random);
        }
    }
}

