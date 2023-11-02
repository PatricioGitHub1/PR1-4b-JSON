package cat.iesesteveterradas.mp06.altres;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

interface Player {
    char getSymbol();
}

class XPlayer implements Player {
    @Override
    public char getSymbol() {
        return 'X';
    }
}

class OPlayer implements Player {
    @Override
    public char getSymbol() {
        return 'O';
    }
}

class Board {
    private static final int SIZE = 3;
    private char[][] grid = new char[SIZE][SIZE];

    public void placeMove(int x, int y, Player player) {
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE && grid[x][y] == '\0') {
            grid[x][y] = player.getSymbol();
        }
    }

    public boolean checkWinner(Player player) {
        for (int i = 0; i < SIZE; i++) {
            if (grid[i][0] == player.getSymbol() && grid[i][1] == player.getSymbol() && grid[i][2] == player.getSymbol()) {
                return true;
            }
            if (grid[0][i] == player.getSymbol() && grid[1][i] == player.getSymbol() && grid[2][i] == player.getSymbol()) {
                return true;
            }
        }
        if (grid[0][0] == player.getSymbol() && grid[1][1] == player.getSymbol() && grid[2][2] == player.getSymbol()) {
            return true;
        }
        if (grid[0][2] == player.getSymbol() && grid[1][1] == player.getSymbol() && grid[2][0] == player.getSymbol()) {
            return true;
        }
        return false;
    }
}

class TicTacToe {
    private Board board = new Board();
    private Player currentPlayer = new XPlayer();
    private Player nextPlayer = new OPlayer();

    public char play(int x, int y) {
        board.placeMove(x, y, currentPlayer);
        char placedSymbol = currentPlayer.getSymbol();
        if (!board.checkWinner(currentPlayer)) {
            swapPlayers();
        }
        return placedSymbol;
    }

    public boolean hasWinner() {
        return board.checkWinner(currentPlayer);
    }

    private void swapPlayers() {
        Player temp = currentPlayer;
        currentPlayer = nextPlayer;
        nextPlayer = temp;
    }
}

/*
public class TicTacToeGUI {
    private TicTacToe game = new TicTacToe();
    private JFrame frame = new JFrame("TicTacToe");
    private JButton[][] buttons = new JButton[3][3];
    private JLabel messageLabel = new JLabel("");

    public TicTacToeGUI() {
        frame.setSize(300, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        buttonClicked((JButton) e.getSource());
                    }
                });
                boardPanel.add(buttons[i][j]);
            }
        }

        frame.add(boardPanel, BorderLayout.CENTER);
        frame.add(messageLabel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void buttonClicked(JButton button) {
        int x = -1, y = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j] == button) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
    
        if (x != -1 && y != -1 && button.getText().equals("")) {
            char prevSymbol = game.play(x, y); 
            button.setText(String.valueOf(prevSymbol));
            if (game.hasWinner()) {
                messageLabel.setText(prevSymbol + " wins!");
                disableButtons();
            }
        }
    }    

    private void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToeGUI());
    }
}
*/

public class TicTacToeGUI extends Application {
    private TicTacToe game = new TicTacToe();
    private Button[][] buttons = new Button[3][3];
    private Label messageLabel = new Label("");

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TicTacToe");

        BorderPane root = new BorderPane();
        GridPane boardPanel = new GridPane();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Button("");
                buttons[i][j].setMinSize(100, 100);
                buttons[i][j].setFont(new javafx.scene.text.Font(40));
                buttons[i][j].setOnAction(e -> buttonClicked((Button) e.getSource()));
                boardPanel.add(buttons[i][j], j, i);
            }
        }

        root.setCenter(boardPanel);
        root.setBottom(messageLabel);

        Scene scene = new Scene(root, 300, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void buttonClicked(Button button) {
        int x = -1, y = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j] == button) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        if (x != -1 && y != -1 && button.getText().equals("")) {
            char prevSymbol = game.play(x, y);
            button.setText(String.valueOf(prevSymbol));
            if (game.hasWinner()) {
                messageLabel.setText(prevSymbol + " wins!");
                disableButtons();
            }
        }
    }

    private void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setDisable(true);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
