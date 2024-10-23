import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        // Add action to "Usuários" menu item to open the user registration window
        usuariosItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openUserRegistrationWindow();
            }
        });
        // Make the main window visible
        mainWindow.setVisible(true);
    }
    // Method to open the User Registration Window
    private static void openUserRegistrationWindow() {
        // Create a new JFrame for the "Cadastro de Usuários" window
        JFrame userWindow = new JFrame("Cadastro de Usuários");
        userWindow.setSize(400, 300);
        userWindow.setLocationRelativeTo(null);
        // Create a panel for user registration form
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // Create form components
        JLabel userLabel = new JLabel("Usuário:");
        JTextField userField = new JTextField();
        JLabel passwordLabel = new JLabel("Senha:");
        JPasswordField passwordField = new JPasswordField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel activeLabel = new JLabel("Ativo:");
        JCheckBox activeCheckBox = new JCheckBox();
        // Add form components to the panel
        formPanel.add(userLabel);
        formPanel.add(userField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(activeLabel);
        formPanel.add(activeCheckBox);
        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        String[] buttons = {"Incluir", "Alterar", "Excluir", "Consultar", "Cancelar", "Sair"};
        for (String buttonName : buttons) {
            JButton button = new JButton(buttonName);
            buttonPanel.add(button);
            // Add action listener for each button
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (buttonName.equals("Sair")) {
                        userWindow.dispose(); // Close the registration window
                    } else {
                        JOptionPane.showMessageDialog(userWindow,
                                "Botão clicado! - " + buttonName,
                                "Informação",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });
        }
        // Add the form panel and button panel to the user window
        userWindow.add(formPanel, BorderLayout.CENTER);
        userWindow.add(buttonPanel, BorderLayout.SOUTH);
        // Make the user registration window visible
        userWindow.setVisible(true);
    }
}
