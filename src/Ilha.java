/**
 * Serve para importar todas as utilidades que vamos usar, como: <br>
 * - ArrayList, ou seja um array <br>
 * - Random, a classe para gerar os numeros aleatorios <br>
 * - HashSet, e uma colecao de itens unicos
  */
import java.util.*;

/**
 * Esta e a classe que implementa toda a logica das Ilhas.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Ilha#nome} - e o nome da Ilha <br>
 * {@link Ilha#pos_x} - e a posicao X da Ilha no {@link Mapa#mapa} <br>
 * {@link Ilha#pos_y} - e a posicao Y da Ilha no {@link Mapa#mapa} <br>
 * {@link Ilha#dificuldade_da_ilha} - e o {@link Dificuldade} da Ilha
 */
public class Ilha {
    /** E o nome da Ilha */
    private String nome;

    /** E a posicao X da {@link Ilha} dentro do {@link Mapa#mapa} */
    private int pos_x;

    /** E a posicao Y da {@link Ilha} dentro do {@link Mapa#mapa} */
    private int pos_y;

    /** E a {@link Dificuldade} da {@link Ilha} */
    private Dificuldade dificuldade_da_ilha;

    /// Uma lista de nomes para as Ilhas de {@link Dificuldade#FACIL}
    private static final List<String> NOMES_FACIL = new ArrayList<>(List.of("Bali", "Fiji", "Malta"));

    /// Uma lista de nomes para as Ilhas de {@link Dificuldade#MEDIO}
    private static final List<String> NOMES_MEDIO = new ArrayList<>(List.of("Skye", "Ibiza", "Capri"));

    /// Uma lista de nomes para as Ilhas de {@link Dificuldade#DIFICIL}
    private static final List<String> NOMES_DIFICIL = new ArrayList<>(List.of("Santorini", "Corsica", "Iceland"));

    /// E a variavel que vamos usar para obter os numeros aleatorios
    private static final Random RANDOM = new Random();

    /// Construtor inicial da Ilha
    public Ilha(String nome, int posX, int posY, Dificuldade dificuldadeDaIlha) {
        this.nome = nome;
        pos_x = posX;
        pos_y = posY;
        this.dificuldade_da_ilha = dificuldadeDaIlha;
    }

    /**
     * Aqui fazemos um method overloading para poder criar a {@link Ilha} da seguinte forma: <br>
     * 1. Damos uma {@link Dificuldade} aleatoria a Ilha. <br>
     * 2. Damos um nome baseado na dificuldade da Ilha, ou seja, um destes: {@link Ilha#NOMES_FACIL}, {@link Ilha#NOMES_MEDIO}, {@link Ilha#NOMES_DIFICIL}. <br>
     * 3. Geramos uma posicao aleatoria e unica a ilha usando a funcao {@link Ilha#generatePosition}.
     * @param occupiedPositions
     * @param nomes_usados_por_dificuldade
     */
    public Ilha(Set<String> occupiedPositions, Map<Dificuldade, Set<String>> nomes_usados_por_dificuldade) {
        // Randomly assign difficulty
        this.dificuldade_da_ilha = Dificuldade.values()[RANDOM.nextInt(Dificuldade.values().length)];

        // Assign a unique name based on difficulty
        List<String> availableNames = switch (this.dificuldade_da_ilha) {
            case FACIL -> NOMES_FACIL;
            case MEDIO -> NOMES_MEDIO;
            case DIFICIL -> NOMES_DIFICIL;
        };

        String chosenName;
        do {
            chosenName = availableNames.get(RANDOM.nextInt(availableNames.size()));
        } while (nomes_usados_por_dificuldade.get(this.dificuldade_da_ilha).contains(chosenName));
        nomes_usados_por_dificuldade.get(this.dificuldade_da_ilha).add(chosenName);
        this.nome = chosenName;

        // Generate unique position
        String positionKey;
        do {
            int[] position = generatePosition(this.dificuldade_da_ilha);
            this.pos_x = position[0];
            this.pos_y = position[1];
            positionKey = pos_x + "," + pos_y;
        } while (occupiedPositions.contains(positionKey));
        occupiedPositions.add(positionKey);
    }

    /**
     * Funcao que gera as posicoes aleatorias de uma {@link Ilha} apartir da sua dificuldade. <br>
     * Tambem faz que a Ilha tenha uma determinada posicao dependendo da sua dificuldade.
     * @param dificuldade
     * @return as posicoes X e Y
     */
    private int[] generatePosition(Dificuldade dificuldade) {
        int x = 0, y = 0;
        switch (dificuldade) {
            /// Vai gerar posicoes de 2 a 4
            case FACIL -> {
                x = 2 + RANDOM.nextInt(3);
                y = 2 + RANDOM.nextInt(3);
            }
            /// Vai gerar posicoes de 5 a 7
            case MEDIO -> {
                x = 5 + RANDOM.nextInt(3);
                y = 5 + RANDOM.nextInt(3);
            }
            /// Vai gerar posicoes de 8 a 10
            case DIFICIL -> {
                x = 8 + RANDOM.nextInt(3);
                y = 8 + RANDOM.nextInt(3);
            }
        }
        return new int[]{x, y};
    }

    /**
     * Vai criar uma lista de N {@link Ilha}s, e para isso vai seguir os seguintes passos: <br>
     * 1. Verificar se o numero de ilhas a serem criadas e maior que os nomes existentes, e se caso forem atira uma excecao. <br>
     * 2. Vai criar as ilhas unicas
     * @param n o numero de ilhas a serem criadas
     * @return
     */
    public static List<Ilha> criarIlhas(int n) {
        if (n > (NOMES_FACIL.size() + NOMES_MEDIO.size() + NOMES_DIFICIL.size())) {
            throw new IllegalArgumentException("Cannot create more islands than the available unique names.");
        }

        List<Ilha> islands = new ArrayList<>();
        Set<String> occupiedPositions = new HashSet<>();
        Map<Dificuldade, Set<String>> usedNamesByDifficulty = new HashMap<>();
        usedNamesByDifficulty.put(Dificuldade.FACIL, new HashSet<>());
        usedNamesByDifficulty.put(Dificuldade.MEDIO, new HashSet<>());
        usedNamesByDifficulty.put(Dificuldade.DIFICIL, new HashSet<>());

        for (int i = 0; i < n; i++) {
            islands.add(new Ilha(occupiedPositions, usedNamesByDifficulty));
        }
        return islands;
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

    public Dificuldade getDificuldade_da_ilha() {
        return dificuldade_da_ilha;
    }

    public void setDificuldade_da_ilha(Dificuldade dificuldade_da_ilha) {
        this.dificuldade_da_ilha = dificuldade_da_ilha;
    }

    /**
     * @param quantidade_ilhas e a quantidade de ilhas que queremos criar
     * @return retorna um Array de {@link Ilha}
     */
    public Ilha[] criar_ilhas(int quantidade_ilhas) {
        Ilha[] ilhas = new Ilha[quantidade_ilhas];

        return ilhas;
    }
}

/**
 * Serve para medir qual a dificuldade da ilha, por exemplo: <br>
 * uma ilha com dificuldade <i>FACIL</i> vai gastar menos recursos que uma ilha com dificuldade <i>DIFICIL</i>
 */
enum Dificuldade {
    /// E uma {@link Ilha} de dificuldade dificil
    DIFICIL,
    /// E uma {@link Ilha} de dificuldade mediana
    MEDIO,
    /// E uma {@link Ilha} de dificuldade facil
    FACIL
}