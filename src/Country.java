import java.util.ArrayList;

public class Country {

    private String name;

    private ArrayList<String> languages;

    public Country(String name, ArrayList<String> languages){
        this.name = name;
        this.languages = languages;
    }

    public int numberOfLanguages(){
        return this.languages.size();
    }

    public boolean isGerman(){
        return languages.contains("de");
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public String getName() {
        return name;
    }
}
