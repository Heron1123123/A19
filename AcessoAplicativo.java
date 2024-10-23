import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcessoAplicativo extends JFrame {
   
    // Componentes da interface gráfica
    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private JButton botaoConfirmar;
    private JButton botaoCancelar;

    // Usuário e senha corretos
    private final String usuarioCorreto = "denys.silva";
    private final String senhaCorreta = "Teste@2024";

    public AcessoAplicativo() {
        super("Tela de Acesso");
        configurarJanela();
        inicializarComponentes();
    }

    // Configurações básicas da janela
    private void configurarJanela() {
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));  // Layout em grade 3x2 com espaçamento
    }

    // Inicializa os componentes da GUI
    private void inicializarComponentes() {
        // Labels e campos de texto
        JLabel labelUsuario = new JLabel("Usuário:");
        campoUsuario = new JTextField();
       
        JLabel labelSenha = new JLabel("Senha:");
        campoSenha = new JPasswordField();

        // Botões
        botaoConfirmar = new JButton("Confirmar");
        botaoCancelar = new JButton("Cancelar");

        // Adiciona ação ao botão Confirmar
        botaoConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarAcesso();
            }
        });

        // Adiciona ação ao botão Cancelar
        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharJanela();
            }
        });

        // Adiciona os componentes na janela
        add(labelUsuario);
        add(campoUsuario);
        add(labelSenha);
        add(campoSenha);
        add(botaoConfirmar);
        add(botaoCancelar);
    }

    // Verifica se o acesso está correto
    private void verificarAcesso() {
        String usuario = campoUsuario.getText();
        String senha = new String(campoSenha.getPassword());

        if (usuario.equals(usuarioCorreto) && senha.equals(senhaCorreta)) {
            JOptionPane.showMessageDialog(this, "Acesso confirmado!");
            fecharJanela();
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha inválido!");
        }
    }

    // Fecha a janela
    private void fecharJanela() {
        dispose();
    }

    // Método principal para iniciar o programa
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AcessoAplicativo().setVisible(true);
        });
    }
}