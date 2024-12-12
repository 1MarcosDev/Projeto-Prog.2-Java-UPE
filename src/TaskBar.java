import javax.swing.*;
import java.awt.event.ActionListener;

public class TaskBar {
    private JButton tarefaButton;
    private JPanel mainPanel;
    private int index;

    public TaskBar(ScreenHandler screen) {
        this.tarefaButton.setText("Tarefa " + this.index);

        tarefaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screen.changeTaskBar(index);
                screen.updateTaskBar();
            }
        });
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setName(String name) {
        this.tarefaButton.setText(name);
    }

    public void hightLight() {
        this.tarefaButton.setContentAreaFilled(true);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
