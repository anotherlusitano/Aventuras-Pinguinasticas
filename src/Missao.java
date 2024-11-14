/**
 * Esta e a classe que implementa toda a logica das Missoes.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Missao#nome} - e o nome da Missao <br>
 * {@link Missao#descricao} - e a descricao da Missao <br>
 * {@link Missao#custo} - e os {@link Recursos} que o {@link Barco} vai perder ao fazer a Missao<br>
 * {@link Missao#ganho} - e os {@link Recursos} que o {@link Barco} vai receber
 */
public class Missao {
    /** E o nome da Missao que vai aparecer ao {@link Jogador} */
    private String nome;

    /** E a descricao da Missao que vai aparecer ao {@link Jogador} */
    private String descricao;

    /** E os {@link Recursos} que o {@link Barco} vai perder ao aceitar a missao*/
    private Recursos custo;

    /** E os {@link Recursos} que o {@link Barco} vai receber ao aceitar a missao*/
    private Recursos ganho;

    public Missao(String nome, String descricao, Recursos custo, Recursos ganho) {
        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
        this.ganho = ganho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
}
