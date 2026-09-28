package callbackseventoslisterners;

import javax.swing.*;
import java.awt.event.*;

public class JanelaSimplesClassico extends JFrame {
    public JanelaSimplesClassico() {
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
        this.setVisible(true);

        arqTeste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("OK");
                JOptionPane.showMessageDialog(null,
                        "Você escolheu: " + e.getActionCommand(),
                        "Teste", JOptionPane.PLAIN_MESSAGE);
            }
        });

        arqSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new JanelaSimplesClassico();
    }
}