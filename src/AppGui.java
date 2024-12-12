import javax.swing.*;

public class AppGui {
    private JPanel mainGui;
    private JButton adicionarButton;
    private JTextField input;
    private JLabel Titulo;
    private JPanel Main;
    private JPanel Adicionar;
    private JButton rTaskBarButton;
    private JButton aTaskBar;
    private JPanel Lateral;
    private JPanel TaskBarPanel;
    private JTextField taskBarInput;

    public AppGui(ScreenHandler screen) {
        screen.setGui(this);
        adicionarButton.addActionListener(new AddHandler(input, screen));
        aTaskBar.addActionListener(new BarAddHandler(taskBarInput, screen));
        rTaskBarButton.addActionListener(new BarRemoveHandler(screen));
    }

    public JPanel getMainGui() {
        return mainGui;
    }

    public JPanel getMainPanel() {
        return Main;
    }

    public JTextField getInput() {
        return input;
    }

    public JPanel getBarPanel() {
        return TaskBarPanel;
    }
}
