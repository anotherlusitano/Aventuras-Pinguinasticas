/**
 * Esta classe abstrata serve para criar um modelo para a classe {@link Coordenada}.
 */
public abstract class CoordenadaAbstrata {
    private int x;
    private int y;

    public abstract boolean equals(Object o);
    public abstract  int hashCode();

    public abstract String toString();
}
