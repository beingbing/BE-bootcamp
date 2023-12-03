import java.util.List;
import java.util.ArrayList;

public class Chess extends TwoPlayerGame {
    private final List<String> pieces;

    public Chess(int id, int mxPlayers, String player1, String player2) {
        super(id, mxPlayers, player1, player2);
        this.pieces = new ArrayList<>();
        this.pieces.add("King");
        this.pieces.add("Queen");
        this.pieces.add("Pawn");
    }

    public List<String> getPieces() {
        return this.pieces;
    }

    private void printBoard() {
        System.out.println("the board is printed!!");
    }
}