package Dane;

public class Miejsce {
    private int numer;
    private boolean czyZajete;


    public Miejsce(int numer) {
        this.numer = numer;
        this.czyZajete = false;
    }
    public Miejsce(int numer, boolean czyZajete) {
        this.numer = numer;
        this.czyZajete = czyZajete;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public boolean getCzyMiejsceJestZajete(){
        return czyZajete;
    }

    public void setCzyZajete(boolean czyZajete) {
        this.czyZajete = czyZajete;
    }


}
