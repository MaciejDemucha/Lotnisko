import Dane.LotTest;
import Dane.TestControl;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Categories.SuiteClasses({LotTest.class, AplikacjaTest.class})
@RunWith(Suite.class)
public class LotniskoTestSuite {
}
