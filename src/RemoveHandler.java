import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveHandler implements ActionListener {
    private final ScreenHandler screen;
    private final Task task;

    public RemoveHandler(ScreenHandler screenHandler, Task task) {
        this.screen = screenHandler;
        this.task = task;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.screen.removeTask(this.task.getIndex());
    }
}
