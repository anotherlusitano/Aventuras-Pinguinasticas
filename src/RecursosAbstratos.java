/**
 * Esta classe abstrata serve para criar um modelo para a classe {@link Recursos}.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Recursos#energia} - é a energia que o {@link Barco} precisa para andar <br>
 * {@link Recursos#peixe} - é a comida que a tripulação do {@link Barco} vai comer <br>
 * {@link Recursos#moral} - é a moral que a tripulação do {@link Barco} tem para continuar <br>
 * {@link Recursos#vida_da_tripulacao} - é a vida da tripulação do {@link Barco}
 */
public abstract class RecursosAbstratos {
    /** É a energia que faz o barco poder se mover */
    private int energia;

    /** É a comida que faz a tripulação ficar viva */
    private int peixe;

    /** É a moral da tripulação, faz que ela não te abandone */
    private int moral;

    /** É a vida da tripulação */
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
