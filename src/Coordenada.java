import java.util.Objects;

/**
 * Esta e a classe que implementa toda a logica das Coordenadas. <br>
 * Uma Coordenada e a posicao X e Y dentro do {@link Mapa}.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Coordenada#x} - e a coordenada x no mapa. <br>
 * {@link Coordenada#y} - e a coordenada y no mapa.
 */
public class Coordenada {
    /** E a posicao X da {@link Ilha} dentro do {@link Mapa#mapa} */
    private int x;

    /** E a posicao Y da {@link Ilha} dentro do {@link Mapa#mapa} */
    private int y;

    public Coordenada(int x, int y) {
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

    @Override
    public String toString() {
        return "Coordenada x: '" + this.x + "', Coordenada y: '" + this.y + "'";
    }

    /**
     Fazemos um Override do metodo equals para poder usar o metodo `add` de um HashSet. <br>
     Ou seja, verificar se Coordenada(x,y) == OutraCoordenada(x,y)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordenada coordenadas = (Coordenada) o;
        return x == coordenadas.x && y == coordenadas.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
