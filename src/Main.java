public class Main {
    public static void main(String[] args) {
        Ilha[] ilhas = null;
        try {
            ilhas = Ilha.criarIlhas(9);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        Jogador jogador = new Jogador("Antonio", -100);

        Recursos recursos = new Recursos(100,100,100,100);

        Barco barco = new Barco(jogador.getNome(), jogador.getPontuacao(), recursos);

        Mapa mapa = new Mapa(barco, ilhas);

        Jogo jogo = new Jogo(jogador, mapa);

        jogo.iniciar();
    }
}