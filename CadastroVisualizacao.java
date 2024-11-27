import javax.swing.*;
import java.awt.*;

public abstract class CadastroVisualizacao {
    protected final JFrame principal;

    public CadastroVisualizacao(JFrame principal) {
        this.principal = principal;
    }

    public abstract void exibir();
}