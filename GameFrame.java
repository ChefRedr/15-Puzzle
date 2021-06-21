import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

    private JPanel panel = new JPanel();
    private final int PANEL_LENGTH = 600;
    private final int TILE_SIZE = PANEL_LENGTH/4;
    private JButton[] tilePieces = new JButton[16];
    
    public GameFrame() {
        setTitle("15 Puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setPreferredSize(new Dimension(PANEL_LENGTH, PANEL_LENGTH));
        panel.setLayout(null);

        //initialize tiles
        for(int i=0; i<tilePieces.length-1; ++i) {
            tilePieces[i] = new JButton();
            tilePieces[i].setFocusable(false);
            tilePieces[i].setFont(new Font("Ariel", Font.BOLD, 75));
            String randomInt = String.valueOf((int) (Math.random() * 15));
            tilePieces[i].setText(randomInt);
            tilePieces[i].setBounds(i%4 * TILE_SIZE, ((i*TILE_SIZE)/PANEL_LENGTH)*TILE_SIZE, TILE_SIZE, TILE_SIZE);
            panel.add(tilePieces[i]);
        }

        add(panel);
        pack();
        setVisible(true);
    }

}
