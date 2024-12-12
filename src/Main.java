import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ScreenHandler screen = new ScreenHandler();
        AppGui app = new AppGui(screen);

        JFrame window = new JFrame("ToDo List");
        window.setContentPane(app.getMainGui());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setMinimumSize(new Dimension(500, 500));
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}