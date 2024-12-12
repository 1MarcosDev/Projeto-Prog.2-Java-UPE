import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gerenciador de Tarefas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        JPanel tarefasPanel = new JPanel();
        tarefasPanel.setLayout(new BoxLayout(tarefasPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(tarefasPanel);
        frame.add(scrollPane, BorderLayout.CENTER);

        JButton adicionarButton = new JButton("Adicionar Tarefa");
        frame.add(adicionarButton, BorderLayout.SOUTH);

        adicionarButton.addActionListener(new ActionListener() {
            private int contadorTarefas = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel novaTarefa = new JLabel("Tarefa " + contadorTarefas++);
                novaTarefa.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                tarefasPanel.add(novaTarefa);

                // Atualizar o painel para mostrar o novo componente
                tarefasPanel.revalidate();
                tarefasPanel.repaint();
            }
        });

        frame.setVisible(true);
    }
}