// Classe que gerencia os formulários de cadastro
class FormularioCadastro {
    private String titulo;
    private JFrame parentFrame;

    public FormularioCadastro(String titulo, JFrame parentFrame) {
        this.titulo = titulo;
        this.parentFrame = parentFrame;
    }

    public void exibir() {
        JDialog dialog = new JDialog(parentFrame, titulo, true);
        dialog.setSize(600, 300);
        dialog.setLayout(new BorderLayout());

        JLabel labelTitulo = new JLabel(titulo, SwingConstants.CENTER);
        dialog.add(labelTitulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(7, 2, 5, 5));
        if (titulo.contains("Usuários")) {
            configurarCamposUsuarios(painelCampos);
        } else {
            configurarCamposPessoas(painelCampos);
        }

        JPanel painelBotoes = criarPainelBotoes(dialog);
        dialog.add(painelCampos, BorderLayout.CENTER);
        dialog.add(painelBotoes, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
    }

    private void configurarCamposUsuarios(JPanel painelCampos) {
        painelCampos.add(new JLabel("Usuário:"));
        painelCampos.add(new JTextField(25));
        painelCampos.add(new JLabel("Senha:"));
        painelCampos.add(new JPasswordField(15));
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(new JTextField(30));
        painelCampos.add(new JLabel("Ativo:"));
        painelCampos.add(new JRadioButton());
    }

    private void configurarCamposPessoas(JPanel painelCampos) {
        painelCampos.add(new JLabel("Nome:"));
        painelCampos.add(new JTextField(40));
        painelCampos.add(new JLabel("Endereço:"));
        painelCampos.add(new JTextField(60));
        painelCampos.add(new JLabel("Cidade:"));
        painelCampos.add(new JTextField(40));
        painelCampos.add(new JLabel("UF:"));
        painelCampos.add(new JTextField(2));
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(new JTextField(30));
        painelCampos.add(new JLabel("Telefone:"));
        painelCampos.add(new JTextField(20));
        painelCampos.add(new JLabel("Sexo:"));
        painelCampos.add(new JComboBox<>(new String[]{"Masculino", "Feminino"}));
    }

    private JPanel criarPainelBotoes(JDialog dialog) {
        JPanel painelBotoes = new JPanel(new FlowLayout());
        String[] labels = {"Incluir", "Alterar", "Excluir", "Consultar", "Cancelar", "Sair"};
        for (String label : labels) {
            JButton button = new JButton(label);
            button.addActionListener(e -> {
                if (label.equals("Sair")) {
                    dialog.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(dialog, "Botão " + label + " clicado!");
                }
            });
            painelBotoes.add(button);
        }
        return painelBotoes;
    }
}