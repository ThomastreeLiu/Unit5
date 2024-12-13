package FarmHeros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FarmHeros extends JPanel implements ActionListener{
    private int button[][] = {
            {3, 0, 0, 3, 3, 3, 3},
            {3, 6, 6, 6, 6, 1, 0},
            {3, 6, 4, 4, 4, 1, 2},
            {3, 6, 4, 5, 4, 1, 2},
            {0, 6, 4, 4, 4, 1, 2},
            {0, 1, 1, 1, 1, 1, 2}
    };
    private int row = 6;
    private int col = 7;

    JLabel pics[] = new JLabel [row * col];

    private int sqDimension = 68;
    private String picStart = "c";
    private String picFileType = ".png";

    public FarmHeros(){
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

        java.net.URL imgURL = FarmHeros.class.getResource(path);
        if(imgURL != null)
            return new ImageIcon(imgURL);
        else
            return null;
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("FarmHeros");
        frame.setSize(560, 460);         //resizes JFrame pane size
        frame.setBackground(Color.PINK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FarmHeros panel = new FarmHeros();
        panel.setOpaque(true);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}