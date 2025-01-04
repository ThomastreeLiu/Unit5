import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sokoban extends JPanel implements ActionListener {

    private JPanel p_card;  //to hold all of the screens
    private JPanel card1, card2, card3, card4, card5;
    CardLayout cdLayout = new CardLayout();
    private JLabel feedBack;    //string to help you troubleshoot

    private int row = 9;
    private int col = 12;
    private JButton currplace[] = new JButton[row * col];
    private int currLevel[][] = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}};
    private JLabel arr[] = new JLabel[row * col];

    private char ground[][] = new char[row][col]; // 定义 ground 数组
    private char top[][] = new char[row][col];    // 定义 top 数组
    private int playerRow = 3;
    private int playerCol = 4;

    public Sokoban() {

        p_card = new JPanel();
        p_card.setLayout(cdLayout);
        screen1();
        screen2();
        screen3();
        screen4();
        screen5();
        setLayout(new BorderLayout());
        feedBack = new JLabel("Status String");    //feedback String for testing purposes
        add(BorderLayout.SOUTH, feedBack);
        add(BorderLayout.CENTER, p_card);
    }

    //screen 1 is set up
    public void screen1() {

        card1 = new JPanel();
        card1.setBackground(Color.WHITE);
        JLabel title = new JLabel("Welcome");
        JButton next = new JButton("Next");
        next.setActionCommand("screen2");
        next.addActionListener(this);
        card1.add(title);
        card1.add(next);
        p_card.add("1", card1);
    }

    //screen 2 is set up
    public void screen2() {

        card2 = new JPanel();
        card2.setBackground(Color.WHITE);
        JLabel title = new JLabel("Instructions");
        JButton next = new JButton("Next");
        next.setActionCommand("screen3");
        next.addActionListener(this);
        card2.add(title);
        card2.add(next);
        p_card.add("2", card2);
    }

    //screen 3 is set up
    public void screen3() {

        card3 = new JPanel();
        card3.setBackground(Color.WHITE);
        JLabel title = new JLabel("Free Form Game");
        JButton next = new JButton("Next");
        next.setActionCommand("screen4");
        next.addActionListener(this);

        //Set up grid
        JPanel pane = new JPanel(new GridLayout(row, col));
        int move = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //starter code you will need to adjust things to work
                arr[move] = new JLabel(createImageIcon(ground[i][j] + "" + top[i][j] + ".png"));
                arr[move].setPreferredSize(new Dimension(32, 32));
                pane.add(arr[move]);
                move++;
            }
        }

        arr[playerRow * col + playerCol].setIcon(createImageIcon(ground[playerRow][playerCol] + "down.png"));

        JButton up = new JButton("Up");
        up.setActionCommand("up");
        up.addActionListener(this);
        JButton down = new JButton("Down");
        down.setActionCommand("down");
        down.addActionListener(this);
        JButton right = new JButton("Right");
        right.setActionCommand("right");
        right.addActionListener(this);
        JButton left = new JButton("Left");
        left.setActionCommand("left");
        left.addActionListener(this);

        card3.add(title);
        card3.add(next);
        card3.add(pane);

        JPanel dir = new JPanel(new GridLayout(2, 3));
        JLabel filler = new JLabel("");
        JLabel filler2 = new JLabel("");
        dir.add(filler);
        dir.add(up);
        dir.add(filler2);

        dir.add(left);
        dir.add(down);
        dir.add(right);
        card3.add(dir);


        p_card.add("3", card3);
    }

    //screen 4 is set up
    public void screen4() {

        card4 = new JPanel();
        card4.setBackground(Color.YELLOW);
        JLabel title = new JLabel("You Win!");
        JButton next = new JButton("Next");
        next.setActionCommand("screen5");
        next.addActionListener(this);
        card4.add(title);
        card4.add(next);
        p_card.add("4", card4);
    }

    //screen 5 is set up
    public void screen5() {

        card5 = new JPanel();
        card5.setBackground(Color.CYAN);
        JLabel title = new JLabel("You Lose.");
        JButton next = new JButton("Back to Introduction?");
        next.setActionCommand("screen1");
        next.addActionListener(this);
        JButton end = new JButton("Quit?");
        end.setActionCommand("screen6");
        end.addActionListener(this);
        card5.add(title);
        card5.add(next);
        card5.add(end);
        p_card.add("5", card5);
    }

    //change the code to your class name
    protected static ImageIcon createImageIcon(String path) {

        java.net.URL imgURL = Sokoban.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public void redraw() {

        int move = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[move].setIcon(createImageIcon(ground[i][j] + "" + top[i][j] + ".png"));
                move++;
            }
        }

    }

    public void moveUp() {
        movePlayer(playerRow - 1, playerCol);
    }

    public void moveDown() {
        movePlayer(playerRow + 1, playerCol);
    }

    public void moveLeft() {
        movePlayer(playerRow, playerCol - 1);
    }

    public void moveRight() {
        movePlayer(playerRow, playerCol + 1);
    }

    private void movePlayer(int newRow, int newCol) {
        // 检查新位置是否合法
        if (newRow < 0 || newRow >= row || newCol < 0 || newCol >= col) {
            return; // 超出边界
        }

        // 检查新位置是否是空地或目标点
        if (ground[newRow][newCol] == ' ' || ground[newRow][newCol] == '.') {
            // 移动玩家
            top[playerRow][playerCol] = ' '; // 清除原来玩家的位置
            playerRow = newRow;
            playerCol = newCol;
            top[playerRow][playerCol] = '@'; // 设置新位置为玩家
            redraw();
        }
    }

    public void copyOver(char a[][], char b[][]) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                a[i][j] = b[i][j];
            }
        }
    }

    //moves between the screens
    //moves between the screens
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("screen1"))
            cdLayout.show(p_card, "1");
        else if (e.getActionCommand().equals("screen2"))
            cdLayout.show(p_card, "2");
        else if (e.getActionCommand().equals("screen3"))
            cdLayout.show(p_card, "3");
        else if (e.getActionCommand().equals("screen4"))
            cdLayout.show(p_card, "4");
        else if (e.getActionCommand().equals("screen5"))
            cdLayout.show(p_card, "5");
        else if (e.getActionCommand().equals("screen6"))
            System.exit(0);
        else if (e.getActionCommand().equals("up"))
            moveUp();
        else if (e.getActionCommand().equals("down"))
            moveDown();
        else if (e.getActionCommand().equals("left"))
            moveLeft();
        else if (e.getActionCommand().equals("right"))
            moveRight();
        else {
            //code to keep track what was element was pressed
            int num = Integer.parseInt(e.getActionCommand());
            int x = num / col;
            int y = num % col;
            feedBack.setText("(" + x + ", " + y + ")");    //delete this line when you are done the program
        }
        redraw();
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Sokoban");
        frame.setSize(560, 460);         //resizes JFrame pane size
        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Sokoban panel = new Sokoban();
        panel.setOpaque(true);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
