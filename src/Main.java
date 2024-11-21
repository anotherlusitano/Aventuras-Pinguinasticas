public class Main {
    public static void main(String[] args) {
        Jogador jogador = new Jogador("Antonio", -100, null);
        Mapa mapa = new Mapa(null, null);

        Jogo jogo = new Jogo(jogador, mapa);

        jogo.iniciar();
    }
}