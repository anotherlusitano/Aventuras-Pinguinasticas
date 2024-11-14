/**
 * Esta e a classe que implementa toda a logica do Jogo.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Jogo#jogador} - e o {@link Jogador} <br>
 * {@link Jogo#mapa} - e o {@link Mapa}
 */
public class Jogo {
    private Jogador jogador;

    private Mapa mapa;

    public Jogo(Jogador jogador, Mapa mapa) {
        this.jogador = jogador;
        this.mapa = mapa;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    /// Esta e a funcao que vai iniciar o Jogo
    public void iniciar() {
        System.out.println("Epic gamer move");
    }
}
