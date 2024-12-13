package StarWars;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StarWars extends JPanel implements ActionListener{

    private int row = 9;
    private int col = 5;
    private int button[][] = {
            {3, 3, 4, 4, 5, 4, 4, 3, 3},
            {3, 1, 1, 1, 2, 1, 1, 1, 3},
            {1, 1, 5, 2, 6, 2, 5, 1, 1},
            {3, 1, 1, 1, 2, 1, 1, 1, 3},
            {3, 3, 4, 4, 5, 4, 4, 3, 3},
    };
    JLabel pics[] = new JLabel [row * col];

    private int sqDimension = 64;
    private String picStart = "sw";
    private String picFileType = ".png";

    public StarWars(){
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

        java.net.URL imgURL = StarWars.class.getResource(path);
        if(imgURL != null)
            return new ImageIcon(imgURL);
        else
            return null;
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("BasicGrid");
        frame.setSize(600, 350);         //resizes JFrame pane size
        frame.setBackground(Color.PINK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StarWars panel = new StarWars();
        panel.setOpaque(true);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}