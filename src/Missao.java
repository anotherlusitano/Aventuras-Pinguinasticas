import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Esta é a classe que implementa toda a lógica das Missões.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Missao#nome} - é o nome da Missão <br>
 * {@link Missao#dificuldade} - é a dificuldade da Missão <br>
 * {@link Missao#opcoes} - é as {@link Opcao}s da Missão
 */
public class Missao {
    /** É o nome da Missão que vai aparecer ao {@link Jogador} */
    private String nome;

    /** É a {@link Dificuldade} da Missão */
    private Dificuldade dificuldade;

    /** São as {@link Opcao}s que a Missão vai ter */
    private List<Opcao> opcoes;

    public Missao(String nome, Dificuldade dificuldade) {
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.opcoes = gerarOpcoes();
    }

    /// Vai gerar uma lista de 3 {@link Opcao}s
    private List<Opcao> gerarOpcoes() {
        List<Opcao> opcoes = new ArrayList<>();

        // A lógica destas 3 linhas de código é criar uma lista que vai até à TEXTO_DAS_OPCOES.length que tivermos
        // ou seja, se tivermos 6 Opções para o texto, a lista tem de estar preenchida de 0..6
        // e com isso, vai trocar a ordem dos números para dar-nos Opções "aleatórias" e únicas
        // o problema disto é que precisamos ter a mesma quantidade de TEXTO_DAS_OPCOES para cada dificuldade
        // e também precisamos mudar até onde vai o *i*, ja que ele representa ate qual Opção vai escolher
        // e claro, que quanto mais Opções tivermos, mais cresce em complexidade O(N)
        // mas por agora, está uma boa solução.
        ArrayList<Integer> listaAleatoriaOpcoes = new ArrayList<Integer>();
        for (int i=0; i<12; i++) listaAleatoriaOpcoes.add(i);
        Collections.shuffle(listaAleatoriaOpcoes);

        for (int i = 0; i < 3; i++) {
            Recursos custo = calcularCustos();
            Recursos ganho = calcularGanhos();

            String texto = gerarTexto(listaAleatoriaOpcoes.get(i));

            opcoes.add(new Opcao(texto, custo, ganho));
        }
        return opcoes;
    }

    /// Vai gerar o texto da opção baseado na {@link Dificuldade} da {@link Missao}
    private String gerarTexto(int opcao) {
        if (dificuldade == Dificuldade.FACIL) {
            String[] TEXTO_DAS_OPCOES_FACEIS = {
                    "Pescar", "Procurar por moedas de ouro", "Brincar na areia",
                    "Nadar com golfinhos", "Conversar na praia", "Fazer um acampamento",
                    "Roubar um comerciante", "Limpar a casa de um pinguim", "Fazer uma partida",
                    "Explorar o aldeia", "Negociar com o comerciante", "Concertar o Barco"
            };

            return TEXTO_DAS_OPCOES_FACEIS[opcao];
        } else if (dificuldade == Dificuldade.MEDIO) {
            String[] TEXTO_DAS_OPCOES_MEDIO = {
                    "Caçar enguias", "Explorar a selva", "Lutar com caranguejos",
                    "Nadar com tubarões", "Lutar com pinguins", "Fazer um Forte contra a tempestade",
                    "Invadir o tanque de peixes", "Roubar ouro", "Fazer uma festa",
                    "Apostar no PeixaMilhões", "Explorar a montanha", "Explorar uma gruta"
            };

            return TEXTO_DAS_OPCOES_MEDIO[opcao];
        } else {
            String[] TEXTO_DAS_OPCOES_DIFICEIS = {
                    "Guerrear contra a Ilha", "Explorar a caverna obscura", "Lutar com piratas",
                    "Nadar com o Kraken", "Roubar a esmeralda perdida", "Matar o rei",
                    "Lutar contra a Macacada", "Roubar o rei", "Roubar piratas",
                    "Explorar o vulcão", "Invocar o deus pinguim", "Começar uma revolução"
            };

            return TEXTO_DAS_OPCOES_DIFICEIS[opcao];
        }
    }

    /// Vai retornar uma quantidade de {@link Recursos} dependendo da dificuldade da {@link Missao}
    private Recursos calcularCustos() {
        final Random RANDOM = new Random();

        if (dificuldade == Dificuldade.FACIL) {
            return new Recursos(RANDOM.nextInt(15)+1, RANDOM.nextInt(15)+1, 0, 0);
        } else if (dificuldade == Dificuldade.MEDIO) {
            return new Recursos(RANDOM.nextInt(16)+20, RANDOM.nextInt(16)+20, RANDOM.nextInt(16)+20, RANDOM.nextInt(16)+20);
        } else {
            return new Recursos(RANDOM.nextInt(25)+35, RANDOM.nextInt(25)+35, RANDOM.nextInt(25)+35, RANDOM.nextInt(25)+35);
        }
    }

    /// Vai retornar uma quantidade de {@link Recursos} dependendo da dificuldade da {@link Missao}
    private Recursos calcularGanhos() {
        final Random RANDOM = new Random();

        if (dificuldade == Dificuldade.FACIL) {
            return new Recursos(RANDOM.nextInt(16), RANDOM.nextInt(16), RANDOM.nextInt(16), RANDOM.nextInt(16));
        } else if (dificuldade == Dificuldade.MEDIO) {

            return new Recursos(RANDOM.nextInt(10)+10, RANDOM.nextInt(10)+10, RANDOM.nextInt(10)+10, RANDOM.nextInt(10)+10);
        } else {
            return new Recursos(RANDOM.nextInt(35)+10, RANDOM.nextInt(35)+10, RANDOM.nextInt(35)+10, RANDOM.nextInt(35)+10);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Opcao> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(List<Opcao> opcoes) {
        this.opcoes = opcoes;
    }
}
