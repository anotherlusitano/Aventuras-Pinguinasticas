/**
 * Esta e a classe que implementa toda a logica do Barco.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Barco#coordenadas} - e as {@link Coordenada}s do Barco <br>
 * {@link Barco#recursos} - e os {@link Recursos} do Barco
 */
public class Barco extends Jogador {
    /** E as {@link Coordenada} do {@link Barco} */
    private Coordenada coordenadas;

    /**
     * O Barco tem os seguintes recursos: <br>
     * - {@link Recursos#energia} <br>
     * - {@link Recursos#peixe} <br>
     * - {@link Recursos#morale} <br>
     * - {@link Recursos#vida_da_tripulacao} <br>
     */
    private Recursos recursos;

    /**
     * Vai construir o objeto Barco
     *
     * @param recursos sao os {@link Recursos} do Barco
     *
     * O resto dos parametros servem para construir o {@link Jogador}
     * @return o objeto {@link Barco}
     */
    public Barco(String nome, int pontuacao, Missao missaoAtual, Recursos recursos) {
        super(nome, pontuacao, missaoAtual);
        this.coordenadas = new Coordenada(0,0);
        this.recursos = recursos;
    }

    public Recursos getRecursos() {
        return recursos;
    }

    public void setRecursos(Recursos recursos) {
        this.recursos = recursos;
    }

    public Coordenada getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenada coordenadas) {
        this.coordenadas = coordenadas;
    }

    /// Se algum dos {@link Recursos} estiver a zero ou menos, vai retornar falso
    public boolean temRecursos() {
        Recursos recursos = this.getRecursos();

        if (recursos.getEnergia() <= 0) {
            return false;
        } else if (recursos.getPeixe() <= 0) {
            return false;
        } else if (recursos.getMorale() <= 0) {
            return false;
        } else if (recursos.getVida_da_tripulacao() <= 0) {
            return false;
        } else {
            return true;
        }
    }
}
