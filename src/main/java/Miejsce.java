public class Miejsce {
    private int numer;
    private boolean czyZajete;


    public Miejsce(int numer) {
        this.numer = numer;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    boolean getCzyMiejsceJestZajete(){
        return czyZajete;
    }

    public void setCzyZajete(boolean czyZajete) {
        this.czyZajete = czyZajete;
    }
}
