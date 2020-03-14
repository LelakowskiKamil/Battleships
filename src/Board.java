import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board {
    String[][] board = new String[12][12];
    String marker;
    boolean isHit;
int numberOfHit=0;
    Set<Integer> hitPoints = new HashSet<>();
    String successfullShot = "[*]";
    String missedShot = "o";
    public Board() {
    }

    public Board(String marker) {
        this.marker = marker;
    }
}

