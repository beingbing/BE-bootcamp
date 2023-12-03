public class Game {
    private final int id;

    private int playersCount;

    private final int maxPlayersAllowed;

    public Game(int id, int mxPlayers) {
        this.id = id;
        this.maxPlayersAllowed = mxPlayers;
    }

    public int getId() {
        return id;
    }

    public int getMaxPlayersAllowed() {
        return maxPlayersAllowed;
    }

    private boolean checkIfOver() {
        return false;
    }
}
