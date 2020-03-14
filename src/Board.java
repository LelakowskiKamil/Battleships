import java.util.HashSet;

public class Board {
    String[][] board = new String[12][12];
    String marker;
    boolean isHit;
int numberOfHit=0;
    HashSet<String> hitPoints = new HashSet<>();
    String successfullShot = "[*]";
    String missedShot = "o";
    public Board() {
    }

    public Board(String marker) {
        this.marker = marker;
    }
}

