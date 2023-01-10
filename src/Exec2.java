
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/*
Image you have a set of data in JSON, describing official languages spoken by countries, as
such:
Write a function in Java that:
- returns the number of countries in the world
- finds the country with the most official languages, where they officially speak German (de).
- that counts all the official languages spoken in the listed countries.
- to find the country with the highest number of official languages.
- to find the most common official language(s), of all countries.
 */

/**
 * Class containing the methods of exercise 2
 */
public class Exec2 {


    /**
     * @param file - path of the json file
     * @return an ArrayList of countries
     */
    public static ArrayList<Country> readJsonFile(String file){
        ArrayList<Country> worldCountryList = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(file))
        {
            Object obj = jsonParser.parse(reader);

            JSONArray countryList = (JSONArray) obj;

            for( Object jsonCountry : countryList){
                Country country = parseCountryObject((JSONObject) jsonCountry);
                worldCountryList.add(country);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return worldCountryList;
    }


    /**
     * @param country - json corresponding to a country
     * @return an instance of Country
     */
    private static Country parseCountryObject(JSONObject country)
    {
        String name = (String) country.get("country");

        JSONArray  languages = (JSONArray) country.get("languages");
        ArrayList<String> languagesList = new ArrayList<>();
        for (Object language : languages) {
            languagesList.add((String) language);
        }

        return new Country(name, languagesList);
    }


    /**
     * @param w - world to be used
     * @return the number of countries
     */
    public static int getNumberOfCountries(World w){
        ArrayList<Country> worldCountryList = w.getWorldCountryList();
        return worldCountryList.size();
    }


    /**
     * @param w - world to be used
     * @return the country with most languages
     */
    public static Country getCountryWithMostLanguages(World w){
        ArrayList<Country> worldCountryList = w.getWorldCountryList();
        Country mostLanguages = null;

        for(Country country : worldCountryList){
            if (mostLanguages == null){
                mostLanguages = country;
            } else {
                if (country.numberOfLanguages() > mostLanguages.numberOfLanguages()){
                    mostLanguages = country;
                }
            }
        }

        return mostLanguages;
    }


    /**
     * @param w - world to be used
     * @return the german country with most languages
     */
    public static Country getGermanCountryWithMostLanguages(World w){
        ArrayList<Country> worldCountryList = w.getWorldCountryList();
        Country mostLanguages = null;

        for(Country country : worldCountryList){
            if(country.isGerman()) {
                if (mostLanguages == null) {
                    mostLanguages = country;
                } else {
                    if (country.numberOfLanguages() > mostLanguages.numberOfLanguages()) {
                        mostLanguages = country;
                    }
                }
            }
        }

        return mostLanguages;
    }


    /**
     * @param w - world to be used
     * @return the number of languages
     */
    public static int getNumberOfLanguages(World w){
        ArrayList<Country> worldCountryList = w.getWorldCountryList();
        ArrayList<String> allLanguages = new ArrayList<>();

        for(Country country : worldCountryList){
            ArrayList<String> languages = country.getLanguages();
            for (String l: languages) {
                if (!allLanguages.contains(l)){
                    allLanguages.add(l);
                }
            }
        }

        return allLanguages.size();
    }


    /**
     * @param w - world to be used
     * @return the most common language
     */
    public static String getMostCommonLanguage(World w){
        ArrayList<Country> worldCountryList = w.getWorldCountryList();
        HashMap<String, Integer> languageList = new HashMap<>();

        for(Country country : worldCountryList){
            ArrayList<String> languages = country.getLanguages();
            for (String l: languages) {
                if (!languageList.containsKey(l)){
                    languageList.put(l, 1);
                } else {
                    languageList.put(l, languageList.get(l) + 1);
                }
            }
        }

        return Collections.max(languageList.entrySet(), HashMap.Entry.comparingByValue()).getKey();
    }


    /**
     * Prints the number of countries
     *
     * @param w - world to be used
     */
    public static void printNumberOfCountries(World w){
        System.out.println("Number of countries: " + getNumberOfCountries(w));
    }


    /**
     * Prints the country name with most languages
     *
     * @param w - world to be used
     */
    public static void printCountryWithMostLanguages(World w){
        Country mostLanguages = getCountryWithMostLanguages(w);

        if(mostLanguages != null){
            System.out.println("Country most languages: " + mostLanguages.getName());
        } else {
            System.out.println("There are no countries");
        }
    }


    /**
     * Prints the german country with most languages
     *
     * @param w - world to be used
     */
    public static void printGermanCountryWithMostLanguages(World w){
        Country mostLanguages = getGermanCountryWithMostLanguages(w);

        if(mostLanguages != null){
            System.out.println("German country most languages: " + mostLanguages.getName());
        } else {
            System.out.println("There are no countries with de language ");
        }

    }


    /**
     * Prints the number of languages
     *
     * @param w - world to be used
     */
    public static void printNumberOfLanguages(World w){
        System.out.println("Number of languages: " + getNumberOfLanguages(w));
    }


    /**
     * Prints the most common language
     *
     * @param w - world to be used
     */
    public static void printMostCommonLanguage(World w){
        System.out.println("Most common language: " + getMostCommonLanguage(w));
    }

}
