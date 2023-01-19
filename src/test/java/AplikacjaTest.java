import Dane.Dane;
import Dane.Pasazer;
import Dane.Rezerwacja;
import Dane.Lot;
import Dane.Miejsce;
import Dane.TestControl;
import Dane.TestEntity;
import com.sun.tools.javac.Main;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import javax.xml.crypto.Data;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@Category({TestControl.class})
@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AplikacjaTest {
    Dane dane;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp(){
        dane= new Dane();
    }

    @Parameterized.Parameter(value = 0)
    public String imie;

    @Parameterized.Parameter(value = 1)
    public String nazwisko;

    @Parameterized.Parameter(value = 2)
    public String nrPaszportu;

    @Parameterized.Parameter(value = 3)
    public int nrRezerwacji;

    @Parameterized.Parameter(value = 4)
    public int nrLotu;

    @Parameterized.Parameter(value = 5)
    public int wybor;

    @Parameterized.Parameter(value = 6)
    public int expectedOutput;

    @Parameterized.Parameter(value = 7)
    public Lot expectedLotOutput;

    @Parameterized.Parameter(value = 8)
    public Rezerwacja expectedRezerwacjaOutput;


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data1 = new Object[][]{
                 {"Maciej", "Demucha2", "AB1234567", 32, 43, 1, 0, null, null}, {"Maciej", "Demucha", "",  1, 1, 1, 2, Dane.loty.get(1),Dane.rezerwacje.get(1)}, {"Mac3iej", "Demucha", "AB1234567",  1, 2, 2, 1, Dane.loty.get(2),Dane.rezerwacje.get(2)} };
        return Arrays.asList(data1);
    }

    @Test
    public void pobierzAtrybutyTest() {
        String userInput = String.format("%s%s%s%s%s%s", imie , System.lineSeparator(), nazwisko, System.lineSeparator(), nrPaszportu, System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        exception.expect(IllegalArgumentException.class);
        Pasazer result = Aplikacja.pobierzAtrybuty();
    }

    @Test
    public void pobierzAtrybutyTest1(){
        String imie = "Maciej";
        String nazwisko = "Demucha";
        String nrPaszportu = "AB1234567";
        String userInput = String.format("%s%s%s%s%s%s", imie , System.lineSeparator(), nazwisko, System.lineSeparator(), nrPaszportu, System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        Pasazer result = Aplikacja.pobierzAtrybuty();
        Pasazer expected = new Pasazer(imie, nazwisko, nrPaszportu);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void anulujRezerwacjeTest(){
        Rezerwacja rezerwacja2 = dane.rezerwacje.get(nrRezerwacji);

        String userInput = String.format("%2d%s", wybor , System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        Assert.assertEquals(expectedOutput, Aplikacja.anulujRezerwacje(rezerwacja2));
    }

    @Test
    public void anulujLotTest(){
        Lot lot = Dane.loty.get(nrLotu);

        String userInput = String.format("%2d%s", wybor , System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        Assert.assertEquals(expectedOutput, Aplikacja.anulujLot(lot));
    }

    @Test
    public void wyszukajLotTest(){
        Lot lot = Dane.loty.get(nrLotu);
        Aplikacja.dodajLot(lot);

        String userInput = String.format("%2d%s", wybor , System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        Assert.assertEquals(expectedLotOutput, Aplikacja.wyszukajLot());


    }
    @Test
    public void wyszukajRezerwacjeTest(){
        Rezerwacja rezerwacja = Dane.rezerwacje.get(nrLotu); //nr lotu moze byc jako nr rezerwacji
        Aplikacja.rezerwacje.put(wybor,rezerwacja);

        String userInput = String.format("%2d%s", wybor , System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        Assert.assertEquals(expectedRezerwacjaOutput, Aplikacja.wyszukajRezerwacje());

    }

}
