import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarRemoveHandler implements ActionListener {
    private final ScreenHandler screen;

    public BarRemoveHandler(ScreenHandler screenHandler) {
        this.screen = screenHandler;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.screen.removeTaskBar();
    }
}
