import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddHandler implements ActionListener {
    private final JTextField task;
    private final ScreenHandler screen;

    public AddHandler(JTextField task, ScreenHandler screenHandler) {
        this.screen = screenHandler;
        this.task = task;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!this.task.getText().isEmpty()) {
            System.out.printf("[DEBUG] Task %s added\n", this.task.getText());
            this.screen.addTask(this.task.getText());
            this.screen.clearInput();
        } else {
            System.out.println("[DEBUG] No task found");
        }
    }
}
