import java.util.List;

/**
 * Esta e a classe que implementa toda a logica do Mapa.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Mapa#mapa} - e a area do nosso mapa <br>
 * {@link Mapa#barco} - e o {@link Barco} que vai estar dentro do mapa <br>
 * {@link Mapa#ilhas} - e as {@link Ilha} que vao estar dentro do mapa
*/
public class Mapa {
    /** Um mapa 10 por 10 em que int[pos_x][pos_y] */
    private int[][] mapa = new int[10][10];

    /** E o {@link Barco} que vai estar dentro do {@link Mapa#mapa} */
    private Barco barco;

    /** Sao as {@link Ilha} que vao ser geradas dentro do {@link Mapa#mapa} */
    private Ilha[] ilhas;

    public Mapa(Barco barco, Ilha[] ilhas) {
        /// Primeiro vamos receber o Barco e as Ilhas
        this.barco = barco;
        this.ilhas = ilhas;

        /// Depois vamos mete-los no Mapa quando ele e criado
    }

    public int[][] getMapa() {
        return mapa;
    }

    public void setMapa(int[][] mapa) {
        this.mapa = mapa;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    public Ilha[] getIlhas() {
        return ilhas;
    }

    public void setIlhas(Ilha[] ilhas) {
        this.ilhas = ilhas;
    }

    /**
     * Esta funçao faz que o Mapa se reconstrua
     * com as coordenadas das {@link Ilha}s e do {@link Jogador}
      */
    public void atualizarMapa() {
        // Atualizar o Mapa
        this.mapa = new int[10][10];

        // Atualizar o Barco
        int pos_x = this.barco.getPos_x();
        int pos_y = this.barco.getPos_y();
        this.mapa[pos_x][pos_y] = 5;

        // Atualizar a Ilha
        for (Ilha ilha : this.ilhas) {
            int x = ilha.getCoordenadas().getX();
            int y = ilha.getCoordenadas().getY();
            this.mapa[x][y] = 1;
        }
    }

    /// Esta funcao serve para mover o {@link Barco} dentro do {@link Mapa}
    public void moverBarco(int direcao) {
        int barco_pos_x = this.barco.getPos_x();
        int barco_pos_y = this.barco.getPos_y();

        switch (direcao) {
            case 1:
                if (barco_pos_x == 0) {
                    //System.out.println("O jogador nao pode ir para essa direçao");
                    break;
                }
                this.barco.setPos_x(barco_pos_x - 1);
                break;
            case 2:
                if (barco_pos_x == 9) {
                    //System.out.println("O jogador nao pode ir para essa direçao");
                    break;
                }
                this.barco.setPos_x(barco_pos_x + 1);
                break;
            case 3:
                if (barco_pos_y == 0) {
                    //System.out.println("O jogador nao pode ir para essa direçao");
                    break;
                }
                this.barco.setPos_y(barco_pos_y - 1);
                break;
            case 4:
                if (barco_pos_y == 9) {
                    //System.out.println("O jogador nao pode ir para essa direçao");
                    break;
                }
                this.barco.setPos_y(barco_pos_y + 1);
                break;
            default:
                System.out.println("O jogador nao pode ir para essa direçao");
        }    }

    /// Esta funçao mostra o mapa na consola
    public void mostrar() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.mapa[i][j] == 5) {
                    System.out.print("\uD83D\uDEE5" + "  ");
                } else if (this.mapa[i][j] == 1) {
                    System.out.print("\uD83C\uDFDD" + "  ");
                } else {
                    System.out.print("\uD83C\uDF0A" + " ");
                }
            }
            System.out.println();
        }
    }

}