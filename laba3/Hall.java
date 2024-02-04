public class Hall {
    public int [][] seats;
    public int number;
    public int row;
    public int place;

    public Hall(int number, int row, int place){
        this.number = number;
        this.place = place;
        this.row = row;
        this.seats = new int[this.row][this.place];
    }

    public int[][] getSeats() {
        return this.seats;
    }
    public int getRow(){
        return this.row;
    }
    public int getPlace(){
        return this.place;
    }
    public int getNumber(){ return this.number;}

}
