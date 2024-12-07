import java.util.Scanner;

public class Main {
    /// Infelizmente, o Scanner ao usar close() fecha completamente o input da consola. <br>
    /// Ver mais explicaçoes [aqui](https://stackoverflow.com/questions/13042008/java-util-nosuchelementexception-scanner-reading-user-input).
    public static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("Bem-vindo as Aventuras Pinguinasticas!");
        System.out.println("O teu objetivo e visitar todas as Ilhas do Oceano(mapa).");
        System.out.println("Mas antes disso, qual e o teu nome?");

        scanner = new Scanner(System.in);
        String nome_do_jogador = "";
        do {
            nome_do_jogador = scanner.nextLine();
        }
        while (nome_do_jogador.contains(";"));

        Jogador jogador = new Jogador(nome_do_jogador);

        jogador.criarFicheiroPontuacao();

        Recursos recursos = new Recursos(100,100,100,100);

        Barco barco = new Barco(jogador.getNome(), recursos);

        Ilha[] ilhas = null;
        try {
            ilhas = Ilha.criarIlhas(9);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        Mapa mapa = new Mapa(barco, ilhas);

        Jogo jogo = new Jogo(jogador, mapa);

        jogo.iniciar();

        scanner.close();
    }
}