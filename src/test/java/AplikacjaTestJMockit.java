import Dane.Lot;
import Dane.Pasazer;
import Dane.Rezerwacja;
import mockit.Mocked;
import mockit.VerificationsInOrder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;

public class AplikacjaTestJMockit {
    @Mocked
    Pasazer pasazer;

    @Test
    public void testEquals(){
        Pasazer pasazer1 = new Pasazer("Imie", "Nazwisko", "AB1234567");
        Lot lot1 = new Lot(0,50, "Warszawa - Berlin", LocalDateTime.now());
        Rezerwacja[] rezerwacje = new Rezerwacja[]{new Rezerwacja(1,lot1, lot1.getMiejsca().get(1), pasazer), new Rezerwacja(1,lot1, lot1.getMiejsca().get(1), pasazer1)};
        for (int i = 0; i < 1; i++)
            for (int j = i; j < 2; j++)
                if (i == j)
                    Assert.assertTrue(rezerwacje[i].equals(rezerwacje[i]));
                else
                    Assert.assertFalse(rezerwacje[i].equals(rezerwacje[j]));
        new VerificationsInOrder() {{
            pasazer.equals(any);
            maxTimes = 2;
        }};
    }
}
