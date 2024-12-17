/**
 * Esta classe abstrata serve para criar um modelo para a classe {@link Recursos}.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Recursos#energia} - e a energia que o {@link Barco} precisa para andar <br>
 * {@link Recursos#peixe} - e a comida que os tripulantes do {@link Barco} vao comer <br>
 * {@link Recursos#moral} - e a moral que os tripulantes do {@link Barco} tem para continuar <br>
 * {@link Recursos#moral} - e a vida dos tripulantes do {@link Barco}
 */
public abstract class RecursosAbstratos {
    /** E a energia que faz os jogadores poderem se mover no barco */
    private int energia;

    /** E os suprimentos, aquilo que faz a tripulacao ficar viva */
    private int peixe;

    /** E a moral da tripulacao, faz que ela nao te abandone */
    private int moral;

    /** E a vida da tripulacao */
    private int vida_da_tripulacao;

    public RecursosAbstratos(int energia, int peixe, int moral, int vida_da_tripulacao) {
        this.energia = energia;
        this.peixe = peixe;
        this.moral = moral;
        this.vida_da_tripulacao = vida_da_tripulacao;
    }

    public int getPeixe() {
        return peixe;
    }

    public void setPeixe(int peixe) {
        this.peixe = peixe;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getMoral() {
        return moral;
    }

    public void setMoral(int moral) {
        this.moral = moral;
    }

    public int getVida_da_tripulacao() {
        return vida_da_tripulacao;
    }

    public void setVida_da_tripulacao(int vida_da_tripulacao) {
        this.vida_da_tripulacao = vida_da_tripulacao;
    }

    public abstract void subtrair(Recursos recursos_para_subtrair);
    public abstract void somar(Recursos recursos_para_somar);

    public abstract String toString();
}
