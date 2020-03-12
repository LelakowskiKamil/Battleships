import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Battleships {
    public static void main(String[] args) {
        Board myBoard = new Board("X");
        Board computerBoard = new Board("@");
       // generateEmptyBoard(myBoard.board);
       // printBoard(myBoard.board);
       // setShip(myBoard.board,myBoard.marker);
        generateEmptyBoard(computerBoard.board);
        computerSetShip(computerBoard.board, computerBoard.marker);
       // computerBoard.board=computerSetShip(computerBoard.board, computerBoard.marker);
//printBoard(computerBoard.board);

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
    public static String[][] computerSetShip(String[][] board, String marker){
        int count=0;
        Random random = new Random();
        boolean tic = false;
        int shipSize=5;
        while(shipSize>1){
            Ship ship = new Ship(shipSize);
            while (ship.numberOfShipToBeStacked > 0) {
            try {
                count++;
                System.out.println("counter = "+count);
                System.out.println("rozmiar kolcka: "+shipSize+" zostalo: "+ship.numberOfShipToBeStacked);
                int row = random.nextInt(11) + 1;
                int col = random.nextInt(11) + 1;

                if(shipSize==5){
                    if (count==35){
                        break;
                    }
                    if(col<2 || col>7){
                        continue;}
                    else {
                        if(board[row][col].equals(marker) ||
                                board[row][col - 1].equals(marker) ||
                                board[row][col + 1].equals(marker) ||
                                board[row][col + 2].equals(marker) ||
                                board[row][col + 3].equals(marker)){
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
                                continue;}
                            else {
                                board[row][col] = marker;
                                board[row][col - 1] = marker;
                                board[row][col + 1] = marker;
                                board[row][col + 2] = marker;
                                board[row][col + 3] = marker;
                                ship.numberOfShipToBeStacked--;
                                count=0;
                            }
                        }
                    }
}
                else if(shipSize==4){
                    if (count==100){
                        break;
                    }
                    if (tic){
                        tic = !tic;
                        if(row<2 || row>8){
                            continue;
                        } else {
                            if(board[row][col].equals(marker) ||
                                    board[row+1][col].equals(marker) ||
                                    board[row-1][col].equals(marker) ||
                                    board[row-2][col].equals(marker) ){
                                continue;
                            }else{
                                if (board[row-2][col-1].equals(marker) ||
                                        board[row-1][col-1].equals(marker) ||
                                        board[row][col-1].equals(marker) ||
                                        board[row+1][col-1].equals(marker) ||
                                        board[row+2][col-1].equals(marker) ||
                                        board[row+3][col-1].equals(marker) ||

                                        board[row - 2][col+ 1].equals(marker) ||
                                        board[row - 1][col + 1].equals(marker) ||
                                        board[row][col + 1].equals(marker) ||
                                        board[row + 1][col + 1].equals(marker) ||
                                        board[row+2][col + 1].equals(marker) ||
                                        board[row+3][col + 1].equals(marker) ||

                                        board[row-2][col].equals(marker) ||
                                        board[row+3][col].equals(marker)) {
                                    continue;
                                } else {
                                    board[row+2][col] = marker;
                                    board[row+1][col] = marker;
                                    board[row][col] = marker;
                                    board[row-1][col] = marker;
                                    ship.numberOfShipToBeStacked--;
                                    count=0;
                                    if (ship.numberOfShipToBeStacked==0){
                                        continue;}
                                }
                            }

                        }
                    }
                    else{
                        tic = !tic;
    if(col<2 || col>8){
        continue;}
    else {
        if(board[row][col].equals(marker) ||
                board[row][col - 1].equals(marker) ||
                board[row][col + 1].equals(marker) ||
                board[row][col + 2].equals(marker)){
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
                continue;
            } else {
                board[row][col] = marker;
                board[row][col - 1] = marker;
                board[row][col + 1] = marker;
                board[row][col + 2] = marker;
                ship.numberOfShipToBeStacked--;
                count=0;

                if (ship.numberOfShipToBeStacked==0){
                    continue;}
            }
        }
    }}
}
                else if(shipSize==3){
                    if (count==100){
                        break;
                    }
                    if (tic){
                        tic = !tic;
                        if(row<2 || row>9){
                            continue;
                        } else {
                            if(board[row][col].equals(marker) ||
                                    board[row+1][col].equals(marker) ||
                                    board[row-1][col].equals(marker) ){
                                continue;
                            }else{
                                if (board[row-2][col-1].equals(marker) ||
                                        board[row-1][col-1].equals(marker) ||
                                        board[row][col-1].equals(marker) ||
                                        board[row+1][col-1].equals(marker) ||
                                        board[row+2][col-1].equals(marker) ||

                                        board[row - 2][col+ 1].equals(marker) ||
                                        board[row - 1][col + 1].equals(marker) ||
                                        board[row][col + 1].equals(marker) ||
                                        board[row + 1][col + 1].equals(marker) ||
                                        board[row+2][col + 1].equals(marker) ||

                                        board[row-2][col].equals(marker) ||
                                        board[row+2][col].equals(marker)) {
                                    continue;
                                } else {
                                    board[row+1][col] = marker;
                                    board[row][col] = marker;
                                    board[row-1][col] = marker;
                                    ship.numberOfShipToBeStacked--;
                                    count=0;
                                    if (ship.numberOfShipToBeStacked==0){
                                        continue;}
                                }
                            }
                        }
                    }
                    else{
                        tic = !tic;
                        if(col<2 || col>9){
                            continue;}
                        else {
                            if(board[row][col].equals(marker) ||
                                    board[row][col - 1].equals(marker) ||
                                    board[row][col + 1].equals(marker)){
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
                                    continue;
                                } else {
                                    board[row][col] = marker;
                                    board[row][col - 1] = marker;
                                    board[row][col + 1] = marker;
                                    ship.numberOfShipToBeStacked--;
                                    count=0;
                                    if (ship.numberOfShipToBeStacked==0){
                                        continue;}}
                            }}}
                    }
                else if(shipSize==2) {
                    if (count==100){
                        break;
                    }
                    if (tic){
                        tic = !tic;
                        if(row<1 || row>9){
                            continue;
                        } else {
                            if(board[row][col].equals(marker) ||
                                    board[row+1][col].equals(marker)){
                                continue;
                            }else{
                                if (    board[row-1][col-1].equals(marker) ||
                                        board[row][col-1].equals(marker) ||
                                        board[row+1][col-1].equals(marker) ||
                                        board[row+2][col-1].equals(marker) ||

                                        board[row - 1][col + 1].equals(marker) ||
                                        board[row][col + 1].equals(marker) ||
                                        board[row + 1][col + 1].equals(marker) ||
                                        board[row+2][col + 1].equals(marker) ||

                                        board[row-1][col].equals(marker) ||
                                        board[row+2][col].equals(marker)) {
                                    continue;
                                } else {
                                    board[row+1][col] = marker;
                                    board[row][col] = marker;
                                    ship.numberOfShipToBeStacked--;
                                    count=0;
                                    if (ship.numberOfShipToBeStacked==0){
                                        continue;}
                                }
                            }
                    }}
                    else{
    tic= !tic;
    if (col < 1 || col > 9) {
        continue;
    } else {
        if (board[row][col].equals(marker) ||
                board[row][col + 1].equals(marker)) {
            continue;
        } else {
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
                continue;
            } else {
                board[row][col] = marker;
                board[row][col + 1] = marker;
                ship.numberOfShipToBeStacked--;
                count=0;
                if (ship.numberOfShipToBeStacked==0){
                    continue;}
            }
        }
    }}
}

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.toString());
            }

    }
            if (count==100){
                break;
            }
            shipSize--;
            printBoard(board);
}
        if (count==100){
            generateEmptyBoard(board);
            computerSetShip(board,marker);
        }
        return board;
}
}

