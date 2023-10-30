public class TTTBoard {
    private char[][] board;
    private int boardSize;

    public TTTBoard() {
        boardSize = 3;
        board = new char[boardSize][boardSize];
    }

    public void initBoard() {
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public void makeMove(Player player, int row, int col) {
        if (isValidCell(row, col)) {
            board[row][col] = player.getSymbol();
        }
    }

    public boolean validateMove(int row, int col) {
        return isValidCell(row, col) && isEmptyCell(row, col);
    }

    public boolean checkWin() {
        for (int i = 0; i < boardSize; i++) {
            if (checkRow(i) || checkColumn(i)) {
                return true;
            }
        }

        if (checkDiagonals()) {
            return true;
        }

        return false;
    }

    public boolean checkDraw() {
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                if (isEmptyCell(row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < boardSize && col >= 0 && col < boardSize;
    }

    private boolean isEmptyCell(int row, int col) {
        return board[row][col] == ' ';
    }

    private boolean checkRow(int row) {
        char symbol = board[row][0];
        if (symbol == ' ') {
            return false;
        }
        for (int col = 1; col < boardSize; col++) {
            if (board[row][col] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col) {
        char symbol = board[0][col];
        if (symbol == ' ') {
            return false;
        }
        for (int row = 1; row < boardSize; row++) {
            if (board[row][col] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonals() {
        char center = board[1][1];
        if (center != ' ') {
            return (board[0][0] == center && board[2][2] == center) || (board[0][2] == center && board[2][0] == center);
        }
        return false;
    }
}
