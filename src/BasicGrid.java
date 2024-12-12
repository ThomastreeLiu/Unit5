
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class BasicGrid extends JPanel implements ActionListener{

    private int row = 6;
    private int col = 7;
    private int button[][] = {{0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}};
    JLabel pics[] = new JLabel [row * col];

    private int sqDimension = 68;
    private String picStart = "c";
    private String picFileType = ".png";

    public BasicGrid(){

        //frame.resize (560, 460); //needs to be set in the main class
        setBackground(Color.pink);
        JPanel gridP = new JPanel(new GridLayout(row, col));
        int m = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){

                pics [m] = new JLabel(createImageIcon(picStart + button[i][j]+ picFileType));
                pics [m].setPreferredSize(new Dimension(sqDimension,sqDimension));
                gridP.add(pics[m]);
                m++;
            }
        }
        add(gridP);

    }

    @Override
    public void actionPerformed(ActionEvent e){


    }

    protected static ImageIcon createImageIcon(String path){

        java.net.URL imgURL = BasicGrid.class.getResource(path);
        if(imgURL != null)
            return new ImageIcon(imgURL);
        else
            return null;
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("BasicGrid");
        frame.setSize(560, 460);         //resizes JFrame pane size
        frame.setBackground(Color.PINK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BasicGrid panel = new BasicGrid();
        panel.setOpaque(true);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}