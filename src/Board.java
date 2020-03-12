import java.util.HashSet;

public class Board {
    String[][] board = new String[12][12];
    int numerOfHits=0;
    String marker;
    boolean isHit;

    HashSet<String> hitPoints = new HashSet<>();





    public Board(String marker) {
        this.marker = marker;
    }
}

