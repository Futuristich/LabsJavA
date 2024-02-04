public class Seance {
    public String name;
    public Hall hall_1;
    public  int [][] seats;

    public Seance(String name, Hall hall_1){
        this.name = name;
        this.hall_1 = hall_1;
        this.seats = new int [hall_1.getRow()][hall_1.getPlace()];

    }

    public String getName() {
        return this.name;
    }

    public int[][] getSeats() {
        return this.seats;
    }

    public Hall getHall() {
        return this.hall_1;
    }


}
