import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        // Atualiza apenas a última linha do ficheiro
        File ficheiro = new File("pontuacao.txt");
        try {
            // Lê todas as linhas do ficheiro
            List<String> linhas = new ArrayList<>();
            Scanner reader = new Scanner(ficheiro);
            while (reader.hasNextLine()) {
                linhas.add(reader.nextLine());
            }
            reader.close();

            // Substitui a última linha pela nova pontuação
            if (!linhas.isEmpty()) {
                linhas.set(linhas.size() - 1, String.valueOf(pontuacao));
            } else {
                linhas.add(String.valueOf(pontuacao)); // Adiciona a pontuação se o ficheiro estava vazio
            }

            // Apaga o conteúdo do ficheiro e reescreve todas as linhas
            FileWriter writer = new FileWriter(ficheiro);
            for (String l : linhas) {
                writer.write(l + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Erro ao salvar a pontuação: " + e.getMessage());
        }
    }

    public int escolher_direcao() {
        int opcao = 0;
        while (opcao < 1 || opcao > 4) {
            System.out.println("Escolha uma direcao");
            System.out.println("1 - cima");
            System.out.println("2 - baixo");
            System.out.println("3 - esquerda");
            System.out.println("4 - direita");
            opcao = Main.scanner.nextInt();
            System.out.println(opcao);
        }
        return opcao;
    }
}
