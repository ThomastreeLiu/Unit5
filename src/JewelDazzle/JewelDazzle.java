package JewelDazzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JewelDazzle extends JPanel implements ActionListener{

    private int row = 4;
    private int col = 5;
    private int button[][] = {
            {1, 2, 3, 2, 1},
            {2, 6, 4, 4, 2},
            {2, 5, 4, 5, 2},
            {1, 2, 3, 2, 1},
    };
    JLabel pics[] = new JLabel [row * col];

    private int sqDimension = 128;
    private String picStart = "sd";
    private String picFileType = ".png";

    public JewelDazzle(){
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

        java.net.URL imgURL = JewelDazzle.class.getResource(path);
        if(imgURL != null)
            return new ImageIcon(imgURL);
        else
            return null;
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("BasicGrid");
        frame.setSize(650, 530);         //resizes JFrame pane size
        frame.setBackground(Color.PINK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JewelDazzle panel = new JewelDazzle();
        panel.setOpaque(true);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}