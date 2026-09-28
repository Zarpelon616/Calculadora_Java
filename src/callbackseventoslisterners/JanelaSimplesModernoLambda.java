package callbackseventoslisterners;

import javax.swing.*;
import java.awt.event.*;

public class JanelaSimplesModernoLambda extends JFrame {
    public JanelaSimplesModernoLambda() {
        JMenuBar barra = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem arqTeste = new JMenuItem("Teste");
        JMenuItem arqSair = new JMenuItem("Sair");

        menuArquivo.add(arqTeste);
        menuArquivo.add(arqSair);
        barra.add(menuArquivo);
        this.setJMenuBar(barra);

        this.setTitle("Minha primeira janela");
        this.setSize(640, 480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Lambda para o botão Teste (Múltiplas linhas de código usam chaves { })
        arqTeste.addActionListener(e -> {
            System.out.println("OK");
            JOptionPane.showMessageDialog(null,
                    "Você escolheu: " + e.getActionCommand(),
                    "Teste", JOptionPane.PLAIN_MESSAGE);
        });

        // Lambda para o botão Sair (Linha única descarta as chaves e ponto-e-vírgula interno)
        arqSair.addActionListener(e -> System.exit(0));

        // Boa prática: Deixar a janela visível apenas depois de configurar todos os elementos e listeners
        this.setVisible(true);
    }

    public static void main(String[] args) {
        // Padrão recomendado pelo Swing para iniciar a GUI de forma segura na thread correta
        SwingUtilities.invokeLater(() -> new JanelaSimplesModernoLambda());
    }
}
