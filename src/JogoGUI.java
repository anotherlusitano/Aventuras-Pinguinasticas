import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoGUI extends JFrame {

    public JogoGUI(Missao missao, Barco barco) {
        // Configurações da janela
        setTitle("Interface de Missão");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel principal com imagem de fundo
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new BorderLayout());

        // Painel para conter o título e os botões
        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false); // Fundo transparente
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS)); // Empilha componentes verticalmente

        String nome_da_missao = missao.getNome();
        String titulo_missao = "Missão " + nome_da_missao;

        // Adiciona título no topo
        JLabel titleLabel = new JLabel(titulo_missao, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK); // Define a cor do título para preto
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza o título

        // Painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Fundo transparente
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        // Criação e estilo dos botões
        for (int i = 0; i < 3; i++) {
            Opcao opcao = missao.getOpcoes().get(i);
            String opcao_texto = opcao.getTexto();
            String opcao_recursos = opcao.toString();

            JButton botao = new JButton(opcao_texto);
            botao.setBackground(Color.BLACK);
            botao.setForeground(Color.WHITE);
            botao.setFocusPainted(false);
            botao.setFont(new Font("Serif", Font.PLAIN, 18));
            botao.setToolTipText(opcao_recursos);

            botao.addActionListener(new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    barco.getRecursos().subtrair(opcao.getCusto());
                    barco.getRecursos().somar(opcao.getGanho());
                    dispose();
                }
            });

            buttonPanel.add(botao);
        }

        // Adiciona o título e os botões ao painel superior
        topPanel.add(Box.createVerticalStrut(10)); // Espaço entre o topo e o título
        topPanel.add(titleLabel); // Adiciona o título
        topPanel.add(Box.createVerticalStrut(10)); // Espaço entre o título e os botões
        topPanel.add(buttonPanel); // Adiciona os botões

        // Adiciona o painel superior ao topo do fundo
        backgroundPanel.add(topPanel, BorderLayout.NORTH);

        // Painel que vai conter o texto no lado inferior esquerdo
        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false); // Transparente
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); // Alinha ao canto esquerdo

        // Criação de um JLabel para exibir as informações
        int peixe =  barco.getRecursos().getPeixe();
        int energia = barco.getRecursos().getEnergia();
        int moral = barco.getRecursos().getMoral();
        int vida_da_tripulacao = barco.getRecursos().getVida_da_tripulacao();
        JLabel infoLabel = new JLabel(
                "<html>Energia: " + energia +
                        "<br>Peixe: " + peixe +
                        "<br>Moral: " + moral +
                        "<br>Vida da Tripulação: " + vida_da_tripulacao + "</html>"
        );
        infoLabel.setFont(new Font("Serif", Font.PLAIN, 16)); // Ajusta a fonte
        infoLabel.setOpaque(true); // Torna o fundo visível
        infoLabel.setBackground(Color.WHITE); // Define o fundo branco
        infoLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Adiciona uma borda interna

        // Adiciona o JLabel ao painel inferior esquerdo
        leftPanel.add(infoLabel);

        // Adiciona o painel esquerdo ao rodapé, alinhado à esquerda
        backgroundPanel.add(leftPanel, BorderLayout.SOUTH);

        // Adiciona o painel de fundo ao JFrame
        setContentPane(backgroundPanel);
        setVisible(true);
    }

    public static void inicializarInterface(Missao missao, Barco barco) {
        try {
            // Criamos a Interface para depois deixá-la visivel
            JogoGUI gui = new JogoGUI(missao, barco);

            // Usamos o invokeAndWait para só avançar no ciclo quando invocar a interface
            SwingUtilities.invokeAndWait(() -> gui.setVisible(true));

            // Vamos esperar até a Interface seja fechada para poder avançar
            while (gui.isDisplayable()) {
                Thread.sleep(100);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    // Classe personalizada para desenhar a imagem de fundo
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel() {
            // Carregar a imagem "ilha.jpg"
            backgroundImage = new ImageIcon(getClass().getResource("/ilha.jpg")).getImage();
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
