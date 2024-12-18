import java.util.Objects;

/**
 * Esta é a classe que implementa toda a lógica das Coordenadas. <br>
 * Uma Coordenada é a posição X e Y dentro do {@link Mapa}.
 */
public class Coordenada extends CoordenadaAbstrata{
    public Coordenada(int x, int y) {
        super(x, y);
    }

    /**
     Fazemos um Override do método equals para poder usar o método `add` de um HashSet. <br>
     Ou seja, verificar se Coordenada(x,y) == OutraCoordenada(x,y)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordenada coordenadas = (Coordenada) o;
        return getX() == coordenadas.getX() && getY() == coordenadas.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
