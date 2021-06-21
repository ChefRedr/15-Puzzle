import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {

    private JPanel panel = new JPanel();
    private final int PANEL_LENGTH = 600;
    private final int TILE_SIZE = PANEL_LENGTH/4;
    private JButton[] tilePieces = new JButton[16];
    
    public GameFrame() {
        setTitle("15 Puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        panel.setPreferredSize(new Dimension(PANEL_LENGTH, PANEL_LENGTH));
        panel.setLayout(null);

        //initialize tiles
        for(int i = 0; i < tilePieces.length; ++i) {
            tilePieces[i] = new JButton();
            tilePieces[i].setFocusable(false);
            tilePieces[i].addActionListener(this);
            tilePieces[i].setFont(new Font("Ariel", Font.BOLD, 75));
            if(i == 15) { tilePieces[i].setEnabled(false); }
            else { tilePieces[i].setText(""+(i+1)); }
        }

        shuffleTiles();

        for(int i = 0; i < tilePieces.length; ++i) {
            tilePieces[i].setBounds(i%4 * TILE_SIZE, ((i*TILE_SIZE)/PANEL_LENGTH)*TILE_SIZE, TILE_SIZE, TILE_SIZE);
            panel.add(tilePieces[i]);
        }

        add(panel);
        pack();
        setVisible(true);
    }

    private void shuffleTiles() {
        int len = tilePieces.length-1;
        for(int i = 0; i < len; ++i) {
            int randomIndex = (int) (Math.random() * (len-1));
            swap(i, randomIndex);
        }
    }

    private void moveTile(int tileIndex) {
        int surroundingIndex = 0;
        for(int i = 0; i < 4; ++i) {
            switch(i) {
                case 0:
                    surroundingIndex = tileIndex - 4;
                    break;
                case 1:
                    surroundingIndex = tileIndex - 1;
                    break;
                case 2:
                    surroundingIndex = tileIndex + 1;
                    break;
                case 3:
                    surroundingIndex = tileIndex + 4;
                    break;
            }
            try {
                if(!tilePieces[surroundingIndex].isEnabled()) {
                    swap(tileIndex, surroundingIndex);
                    break;
                }
            } catch(IndexOutOfBoundsException e) {}
        }
    }

    private void swap(int indexA, int indexB) {
        JButton temp = tilePieces[indexA];
        tilePieces[indexA] = tilePieces[indexB];
        tilePieces[indexB] = temp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = 0;
        for(int i = 0; i < tilePieces.length; ++i) {
            if(tilePieces[i] == e.getSource()) { index = i; break; }
        }
        moveTile(index);
        
        for(int i = 0; i < tilePieces.length; ++i) {
            tilePieces[i].setBounds(i%4 * TILE_SIZE, ((i*TILE_SIZE)/PANEL_LENGTH)*TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }
    }

}