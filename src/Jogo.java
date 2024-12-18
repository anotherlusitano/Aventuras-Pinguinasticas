/**
 * Esta é a classe que implementa toda a lógica do Jogo.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Jogo#jogador} - é o {@link Jogador} <br>
 * {@link Jogo#mapa} - é o {@link Mapa}
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

    /// Esta é a função que vai iniciar o Jogo. <br>
    public void iniciar() {
        Mapa mapinha = getMapa();

        boolean fimDeJogo = false;
        while (!fimDeJogo) {
            mapinha.atualizarMapa();
            mapinha.mostrar();

            // Criamos um novo objeto para não ser uma referência do objeto Barco.Coordenada
            int posicaoXantiga = mapinha.getBarco().getCoordenadas().getX();
            int posicaoYantiga = mapinha.getBarco().getCoordenadas().getY();
            Coordenada posicaoAntigaDoBarco = new Coordenada(posicaoXantiga, posicaoYantiga);

            int opcao = jogador.escolherOqueFazer();
            executarOpcaoMenu(opcao);

            Ilha ilhaOndeEstaOBarco = mapinha.verificarChegouNaIlha();

            if (ilhaOndeEstaOBarco != null) {
                Missao missaoDaIlha = ilhaOndeEstaOBarco.getMissao();

                // vai mostrar a interface gráfica com a Missão
                // e apartir daí vai remover ou adicionar recursos ao Barco do Jogador
                JogoGUI.inicializarInterface(missaoDaIlha, mapinha.getBarco());

                // Por cada Ilha que visita, ganha 100 pontos
                int pontuacaoAtual = jogador.getPontuacao();
                jogador.setPontuacao(pontuacaoAtual+100);

                if (mapinha.verificarSeTodasAsIlhasForamVisitadas()) {
                    System.out.println("Muitos parabéns " + jogador.getNome() + "!");
                    System.out.println("Conseguiste navegar pelos 7 mares e acumular uma pontuação de " + jogador.getPontuacao() + " pontos!");
                    System.out.println("Por agora, o jogo acabou. Mas esperamos ver-te novamente!");
                    break;
                }
            }

            Coordenada posicaoAtualDoBarco = mapinha.getBarco().getCoordenadas();

            // Vai gastar 2 de energia cada vez que o Barco se mover para uma nova posição
            if (!posicaoAntigaDoBarco.equals(posicaoAtualDoBarco)) {
                int energia_atual = mapinha.getBarco().getRecursos().getEnergia();
                mapinha.getBarco().getRecursos().setEnergia(energia_atual-2);
            }

            fimDeJogo = verificarFimDeJogo();
        }

        if (fimDeJogo) {
            GameOver.inicializarGameOver();
            System.out.println("Perdeste " + jogador.getNome() + "...");
            System.out.println("Não conseguiste acabar o Jogo, mas ao menos acumulaste uma riqueza de " + jogador.getPontuacao() + " pontos...");
        }
    }

    /// Vai receber a opção que o jogador escolheu em {@link Jogador#escolherOqueFazer()} e vai responder a essa opção.
    private void executarOpcaoMenu(int opcao) {
        if (opcao == 5) {
            // Vai mostrar os recursos
            System.out.println(this.mapa.getBarco().getRecursos().toString());
        } else {
            // Vai mover o Barco
            this.mapa.moverBarco(opcao);
        }
    }

    /// Verifica se o {@link Barco} não tem algum dos recursos, e se nao tiver, vai acabar o Jogo
    private boolean verificarFimDeJogo() {
        Mapa mapa = getMapa();
        Barco barco = mapa.getBarco();

        return !barco.temRecursos();
    }
}
