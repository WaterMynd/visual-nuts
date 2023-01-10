import static org.junit.jupiter.api.Assertions.*;

class Exec1Test {

    @org.junit.jupiter.api.Test
    void getTextForNormalNumber() {
        String result = Exec1.getTextForNumber(8);
        assertEquals("8", result);
    }

    @org.junit.jupiter.api.Test
    void getTextForVisualNumber() {
        String result = Exec1.getTextForNumber(3);
        assertEquals("Visual", result);
    }

    @org.junit.jupiter.api.Test
    void getTextForNutsNumber() {
        String result = Exec1.getTextForNumber(10);
        assertEquals("Nuts", result);
    }

    @org.junit.jupiter.api.Test
    void getTextForVisualNutsNumber() {
        String result = Exec1.getTextForNumber(30);
        assertEquals("Visual Nuts", result);
    }
}