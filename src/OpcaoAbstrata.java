/**
 * Esta classe abstrata serve para criar um modelo para a classe {@link Opcao}.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Opcao#texto} - e o texto que a {@link Opcao} vai ter<br>
 * {@link Opcao#custo} - e os {@link Recursos} que o {@link Barco} vai perder ao fazer a {@link Missao}<br>
 * {@link Opcao#ganho} - e os {@link Recursos} que o {@link Barco} vai receber ao fazer a {@link Missao}
 */
public abstract class OpcaoAbstrata {
    /** E o nome que a {@link Opcao} vai ter*/
    private String texto;

    /** E os {@link Recursos} que o {@link Barco} vai perder ao aceitar a missao*/
    private Recursos custo;

    /** E os {@link Recursos} que o {@link Barco} vai receber ao aceitar a missao*/
    private Recursos ganho;

    public OpcaoAbstrata(String texto, Recursos custo, Recursos ganho) {
        this.texto = texto;
        this.custo = custo;
        this.ganho = ganho;
    }

    public Recursos getCusto() {
        return custo;
    }

    public void setCusto(Recursos custo) {
        this.custo = custo;
    }

    public Recursos getGanho() {
        return ganho;
    }

    public void setGanho(Recursos ganho) {
        this.ganho = ganho;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public abstract String toString();
}
