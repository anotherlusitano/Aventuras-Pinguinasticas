/**
 * Esta e a classe que implementa toda a logica do Jogo.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Jogo#jogador} - e o {@link Jogador} <br>
 * {@link Jogo#mapa} - e o {@link Mapa}
 */
public class Jogo {
    private Jogador jogador;

    private Mapa mapa;

    public Jogo(Jogador jogador, Mapa mapa) {
        this.jogador = jogador;
        this.mapa = mapa;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    /// Esta e a funcao que vai iniciar o Jogo. <br>
    public void iniciar() {
        Mapa mapinha = getMapa();

        boolean fimDeJogo = false;
        while (!fimDeJogo) {
            mapinha.atualizarMapa();
            mapinha.mostrar();

            int direcao = jogador.escolher_direcao();
            mapinha.moverBarco(direcao);

            Ilha ilhaOndeEstaOBarco = mapinha.verificarChegouNaIlha();

            if (ilhaOndeEstaOBarco != null) {
                Missao missaoDaIlha = ilhaOndeEstaOBarco.getMissao();

                // vai mostrar a interface com a Missao
                // e apartir dai vai remover ou adicionar recursos ao Barco do Jogador
                JogoGUI.inicializarInterface(missaoDaIlha, mapinha.getBarco());

                // Por cada Ilha que visita, ganha 100 pontos
                int pontuacaoAtual = jogador.getPontuacao();
                jogador.setPontuacao(pontuacaoAtual+100);

                if (mapinha.verificarSeTodasAsIlhasForamVisitadas()) {
                    System.out.println("Muitos parabens " + jogador.getNome() + "!");
                    System.out.println("Conseguiste navegar pelos 7 mares e acumular uma pontuaçao de " + jogador.getPontuacao() + " pontos!");
                    System.out.println("Por agora, o jogo acabou. Mas esperamos ver te novamente!");
                    break;
                }
            }

            // Vai gastar 5 de energia cada vez que se mexer
            int energia_atual = mapinha.getBarco().getRecursos().getEnergia();
            mapinha.getBarco().getRecursos().setEnergia(energia_atual-5);

            fimDeJogo = verificarFimDeJogo();
        }

        if (fimDeJogo) {
            GameOver.inicializarGameOver();
        }
    }

    /// Verifica se o {@link Barco} nao tem recursos, e se nao tiver, vai acabar o Jogo
    private boolean verificarFimDeJogo() {
        Mapa mapa = getMapa();
        Barco barco = mapa.getBarco();

        return !barco.temRecursos();
    }
}
