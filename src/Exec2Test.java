import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exec2Test {

    private static World w;
    private static World wNull;


    @BeforeAll
    static void setup() {
        w = new World(System.getProperty("user.dir") + "\\src\\Exec2-test.json");
        wNull = new World(System.getProperty("user.dir") + "\\src\\Exec2-test2.json");
    }

    @Test
    void getNumberOfCountries() {
        int result = Exec2.getNumberOfCountries(w);
        assertEquals(6, result);
    }


    @Test
    void getCountryWithMostLanguages() {
        Country result = Exec2.getCountryWithMostLanguages(w);
        assertEquals("CH", result.getName());
    }


    @Test
    void getGermanCountryWithMostLanguagesNull() {
        Country result = Exec2.getGermanCountryWithMostLanguages(wNull);
        assertNull(result);
    }


    @Test
    void getGermanCountryWithMostLanguages() {
        Country result = Exec2.getGermanCountryWithMostLanguages(w);
        assertEquals("BE", result.getName());
    }


    @Test
    void getNumberOfLanguages() {
        int result = Exec2.getNumberOfLanguages(w);
        assertEquals(6, result);
    }


    @Test
    void getNumberOfLanguages2() {
        int result = Exec2.getNumberOfLanguages(wNull);
        assertEquals(5, result);
    }


    @Test
    void getMostCommonLanguage() {
        String result = Exec2.getMostCommonLanguage(w);
        assertEquals("nl", result);
    }
}