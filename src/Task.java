import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

public class Task {
    private JButton tarefaButton;
    private JButton removerButton;
    private JPanel TaskPanel;
    private int index;
    private Boolean checked = false;

    public Task(String taskName, ScreenHandler screen) {
        tarefaButton.setText(taskName);
        TaskPanel.revalidate();
        TaskPanel.repaint();
        removerButton.addActionListener(new RemoveHandler(screen, this));

        tarefaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checked = !checked;
                Font font = tarefaButton.getFont();
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.STRIKETHROUGH, checked);
                tarefaButton.setFont(font.deriveFont(attributes));
                tarefaButton.setContentAreaFilled(checked);
            }
        });
    }

    public void setIndex(int index) {
        this.index = index;
        System.out.println(tarefaButton.getText());
        System.out.println(index);
    }

    public int getIndex() {
        return index;
    }

    public JPanel getTaskPanel() {
        return TaskPanel;
    }
}
