public class Move {
    private Player player;
    private int row;
    private int col;
    private MoveOutcome outcome;

    public Move(Player player, int row, int col, MoveOutcome outcome) {
        this.player = player;
        this.row = row;
        this.col = col;
        this.outcome = outcome;
    }

    public Player getPlayer() {
        return player;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public MoveOutcome getOutcome() {
        return outcome;
    }
}

enum MoveOutcome {
    WIN, DRAW, CONTINUE
}
