package pet_shop;

import java.io.File;
import java.util.Random;
import java.util.logging.Logger;

public class CONSTANTS {
    public static Random R = new Random();

    public enum CHARACTERS {
        LOYAL, PLAYFUL, SMART, INDEPENDENT, BRAVE, ENDURING
    }


    public enum DOG_BREEDS {
        ROTTWEILER, SHIBA_INU, AKITA_INU, LABRADOR, BEAGLE
    }


    public enum CAT_BREEDS {
        PERSIAN, SCOTTISH_FOLD, THAI, BENGAL
    }


    public enum LIZARD_BREEDS {
        IGUANA, CHAMELEON, AGAMA
    }


    public enum SPIDER_BREEDS {
        THERAPHOSIDAE, CAMEL, LYKOSIDAE
    }


    public enum AVAILABLE_ANIMALS {Dog, Cat, Spider, Lizard}

    public enum FEATURES {
        BREED, NAME, COST, CHARACTER
    }

    public enum AVAILABLE_BREEDS {
        ROTTWEILER, SHIBA_INU, AKITA_INU, LABRADOR, BEAGLE,
        PERSIAN, SCOTTISH_FOLD, THAI, BENGAL,
        IGUANA, CHAMELEON, AGAMA,
        THERAPHOSIDAE, CAMEL, LYKOSIDAE
    }

    public static final String PATH =
            new File(".").getAbsolutePath().toString();

    public static final String PATH_TO_STORAGE =
            PATH.substring(0, PATH.length() - 1)
            + "src\\main\\resources\\storage.json";
}
