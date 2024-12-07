import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta e a classe que implementa toda a logica do Jogador.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Jogador#nome} - e o nome do Jogador <br>
 * {@link Jogador#pontuacao} - e a pontuacao final do Jogador <br>
 */
public class Jogador {
    /** E o nome do Jogador */
    protected String nome;

    /** E a pontuacao do Jogador que vai ser armazenada em um ficheiro*/
    protected int pontuacao;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
    }

    /// Vai criar o ficheiro pontuacao com a seguinte formataçao:<br>
    /// nomeJogador;pontuacao <br>
    /// Vai ter o ponto e virgula a separar
    public void criarFicheiroPontuacao() {
        String nomeEpontuacao = this.nome + ";" + this.pontuacao;

        try {
            FileWriter fileWriter = new FileWriter("pontuacao.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(nomeEpontuacao);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Aconteceu um erro ao criar o ficheiro pontuacao.txt: " + e.getMessage());
        }
    }

    /**
     * Esta funçao vai ler e guardar todas as linhas do ficheiro.<br>
     * Depois vai alterar a pontuacao da ultima linha do ficheiro. <br>
     * E por fim, vai escrever tudo de volta no ficheiro
     */
    public void atualizarPontuacao() {
        List<String> linhas_do_ficheiro = new ArrayList<>();
        String ficheiro = "pontuacao.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(ficheiro));

            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas_do_ficheiro.add(linha);
            }
            reader.close();

            String ultima_linha = linhas_do_ficheiro.remove(linhas_do_ficheiro.size() - 1);
            String[] divisao = ultima_linha.split(";");

            ultima_linha = divisao[0] + ";" + this.pontuacao;
            linhas_do_ficheiro.add(ultima_linha);

            BufferedWriter writer = new BufferedWriter(new FileWriter(ficheiro, false));

            for (String updatedLine : linhas_do_ficheiro) {
                writer.write(updatedLine);
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Aconteceu um erro ao atualizar a pontuacao do ficheiro pontuacao.txt: " + e.getMessage());
        }
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

        atualizarPontuacao();
    }

    /// Vai imprimir o menu e retornar a escolha do {@link Jogador}
    public int escolherOqueFazer() {
        int opcao = 0;
        while (opcao < 1 || opcao > 5) {
            System.out.println("Escolha uma direcao");
            System.out.println("1 - andar para cima");
            System.out.println("2 - andar para baixo");
            System.out.println("3 - andar para a esquerda");
            System.out.println("4 - andar para a direita");
            System.out.println("5 - ver recursos atuais");
            opcao = Main.scanner.nextInt();
            System.out.println(opcao);
        }
        return opcao;
    }
}
