import java.util.Scanner;

/**
 * Esta e a classe que implementa toda a logica do Jogador.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Jogador#nome} - e o nome do Jogador <br>
 * {@link Jogador#pontuacao} - e a pontuacao final do Jogador <br>
 * {@link Jogador#missao_atual} - e a {@link Missao} que o Jogador esta a fazer no momento
 */
public class Jogador {
    /** E o nome do Jogador */
    protected String nome;

    /** E a pontuacao do Jogador que vai ser armazenada em um ficheiro*/
    protected int pontuacao;

    /** E a {@link Missao} que o Jogador esta a fazer */
    protected Missao missao_atual;

    public Jogador(String nome, int pontuacao, Missao missaoAtual) {
        this.nome = nome;
        this.pontuacao = pontuacao;
        missao_atual = missaoAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Missao getMissao_atual() {
        return missao_atual;
    }

    public void setMissao_atual(Missao missao_atual) {
        this.missao_atual = missao_atual;
    }

    public int escolher_direcao() {
        Scanner input = new Scanner(System.in);
        int opcao = 0;

        while (opcao < 1 || opcao > 4) {
            System.out.println("Escolha uma direcao");
            System.out.println("1 - cima");
            System.out.println("2 - baixo");
            System.out.println("3 - esquerda");
            System.out.println("4 - direita");
            opcao = input.nextInt();
            System.out.println(opcao);
        }

        //input.close();
        return opcao;
    }
}