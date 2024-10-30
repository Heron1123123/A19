import javax.swing.*; 
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// Classe principal do sistema
public class SistemaPessoa {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SistemaPessoa::criarInterface);
    }

    private static void criarInterface() {
        // Cria o frame principal
        JFrame principal = new JFrame("Sistema Pessoa");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(800, 800);

        // Adiciona componentes ao frame
        principal.setJMenuBar(new MenuPrincipal().criarMenu());
        principal.getContentPane().add(BorderLayout.CENTER, new JTextArea());
        principal.getContentPane().add(BorderLayout.SOUTH, new Rodape().criarRodape());

        principal.setLocationRelativeTo(null); // Centraliza a janela
        principal.setVisible(true); // Torna a janela visível
    }
}

// Classe para o menu principal
class MenuPrincipal {
    public JMenuBar criarMenu() {
        JMenuBar menuPrincipal = new JMenuBar();

        // Cria e adiciona as opções horizontais do menu principal
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenu menuSair = new JMenu("Sair");

        // Adiciona opções ao menu de cadastro
        menuCadastro.add(new JMenuItem("Usuários"));
        menuCadastro.add(new JMenuItem("Pessoas"));

        // Adiciona opções ao menu de visualização
        menuVisualizacao.add(new JMenuItem("Lista de usuários"));
        menuVisualizacao.add(new JMenuItem("Lista de pessoas"));

        // Cria a opção de "Sair" no menu principal
        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            @Override
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0); // Sai do sistema
            }
            @Override
            public void menuDeselected(javax.swing.event.MenuEvent e) {}
            @Override
            public void menuCanceled(javax.swing.event.MenuEvent e) {}
        });

        // Adiciona os menus à barra de menu
        menuPrincipal.add(menuCadastro);
        menuPrincipal.add(menuVisualizacao);
        menuPrincipal.add(menuSair);

        return menuPrincipal;
    }
}

// Classe para o rodapé
class Rodape {
    public JPanel criarRodape() {
        // Constantes e variáveis para informações do rodapé
        final String versaoSistema = "12.1.2024";
        String nomeUsuario = "denys.silva";
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        String dataAcesso = dateFormat.format(new Date());

        // Cria painel e label do rodapé
        JPanel painelRodape = new JPanel();
        JLabel labelRodape = new JLabel("Versão: " + versaoSistema + "               Usuário: " + nomeUsuario + "               Data de acesso: " + dataAcesso);
        painelRodape.add(labelRodape); // Components Added using Flow Layout

        return painelRodape;
    }
}
