package pet_shop;

import org.apache.log4j.Logger;

public enum PrintingService {
    INSTANCE;

    static Logger log = Logger.getLogger(PrintingService.class.getName());


    public static void printBuy(Animal animal) {
        log.info("Animal " + animal.getName() + " was bought.");
    }

    public static void printSellSuccessfully(Animal animal) {
        log.info("Animal " + animal.getName() + " was sold successfully.");
    }

    public static void printSellFailed() {
        log.info("Sale was failed because required animal is not in the storage.");
    }
}
