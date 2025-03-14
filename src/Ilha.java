/**
 * Serve para importar todas as utilidades que vamos usar, como: <br>
 * - ArrayList, ou seja um array <br>
 * - Random, a classe para gerar os números aleatórios <br>
 * - HashSet, e uma coleção de itens únicos
  */
import java.util.*;

/**
 * Esta é a classe que implementa toda a lógica das Ilhas.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Ilha#dificuldade_da_ilha} - é o {@link Dificuldade} da Ilha <br>
 * {@link Ilha#coordenadas} - são as {@link Coordenada}s da Ilha <br>
 * {@link Ilha#visitada} - verifica se a Ilha ja foi visitada pelo {@link Barco} <br>
 * {@link Ilha#missao} - é a {@link Missao} da Ilha
 */
public class Ilha {
    /** É a {@link Dificuldade} da {@link Ilha} */
    private Dificuldade dificuldade_da_ilha;

    /** São as {@link Coordenada}s da {@link Ilha} */
    private Coordenada coordenadas;

    /** Determina se a {@link Ilha} foi visitada */
    private boolean visitada;

    /** E a {@link Missao} da {@link Ilha} */
    private Missao missao;

    /// Construtor inicial da Ilha
    public Ilha(Dificuldade dificuldadeDaIlha, Coordenada coordenadas, boolean visitada, Missao missao) {
        this.dificuldade_da_ilha = dificuldadeDaIlha;
        this.coordenadas = coordenadas;
        this.visitada = visitada;
        this.missao = missao;
    }

    private static Dificuldade gerarDificuldade() {
        final Random RANDOM = new Random();

        Dificuldade[] todas_dificuldades = Dificuldade.values();
        int indice_aleatorio = RANDOM.nextInt(todas_dificuldades.length);

        Dificuldade dificuldade_da_ilha = todas_dificuldades[indice_aleatorio];

        return dificuldade_da_ilha;
    }

    /**
     * Função que gera uma lista de posições <i>x</i> e <i>y</i> de uma {@link Ilha}, baseado na sua {@link Dificuldade}. <br>
     * Todos os valores são pré-computados/gerados para uma otimização na geração, ja que se fossemos com valores aleatórios demoraria imenso tempo.<br>
     * Pode ter no máximo 72 Ilhas, sendo elas, 12 fáceis, 24 médias e 36 difíceis.<br><br>
     * Explicação: <br>
     * Esta é a organização das {@link Ilha}s pelo mapa:
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
     * Cada divisão representa uma dificuldade, ou seja, a primeira divisão de 1's representa as Ilhas de {@link Dificuldade#FACIL},
     * a segunda divisão representa as Ilhas de {@link Dificuldade#MEDIO} e a última divisão representa a {@link Dificuldade#DIFICIL}.
     * <br><br>
     * Para ser considerado uma {@link Ilha} o <i>X</i> ou o <i>Y</i> precisa de ser 2, 3, 5, 6, 8 ou 9.<br>
     * Primeiro vamos escolher gerar todas as posiçoes com X, ou seja:
     * <pre>
     *     (X = 2 & X = 3) & Y = FOR(0..X)
     * </pre>
     * e fazemos a mesma coisa para o Y:
     * <pre>
     *     (Y = 2 & Y = 3) & X = FOR(0..Y-1)
     * </pre>
     * Para cada {@link Coordenada} gerada, vamos adicionar a uma lista, e depois vamos dar um <i>SHUFFLE</i> nessa lista para torna-la pseudo-aleatória.<br>
     * <br>
     * <b>WARNING:</b> o único "se não" desta função é que gera todas as Coordenadas das Ilhas, de uma dada dificuldade, mesmo que só queiramos 1 Coordenada.
     * @param dificuldade
     * @return as posicoes X e Y
     */
    private static List<Coordenada> gerarCoordenadas(Dificuldade dificuldade) {
        List<Coordenada> coordenadas = new ArrayList<>();

        switch (dificuldade) {
            case FACIL -> {
                for (int x = 2; x <= 3; x++) {
                    for (int y = 0; y <= x; y++) {
                        coordenadas.add(new Coordenada(x, y));
                    }
                }
                for (int y = 2; y <= 3; y++) {
                    for (int x = 0; x < y; x++) {
                        coordenadas.add(new Coordenada(x, y));
                    }
                }

                Collections.shuffle(coordenadas);
                return coordenadas;
            }
            case MEDIO -> {
                for (int x = 5; x <= 6; x++) {
                    for (int y = 0; y <= x; y++) {
                        coordenadas.add(new Coordenada(x, y));
                    }
                }
                for (int y = 5; y <= 6; y++) {
                    for (int x = 0; x < y; x++) {
                        coordenadas.add(new Coordenada(x, y));
                    }
                }

                Collections.shuffle(coordenadas);
                return coordenadas;
            }
            case DIFICIL -> {
                for (int x = 8; x <= 9; x++) {
                    for (int y = 0; y < x; y++) {
                        coordenadas.add(new Coordenada(x, y));
                    }
                }
                for (int y = 8; y <= 9; y++) {
                    for (int x = 0; x <= y; x++) {
                        coordenadas.add(new Coordenada(x, y));
                    }
                }

                Collections.shuffle(coordenadas);
                return coordenadas;
            }
        }
        // Isto provavelmente nunca vai acontecer já que só existe 3 dificuldades
        return coordenadas;
    }

    /**
     * @param quantidade_ilhas o número de ilhas a serem criadas
     * @return um Array de {@link Ilha}s
     */
    public static Ilha[] criarIlhas(int quantidade_ilhas) {
        Ilha[] ilhas = new Ilha[quantidade_ilhas];

        /// Estas variáveis servem para contar se existe ilhas de X dificuldade disponíveis
        int ilhasFaceisDisponiveis = 12;
        int ilhasMediasDisponiveis = 24;
        int ilhasDificeisDisponiveis = 36;

        /// São as listas de coordenadas ÚNICAS, divídidas por Dificuldade
        List<Coordenada> coordenadasFaceis = gerarCoordenadas(Dificuldade.FACIL);
        List<Coordenada> coordenadasMedias = gerarCoordenadas(Dificuldade.MEDIO);
        List<Coordenada> coordenadasDificeis = gerarCoordenadas(Dificuldade.DIFICIL);

        Coordenada coordenadas_da_ilha;

        for (int i = 0; i < quantidade_ilhas; i++) {
            /*
                Primeiro geramos uma dificuldade.
                Depois verificamos se essa ilha pode ter essa dificuldade.
                Se não poder ter essa dificuldade, vai gerar uma nova dificuldade até dar.
             */
            Dificuldade dificuldade_da_ilha = gerarDificuldade();

            while ((dificuldade_da_ilha == Dificuldade.FACIL && ilhasFaceisDisponiveis == 0) ||
                    (dificuldade_da_ilha == Dificuldade.MEDIO && ilhasMediasDisponiveis == 0) ||
                    (dificuldade_da_ilha == Dificuldade.DIFICIL && ilhasDificeisDisponiveis == 0)) {
                dificuldade_da_ilha = gerarDificuldade();
            }

            if (dificuldade_da_ilha == Dificuldade.FACIL) {
                ilhasFaceisDisponiveis -= 1;
                coordenadas_da_ilha = coordenadasFaceis.get(ilhasFaceisDisponiveis);
            } else if (dificuldade_da_ilha == Dificuldade.MEDIO) {
                ilhasMediasDisponiveis -= 1;
                coordenadas_da_ilha = coordenadasMedias.get(ilhasMediasDisponiveis);
            } else {
                ilhasDificeisDisponiveis -= 1;
                coordenadas_da_ilha = coordenadasDificeis.get(ilhasDificeisDisponiveis);
            }

            String[] NOMES_PARA_AS_MISSOES = {
                    "GPT", "Piaget", "Pirata","Setúbal",
                    "Gelado", "Iceberg", "Dourada", "Projeto Europeu",
                    "Sardinha", "Bacalhau", "Madeirense", "Atlântica",
                    "Colorida", "Neve Azul", "dos Tubarões", "das Raias",
                    "Congelada", "Inacreditável", "Pena Branca","Foca",
                    "Perna de Pau", "da Rainha", "Pérola Negra", "do Rei",
                    "Arenosa", "Caveira", "do Ovo"
            };

            Random random = new Random();
            String nome_da_missao = NOMES_PARA_AS_MISSOES[random.nextInt(NOMES_PARA_AS_MISSOES.length)];

            Missao missao = new Missao(nome_da_missao, dificuldade_da_ilha);

            ilhas[i] = new Ilha(
                   dificuldade_da_ilha,
                   coordenadas_da_ilha,
                    false,
                    missao
            );
        }

        return ilhas;
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
