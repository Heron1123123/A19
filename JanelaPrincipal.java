
// Classe que gerencia a janela principal
class JanelaPrincipal {
    private JFrame frame;
    private String versaoSistema;
    private String nomeUsuario;

    public JanelaPrincipal(String versaoSistema, String nomeUsuario) {
        this.versaoSistema = versaoSistema;
        this.nomeUsuario = nomeUsuario;
        frame = new JFrame("Sistema Pessoa");
    }

    public void iniciar() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        String dataAcesso = dateFormat.format(new Date());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        MenuSistema menuSistema = new MenuSistema(frame);
        JPanel painelRodape = new PainelRodape(versaoSistema, nomeUsuario, dataAcesso);

        frame.getContentPane().add(BorderLayout.NORTH, menuSistema.getMenuBar());
        frame.getContentPane().add(BorderLayout.CENTER, new JTextArea());
        frame.getContentPane().add(BorderLayout.SOUTH, painelRodape);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
