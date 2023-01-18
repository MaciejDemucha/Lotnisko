import Dane.Lot;
import Dane.Miejsce;
import Dane.Pasazer;
import Dane.Rezerwacja;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class Aplikacja {
    static HashMap<Integer, Lot> loty = new HashMap<>();
    static HashMap<Integer, Rezerwacja> rezerwacje = new HashMap<Integer, Rezerwacja>();

    public static void main(String[] args) {
        Lot lot = new Lot(0,50,"Warszawa - Berlin", LocalDateTime.now());
        System.out.println(lot.toString());
        dodajLot(lot);

        Lot wybranyLot = wyszukajLot();
        Rezerwacja rezerwacja = rezerwujLot(wybranyLot);
        System.out.println(rezerwacja.getNumerRezerwacji());
        System.out.println(rezerwacja.toString());
        Rezerwacja wybranaRezerwacja = wyszukajRezerwacje();
       if(anulujRezerwacje(wybranaRezerwacja) == 2)
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

    private static boolean czyZawieraCyfre(String string){
        char[] chars = string.toCharArray();
        for(char c : chars)
            if(Character.isDigit(c))
               return true;
        return false;
    }

    public static Pasazer pobierzAtrybuty() {
        String imie = "", nazwisko = "";
        String nrPaszportu = "";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj imię: ");
        imie = scanner.nextLine();
        System.out.println("Podaj nazwisko: ");
        nazwisko = scanner.nextLine();
        System.out.println("Podaj numer paszportu: ");
        nrPaszportu = scanner.nextLine();

        if(czyZawieraCyfre(imie) || czyZawieraCyfre(nazwisko) || imie.length() == 0 || nazwisko.length() == 0 || nrPaszportu.length() == 0)
            throw new IllegalArgumentException("Złe dane");

        return new Pasazer(imie, nazwisko, nrPaszportu);
    }

    private static Rezerwacja rezerwujLot(Lot lot) {

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

    public static int anulujRezerwacje(Rezerwacja rezerwacja){


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
        int numerRezerwacji = rezerwacja.getNumerRezerwacji();
        rezerwacje.remove(numerRezerwacji);
        return 2; // rezerwacja poprawnie usunięta
    }

    private static void oplacRezerwacje(Rezerwacja rezerwacja){
        System.out.println("Opłacono rezerwacje nr: " + rezerwacja.getNumerRezerwacji());
    }

    private static Rezerwacja wyszukajRezerwacje(){
       Rezerwacja rezerwacja;
       Scanner scanner = new Scanner(System.in);
       System.out.println("Podaj numer rezerwacji: ");
       rezerwacja = rezerwacje.get(scanner.nextInt());
       return rezerwacja;
    }

    public static int anulujLot(Lot lot){

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
        loty.put(lot.getNumerLotu(), lot);
    }

    private static Lot wyszukajLot(){
        Lot lot;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer lotu: ");
        lot = loty.get(scanner.nextInt());
        return lot;
   }

}
