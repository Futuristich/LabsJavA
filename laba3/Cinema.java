public class Cinema {
    public Hall[] halls;
    public String name;
    public Seance[] seances;

    public Cinema(Hall[] halls, String name, Seance[] seances){
        this.halls = halls;
        this.name = name;
        this.seances = seances;

    }
    public String getName(){
        return this.name;
    }

    public Hall[] getHalls() {
        return this.halls;
    }

    public void setHalls( Hall[] hallsNew) {
        this.halls = hallsNew;
    }

    public Seance[] getSeances(){
       return this.seances;
    }
    public void setSeances(Seance[] seancesNew){
        this.seances = seancesNew;
    }
}
