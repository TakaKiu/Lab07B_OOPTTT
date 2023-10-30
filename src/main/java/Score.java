import java.util.HashMap;
import java.util.Map;

public class Score {
    private int totalWins;
    private int totalDraws;
    private Map<Player, Integer> playerWins;

    public Score() {
        totalWins = 0;
        totalDraws = 0;
        playerWins = new HashMap<>();
    }

    public int getWins() {
        return totalWins;
    }

    public int getDraws() {
        return totalDraws;
    }

    public Map<Player, Integer> getStatistics() {
        return playerWins;
    }

    public void increaseWins(Player player) {
        totalWins++;
        playerWins.put(player, playerWins.getOrDefault(player, 0) + 1);
    }

    public void increaseDraws() {
        totalDraws++;
    }
}
