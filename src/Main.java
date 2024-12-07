import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo as Aventuras Pinguinasticas!");
        System.out.println("O teu objetivo e visitar todas as Ilhas do Oceano(mapa).");
        System.out.println("Mas antes disso, qual e o teu nome?");

        // Pedir o nome do utilizador
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();

        Jogador jogador = new Jogador(nome);

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
    }
}