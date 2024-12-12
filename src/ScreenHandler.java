import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ScreenHandler {
    private JPanel mainPanel;
    private JPanel barPanel;
    private AppGui gui;
    List<List<Task>> tasks = new ArrayList<>();
    List<String> taskNames = new ArrayList<>();
    private int taskIndex = 0;
    //public List<Task> taskList = new ArrayList<Task>();

    public void setGui(AppGui gui) {
        this.gui = gui;
        this.mainPanel = this.gui.getMainPanel();
        this.barPanel = this.gui.getBarPanel();
        this.tasks.add(new ArrayList<>());
        this.taskNames.add("Minha Lista");
        this.updateTaskBar();
    }

    public JPanel getMain() {
        return this.gui.getMainPanel();
    }

    public String getInputText() {
        return this.gui.getInput().getText();
    }

    public void clearInput() {
        System.out.println("[DEBUG] Input cleared");
        this.gui.getInput().setText("");
    }

    public void updateTaskList() {
        System.out.println("[DEBUG] Task list updated");
        int i = 0;
        for (Task task : this.tasks.get(taskIndex)) {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = i;
            task.setIndex(i);
            this.mainPanel.add(task.getTaskPanel(), gbc);
            i++;
        }
        this.mainPanel.revalidate();
        this.mainPanel.repaint();
    }

    public void updateTaskBar() {
        this.barPanel.removeAll();
        System.out.println("[DEBUG] Task bar updated");
        int i = 0;
        for (List<Task> task : this.tasks) {
            TaskBar taskBar = new TaskBar(this);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = i;
            taskBar.setIndex(i);
            taskBar.setName(this.taskNames.get(i));
            if (i == taskIndex) {
                taskBar.hightLight();
            }
            this.barPanel.add(taskBar.getMainPanel(), gbc);
            i++;
        }
        this.mainPanel.removeAll();
        this.updateTaskList();
        this.mainPanel.revalidate();
        this.mainPanel.repaint();
    }

    public void changeTaskBar(int index) {
        System.out.printf("[DEBUG] Task bar changed to %d\n", index);
        taskIndex = index;
        updateTaskList();
    }

    public void addTask(String taskName) {
        this.tasks.get(taskIndex).add(new Task(taskName, this));
        updateTaskList();
    }

    public void removeTask(int index) {
        System.out.println("[DEBUG] Task removed");
        this.tasks.get(taskIndex).remove(index);
        this.mainPanel.removeAll();
        updateTaskList();
    }

    public void addTaskBar(String taskName) {
        this.tasks.add(new ArrayList<>());
        this.taskNames.add(taskName);
        this.updateTaskBar();
    }

    public void removeTaskBar() {
        System.out.println("[DEBUG] Task bar removed");
        if (this.tasks.size() > 1 && taskIndex != 0) {
            int oldTaskIndex = taskIndex;
            int oldTasksSize = this.tasks.size();
            this.tasks.remove(taskIndex);
            this.taskNames.remove(taskIndex);

            if (oldTaskIndex+1 >= oldTasksSize) {
                taskIndex--;
            } else {
                taskIndex = oldTaskIndex;
            }

            this.updateTaskBar();
        } else {
            System.out.println("[DEBUG] There is only one task bar");
        }
    }
}
