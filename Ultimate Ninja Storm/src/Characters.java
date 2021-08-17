public class Characters {
    public String nome;
    private int vida;
    private int chakra;
    private int especial;
    private int agilidade;

    Characters (String nome, int vida, int chakra, int especial, int agilidade){ 
        this.nome = nome;
        this.vida = vida;
        this.chakra = chakra;
        this.especial = especial;
        this.agilidade = agilidade;
    }

    public String getNameAttack(int attack, String nome){
        BankAccess bank = new BankAccess();
        String nomeattack = bank.getNameAttack(attack, nome);
        return nomeattack;
    } 

    public int getSpecial(String nome){
        BankAccess bank = new BankAccess();
        int forçaEspecial = bank.getSpecial(nome);
        return forçaEspecial;
    }

    private void verificarChakra(int diminuir){
        if(chakra-diminuir <= 0){
            chakra = 0;
        }else
            chakra -= diminuir;
    }

    public void takeDamage(int dano){     
        if(vida - dano <= 0){
            vida = 0;
        }else
            vida -= dano;
    }

    public boolean estaVivo(){              
        if(vida > 0)
            return true;
        return false;
    }

    public boolean decreaseAgility(){       
        if(agilidade <= 0){
            agilidade = 0;
            return false;
        }
        agilidade -= 10;
        return true;
    }

    public boolean activateSpecial(){         
        if(especial  >= 10 && chakra >= 60){
            especial -= 10;
            verificarChakra(60);
            return true;
        }
        return false;
    }

    public boolean recoverLife(){   
        if(chakra >= 10 && chakra <= 30 && vida <= 60){
            vida += 30;
            agilidade += 5;
            verificarChakra(20);
            return true;
        }else if(chakra >= 40 && chakra <= 60 && vida <= 70){
            vida += 20;
            agilidade += 10;
            verificarChakra(10);
            return true;
        }else if(chakra >= 70 && chakra < 100 && vida <= 80){
            vida += 10;
            agilidade += 20;
            verificarChakra(5);
            return true;
        }
        return false;
    }

    public boolean recoverChakra(){    
        if(vida >= 10 && vida <= 40 && chakra <= 70){
            chakra += 30;
            agilidade += 5;
            return true;
        }else if(vida >= 50 && vida <= 70 && chakra <= 80){
            chakra += 20;
            agilidade += 10;
            return true;
        }else if(vida >= 80 && vida < 100 && chakra <= 90){
            chakra += 10;
            agilidade += 20;
            return true;
        }
        return false;
    }

    int attack(int attack, String nome){   
        BankAccess bank = new BankAccess();
        int força = bank.getAttack(attack, nome);
        
        if(força == 10 && chakra >= 5){
            agilidade -= 5;
            verificarChakra(5);
            return força;
        }else if(força == 20 && chakra >= 10){
            agilidade -= 10;
            verificarChakra(10);
            return força;
        }else if(força == 30 && chakra >= 15){
            agilidade -= 20;
            verificarChakra(20);
            return força;
        }
        return 0;
    }

    public String toString(){  
        return nome + " - " + "Vida: " + vida + "/100" + " Chakra: " + chakra;
    }
}