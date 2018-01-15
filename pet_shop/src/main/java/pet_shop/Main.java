package pet_shop;

import org.apache.log4j.Logger;

public class Main {

    static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        PetShopStorage.getInstance().loadFromFile();

        DataStoringJob.getInstance().setDaemon(true);
        DataStoringJob.getInstance().start();

        RealLifeEmulator.getInstance().start();

        try {
            RealLifeEmulator.getInstance().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.info("Error in joining the threads.");
        }

        log.info("End of the work.");
    }
}
