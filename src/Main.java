
public class Main {


    public static void main(String[] args) {
        Exec1.writeNumbers(100);

        World w = new World(System.getProperty("user.dir") + "\\src\\Exec2.json");
        Exec2.printNumberOfCountries(w);
        Exec2.printGermanCountryWithMostLanguages(w);
        Exec2.printNumberOfLanguages(w);
        Exec2.printCountryWithMostLanguages(w);
        Exec2.printMostCommonLanguage(w);
    }

}
