import java.awt.*;
import javax.swing.*;

public class SistemaPessoa {

    public static void main(String[] args) {
        // Create the main window (JFrame)
        JFrame mainWindow = new JFrame("Sistema de Pessoa");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(600, 400);
        mainWindow.setLocationRelativeTo(null); // Center the window

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create main menus
        JMenu cadastroMenu = new JMenu("Cadastro");
        JMenu visualizacaoMenu = new JMenu("Visualização");
        JMenu sairMenu = new JMenu("Sair");

        // Create sub-menu items for "Cadastro"
        JMenuItem usuariosItem = new JMenuItem("Usuários");
        JMenuItem pessoasItem = new JMenuItem("Pessoas");
        cadastroMenu.add(usuariosItem);
        cadastroMenu.add(pessoasItem);

        // Create sub-menu items for "Visualização"
        JMenuItem listaUsuariosItem = new JMenuItem("Lista de Usuário");
        JMenuItem listaPessoasItem = new JMenuItem("Lista de Pessoas");
        visualizacaoMenu.add(listaUsuariosItem);
        visualizacaoMenu.add(listaPessoasItem);

        // Add action to "Sair" menu to exit the application
        sairMenu.addMenuListener(new javax.swing.event.MenuListener() {
            @Override
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0); // Exit the program when "Sair" is clicked
            }

            @Override
            public void menuDeselected(javax.swing.event.MenuEvent e) {}

            @Override
            public void menuCanceled(javax.swing.event.MenuEvent e) {}
        });

        // Add menus to the menu bar
        menuBar.add(cadastroMenu);
        menuBar.add(visualizacaoMenu);
        menuBar.add(sairMenu);

        // Set the menu bar to the window
        mainWindow.setJMenuBar(menuBar);

        // Create a panel to simulate content display
        JPanel contentPanel = new JPanel(new BorderLayout());
        mainWindow.add(contentPanel, BorderLayout.CENTER);

        // Create footer information
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        footerPanel.add(new JLabel("Versão: 12.1.2024  "));
        footerPanel.add(new JLabel("Usuário: denys.silva  "));
        footerPanel.add(new JLabel("Data de acesso: 20/09/2024 10:58"));
        mainWindow.add(footerPanel, BorderLayout.SOUTH);

        // Make the main window visible
        mainWindow.setVisible(true);
    }
}
