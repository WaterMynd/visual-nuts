
import java.util.ArrayList;


public class World {

    private final ArrayList<Country> worldCountryList;

    public World(String file){
        worldCountryList = Exec2.readJsonFile(file);
    }

    public ArrayList<Country> getWorldCountryList() {
        return worldCountryList;
    }

}
