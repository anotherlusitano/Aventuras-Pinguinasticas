/**
 * Esta classe abstrata serve para criar um modelo para a classe {@link Recursos}.
 */
public abstract class RecursosAbstratos {
    private int energia;
    private int peixe;
    private int moral;
    private int vida_da_tripulacao;

    public abstract void subtrair(Recursos recursos_para_subtrair);
    public abstract void somar(Recursos recursos_para_somar);

    public abstract String toString();
}
