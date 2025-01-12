package Maze;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class  Maze extends JPanel implements ActionListener {

    private int row = 7;
    private int col = 10;
    private int currLevel[][] = {{5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
            {4, 0, 0, 0, 0, 0, 0, 6, 3, 4},
            {4, 7, 4, 4, 7, 7, 0, 0, 4, 4},
            {4, 7, 4, 6, 7, 7, 0, 0, 9, 4},
            {4, 7, 7, 3, 4, 7, 0, 4, 4, 4},
            {4, 7, 0, 0, 0, 0, 0, 0, 0, 1},
            {4, 4, 4, 2, 2, 2, 4, 4, 4, 4}};
    private int level1[][] = {{5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
            {4, 0, 0, 0, 0, 0, 0, 6, 3, 4},
            {4, 7, 4, 4, 7, 7, 0, 0, 4, 4},
            {4, 7, 4, 6, 7, 7, 0, 0, 9, 4},
            {4, 7, 7, 3, 4, 7, 0, 4, 4, 4},
            {4, 7, 0, 0, 0, 0, 0, 0, 0, 1},
            {4, 4, 4, 2, 2, 2, 4, 4, 4, 4}};

    private JLabel pics[] = new JLabel[row * col];
    private int sqDimension = 61;
    private String picStart = "sc";
    private String picFileType = ".png";
    private String characterPic = "c1.png";
    private String blankPic = "sc0.png";
    private String diamondPic = "sc8.png";

    private boolean key = false;
    private int coins = 0;
    private int diamonds = 0;
    private JLabel score;
    private JLabel feedback;
    private int x = 1;
    private int y = 1;
    private int lvl = 1;

    public Maze() {

        // frame.setSize(660, 520); //set in main class

        JPanel gridP = new JPanel(new GridLayout(row, col));
        gridP.setBackground(new Color(150, 235, 194));
        int m = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                pics[m] = new JLabel(createImageIcon(picStart + currLevel[i][j] + picFileType));
                pics[m].setPreferredSize(new Dimension(sqDimension, sqDimension));
                gridP.add(pics[m]);
                m++;
            }
        }
        add(gridP);
        score = new JLabel("You have " + coins + "/10 coins + " + diamonds + "/4 diamonds + key? " + key);
        score.setPreferredSize(new Dimension(300, 20));
        add(score);
        pics[x * col + y].setIcon(createImageIcon(characterPic));

        JButton up = new JButton("up");
        up.setActionCommand("up");
        up.addActionListener(this);
        JButton left = new JButton("left");
        left.setActionCommand("left");
        left.addActionListener(this);
        JButton down = new JButton("down");
        down.setActionCommand("down");
        down.addActionListener(this);
        JButton right = new JButton("right");
        right.setActionCommand("right");
        right.addActionListener(this);
        JButton next = new JButton("next");
        next.setActionCommand("next");
        next.setBackground(new Color(150, 235, 194));
        next.addActionListener(this);
        add(up);
        add(down);
        add(left);
        add(right);
        add(next);
        feedback = new JLabel("Click on the buttons to move.");
        add(feedback);
    }

    /*public void Maze1() {

        // frame.setSize(660, 520); //set in main class

        JPanel gridP = new JPanel(new GridLayout(row, col));
        gridP.setBackground(new Color(150, 235, 194));
        int m = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                pics[m] = new JLabel(createImageIcon(picStart + currLevel[i][j] + picFileType));
                pics[m].setPreferredSize(new Dimension(sqDimension, sqDimension));
                gridP.add(pics[m]);
                m++;
            }
        }
        add(gridP);
        score = new JLabel("You have " + coins + "/10 coins + " + diamonds + "/2 diamonds + key? " + key);
        score.setPreferredSize(new Dimension(300, 20));
        add(score);
        pics[x * col + y].setIcon(createImageIcon(characterPic));

        JButton up = new JButton("up");
        up.setActionCommand("up");
        up.addActionListener(this);
        JButton left = new JButton("left");
        left.setActionCommand("left");
        left.addActionListener(this);
        JButton down = new JButton("down");
        down.setActionCommand("down");
        down.addActionListener(this);
        JButton right = new JButton("right");
        right.setActionCommand("right");
        right.addActionListener(this);
        JButton next = new JButton("next");
        next.setActionCommand("next");
        next.setBackground(new Color(150, 235, 194));
        next.addActionListener(this);
        add(up);
        add(down);
        add(left);
        add(right);
        add(next);
        feedback = new JLabel("Click on the buttons to move.");
        add(feedback);
    }

     */

    public void move(int newx, int newy, String dir) {


        feedback.setText("OK! Moving " + dir + ".");
        pics[x * col + y].setIcon(createImageIcon(blankPic));
        x = newx;
        y = newy;
        pics[x * col + y].setIcon(createImageIcon(characterPic));
    }

    public void showDiamonds() {

        currLevel[1][1] = 8;
        currLevel[5][3] = 8;
        pics[1 * col + 1].setIcon(createImageIcon(diamondPic));
        pics[5 * col + 3].setIcon(createImageIcon(diamondPic));
    }

    public void copyOver(int a[][], int c[][]) {

        int m = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                a[i][j] = c[i][j];
                pics[m].setIcon(createImageIcon(picStart + currLevel[i][j] + picFileType));
                m++;
            }
        }
        x = 1;
        y = 1;
        coins = 0;
        diamonds = 0;
        key = false;
        pics[x * col + y].setIcon(createImageIcon(characterPic));
        JOptionPane.showMessageDialog(null, "New Level begins.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /*if (e.getActionCommand().equals("next")) {
            Maze1();
        }

         */
        // Up direction
        if (e.getActionCommand().equals("up")) {
            if (x-1 >= row)
                feedback.setText("Off the board!");
            else if (currLevel[x-1][y]==0)
                move(x-1,y,"up");
            else if (currLevel[x-1][y]==7) {
                move(x - 1, y, "up");
                coins++;
                currLevel[x][y]=0;
            }
            else if (currLevel[x-1][y]==6) {
                if (key==true)
                    currLevel[x-1][y]=8;
                else
                    feedback.setText("need key");
            }
            else if (currLevel[x-1][y]==8) {
                move(x - 1, y, "up");
                diamonds++;
                currLevel[x][y]=0;
            }
            else if (currLevel[x-1][y]==9) {
                move(x - 1, y, "up");
                key=true;
                showDiamonds();
                currLevel[x][y]=0;
            }
            else
                feedback.setText("There is a wall.");
        }
        // Down direction
        else if (e.getActionCommand().equals("down")) {
            if (x+1 >= row)
                feedback.setText("Off the board!");
            else if (currLevel[x+1][y]==0)
                move(x+1,y,"down");
            else if (currLevel[x+1][y]==7) {
                move(x + 1, y, "down");
                coins++;
                currLevel[x][y]=0;
            }
            else if (currLevel[x+1][y]==9) {
                move(x + 1, y, "down");
                key=true;
                showDiamonds();
                currLevel[x][y]=0;
            }
            else if (currLevel[x+1][y]==6) {
                if (key==true)
                    currLevel[x+1][y]=8;
                else feedback.setText("need key");
            }
            else if (currLevel[x+1][y]==8) {
                move(x + 1, y, "down");
                diamonds++;
                currLevel[x][y]=0;
            }
            else
                feedback.setText("There is a wall.");
        }
        // Right direction
        else if (e.getActionCommand().equals("right")) {
            if (y+1 >= col)
                feedback.setText("Off the board!");
            else if (currLevel[x][y+1]==0)
                move(x,y+1,"right");
            else if (currLevel[x][y+1]==7) {
                move(x, y+1, "right");
                coins++;
                currLevel[x][y]=0;
            }
            else if (currLevel[x][y+1]==9) {
                move(x, y+1, "right");
                key=true;
                showDiamonds();
                currLevel[x][y]=0;
            }
            else if (currLevel[x][y+1]==6) {
                if (key==true)
                    currLevel[x][y+1]=8;
                else feedback.setText("need key");
            }
            else if (currLevel[x][y+1]==8) {
                move(x, y+1, "right");
                diamonds++;
                currLevel[x][y]=0;
            }
            else
                feedback.setText("There is a wall.");
        }
        // Left direction
        else if (e.getActionCommand().equals("left")) {
            if (y-1 >= col)
                feedback.setText("Off the board!");
            else if (currLevel[x][y-1]==0)
                move(x,y-1,"left");
            else if (currLevel[x][y-1]==7) {
                move(x, y-1, "left");
                coins++;
                currLevel[x][y]=0;
            }
            else if (currLevel[x][y-1]==9) {
                move(x, y-1, "left");
                key=true;
                showDiamonds();
                currLevel[x][y]=0;
            }
            else if (currLevel[x][y-1]==6) {
                if (key==true)
                    currLevel[x][y-1]=8;
                else feedback.setText("need key");
            }
            else if (currLevel[x][y-1]==8) {
                move(x, y-1, "left");
                diamonds++;
                currLevel[x][y]=0;
            }
            else
                feedback.setText("There is a wall.");
        }
        score.setText("You have " + coins + "/10 coins + " + diamonds + "/2 diamonds + key? " + key);

    }

    protected static ImageIcon createImageIcon(String path) {

        java.net.URL imgURL = Maze.class.getResource(path);
        if (imgURL != null)
            return new ImageIcon(imgURL);
        else
            return null;
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Maze");
        frame.setSize(770, 530);         //resizes JFrame pane size
        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Maze panel = new Maze();
        panel.setOpaque(true);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
