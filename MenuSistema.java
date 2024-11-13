
// Classe que gerencia a criação e configuração do menu
class MenuSistema {
    private JMenuBar menuBar;
    private JFrame parentFrame;

    public MenuSistema(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        menuBar = new JMenuBar();
        configurarMenu();
    }

    private void configurarMenu() {
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenu menuSair = new JMenu("Sair");

        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0);
            }
            public void menuDeselected(javax.swing.event.MenuEvent e) {}
            public void menuCanceled(javax.swing.event.MenuEvent e) {}
        });

        JMenuItem itemCadastroUsuarios = new JMenuItem("Usuários");
        JMenuItem itemCadastroPessoas = new JMenuItem("Pessoas");
        itemCadastroUsuarios.addActionListener(e -> new FormularioCadastro("Cadastro de Usuários", parentFrame).exibir());
        itemCadastroPessoas.addActionListener(e -> new FormularioCadastro("Cadastro de Pessoa", parentFrame).exibir());

        menuCadastro.add(itemCadastroUsuarios);
        menuCadastro.add(itemCadastroPessoas);

        JMenuItem itemListaUsuarios = new JMenuItem("Lista de usuários");
        JMenuItem itemListaPessoas = new JMenuItem("Lista de pessoas");
        itemListaUsuarios.addActionListener(e -> new ListaVisualizacao("Lista de Usuários", parentFrame).exibir());
        itemListaPessoas.addActionListener(e -> new ListaVisualizacao("Lista de Pessoas", parentFrame).exibir());

        menuVisualizacao.add(itemListaUsuarios);
        menuVisualizacao.add(itemListaPessoas);

        menuBar.add(menuCadastro);
        menuBar.add(menuVisualizacao);
        menuBar.add(menuSair);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
}