package Dane;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class LotTest {

    @Test
    void czyJestWolneMiejsce() {
        HashMap<Integer, Rezerwacja> rezerwacje = new HashMap<Integer, Rezerwacja>();
        Pasazer pasazer = new Pasazer("Jakub","Kulejewski",12345);
        Lot lot = new Lot(2, "Test", LocalDateTime.now());
        Rezerwacja rezerwacja = new Rezerwacja(lot,lot.wylosujMiejsce(),pasazer,rezerwacje);
        Assertions.assertTrue(lot.czyJestWolneMiejsce());
    }
}