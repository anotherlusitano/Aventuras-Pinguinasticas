import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Esta e a classe que implementa toda a logica das Missoes.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Missao#nome} - e o nome da Missao <br>
 * {@link Missao#dificuldade} - e a dificuldade da Missao <br>
 * {@link Missao#opcoes} - e as {@link Opcao}s da Missao
 */
public class Missao {
    /** E o nome da Missao que vai aparecer ao {@link Jogador} */
    private String nome;

    /** E a {@link Dificuldade} da Missao */
    private Dificuldade dificuldade;

    /** Sao as {@link Opcao}s que a Missao vai ter */
    private List<Opcao> opcoes;

    public Missao(String nome, Dificuldade dificuldade) {
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.opcoes = gerarOpcoes();
    }

    /// Vai gerar uma lista de 3 {@link Opcao}s
    private List<Opcao> gerarOpcoes() {
        List<Opcao> opcoes = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            Recursos custo = calcularCustos();
            Recursos ganho = calcularGanhos();
            String texto = gerarTexto();
            opcoes.add(new Opcao(texto, custo, ganho));
        }
        return opcoes;
    }

    /// Vai gerar o texto da opçao baseado na {@link Dificuldade} da {@link Missao}
    private String gerarTexto() {
        Random random = new Random();

        if (dificuldade == Dificuldade.FACIL) {
            String[] TEXTO_DAS_OPCOES_FACEIS = {"Pescar", "Procurar por moedas de ouro", "Brincar na areia","Nadar com golfinhos", "Conversar na praia", "Fazer um acampamento"};

            String texto_da_opcao = TEXTO_DAS_OPCOES_FACEIS[random.nextInt(TEXTO_DAS_OPCOES_FACEIS.length)];

            return texto_da_opcao;
        } else if (dificuldade == Dificuldade.MEDIO) {
            String[] TEXTO_DAS_OPCOES_MEDIO = {"Caçar enguias", "Explorar a selva", "Lutar com caranguejos","Nadar com tubaroes", "Lutar com outros pinguins", "Fazer um Forte contra a tempestade"};

            String texto_da_opcao = TEXTO_DAS_OPCOES_MEDIO[random.nextInt(TEXTO_DAS_OPCOES_MEDIO.length)];

            return texto_da_opcao;
        } else {
            String[] TEXTO_DAS_OPCOES_DIFICEIS = {"Guerrear contra a Ilha", "Explorar a caverna obscura", "Lutar com piratas","Nadar com o Kraken", "Roubar a esmeralda perdida", "Matar o rei da Ilha"};

            String texto_da_opcao = TEXTO_DAS_OPCOES_DIFICEIS[random.nextInt(TEXTO_DAS_OPCOES_DIFICEIS.length)];

            return texto_da_opcao;
        }
    }

    /// Vai retornar uma quantidade de {@link Recursos} dependendo da dificuldade da {@link Missao}
    private Recursos calcularCustos() {
        final Random RANDOM = new Random();
        int recursos = 0;

        if (dificuldade == Dificuldade.FACIL) {
            recursos = 1 + RANDOM.nextInt(15);

            return new Recursos(recursos, recursos, 0, 0);
        } else if (dificuldade == Dificuldade.MEDIO) {
            recursos = 20 + RANDOM.nextInt(16);

            return new Recursos(recursos, recursos, recursos, recursos);
        } else {
            recursos = 35 + RANDOM.nextInt(25);

            return new Recursos(recursos, recursos, recursos, (int) (recursos*1.2));
        }
    }

    /// Vai retornar uma quantidade de {@link Recursos} dependendo da dificuldade da {@link Missao}
    private Recursos calcularGanhos() {
        final Random RANDOM = new Random();
        int recursos = 0;

        if (dificuldade == Dificuldade.FACIL) {
            recursos = RANDOM.nextInt(16);

            return new Recursos(recursos, recursos, recursos, recursos);
        } else if (dificuldade == Dificuldade.MEDIO) {
            recursos = 10 + RANDOM.nextInt(10);

            return new Recursos(recursos, recursos, recursos, recursos);
        } else {
            recursos = 10 + RANDOM.nextInt(35);

            return new Recursos(recursos, recursos, recursos, recursos);
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
