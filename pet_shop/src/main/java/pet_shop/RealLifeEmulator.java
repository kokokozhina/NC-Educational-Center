package pet_shop;

import org.apache.log4j.Logger;

import java.util.ArrayList;

import static pet_shop.CONSTANTS.AVAILABLE_ANIMALS;
import static pet_shop.CONSTANTS.R;
import static pet_shop.CONSTANTS.FEATURES;
import static pet_shop.CONSTANTS.CHARACTERS;
import static pet_shop.CONSTANTS.AVAILABLE_BREEDS;

public class RealLifeEmulator extends Thread {

    private static RealLifeEmulator ourInstance = new RealLifeEmulator();

    public static RealLifeEmulator getInstance() {
        return ourInstance;
    }

    private RealLifeEmulator() {
    }

    static Logger log = Logger.getLogger(RealLifeEmulator.class.getName());

    public static Animal createAnimal() {
        String newClass = "pet_shop." +
                AVAILABLE_ANIMALS.values()[R.nextInt(AVAILABLE_ANIMALS.values().length)].toString();
        Animal a = null;
        try {
            a = (Animal) Class.forName(newClass).newInstance();
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return a;
    }

    private static String[] createFeatureToSell() {
        int c = R.nextInt(FEATURES.values().length);

        String param;
        switch (c) {
            case 0:
                param = AVAILABLE_BREEDS.values()[R.nextInt(AVAILABLE_BREEDS.values().length)].toString();
                break;
            case 1:
                param = AbstractAnimal.generateName();
                break;
            case 2:
                param = String.valueOf(R.nextInt(10000));
                break;
            case 3:
                param = CHARACTERS.values()[R.nextInt(CHARACTERS.values().length)].toString();
                break;
            default:
                param = null;
                log.error("Error in createFeatureToSell");
        }
        String ans[] = new String[]{
                FEATURES.values()[c].toString(),
                param
        };
        return ans;
    }

    @Override
    public void run() {

        while (true) {
            int code = R.nextInt(10);

            if (PetShopStorage.getInstance().getStorage().isEmpty()) {
                break;
            }

            synchronized (this){
                if (code == 4) {
                    BuySellService.buy(createAnimal());
                } else if (code == 6) {
                    BuySellService.sell(createFeatureToSell());
                } else if (code == 7) {
                    PetShopStorage.getInstance().runAway();
                }
            }

            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                log.error(ex.getMessage());
            }
        }

    }


}
