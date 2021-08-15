public class Personagens {
    public String nome;
    private int vida;
    private int chakra;
    private int especial;
    private int agilidade;

    Personagens (String nome, int vida, int chakra, int especial, int agilidade){ 
        this.nome = nome;
        this.vida = vida;
        this.chakra = chakra;
        this.especial = especial;
        this.agilidade = agilidade;
    }

    public String getNomeAtaque(int ataque, String nome){
        AcessoBanco banco = new AcessoBanco();
        String nomeAtaque = banco.getNomeAtaque(ataque, nome);
        return nomeAtaque;
    } 

    public int getEspecial(String nome){
        AcessoBanco banco = new AcessoBanco();
        int forçaEspecial = banco.getEspecial(nome);
        return forçaEspecial;
    }

    private void verificarChakra(int diminuir){
        if(chakra-diminuir <= 0){
            chakra = 0;
        }else
            chakra -= diminuir;
    }

    public void levarDano(int levarDano){           
        vida -= levarDano;
    }

    public boolean estaVivo(){              
        if(vida > 0)
            return true;
        return false;
    }

    public boolean diminuirAgilidade(){       
        if(agilidade >= 5){
            agilidade -= 10;
            return true;
        }
        return false;
    }

    public boolean ativarEspecial(){         
        if(especial  == 10 && chakra >= 90){
            especial -= 10;
            verificarChakra(60);
            return true;
        }
        return false;
    }

    public boolean recuperarVida(){   
        if(chakra >= 10 && chakra <= 40 && vida <= 70){
            vida += 30;
            agilidade += 5;
            verificarChakra(20);
            return true;
        }else if(chakra >= 50 && chakra <= 70 && vida <= 80){
            vida += 20;
            agilidade += 10;
            verificarChakra(10);
            return true;
        }else if(chakra >= 80 && chakra < 100 && vida <= 90){
            vida += 10;
            agilidade += 20;
            verificarChakra(5);
            return true;
        }
        return false;
    }

    public boolean recuperarChakra(){    
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

    int ataque(int ataque, String nome){   
        AcessoBanco banco = new AcessoBanco();
        int força = banco.getAtaque(ataque, nome);
        
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