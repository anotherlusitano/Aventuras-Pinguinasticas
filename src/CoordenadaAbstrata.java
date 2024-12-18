/**
 * Esta classe abstrata serve para criar um modelo para a classe {@link Coordenada}.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Coordenada#x} - é a coordenada x no mapa. <br>
 * {@link Coordenada#y} - é a coordenada y no mapa.
 */
public abstract class CoordenadaAbstrata {
    /** É a posição X dentro do {@link Mapa#mapa} */
    private int x;

    /** É a posição Y dentro do {@link Mapa#mapa} */
    private int y;

    public CoordenadaAbstrata(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract boolean equals(Object o);
    public abstract  int hashCode();
}
