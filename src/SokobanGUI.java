import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SokobanGUI extends JPanel {
    private static final int TILE_SIZE = 40;
    private static final char EMPTY = ' ';
    private static final char WALL = '#';
    private static final char BOX = '$';
    private static final char TARGET = '.';
    private static final char PLAYER = '@';
    private static final char BOX_ON_TARGET = '*';
    private static final char PLAYER_ON_TARGET = '+';

    private static char[][] board = {
            {WALL, WALL, WALL, WALL, WALL},
            {WALL, EMPTY, EMPTY, TARGET, WALL},
            {WALL, EMPTY, BOX, EMPTY, WALL},
            {WALL, PLAYER, EMPTY, EMPTY, WALL},
            {WALL, WALL, WALL, WALL, WALL}
    };

    private static int playerRow = 3;
    private static int playerCol = 1;

    public SokobanGUI() {
        setPreferredSize(new Dimension(board[0].length * TILE_SIZE, board.length * TILE_SIZE));
        setBackground(Color.WHITE);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                char move = ' ';
                if (key == KeyEvent.VK_W) move = 'W';
                if (key == KeyEvent.VK_A) move = 'A';
                if (key == KeyEvent.VK_S) move = 'S';
                if (key == KeyEvent.VK_D) move = 'D';
                if (movePlayer(move)) {
                    repaint();
                    if (isGameWon()) {
                        JOptionPane.showMessageDialog(SokobanGUI.this, "Congratulations! You've won the game!");
                    }
                }
            }
        });
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                switch (board[row][col]) {
                    case EMPTY : g.setColor(Color.WHITE);
                    case WALL : g.setColor(Color.BLACK);
                    case BOX : g.setColor(Color.ORANGE);
                    case TARGET : g.setColor(Color.RED);
                    case PLAYER : g.setColor(Color.BLUE);
                    case BOX_ON_TARGET : g.setColor(Color.GREEN);
                    case PLAYER_ON_TARGET : g.setColor(Color.CYAN);
                }
                g.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                g.setColor(Color.GRAY);
                g.drawRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }

    private boolean movePlayer(char move) {
        int newRow = playerRow;
        int newCol = playerCol;

        switch (move) {
            case 'W': newRow--; break;
            case 'A': newCol--; break;
            case 'S': newRow++; break;
            case 'D': newCol++; break;
            default: return false;
        }

        if (isValidMove(newRow, newCol)) {
            if (board[newRow][newCol] == BOX || board[newRow][newCol] == BOX_ON_TARGET) {
                int boxNewRow = newRow + (newRow - playerRow);
                int boxNewCol = newCol + (newCol - playerCol);
                if (isValidMove(boxNewRow, boxNewCol) && board[boxNewRow][boxNewCol] != BOX && board[boxNewRow][boxNewCol] != BOX_ON_TARGET) {
                    moveBox(newRow, newCol, boxNewRow, boxNewCol);
                } else {
                    return false;
                }
            }
            movePlayerTo(newRow, newCol);
            return true;
        }
        return false;
    }

    private boolean isValidMove(int row, int col) {
        return board[row][col] == EMPTY || board[row][col] == TARGET;
    }

    private void movePlayerTo(int newRow, int newCol) {
        if (board[playerRow][playerCol] == PLAYER_ON_TARGET) {
            board[playerRow][playerCol] = TARGET;
        } else {
            board[playerRow][playerCol] = EMPTY;
        }

        if (board[newRow][newCol] == TARGET) {
            board[newRow][newCol] = PLAYER_ON_TARGET;
        } else {
            board[newRow][newCol] = PLAYER;
        }

        playerRow = newRow;
        playerCol = newCol;
    }

    private void moveBox(int oldRow, int oldCol, int newRow, int newCol) {
        if (board[oldRow][oldCol] == BOX_ON_TARGET) {
            board[oldRow][oldCol] = TARGET;
        } else {
            board[oldRow][oldCol] = EMPTY;
        }

        if (board[newRow][newCol] == TARGET) {
            board[newRow][newCol] = BOX_ON_TARGET;
        } else {
            board[newRow][newCol] = BOX;
        }
    }

    private boolean isGameWon() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == TARGET) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sokoban");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SokobanGUI());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
