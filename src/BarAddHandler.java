import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarAddHandler implements ActionListener {
    private final ScreenHandler screen;
    private final JTextField input;

    public BarAddHandler(JTextField input, ScreenHandler screenHandler) {
        this.screen = screenHandler;
        this.input = input;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!this.input.getText().isEmpty()) {
            System.out.printf("[DEBUG] Task Bar %s added\n", this.input.getText());
            this.screen.addTaskBar(this.input.getText());
            this.input.setText("");
        } else {
            System.out.println("[DEBUG] No Task Bar founded found");
        }
    }
}
