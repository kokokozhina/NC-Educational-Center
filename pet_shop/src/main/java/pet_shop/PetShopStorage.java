package pet_shop;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static pet_shop.CONSTANTS.R;

public class PetShopStorage {

    private static PetShopStorage ourInstance = new PetShopStorage();

    private ArrayList<Animal> storage;

    static Logger log = Logger.getLogger(PetShopStorage.class.getName());

    public static PetShopStorage getInstance() {
        return ourInstance;
    }

    public ArrayList<Animal> getStorage() {
        return (new ArrayList<Animal>(storage));
    }

    public void addAnimal(Animal animal) {
        storage.add(animal);
    }

    public void deleteAnimal(int idx) {
        if (idx < 0 || idx >= storage.size()) {
            System.out.println("ERROR");
        } else {
            storage.remove(idx);
        }
    }

    public void runAway() {
        if (storage.size() > 0) {
            deleteAnimal(R.nextInt(storage.size()));
            log.info("One animal ran away.");
        } else {
            log.info("Storage is empty! Nothing could run away!");
        }
    }

    public void loadFromFile() {
        storage.clear();

        log.info("Loading storage from file...");

        JSONParser parser = new JSONParser();
        try {
            FileReader file = new FileReader(CONSTANTS.PATH_TO_STORAGE);
            Object obj = parser.parse(file);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray items = (JSONArray) jsonObject.get("items");
            Iterator<JSONObject> iterator = items.iterator();
            while (iterator.hasNext()) {
                JSONObject curAnimal = iterator.next();

                String name = (String) curAnimal.get("name");
                Integer cost = new Integer(curAnimal.get("cost").toString());
                String character = (String) curAnimal.get("character");
                String breed = (String) curAnimal.get("breed");
                String instanceOfClass = (String) curAnimal.get("class");

                AbstractAnimal a = (AbstractAnimal) (Class.forName(instanceOfClass)).newInstance();
                a.cost = cost;
                a.character = character;
                a.breed = breed;
                a.name = name;

                addAnimal(a);
            }

            file.close();
            log.info("Storage loaded successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    private PetShopStorage() {
        storage = new ArrayList<Animal>();
    }
}
