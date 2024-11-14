/**
 * Esta e a classe que implementa toda a logica das Ilhas.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Ilha#nome} - e o nome da Ilha <br>
 * {@link Ilha#pos_x} - e a posicao X da Ilha no {@link Mapa#mapa} <br>
 * {@link Ilha#pos_y} - e a posicao Y da Ilha no {@link Mapa#mapa} <br>
 * {@link Ilha#dificuldadeDaIlha} - e o {@link dificuldade} da Ilha
 */
public class Ilha {
    /** E o nome da Ilha */
    private String nome;

    /** E a posicao X da {@link Ilha} dentro do {@link Mapa#mapa} */
    private int pos_x;

    /** E a posicao Y da {@link Ilha} dentro do {@link Mapa#mapa} */
    private int pos_y;

    /** E a {@link dificuldade} da {@link Ilha} */
    private dificuldade dificuldadeDaIlha;

    public Ilha(String nome, int posX, int posY, dificuldade dificuldadeDaIlha) {
        this.nome = nome;
        pos_x = posX;
        pos_y = posY;
        this.dificuldadeDaIlha = dificuldadeDaIlha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public dificuldade getDificuldadeDaIlha() {
        return dificuldadeDaIlha;
    }

    public void setDificuldadeDaIlha(dificuldade dificuldadeDaIlha) {
        this.dificuldadeDaIlha = dificuldadeDaIlha;
    }
}

/**
 * Serve para medir qual a dificuldade da ilha, por exemplo: <br>
 * uma ilha com dificuldade <i>FACIL</i> vai gastar menos recursos que uma ilha com dificuldade <i>DIFICIL</i>
 */
enum dificuldade{
    /// E uma {@link Ilha} de dificuldade dificil
    DIFICIL,
    /// E uma {@link Ilha} de dificuldade mediana
    MEDIO,
    /// E uma {@link Ilha} de dificuldade facil
    FACIL
}