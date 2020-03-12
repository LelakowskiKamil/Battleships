public class Ship {
    int shipSize;
    int numberOfShipToBeStacked;



    public Ship(int shipSize) {
        this.shipSize = shipSize;
        if (shipSize==2){
            numberOfShipToBeStacked=2;
        }else if (shipSize==3){
            numberOfShipToBeStacked=3;
        }else if (shipSize==4){
            numberOfShipToBeStacked=3;
        }else if (shipSize==5){
            numberOfShipToBeStacked=1;
        }
        }

        String getVoice(int shipSize){
        if (shipSize==2) return "[X] X";
        else if (shipSize==3) return "X [X] X";
        else if (shipSize==4) return "X [X] X X";
        else if (shipSize==5) return "X [X] X X X";
        return "Error";
        }
}



