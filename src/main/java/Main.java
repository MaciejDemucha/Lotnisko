import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    static HashSet<Lot> loty = new HashSet<>();
    static HashMap<Integer, Rezerwacja> rezerwacje = new HashMap<Integer, Rezerwacja>();

    public static void main(String[] args) {

    }

    public HashSet<Lot> getLoty() {
        return loty;
    }

    public void setLoty(HashSet<Lot> loty) {
        this.loty = loty;
    }

    public HashMap<Integer, Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

    public void setRezerwacje(HashMap<Integer, Rezerwacja> rezerwacje) {
        this.rezerwacje = rezerwacje;
    }

    public static Pasazer pobierzAtrybuty(){
        String imie = "", nazwisko = "";
        int nrPaszportu = 0;

        //scannner

        Pasazer pasazer = new Pasazer(imie, nazwisko, nrPaszportu);
        return pasazer;
    }

    private static Rezerwacja rezerwujLot(){
        Lot lot = wyszukajLot();
        if(!lot.czyJestWolneMiejsce()){
            return null;
        }
        boolean czyKlientWybieraMiejsce = false;
        Miejsce miejsce;

        //uzytkownik wybiera

        if(czyKlientWybieraMiejsce){
            miejsce = lot.wybierzMiejsce();
        }
        else{
            miejsce = lot.wylosujMiejsce();
        }

        Pasazer pasazer = pobierzAtrybuty();

        Rezerwacja rezerwacja = new Rezerwacja(lot, miejsce, pasazer, rezerwacje);
        rezerwacje.put(rezerwacja.getNumerRezerwacji(), rezerwacja);
        return rezerwacja;
    }

    private static int anulujRezerwacje(){
        Rezerwacja rezerwacja = wyszukajRezerwacje();
        boolean czyKlientPotwierdzaUsuniecieRezerwacje = false;
        if(rezerwacja == null){
            return 0;
        }
        if(!czyKlientPotwierdzaUsuniecieRezerwacje){
            return 1;
        }
        rezerwacje.remove(rezerwacja.getNumerRezerwacji());
        return 2;
    }

    private static void oplacRezerwacje(Rezerwacja rezerwacja){

    }

    private static Rezerwacja wyszukajRezerwacje(){

    }

    private static void anulujLot(Lot lot){

    }

    private static void dodajLot(Lot lot){

    }

    private static Lot wyszukajLot(){

   }

}
