import javax.swing.*;
import java.awt.*;

public class GameOver extends JFrame {

    public GameOver() {
        // Configurações da janela
        setTitle("Game Over");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel com a imagem de fundo
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new BorderLayout());

        // Painel para o conteúdo, com texto dentro de uma caixa preta
        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(true); // Fundo opaco
        contentPanel.setBackground(Color.BLACK); // Cor de fundo preta
        contentPanel.setLayout(new BorderLayout()); // Usando BorderLayout para centralizar o texto

        // Texto de descrição do Game Over
        JLabel descriptionLabel = new JLabel("Você perdeu! Seus recursos acabaram.", SwingConstants.CENTER);
        descriptionLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        descriptionLabel.setForeground(Color.WHITE); // Cor branca para o texto
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Alinha ao centro

        // Adiciona o texto ao painel de conteúdo (caixa preta)
        contentPanel.add(descriptionLabel, BorderLayout.CENTER); // Texto no centro da caixa preta

        // Adiciona o painel de conteúdo ao painel de fundo
        backgroundPanel.add(contentPanel, BorderLayout.SOUTH); // Coloca o conteúdo na parte inferior

        // Define o painel de fundo como conteúdo da janela
        setContentPane(backgroundPanel);

        // Torna a janela visível
        setVisible(true);
    }

    public static void inicializarGameOver() {
        SwingUtilities.invokeLater(GameOver::new);
    }

    // Classe personalizada para desenhar a imagem de fundo
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel() {
            // Carregar a imagem de fundo (gameover.png ou outro nome)
            backgroundImage = new ImageIcon(getClass().getResource("/gameover.png")).getImage(); // Ajuste o caminho para a imagem correta
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                // Desenha a imagem preenchendo o painel
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
