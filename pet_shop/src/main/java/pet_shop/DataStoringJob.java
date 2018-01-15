package pet_shop;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataStoringJob extends Thread {

    private static DataStoringJob ourInstance = new DataStoringJob();

    public static DataStoringJob getInstance() {
        return ourInstance;
    }

    static Logger log = Logger.getLogger(DataStoringJob.class.getName());

    public synchronized static void saveStorage(ArrayList<Animal> storage) {

        try {
            log.info("Saving storage...");
            FileWriter file = new FileWriter(CONSTANTS.PATH_TO_STORAGE);
            JSONObject highLevelObj = new JSONObject();
            JSONArray ar = new JSONArray();

            for (Animal a : storage) {
                JSONObject obj = new JSONObject();
                obj.put("character", a.getCharacter());
                obj.put("cost", a.getCost());
                obj.put("name", a.getName());
                obj.put("breed", a.getBreed());
                obj.put("class", a.getClass().toString().substring(6));
                ar.add(obj);
            }

            highLevelObj.put("items", ar);
            file.write(highLevelObj.toJSONString());
            file.close();

            log.info("Storage saved at " + new Date(System.currentTimeMillis()));
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.toString());
        }

    }

    @Override
    public void run() {
        try {
            while (true) {
                DataStoringJob.saveStorage(PetShopStorage.getInstance().getStorage());
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error("Error in saving the storage");
        }

    }

    private DataStoringJob() {
    }
}
