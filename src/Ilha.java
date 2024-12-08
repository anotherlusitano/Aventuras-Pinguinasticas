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
 * {@link Ilha#dificuldade_da_ilha} - e o {@link Dificuldade} da Ilha <br>
 * {@link Ilha#coordenadas} - e as {@link Coordenada}s da Ilha <br>
 * {@link Ilha#visitada} - verifica se a Ilha ja foi visitada pelo {@link Barco} <br>
 * {@link Ilha#visitada} - E a {@link Missao} da Ilha
 */
public class Ilha {
    /** E o nome da {@link Ilha} */
    private String nome;

    /** E a {@link Dificuldade} da {@link Ilha} */
    private Dificuldade dificuldade_da_ilha;

    /** E as {@link Coordenada} da {@link Ilha} */
    private Coordenada coordenadas;

    /** Determina se a {@link Ilha} foi visitada */
    private boolean visitada;

    /** E a {@link Missao} da {@link Ilha} */
    private Missao missao;

    /// Construtor inicial da Ilha
    public Ilha(String nome, Dificuldade dificuldadeDaIlha, Coordenada coordenadas, boolean visitada, Missao missao) {
        this.nome = nome;
        this.dificuldade_da_ilha = dificuldadeDaIlha;
        this.coordenadas = coordenadas;
        this.visitada = visitada;
        this.missao = missao;
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
     * Pode ter no maximo 72 Ilhas, sendo elas, 12 faceis, 24 medias e 36 dificeis.<br><br>
     * Explicaçao: <br>
     * Esta e a organizaçao das {@link Ilha}s pelo mapa:
     * <pre>
     * 0 0 1 1 0 1 1 0 1 1
     * 0 0 1 1 0 1 1 0 1 1
     * 1 1 1 1 0 1 1 0 1 1
     * 1 1 1 1 0 1 1 0 1 1
     * 0 0 0 0 0 1 1 0 1 1
     * 1 1 1 1 1 1 1 0 1 1
     * 1 1 1 1 1 1 1 0 1 1
     * 0 0 0 0 0 0 0 0 1 1
     * 1 1 1 1 1 1 1 1 1 1
     * 1 1 1 1 1 1 1 1 1 1
     *
     * 1 = Ilha ; 0 = Onda
     * </pre>
     * Para ser considerado uma {@link Ilha} o <i>X</i> ou o <i>Y</i> precisa de ser 2, 3, 5, 6, 8 ou 9.<br>
     * Apartir do momento que escolhemos que o X/Y seja um desses numeros, vamos gerar um numero aleatorio ate esse numero para o outro eixo.<br>
     * Exemplo:<br>
     * X = 5 entao Y = RANDOM(0..X)<br>
     * Y = 3 entao X = RANDOM(0..Y)<br>
     * <br>
     * Cada divisao representa uma dificuldade, ou seja, a primeira divisao de 1's representa as Ilhas de {@link Dificuldade#FACIL},
     * a segunda divisao representa as Ilhas de {@link Dificuldade#MEDIO} e a ultima divisao representa a {@link Dificuldade#DIFICIL}.
     * @param dificuldade
     * @return as posicoes X e Y
     */
    public static Coordenada gerarCoordenadas(Dificuldade dificuldade) {
        final Random RANDOM = new Random();
        int x = 0, y = 0;
        int escolherXouY;

        switch (dificuldade) {
            case FACIL -> {
                escolherXouY = RANDOM.nextInt(2);
                if (escolherXouY == 0) {
                    x = 2 + RANDOM.nextInt(2);
                    y = RANDOM.nextInt(x);
                } else {
                    y = 2 + RANDOM.nextInt(2);
                    x = RANDOM.nextInt(y);
                }
            }
            case MEDIO -> {
                escolherXouY = RANDOM.nextInt(2);
                if (escolherXouY == 0) {
                    x = 5 + RANDOM.nextInt(2);
                    y = RANDOM.nextInt(x);
                } else {
                    y = 5 + RANDOM.nextInt(2);
                    x = RANDOM.nextInt(y);
                }
            }
            case DIFICIL -> {
                escolherXouY = RANDOM.nextInt(2);
                if (escolherXouY == 0) {
                    x = 8 + RANDOM.nextInt(2);
                    y = RANDOM.nextInt(x);
                } else {
                    y = 8 + RANDOM.nextInt(2);
                    x = RANDOM.nextInt(y);
                }
            }
        }
        return new Coordenada(x, y);
    }

    /**
     * @param quantidade_ilhas o numero de ilhas a serem criadas
     * @return um Array de {@link Ilha}s
     */
    public static Ilha[] criarIlhas(int quantidade_ilhas) {
        String[] NOMES_PARA_AS_ILHAS = {
                "GPT", "Piaget", "Pirata","Setubal",
                "Gelado", "Iceberg", "Dourada", "Projeto Europeu",
                "Sardinha", "Bacalhau", "Madeirense", "Atlantica",
                "Colorida", "Neve Azul", "dos Tubaroes", "das Raias",
                "Congelada", "Inacreditavel", "Pena Branca","Foca",
                "Perna de Pau", "da Rainha", "Perola Negra", "do Rei",
                "Arenosa", "Caveira", "do Ovo"
        };

        Ilha[] ilhas = new Ilha[quantidade_ilhas];

        /// Estas variaveis servem para contar se existe ilhas de X dificuldade disponiveis
        int ilhasFaceisDisponiveis = 12;
        int ilhasMediasDisponiveis = 24;
        int ilhasDificeisDisponiveis = 36;

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
            String nome_da_missao = "Missao " + nome_da_ilha;

            Missao missao = new Missao(nome_da_missao, dificuldade_da_ilha);

            ilhas[i] = new Ilha(
                   nome_da_ilha,
                   dificuldade_da_ilha,
                   coordenadas_da_ilha,
                    false,
                    missao
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

    public boolean getVisitada() {
        return visitada;
    }

    public void setVisitada(boolean visitada) {
        this.visitada = visitada;
    }

    public Missao getMissao() {
        return missao;
    }

    public void setMissao(Missao missao) {
        this.missao = missao;
    }
}