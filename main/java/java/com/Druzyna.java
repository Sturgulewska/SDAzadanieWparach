import javax.swing.*;
import java.awt.*;

public class Druzyna extends JFrame {

    public void startGui() {
        JFrame mainFrame = new JFrame("Druzyny");
        mainFrame.setMinimumSize(new Dimension(600, 300));
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.add(addMainPanel());
        mainFrame.setVisible(true);

    }

    private Component addMainPanel() {
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        return panel;

    }
}
