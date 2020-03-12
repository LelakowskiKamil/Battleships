import java.sql.SQLOutput;
import java.util.Scanner;

public class Battleships {
    public static void main(String[] args) {
        Board myBoard = new Board("X");

      //  generateBoard(myBoard.board);
        generateEmptyBoard(myBoard.board);
        printBoard(myBoard.board);
        setShip(myBoard.board,myBoard.marker);


    }
    static void printBoard(String[][] board){
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(board[i][j]+"\t");}
            System.out.println();
        }
    }
    static String[][]  generateEmptyBoard (String[][] board){
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if(i==0){
                    if (j!=11){
                        board[i][j]=""+j;
                    }
                    else{
                        board[i][j]="";
                    }
                }
                else if(i==11 || j==11){
                    board[i][j]="";
                }
                else if(j==0) {
                    board[i][j] = "" + i;
                }
                else{
                    board[i][j] = "";
                }
            }
        }
        return board;
    }
    public static void setShip(String[][] board, String marker) {
        int shipSize=2;
        while(shipSize<6){
       // System.out.println("Set up a ship with 2 spaces");
        Ship ship = new Ship(shipSize);
        while (ship.numberOfShipToBeStacked > 0) {
            System.out.println(ship.getVoice(shipSize));
            System.out.println("Quantity: "+ship.numberOfShipToBeStacked);
            System.out.println();
            try {
                System.out.println("Enter the row index:");
                int row = new Scanner(System.in).nextInt();
                System.out.println("Enter the column index:");
                int col = new Scanner(System.in).nextInt();
                if (shipSize==2){
                    if(col<1 || col>9){
                        System.out.println("The ship is out of the board, choose a different position");
                        continue;}
                    else {
                        if(board[row][col].equals(marker) || board[row][col + 1].equals(marker)){
                            System.out.println("There is something already in these fields, choose another field");
                            continue;}
                        else{
                            if (board[row - 1][col - 1].equals(marker) ||
                                    board[row - 1][col].equals(marker) ||
                                    board[row - 1][col + 1].equals(marker) ||
                                    board[row - 1][col + 2].equals(marker) ||

                                    board[row + 1][col - 1].equals(marker) ||
                                    board[row + 1][col].equals(marker) ||
                                    board[row + 1][col + 1].equals(marker) ||
                                    board[row + 1][col + 2].equals(marker) ||

                                    board[row][col - 1].equals(marker) ||
                                    board[row][col + 2].equals(marker)) {
                                System.out.println("The ship is bordered by another ship, please select another field");
                                continue;
                            } else {
                                board[row][col] = marker;
                                board[row][col + 1] = marker;}}
                    }
                    ship.numberOfShipToBeStacked--;
                    printBoard(board);
                }
                else if(shipSize==3){
                    if(col<2 || col>9){
                        System.out.println("The ship is out of the board, choose a different position");
                        continue;}
                    else {
                        if(board[row][col].equals(marker) ||
                           board[row][col - 1].equals(marker) ||
                           board[row][col + 1].equals(marker)){
                            System.out.println("There is something already in these fields, choose another field");
                            continue;}
                        else{
                            if (board[row - 1][col - 2].equals(marker) ||
                                    board[row - 1][col - 1].equals(marker) ||
                                    board[row - 1][col].equals(marker) ||
                                    board[row - 1][col + 1].equals(marker) ||
                                    board[row - 1][col + 2].equals(marker) ||

                                    board[row + 1][col - 2].equals(marker) ||
                                    board[row + 1][col - 1].equals(marker) ||
                                    board[row + 1][col].equals(marker) ||
                                    board[row + 1][col + 1].equals(marker) ||
                                    board[row + 1][col + 2].equals(marker) ||

                                    board[row][col - 2].equals(marker) ||
                                    board[row][col + 2].equals(marker)) {
                                System.out.println("The ship is bordered by another ship, please select another field");
                                continue;
                            } else {
                                board[row][col] = marker;
                                board[row][col - 1] = marker;
                                board[row][col + 1] = marker;}}
                    }
                    ship.numberOfShipToBeStacked--;
                    printBoard(board);
                }
                else if(shipSize==4){
                    if(col<2 || col>8){
                        System.out.println("The ship is out of the board, choose a different position");
                        continue;}
                    else {
                        if(board[row][col].equals(marker) ||
                            board[row][col - 1].equals(marker) ||
                            board[row][col + 1].equals(marker) ||
                            board[row][col + 2].equals(marker)){
                            System.out.println("There is something already in these fields, choose another field");
                            continue;}
                        else{
                        if (board[row - 1][col - 2].equals(marker) ||
                                board[row - 1][col - 1].equals(marker) ||
                                board[row - 1][col].equals(marker) ||
                                board[row - 1][col + 1].equals(marker) ||
                                board[row - 1][col + 2].equals(marker) ||
                                board[row - 1][col + 3].equals(marker) ||

                                board[row + 1][col - 2].equals(marker) ||
                                board[row + 1][col - 1].equals(marker) ||
                                board[row + 1][col].equals(marker) ||
                                board[row + 1][col + 1].equals(marker) ||
                                board[row + 1][col + 2].equals(marker) ||
                                board[row + 1][col + 3].equals(marker) ||

                                board[row][col - 2].equals(marker) ||
                                board[row][col + 3].equals(marker)) {
                            System.out.println("The ship is bordered by another ship, please select another field");
                            continue;
                        } else {
                            board[row][col] = marker;
                            board[row][col - 1] = marker;
                            board[row][col + 1] = marker;
                            board[row][col + 2] = marker;
                        }
                    }
                }
                    ship.numberOfShipToBeStacked--;
                    printBoard(board);}
                else if(shipSize==5){
                    if(col<2 || col>7){
                        System.out.println("The ship is out of the board, choose a different position");
                        continue;}
                    else {
                        if(board[row][col].equals(marker) ||
                                board[row][col - 1].equals(marker) ||
                                board[row][col + 1].equals(marker) ||
                                board[row][col + 2].equals(marker) ||
                                board[row][col + 3].equals(marker)){
                            System.out.println("There is something already in these fields, choose another field");
                            continue;}
                        else{
                            if (board[row - 1][col - 2].equals(marker) ||
                                    board[row - 1][col - 1].equals(marker) ||
                                    board[row - 1][col].equals(marker) ||
                                    board[row - 1][col + 1].equals(marker) ||
                                    board[row - 1][col + 2].equals(marker) ||
                                    board[row - 1][col + 3].equals(marker) ||
                                    board[row - 1][col + 4].equals(marker) ||

                                    board[row + 1][col - 2].equals(marker) ||
                                    board[row + 1][col - 1].equals(marker) ||
                                    board[row + 1][col].equals(marker) ||
                                    board[row + 1][col + 1].equals(marker) ||
                                    board[row + 1][col + 2].equals(marker) ||
                                    board[row + 1][col + 3].equals(marker) ||
                                    board[row + 1][col + 4].equals(marker) ||

                                    board[row][col - 2].equals(marker) ||
                                    board[row][col + 4].equals(marker)) {
                                System.out.println("The ship is bordered by another ship, please select another field");
                                continue; }
                            else {
                                board[row][col] = marker;
                                board[row][col - 1] = marker;
                                board[row][col + 1] = marker;
                                board[row][col + 2] = marker;
                                board[row][col + 3] = marker;}
                        }
                    }
                    ship.numberOfShipToBeStacked--;
                    printBoard(board);}
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                System.out.println("The ship will not fit on the board");
            }
        }
shipSize++;

    }
    }
}
