import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Battleships {
    public static void main(String[] args) {
        Board myBoard = new Board("X");
        Board computerBoard = new Board("@");
        Board emptyBoard = new Board();

        game(computerBoard,emptyBoard,myBoard);

   }
   public static void game(Board computerBoard,Board emptyBoard,Board myBoard){
       generateEmptyBoard(myBoard.board);
       printBoard(myBoard.board);
       myBoard.board=setShip(myBoard.board,myBoard.marker);
       generateEmptyBoard(computerBoard.board);
       computerBoard.board=computerSetShip(computerBoard.board, computerBoard.marker);
       turn(computerBoard,myBoard,emptyBoard);
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
    public static String[][] setShip(String[][] board, String marker) {
        int shipSize=2;
        while(shipSize<6){
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
        return board;
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
                int row = random.nextInt(11) + 1;
                int col = random.nextInt(11) + 1;

                if(shipSize==5){
                    if (count==100){
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
                                count=0;
                                ship.numberOfShipToBeStacked--;
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
                                    count=0;
                                    ship.numberOfShipToBeStacked--;
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
                                    count=0;
                                    ship.numberOfShipToBeStacked--;
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
            }

    }
            if (count==100){
                break;
            }
            shipSize--;
}
        if (count==100){
            generateEmptyBoard(board);
            computerSetShip(board,marker);
        }
        return board;
}

    public static void shot(Board computerBoard,Board emptyBoard){
        do{
            System.out.println("Enter the row index:");
            int row = new Scanner(System.in).nextInt();
            System.out.println("Enter the column index:");
            int col = new Scanner(System.in).nextInt();
            String kord1 = Integer.toString(row)+Integer.toString(col);
            int kord= Integer.parseInt(kord1);
            try {
                if (row==0 || col==0 || col==11 || row==11){
                    System.out.println("Out of board, try again");
                    computerBoard.isHit=true;
                    continue;
                }
                if(computerBoard.board[row][col].equals(computerBoard.marker)) {
                    computerBoard.isHit=true;
                    computerBoard.hitPoints.add(kord);
                    computerBoard.numberOfHit++;
                    System.out.println("Getting hit!");
                    emptyBoard.board[row][col]=computerBoard.successfullShot;
                    printBoard(emptyBoard.board);

                    if(computerBoard.numberOfHit==34){
                        System.out.println("you won");
                        break;
                    }
                    System.out.println("the number of shot: "+computerBoard.numberOfHit);

                }else if(computerBoard.board[row][col].equals(computerBoard.missedShot)) {
                    System.out.println("you already hit this field");
                    computerBoard.isHit=true;
                continue;}
                else if(computerBoard.board[row][col].equals(computerBoard.successfullShot)) {
                    System.out.println("you already hit this field");
                    computerBoard.isHit=true;
                    continue;}
                else{
                    System.out.println("mishit!");
                    emptyBoard.board[row][col]=computerBoard.missedShot;
                    printBoard(emptyBoard.board);
                    computerBoard.isHit=false;}
            }catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Out of range");
            }
        }while(computerBoard.isHit);
}

    public static void computerShot(Board myBoard){
        Random random = new Random();
        do{
            int row = random.nextInt(10)+1;
            int col = random.nextInt(10)+1;
            String kord1 = ""+row+col;
            int kord= Integer.parseInt(kord1);
            try {
                System.out.println("Computer shot: "+row +" "+col);
                if (myBoard.hitPoints.contains(kord)){
                    myBoard.isHit=true;
                    continue;
                }
                myBoard.hitPoints.add(kord);
                if(myBoard.board[row][col].equals(myBoard.marker)) {
                    myBoard.isHit=true;
                    myBoard.hitPoints.add(kord);
                    myBoard.numberOfHit++;
                    System.out.println("Trafiony");
                    myBoard.board[row][col]=myBoard.successfullShot;
                    printBoard(myBoard.board);

                    if(myBoard.numberOfHit==34){
                        System.out.println("Enemy correct hits: "+myBoard.numberOfHit);
                        System.out.println("you lose");
                        break;

                    }
                    System.out.println("the number of shot: "+myBoard.numberOfHit);

                }else{
                    System.out.println("mishit!");
                    myBoard.board[row][col]=myBoard.missedShot;
                    printBoard(myBoard.board);
                    myBoard.isHit=false;}
            }catch (ArrayIndexOutOfBoundsException e) {
            }
        }while(myBoard.isHit);
}
    public static void turn(Board computerBoard, Board myBoard, Board emptyBoard){
    generateEmptyBoard(emptyBoard.board);
        while (computerBoard.numberOfHit<34 || myBoard.numberOfHit<34) {
            shot(computerBoard, emptyBoard);
            computerShot(myBoard);
        }

}
    }



