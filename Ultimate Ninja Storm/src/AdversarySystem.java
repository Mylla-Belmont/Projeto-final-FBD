import java.util.Random;

public class AdversarySystem{
    private void attack(Characters adversary, Characters player, Random random){
        int attackadversary = random.nextInt(4);
        if(attackadversary >= 0 && attackadversary <= 2){
            player.takeDamage(adversary.attack(attackadversary, adversary.nome));
            System.out.println(adversary.nome + " atacou com um " + adversary.getNameAttack(attackadversary, adversary.nome));
        }else
            System.out.println(adversary.nome + " errou o golpe!");
    }

    private void makeSpecial(Characters player, Characters adversary){
        if(adversary.activateSpecial()){
            player.takeDamage(adversary.getSpecial(adversary.nome));
            System.out.println(adversary.nome + " usou um Jutsu avançado!"); 
        }else
            System.out.println(adversary.nome + ": - Onde está sua determinação, idiota?!");
    }

    private void recoverLife(Characters adversary, Characters player){
        if(adversary.recoverLife()){
            System.out.println(adversary.nome + " recuperou vida!");
        }else
            System.out.println(player.nome + ", essa vitória é sua!");
    }

    private void recoverChakra(Characters adversary){
        if(adversary.recoverChakra()){         
            System.out.println(adversary.nome + " recuperou chakra!");
        }else 
            System.out.println("Seu oponente é muito forte, mas ele não é pareo pra você!");
    }
    
    public void commands(Characters player, Characters adversary){
        Random random = new Random();
        int movimentoadversary = random.nextInt(5);

        if(movimentoadversary == 0){
            recoverChakra(adversary);
        }else if(movimentoadversary == 1){
            recoverLife(adversary, player);
        }else if(movimentoadversary == 2){
            makeSpecial(player, adversary);
        }else{
            attack(adversary, player, random);
        }
    }
}

