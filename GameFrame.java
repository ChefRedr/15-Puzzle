import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

    private JPanel panel = new JPanel();
    private final int PANEL_WIDTH = 600;
    private final int PANEL_HEIGHT = 600;
    
    public GameFrame() {
        setTitle("15 Puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        
        add(panel);
        pack();
        setVisible(true);
    }
}
