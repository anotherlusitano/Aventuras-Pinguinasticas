/**
 * Esta e a classe que implementa toda a logica do Mapa.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Mapa#mapa} - e a area do nosso mapa <br>
 * {@link Mapa#barco} - e o {@link Barco} que vai estar dentro do mapa <br>
 * {@link Mapa#ilhas} - e as {@link Ilha} que vao estar dentro do mapa
*/
public class Mapa {
    /** Um mapa 10 por 10 em que int[pos_x][pos_y] */
    private int[][] mapa = new int[10][10];

    /** E o {@link Barco} que vai estar dentro do {@link Mapa#mapa} */
    private Barco barco;

    /** Sao as {@link Ilha} que vao ser geradas dentro do {@link Mapa#mapa} */
    private Ilha[] ilhas;

    public Mapa(Barco barco, Ilha[] ilhas) {
        this.barco = barco;
        this.ilhas = ilhas;
    }

    public int[][] getMapa() {
        return mapa;
    }

    public void setMapa(int[][] mapa) {
        this.mapa = mapa;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    public Ilha[] getIlhas() {
        return ilhas;
    }

    public void setIlhas(Ilha[] ilhas) {
        this.ilhas = ilhas;
    }
}