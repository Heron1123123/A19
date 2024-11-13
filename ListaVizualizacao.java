// Classe que gerencia as janelas de visualização de listas
class ListaVisualizacao {
    private String titulo;
    private JFrame parentFrame;

    public ListaVisualizacao(String titulo, JFrame parentFrame) {
        this.titulo = titulo;
        this.parentFrame = parentFrame;
    }

    public void exibir() {
        JDialog dialog = new JDialog(parentFrame, titulo, true);
        dialog.setSize(750, 650);
        dialog.setLayout(new BorderLayout());

        dialog.add(new JLabel(titulo, SwingConstants.CENTER), BorderLayout.NORTH);
        dialog.add(new JTextArea("Exemplo de lista..."), BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dialog.setVisible(false));
        dialog.add(btnFechar, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
    }
}