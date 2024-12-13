/**
 * Esta classe abstrata serve para criar um modelo para a classe {@link Opcao}.
 */
public abstract class OpcaoAbstrata {
    private String texto;
    private Recursos custo;
    private Recursos ganho;

    public abstract String toString();
}
