import Dane.Lot;
import Dane.Miejsce;
import Dane.Pasazer;
import Dane.Rezerwacja;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<Integer, Lot> loty = new HashMap<>();
    static HashMap<Integer, Rezerwacja> rezerwacje = new HashMap<Integer, Rezerwacja>();

    public static void main(String[] args) {
        Lot lot = new Lot(50,"Warszawa - Berlin", LocalDateTime.now());
        System.out.println(lot.toString());
        //loty.put(0, lot);
        dodajLot(lot);

        Rezerwacja rezerwacja = rezerwujLot();
        System.out.println(rezerwacja.getNumerRezerwacji());
        System.out.println(rezerwacja.toString());
       if(anulujRezerwacje() == 2)
           System.out.println("Sukces");
    }

    public HashMap<Integer, Lot> getLoty() {
        return loty;
    }

    public void setLoty(HashMap<Integer, Lot> loty) {
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

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj imię: ");
        imie = scanner.nextLine();
        System.out.println("Podaj nazwisko: ");
        nazwisko = scanner.nextLine();
        System.out.println("Podaj numer paszportu: ");
        nrPaszportu = Integer.parseInt(scanner.nextLine());

        return new Pasazer(imie, nazwisko, nrPaszportu);
    }

    private static Rezerwacja rezerwujLot(){
        Lot lot = wyszukajLot();
        if(!lot.czyJestWolneMiejsce()){
            return null;
        }
        boolean czyKlientWybieraMiejsce = false;
        Miejsce miejsce;

       Scanner scanner = new Scanner(System.in);

        System.out.println("1. Wybierz miejsce");
        System.out.println("2. Wylosuj miejsce");
        int choice = scanner.nextInt();
        if(choice == 1)
            czyKlientWybieraMiejsce = true;

        if(czyKlientWybieraMiejsce){
            do {
                miejsce = lot.wybierzMiejsce();
            }while (miejsce.getCzyMiejsceJestZajete());
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

        if(rezerwacja == null){
            return 0; //nie znaleziono rezerwacji
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Czy chcesz anulować rezerwację? ");
        System.out.println("1. Tak ");
        System.out.println("2. Nie");
        int choice = scanner.nextInt();
        boolean czyKlientPotwierdzaUsuniecieRezerwacje = false;
        if(choice == 1)
            czyKlientPotwierdzaUsuniecieRezerwacje = true;

        if(!czyKlientPotwierdzaUsuniecieRezerwacje){
            return 1; //klient anulowal usuwanie rezerwacji
        }
        rezerwacje.remove(rezerwacja.getNumerRezerwacji());
        return 2; // rezerwacja poprawnie usunięta
    }

    private static void oplacRezerwacje(Rezerwacja rezerwacja){

    }

    private static Rezerwacja wyszukajRezerwacje(){
       Rezerwacja rezerwacja;
       Scanner scanner = new Scanner(System.in);
       System.out.println("Podaj numer rezerwacji: ");
       rezerwacja = rezerwacje.get(scanner.nextInt());
       return rezerwacja;
    }

    private static int anulujLot(){
        Lot lot = wyszukajLot();

        if(lot == null){
            return 0; //nie znaleziono lotu
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Czy chcesz anulować lot? ");
        System.out.println("1. Tak ");
        System.out.println("2. Nie");
        int choice = scanner.nextInt();
        boolean czyPotwierdzonoAnulowanieLotu = false;
        if(choice == 1)
            czyPotwierdzonoAnulowanieLotu = true;

        if(!czyPotwierdzonoAnulowanieLotu){
            return 1; //pracownik nie potwierdzil usuniecia lotu
        }

        loty.remove(lot);
        return 2;
    }

    private static void dodajLot(Lot lot){
        loty.put(0, lot);
    }

    private static Lot wyszukajLot(){
        Lot lot;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer lotu: ");
        lot = loty.get(scanner.nextInt());
        return lot;
   }

}
