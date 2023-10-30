public class Game {
    private TTTBoard board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean gameOver;
    private int moves;

    public Game() {
        board = new TTTBoard();
        player1 = new Player("Player 1", 'X');
        player2 = new Player("Player 2", 'O');
        currentPlayer = player1;
        gameOver = false;
        moves = 0;
    }

    public void startGame() {
        board.initBoard();
        currentPlayer = player1;
        gameOver = false;
        moves = 0;
    }

    public void endGame() {
        // Perform any cleanup or end-of-game actions here
    }

    public void resetGame() {
        board.initBoard();
        currentPlayer = player1;
        gameOver = false;
        moves = 0;
    }

    public boolean makeMove(int row, int col) {
        if (!gameOver) {
            if (board.validateMove(row, col)) {
                board.makeMove(currentPlayer, row, col);
                moves++;

                if (board.checkWin() || board.checkDraw()) {
                    showGameResult();
                    gameOver = true;
                    return true;
                }

                togglePlayer();
                return true;
            }
        }
        return false;
    }

    private void togglePlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private void showGameResult() {
        if (board.checkWin()) {
            currentPlayer.increaseScore();
            // Show win message using JOptionPane
        } else if (board.checkDraw()) {
            // Show draw message using JOptionPane
        }
    }

    public char getCurrentPlayerSymbol() {
        return currentPlayer.getSymbol();
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
