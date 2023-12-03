public class TwoPlayerGame extends Game {
    private final String player1, player2;

    public TwoPlayerGame(int id, int mxPlayers, String player1, String player2) {
        super(id, mxPlayers);
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    private void swapPlayers() {}
}
