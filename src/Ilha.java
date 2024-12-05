/**
 * Serve para importar todas as utilidades que vamos usar, como: <br>
 * - ArrayList, ou seja um array <br>
 * - Random, a classe para gerar os numeros aleatorios <br>
 * - HashSet, e uma colecao de itens unicos
  */
import java.util.*;

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

/**
 * Esta e a classe que implementa toda a logica das Ilhas.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Ilha#nome} - e o nome da Ilha <br>
 * {@link Ilha#dificuldade_da_ilha} - e o {@link Dificuldade} da Ilha
 */
public class Ilha {
    /** E o nome da {@link Ilha} */
    private String nome;

    /** E a {@link Dificuldade} da {@link Ilha} */
    private Dificuldade dificuldade_da_ilha;

    /** E as {@link Coordenada} da {@link Ilha} */
    private Coordenada coordenadas;

    /// Construtor inicial da Ilha
    public Ilha(String nome, Dificuldade dificuldadeDaIlha, Coordenada coordenadas) {
        this.nome = nome;
        this.dificuldade_da_ilha = dificuldadeDaIlha;
        this.coordenadas = coordenadas;
    }

    public static Dificuldade gerarDificuldade() {
        final Random RANDOM = new Random();

        Dificuldade[] todas_dificuldades = Dificuldade.values();
        int indice_aleatorio = RANDOM.nextInt(todas_dificuldades.length);

        Dificuldade dificuldade_da_ilha = todas_dificuldades[indice_aleatorio];

        return dificuldade_da_ilha;
    }

    /**
     * Funcao que gera as posicoes <i>x</i> e <i>y</i> de uma {@link Ilha}. <br>
     * Tambem faz que a Ilha tenha uma determinada posicao dependendo da sua dificuldade. <br>
     * A Ilha começa a aparecer depois da coordenada 1x1, ou seja, x=1 e y=1. <br>
     * @param dificuldade
     * @return as posicoes X e Y
     */
    public static Coordenada gerarCoordenadas(Dificuldade dificuldade) {
        final Random RANDOM = new Random();
        int x = 0, y = 0;

        /// Cada dificuldade pode gerar 9 Ilhas (NxN), entao podemos ter um total de 27 ilhas.
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
                x = 8 + RANDOM.nextInt(2);
                y = 8 + RANDOM.nextInt(2);
            }
        }
        return new Coordenada(x, y);
    }

    /**
     * @param quantidade_ilhas o numero de ilhas a serem criadas
     * @return um Array de {@link Ilha}s
     */
    public static Ilha[] criarIlhas(int quantidade_ilhas) throws Exception {
        String[] NOMES_PARA_AS_ILHAS = {"Ilha do GPT", "Piaget", "Ilha do W3","Setubal", "Reddit", "Ponto Medio","Amadora", "Africa", "4chan"};

        if (quantidade_ilhas > 27) {
            throw new Exception("Nao existe espaço para essas ilhas todas.");
        } else if (quantidade_ilhas > NOMES_PARA_AS_ILHAS.length) {
            throw new Exception("Nao podes criar mais ilhas que os nomes que existem.");
        }

        Ilha[] ilhas = new Ilha[quantidade_ilhas];

        /// Estas variaveis servem para contar se existe ilhas de X dificuldade disponiveis
        int ilhasFaceisDisponiveis = 9;
        int ilhasMediasDisponiveis = 9;
        int ilhasDificeisDisponiveis = 9;

        /// E a lista de coordenadas UNICAS
        Set<Coordenada> lista_de_coordenadas = new HashSet<>();

        for (int i = 0; i < quantidade_ilhas; i++) {
            /*
                Primeiro geramos uma dificuldade.
                Depois verificamos se essa ilha pode ter essa dificuldade ja que o maximo e 9.
                Se nao poder ter essa dificuldade, vai gerar uma nova dificuldade ate dar.
             */
            Dificuldade dificuldade_da_ilha = gerarDificuldade();

            while ((dificuldade_da_ilha == Dificuldade.FACIL && ilhasFaceisDisponiveis == 0) ||
                    (dificuldade_da_ilha == Dificuldade.MEDIO && ilhasMediasDisponiveis == 0) ||
                    (dificuldade_da_ilha == Dificuldade.DIFICIL && ilhasDificeisDisponiveis == 0)) {
                dificuldade_da_ilha = gerarDificuldade();
            }

            if (dificuldade_da_ilha == Dificuldade.FACIL) {
                ilhasFaceisDisponiveis -= 1;
            } else if (dificuldade_da_ilha == Dificuldade.MEDIO) {
                ilhasMediasDisponiveis -= 1;
            } else {
                ilhasDificeisDisponiveis -= 1;
            }

            /*
                Aqui nos geramos as coordenadas para a Ilha, ou seja,
                criamos uma lista de coordenadas, para saber quais coordenadas estao em uso,
                depois se uma dessas coordenadas estiver em uso, vai voltar a gerar a coordenada ate dar
             */
            Coordenada coordenadas_da_ilha = gerarCoordenadas(dificuldade_da_ilha);

            while (lista_de_coordenadas.contains(coordenadas_da_ilha)) {
                coordenadas_da_ilha = gerarCoordenadas(dificuldade_da_ilha);
            }

            lista_de_coordenadas.add(coordenadas_da_ilha);

            Random random = new Random();
            String nome_da_ilha = NOMES_PARA_AS_ILHAS[random.nextInt(NOMES_PARA_AS_ILHAS.length)];

            ilhas[i] = new Ilha(
                   nome_da_ilha,
                   dificuldade_da_ilha,
                   coordenadas_da_ilha
            );
        }

        return ilhas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Dificuldade getDificuldade_da_ilha() {
        return dificuldade_da_ilha;
    }

    public void setDificuldade_da_ilha(Dificuldade dificuldade_da_ilha) {
        this.dificuldade_da_ilha = dificuldade_da_ilha;
    }

    public Coordenada getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenada coordenadas) {
        this.coordenadas = coordenadas;
    }
}